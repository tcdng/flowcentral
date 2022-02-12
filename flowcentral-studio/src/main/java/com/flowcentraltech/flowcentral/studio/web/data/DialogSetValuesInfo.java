/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.data;

import com.flowcentraltech.flowcentral.application.web.widgets.SetValueEntries;

/**
 * Dialog set values info.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DialogSetValuesInfo {

    private String title;

    private SetValueEntries entries;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SetValueEntries getEntries() {
        return entries;
    }

    public void setEntries(SetValueEntries entries) {
        this.entries = entries;
    }

}
