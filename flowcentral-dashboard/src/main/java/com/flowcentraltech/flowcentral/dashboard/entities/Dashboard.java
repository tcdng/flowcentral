/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.dashboard.entities;

import java.util.List;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntity;
import com.tcdng.unify.core.annotation.ChildList;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;

/**
 * Dashboard entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_DASHBOARD")
public class Dashboard extends BaseApplicationEntity {

    @Column
    private int sections;

    @ChildList
    private List<DashboardTile> tileList;

    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    public List<DashboardTile> getTileList() {
        return tileList;
    }

    public void setTileList(List<DashboardTile> tileList) {
        this.tileList = tileList;
    }

}
