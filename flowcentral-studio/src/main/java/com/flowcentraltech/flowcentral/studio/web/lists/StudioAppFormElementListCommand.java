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

import com.flowcentraltech.flowcentral.application.entities.AppFormElement;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Studio form element list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioformelementlist")
public class StudioAppFormElementListCommand extends AbstractApplicationListCommand<FormElementParams> {

    public StudioAppFormElementListCommand() {
        super(FormElementParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, FormElementParams formElementParams) throws UnifyException {
        if (formElementParams.isPresent()) {
            List<AppFormElement> appEntityFieldList = applicationService()
                    .findAppFormElementsByStatePolicy(formElementParams.getParentId(), formElementParams.getType());
            if (!DataUtils.isBlank(appEntityFieldList)) {
                List<ListData> list = new ArrayList<ListData>();
                for (AppFormElement appEntityField : appEntityFieldList) {
                    list.add(new ListData(appEntityField.getElementName(), appEntityField.getElementName()));
                }

                return list;
            }
        }

        return Collections.emptyList();
    }

}
