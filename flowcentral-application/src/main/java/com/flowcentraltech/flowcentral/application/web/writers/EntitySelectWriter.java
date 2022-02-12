/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.writers;

import com.flowcentraltech.flowcentral.application.web.widgets.EntitySelectWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.control.AbstractPopupTextField;
import com.tcdng.unify.web.ui.widget.writer.control.AbstractPopupTextFieldWriter;

/**
 * Entity select widget writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(EntitySelectWidget.class)
@Component("entityselect-writer")
public class EntitySelectWriter extends AbstractPopupTextFieldWriter {

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        super.doWriteBehavior(writer, widget);
        EntitySelectWidget entitySelectWidget = (EntitySelectWidget) widget;
        writer.beginFunction("fux.rigEntitySelect");
        writer.writeParam("pId", entitySelectWidget.getId());
        writer.writeParam("pFacId", entitySelectWidget.getFacadeId());
        writer.writeParam("pFilId", entitySelectWidget.getFacadeId());
        writer.writeParam("pBrdId", entitySelectWidget.getBorderId());
        writer.writeCommandURLParam("pCmdURL");
        writer.writeParam("pClearable", entitySelectWidget.isClearable());
        Listable listable = entitySelectWidget.getCurrentSelect();
        if (listable != null) {
            writer.writeParam("pDesc", listable.getListDescription());
        }
        writer.endFunction();
    }

    @Override
    protected void writePopupContent(ResponseWriter writer, AbstractPopupTextField popupTextField)
            throws UnifyException {

    }

    @Override
    protected void doWritePopupTextFieldBehaviour(ResponseWriter writer, AbstractPopupTextField popupTextField,
            boolean popupEnabled) throws UnifyException {

    }

    @Override
    protected String getOnShowAction() throws UnifyException {
        return null;
    }

    @Override
    protected String getOnShowParam(AbstractPopupTextField popupTextField) throws UnifyException {
        return null;
    }

    @Override
    protected String getOnHideAction() throws UnifyException {
        return null;
    }

    @Override
    protected String getOnHideParam(AbstractPopupTextField popupTextField) throws UnifyException {
        return null;
    }

}
