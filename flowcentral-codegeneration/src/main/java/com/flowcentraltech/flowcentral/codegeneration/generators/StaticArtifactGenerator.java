/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.generators;

import java.util.zip.ZipOutputStream;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Static artifact builder.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface StaticArtifactGenerator extends UnifyComponent {

    void generate(ExtensionModuleStaticFileBuilderContext ctx, String entityName, ZipOutputStream zos) throws UnifyException;
}
