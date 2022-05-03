/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.flowcentraltech.flowcentral.application.data;

import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldType;
import com.tcdng.unify.core.constant.TextCase;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Entity field definition.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public class EntityFieldDef implements Listable, EntityFieldAttributes {

    private WidgetTypeDef textWidgetTypeDef;

    private WidgetTypeDef inputWidgetTypeDef;

    private WidgetTypeDef ligualWidgetTypeDef;

    private EntityFieldDef resolvedTypeFieldDef;

    private RefDef refDef;

    private EntityFieldDataType dataType;

    private EntityFieldType type;

    private TextCase textCase;

    private String entityLongName;
    
    private String fieldName;

    private String fieldLabel;

    private String columnName;

    private String references;

    private String key;

    private String property;

    private String category;

    private String suggestionType;

    private String inputLabel;

    private String inputListKey;

    private String lingualListKey;

    private String autoFormat;

    private String defaultVal;
    
    private int rows;

    private int columns;

    private int minLen;

    private int maxLen;

    private int precision;

    private int scale;

    private boolean nullable;

    private boolean auditable;

    private boolean reportable;

    private boolean descriptive;

    private boolean maintainLink;

    private boolean basicSearch;
    
    public EntityFieldDef(WidgetTypeDef textWidgetTypeDef, WidgetTypeDef inputWidgetTypeDef, RefDef refDef, String entityLongName, String fieldName, String references,
            String inputListKey) {
        this.textWidgetTypeDef =  textWidgetTypeDef;
        this.inputWidgetTypeDef = inputWidgetTypeDef;
        this.refDef = refDef;
        this.entityLongName = entityLongName;
        this.fieldName = fieldName;
        this.references = references;
        this.inputListKey = inputListKey;
    }

    public EntityFieldDef(WidgetTypeDef textWidgetTypeDef, WidgetTypeDef inputWidgetTypeDef, WidgetTypeDef ligualWidgetTypeDef, RefDef refDef,
            EntityFieldDataType dataType, EntityFieldType type, TextCase textCase, String entityLongName, String fieldName, String fieldLabel,
            String columnName, String references, String category, String suggestionType, String inputLabel, String inputListKey,
            String lingualListKey, String autoFormat, String defaultVal, String key, String property, int rows, int columns, int minLen, int maxLen,
            int precision, int scale, boolean nullable, boolean auditable, boolean reportable, boolean maintainLink, boolean basicSearch,
            boolean descriptive) {
        this.textWidgetTypeDef =  textWidgetTypeDef;
        this.inputWidgetTypeDef = inputWidgetTypeDef;
        this.ligualWidgetTypeDef = ligualWidgetTypeDef;
        this.refDef = refDef;
        this.dataType = dataType;
        this.type = type;
        this.textCase = textCase;
        this.entityLongName = entityLongName;
        this.fieldName = fieldName;
        this.fieldLabel = fieldLabel;
        this.columnName = columnName;
        this.references = references;
        this.category = category;
        this.suggestionType = suggestionType;
        this.inputLabel = inputLabel;
        this.inputListKey = inputListKey;
        this.lingualListKey = lingualListKey;
        this.autoFormat = autoFormat;
        this.defaultVal = defaultVal;
        this.key = key;
        this.property = property;
        this.rows = rows;
        this.columns = columns;
        this.minLen = minLen;
        this.maxLen = maxLen > 0 ? maxLen : 0;
        this.precision = precision;
        this.scale = scale;
        this.nullable = nullable;
        this.auditable = auditable;
        this.reportable = reportable;
        this.maintainLink = maintainLink;
        this.basicSearch = basicSearch;
        this.descriptive = descriptive;
    }

    @Override
    public String getListDescription() {
        return inputLabel != null ? inputLabel : fieldLabel;
    }

    @Override
    public String getListKey() {
        return fieldName;
    }

    public WidgetTypeDef getTextWidgetTypeDef() {
        return textWidgetTypeDef;
    }

    public WidgetTypeDef getInputWidgetTypeDef() {
        return inputWidgetTypeDef != null ? inputWidgetTypeDef
                : (resolvedTypeFieldDef != null ? resolvedTypeFieldDef.getInputWidgetTypeDef() : null);
    }

    public WidgetTypeDef getLigualWidgetTypeDef() {
        return ligualWidgetTypeDef != null ? ligualWidgetTypeDef : getInputWidgetTypeDef();
    }

    public RefDef getRefDef() {
        return refDef;
    }

    public EntityFieldDataType getDataType() {
        return dataType;
    }

    public EntityFieldType getType() {
        return type;
    }

    public TextCase getTextCase() {
        return textCase;
    }

    public int getSortIndex() {
        return type.index();
    }

    public String getEntityLongName() {
        return entityLongName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getReferences() {
        return references;
    }

    public String getCategory() {
        return category;
    }

    public String getSuggestionType() {
        return suggestionType;
    }

    public boolean isWithSuggestionType() {
        return !StringUtils.isBlank(suggestionType);
    }
    
    public EntityFieldDef getResolvedTypeFieldDef() {
        return resolvedTypeFieldDef;
    }

    public void setResolvedTypeFieldDef(EntityFieldDef resolvedTypeFieldDef) {
        if (this.resolvedTypeFieldDef == null && EntityFieldDataType.LIST_ONLY.equals(dataType)) {
            this.resolvedTypeFieldDef = resolvedTypeFieldDef;
        }
    }

    public boolean isWithResolvedTypeFieldDef() {
        return resolvedTypeFieldDef != null;
    }

    public boolean isWithCategory() {
        return !StringUtils.isBlank(category);
    }

    public String getInputLabel() {
        return inputLabel;
    }

    public String getInputListKey() {
        return inputListKey;
    }

    public String getLingualListKey() {
        return lingualListKey;
    }

    public String getAutoFormat() {
        return autoFormat;
    }

    public boolean isWithAutoFormat() {
        return !StringUtils.isBlank(autoFormat);
    }

    public boolean isStringAutoFormat() {
        return EntityFieldDataType.STRING.equals(dataType) || !StringUtils.isBlank(autoFormat);
    }
    
    public String getDefaultVal() {
        return defaultVal;
    }
    
    public boolean isWithDefaultVal() {
        return !StringUtils.isBlank(defaultVal);
    }

    public boolean isWithInputWidget() {
        return inputWidgetTypeDef != null || (resolvedTypeFieldDef != null && resolvedTypeFieldDef.isWithInputWidget());
    }

    public String getKey() {
        return key;
    }

    public String getProperty() {
        return property;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public int getMinLen() {
        return minLen;
    }

    @Override
    public int getMaxLen() {
        return maxLen;
    }

    @Override
    public int getPrecision() {
        return precision;
    }

    @Override
    public int getScale() {
        return scale;
    }

    public boolean isLenLimits() {
        return minLen > 0 || maxLen > 0;
    }

    public boolean isPrimaryKey() {
        return "id".equals(fieldName);
    }

    public boolean isNullable() {
        return nullable;
    }

    public boolean isAuditable() {
        return auditable || dataType.isForeignKey();
    }

    public boolean isReportable() {
        return reportable;
    }

    public boolean isDescriptive() {
        return descriptive;
    }

    public boolean isMaintainLink() {
        return maintainLink;
    }

    public boolean isBasicSearch() {
        return basicSearch;
    }

    public boolean isTableViewable() {
        return dataType.isTableViewable();
    }

    public boolean isFormViewable() {
        return dataType.isFormViewable();
    }

    public boolean isSupportFilter() {
        return dataType.isSupportFilter();
    }

    public boolean isSupportSetValue() {
        return dataType.isSupportSetValue() && !isListOnly();
    }

    public boolean isPrimitive() {
        return dataType.isPrimitive();
    }

    public boolean isScratch() {
        return dataType.isScratch();
    }

    public boolean isDate() {
        return dataType.isDate();
    }

    public boolean isTimestamp() {
        return dataType.isTimestamp();
    }

    public boolean isBoolean() {
        return dataType.isBoolean();
    }

    public boolean isNumber() {
        return dataType.isNumber();
    }

    public boolean isEnumDataType() {
        return dataType.isEnumDataType();
    }

    public boolean isRefDataType() {
        return dataType.isRefDataType();
    }

    public boolean isRefFileUpload() {
        return dataType.isRefFileUpload();
    }

    public boolean isString() {
        return dataType.isString();
    }
    
    public boolean isBase() {
        return type.isBase();
    }

    public boolean isStatic() {
        return type.isStatic();
    }

    public boolean isCustom() {
        return type.isCustom();
    }

    public boolean isEntityRef() {
        return refDef != null;
    }

    public boolean isForeignKey() {
        return dataType.isForeignKey();
    }

    public boolean isChildRef() {
        return dataType.isChild() || dataType.isChildList();
    }

    public boolean isChild() {
        return dataType.isChild();
    }

    public boolean isChildList() {
        return dataType.isChildList();
    }

    public boolean isListOnly() {
        return dataType != null && dataType.isListOnly();
    }

    public boolean isBlob() {
        return EntityFieldDataType.BLOB.equals(dataType);
    }

    @Override
    public String toString() {
        return "EntityFieldDef [inputWidgetTypeDef=" + inputWidgetTypeDef + ", ligualWidgetTypeDef="
                + ligualWidgetTypeDef + ", refDef=" + refDef + ", dataType=" + dataType + ", type=" + type
                + ", fieldName=" + fieldName + ", fieldLabel=" + fieldLabel + ", columnName=" + columnName
                + ", references=" + references + ", key=" + key + ", property=" + property + ", category=" + category
                + ", inputLabel=" + inputLabel + ", inputListKey=" + inputListKey + ", lingualListKey=" + lingualListKey
                + ", minLen=" + minLen + ", maxLen=" + maxLen + ", precision=" + precision + ", scale=" + scale
                + ", nullable=" + nullable + ", auditable=" + auditable + ", reportable=" + reportable
                + ", descriptive=" + descriptive + ", maintainLink=" + maintainLink + "]";
    }

}
