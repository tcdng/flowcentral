/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.writers;

import com.flowcentraltech.flowcentral.application.web.widgets.FormListing;
import com.flowcentraltech.flowcentral.application.web.widgets.FormListingWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractContainerWriter;

/**
 * Form listing writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(FormListingWidget.class)
@Component("fc-formlisting-writer")
public class FormListingWriter extends AbstractContainerWriter {

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        FormListingWidget formListingWidget = (FormListingWidget) widget;
        writer.write("<div");
        writeTagAttributes(writer, formListingWidget);
        writer.write(">");

        FormListing formListing = formListingWidget.getFormListing();
        FormListingGenerator generator = (FormListingGenerator) getComponent(formListing.getListingGenerator());
        generator.generate(formListing.getFormValueStore(), writer);
        writer.write("</div>");
    }
}
