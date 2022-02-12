/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.web.widgets;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplAttribute;
import com.tcdng.unify.core.annotation.UplAttributes;
import com.tcdng.unify.web.ui.widget.AbstractWidget;

/**
 * Chart widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-chart")
@UplAttributes({ @UplAttribute(name = "sparkLine", type = boolean.class, defaultVal = "false") })
public class ChartWidget extends AbstractWidget {

    public boolean isSparkLine() throws UnifyException {
        return getUplAttribute(boolean.class, "sparkLine");
    }
}
