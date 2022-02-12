/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

import java.util.ArrayList;
import java.util.List;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.ReflectUtils;

/**
 * Entity class definition
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityClassDef {

    private EntityDef entityDef;

    private Class<?> entityClass;

    private List<String> copyFields;

    public EntityClassDef(EntityDef entityDef, Class<?> entityClass) {
        this.entityDef = entityDef;
        this.entityClass = entityClass;
    }

    public EntityDef getEntityDef() {
        return entityDef;
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public Long getId() {
        return entityDef.getId();
    }

    public long getVersion() {
        return entityDef.getVersion();
    }

    @SuppressWarnings("unchecked")
    public <T> T newInst() throws UnifyException {
        return (T) ReflectUtils.newInstance(entityClass);
    }

    public <T> T newInst(T srcInst) throws UnifyException {
        T destInst = newInst();
        ReflectUtils.shallowBeanCopy(destInst, srcInst, getCopyFields());
        return destInst;
    }

    public <T> void copy(T destInst, T srcInst) throws UnifyException {
        ReflectUtils.shallowBeanCopy(destInst, srcInst, getCopyFields());
    }

    public String getLongName() {
        return entityDef.getLongName();
    }

    public String getDelegate() {
        return entityDef.getDelegate();
    }
    
    public boolean delegated() {
        return entityDef.delegated();
    }
    
    @Override
    public String toString() {
        return "EntityClassDef [entityDef.getLongName()=" + entityDef.getLongName() + ", entityDef.getVersion()="
                + entityDef.getVersion() + ", entityClass=" + entityClass + "]";
    }

    private List<String> getCopyFields() {
        if (copyFields == null) {
            copyFields = new ArrayList<String>();
            for (EntityFieldDef entityFieldDef : entityDef.getFieldDefList()) {
                if (!entityFieldDef.isBase() && !entityFieldDef.isScratch()) {
                    copyFields.add(entityFieldDef.getFieldName());
                }
            }
        }

        return copyFields;
    }
}
