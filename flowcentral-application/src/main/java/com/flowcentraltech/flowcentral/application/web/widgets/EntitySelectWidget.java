/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.constants.ApplicationResultMappingConstants;
import com.flowcentraltech.flowcentral.application.data.EntityClassDef;
import com.flowcentraltech.flowcentral.application.data.RefDef;
import com.flowcentraltech.flowcentral.application.data.TableDef;
import com.flowcentraltech.flowcentral.application.policies.EntityBasedFilterGenerator;
import com.flowcentraltech.flowcentral.application.web.panels.EntitySelect;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.flowcentraltech.flowcentral.common.constants.FlowCentralSessionAttributeConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplAttribute;
import com.tcdng.unify.core.annotation.UplAttributes;
import com.tcdng.unify.core.criterion.Restriction;
import com.tcdng.unify.core.data.BeanValueStore;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.constant.ExtensionType;
import com.tcdng.unify.web.ui.widget.control.AbstractPopupTextField;

/**
 * Entity select widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-entityselect")
@UplAttributes({ @UplAttribute(name = "limit", type = int.class, defaultVal = "20"),
        @UplAttribute(name = "ref", type = String.class, mandatory = true),
        @UplAttribute(name = "buttonImgSrc", type = String.class, defaultVal = "$t{images/search.png}"),
        @UplAttribute(name = "buttonSymbol", type = String.class, defaultVal = "search"),
        @UplAttribute(name = "listKey", type = String.class) })
public class EntitySelectWidget extends AbstractPopupTextField {

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
        RefDef refDef = getRefDef();
        TableDef tableDef = applicationModuleService.getTableDef(refDef.getSearchTable());
        int limit = getUplAttribute(int.class, "limit");
        EntitySelect entitySelect = new EntitySelect(appletUtilities, tableDef, refDef.getSearchField(), limit);
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
            Listable select = doCurrentSelect(keyVal);
            if (select != null) {
                return select;
            }

            setValue(null);
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    private Listable doCurrentSelect(Object keyVal) throws UnifyException {
        logDebug("Decoding reference value [{0}]...", keyVal);
        RefDef refDef = getRefDef();
        final EntityClassDef entityClassDef = applicationModuleService.getEntityClassDef(refDef.getEntity());
        Query<? extends Entity> query = null;
        Restriction br = null;
        if (refDef.isWithFilterGenerator()) {
            br = ((EntityBasedFilterGenerator) getComponent(refDef.getFilterGenerator()))
                    .generate(getValueStore().getReader(), refDef.getFilterGeneratorRule());
        } else {
            br = refDef.isWithFilter()
                    ? refDef.getFilter().getRestriction(entityClassDef.getEntityDef(), null,
                            applicationModuleService.getNow())
                    : null;
        }

        if (br != null) {
            query = Query.ofDefaultingToAnd((Class<? extends Entity>) entityClassDef.getEntityClass(), br);
        } else {
            query = Query.of((Class<? extends Entity>) entityClassDef.getEntityClass());
        }

        String listKey = getListkey();
        if (StringUtils.isBlank(listKey)) {
            query.addEquals("id", keyVal);
        } else {
            query.addEquals(listKey, keyVal);
        }

        Listable result = environmentService.listLean(query);
        if (result != null) {
            String formatDesc = refDef.isWithListFormat()
                    ? StringUtils.buildParameterizedString(refDef.getListFormat(), new BeanValueStore(result))
                    : applicationModuleService.getEntityDescription(entityClassDef, (Entity) result,
                            refDef.getSearchField());
            return new ListData(result.getListKey(), formatDesc);
        }

        return result;
    }

    private RefDef getRefDef() throws UnifyException {
        return applicationModuleService.getRefDef(getRef());
    }
}