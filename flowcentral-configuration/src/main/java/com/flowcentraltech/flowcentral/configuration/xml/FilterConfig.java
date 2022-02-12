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

/**
 * Filter configuration
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FilterConfig {

    private String name;

    private String description;

    private String preferredForm;
    
    private boolean quickFilter;

    private List<FilterRestrictionConfig> restrictionList;

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @XmlAttribute
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreferredForm() {
        return preferredForm;
    }

    @XmlAttribute
    public void setPreferredForm(String preferredForm) {
        this.preferredForm = preferredForm;
    }

    public boolean isQuickFilter() {
        return quickFilter;
    }

    @XmlAttribute
    public void setQuickFilter(boolean quickFilter) {
        this.quickFilter = quickFilter;
    }

    public List<FilterRestrictionConfig> getRestrictionList() {
        return restrictionList;
    }

    @XmlElement(name = "restriction", required = true)
    public void setRestrictionList(List<FilterRestrictionConfig> restrictionList) {
        this.restrictionList = restrictionList;
    }

    @Override
    public String toString() {
        return "FilterConfig [name=" + name + ", description=" + description + ", quickFilter=" + quickFilter
                + ", restrictionList=" + restrictionList + "]";
    }
}
