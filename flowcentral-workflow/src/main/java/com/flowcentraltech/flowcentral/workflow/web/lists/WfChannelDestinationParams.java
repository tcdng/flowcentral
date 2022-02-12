/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.web.lists;

import com.flowcentraltech.flowcentral.configuration.constants.ChannelDirectionType;
import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Workflow channel destination  parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfChannelDestinationParams extends AbstractListParam {

    private ChannelDirectionType direction;

    private String entity;
    
    public WfChannelDestinationParams(ChannelDirectionType direction, String entity) {
        this.direction = direction;
        this.entity = entity;
    }

    public ChannelDirectionType getDirection() {
        return direction;
    }

    public String getEntity() {
        return entity;
    }

    @Override
    public boolean isPresent() {
        return direction != null && entity != null;
    }

}
