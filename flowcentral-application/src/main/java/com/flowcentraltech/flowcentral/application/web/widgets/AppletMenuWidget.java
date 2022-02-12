/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplAttribute;
import com.tcdng.unify.core.annotation.UplAttributes;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.constant.ResultMappingConstants;
import com.tcdng.unify.web.constant.UnifyWebRequestAttributeConstants;
import com.tcdng.unify.web.ui.widget.Control;
import com.tcdng.unify.web.ui.widget.data.RefreshSection;

/**
 * Applet menu widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-appletmenu")
@UplAttributes({ @UplAttribute(name = "searchable", type = boolean.class, defaultVal = "false") })
public class AppletMenuWidget extends AbstractMenuWidget {

    private Control searchCtrl;

    private String searchInput;

    @Action
    public void clear() throws UnifyException {
        searchInput = null;
        refereshSection();
    }

    @Action
    public void search() throws UnifyException {
        searchInput = getRequestTarget(String.class);
        searchInput = searchInput != null ? searchInput.toLowerCase() : null;
        refereshSection();
    }
    
    public String getMenuSectionId() throws UnifyException {
        return getPrefixedId("msc_");
    }

    public String getClearId() throws UnifyException {
        return getPrefixedId("clr_");
    }

    public boolean isSearchable() throws UnifyException {
        return getUplAttribute(boolean.class, "searchable");
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public Control getSearchCtrl() {
        return searchCtrl;
    }

    @Override
    public void onPageConstruct() throws UnifyException {
        super.onPageConstruct();
        if (isSearchable()) {
            searchCtrl = (Control) addInternalWidget("!ui-text styleClass:$s{search}  binding:searchInput");
        }
    }

    private void refereshSection() throws UnifyException {
        setCollapsedInitial(StringUtils.isBlank(searchInput));
        setRequestAttribute(UnifyWebRequestAttributeConstants.REFRESH_SECTION,
                new RefreshSection(this, getMenuSectionId()));
        setCommandResultMapping(ResultMappingConstants.REFRESH_SECTION);
    }

}
