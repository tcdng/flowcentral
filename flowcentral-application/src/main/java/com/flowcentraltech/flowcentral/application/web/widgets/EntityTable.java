/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.List;
import java.util.Set;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.constants.ApplicationFeatureConstants;
import com.flowcentraltech.flowcentral.application.data.EntityClassDef;
import com.flowcentraltech.flowcentral.application.data.TableDef;
import com.flowcentraltech.flowcentral.application.util.PrivilegeNameUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.Order;
import com.tcdng.unify.core.criterion.Restriction;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;

/**
 * Entity table object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityTable extends AbstractTable<Restriction, Entity> {

    private static final Order DEFAULT_TABLE_ORDER = new Order().add("id");

    private final String saveGlobalTableQuickFilterPrivilege;

    private int limit;

    private boolean limitSelectToColumns;

    public EntityTable(AppletUtilities au, TableDef tableDef) {
        super(au, tableDef, DEFAULT_TABLE_ORDER, false);
        this.limitSelectToColumns = true;
        this.saveGlobalTableQuickFilterPrivilege = PrivilegeNameUtils
                .getFeaturePrivilegeName(ApplicationFeatureConstants.SAVE_GLOBAL_TABLE_QUICK_FILTER);
    }

    public String getSaveGlobalTableQuickFilterPrivilege() {
        return saveGlobalTableQuickFilterPrivilege;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isLimitSelectToColumns() {
        return limitSelectToColumns;
    }

    public void setLimitSelectToColumns(boolean limitSelectToColumns) {
        this.limitSelectToColumns = limitSelectToColumns;
    }

    @Override
    protected void onLoadSourceObject(Restriction sourceObject, Set<Long> selected) throws UnifyException {

    }

    @Override
    protected void onFireOnChange(Restriction sourceObject, Set<Long> selected) throws UnifyException {
        
    }

    @SuppressWarnings("unchecked")
    @Override
    protected int getSourceObjectSize(Restriction restriction) throws UnifyException {
        final EntityClassDef entityClassDef = au.getEntityClassDef(getTableDef().getEntityDef().getLongName());
        if (restriction != null) {
            return au.getEnvironment().countAll(
                    Query.ofDefaultingToAnd((Class<? extends Entity>) entityClassDef.getEntityClass(), restriction));
        }

        return au.getEnvironment().countAll(
                Query.of((Class<? extends Entity>) entityClassDef.getEntityClass()).ignoreEmptyCriteria(true));
    }

    @SuppressWarnings("unchecked")
    @Override
    protected List<Entity> getDisplayItems(Restriction restriction, int dispStartIndex, int dispEndIndex)
            throws UnifyException {
        final TableDef tableDef = getTableDef();
        final EntityClassDef entityClassDef = au.getEntityClassDef(tableDef.getEntityDef().getLongName());
        if (restriction != null) {
            Query<? extends Entity> query = Query
                    .ofDefaultingToAnd((Class<? extends Entity>) entityClassDef.getEntityClass(), restriction)
                    .setOrder(getOrder()).setOffset(dispStartIndex).setLimit(dispEndIndex - dispStartIndex);
            if (limitSelectToColumns && tableDef.isLimitSelectToColumns()) {
                query.setSelect(tableDef.getSelect());
            }

            return (List<Entity>) au.getEnvironment().listAll(query);
        }

        Query<? extends Entity> query = Query.of((Class<? extends Entity>) entityClassDef.getEntityClass())
                .ignoreEmptyCriteria(true).setOrder(getOrder()).setOffset(dispStartIndex)
                .setLimit(dispEndIndex - dispStartIndex);
        if (limitSelectToColumns && tableDef.isLimitSelectToColumns()) {
            query.setSelect(tableDef.getSelect());
        }

        return (List<Entity>) au.getEnvironment().listAll(query);
    }
}
