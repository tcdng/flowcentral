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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Workflow configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@XmlRootElement(name = "workflow")
public class WfConfig extends BaseNameConfig {

    private WfStepsConfig stepsConfig;

    private String entity;

    private String descFormat;

    private List<FilterConfig> filterList;

    public WfStepsConfig getStepsConfig() {
        return stepsConfig;
    }

    @XmlElement(name = "steps")
    public void setStepsConfig(WfStepsConfig stepsConfig) {
        this.stepsConfig = stepsConfig;
    }

    public String getEntity() {
        return entity;
    }

    @XmlAttribute(required = true)
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getDescFormat() {
        return descFormat;
    }

    @XmlAttribute
    public void setDescFormat(String descFormat) {
        this.descFormat = descFormat;
    }

    public List<FilterConfig> getFilterList() {
        return filterList;
    }

    @XmlElement(name = "filter", required = true)
    public void setFilterList(List<FilterConfig> filterList) {
        this.filterList = filterList;
    }

}
