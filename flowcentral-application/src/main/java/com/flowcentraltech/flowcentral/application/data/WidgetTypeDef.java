/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.configuration.constants.InputType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.constant.DataType;

/**
 * Widget type definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WidgetTypeDef extends BaseApplicationEntityDef {

    private DataType dataType;

    private InputType type;

    private String editor;

    private String renderer;

    private boolean stretch;

    public WidgetTypeDef(DataType dataType, InputType type, String longName, String description, Long id,
            long versionNo, String editor, String renderer) throws UnifyException {
        this(dataType, type, longName, description, id, versionNo, editor, renderer, true);
    }

    public WidgetTypeDef(DataType dataType, InputType type, String longName, String description, Long id,
            long versionNo, String editor, String renderer, boolean stretch) throws UnifyException {
        super(ApplicationNameUtils.getApplicationEntityNameParts(longName), description, id, versionNo);
        this.dataType = dataType;
        this.type = type;
        this.editor = editor;
        this.renderer = renderer;
        this.stretch = stretch;
    }

    public DataType getDataType() {
        return dataType;
    }

    public InputType getInputType() {
        return type;
    }

    public String getEditor() {
        return editor;
    }

    public String getRenderer() {
        return renderer;
    }

    public boolean isStretch() {
        return stretch;
    }

    public boolean isEnumList() {
        return "application.enumlist".equals(getName());
    }

    @Override
    public String toString() {
        return "WidgetTypeDef [dataType=" + dataType + ", type=" + type + ", editor=" + editor + ", renderer="
                + renderer + ", stretch=" + stretch + ", longName=" + getLongName() + "]";
    }
}
