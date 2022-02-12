/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.web.controllers;

import java.util.Collections;
import java.util.List;

import com.flowcentraltech.flowcentral.system.data.LicenseDef;
import com.flowcentraltech.flowcentral.system.data.LicenseEntryDef;
import com.tcdng.unify.web.ui.AbstractPageBean;

/**
 * Licensing page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class LicensingPageBean extends AbstractPageBean {

    private LicenseDef licenseDef;

    private String formClientTitle;

    private String formAccountNo;
    
    private byte[] licenseFile;

    public LicenseDef getLicenseDef() {
        return licenseDef;
    }

    public void setLicenseDef(LicenseDef licenseDef) {
        this.licenseDef = licenseDef;
    }

    public String getType() {
        return licenseDef != null? licenseDef.getType() : null;
    }

    public String getClientTitle() {
        return licenseDef != null? licenseDef.getClientTitle() : null;
    }

    public List<LicenseEntryDef> getEntryList() {
        return licenseDef != null? licenseDef.getEntryList() : Collections.emptyList();
    }

    public String getFormClientTitle() {
        return formClientTitle;
    }

    public void setFormClientTitle(String formClientTitle) {
        this.formClientTitle = formClientTitle;
    }

    public String getFormAccountNo() {
        return formAccountNo;
    }

    public void setFormAccountNo(String formAccountNo) {
        this.formAccountNo = formAccountNo;
    }

    public byte[] getLicenseFile() {
        return licenseFile;
    }

    public void setLicenseFile(byte[] licenseFile) {
        this.licenseFile = licenseFile;
    }
    
}
