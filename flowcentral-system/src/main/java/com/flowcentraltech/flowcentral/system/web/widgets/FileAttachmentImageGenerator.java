/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.web.widgets;

import com.tcdng.unify.core.resource.ImageGenerator;

/**
 * File attachment image generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface FileAttachmentImageGenerator extends ImageGenerator {

    void init(String category, String entityName, String attachmentName);

    void prepareGenerationFor(Long entityInstId);
}
