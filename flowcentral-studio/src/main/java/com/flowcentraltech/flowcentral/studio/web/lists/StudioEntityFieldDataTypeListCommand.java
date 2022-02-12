/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.data.LocaleFactoryMap;
import com.tcdng.unify.core.list.ListManager;

/**
 * Studio entity field data type list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioentityfielddatatypelist")
public class StudioEntityFieldDataTypeListCommand extends AbstractApplicationListCommand<EntityFieldTypeParams> {

    @Configurable
    private ListManager listManager;

    private List<EntityFieldDataType> supportedTypeList = Collections
            .unmodifiableList(Arrays.asList(EntityFieldDataType.REF, EntityFieldDataType.REF_UNLINKABLE, EntityFieldDataType.REF_FILEUPLOAD,
                    EntityFieldDataType.ENUM_REF, EntityFieldDataType.ENUM, EntityFieldDataType.LIST_ONLY,
                    EntityFieldDataType.CHILD, EntityFieldDataType.CHILD_LIST,
                    EntityFieldDataType.STRING, EntityFieldDataType.CHAR, EntityFieldDataType.BOOLEAN,
                    EntityFieldDataType.LONG, EntityFieldDataType.INTEGER, EntityFieldDataType.SHORT,
                    EntityFieldDataType.DECIMAL, EntityFieldDataType.DOUBLE, EntityFieldDataType.FLOAT,
                    EntityFieldDataType.DATE, EntityFieldDataType.TIMESTAMP, EntityFieldDataType.TIMESTAMP_UTC,
                    EntityFieldDataType.CLOB, EntityFieldDataType.BLOB));

    private LocaleFactoryMap<List<Listable>> listFactory;

    public StudioEntityFieldDataTypeListCommand() {
        super(EntityFieldTypeParams.class);
        listFactory = new LocaleFactoryMap<List<Listable>>()
            {

                @Override
                protected List<Listable> create(Locale locale, Object... arg1) throws Exception {
                    List<Listable> list = new ArrayList<Listable>();
                    Map<String, Listable> map = listManager.getListMap(locale, "entityfielddatatypelist");
                    for (EntityFieldDataType type : supportedTypeList) {
                        list.add(map.get(type.code()));
                    }

                    return Collections.unmodifiableList(list);
                }

            };
    }

    public void setListManager(ListManager listManager) {
        this.listManager = listManager;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, EntityFieldTypeParams params) throws UnifyException {
        if (params.isPresent()) {
            if (params.getType().isCustom()) {
                return listFactory.get(locale);
            }
        }

        return listManager.getList(locale, "entityfielddatatypelist");
    }

}
