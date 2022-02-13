/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import java.util.List;

import com.flowcentraltech.flowcentral.configuration.constants.AppletType;
import com.tcdng.unify.core.annotation.ChildList;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application applet entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_APPLET")
public class AppApplet extends BaseApplicationEntity {

    @ForeignKey(name = "APPLET_TY")
    private AppletType type;

    @Column(length = 128, nullable = true)
    private String entity;

    @Column(length = 96)
    private String label;

    @Column(length = 96, nullable = true)
    private String icon;

    @Column(length = 128, nullable = true)
    private String routeToApplet;

    @Column(length = 96, nullable = true)
    private String path;

    @Column(length = 64, nullable = true)
    private String baseField;

    @Column(length = 64, nullable = true)
    private String assignField;

    @Column(length = 64, nullable = true)
    private String assignDescField;

    @Column
    private boolean menuAccess;

    @Column
    private int displayIndex;

    @ListOnly(key = "type", property = "description")
    private String typeDesc;

    @ChildList
    private List<AppAppletProp> propList;

    @ChildList
    private List<AppAppletFilter> filterList;

    public AppletType getType() {
        return type;
    }

    public void setType(AppletType type) {
        this.type = type;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRouteToApplet() {
        return routeToApplet;
    }

    public void setRouteToApplet(String routeToApplet) {
        this.routeToApplet = routeToApplet;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBaseField() {
        return baseField;
    }

    public void setBaseField(String baseField) {
        this.baseField = baseField;
    }

    public String getAssignField() {
        return assignField;
    }

    public void setAssignField(String assignField) {
        this.assignField = assignField;
    }

    public String getAssignDescField() {
        return assignDescField;
    }

    public void setAssignDescField(String assignDescField) {
        this.assignDescField = assignDescField;
    }

    public boolean isMenuAccess() {
        return menuAccess;
    }

    public void setMenuAccess(boolean menuAccess) {
        this.menuAccess = menuAccess;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public List<AppAppletProp> getPropList() {
        return propList;
    }

    public void setPropList(List<AppAppletProp> propList) {
        this.propList = propList;
    }

    public List<AppAppletFilter> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<AppAppletFilter> filterList) {
        this.filterList = filterList;
    }

}