/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.writers;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.application.web.widgets.SetValueEntry;
import com.flowcentraltech.flowcentral.application.web.widgets.SetValuesWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.ui.widget.Control;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.control.DynamicField;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Set values widget writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(SetValuesWidget.class)
@Component("fc-setvalues-writer")
public class SetValuesWriter extends AbstractControlWriter {

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        SetValuesWidget setValuesWidget = (SetValuesWidget) widget;
        writer.write("<div");
        writeTagAttributes(writer, setValuesWidget);
        writer.write(">");
        List<ValueStore> valueStoreList = setValuesWidget.getValueList();
        if (valueStoreList != null) {
            Control fieldSelectCtrl = setValuesWidget.getFieldSelectCtrl();
            Control typeSelectCtrl = setValuesWidget.getTypeSelectCtrl();
            DynamicField paramCtrl = setValuesWidget.getParamCtrl();
            Control deleteCtrl = setValuesWidget.getDeleteCtrl();
            int len = valueStoreList.size();
            for (int i = 0; i < len; i++) {
                ValueStore lineValueStore = valueStoreList.get(i);
                SetValueEntry svo = (SetValueEntry) lineValueStore.getValueObject();
                writer.write("<div class=\"line\">");
                writeValuesItem(writer, lineValueStore, fieldSelectCtrl);
                if (!StringUtils.isBlank(svo.getFieldName())) {
                    writeValuesItem(writer, lineValueStore, typeSelectCtrl);
                    if (svo.getType() != null && !svo.getType().isNoParam()) {
                        if (svo.getParamInput() != null) {
                            writeValuesItem(writer, lineValueStore, paramCtrl);
                        }
                    }

                    writer.write("<div class=\"atab\">");
                    writeActionItem(writer, lineValueStore, deleteCtrl);
                    writer.write("</div>");
                }
                writer.write("</div>");
            }

        }
        writer.write("</div>");
    }

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        super.doWriteBehavior(writer, widget);
        SetValuesWidget setValuesWidget = (SetValuesWidget) widget;
        List<ValueStore> valueStoreList = setValuesWidget.getValueList();
        List<String> csb = new ArrayList<String>();
        if (valueStoreList != null) {
            Control fieldSelectCtrl = setValuesWidget.getFieldSelectCtrl();
            Control typeSelectCtrl = setValuesWidget.getTypeSelectCtrl();
            DynamicField paramCtrl = setValuesWidget.getParamCtrl();
            final int len = valueStoreList.size();
            for (int i = 0; i < len; i++) {
                ValueStore lineValueStore = valueStoreList.get(i);
                SetValueEntry svo = (SetValueEntry) lineValueStore.getValueObject();
                writeBehavior(writer, setValuesWidget, lineValueStore, fieldSelectCtrl);
                csb.add(fieldSelectCtrl.getId());

                if (!StringUtils.isBlank(svo.getFieldName())) {
                    writeBehavior(writer, setValuesWidget, lineValueStore, typeSelectCtrl);
                    csb.add(typeSelectCtrl.getId());
                    if (svo.getType() != null && !svo.getType().isNoParam()) {
                        if (svo.getParamInput() != null) {
                            writeBehavior(writer, setValuesWidget, lineValueStore, paramCtrl);
                        }
                    }
                }
            }
        }

        writer.beginFunction("fux.rigSetValues");
        writer.writeParam("pId", setValuesWidget.getId());
        writer.writeCommandURLParam("pCmdURL");
        writer.writeParam("pContId", setValuesWidget.getContainerId());
        writer.writeParam("pDelId", setValuesWidget.getDeleteCtrl().getBaseId());
        writer.writeParam("pOnChgId", DataUtils.toArray(String.class, csb));
        writer.endFunction();
    }

    private void writeValuesItem(ResponseWriter writer, ValueStore lineValueStore, Control ctrl) throws UnifyException {
        writer.write("<span class=\"item\">");
        ctrl.setValueStore(lineValueStore);
        writer.writeStructureAndContent(ctrl);
        writer.write("</span>");
    }

    private void writeActionItem(ResponseWriter writer, ValueStore lineValueStore, Control ctrl) throws UnifyException {
        writer.write("<span style=\"display:inline-block;\">");
        ctrl.setValueStore(lineValueStore);
        writer.writeStructureAndContent(ctrl);
        writer.write("</span>");
    }

    private void writeBehavior(ResponseWriter writer, SetValuesWidget setValuesWidget, ValueStore lineValueStore,
            Control ctrl) throws UnifyException {
        ctrl.setValueStore(lineValueStore);
        writer.writeBehavior(ctrl);
        if (setValuesWidget.isContainerEditable()) {
            addPageAlias(setValuesWidget.getId(), ctrl);
        }
    }
}
