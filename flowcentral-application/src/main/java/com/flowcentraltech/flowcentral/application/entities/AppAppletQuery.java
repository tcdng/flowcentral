/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import java.util.Collection;

import com.flowcentraltech.flowcentral.configuration.constants.AppletType;

/**
 * Application applet query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppAppletQuery extends BaseApplicationEntityQuery<AppApplet> {

    public AppAppletQuery() {
        super(AppApplet.class);
    }

    public AppAppletQuery entity(String entity) {
        return (AppAppletQuery) addEquals("entity", entity);
    }

    public AppAppletQuery entityIn(Collection<String> entity) {
        return (AppAppletQuery) addAmongst("entity", entity);
    }

    public AppAppletQuery menuAccess(boolean menuAccess) {
        return (AppAppletQuery) addEquals("menuAccess", menuAccess);
    }

    public AppAppletQuery type(AppletType type) {
        return (AppAppletQuery) addEquals("type", type);
    }

    public AppAppletQuery typeNotIn(Collection<AppletType> type) {
        return (AppAppletQuery) addNotAmongst("type", type);
    }

    public AppAppletQuery typeIn(Collection<AppletType> type) {
        return (AppAppletQuery) addAmongst("type", type);
    }

    public AppAppletQuery unreserved() {
        return (AppAppletQuery) addAmongst("type", AppletType.UNRESERVED_LIST);
    }

}
