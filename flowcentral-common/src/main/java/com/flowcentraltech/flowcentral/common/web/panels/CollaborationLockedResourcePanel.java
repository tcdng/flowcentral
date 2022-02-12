/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.web.panels;

import com.flowcentraltech.flowcentral.common.constants.FlowCentralRequestAttributeConstants;
import com.flowcentraltech.flowcentral.common.data.CollaborationLockedResourceInfo;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;

/**
 * Panel for collaboration locked resource.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-collaborationlockedresourcepanel")
@UplBinding("web/common/upl/collaborationlockedresourcepanel.upl")
public class CollaborationLockedResourcePanel extends BaseDialogPanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();
        CollaborationLockedResourceInfo collaborationLockedResourceInfo = getValue(
                CollaborationLockedResourceInfo.class);
        setRequestAttribute(FlowCentralRequestAttributeConstants.USER_LOGINID,
                collaborationLockedResourceInfo.getLockedByUserLoginId());
    }

}
