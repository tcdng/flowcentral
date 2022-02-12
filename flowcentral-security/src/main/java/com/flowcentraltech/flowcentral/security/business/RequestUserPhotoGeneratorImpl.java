/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.security.business;

import com.flowcentraltech.flowcentral.common.business.RequestUserPhotoGenerator;
import com.flowcentraltech.flowcentral.common.constants.FlowCentralRequestAttributeConstants;
import com.flowcentraltech.flowcentral.security.constants.SecurityModuleNameConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;

/**
 * Request user photo generator implementation.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(SecurityModuleNameConstants.SECURITY_REQUEST_USER_PHOTO_GENERATOR)
public class RequestUserPhotoGeneratorImpl extends AbstractUserPhotoGenerator implements RequestUserPhotoGenerator {

    @Override
    protected String getUserLoginId() throws UnifyException {
        return (String) getRequestAttribute(FlowCentralRequestAttributeConstants.USER_LOGINID);
    }

}
