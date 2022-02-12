/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import com.flowcentraltech.flowcentral.configuration.constants.RendererType;

/**
 * Tab definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TabDef {

    private String tabName;

    private String tabLabel;

    private String tabRenderer;

    private RendererType rendererType;

    private boolean errors;

    public TabDef(String tabName, String tabLabel, String tabRenderer, RendererType rendererType) {
        this.tabName = tabName;
        this.tabLabel = tabLabel;
        this.tabRenderer = tabRenderer;
        this.rendererType = rendererType;
    }

    public String getTabName() {
        return tabName;
    }

    public String getTabLabel() {
        return tabLabel;
    }

    public void setTabLabel(String tabLabel) {
        this.tabLabel = tabLabel;
    }

    public String getTabRenderer() {
        return tabRenderer;
    }

    public RendererType getRendererType() {
        return rendererType;
    }

    public boolean isErrors() {
        return errors;
    }

    public void setErrors(boolean errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "TabDef [tabName=" + tabName + ", tabLabel=" + tabLabel + ", tabRenderer=" + tabRenderer
                + ", rendererType=" + rendererType + ", errors=" + errors + "]";
    }
}
