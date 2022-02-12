/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.tcdng.unify.core.constant.RequirementType;
import com.tcdng.unify.core.util.xml.adapter.RequirementTypeXmlAdapter;

/**
 * Workflow user action configuration.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class WfUserActionConfig extends BaseNameConfig {

    private String nextStepName;

    private RequirementType commentRequirement;

    private int orderIndex;

    private boolean validatePage;
    
    private boolean forwarderPreferred;
    
    public WfUserActionConfig() {
        this.commentRequirement = RequirementType.NONE;
        this.validatePage = Boolean.FALSE;
    }

    public String getNextStepName() {
        return nextStepName;
    }

    @XmlAttribute(name = "nextStep", required = true)
    public void setNextStepName(String nextStepName) {
        this.nextStepName = nextStepName;
    }

    public RequirementType getCommentRequirement() {
        return commentRequirement;
    }

    @XmlJavaTypeAdapter(RequirementTypeXmlAdapter.class)
    @XmlAttribute(name = "commentRequirement")
    public void setCommentRequirement(RequirementType commentRequirement) {
        this.commentRequirement = commentRequirement;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    @XmlAttribute
    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public boolean isValidatePage() {
        return validatePage;
    }

    @XmlAttribute(name = "validatePage")
    public void setValidatePage(boolean validatePage) {
        this.validatePage = validatePage;
    }

    public boolean isForwarderPreferred() {
        return forwarderPreferred;
    }

    @XmlAttribute
    public void setForwarderPreferred(boolean forwarderPreferred) {
        this.forwarderPreferred = forwarderPreferred;
    }
}
