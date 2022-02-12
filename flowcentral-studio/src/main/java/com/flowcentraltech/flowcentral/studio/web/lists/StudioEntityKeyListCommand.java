/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.entities.AppEntityFieldQuery;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;

/**
 * Studio entity key list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("entitykeylist")
public class StudioEntityKeyListCommand extends AbstractApplicationListCommand<LongParam> {

    public StudioEntityKeyListCommand() {
        super(LongParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam params) throws UnifyException {
        if (params.isPresent()) {
            return applicationService()
                    .findAppEntityFields((AppEntityFieldQuery) new AppEntityFieldQuery()
                            .appEntityId(params.getValue()).dataTypeIn(EntityFieldDataType.ENUM_REF,
                                    EntityFieldDataType.REF, EntityFieldDataType.REF_UNLINKABLE)
                            .addSelect("id", "name").addOrder("name"));
        }

        return Collections.emptyList();
    }

}
