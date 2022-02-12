/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.business;

import com.flowcentraltech.flowcentral.configuration.data.ModuleInstall;
import com.tcdng.unify.core.application.FeatureInstaller;
import com.tcdng.unify.core.business.BusinessService;

/**
 * Flowcentral service interface.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface FlowCentralService extends BusinessService, FeatureInstaller<ModuleInstall> {

}
