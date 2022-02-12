/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.HashMap;
import java.util.Map;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.format.Formatter;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Dictionary class.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class Dictionary {

    private Map<String, Object> valueMap;

    public Dictionary() {
        valueMap = new HashMap<String, Object>();
    }

    public Map<String, Object> getValueMap() {
        return valueMap;
    }

    public void setValue(String key, Object val) {
        valueMap.put(key, val);
    }

    public Object replaceValue(String key, Object val) {
        Object oldVal = valueMap.get(key);
        valueMap.put(key, val);
        return oldVal;
    }

    public Object getValue(String key) {
        return valueMap.get(key);
    }

    public <T> T getValue(Class<T> targetClazz, String key) throws UnifyException {
        return DataUtils.convert(targetClazz, valueMap.get(key));
    }

    public <T> T getValue(Class<T> targetClazz, String key, Formatter<?> formatter) throws UnifyException {
        return DataUtils.convert(targetClazz, valueMap.get(key), formatter);
    }

    public void clear() {
        valueMap.clear();
    }

    public int size() {
        return valueMap.size();
    }

    public boolean isKey(String key) {
        return valueMap.containsKey(key);
    }

    public boolean isEmpty() {
        return valueMap.isEmpty();
    }
}
