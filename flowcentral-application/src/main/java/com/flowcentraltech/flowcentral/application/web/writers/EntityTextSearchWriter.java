/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.writers;

import java.util.List;

import com.flowcentraltech.flowcentral.application.web.widgets.EntityTextSearchWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.WriteWork;
import com.tcdng.unify.web.ui.widget.control.AbstractPopupTextField;
import com.tcdng.unify.web.ui.widget.writer.control.AbstractPopupTextFieldWriter;

/**
 * Entity text search widget writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(EntityTextSearchWidget.class)
@Component("entitytextsearch-writer")
public class EntityTextSearchWriter extends AbstractPopupTextFieldWriter {

    @Override
    protected void writePopupContent(ResponseWriter writer, AbstractPopupTextField popupTextField)
            throws UnifyException {
        EntityTextSearchWidget entityTextSearchWidget = (EntityTextSearchWidget) popupTextField;

        writer.write("<div");
        writeTagId(writer, entityTextSearchWidget.getSearchPanelId());
        writeTagStyleClass(writer, "elborder");
        writer.write(">");

        // Aggregate item row
        writer.write("<div");
        writeTagId(writer, entityTextSearchWidget.getResultPanelId());
        writeTagStyleClass(writer, "elresultrow");
        writer.write(" tabindex=\"-1\">");
        writer.write("</div>");

        writer.write("</div>");
    }

    @Override
    protected void doWritePopupTextFieldBehaviour(ResponseWriter writer, AbstractPopupTextField popupTextField,
            boolean popupEnabled) throws UnifyException {
        EntityTextSearchWidget entityTextSearchWidget = (EntityTextSearchWidget) popupTextField;
        writer.beginFunction("fux.rigEntitySearch");
        writer.writeParam("pId", entityTextSearchWidget.getId());
        writer.writeParam("pFacId", entityTextSearchWidget.getFacadeId());
        writer.writeParam("pFilId", entityTextSearchWidget.getFacadeId());
        writer.writeParam("pPopId", entityTextSearchWidget.getPopupId());
        writer.writeParam("pBrdId", entityTextSearchWidget.getBorderId());
        writer.writeParam("pRltId", entityTextSearchWidget.getResultPanelId());
        writer.writeCommandURLParam("pCmdURL");
        writer.writeParam("pClearable", entityTextSearchWidget.isClearable());
        writer.writeParam("pText", true);
        Listable listable = entityTextSearchWidget.getCurrentSelect();
        if (listable != null) {
            writer.writeParam("pDesc", listable.getListDescription());
        }
        writer.endFunction();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doWriteSectionStructureAndContent(ResponseWriter writer, Widget widget, String sectionPageName)
            throws UnifyException {
        EntityTextSearchWidget entityTextSearchWidget = (EntityTextSearchWidget) widget;
        if (entityTextSearchWidget.getResultPanelId().equals(sectionPageName)) {
            writer.write("<div");
            writeTagStyleClass(writer, "ellist");
            writer.write(">");

            WriteWork work = entityTextSearchWidget.getWriteWork();
            List<? extends Listable> listableList = (List<? extends Listable>) work
                    .get(EntityTextSearchWidget.WORK_RESULTLIST);
            if (!DataUtils.isBlank(listableList)) {
                final int len = listableList.size();
                String[] selectIds = new String[len];
                String[] texts = new String[len];
                for (int i = 0; i < len; i++) {
                    selectIds[i] = entityTextSearchWidget.getNamingIndexedId(i);
                    writer.write("<a ");
                    writeTagId(writer, selectIds[i]);
                    writeTagStyleClass(writer, "norm");
                    writer.write(">");
                    writer.write("</a>");
                    texts[i] = listableList.get(i).getListDescription();
                }

                work.set(EntityTextSearchWidget.WORK_SELECTIDS, selectIds);
                work.set(EntityTextSearchWidget.WORK_TEXTS, texts);
            }

            writer.write("</div>");
        }
    }

    @Override
    protected void doWriteSectionBehavior(ResponseWriter writer, Widget widget, String sectionPageName)
            throws UnifyException {
        EntityTextSearchWidget entitySearchWidget = (EntityTextSearchWidget) widget;
        if (entitySearchWidget.getResultPanelId().equals(sectionPageName)) {
            WriteWork work = entitySearchWidget.getWriteWork();
            writer.beginFunction("fux.rigEntitySearchResult");
            writer.writeParam("pId", entitySearchWidget.getId());
            writer.writeParam("pFacId", entitySearchWidget.getFacadeId());
            writer.writeParam("pFilId", entitySearchWidget.getFacadeId());
            writer.writeParam("pPopId", entitySearchWidget.getPopupId());
            writer.writeParam("pBrdId", entitySearchWidget.getBorderId());
            writer.writeParam("pRltId", entitySearchWidget.getResultPanelId());
            writer.writeCommandURLParam("pCmdURL");
            writer.writeParam("pSelectIds", (String[]) work.get(EntityTextSearchWidget.WORK_SELECTIDS));
            writer.writeParam("pKeys", (String[]) work.get(EntityTextSearchWidget.WORK_TEXTS));
            writer.writeParam("pNormCls", "norm");
            writer.writeParam("pSelCls", getUserColorStyleClass("sel"));
            writer.writeParam("pText", true);
            writer.endFunction();
        }
    }

    @Override
    protected String getOnHideAction() throws UnifyException {
        return null;
    }

    @Override
    protected String getOnHideParam(AbstractPopupTextField popupTextField) throws UnifyException {
        return null;
    }

    @Override
    protected String getOnShowAction() throws UnifyException {
        return "fux.esOnShow";
    }

    @Override
    protected String getOnShowParam(AbstractPopupTextField popupTextField) throws UnifyException {
        EntityTextSearchWidget entitySearchWidget = (EntityTextSearchWidget) popupTextField;
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        sb.append("\"pFilId\":\"").append(entitySearchWidget.getFacadeId()).append('"');
        sb.append(",\"pRltId\":\"").append(entitySearchWidget.getResultPanelId()).append('"');
        sb.append('}');
        return sb.toString();
    }

}
