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

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.notification.business.NotificationModuleService;
import com.flowcentraltech.flowcentral.notification.entities.NotificationTemplateQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.StringParam;

/**
 * Workflow editor notification template list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("wfeditnotiftemplatelist")
public class WfEditNotifTemplateListCommand extends AbstractApplicationListCommand<StringParam> {

    @Configurable
    private NotificationModuleService notificationModuleService;

    public WfEditNotifTemplateListCommand() {
        super(StringParam.class);
    }

    public void setNotificationModuleService(NotificationModuleService notificationModuleService) {
        this.notificationModuleService = notificationModuleService;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, StringParam param) throws UnifyException {
        if (param.isPresent()) {
            return ApplicationNameUtils.getListableList(notificationModuleService
                    .findNotificationTemplates((NotificationTemplateQuery) new NotificationTemplateQuery()
                            .entity(param.getValue()).addSelect("name", "description", "applicationName")));
        }

        return Collections.emptyList();
    }

}
