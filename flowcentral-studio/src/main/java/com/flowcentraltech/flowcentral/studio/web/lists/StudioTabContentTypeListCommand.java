/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.configuration.constants.TabContentType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.data.LocaleFactoryMap;
import com.tcdng.unify.core.list.ListManager;
import com.tcdng.unify.core.list.ZeroParams;

/**
 * Studio tab content type list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiotabcontenttypelist")
public class StudioTabContentTypeListCommand extends AbstractApplicationListCommand<ZeroParams> {

    @Configurable
    private ListManager listManager;

    private LocaleFactoryMap<List<Listable>> listFactory;

    public StudioTabContentTypeListCommand() {
        super(ZeroParams.class);
        listFactory = new LocaleFactoryMap<List<Listable>>()
            {

                @Override
                protected List<Listable> create(Locale locale, Object... arg1) throws Exception {
                    List<Listable> list = new ArrayList<Listable>();
                    Map<String, Listable> map = listManager.getListMap(locale, "tabcontenttypelist");
                    for (TabContentType type : TabContentType.values()) {
                        Listable listable = map.get(type.code());
                        list.add(new ListData(type.name(), listable.getListDescription()));
                    }

                    return Collections.unmodifiableList(list);
                }

            };
    }

    public void setListManager(ListManager listManager) {
        this.listManager = listManager;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ZeroParams zeroParams) throws UnifyException {
        return listFactory.get(locale);
    }

}
