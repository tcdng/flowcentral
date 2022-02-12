/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.widgets;

import com.flowcentraltech.flowcentral.application.web.widgets.EntityListWidget;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplAttribute;
import com.tcdng.unify.core.annotation.UplAttributes;

/**
 * Suggestion type list widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-suggestiontypelist")
@UplAttributes({
        @UplAttribute(name = "listKey", type = String.class, defaultVal = "longName"),
        @UplAttribute(name = "ref", type = String[].class, defaultVal = "application.appSuggestionTypeRef") })
public class SuggestionTypeListWidget extends EntityListWidget {

}
