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
import com.flowcentraltech.flowcentral.application.data.EntityFieldDef;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.configuration.constants.TabContentType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;

/**
 * Studio tab reference list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiotabreferencelist")
public class StudioTabReferenceListCommand extends AbstractApplicationListCommand<ReferenceParams> {

    public StudioTabReferenceListCommand() {
        super(ReferenceParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ReferenceParams params) throws UnifyException {
        if (params.isPresent()) {
            final TabContentType type = params.getType();
            if (TabContentType.CHILD.equals(type) || TabContentType.CHILD_LIST.equals(type)) {
                EntityDef entityDef = applicationService().getEntityDef(params.getEntity());
                List<EntityFieldDef> list = new ArrayList<EntityFieldDef>();
                if (TabContentType.CHILD.equals(type)) {
                    for (EntityFieldDef entityFieldDef : entityDef.getFieldDefList()) {
                        if (entityFieldDef.isChild()) {
                            list.add(entityFieldDef);
                        }
                    }
                } else {
                    for (EntityFieldDef entityFieldDef : entityDef.getFieldDefList()) {
                        if (entityFieldDef.isChildList()) {
                            list.add(entityFieldDef);
                        }
                    }
                }

                return list;
            }
        }

        return Collections.emptyList();
    }

}
