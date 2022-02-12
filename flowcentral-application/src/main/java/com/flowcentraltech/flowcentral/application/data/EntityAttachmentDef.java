/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import com.tcdng.unify.core.constant.FileAttachmentType;
import com.tcdng.unify.core.data.Listable;

/**
 * Entity attachment definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityAttachmentDef implements Listable {

    private FileAttachmentType type;

    private String name;

    private String description;

    public EntityAttachmentDef(FileAttachmentType type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
    }

    @Override
    public String getListDescription() {
        return description;
    }

    @Override
    public String getListKey() {
        return name;
    }

    public FileAttachmentType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
