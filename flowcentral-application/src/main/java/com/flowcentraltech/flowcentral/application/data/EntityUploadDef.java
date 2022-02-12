/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tcdng.unify.core.batch.ConstraintAction;
import com.tcdng.unify.core.data.Listable;

/**
 * Entity upload definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityUploadDef implements Listable {

    private String name;

    private String description;

    private FieldSequenceDef fieldSequenceDef;

    private List<String> fieldNameList;

    private ConstraintAction constraintAction;

    public EntityUploadDef(String name, String description, FieldSequenceDef fieldSequenceDef,
            ConstraintAction constraintAction) {
        this.name = name;
        this.description = description;
        this.fieldSequenceDef = fieldSequenceDef;
        this.constraintAction = constraintAction;
    }

    @Override
    public String getListDescription() {
        return description;
    }

    @Override
    public String getListKey() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public FieldSequenceDef getFieldSequenceDef() {
        return fieldSequenceDef;
    }

    public ConstraintAction getConstraintAction() {
        return constraintAction;
    }

    public List<String> getFieldNameList() {
        if (fieldNameList == null) {
            fieldNameList = new ArrayList<String>();
            for (FieldSequenceEntryDef fieldSequenceEntryDef : fieldSequenceDef.getFieldSequenceList()) {
                fieldNameList.add(fieldSequenceEntryDef.getFieldName());
            }

            fieldNameList = Collections.unmodifiableList(fieldNameList);
        }
        return fieldNameList;
    }

}
