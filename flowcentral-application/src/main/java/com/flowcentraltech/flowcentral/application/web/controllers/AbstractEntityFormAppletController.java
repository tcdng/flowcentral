/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.AbstractEntityFormApplet;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.annotation.ResultMapping;
import com.tcdng.unify.web.annotation.ResultMappings;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;

/**
 * Abstract base class for entity form applet controllers.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@ResultMappings({ @ResultMapping(name = "refreshapplet",
        response = { "!hidepopupresponse", "!refreshpanelresponse panels:$l{appletPanel}" }) })
public abstract class AbstractEntityFormAppletController<T extends AbstractEntityFormApplet, U extends AbstractEntityFormAppletPageBean<T>>
        extends AbstractAppletController<U> {

    public AbstractEntityFormAppletController(Class<U> pageBeanClass, Secured secured, ReadOnly readOnly,
            ResetOnWrite resetOnWrite) {
        super(pageBeanClass, secured, readOnly, resetOnWrite);
    }

    @Action
    public String newChildItem() throws UnifyException {
        AbstractEntityFormAppletPageBean<T> pageBean = getPageBean();
        AbstractEntityFormApplet applet = pageBean.getApplet();
        int childTabIndex = getRequestTarget(int.class);
        applet.newChildItem(childTabIndex);
        return "refreshapplet";
    }

    @Action
    public String newChildListItem() throws UnifyException {
        AbstractEntityFormAppletPageBean<T> pageBean = getPageBean();
        AbstractEntityFormApplet applet = pageBean.getApplet();
        int childTabIndex = getRequestTarget(int.class);
        applet.newChildListItem(childTabIndex);
        return "refreshapplet";
    }

    @Action
    public String editChildItem() throws UnifyException {
        AbstractEntityFormAppletPageBean<T> pageBean = getPageBean();
        AbstractEntityFormApplet applet = pageBean.getApplet();
        int childTabIndex = getRequestTarget(int.class);
        applet.editChildItem(childTabIndex);
        return "refreshapplet";
    }

    @Action
    public String assignToChildItem() throws UnifyException {
        AbstractEntityFormAppletPageBean<T> pageBean = getPageBean();
        AbstractEntityFormApplet applet = pageBean.getApplet();
        int childTabIndex = getRequestTarget(int.class);
        applet.assignToChildItem(childTabIndex);
        return "refreshapplet";
    }

    @Action
    public String newRelatedItem() throws UnifyException {
        AbstractEntityFormAppletPageBean<T> pageBean = getPageBean();
        AbstractEntityFormApplet applet = pageBean.getApplet();
        String relatedListName = getRequestTarget(String.class);
        applet.newRelatedListItem(relatedListName);
        return "refreshapplet";
    }

    @Action
    public String newHeadlessItem() throws UnifyException {
        AbstractEntityFormAppletPageBean<T> pageBean = getPageBean();
        AbstractEntityFormApplet applet = pageBean.getApplet();
        String appletName = getRequestTarget(String.class);
        applet.newHeadlessListItem(appletName);
        return "refreshapplet";
    }

    @Action
    public String assignToRelatedItem() throws UnifyException {
        AbstractEntityFormAppletPageBean<T> pageBean = getPageBean();
        AbstractEntityFormApplet applet = pageBean.getApplet();
        String relatedListName = getRequestTarget(String.class);
        applet.assignToRelatedListItem(relatedListName);
        return "refreshapplet";
    }

    @Action
    public String manageProperties() throws UnifyException {
        AbstractEntityFormAppletPageBean<T> pageBean = getPageBean();
        AbstractEntityFormApplet applet = pageBean.getApplet();
        int childTabIndex = getRequestTarget(int.class);
        applet.prepareItemProperties(childTabIndex);
        return "refreshapplet";
    }

}
