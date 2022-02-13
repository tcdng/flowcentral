/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.data.EntityClassDef;
import com.flowcentraltech.flowcentral.application.data.FormDef;
import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.widgets.MiniForm;
import com.flowcentraltech.flowcentral.application.web.widgets.MiniFormScope;
import com.flowcentraltech.flowcentral.common.business.policies.SweepingCommitPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.Restriction;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;

/**
 * Entity child object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityChild extends AbstractPanelFormBinding {

    private final FormDef childFormDef;

    private String entitySubTitle;

    private MiniForm childForm;

    private Entity childInst;

    private int childTabIndex;

    private boolean canCreate;

    public EntityChild(FormContext ctx, SweepingCommitPolicy sweepingCommitPolicy, String tabName, FormDef childFormDef) {
        super(ctx, sweepingCommitPolicy, tabName);
        this.childFormDef = childFormDef;
    }

    public MiniForm getChildForm() {
        return childForm;
    }

    public boolean isWithChild() {
        return childForm != null;
    }

    public String getEntityTitle() {
        return childFormDef.getEntityDef().getDescription();
    }

    public String getEntitySubTitle() {
        return entitySubTitle;
    }

    public void setEntitySubTitle(String entitySubTitle) {
        this.entitySubTitle = entitySubTitle;
    }

    public Entity getChildInst() {
        return childInst;
    }

    public int getChildTabIndex() {
        return childTabIndex;
    }

    public void setChildTabIndex(int childTabIndex) {
        this.childTabIndex = childTabIndex;
    }

    public boolean isCreateButtonVisible() {
        return canCreate && getAppletCtx().isContextEditable();
    }

    public boolean isCanCreate() {
        return canCreate;
    }

    public void setCanCreate(boolean canCreate) {
        this.canCreate = canCreate;
    }

    public boolean isEditButtonVisible() {
        return getAppletCtx().isContextEditable();
    }

    public boolean isViewButtonVisible() {
        return !getAppletCtx().isContextEditable();
    }

    @SuppressWarnings("unchecked")
    public void load(FormContext ctx, Restriction restriction) throws UnifyException {
        final EntityClassDef entityClassDef = ctx.getAu().getEntityClassDef(childFormDef.getEntityDef().getLongName());
        childInst = ctx.getEnvironment()
                .listLean(Query.of((Class<? extends Entity>) entityClassDef.getEntityClass())
                        .addRestriction(restriction));
        if (childInst != null) {
            FormContext _ctx = new FormContext(ctx.getAppletContext(), childFormDef, ctx.getFormSwitchOnChangeHandlers(),
                    childInst);
            _ctx.revertTabStates();
            childForm = new MiniForm(MiniFormScope.CHILD_FORM, _ctx, childFormDef.getFormTabDef(0));
        } else {
            childForm = null;
        }
    }
}