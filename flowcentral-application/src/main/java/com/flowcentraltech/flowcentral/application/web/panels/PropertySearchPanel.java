/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.common.business.ApplicationPrivilegeManager;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.ui.widget.AbstractPanel;

/**
 * Property search panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-propertysearchpanel")
@UplBinding("web/application/upl/propertysearchpanel.upl")
public class PropertySearchPanel extends AbstractPanel {

    @Configurable
    private ApplicationPrivilegeManager applicationPrivilegeManager;

    public void setApplicationPrivilegeManager(ApplicationPrivilegeManager applicationPrivilegeManager) {
        this.applicationPrivilegeManager = applicationPrivilegeManager;
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        PropertySearch propertySearch = getPropertySearch();
        String roleCode = getUserToken().getRoleCode();
        EntityDef parentEntityDef = propertySearch.getPropertyRuleDef().getEntityDef();
        setVisible("editBtn", propertySearch.isEditButtonVisible()
                && applicationPrivilegeManager.isRoleWithPrivilege(roleCode, parentEntityDef.getEditPrivilege()));
        setVisible("viewBtn", propertySearch.isViewButtonVisible()
                && applicationPrivilegeManager.isRoleWithPrivilege(roleCode, parentEntityDef.getEditPrivilege()));
    }

    private PropertySearch getPropertySearch() throws UnifyException {
        return getValue(PropertySearch.class);
    }
}
