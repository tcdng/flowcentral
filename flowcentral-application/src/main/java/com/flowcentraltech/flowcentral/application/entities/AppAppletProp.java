/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Application applet property entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_APPLETPROP", uniqueConstraints = { @UniqueConstraint({ "appAppletId", "name" }) })
public class AppAppletProp extends BaseConfigEntity {

    @ForeignKey(AppApplet.class)
    private Long appAppletId;

    @Column(name = "APPLETPROP_NM", length = 96)
    private String name;

    @Column(name = "APPLETPROP_VAL", length = 1024, nullable = true)
    private String value;

    public AppAppletProp(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public AppAppletProp() {

    }

    @Override
    public String getDescription() {
        return name;
    }

    public Long getAppAppletId() {
        return appAppletId;
    }

    public void setAppAppletId(Long appAppletId) {
        this.appAppletId = appAppletId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
