/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import com.flowcentraltech.flowcentral.common.entities.WorkEntity;
import com.tcdng.unify.core.data.BeanValueStore;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.core.data.ValueStoreReader;
import com.tcdng.unify.core.data.ValueStoreWriter;

/**
 * Workflow entity instance object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfEntityInst {
    
    private ValueStore valueStore;

    private ValueStoreReader valueStoreReader;

    private ValueStoreWriter valueStoreWriter;

    public WfEntityInst(WorkEntity wfEntityInst) {
        this.valueStore = new BeanValueStore(wfEntityInst);
    }

    public WorkEntity getWfEntityInst() {
        return (WorkEntity) valueStore.getValueObject();
    }

    public ValueStoreReader getValueStoreReader() {
        if (valueStoreReader == null) {
            valueStoreReader = new ValueStoreReader(valueStore);
        }

        return valueStoreReader;
    }

    public ValueStoreWriter getValueStoreWriter() {
        if (valueStoreWriter == null) {
            valueStoreWriter = new ValueStoreWriter(valueStore);
        }

        return valueStoreWriter;
    }

    public ValueStore getWfInstValueStore() {
        return valueStore;
    }

}
