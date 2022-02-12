/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.widgets;

import com.flowcentraltech.flowcentral.studio.web.widgets.TableEditor.Design;
import com.tcdng.unify.core.ApplicationComponents;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplAttribute;
import com.tcdng.unify.core.annotation.UplAttributes;
import com.tcdng.unify.core.stream.JsonObjectStreamer;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.AbstractMultiControl;
import com.tcdng.unify.web.ui.widget.Control;

/**
 * Table editor widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-tableeditor")
@UplAttributes({ @UplAttribute(name = "choiceWidth", type = String.class, defaultVal = "200px") })
public class TableEditorWidget extends AbstractMultiControl {

    public static final String WORK_CONTENT = "content";

    public static final String FIELDS_TAB = "fields";

    @Configurable(ApplicationComponents.APPLICATION_JSONOBJECTSTREAMER)
    private JsonObjectStreamer jsonObjectStreamer;

    private Control valueCtrl;

    private String design;

    public void setJsonObjectStreamer(JsonObjectStreamer jsonObjectStreamer) {
        this.jsonObjectStreamer = jsonObjectStreamer;
    }

    @Override
    protected void doOnPageConstruct() throws UnifyException {
        valueCtrl = (Control) addInternalChildWidget("!ui-hidden binding:design");
    }

    @Override
    public void addPageAliases() throws UnifyException {
        addPageAlias(valueCtrl);
    }

    @Action
    public void update() throws UnifyException {

    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) throws UnifyException {
        if (!StringUtils.isBlank(design)) {
            getTableEditor().setDesign(jsonObjectStreamer.unmarshal(Design.class, design));
        }
    }

    public Control getValueCtrl() {
        return valueCtrl;
    }

    public TableEditor getTableEditor() throws UnifyException {
        return getValue(TableEditor.class);
    }

    public String getChoiceWidth() throws UnifyException {
        return getUplAttribute(String.class, "choiceWidth");
    }

    public String getFieldBaseId() throws UnifyException {
        return getPrefixedId("field_base_");
    }

    public String getDesignBaseId() throws UnifyException {
        return getPrefixedId("design_base_");
    }

    public String getChoiceId() throws UnifyException {
        return getPrefixedId("choice_");
    }

}
