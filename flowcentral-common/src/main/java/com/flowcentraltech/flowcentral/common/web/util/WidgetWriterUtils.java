/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
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
 * @author Lateef Ojulari
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
