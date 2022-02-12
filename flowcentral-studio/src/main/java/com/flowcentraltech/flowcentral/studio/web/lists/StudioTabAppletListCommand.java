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

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.entities.AppApplet;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;

/**
 * Studio tab applet list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiotabappletlist")
public class StudioTabAppletListCommand extends AbstractApplicationListCommand<AppletParams> {

    public StudioTabAppletListCommand() {
        super(AppletParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, AppletParams params) throws UnifyException {
        if (params.isPresent()) {
            EntityDef entityDef = applicationService().getEntityDef(params.getEntity());
            String childEntity = entityDef.getFieldDef(params.getReference()).getRefDef().getEntity();
            List<ListData> list = new ArrayList<ListData>();
            for (AppApplet appApplet : applicationService().findManageEntityListApplets(childEntity)) {
                list.add(new ListData(ApplicationNameUtils.getApplicationEntityLongName(appApplet.getApplicationName(),
                        appApplet.getName()), appApplet.getDescription()));
            }

            return list;
        }

        return Collections.emptyList();
    }

}
