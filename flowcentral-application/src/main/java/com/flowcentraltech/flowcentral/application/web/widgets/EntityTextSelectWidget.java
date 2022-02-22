/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.constants.ApplicationResultMappingConstants;
import com.flowcentraltech.flowcentral.application.data.RefDef;
import com.flowcentraltech.flowcentral.application.data.TableDef;
import com.flowcentraltech.flowcentral.application.web.panels.EntitySelect;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.flowcentraltech.flowcentral.common.constants.FlowCentralSessionAttributeConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplAttribute;
import com.tcdng.unify.core.annotation.UplAttributes;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.constant.ExtensionType;
import com.tcdng.unify.web.ui.widget.control.AbstractPopupTextField;

/**
 * Entity text select widget.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
@Component("fc-entitytextselect")
@UplAttributes({ @UplAttribute(name = "limit", type = int.class, defaultVal = "20"),
        @UplAttribute(name = "ref", type = String.class, mandatory = true),
        @UplAttribute(name = "buttonImgSrc", type = String.class, defaultVal = "$t{images/search.png}"),
        @UplAttribute(name = "buttonSymbol", type = String.class, defaultVal = "table-list"),
        @UplAttribute(name = "listKey", type = String.class) })
public class EntityTextSelectWidget extends AbstractPopupTextField {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    @Configurable
    private AppletUtilities appletUtilities;

    @Configurable
    private EnvironmentService environmentService;

    public final void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    public final void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    public void setAppletUtilities(AppletUtilities appletUtilities) {
        this.appletUtilities = appletUtilities;
    }

    @Action
    public final void search() throws UnifyException {
        String input = getRequestTarget(String.class);
        RefDef refDef = getRefDef();
        TableDef tableDef = applicationModuleService.getTableDef(refDef.getSearchTable());
        int limit = getUplAttribute(int.class, "limit");
        EntitySelect entitySelect = new EntitySelect(appletUtilities, tableDef, refDef.getSearchField(),
                getValueStore(), refDef.getSelectHandler(), limit);
        String label = tableDef.getEntityDef().getFieldDef(refDef.getSearchField()).getFieldLabel() + ":";
        entitySelect.setLabel(label);
        if (input != null && !input.trim().isEmpty()) {
            entitySelect.setFilter(input);
        }

        entitySelect.applyFilterToSearch();
        setSessionAttribute(FlowCentralSessionAttributeConstants.ENTITYSELECT, entitySelect);
        setCommandResultMapping(ApplicationResultMappingConstants.SHOW_ENTITY_SELECT);
    }

    @Override
    public ExtensionType getExtensionType() {
        return ExtensionType.FACADE_HIDDEN_EDIT;
    }

    @Override
    public boolean isPopupOnEditableOnly() {
        return true;
    }

    @Override
    public boolean isUseFacade() throws UnifyException {
        return true;
    }

    @Override
    public boolean isBindEventsToFacade() throws UnifyException {
        return false;
    }

    public String getRef() throws UnifyException {
        return getUplAttribute(String.class, "ref");
    }

    public String getListkey() throws UnifyException {
        return getUplAttribute(String.class, "listKey");
    }

    public Listable getCurrentSelect() throws UnifyException {
        Object keyVal = getValue(Object.class);
        if (keyVal != null) {
            String val = String.valueOf(keyVal);
            return new ListData(val, val);
        }

        return null;
    }

    private RefDef getRefDef() throws UnifyException {
        return applicationModuleService.getRefDef(getRef());
    }
}
