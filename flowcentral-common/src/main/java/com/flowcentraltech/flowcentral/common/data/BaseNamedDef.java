/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.data;

import com.tcdng.unify.core.data.Listable;

/**
 * Convenient abstract base class for named definitions.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseNamedDef implements Listable {

    private String name;

    private String description;

    private Long id;

    private long version;

    protected BaseNamedDef(String name, String description, Long id, long version) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.version = version;
    }

    @Override
    public String getListDescription() {
        return description;
    }

    @Override
    public String getListKey() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

}
