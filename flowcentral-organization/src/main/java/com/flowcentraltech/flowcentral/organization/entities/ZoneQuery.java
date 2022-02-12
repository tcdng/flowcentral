/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntityQuery;

/**
 * Query class for zones.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ZoneQuery extends BaseStatusEntityQuery<Zone> {

    public ZoneQuery() {
        super(Zone.class);
    }

    public ZoneQuery code(String code) {
        return (ZoneQuery) addEquals("code", code);
    }

    public ZoneQuery codeLike(String code) {
        return (ZoneQuery) addLike("code", code);
    }

    public ZoneQuery descriptionLike(String description) {
        return (ZoneQuery) addLike("description", description);
    }
}
