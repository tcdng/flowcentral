/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import com.tcdng.unify.core.data.Listable;

/**
 * Entity expression definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityExpressionDef implements Listable {

    private String name;

    private String description;

    private String expression;

    public EntityExpressionDef(String name, String description, String expression) {
        this.name = name;
        this.description = description;
        this.expression = expression;
    }

    @Override
    public String getListDescription() {
        return description;
    }

    @Override
    public String getListKey() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getExpression() {
        return expression;
    }

}
