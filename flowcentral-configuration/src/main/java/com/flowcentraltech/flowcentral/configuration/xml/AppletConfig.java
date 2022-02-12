/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.AppletType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.AppletTypeXmlAdapter;

/**
 * Applet configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppletConfig extends BaseNameConfig {

    private AppletType type;

    private String entity;

    private String icon;

    private String routeToApplet;
    
    private String path;

    private String baseField;

    private String assignField;

    private String assignDescField;

    private int displayIndex;

    private boolean menuAccess;

    private List<AppletPropConfig> propList;

    private List<FilterConfig> filterList;

    public AppletType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(AppletTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setType(AppletType type) {
        this.type = type;
    }

    public String getEntity() {
        return entity;
    }

    @XmlAttribute
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getIcon() {
        return icon;
    }

    @XmlAttribute
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRouteToApplet() {
        return routeToApplet;
    }

    @XmlAttribute
    public void setRouteToApplet(String routeToApplet) {
        this.routeToApplet = routeToApplet;
    }

    public String getPath() {
        return path;
    }

    @XmlAttribute
    public void setPath(String path) {
        this.path = path;
    }

    public String getBaseField() {
        return baseField;
    }

    @XmlAttribute
    public void setBaseField(String baseField) {
        this.baseField = baseField;
    }

    public String getAssignField() {
        return assignField;
    }

    @XmlAttribute
    public void setAssignField(String assignField) {
        this.assignField = assignField;
    }

    public String getAssignDescField() {
        return assignDescField;
    }

    @XmlAttribute
    public void setAssignDescField(String assignDescField) {
        this.assignDescField = assignDescField;
    }

    public boolean isMenuAccess() {
        return menuAccess;
    }

    @XmlAttribute(required = true)
    public void setMenuAccess(boolean menuAccess) {
        this.menuAccess = menuAccess;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    @XmlAttribute
    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public List<AppletPropConfig> getPropList() {
        return propList;
    }

    @XmlElement(name = "property", required = true)
    public void setPropList(List<AppletPropConfig> propList) {
        this.propList = propList;
    }

    public List<FilterConfig> getFilterList() {
        return filterList;
    }

    @XmlElement(name = "filter", required = true)
    public void setFilterList(List<FilterConfig> filterList) {
        this.filterList = filterList;
    }

}
