/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.data.LocaleFactoryMaps;
import com.tcdng.unify.core.list.AbstractListCommand;

/**
 * Entity field definition formatter list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("entityfielddefformatterlist")
public class EntityFieldDefFormatterListCommand extends AbstractListCommand<EntityFieldDefListParams> {

    private final LocaleFactoryMaps<EntityFieldDataType, List<? extends Listable>> listMap;

    public EntityFieldDefFormatterListCommand() {
        super(EntityFieldDefListParams.class);
        listMap = new LocaleFactoryMaps<EntityFieldDataType, List<? extends Listable>>() {

            @Override
            protected List<? extends Listable> createObject(Locale locale, EntityFieldDataType fieldType, Object... params)
                    throws Exception {
                List<ListData> list = Collections.emptyList();
                switch(fieldType) {
                    case BLOB:
                    case BOOLEAN:
                    case CATEGORY_COLUMN:
                    case CHAR:
                    case CHILD:
                    case CHILD_LIST:
                    case REF_FILEUPLOAD:
                    case CLOB:
                    case DECIMAL:
                    case DOUBLE:
                    case ENUM:
                    case ENUM_REF:
                    case FLOAT:
                    case FOSTER_PARENT_ID:
                    case FOSTER_PARENT_TYPE:
                    case INTEGER:
                    case LIST_ONLY:
                    case LONG:
                    case REF:
                    case REF_UNLINKABLE:
                    case SCRATCH:
                    case SHORT:
                    case STRING:
                        break;
                    case DATE:
                        list = new ArrayList<ListData>();
                        list.add(new ListData("!fixeddatetimeformat pattern:$s{dd/MM/yyyy}", "dd/MM/yyyy"));
                        list.add(new ListData("!fixeddatetimeformat pattern:$s{MM/dd/yyyy}", "MM/dd/yyyy"));
                        list.add(new ListData("!fixeddatetimeformat pattern:$s{dd-MM-yyyy}", "dd-MM-yyyy"));
                        list.add(new ListData("!fixeddatetimeformat pattern:$s{MM-dd-yyyy}", "MM-dd-yyyy"));
                        list.add(new ListData("!fixeddatetimeformat pattern:$s{yyyy-MM-dd}", "yyyy-MM-dd"));
                        break;
                    case TIMESTAMP:
                    case TIMESTAMP_UTC:
                        list = new ArrayList<ListData>();
                        list.add(new ListData("!fixeddatetimeformat pattern:$s{yyyy-MM-dd HH:mm:ss}", "yyyy-MM-dd HH:mm:ss"));
                        break;
                    default:
                        break;                    
                }
                
                return list;
            }
            
        };
        
    }

    @Override
    public List<? extends Listable> execute(Locale locale, EntityFieldDefListParams params) throws UnifyException {
        if (params.isPresent()) {
            EntityFieldDataType fieldType = params.getEntityDef().getFieldDef(params.getFieldName()).getDataType();
            return listMap.get(locale, fieldType);
        }

        return Collections.emptyList();
    }

}
