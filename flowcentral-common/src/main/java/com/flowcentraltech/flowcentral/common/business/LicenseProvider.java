/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.constants.LicenseStatus;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * License provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface LicenseProvider extends UnifyComponent {

    /**
     * Generates a license request.
     * 
     * @param clientTitle
     *                      the client title
     * @param clientAccount
     *                      the client flowCentral account number.
     * @param requestDt
     *                      the request date
     * @return the generated license
     * @throws UnifyException
     *                        if an error occurs
     */
    byte[] generateLicenseRequest(String clientTitle, String clientAccount, Date requestDt) throws UnifyException;
    
    /**
     * Checks if feature is licensed and unexpired.
     * 
     * @param featureCode
     *                    the feature code
     * @return true if licensed otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean isLicensed(String featureCode) throws UnifyException;

    /**
     * Gets when license for feature will expire.
     * 
     * @param featureCode
     *                    the feature code
     * @return the expiration date
     * @throws UnifyException
     *                        if an error occurs
     */
    Date licensedExpiresOn(String featureCode) throws UnifyException;

    /**
     * Gets the feature license status.
     * 
     * @param featureCode
     *                    the feature code
     * @return the license status
     * @throws UnifyException
     *                        if an error occurs
     */
    LicenseStatus getLicenseStatus(String featureCode) throws UnifyException;
}