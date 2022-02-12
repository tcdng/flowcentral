/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.data;

/**
 * Credential definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class CredentialDef {

    private String credName;

    private String userName;

    private String password;

    private long versionNo;

    public CredentialDef(String credName, String userName, String password, long versionNo) {
        this.credName = credName;
        this.userName = userName;
        this.password = password;
        this.versionNo = versionNo;
    }

    public String getCredName() {
        return credName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public long getVersionNo() {
        return versionNo;
    }
}
