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

package com.flowcentraltech.flowcentral.common.web.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.flowcentraltech.flowcentral.configuration.constants.FormColumnsType;

/**
 * Widget writer utility methods.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public final class WidgetWriterUtils {

    private static final Map<FormColumnsType, List<ColumnRenderInfo>> columnsInfo;

    private static final List<FormColumnsType> columnTypes = Collections.unmodifiableList(Arrays
            .asList(FormColumnsType.TYPE_1, FormColumnsType.TYPE_2, FormColumnsType.TYPE_3, FormColumnsType.TYPE_4));

    static {
        Map<FormColumnsType, List<ColumnRenderInfo>> map = new EnumMap<FormColumnsType, List<ColumnRenderInfo>>(
                FormColumnsType.class);
        map.put(FormColumnsType.TYPE_1,
                Collections.unmodifiableList(Arrays.asList(new ColumnRenderInfo("style=\"width:100%;\""))));
        map.put(FormColumnsType.TYPE_2, Collections.unmodifiableList(Arrays
                .asList(new ColumnRenderInfo("style=\"width:50%;\""), new ColumnRenderInfo("style=\"width:50%;\""))));
        map.put(FormColumnsType.TYPE_1_2,
                Collections.unmodifiableList(Arrays.asList(new ColumnRenderInfo("style=\"width:50%;\""),
                        new ColumnRenderInfo("style=\"width:25%;\""), new ColumnRenderInfo("style=\"width:25%;\""))));
        map.put(FormColumnsType.TYPE_2_1,
                Collections.unmodifiableList(Arrays.asList(new ColumnRenderInfo("style=\"width:25%;\""),
                        new ColumnRenderInfo("style=\"width:25%;\""), new ColumnRenderInfo("style=\"width:50%;\""))));
        map.put(FormColumnsType.TYPE_3,
                Collections.unmodifiableList(Arrays.asList(new ColumnRenderInfo("style=\"width:33%;\""),
                        new ColumnRenderInfo("style=\"width:34%;\""), new ColumnRenderInfo("style=\"width:33%;\""))));
        map.put(FormColumnsType.TYPE_4,
                Collections.unmodifiableList(Arrays.asList(new ColumnRenderInfo("style=\"width:25%;\""),
                        new ColumnRenderInfo("style=\"width:25%;\""), new ColumnRenderInfo("style=\"width:25%;\""),
                        new ColumnRenderInfo("style=\"width:25%;\""))));
        columnsInfo = Collections.unmodifiableMap(map);
    }

    private WidgetWriterUtils() {

    }

    public static String getTabClass(int index, int tabIndex) {
        if (index == tabIndex) {
            return "tactive";
        } else if (index < tabIndex) {
            return "tinactiveleft";
        }

        return "tinactiveright";
    }

    public static List<ColumnRenderInfo> getColumnRenderInfoList(FormColumnsType type) {
        return columnsInfo.get(type);
    }

    public static List<ColumnRenderInfo> getColumnRenderInfoList(int columns) {
        FormColumnsType type = null;
        columns--;
        if (columns < 0) {
            type = columnTypes.get(0);
        } else if (columns >= columnTypes.size()) {
            type = columnTypes.get(columnTypes.size() - 1);
        } else {
            type = columnTypes.get(columns);
        }
        
        return columnsInfo.get(type);
    }

    public static class ColumnRenderInfo {

        private String columnStyle;

        public ColumnRenderInfo(String columnStyle) {
            this.columnStyle = columnStyle;
        }

        public String getColumnStyle() {
            return columnStyle;
        }

    }
}
