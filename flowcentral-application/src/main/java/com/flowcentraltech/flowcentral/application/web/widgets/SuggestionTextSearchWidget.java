/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.data.SuggestionTypeDef;
import com.flowcentraltech.flowcentral.application.util.ApplicationEntityNameParts;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplAttribute;
import com.tcdng.unify.core.annotation.UplAttributes;
import com.tcdng.unify.core.criterion.And;
import com.tcdng.unify.core.criterion.Equals;
import com.tcdng.unify.core.criterion.Or;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Suggestion text search.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-suggestiontextsearch")
@UplAttributes({ @UplAttribute(name = "ref", type = String.class, defaultVal = "application.appSuggestionRef"),
        @UplAttribute(name = "searchField", type = String.class, defaultVal = "suggestion"),
        @UplAttribute(name = "type", type = String.class, mandatory = false) })
public class SuggestionTextSearchWidget extends EntityTextSearchWidget {

    @Override
    protected void addMoreResultRestriction(Query<? extends Entity> query) throws UnifyException {
        String suggestionType = getUplAttribute(String.class, "type");
        if (!StringUtils.isBlank(suggestionType)) {
            SuggestionTypeDef suggestionTypeDef = applicationService().getSuggestionTypeDef(suggestionType);
            ApplicationEntityNameParts parts = ApplicationNameUtils.getApplicationEntityNameParts(suggestionType);
            if (suggestionTypeDef.isWithParent()) {
                ApplicationEntityNameParts pparts = ApplicationNameUtils
                        .getApplicationEntityNameParts(suggestionTypeDef.getParent());
                query.addRestriction(new Or()
                        .add(new And().add(new Equals("applicationName", parts.getApplicationName()))
                                .add(new Equals("suggestionTypeName", parts.getEntityName())))
                        .add(new And().add(new Equals("applicationName", pparts.getApplicationName()))
                                .add(new Equals("suggestionTypeName", pparts.getEntityName()))));
            } else {
                query.addEquals("applicationName", parts.getApplicationName()).addEquals("suggestionTypeName",
                        parts.getEntityName());
            }
        }
    }

}
