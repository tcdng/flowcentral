/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.lists;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.LabelSuggestionDef;
import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Entity definition and label suggestion list parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityLabelSuggestionDefListParams extends AbstractListParam {

    private EntityDef entityDef;

    private LabelSuggestionDef labelSuggestionDef;

    public EntityLabelSuggestionDefListParams(EntityDef entityDef, LabelSuggestionDef labelSuggestionDef) {
        this.entityDef = entityDef;
        this.labelSuggestionDef = labelSuggestionDef;
    }

    public EntityDef getEntityDef() {
        return entityDef;
    }

    public LabelSuggestionDef getLabelSuggestionDef() {
        return labelSuggestionDef;
    }

    @Override
    public boolean isPresent() {
        return entityDef != null;
    }

    @Override
    public String toString() {
        return "EntityLabelSuggestionDefListParams [entityDef=" + entityDef + ", labelSuggestionDef="
                + labelSuggestionDef + "]";
    }

}
