/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.EntityFieldDef;
import com.flowcentraltech.flowcentral.application.data.LabelSuggestionDef;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.And;
import com.tcdng.unify.core.criterion.Equals;
import com.tcdng.unify.core.criterion.ILike;
import com.tcdng.unify.core.criterion.Restriction;

/**
 * Search entries object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SearchEntries {

    private EntityDef entityDef;

    private LabelSuggestionDef labelSuggestion;

    private List<SearchEntry> entryList;

    private final int columns;

    public SearchEntries(EntityDef entityDef, LabelSuggestionDef labelSuggestion, int columns) {
        this.entityDef = entityDef;
        this.labelSuggestion = labelSuggestion;
        this.columns = columns;
    }

    public EntityDef getEntityDef() {
        return entityDef;
    }

    public String getLabelSuggestion(String fieldName) {
        return labelSuggestion != null ? labelSuggestion.getSuggestedLabel(fieldName) : null;
    }

    public List<SearchEntry> getEntryList() {
        return entryList;
    }

    public SearchEntry getEntry(int index) {
        return entryList.get(index);
    }

    public void clear() {
        if (entryList != null) {
            for (SearchEntry searchEntry : entryList) {
                searchEntry.getParamInput().setValue(null);
            }
        }
    }

    public int size() {
        return entryList.size();
    }

    public int getColumns() {
        return columns;
    }

    public Restriction getRestriction() throws UnifyException {
        if (entryList != null) {
            And and = new And();
            for (SearchEntry searchEntry : entryList) {
                Object val = searchEntry.getParamInput().getValue();
                if (val != null) {
                    EntityFieldDef entityFieldDef = searchEntry.getEntityFieldDef();
                    EntityFieldDataType dataType = entityFieldDef.isWithResolvedTypeFieldDef()
                            ? entityFieldDef.getResolvedTypeFieldDef().getDataType()
                            : entityFieldDef.getDataType();
                    if (EntityFieldDataType.STRING.equals(dataType)) {
                        and.add(new ILike(entityFieldDef.getFieldName(), val));
                    } else {
                        and.add(new Equals(entityFieldDef.getFieldName(), val));
                    }
                }
            }

            if (!and.isEmpty()) {
                return and;
            }
        }

        return null;
    }

    public void normalize() throws UnifyException {
        if (entryList == null) {
            entryList = new ArrayList<SearchEntry>();
            for (EntityFieldDef entityFieldDef : entityDef.getBasicSearchFieldDefList()) {
                SearchEntry searchEntry = new SearchEntry(entityDef, entityFieldDef.getFieldName());
                searchEntry.normalize();
                entryList.add(searchEntry);
            }
        }
    }

}
