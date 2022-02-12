/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.constants;

/**
 * Security module system parameter constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface SecurityModuleSysParamConstants {

    String ENABLE_PASSWORD_HISTORY = "SEC-0001";

    String PASSWORD_HISTORY_LENGTH = "SEC-0002";

    String ENABLE_PASSWORD_EXPIRY = "SEC-0003";

    String PASSWORD_EXPIRY_DAYS = "SEC-0004";

    String ENABLE_ACCOUNT_LOCKING = "SEC-0005";

    String MAXIMUM_LOGIN_TRIES = "SEC-0006";

    String USER_PASSWORD_GENERATOR = "SEC-0007";

    String USER_PASSWORD_LENGTH = "SEC-0008";

    String USER_PASSWORD_SEND_EMAIL = "SEC-0009";

    String USER_DEFAULT_APPLICATION = "SEC-000A";

    String ENABLE_TWOFACTOR_AUTHENTICATION = "SEC-000B";

    String ENABLE_SYSTEMWIDE_MULTILOGIN_RULE = "SEC-000C";

    String SYSTEMWIDE_MULTILOGIN = "SEC-000D";

    String APPLICATION_SECURITY_KEY = "SEC-000E";

    String ADMINISTRATOR_EMAIL = "SEC-000F";

    String ADMINISTRATOR_NAME = "SEC-0010";

    String USE_LOGIN_LOCALE = "SEC-0011";

}
