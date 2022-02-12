/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Entities configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppEntitiesConfig {

    private List<AppEntityConfig> entityList;

    public List<AppEntityConfig> getEntityList() {
        return entityList;
    }

    @XmlElement(name = "entity")
    public void setEntityList(List<AppEntityConfig> entityList) {
        this.entityList = entityList;
    }

}
