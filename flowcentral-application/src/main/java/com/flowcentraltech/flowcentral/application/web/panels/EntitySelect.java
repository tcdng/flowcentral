/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.TableDef;
import com.flowcentraltech.flowcentral.application.web.widgets.EntityTable;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.ILike;
import com.tcdng.unify.core.criterion.IsNull;
import com.tcdng.unify.core.criterion.Order;
import com.tcdng.unify.core.criterion.Restriction;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Entity select object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntitySelect {

    private static final Restriction NULL_RESTRICTION = new IsNull("id");
    
    private final String fieldName;
    
    private String filter;

    private EntityTable entityTable;

    public EntitySelect(AppletUtilities au, TableDef tableDef, String fieldName, int limit) {
        this.entityTable = new EntityTable(au, tableDef);
        this.entityTable.setOrder(new Order().add(fieldName));
        this.entityTable.setLimit(limit);
        this.fieldName = fieldName;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public EntityTable getEntityTable() {
        return entityTable;
    }

    public void ensureTableStruct() throws UnifyException {
        TableDef _eTableDef = entityTable.getTableDef();
        TableDef _nTableDef = entityTable.getAu().getTableDef(_eTableDef.getLongName());
        if (_eTableDef.getVersion() != _nTableDef.getVersion()) {
            entityTable = new EntityTable(entityTable.getAu(), _nTableDef);
            applyFilterToSearch();
        }
    }

    public void applyFilterToSearch() throws UnifyException {
        Restriction restriction = !StringUtils.isBlank(filter) ? new ILike(fieldName, filter): NULL_RESTRICTION;
        entityTable.setSourceObject(restriction);
    }

}
