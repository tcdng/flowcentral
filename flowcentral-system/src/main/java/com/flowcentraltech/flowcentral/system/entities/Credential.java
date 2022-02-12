/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Credential entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_CREDENTIAL",
        uniqueConstraints = { @UniqueConstraint({ "name" }), @UniqueConstraint({ "description" }) })
public class Credential extends BaseStatusEntity {

    @Column(length = 64)
    private String name;

    @Column(length = 128)
    private String description;

    @Column(length = 64)
    private String userName;

    @Column(length = 512, transformer = "twoway-stringcryptograph", nullable = true)
    private String password;

    @Override
    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
