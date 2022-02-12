/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.TableDef;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.BeanValueListStore;
import com.tcdng.unify.core.data.ValueStore;

/**
 * Bean table object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class BeanTable extends AbstractTable<List<?>, Object> {

    private BeanTablePolicy policy;

    private ValueStore valueStore;

    private List<?> oldSourceObject;

    public BeanTable(AppletUtilities au, TableDef tableDef) {
        this(au, tableDef, false);
    }

    public BeanTable(AppletUtilities au, TableDef tableDef, boolean entryMode) {
        super(au, tableDef, null, entryMode);
    }

    public void setPolicy(BeanTablePolicy policy) {
        this.policy = policy;
    }

    @Override
    protected void onLoadSourceObject(List<?> sourceObject, Set<Long> selected) throws UnifyException {
        if (policy != null) {
            policy.onLoad(getValueStore(sourceObject), selected);
        }
    }

    @Override
    protected void onFireOnChange(List<?> sourceObject, Set<Long> selected) throws UnifyException {
        if (policy != null) {
            policy.onChange(getValueStore(sourceObject), selected);
        }
    }

    @Override
    protected int getSourceObjectSize(List<?> sourceObject) throws UnifyException {
        if (sourceObject != null) {
            return sourceObject.size();
        }

        return 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected List<Object> getDisplayItems(List<?> sourceObject, int dispStartIndex, int dispEndIndex)
            throws UnifyException {
        if (sourceObject != null) {
            if (dispStartIndex == 0 && dispEndIndex == sourceObject.size()) {
                return (List<Object>) sourceObject;
            }

            return (List<Object>) sourceObject.subList(dispStartIndex, dispEndIndex);
        }

        return Collections.emptyList();
    }

    private ValueStore getValueStore(List<?> sourceObject) throws UnifyException {
        if (sourceObject != oldSourceObject) {
            synchronized (this) {
                if (sourceObject != oldSourceObject) {
                    valueStore = new BeanValueListStore(sourceObject);
                    oldSourceObject = sourceObject;
                }
            }
        }

        return valueStore;
    }
}
