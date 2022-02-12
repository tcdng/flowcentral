/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.lists;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractFlowCentralListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.list.ListParam;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Convenient abstract base class for application list commands.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractApplicationListCommand<T extends ListParam> extends AbstractFlowCentralListCommand<T> {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    public AbstractApplicationListCommand(Class<T> paramType) {
        super(paramType);
    }

    public final void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    protected ApplicationModuleService applicationService() {
        return applicationModuleService;
    }

    protected List<? extends Listable> getListables(List<? extends Entity> srcList, String descField)
            throws UnifyException {
        List<ListData> resultList = new ArrayList<ListData>();
        for (Entity entity : srcList) {
            resultList
                    .add(new ListData(entity.getListKey(), DataUtils.getBeanProperty(String.class, entity, descField)));
        }

        return resultList;
    }

    protected List<? extends Listable> getListables(List<? extends Entity> srcList, String keyField, String descField)
            throws UnifyException {
        List<ListData> resultList = new ArrayList<ListData>();
        for (Entity entity : srcList) {
            resultList.add(new ListData(DataUtils.getBeanProperty(String.class, entity, keyField),
                    DataUtils.getBeanProperty(String.class, entity, descField)));
        }

        return resultList;
    }
}
