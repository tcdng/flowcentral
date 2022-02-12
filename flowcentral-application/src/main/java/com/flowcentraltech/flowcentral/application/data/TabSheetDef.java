/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.configuration.constants.RendererType;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Tab sheet definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TabSheetDef {

    private List<TabDef> tabDefList;

    private FormContext formContext;
    
    private long version;

    private TabSheetDef(FormContext formContext, List<TabDef> tabDefList, long version) {
        this.formContext = formContext;
        this.tabDefList = DataUtils.unmodifiableList(tabDefList);
        this.version = version;
    }

    public FormContext getFormContext() {
        return formContext;
    }

    public boolean isWithFormContext() {
        return formContext != null;
    }

    public List<TabDef> getTabDefList() {
        return tabDefList;
    }

    public TabDef getTabDef(int tabIndex) {
        return tabDefList.get(tabIndex);
    }

    public long getVersion() {
        return version;
    }

    public static Builder newBuilder(FormContext formContext, long version) {
        return new Builder(formContext, version);
    }

    public static class Builder {

        private List<TabDef> tabDefList;

        private FormContext formContext;
        
        private long version;

        public Builder(FormContext formContext, long version) {
            this.version = version;
            this.formContext = formContext;
            tabDefList = new ArrayList<TabDef>();
        }

        public Builder addTabDef(String tabName, String tabLabel, String tabRenderer) {
            return addTabDef(tabName, tabLabel, tabRenderer, RendererType.SIMPLE_WIDGET);
        }

        public Builder addTabDef(String tabName, String tabLabel, String tabRenderer, RendererType rendererType) {
            tabDefList.add(new TabDef(tabName, tabLabel, tabRenderer, rendererType));
            return this;
        }

        public TabSheetDef build() {
            return new TabSheetDef(formContext, tabDefList, version);
        }
    }
}
