/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.data;

import java.util.List;

import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.web.ui.widget.data.DialogCrudInfo;

/**
 * Step dialog information object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StepDialogCrudInfo<T> extends DialogCrudInfo<T> {

    private String entityName;

    private Long workflowId;
    
    private List<? extends Listable> prevStepList;

    public StepDialogCrudInfo(Class<T> typeClass, String entityName, Long workflowId) {
        super(typeClass);
        this.entityName = entityName;
        this.workflowId = workflowId;
    }

    public Long getWorkflowId() {
        return workflowId;
    }

    public String getEntityName() {
        return entityName;
    }

    public List<? extends Listable> getPrevStepList() {
        return prevStepList;
    }

    public void setPrevStepList(List<? extends Listable> prevStepList) {
        this.prevStepList = prevStepList;
    }

}
