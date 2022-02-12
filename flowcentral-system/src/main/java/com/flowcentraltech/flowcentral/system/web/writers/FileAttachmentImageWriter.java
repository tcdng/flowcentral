/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.web.writers;

import com.flowcentraltech.flowcentral.system.web.widgets.FileAttachmentImageWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * File attachment image writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(FileAttachmentImageWidget.class)
@Component("fileattachmentimage-writer")
public class FileAttachmentImageWriter extends AbstractControlWriter {

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        FileAttachmentImageWidget fileAttachmentImageWidget = (FileAttachmentImageWidget) widget;
        writer.writeStructureAndContent(fileAttachmentImageWidget.getImageControl());
    }

}
