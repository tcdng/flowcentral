/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.flowcentraltech.flowcentral.dashboard.data;

import com.flowcentraltech.flowcentral.configuration.constants.DashboardTileType;

/**
 * Dashboard tile definition object.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public class DashboardTileDef {

    private DashboardTileType type;

    private String name;

    private String description;

    private String chart;

    private int section;

    private int index;

    public DashboardTileDef(DashboardTileType type, String name, String description, String chart, int section,
            int index) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.chart = chart;
        this.section = section;
        this.index = index;
    }

    public DashboardTileType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getChart() {
        return chart;
    }

    public int getSection() {
        return section;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "DashboardTileDef [type=" + type + ", name=" + name + ", description=" + description + ", chart=" + chart
                + ", section=" + section + ", index=" + index + "]";
    }

}
