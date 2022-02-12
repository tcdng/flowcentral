/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.generators;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.zip.ZipOutputStream;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.database.dynamic.DynamicEntityInfo;
import com.tcdng.unify.core.util.DynamicEntityUtils;
import com.tcdng.unify.core.util.TypeInfo;

/**
 * Extension module entities Java class generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("extension-module-entities-java-generator")
public class ExtensionModuleEntitiesJavaGenerator extends AbstractStaticArtifactGenerator {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    public ExtensionModuleEntitiesJavaGenerator() {
        super("src/main/java/{0}/{1}/extension/entities/");
    }

    public final void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    @Override
    protected void doGenerate(ExtensionModuleStaticFileBuilderContext ctx, String moduleName, ZipOutputStream zos)
            throws UnifyException {
        for (DynamicEntityInfo dynamicEntityInfo : applicationModuleService
                .generateDynamicEntityInfos(ctx.getEntityList(), ctx.getBasePackage())) {
            TypeInfo typeInfo = new TypeInfo(dynamicEntityInfo.getClassName());
            final String filename = typeInfo.getSimpleName() + ".java";
            openEntry(filename, zos);
            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(zos));
                String src = DynamicEntityUtils.generateEntityJavaClassSource(dynamicEntityInfo);
                bw.write(src);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                throwOperationErrorException(e);
            }
            closeEntry(zos);
        }

        closeEntry(zos);
    }
}
