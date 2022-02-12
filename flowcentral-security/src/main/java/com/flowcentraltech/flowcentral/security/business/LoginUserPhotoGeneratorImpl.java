/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.security.business;

import com.flowcentraltech.flowcentral.common.business.LoginUserPhotoGenerator;
import com.flowcentraltech.flowcentral.security.constants.SecurityModuleNameConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;

/**
 * Logged in user photo generator implementation.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(SecurityModuleNameConstants.SECURITY_LOGIN_USER_PHOTO_GENERATOR)
public class LoginUserPhotoGeneratorImpl extends AbstractUserPhotoGenerator implements LoginUserPhotoGenerator {

    @Override
    protected String getUserLoginId() throws UnifyException {
        return getUserToken().getUserLoginId();
    }

}
