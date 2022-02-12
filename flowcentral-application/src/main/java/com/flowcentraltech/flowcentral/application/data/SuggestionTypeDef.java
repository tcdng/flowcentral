/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.tcdng.unify.core.UnifyException;

/**
 * Suggestion type definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SuggestionTypeDef extends BaseApplicationEntityDef {

    private String parent;
    
    public SuggestionTypeDef(String parent, String longName, String description, Long id,
            long versionNo) throws UnifyException {
        super(ApplicationNameUtils.getApplicationEntityNameParts(longName), description, id, versionNo);
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }

    public boolean isWithParent() {
        return parent != null;
    }
    
    @Override
    public String toString() {
        return "SuggestionTypeDef [getListDescription()=" + getListDescription() + ", getListKey()=" + getListKey()
                + ", getNameParts()=" + getNameParts() + ", getLongName()=" + getLongName() + ", getApplicationName()="
                + getApplicationName() + ", getName()=" + getName() + ", getDescription()=" + getDescription()
                + ", getId()=" + getId() + ", getVersion()=" + getVersion() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
