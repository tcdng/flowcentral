/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Workflow routing configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfRoutingConfig extends BaseNameConfig {

    private String nextStepName;

    private String condition;

    public String getNextStepName() {
        return nextStepName;
    }

    @XmlAttribute(name = "nextStep", required = true)
    public void setNextStepName(String nextStepName) {
        this.nextStepName = nextStepName;
    }

    public String getCondition() {
        return condition;
    }

    @XmlAttribute(required = true)
    public void setCondition(String condition) {
        this.condition = condition;
    }

}
