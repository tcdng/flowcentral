/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
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
 * @author FlowCentral Technologies Limited
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
    protected void onLoadSourceObject(List<?> sourceObject, Set<Integer> selected) throws UnifyException {
        if (policy != null) {
            policy.onLoad(getValueStore(sourceObject), selected);
        }
    }

    @Override
    protected void onFireOnChange(List<?> sourceObject, Set<Integer> selected) throws UnifyException {
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
