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
package com.flowcentraltech.flowcentral.application.data;

import java.util.List;

import com.flowcentraltech.flowcentral.application.util.PrivilegeNameUtils;
import com.flowcentraltech.flowcentral.common.data.BaseNamedDef;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Application menu definition.
 * 
 * @author FlowCentral Technologies Limited
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
