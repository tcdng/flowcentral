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

import com.flowcentraltech.flowcentral.application.data.RefDef;
import com.flowcentraltech.flowcentral.application.entities.AppEntityField;
import com.flowcentraltech.flowcentral.application.entities.AppEntityFieldQuery;
import com.flowcentraltech.flowcentral.application.entities.AppRefQuery;
import com.flowcentraltech.flowcentral.application.util.ApplicationEntityNameParts;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Studio entity field input reference list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioentityfieldinputreflist")
public class StudioEntityFieldInputRefListCommand extends AbstractApplicationListCommand<StudioEntityFieldFormParams> {

    public StudioEntityFieldInputRefListCommand() {
        super(StudioEntityFieldFormParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, StudioEntityFieldFormParams params) throws UnifyException {
        if (params.isPresent()) {
            EntityFieldDataType type = DataUtils.convert(EntityFieldDataType.class, params.getDataType());
            if (type.isForeignKey() && !type.isEnumDataType()) {
                ApplicationEntityNameParts np = ApplicationNameUtils.getApplicationEntityNameParts(params.getEntity());
                AppEntityField appEntityField = applicationService().findAppEntityField(
                        (AppEntityFieldQuery) new AppEntityFieldQuery().applicationName(np.getApplicationName())
                                .appEntityName(np.getEntityName()).name(params.getName()));
                RefDef _refDef = applicationService().getRefDef(appEntityField.getReferences());
                AppRefQuery query = new AppRefQuery();
                query.entity(_refDef.getEntity());
                query.addSelect("applicationName", "name", "description");
                return ApplicationNameUtils.getListableList(applicationService().findAppRefs(query));
            }
        }

        return Collections.emptyList();
    }

}
