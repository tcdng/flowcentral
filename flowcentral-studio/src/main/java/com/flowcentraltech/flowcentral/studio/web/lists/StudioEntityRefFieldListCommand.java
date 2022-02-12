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
import com.flowcentraltech.flowcentral.application.util.ApplicationEntityNameParts;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.StringParam;

/**
 * Studio entity reference field list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioentityreffieldlist")
public class StudioEntityRefFieldListCommand extends AbstractApplicationListCommand<StringParam> {

    public StudioEntityRefFieldListCommand() {
        super(StringParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, StringParam params) throws UnifyException {
        if (params.isPresent()) {
            ApplicationEntityNameParts np = ApplicationNameUtils.getApplicationEntityNameParts(params.getValue());
            return applicationService().findAppEntityFields(
                    (AppEntityFieldQuery) new AppEntityFieldQuery().applicationName(np.getApplicationName())
                            .appEntityName(np.getEntityName()).dataType(EntityFieldDataType.REF).addSelect("name"));
        }

        return Collections.emptyList();
    }

}
