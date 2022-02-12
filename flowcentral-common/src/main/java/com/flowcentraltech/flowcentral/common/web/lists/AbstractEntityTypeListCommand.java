/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.web.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.flowcentraltech.flowcentral.common.annotation.EntityReferences;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyComponentConfig;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.list.ListParam;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Convenient abstract base class for entity type list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractEntityTypeListCommand<T extends UnifyComponent, U extends ListParam>
        extends AbstractFlowCentralTypeListCommand<T, U> {

    public AbstractEntityTypeListCommand(Class<T> typeClazz, Class<U> paramClazz) {
        super(typeClazz, paramClazz);
    }

    @Override
    final protected List<UnifyComponentConfig> filterList(List<UnifyComponentConfig> baseConfigList, U param)
            throws UnifyException {
        if (!DataUtils.isBlank(baseConfigList)) {
            final String entityName = getEntityName(param);
            if (!StringUtils.isBlank(entityName)) {
                List<UnifyComponentConfig> list = new ArrayList<UnifyComponentConfig>();
                for (UnifyComponentConfig unifyComponentConfig : baseConfigList) {
                    EntityReferences era = unifyComponentConfig.getType().getAnnotation(EntityReferences.class);
                    if (era == null) {
                        list.add(unifyComponentConfig);
                    } else {
                        for (String entity : era.value()) {
                            if (entityName.equals(entity)) {
                                list.add(unifyComponentConfig);
                                break;
                            }
                        }
                    }
                }
                return list;
            }
        }

        return Collections.emptyList();
    }

    protected abstract String getEntityName(U param) throws UnifyException;
}
