/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.List;

import com.flowcentraltech.flowcentral.application.data.FormAnnotationDef;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.web.ui.widget.AbstractControl;

/**
 * Form annotation widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-formannotation")
public class FormAnnotationWidget extends AbstractControl {

    @SuppressWarnings("unchecked")
    public List<FormAnnotationDef> getFormAnnotationDef() throws UnifyException {
        return (List<FormAnnotationDef>) getValue(List.class);
    }
}
