/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.writers;

import com.tcdng.unify.core.constant.HAlignType;

/**
 * Listing column.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ListingColumn {

    private  HAlignType align;
    
    private int widthPercent;

    public ListingColumn(int widthPercent) {
        this.align = HAlignType.LEFT;
        this.widthPercent = widthPercent;
    }

    public ListingColumn(HAlignType align, int widthPercent) {
        this.align = align;
        this.widthPercent = widthPercent;
    }

    public HAlignType getAlign() {
        return align;
    }

    public int getWidthPercent() {
        return widthPercent;
    }
}
