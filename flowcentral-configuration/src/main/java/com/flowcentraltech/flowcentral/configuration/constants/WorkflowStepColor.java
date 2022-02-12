/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.constants;

/**
 * Workflow step color enumeration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public enum WorkflowStepColor {
    
    RED(0),
    PURPLE(1),
    CYAN(2),
    BLUE(3),
    GREEN(4),
    GOLD(5),
    ORANGE(6),
    GRAY(7),
    NAVY(8),
    BLACK(9);

    private final int index;
    
    private WorkflowStepColor(int index) {
        this.index = index;
    }

    public int index() {
        return this.index;
    }
}
