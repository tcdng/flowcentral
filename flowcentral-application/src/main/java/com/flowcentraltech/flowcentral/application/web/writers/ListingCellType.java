/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.writers;

/**
 * Listing cell type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public enum ListingCellType {

    BOLD_LABEL("flboldlabel"),
    BOLD_TEXT("flboldtext"),
    TEXT("") ;
    
    private String styleClass;
    
    private ListingCellType(String styleClass) {
        this.styleClass =styleClass;
    }
    
    public String styleClass() {
        return styleClass;
    }
}
