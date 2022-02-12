/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.tcdng.unify.core.batch.ConstraintAction;
import com.tcdng.unify.core.util.xml.adapter.ConstraintActionXmlAdapter;

/**
 * Entity upload configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityUploadConfig extends BaseNameConfig {

    private ConstraintAction constraintAction;

    private FieldSequenceConfig fieldSequence;

    public EntityUploadConfig() {
        this.constraintAction = ConstraintAction.FAIL;
    }

    public ConstraintAction getConstraintAction() {
        return constraintAction;
    }

    @XmlJavaTypeAdapter(ConstraintActionXmlAdapter.class)
    @XmlAttribute(name = "onConstraint")
    public void setConstraintAction(ConstraintAction constraintAction) {
        this.constraintAction = constraintAction;
    }

    public FieldSequenceConfig getFieldSequence() {
        return fieldSequence;
    }

    @XmlElement(required = true)
    public void setFieldSequence(FieldSequenceConfig fieldSequence) {
        this.fieldSequence = fieldSequence;
    }

}
