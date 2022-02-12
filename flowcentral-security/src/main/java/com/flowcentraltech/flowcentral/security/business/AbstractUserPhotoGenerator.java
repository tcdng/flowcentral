/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.security.business;

import java.io.IOException;
import java.io.OutputStream;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.resource.AbstractImageGenerator;
import com.tcdng.unify.core.resource.ImageFormat;

/**
 * Convenient abstract base class for user photo generators.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractUserPhotoGenerator extends AbstractImageGenerator {

    @Configurable
    private SecurityModuleService securityModuleService;

    private byte[] photo;

    public void setSecurityModuleService(SecurityModuleService securityModuleService) {
        this.securityModuleService = securityModuleService;
    }

    @Override
    public ImageFormat generate(OutputStream outputStream) throws UnifyException {
        try {
            outputStream.write(photo);
            outputStream.flush();
        } catch (IOException e) {
            throwOperationErrorException(e);
        } finally {
            photo = null;
        }

        return ImageFormat.WILDCARD;
    }

    @Override
    public boolean isReady() throws UnifyException {
        String userLoginId = getUserLoginId();
        if (userLoginId != null) {
            photo = securityModuleService.findUserPhotograph(userLoginId);
            return photo != null;
        }

        return false;
    }
    
    protected abstract String getUserLoginId() throws UnifyException;

}
