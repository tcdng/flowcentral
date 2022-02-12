/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.dashboard.web.widgets;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.dashboard.data.DashboardDef;
import com.flowcentraltech.flowcentral.dashboard.data.DashboardTileDef;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.web.ui.widget.AbstractMultiControl;
import com.tcdng.unify.web.ui.widget.Widget;

/**
 * Dashboard slate widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-dashboardslate")
public class DashboardSlateWidget extends AbstractMultiControl {

    private DashboardSlate oldSlate;

    private List<List<Widget>> tileList;

    public DashboardSlateWidget() {
        tileList = new ArrayList<List<Widget>>();
    }

    public DashboardSlate getDashboardSlate() throws UnifyException {
        DashboardSlate slate = getValue(DashboardSlate.class);
        if (slate != oldSlate) {
            DashboardDef oldDashboardDef = oldSlate != null ? oldSlate.getDashboardDef() : null;
            DashboardDef dashboardDef = slate != null ? slate.getDashboardDef() : null;
            if (dashboardDef != oldDashboardDef) {
                removeAllExternalChildWidgets();
                tileList.clear();

                if (dashboardDef != null) {
                    final int sections = dashboardDef.getSections();
                    for (int i = 0; i < sections; i++) {
                        List<Widget> widgetList = new ArrayList<Widget>();
                        for (DashboardTileDef dashboardTileDef : dashboardDef.getTileList(i)) {
                            String renderer = null;
                            switch (dashboardTileDef.getType()) {
                                case SPARKLINE:
                                    renderer = "!fc-chart sparkLine:true binding:chart";
                                    break;
                                case SIMPLE:
                                default:
                                    renderer = "!fc-chart sparkLine:false binding:chart";
                                    break;
                            }

                            Widget widget = addExternalChildWidget(renderer);
                            widget.setValueStore(createValueStore(dashboardTileDef));
                            widgetList.add(widget);
                        }

                        tileList.add(widgetList);
                    }

                }
            }

            oldSlate = slate;
        }

        return slate;
    }

    public List<List<Widget>> getTileList() throws UnifyException {
        getDashboardSlate();
        return tileList;
    }

    @Override
    protected void doOnPageConstruct() throws UnifyException {

    }

}
