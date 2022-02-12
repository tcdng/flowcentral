/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.web.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyComponentConfig;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.AbstractListCommand;
import com.tcdng.unify.core.list.ListParam;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Convenient abstract base class for flowCentral type list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractFlowCentralTypeListCommand<T extends UnifyComponent, U extends ListParam>
        extends AbstractListCommand<U> {

    private Class<T> typeClass;

    private List<UnifyComponentConfig> configList;

    public AbstractFlowCentralTypeListCommand(Class<T> typeClazz, Class<U> paramClazz) {
        super(paramClazz);
        this.typeClass = typeClazz;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, U params) throws UnifyException {
        List<UnifyComponentConfig> filteredList = filterList(getConfigList(), params);
        if (!DataUtils.isBlank(filteredList)) {
            List<Listable> list = new ArrayList<Listable>();
            for (UnifyComponentConfig unifyComponentConfig : filteredList) {
                String description = unifyComponentConfig.getDescription() != null
                        ? resolveSessionMessage(unifyComponentConfig.getDescription())
                        : unifyComponentConfig.getName();
                list.add(new ListData(unifyComponentConfig.getName(), description));
            }
            DataUtils.sortAscending(list, Listable.class, "listDescription");
            return list;
        }
        return Collections.emptyList();
    }

    protected abstract List<UnifyComponentConfig> filterList(List<UnifyComponentConfig> baseConfigList, U params)
            throws UnifyException;

    private List<UnifyComponentConfig> getConfigList() throws UnifyException {
        if (configList == null) {
            configList = DataUtils.unmodifiableList(getComponentConfigs(typeClass));
        }

        return configList;
    }
}
