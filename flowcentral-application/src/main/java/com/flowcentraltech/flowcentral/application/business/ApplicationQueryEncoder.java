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
 * @author FlowCentral Technologies Limited
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
