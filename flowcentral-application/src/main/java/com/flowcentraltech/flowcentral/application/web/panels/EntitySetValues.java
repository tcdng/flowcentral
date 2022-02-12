/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.SetValuesDef;
import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.widgets.SetValueEntries;
import com.flowcentraltech.flowcentral.common.business.policies.SweepingCommitPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.constant.Editable;

/**
 * Entity set values object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntitySetValues extends AbstractPanelFormBinding {

    public static final int SHOW_CLEAR_BUTTON = 0x00000001;
    public static final int SHOW_APPLY_BUTTON = 0x00000002;

    public static final int ENABLE_ALL = SHOW_CLEAR_BUTTON | SHOW_APPLY_BUTTON;

    private final int mode;

    private final EntityDef ownerEntityDef;

    private SetValueEntries setValueEntries;

    private String category;

    private Long ownerInstId;

    public EntitySetValues(FormContext ctx, SweepingCommitPolicy sweepingCommitPolicy, String tabName, EntityDef ownerEntityDef,
            int mode) {
        super(ctx, sweepingCommitPolicy, tabName);
        this.ownerEntityDef = ownerEntityDef;
        this.mode = mode;
    }

    public SetValueEntries getSetValueEntries() {
        return setValueEntries;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOwnerInstId(Long ownerInstId) {
        this.ownerInstId = ownerInstId;
    }

    public void load(EntityDef entityDef) throws UnifyException {
        SetValuesDef setValuesDef = getAppletCtx().getAu().retrieveSetValuesDef(category, ownerEntityDef.getLongName(), ownerInstId);
        setValueEntries = new SetValueEntries(entityDef, setValuesDef, Editable.fromBoolean(isApplyButtonVisible()));
    }

    public void save() throws UnifyException {
        if (setValueEntries != null) {
            getAppletCtx().getAu().saveSetValuesDef(getSweepingCommitPolicy(), category, ownerEntityDef.getLongName(), ownerInstId,
                    setValueEntries.getSetValuesDef());
        }
    }

    public void clear() throws UnifyException {
        if (setValueEntries != null) {
            setValueEntries.clear();
        }
    }

    public boolean isClearButtonVisible() {
        return getAppletCtx().isContextEditable() && (mode & SHOW_CLEAR_BUTTON) > 0;
    }

    public boolean isApplyButtonVisible() {
        return getAppletCtx().isContextEditable() && (mode & SHOW_APPLY_BUTTON) > 0;
    }
}
