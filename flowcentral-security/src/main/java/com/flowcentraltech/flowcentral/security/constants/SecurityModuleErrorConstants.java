/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.constants;

/**
 * Security module error constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface SecurityModuleErrorConstants {

    /** Invalid login ID or password */
    String INVALID_LOGIN_ID_PASSWORD = "SECURITY_0001";

    /** Invalid old password */
    String INVALID_OLD_PASSWORD = "SECURITY_0002";

    /** New password is stale */
    String NEW_PASSWORD_IS_STALE = "SECURITY_0003";

    /** User has no role or role(s) not active at current time */
    String USER_ROLE_NOT_ACTIVE_AT_CURRENTTIME = "SECURITY_0004";

    /** User account is locked */
    String USER_ACCOUNT_IS_LOCKED = "SECURITY_0005";

    /** Login as anonymous is not allowed. */
    String LOGIN_AS_ANONYMOUS_NOT_ALLOWED = "SECURITY_0006";

    /** User account is not active */
    String USER_ACCOUNT_NOT_ACTIVE = "SECURITY_0007";

    /** Invalid one-time password */
    String INVALID_ONETIME_PASSWORD = "SECURITY_0008";

    /** User role {0} has no workspace */
    String USER_ROLE_HAS_NO_WORKSPACE = "SECURITY_0009";

    /** User account is not approved */
    String USER_ACCOUNT_NOT_APPROVED = "SECURITY_000A";
}
