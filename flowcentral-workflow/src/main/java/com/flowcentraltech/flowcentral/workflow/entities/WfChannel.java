/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntity;
import com.flowcentraltech.flowcentral.configuration.constants.ChannelDirectionType;
import com.flowcentraltech.flowcentral.workflow.constants.WfChannelStatus;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application workflow channel entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_WORKCHANNEL")
public class WfChannel extends BaseApplicationEntity {

    @ForeignKey
    private ChannelDirectionType direction;

    @ForeignKey
    private WfChannelStatus status;
    
    @Column(name = "CHANNEL_LABEL", length = 64)
    private String label;

    @Column(length = 128)
    private String entity;

    @Column(length = 128)
    private String destination;

    @Column(length = 128, nullable = true)
    private String rule;

    @ListOnly(key = "direction", property = "description")
    private String directionDesc;

    @ListOnly(key = "status", property = "description")
    private String statusDesc;

    public ChannelDirectionType getDirection() {
        return direction;
    }

    public void setDirection(ChannelDirectionType direction) {
        this.direction = direction;
    }

    public WfChannelStatus getStatus() {
        return status;
    }

    public void setStatus(WfChannelStatus status) {
        this.status = status;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getDirectionDesc() {
        return directionDesc;
    }

    public void setDirectionDesc(String directionDesc) {
        this.directionDesc = directionDesc;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

}
