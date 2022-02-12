/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application form related list entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_FORMRELLIST")
public class AppFormRelatedList extends BaseConfigNamedEntity {

    @ForeignKey(AppForm.class)
    private Long appFormId;

    @Column(length = 64)
    private String label;

    @Column(name = "APPLET_NM", length = 128)
    private String applet;

    @Column(length = 64, nullable = true)
    private String editAction;

    public Long getAppFormId() {
        return appFormId;
    }

    public void setAppFormId(Long appFormId) {
        this.appFormId = appFormId;
    }

    public String getApplet() {
        return applet;
    }

    public void setApplet(String applet) {
        this.applet = applet;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getEditAction() {
        return editAction;
    }

    public void setEditAction(String editAction) {
        this.editAction = editAction;
    }

}
