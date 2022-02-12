/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.writers;

import com.tcdng.unify.core.util.StringUtils;

/**
 * Listing column.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ListingCell {

    private  ListingCellType type;
    
    private String content;

    public ListingCell(ListingCellType type, String content) {
        this.type = type;
        this.content = content;
    }

    public ListingCell(String content) {
        this.type = ListingCellType.TEXT;
        this.content = content;
    }

    public ListingCellType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public boolean isWithContent() {
        return !StringUtils.isBlank(content);
    }
}
