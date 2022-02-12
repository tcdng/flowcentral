/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.web.widgets;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplAttribute;
import com.tcdng.unify.core.annotation.UplAttributes;
import com.tcdng.unify.web.ui.widget.AbstractMultiControl;
import com.tcdng.unify.web.ui.widget.Control;

/**
 * File attachment image.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-fileattachmentimage")
@UplAttributes({ @UplAttribute(name = "category", type = String.class, mandatory = true),
        @UplAttribute(name = "entityName", type = String.class, mandatory = true),
        @UplAttribute(name = "attachmentName", type = String.class, mandatory = true) })
public class FileAttachmentImageWidget extends AbstractMultiControl {

    @Configurable
    private FileAttachmentImageGenerator imageGenerator;

    private Control imageControl;

    public void setImageGenerator(FileAttachmentImageGenerator imageGenerator) {
        this.imageGenerator = imageGenerator;
    }

    public Control getImageControl() {
        return imageControl;
    }

    public FileAttachmentImageGenerator getImageGenerator() throws UnifyException {
        Long entityInstId = getValue(Long.class);
        imageGenerator.prepareGenerationFor(entityInstId);
        return imageGenerator;
    }

    @Override
    protected void doOnPageConstruct() throws UnifyException {
        imageGenerator.init(getUplAttribute(String.class, "category"), getUplAttribute(String.class, "entityName"),
                getUplAttribute(String.class, "attachmentName"));
        StringBuilder sb = new StringBuilder();
        sb.append("!ui-image src:$t{images/blank.png} binding:imageGenerator");
        appendUplAttribute(sb, "styleClass");
        appendUplAttribute(sb, "style");
        imageControl = (Control) addInternalChildWidget(sb.toString());
    }

}
