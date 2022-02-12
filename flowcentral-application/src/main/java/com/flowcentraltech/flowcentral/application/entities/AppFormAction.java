/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.flowcentraltech.flowcentral.configuration.constants.UIActionType;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Application form action entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_FORMACTION", uniqueConstraints = { @UniqueConstraint({ "appFormId", "name" }) })
public class AppFormAction extends BaseConfigNamedEntity {

    @ForeignKey(AppForm.class)
    private Long appFormId;

    @ForeignKey(name = "FORMACTION_TY")
    private UIActionType type;

    @Column(name = "FORMACTION_LABEL", length = 96)
    private String label;

    @Column(name = "FORMACTION_SYMBOL", length = 64, nullable = true)
    private String symbol;

    @Column(length = 64, nullable = true)
    private String styleClass;

    @Column(name = "ACTION_POLICY", length = 64)
    private String policy;

    @Column
    private int orderIndex;

    @Column
    private boolean showOnCreate;

    @Column
    private boolean showOnMaintain;

    @Column
    private boolean validateForm;

    @ListOnly(key = "type", property = "description")
    private String typeDesc;

    public Long getAppFormId() {
        return appFormId;
    }

    public void setAppFormId(Long appFormId) {
        this.appFormId = appFormId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public UIActionType getType() {
        return type;
    }

    public void setType(UIActionType type) {
        this.type = type;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public boolean isShowOnCreate() {
        return showOnCreate;
    }

    public void setShowOnCreate(boolean showOnCreate) {
        this.showOnCreate = showOnCreate;
    }

    public boolean isShowOnMaintain() {
        return showOnMaintain;
    }

    public void setShowOnMaintain(boolean showOnMaintain) {
        this.showOnMaintain = showOnMaintain;
    }

    public boolean isValidateForm() {
        return validateForm;
    }

    public void setValidateForm(boolean validateForm) {
        this.validateForm = validateForm;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

}
