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

import com.tcdng.unify.core.criterion.FilterConditionType;
import com.tcdng.unify.core.util.xml.adapter.FilterConditionTypeXmlAdapter;

/**
 * Filter restriction configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FilterRestrictionConfig {

    private FilterConditionType type;

    private String field;

    private String paramA;

    private String paramB;

    private List<FilterRestrictionConfig> restrictionList;

    public FilterConditionType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(FilterConditionTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setType(FilterConditionType type) {
        this.type = type;
    }

    public String getField() {
        return field;
    }

    @XmlAttribute(required = true)
    public void setField(String field) {
        this.field = field;
    }

    public String getParamA() {
        return paramA;
    }

    @XmlAttribute(required = true)
    public void setParamA(String paramA) {
        this.paramA = paramA;
    }

    public String getParamB() {
        return paramB;
    }

    @XmlAttribute(required = true)
    public void setParamB(String paramB) {
        this.paramB = paramB;
    }

    public List<FilterRestrictionConfig> getRestrictionList() {
        return restrictionList;
    }

    @XmlElement(name = "restriction")
    public void setRestrictionList(List<FilterRestrictionConfig> restrictionList) {
        this.restrictionList = restrictionList;
    }

    @Override
    public String toString() {
        return "FilterRestrictionConfig [type=" + type + ", field=" + field + ", paramA=" + paramA + ", paramB="
                + paramB + ", restrictionList=" + restrictionList + "]";
    }

}
