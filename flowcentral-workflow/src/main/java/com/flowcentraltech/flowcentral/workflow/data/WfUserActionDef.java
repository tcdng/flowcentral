/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.data;

import com.tcdng.unify.core.constant.RequirementType;

/**
 * Workflow user action definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfUserActionDef {

    private RequirementType commentRequirement;

    private String name;

    private String description;

    private String label;

    private String symbol;

    private String styleClass;

    private String nextStepName;

    private int orderIndex;

    private boolean validatePage;

    private boolean forwarderPreferred;

    public WfUserActionDef(RequirementType commentRequirement, String name, String description, String label,
            String symbol, String styleClass, String nextStepName, int orderIndex, boolean validatePage,
            boolean forwarderPreferred) {
        this.commentRequirement = commentRequirement;
        this.name = name;
        this.description = description;
        this.label = label;
        this.symbol = symbol;
        this.styleClass = styleClass;
        this.nextStepName = nextStepName;
        this.orderIndex = orderIndex;
        this.validatePage = validatePage;
        this.forwarderPreferred = forwarderPreferred;
    }

    public RequirementType getCommentRequirement() {
        return commentRequirement;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public String getNextStepName() {
        return nextStepName;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public boolean isValidatePage() {
        return validatePage;
    }

    public boolean isForwarderPreferred() {
        return forwarderPreferred;
    }

}
