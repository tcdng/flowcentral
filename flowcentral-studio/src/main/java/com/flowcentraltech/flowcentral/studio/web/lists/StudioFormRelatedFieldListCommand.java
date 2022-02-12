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

import com.flowcentraltech.flowcentral.application.entities.AppEntityField;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Studio form related field list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioformrelatedfieldlist")
public class StudioFormRelatedFieldListCommand extends AbstractApplicationListCommand<FormAppletParams> {

    public StudioFormRelatedFieldListCommand() {
        super(FormAppletParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, FormAppletParams formAppletParams) throws UnifyException {
        if (formAppletParams.isPresent()) {
            List<AppEntityField> appEntityFieldList = applicationService()
                    .findFormRelatedAppEntityFields(formAppletParams.getFormId(), formAppletParams.getAppletName());
            if (!DataUtils.isBlank(appEntityFieldList)) {
                List<ListData> list = new ArrayList<ListData>();
                for (AppEntityField appEntityField : appEntityFieldList) {
                    list.add(new ListData(appEntityField.getName(), appEntityField.getLabel()));
                }

                return list;
            }
        }

        return Collections.emptyList();
    }

}
