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
package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.AppletDef;
import com.flowcentraltech.flowcentral.application.data.EntityFormEventHandlers;
import com.flowcentraltech.flowcentral.application.web.panels.AbstractForm.FormMode;
import com.tcdng.unify.core.UnifyException;

/**
 * Create entity applet object.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public class CreateEntityApplet extends AbstractEntityFormApplet {

    public CreateEntityApplet(AppletUtilities au, String pathVariable, EntityFormEventHandlers formEventHandlers)
            throws UnifyException {
        super(au, pathVariable, formEventHandlers);
        currFormAppletDef = getRootAppletDef();
        form = constructNewForm(FormMode.CREATE, null, false);
        viewMode = ViewMode.NEW_PRIMARY_FORM;
    }

    @Override
    protected AppletDef getAlternateFormAppletDef() throws UnifyException {
        return null;
    }
}
