/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.FieldSequenceDef;
import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.widgets.FieldSequence;
import com.flowcentraltech.flowcentral.common.business.policies.SweepingCommitPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.constant.Editable;

/**
 * Entity field sequence object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityFieldSequence extends AbstractPanelFormBinding {

    public static final int SHOW_CLEAR_BUTTON = 0x00000001;
    public static final int SHOW_APPLY_BUTTON = 0x00000002;

    public static final int ENABLE_ALL = SHOW_CLEAR_BUTTON | SHOW_APPLY_BUTTON;

    private final int mode;

    private final EntityDef ownerEntityDef;

    private FieldSequence fieldSequence;

    private String category;

    private Long ownerInstId;

    public EntityFieldSequence(FormContext ctx, SweepingCommitPolicy sweepingCommitPolicy, String tabName,
            EntityDef ownerEntityDef, int mode) {
        super(ctx, sweepingCommitPolicy, tabName);
        this.ownerEntityDef = ownerEntityDef;
        this.mode = mode;
    }

    public FieldSequence getFieldSequence() {
        return fieldSequence;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOwnerInstId(Long ownerInstId) {
        this.ownerInstId = ownerInstId;
    }

    public void load(EntityDef entityDef) throws UnifyException {
        FieldSequenceDef fieldSequenceDef = getAppletCtx().getAu().retrieveFieldSequenceDef(category,
                ownerEntityDef.getLongName(), ownerInstId);
        fieldSequence = new FieldSequence(entityDef, fieldSequenceDef, Editable.fromBoolean(isApplyButtonVisible()));
    }

    public void save() throws UnifyException {
        if (fieldSequence != null) {
            getAppletCtx().getAu().saveFieldSequenceDef(getSweepingCommitPolicy(), category,
                    ownerEntityDef.getLongName(), ownerInstId, fieldSequence.getFieldSequenceDef());
        }
    }

    public void clear() throws UnifyException {
        if (fieldSequence != null) {
            fieldSequence.clear();
        }
    }

    public boolean isClearButtonVisible() {
        return getAppletCtx().isContextEditable() && (mode & SHOW_CLEAR_BUTTON) > 0;
    }

    public boolean isApplyButtonVisible() {
        return getAppletCtx().isContextEditable() && (mode & SHOW_APPLY_BUTTON) > 0;
    }
}