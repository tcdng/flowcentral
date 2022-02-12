/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import java.util.Collection;

import com.tcdng.unify.core.criterion.CompoundRestriction;

/**
 * Base query object for base named entity sub-classes.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseNamedEntityQuery<T extends BaseNamedEntity> extends BaseAuditEntityQuery<T> {

    public BaseNamedEntityQuery(Class<T> entityClass) {
        super(entityClass);
    }

    public BaseNamedEntityQuery(Class<T> entityClass, boolean applyAppQueryLimit) {
        super(entityClass, applyAppQueryLimit);
    }

    public BaseNamedEntityQuery(Class<T> entityClass, CompoundRestriction restrictions, boolean applyAppQueryLimit) {
        super(entityClass, restrictions, applyAppQueryLimit);
    }

    public final BaseNamedEntityQuery<T> name(String name) {
        return (BaseNamedEntityQuery<T>) addEquals("name", name);
    }

    public final BaseNamedEntityQuery<T> nameIn(Collection<String> name) {
        return (BaseNamedEntityQuery<T>) addAmongst("name", name);
    }

    public final BaseNamedEntityQuery<T> nameLike(String name) {
        return (BaseNamedEntityQuery<T>) addLike("name", name);
    }

    public final BaseNamedEntityQuery<T> descriptionLike(String description) {
        return (BaseNamedEntityQuery<T>) addLike("description", description);
    }

}
