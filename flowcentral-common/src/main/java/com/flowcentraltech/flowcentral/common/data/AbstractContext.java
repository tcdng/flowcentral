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
import com.tcdng.unify.core.util.DataUtils;

/**
 * Convenient abstract base class for context object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractContext {

    private Map<String, Object> attributes;

    public void setAll(AbstractContext ctx) {
        if (ctx.attributes != null) {
            if (attributes == null) {
                attributes = new HashMap<String, Object>();
            }

            attributes.putAll(ctx.attributes);
        }
    }

    public void setAttribute(String name, Object val) {
        if (attributes == null) {
            attributes = new HashMap<String, Object>();
        }

        attributes.put(name, val);
    }

    public <T> T getAttribute(Class<T> clazz, String name) throws UnifyException {
        if (attributes != null) {
            return DataUtils.convert(clazz, attributes.get(name));
        }

        return null;
    }
}
