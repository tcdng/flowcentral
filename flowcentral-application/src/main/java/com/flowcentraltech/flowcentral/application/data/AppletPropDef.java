/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Applet property definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppletPropDef {

    private String name;

    private String value;

    private List<String> valueList;

    public AppletPropDef(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public <T> T getValue(Class<T> dataClazz) throws UnifyException {
        return DataUtils.convert(dataClazz, value);
    }

    public List<String> getValueList() {
        if (valueList == null) {
            synchronized (this) {
                if (valueList == null) {
                    if (!StringUtils.isBlank(value)) {
                        valueList = new ArrayList<String>();
                        String[] vals = StringUtils.commaSplit(value);
                        for (int i = 0; i < vals.length; i++) {
                            valueList.add(vals[i].trim());
                        }
                    } else {
                        valueList = Collections.emptyList();
                    }
                }
            }
        }
        
        return valueList;
    }
}
