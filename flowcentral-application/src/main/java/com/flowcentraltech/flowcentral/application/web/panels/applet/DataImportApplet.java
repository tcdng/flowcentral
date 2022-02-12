/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.tcdng.unify.core.UnifyException;

/**
 * Data import applet.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DataImportApplet extends AbstractApplet {

    private final String importTitle;

    private byte[] uploadFile;

    private boolean hasHeader;

    public DataImportApplet(AppletUtilities au, String appletName) throws UnifyException {
        super(au, appletName);
        importTitle = getRootAppletDef().getLabel();
    }

    public String getImportTitle() {
        return importTitle;
    }

    public byte[] getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(byte[] uploadFile) {
        this.uploadFile = uploadFile;
    }

    public boolean isHasHeader() {
        return hasHeader;
    }

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

}
