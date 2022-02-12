/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import java.util.List;

import com.tcdng.unify.core.annotation.ChildList;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application property list entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_PROPLIST")
public class AppPropertyList extends BaseApplicationEntity {

    @ChildList
    private List<AppPropertySet> itemSet;

    public List<AppPropertySet> getItemSet() {
        return itemSet;
    }

    public void setItemSet(List<AppPropertySet> itemSet) {
        this.itemSet = itemSet;
    }

}
