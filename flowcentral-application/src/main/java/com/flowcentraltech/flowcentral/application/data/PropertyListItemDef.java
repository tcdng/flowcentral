/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

/**
 * Property list item definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PropertyListItemDef {

    private EntityFieldDef entityFieldDef;

    private WidgetTypeDef widgetTypeDef;
    
    private String description;

    private String renderer;

    private String defaultVal;

    private boolean required;

    private boolean mask;

    private boolean encrypt;

    public PropertyListItemDef(EntityFieldDef entityFieldDef, WidgetTypeDef widgetTypeDef, String description, String renderer,
            String defaultVal, boolean required, boolean mask, boolean encrypt) {
        this.entityFieldDef = entityFieldDef;
        this.widgetTypeDef = widgetTypeDef;
        this.description = description;
        this.renderer = renderer;
        this.defaultVal = defaultVal;
        this.required = required;
        this.mask = mask;
        this.encrypt = encrypt;
    }

    public EntityFieldDef getEntityFieldDef() {
        return entityFieldDef;
    }

    public WidgetTypeDef getWidgetTypeDef() {
        return widgetTypeDef;
    }

    public String getName() {
        return entityFieldDef.getFieldName();
    }

    public String getDescription() {
        return description;
    }

    public String getReferences() {
        return entityFieldDef.getReferences();
    }

    public String getRenderer() {
        return renderer;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean isMask() {
        return mask;
    }

    public boolean isEncrypt() {
        return encrypt;
    }
}
