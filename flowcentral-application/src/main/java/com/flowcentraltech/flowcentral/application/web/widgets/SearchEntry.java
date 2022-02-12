/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.EntityFieldDef;
import com.flowcentraltech.flowcentral.application.util.InputWidgetUtils;
import com.flowcentraltech.flowcentral.common.input.AbstractInput;
import com.tcdng.unify.core.UnifyException;

/**
 * Search entry.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SearchEntry {

    private EntityDef entityDef;

    private String fieldName;

    private String paramField;

    private AbstractInput<?> paramInput;

    public SearchEntry(EntityDef entityDef, String fieldName) {
        this.entityDef = entityDef;
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public EntityDef getEntityDef() {
        return entityDef;
    }

    public EntityFieldDef getEntityFieldDef() {
        return entityDef.getFieldDef(fieldName);
    }

    public String getParamField() {
        return paramField;
    }

    public AbstractInput<?> getParamInput() {
        return paramInput;
    }

    public boolean isWithParamInput() {
        return paramInput != null;
    }

    public void normalize() throws UnifyException {
        EntityFieldDef entityFieldDef = entityDef.getFieldDef(fieldName);
        paramInput = evalInput(entityFieldDef);
    }

    private AbstractInput<?> evalInput(EntityFieldDef entityFieldDef)
            throws UnifyException {
        return InputWidgetUtils.newInput(entityFieldDef, false, true);
    }

}
