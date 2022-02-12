/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Application workflow wizard step entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_WORKWIZARDSTEP", uniqueConstraints = { @UniqueConstraint({ "wfWizardId", "name" }) })
public class WfWizardStep extends BaseConfigNamedEntity {

    @ForeignKey(WfWizard.class)
    private Long wfWizardId;

    @Column(name = "WIZARDSTEP_LABEL", length = 64)
    private String label;

    @Column(name = "WIZARDSTEP_FORM", length = 128)
    private String form;

    @Column(name = "WIZARDSTEP_REFERENCE", length = 64, nullable = true)
    private String reference;

    public Long getWfWizardId() {
        return wfWizardId;
    }

    public void setWfWizardId(Long wfWizardId) {
        this.wfWizardId = wfWizardId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
