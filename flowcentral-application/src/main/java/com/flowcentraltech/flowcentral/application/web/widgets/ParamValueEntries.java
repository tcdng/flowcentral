/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.flowcentraltech.flowcentral.common.data.ParamValueDef;
import com.flowcentraltech.flowcentral.common.data.ParamValuesDef;
import com.flowcentraltech.flowcentral.common.input.AbstractInput;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Parameter value entries object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ParamValueEntries {

    private List<ParamValueEntry> entryList;

    public ParamValueEntries(ParamValuesDef paramValuesDef) throws UnifyException {
        entryList = Collections.emptyList();
        if (paramValuesDef != null) {
            entryList = new ArrayList<ParamValueEntry>();
            for (ParamValueDef paramValueDef : paramValuesDef.getParamValueList()) {
                ParamValueEntry pvo = new ParamValueEntry(paramValueDef.getParamConfig());
                pvo.normalize();

                AbstractInput<?> in = pvo.getParamInput();
                if (in != null) {
                    in.setStringValue(paramValueDef.getParamVal());
                }
                entryList.add(pvo);
            }

            entryList = DataUtils.unmodifiableList(entryList);
        }
    }

    public ParamValueEntry getEntry(int index) {
        return entryList.get(index);
    }

    public List<ParamValueEntry> getEntryList() {
        return entryList;
    }

    public int size() {
        return entryList.size();
    }

    public ParamValuesDef getParamValuesDef() throws UnifyException {
        ParamValuesDef.Builder pvdb = ParamValuesDef.newBuilder();
        for (ParamValueEntry pvo : entryList) {
            String param = pvo.isWithParamInput() ? pvo.getParamInput().getStringValue() : null;
            pvdb.addParamValueDef(pvo.getParamConfig(), param);
        }

        return pvdb.build();
    }

}
