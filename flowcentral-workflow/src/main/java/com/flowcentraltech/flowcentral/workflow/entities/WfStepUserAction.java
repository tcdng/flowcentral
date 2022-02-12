/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseNamedEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;
import com.tcdng.unify.core.constant.RequirementType;

/**
 * Workflow step user action entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_WORKSTEPUSERACTION", uniqueConstraints = { @UniqueConstraint({ "wfStepId", "name" }),
        @UniqueConstraint({ "wfStepId", "description" }), @UniqueConstraint({ "wfStepId", "label" }) })
public class WfStepUserAction extends BaseNamedEntity {

    @ForeignKey(WfStep.class)
    private Long wfStepId;

    @ForeignKey
    private RequirementType commentRequirement;

    @Column(name = "USERACTION_LABEL", length = 96)
    private String label;

    @Column(name = "USERACTION_SYMBOL", length = 64, nullable = true)
    private String symbol;

    @Column(length = 64, nullable = true)
    private String styleClass;

    @Column(name = "NEXT_STEP_NM", length = 64)
    private String nextStepName;

    @Column
    private int orderIndex;

    @Column
    private boolean validatePage;

    @Column
    private boolean forwarderPreferred;
    
    @ListOnly(key = "wfStepId", property = "description")
    private String wfStepDesc;

    @ListOnly(key = "commentRequirement", property = "description")
    private String commentRequirementDesc;

    public Long getWfStepId() {
        return wfStepId;
    }

    public void setWfStepId(Long wfStepId) {
        this.wfStepId = wfStepId;
    }

    public RequirementType getCommentRequirement() {
        return commentRequirement;
    }

    public void setCommentRequirement(RequirementType commentRequirement) {
        this.commentRequirement = commentRequirement;
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

    public String getNextStepName() {
        return nextStepName;
    }

    public void setNextStepName(String nextStepName) {
        this.nextStepName = nextStepName;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public boolean isValidatePage() {
        return validatePage;
    }

    public void setValidatePage(boolean validatePage) {
        this.validatePage = validatePage;
    }

    public boolean isForwarderPreferred() {
        return forwarderPreferred;
    }

    public void setForwarderPreferred(boolean forwarderPreferred) {
        this.forwarderPreferred = forwarderPreferred;
    }

    public String getWfStepDesc() {
        return wfStepDesc;
    }

    public void setWfStepDesc(String wfStepDesc) {
        this.wfStepDesc = wfStepDesc;
    }

    public String getCommentRequirementDesc() {
        return commentRequirementDesc;
    }

    public void setCommentRequirementDesc(String commentRequirementDesc) {
        this.commentRequirementDesc = commentRequirementDesc;
    }

}
