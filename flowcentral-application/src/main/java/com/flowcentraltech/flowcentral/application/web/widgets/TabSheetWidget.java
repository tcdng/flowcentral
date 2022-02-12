/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.Collections;
import java.util.List;

import com.flowcentraltech.flowcentral.application.data.TabDef;
import com.flowcentraltech.flowcentral.application.data.TabSheetDef;
import com.flowcentraltech.flowcentral.application.web.widgets.TabSheet.TabSheetItem;
import com.flowcentraltech.flowcentral.configuration.constants.RendererType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.AbstractValueListMultiControl;
import com.tcdng.unify.web.ui.widget.Widget;

/**
 * Tab sheet widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-tabsheet")
public class TabSheetWidget extends AbstractValueListMultiControl<ValueStore, TabSheetItem> {

    private TabSheet oldTabSheet;

    private Widget[] tabWidgets;

    @Action
    public void choose() throws UnifyException {
        TabSheet tabSheet = getTabSheet();
        if (tabSheet != null) {
            tabSheet.setCurrentTabIndex(getRequestTarget(int.class));
            if (tabSheet.isWithEventHandler() && tabSheet.isWithCurrentItem()) {
                tabSheet.getEventHandler().onChoose(tabSheet.getCurrentItem());
            }
        }
    }

    public TabSheet getTabSheet() throws UnifyException {
        TabSheet tabSheet = getValue(TabSheet.class);
        if (tabSheet != oldTabSheet) {
            TabSheetDef oldTabSheetDef = null;
            if (oldTabSheet != null) {
                oldTabSheetDef = oldTabSheet != null ? oldTabSheet.getTabSheetDef() : null;
            }

            TabSheetDef tabSheetDef = null;
            if (tabSheet != null) {
                tabSheetDef = tabSheet != null ? tabSheet.getTabSheetDef() : null;
            }

            if (oldTabSheetDef != tabSheetDef) {
                removeAllExternalChildWidgets();
                tabWidgets = null;
                if (tabSheet != null) {
                    List<TabDef> tabDefList = tabSheet.getTabDefList();
                    tabWidgets = new Widget[tabDefList.size()];
                    for (int i = 0; i < tabWidgets.length; i++) {
                        TabDef tabDef = tabDefList.get(i);
                        if (RendererType.STANDALONE_PANEL.equals(tabDef.getRendererType())) {
                            tabWidgets[i] = addExternalChildStandalonePanel(tabDef.getTabRenderer(), getId() + i);
                        } else {
                            tabWidgets[i] = addExternalChildWidget(tabDef.getTabRenderer());
                        }
                    }
                }
            }

            oldTabSheet = tabSheet;
        }

        return tabSheet;
    }

    public Widget getCurrentTabWidget() throws UnifyException {
        TabSheet tabSheet = getTabSheet();
        if (tabSheet != null) {
            return tabWidgets[tabSheet.getCurrentTabIndex()];
        }

        return null;
    }

    @Override
    protected void doOnPageConstruct() throws UnifyException {

    }

    @Override
    protected ValueStore newValue(TabSheetItem object, int index) throws UnifyException {
        return createValueStore(object.getValObject(), index);
    }

    @Override
    protected void onCreateValueList(List<ValueStore> arg0) throws UnifyException {

    }

    @Override
    protected List<TabSheetItem> getItemList() throws UnifyException {
        TabSheet tabSheet = getTabSheet();
        if (tabSheet != null) {
            return tabSheet.getTabSheetItemList();
        }

        return Collections.emptyList();
    }

}
