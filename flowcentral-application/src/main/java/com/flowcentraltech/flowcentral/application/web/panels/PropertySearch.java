/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import java.util.List;

import com.flowcentraltech.flowcentral.application.data.PropertyListItem;
import com.flowcentraltech.flowcentral.application.data.PropertyRuleDef;
import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.widgets.BeanTable;
import com.flowcentraltech.flowcentral.common.business.policies.SweepingCommitPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Property search object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PropertySearch extends AbstractPanelFormBinding {

    public static final int SHOW_EDIT_BUTTON = 0x00000001;

    public static final int ENABLE_ALL = SHOW_EDIT_BUTTON;

    private PropertyRuleDef propertyRuleDef;

    private BeanTable beanTable;

    private String entitySubTitle;

    private int childTabIndex;

    private int mode;

    public PropertySearch(FormContext ctx, SweepingCommitPolicy sweepingCommitPolicy, String tabName,
            PropertyRuleDef propertyRuleDef, int mode) throws UnifyException {
        super(ctx, sweepingCommitPolicy, tabName);
        this.beanTable = new BeanTable(ctx.getAu(), ctx.getAu().getTableDef("application.propertyItemTable"));
        this.propertyRuleDef = propertyRuleDef;
        this.mode = mode;
    }

    public PropertyRuleDef getPropertyRuleDef() {
        return propertyRuleDef;
    }

    public int getMode() {
        return mode;
    }

    public BeanTable getBeanTable() {
        return beanTable;
    }

    public String getEntityTitle() {
        return beanTable.getTableDef().getLabel();
    }

    public String getEntitySubTitle() {
        return entitySubTitle;
    }

    public void setEntitySubTitle(String entitySubTitle) {
        this.entitySubTitle = entitySubTitle;
    }

    public int getChildTabIndex() {
        return childTabIndex;
    }

    public void setChildTabIndex(int childTabIndex) {
        this.childTabIndex = childTabIndex;
    }

    public int getTotalItemCount() {
        return beanTable.getTotalItemCount();
    }

    public void applyEntityToSearch(Entity inst, String childFkFieldName) throws UnifyException {
        List<PropertyListItem> propertyItemList = beanTable.getAu().getPropertyListItems(inst, childFkFieldName,
                propertyRuleDef);
        beanTable.setSourceObject(propertyItemList);
    }

    public boolean isEditButtonVisible() {
        return getAppletCtx().isContextEditable() && (mode & SHOW_EDIT_BUTTON) > 0
                && !DataUtils.isBlank(beanTable.getSourceObject());
    }

    public boolean isViewButtonVisible() {
        return !getAppletCtx().isContextEditable() && (mode & SHOW_EDIT_BUTTON) > 0
                && !DataUtils.isBlank(beanTable.getSourceObject());
    }
}
