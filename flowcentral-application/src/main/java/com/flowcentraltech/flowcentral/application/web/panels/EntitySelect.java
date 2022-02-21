/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.TableDef;
import com.flowcentraltech.flowcentral.application.web.widgets.EntityTable;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.ILike;
import com.tcdng.unify.core.criterion.Order;
import com.tcdng.unify.core.criterion.Restriction;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Entity select object.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public class EntitySelect {
    
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
        Restriction restriction = !StringUtils.isBlank(filter) ? new ILike(fieldName, filter): null;
        entityTable.setSourceObject(restriction);
    }

}
