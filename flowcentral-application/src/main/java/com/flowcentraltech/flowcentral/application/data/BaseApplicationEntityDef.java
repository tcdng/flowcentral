/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

import com.flowcentraltech.flowcentral.application.util.ApplicationEntityNameParts;
import com.tcdng.unify.core.data.Listable;

/**
 * Base class for application entity definition
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseApplicationEntityDef implements Listable {

    private ApplicationEntityNameParts nameParts;

    private String description;

    private Long id;

    private long version;

    public BaseApplicationEntityDef(ApplicationEntityNameParts nameParts, String description, Long id, long version) {
        this.nameParts = nameParts;
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
        return nameParts.getLongName();
    }

    public ApplicationEntityNameParts getNameParts() {
        return nameParts;
    }

    public String getLongName() {
        return nameParts.getLongName();
    }

    public String getApplicationName() {
        return nameParts.getApplicationName();
    }

    public String getName() {
        return nameParts.getEntityName();
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
