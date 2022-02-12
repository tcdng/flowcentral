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
import com.flowcentraltech.flowcentral.configuration.constants.FormElementType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Studio form state field list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioformstatefieldlist")
public class StudioAppFormStateFieldListCommand extends AbstractApplicationListCommand<LongParam> {

    public StudioAppFormStateFieldListCommand() {
        super(LongParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam param) throws UnifyException {
        if (param.isPresent()) {
            List<AppFormElement> appEntityFieldList = applicationService()
                    .findAppFormElementsByFormId(param.getValue(), FormElementType.FIELD);
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
