/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.business;

import com.flowcentraltech.flowcentral.application.util.InputWidgetUtils;
import com.flowcentraltech.flowcentral.common.business.QueryEncoder;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.criterion.Order;
import com.tcdng.unify.core.criterion.Update;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;

/**
 * Application query encoder.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("application-queryencoder")
public class ApplicationQueryEncoder extends AbstractUnifyComponent implements QueryEncoder {

    @Override
    public String encodeQueryFilter(Query<? extends Entity> query) throws UnifyException {
        return !query.isEmptyCriteria() ? InputWidgetUtils.getFilterDefinition(query.getRestrictions()) : null;
    }

    @Override
    public String encodeQueryOrder(Query<? extends Entity> query) throws UnifyException {
        if (query.isOrder()) {
            StringBuilder sb = new StringBuilder();
            for (Order.Part part : query.getOrder().getParts()) {
                sb.append(part.getField()).append("]").append(part.getType().name()).append("\r\n");
            }
            
            return sb.toString();
        }

        return null;
    }

    @Override
    public String encodeUpdate(Update update) throws UnifyException {
        return InputWidgetUtils.getUpdateDefinition(update);
    }

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

}
