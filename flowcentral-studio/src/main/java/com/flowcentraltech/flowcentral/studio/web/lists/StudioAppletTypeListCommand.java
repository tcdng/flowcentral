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
import com.flowcentraltech.flowcentral.configuration.constants.AppletType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.data.LocaleFactoryMap;
import com.tcdng.unify.core.list.ListManager;

/**
 * Studio applet type list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioapplettypelist")
public class StudioAppletTypeListCommand extends AbstractApplicationListCommand<ConfigTypeParams> {

    private static final List<AppletType> CREATABLE_APPLETTYPE_LIST = Collections
            .unmodifiableList(Arrays.asList(AppletType.MANAGE_ENTITYLIST, AppletType.MANAGE_ENTITYLIST_ASSIGN,
                    AppletType.MANAGE_ENTITYLIST_SINGLEFORM, AppletType.HEADLESS_TABS, AppletType.CREATE_ENTITY,
                    AppletType.CREATE_ENTITY_SINGLEFORM, AppletType.TASK_EXECUTION, AppletType.DATA_IMPORT,
                    AppletType.FACADE, AppletType.PATH_WINDOW, AppletType.PATH_PAGE));

    @Configurable
    private ListManager listManager;

    private LocaleFactoryMap<List<Listable>> listFactory;

    public StudioAppletTypeListCommand() {
        super(ConfigTypeParams.class);
        listFactory = new LocaleFactoryMap<List<Listable>>()
            {

                @Override
                protected List<Listable> create(Locale locale, Object... arg1) throws Exception {
                    List<Listable> list = new ArrayList<Listable>();
                    Map<String, Listable> map = listManager.getListMap(locale, "applettypelist");
                    for (AppletType type : CREATABLE_APPLETTYPE_LIST) {
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
    public List<? extends Listable> execute(Locale locale, ConfigTypeParams params) throws UnifyException {
        if (params.isPresent()) {
            if (params.getType().isStatic()) {
                return listManager.getList(locale, "applettypelist");
            }
        }

        return listFactory.get(locale);
    }

}
