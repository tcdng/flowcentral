/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.data;

import com.flowcentraltech.flowcentral.application.data.BaseApplicationEntityDef;
import com.flowcentraltech.flowcentral.application.util.ApplicationEntityNameParts;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.configuration.constants.ChartPaletteType;
import com.flowcentraltech.flowcentral.configuration.constants.ChartType;
import com.tcdng.unify.core.UnifyException;

/**
 * Chart definition object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ChartDef extends BaseApplicationEntityDef {

    private ChartType type;

    private ChartPaletteType paletteType;

    private String title;

    private String subTitle;

    private String provider;

    private String rule;

    private int width;

    private int height;

    private boolean stacked;

    private boolean showGrid;

    private boolean smooth;

    private boolean showDataLabels;

    private ChartDef(ChartType type, ChartPaletteType paletteType, String title, String subTitle, String provider,
            String rule, int width, int height, boolean stacked, boolean showGrid, boolean showDataLabels,
            boolean smooth, ApplicationEntityNameParts nameParts, String description, Long id, long version) {
        super(nameParts, description, id, version);
        this.type = type;
        this.paletteType = paletteType;
        this.title = title;
        this.subTitle = subTitle;
        this.provider = provider;
        this.rule = rule;
        this.width = width;
        this.height = height;
        this.stacked = stacked;
        this.showGrid = showGrid;
        this.showDataLabels = showDataLabels;
        this.smooth = smooth;
    }

    public ChartType getType() {
        return type;
    }

    public ChartPaletteType getPaletteType() {
        return paletteType;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getProvider() {
        return provider;
    }

    public String getRule() {
        return rule;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isStacked() {
        return stacked;
    }

    public boolean isShowGrid() {
        return showGrid;
    }

    public boolean isShowDataLabels() {
        return showDataLabels;
    }

    public boolean isSmooth() {
        return smooth;
    }

    public static Builder newBuilder(ChartType type, ChartPaletteType paletteType, String provider, String rule,
            String longName, String description, Long id, long version) {
        return new Builder(type, paletteType, provider, rule, longName, description, id, version);
    }

    public static class Builder {

        private ChartType type;

        private ChartPaletteType paletteType;

        private String title;

        private String subTitle;

        private String provider;

        private String rule;

        private int width;

        private int height;

        private boolean stacked;

        private boolean showGrid;

        private boolean smooth;

        private boolean showDataLabels;

        private String longName;

        private String description;

        private Long id;

        private long version;

        public Builder(ChartType type, ChartPaletteType paletteType, String provider, String rule, String longName,
                String description, Long id, long version) {
            this.type = type;
            this.paletteType = paletteType;
            this.provider = provider;
            this.rule = rule;
            this.longName = longName;
            this.description = description;
            this.id = id;
            this.version = version;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder subTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder stacked(boolean stacked) {
            this.stacked = stacked;
            return this;
        }

        public Builder showGrid(boolean showGrid) {
            this.showGrid = showGrid;
            return this;
        }

        public Builder showDataLabels(boolean showDataLabels) {
            this.showDataLabels = showDataLabels;
            return this;
        }

        public Builder smooth(boolean smooth) {
            this.smooth = smooth;
            return this;
        }

        public ChartDef build() throws UnifyException {
            return new ChartDef(type, paletteType, title, subTitle, provider, rule, width, height, stacked, showGrid,
                    showDataLabels, smooth, ApplicationNameUtils.getApplicationEntityNameParts(longName), description,
                    id, version);
        }
    }

}
