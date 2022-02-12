/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import java.util.List;

import com.flowcentraltech.flowcentral.application.util.PrivilegeNameUtils;
import com.flowcentraltech.flowcentral.common.data.BaseNamedDef;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Application menu definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ApplicationMenuDef extends BaseNamedDef {

    private String label;

    private String privilege;

    private List<AppletDef> appletDefList;

    public ApplicationMenuDef(String label, String name, String description, Long id, long version,
            List<AppletDef> appletDefList) {
        super(name, description, id, version);
        this.label = label;
        this.privilege = PrivilegeNameUtils.getApplicationPrivilegeName(name);
        this.appletDefList = DataUtils.unmodifiableList(appletDefList);
    }

    public List<AppletDef> getAppletDefList() {
        return appletDefList;
    }

    public String getLabel() {
        return label;
    }

    public String getPrivilege() {
        return privilege;
    }

    @Override
    public String toString() {
        return "ApplicationMenuDef [label=" + label + ", privilege=" + privilege + "]";
    }

}
