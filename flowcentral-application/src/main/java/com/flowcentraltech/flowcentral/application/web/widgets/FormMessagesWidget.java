/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.List;

import com.flowcentraltech.flowcentral.common.data.FormMessage;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.web.ui.widget.AbstractControl;

/**
 * Form messages widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-formmessages")
public class FormMessagesWidget extends AbstractControl {

    @SuppressWarnings("unchecked")
    public List<FormMessage> getMessages() throws UnifyException {
        return (List<FormMessage>) getValue(List.class);
    }
}
