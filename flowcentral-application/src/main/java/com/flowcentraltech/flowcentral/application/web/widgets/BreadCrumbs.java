/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.ArrayList;
import java.util.List;

import com.tcdng.unify.core.util.DataUtils;

/**
 * Bread crumbs.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class BreadCrumbs {

    private List<BreadCrumb> histCrumbList;

    private BreadCrumb lastBreadCrumb;

    private BreadCrumbs(List<BreadCrumb> histCrumbList) {
        this.histCrumbList = histCrumbList;
        this.lastBreadCrumb = new BreadCrumb();
    }

    public BreadCrumbs advance() {
        List<BreadCrumb> advHistCrumbList = new ArrayList<BreadCrumb>(histCrumbList);
        advHistCrumbList.add(lastBreadCrumb);
        return new BreadCrumbs(DataUtils.unmodifiableList(advHistCrumbList));
    }

    public void setLastCrumbTitle(String title) {
        lastBreadCrumb.title = title;
    }

    public void setLastCrumbSubTitle(String subTitle) {
        lastBreadCrumb.subTitle = subTitle;
    }

    public void setLastCrumbStepIndex(int stepIndex) {
        if (stepIndex > 0) {
            lastBreadCrumb.stepIndex = stepIndex;
        }
    }

    public List<BreadCrumb> getHistCrumbList() {
        return histCrumbList;
    }

    public BreadCrumb getLastBreadCrumb() {
        return lastBreadCrumb;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private List<BreadCrumb> histCrumbList;

        public Builder() {
            histCrumbList = new ArrayList<BreadCrumb>();
        }

        public Builder addHistoryCrumb(BreadCrumb bc) {
            histCrumbList.add(bc);
            return this;
        }

        public Builder addHistoryCrumb(String title, String subTitle, int stepIndex) {
            histCrumbList.add(new BreadCrumb(title, subTitle, stepIndex));
            return this;
        }

        public BreadCrumbs build() {
            return new BreadCrumbs(DataUtils.unmodifiableList(histCrumbList));
        }
    }

    public static class BreadCrumb {

        private String title;

        private String subTitle;

        private int stepIndex;

        public BreadCrumb(String title, String subTitle, int stepIndex) {
            this.title = title;
            this.subTitle = subTitle;
            this.stepIndex = stepIndex;
        }

        private BreadCrumb() {

        }

        public String getTitle() {
            return title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public int getStepIndex() {
            return stepIndex;
        }

    }
}
