/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.UIActionType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.UIActionTypeXmlAdapter;

/**
 * Form action configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormActionConfig extends BaseNameConfig {

    private UIActionType type;

    private String policy;

    private String symbol;

    private String styleClass;

    private int orderIndex;

    private boolean showOnCreate;

    private boolean showOnMaintain;

    private boolean validateForm;

    public UIActionType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(UIActionTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setType(UIActionType type) {
        this.type = type;
    }

    public String getPolicy() {
        return policy;
    }

    @XmlAttribute(required = true)
    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getSymbol() {
        return symbol;
    }

    @XmlAttribute
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStyleClass() {
        return styleClass;
    }

    @XmlAttribute
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    @XmlAttribute
    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public boolean isShowOnCreate() {
        return showOnCreate;
    }

    @XmlAttribute
    public void setShowOnCreate(boolean showOnCreate) {
        this.showOnCreate = showOnCreate;
    }

    public boolean isShowOnMaintain() {
        return showOnMaintain;
    }

    @XmlAttribute
    public void setShowOnMaintain(boolean showOnMaintain) {
        this.showOnMaintain = showOnMaintain;
    }

    public boolean isValidateForm() {
        return validateForm;
    }

    @XmlAttribute
    public void setValidateForm(boolean validateForm) {
        this.validateForm = validateForm;
    }
}
