/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.constants.OwnershipType;
import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;
import com.tcdng.unify.core.criterion.And;
import com.tcdng.unify.core.criterion.Equals;
import com.tcdng.unify.core.criterion.Or;

/**
 * Application applet filter query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppAppletFilterQuery extends BaseConfigNamedEntityQuery<AppAppletFilter> {

    public AppAppletFilterQuery() {
        super(AppAppletFilter.class);
    }

    public AppAppletFilterQuery appAppletId(Long appAppletId) {
        return (AppAppletFilterQuery) addEquals("appAppletId", appAppletId);
    }

    public AppAppletFilterQuery byOwner(String ownerId) {
        return (AppAppletFilterQuery) addRestriction(new Or().add(new Equals("ownershipType", OwnershipType.GLOBAL))
                .add(new And().add(new Equals("ownershipType", OwnershipType.USER)).add(new Equals("owner", ownerId))));
    }

    public AppAppletFilterQuery quickFilter(boolean quickFilter) {
        return (AppAppletFilterQuery) addEquals("quickFilter", quickFilter);
    }

}
