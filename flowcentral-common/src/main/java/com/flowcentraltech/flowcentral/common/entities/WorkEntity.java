/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.entities;

import com.tcdng.unify.core.database.Entity;

/**
 * Work entity definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface WorkEntity extends Entity {

    String getWorkBranchCode();

    void setWorkBranchCode(String branchCode);
    
    String getWorkDepartmentCode();

    void setWorkDepartmentCode(String departmentCode);

    String getWorkflowItemDesc();

    boolean isInWorkflow();

    void setInWorkflow(boolean inWorkflow);
}
