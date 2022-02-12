/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.generators;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Singleton;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Convenient abstract base class for static artifact generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Singleton(false)
public abstract class AbstractStaticArtifactGenerator extends AbstractUnifyComponent
        implements StaticArtifactGenerator {

    private String zipDir;

    public AbstractStaticArtifactGenerator(String zipDir) {
        this.zipDir = zipDir;
    }

    public AbstractStaticArtifactGenerator() {

    }

    @Override
    public final void generate(ExtensionModuleStaticFileBuilderContext ctx, String entityName, ZipOutputStream zos)
            throws UnifyException {
        if (!StringUtils.isBlank(zipDir)) {
            if (zipDir.indexOf('{') >= 0) {
                String packageFolder = ctx.getBasePackage().replaceAll("\\.", "/");
                String lowerEntityName = entityName.toLowerCase();
                zipDir = MessageFormat.format(zipDir, packageFolder, lowerEntityName);
            }
            
            if (ctx.addZipDir(zipDir)) {
                try {
                    zos.putNextEntry(new ZipEntry(zipDir));
                } catch (IOException e) {
                    throwOperationErrorException(e);
                }
            }
        }

        doGenerate(ctx, entityName, zos);
    }

    protected abstract void doGenerate(ExtensionModuleStaticFileBuilderContext ctx, String name, ZipOutputStream zos)
            throws UnifyException;

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

    protected void openEntry(String filename, ZipOutputStream zos) throws UnifyException {
        try {
            zos.putNextEntry(new ZipEntry(zipDir + filename));
        } catch (IOException e) {
            throwOperationErrorException(e);
        }
    }
    
    protected void closeEntry(ZipOutputStream zos) throws UnifyException {
        try {
            zos.flush();
            zos.closeEntry();
        } catch (IOException e) {
            throwOperationErrorException(e);
        }
    }
    
    protected String getDescriptionKey(String applicationName, String category, String description) {
        return (applicationName + "." + category + "." + description.replaceAll("[^a-zA-Z0-9]+", "").trim()).toLowerCase();
    }
}
