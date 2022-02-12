/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.generators;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.ZipOutputStream;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Extension module static settings Java class generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("extension-module-static-settings-java-generator")
public class ExtensionModuleStaticSettingsJavaGenerator extends AbstractStaticArtifactGenerator {

    public ExtensionModuleStaticSettingsJavaGenerator() {
        super("src/main/java/{0}/{1}/extension/constants/");
    }

    @Override
    protected void doGenerate(ExtensionModuleStaticFileBuilderContext ctx, String moduleName, ZipOutputStream zos)
            throws UnifyException {
        final String capModuleName = StringUtils.capitalizeFirstLetter(moduleName);
        final String lowerModuleName = moduleName.toLowerCase();
        final String className = capModuleName + "ModuleStaticSettings";
        final String filename = className + ".java";
        final String packageName = ctx.getBasePackage() + '.' + lowerModuleName + ".extension.constants";

        openEntry(filename, zos);

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(zos));
        pw.print("package ");
        pw.print(packageName);
        pw.println(';');
        pw.println();

        pw.println(
                "import com.flowcentraltech.flowcentral.configuration.constants.AbstractExtensionModuleStaticSettings;");
        pw.println("import com.tcdng.unify.core.annotation.AutoDetect;");
        pw.println();
        pw.println();

        pw.println("@AutoDetect");
        pw.print("public class ");
        pw.print(className);
        pw.println(" extends AbstractExtensionModuleStaticSettings {");
        pw.println();
        pw.print("\tpublic ");
        pw.print(className);
        pw.println("() {");

        pw.print("\t\tsuper(null, \"config/");
        pw.print(lowerModuleName);
        pw.println("-extension-module.xml\",");
        pw.print("\t\t\t\"");
        pw.print(ctx.getBasePackage());
        pw.print(".resources.");
        pw.print(lowerModuleName);
        pw.print("-extension-messages\");");

        pw.println("\t}");

        pw.println("}");
        pw.println();

        pw.flush();

        closeEntry(zos);
    }
}
