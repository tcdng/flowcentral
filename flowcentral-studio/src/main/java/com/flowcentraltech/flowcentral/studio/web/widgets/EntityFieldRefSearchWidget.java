/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.widgets;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.widgets.EntitySearchWidget;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplAttribute;
import com.tcdng.unify.core.annotation.UplAttributes;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;
import com.tcdng.unify.core.list.ListManager;

/**
 * Entity field reference search widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-entityfieldrefsearch")
@UplAttributes({ @UplAttribute(name = "typeField", type = String.class, mandatory = true),
        @UplAttribute(name = "entityName", type = String.class, mandatory = true),
        @UplAttribute(name = "appName", type = String.class, mandatory = true),
        @UplAttribute(name = "styleClass", type = String.class, defaultVal = "$e{fc-entitysearch}"),
        @UplAttribute(name = "ref", type = String[].class, defaultVal = "application.appRefRef") })
public class EntityFieldRefSearchWidget extends EntitySearchWidget {

    @Configurable
    private ListManager listManager;

    public void setListManager(ListManager listManager) {
        this.listManager = listManager;
    }

    public String getListkey() throws UnifyException {
        EntityFieldDataType type = getEntityFieldDataType();
        if (type.isEntityRef()) {
            return "longName";
        }

        return getUplAttribute(String.class, "listKey");
    }

    @Override
    protected Listable doCurrentSelect(Object keyVal) throws UnifyException {
        EntityFieldDataType type = getEntityFieldDataType();
        if (type != null) {
            switch (type) {
                case ENUM:
                case ENUM_REF:
                    return listManager.getListItemByKey(getSessionLocale(), "staticlistlist", (String) keyVal);
                case CHILD:
                case CHILD_LIST:
                case REF_FILEUPLOAD:
                case REF:
                case REF_UNLINKABLE:
                    return super.doCurrentSelectByRef(keyVal);
                case LIST_ONLY:
                case BLOB:
                case BOOLEAN:
                case CATEGORY_COLUMN:
                case CLOB:
                case DATE:
                case DECIMAL:
                case DOUBLE:
                case CHAR:
                case FLOAT:
                case FOSTER_PARENT_ID:
                case FOSTER_PARENT_TYPE:
                case INTEGER:
                case LONG:
                case SCRATCH:
                case SHORT:
                case STRING:
                case TIMESTAMP:
                case TIMESTAMP_UTC:
                default:
                    break;
            }
        }

        return null;
    }

    @Override
    protected List<? extends Listable> doSearch(String input, int limit) throws UnifyException {
        EntityFieldDataType type = getEntityFieldDataType();
        if (type != null) {
            switch (type) {
                case ENUM:
                case ENUM_REF:
                    return listManager.getCaseInsensitiveSubList(getApplicationLocale(), "staticlistlist", input,
                            limit);
                case CHILD:
                case CHILD_LIST:
                case REF_FILEUPLOAD: {
                    String entityName = ApplicationNameUtils.getApplicationEntityLongName(
                            getValue(String.class, getUplAttribute(String.class, "appName")),
                            getValue(String.class, getUplAttribute(String.class, "entityName")));
                    Set<String> childEntityList = EntityFieldDataType.REF_FILEUPLOAD.equals(type)
                            ? getApplicationService().findBlobEntities(entityName)
                            : getApplicationService().findChildAppEntities(entityName);
                    if (!childEntityList.isEmpty()) {
                        getWriteWork().set("ref.childentitylist", childEntityList);
                        return getResultByRef(input, limit);
                    }

                    return Collections.emptyList();
                }
                case REF:
                case REF_UNLINKABLE:
                    return getResultByRef(input, limit);
                case LIST_ONLY:
                case BLOB:
                case BOOLEAN:
                case CATEGORY_COLUMN:
                case CLOB:
                case DATE:
                case DECIMAL:
                case DOUBLE:
                case CHAR:
                case FLOAT:
                case FOSTER_PARENT_ID:
                case FOSTER_PARENT_TYPE:
                case INTEGER:
                case LONG:
                case SCRATCH:
                case SHORT:
                case STRING:
                case TIMESTAMP:
                case TIMESTAMP_UTC:
                default:
                    break;
            }
        }

        return Collections.emptyList();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addMoreResultRestriction(Query<? extends Entity> query) throws UnifyException {
        super.addMoreResultRestriction(query);

        Set<String> childEntityList = (Set<String>) getWriteWork().get(Set.class, "ref.childentitylist");
        if (childEntityList != null) {
            query.addAmongst("entity", childEntityList);
        }
    }

    private EntityFieldDataType getEntityFieldDataType() throws UnifyException {
        return getValue(EntityFieldDataType.class, getUplAttribute(String.class, "typeField"));
    }
}
