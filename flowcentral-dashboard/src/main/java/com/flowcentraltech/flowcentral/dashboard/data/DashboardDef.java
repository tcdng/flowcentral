/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.dashboard.data;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.application.data.BaseApplicationEntityDef;
import com.flowcentraltech.flowcentral.application.util.ApplicationEntityNameParts;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.configuration.constants.DashboardTileType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Dashboard definition object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DashboardDef extends BaseApplicationEntityDef {

    private int sections;

    private List<List<DashboardTileDef>> tileList;

    private DashboardDef(int sections, List<List<DashboardTileDef>> tileList, ApplicationEntityNameParts nameParts,
            String description, Long id, long version) {
        super(nameParts, description, id, version);
        this.sections = sections;
        this.tileList = tileList;
    }

    public int getSections() {
        return sections;
    }

    public List<DashboardTileDef> getTileList(int section) {
        return tileList.get(section);
    }

    public static Builder newBuilder(int sections, String longName, String description, Long id, long version) {
        return new Builder(sections, longName, description, id, version);
    }

    public static class Builder {

        private int sections;

        private List<DashboardTileDef> tileList;

        private String longName;

        private String description;

        private Long id;

        private long version;

        public Builder(int sections, String longName, String description, Long id, long version) {
            this.sections = sections <= 0 ? 1 : sections;
            this.longName = longName;
            this.description = description;
            this.id = id;
            this.version = version;
            this.tileList = new ArrayList<DashboardTileDef>();
        }

        public Builder addTile(DashboardTileType type, String name, String description, String chart, int section,
                int index) {
            if (section < 0 || section >= sections) {
                throw new RuntimeException(
                        "Can not add tile to section [" + section + "] for dashboard with [" + sections + "] sections");
            }

            tileList.add(new DashboardTileDef(type, name, description, chart, section, index));
            return this;
        }

        @SuppressWarnings("unchecked")
        public DashboardDef build() throws UnifyException {
            Object[] tileListArr = new Object[sections];
            for (int i = 0; i < sections; i++) {
                tileListArr[i] = new ArrayList<DashboardTileDef>();
            }

            for (DashboardTileDef dashboardTileDef : tileList) {
                ((List<DashboardTileDef>) tileListArr[dashboardTileDef.getSection()]).add(dashboardTileDef);
            }

            List<List<DashboardTileDef>> finalTileList = new ArrayList<List<DashboardTileDef>>();
            for (Object obj : tileListArr) {
                List<DashboardTileDef> tileList = (List<DashboardTileDef>) obj;
                DataUtils.sortAscending(tileList, DashboardTileDef.class, "index");
                finalTileList.add(DataUtils.unmodifiableList(tileList));
            }

            return new DashboardDef(sections, DataUtils.unmodifiableList(finalTileList),
                    ApplicationNameUtils.getApplicationEntityNameParts(longName), description, id, version);
        }
    }

    @Override
    public String toString() {
        return "DashboardDef [sections=" + sections + ", tileList=" + tileList + "]";
    }

}
