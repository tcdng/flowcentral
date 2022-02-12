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
import java.util.Map;
import java.util.zip.ZipOutputStream;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;

/**
 * Extension module messages generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("extension-module-messages-generator")
public class ExtensionModuleMessagesGenerator extends AbstractStaticArtifactGenerator {

    public ExtensionModuleMessagesGenerator() {
        super("src/main/resources/{0}/resources/");
    }

    @Override
    protected void doGenerate(ExtensionModuleStaticFileBuilderContext ctx, String moduleName, ZipOutputStream zos)
            throws UnifyException {
        final String filename = moduleName.toLowerCase() + "-extension-messages.properties";
        openEntry(filename, zos);
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(zos));
            for (StaticApplicationConfig staticApplicationConfig: ctx.getStaticApplicationConfigs()) {
                bw.write("# ");
                bw.write(staticApplicationConfig.getApplicationDesc());
                bw.newLine();
                for (StaticMessageCategoryType type : StaticMessageCategoryType.values()) {
                    bw.write("# ");
                    bw.write(type.comment());
                    bw.newLine();
                    for (Map.Entry<String, String> entry : staticApplicationConfig.getMessages(type).entrySet()) {
                        if (!entry.getKey().startsWith("_ctxGap")) {
                            bw.write(entry.getKey());
                            bw.write("=");
                            bw.write(String.valueOf(entry.getValue()).replaceAll("\n", "\\\\n\\\\\n"));
                        }

                        bw.newLine();
                    }

                    bw.newLine();
                }
            }

            bw.flush();
        } catch (IOException e) {
            throwOperationErrorException(e);
        }

        closeEntry(zos);
    }
}
