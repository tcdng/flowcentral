/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.constants;

import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Application auxiliary version.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class ApplicationAuxiliaryVersion implements com.tcdng.unify.core.application.ApplicationAuxiliaryVersion {

    @Override
    public String getAuxiliaryVersion() {
        return "1.0.0";
    }

}
