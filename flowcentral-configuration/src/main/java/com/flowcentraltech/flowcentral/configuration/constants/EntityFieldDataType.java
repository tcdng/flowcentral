/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.constant.DataType;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Entity field data type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_ENTITYFIELDDATATYPE")
@StaticList(name = "entityfielddatatypelist", description = "$m{staticlist.entityfielddatatypelist}")
public enum EntityFieldDataType implements EnumConst {

    CHAR(
            "CH",
            DataType.CHAR,
            true,
            true,
            true,
            true),
    BOOLEAN(
            "BL",
            DataType.BOOLEAN,
            true,
            true,
            true,
            true),
    SHORT(
            "SH",
            DataType.SHORT,
            true,
            true,
            true,
            true),
    INTEGER(
            "IN",
            DataType.INTEGER,
            true,
            true,
            true,
            true),
    LONG(
            "LN",
            DataType.LONG,
            true,
            true,
            true,
            true),
    FLOAT(
            "FL",
            DataType.FLOAT,
            true,
            true,
            true,
            true),
    DOUBLE(
            "DB",
            DataType.DOUBLE,
            true,
            true,
            true,
            true),
    DECIMAL(
            "DC",
            DataType.DECIMAL,
            true,
            true,
            true,
            true),
    DATE(
            "DT",
            DataType.DATE,
            true,
            true,
            true,
            true),
    TIMESTAMP_UTC(
            "TU",
            DataType.TIMESTAMP_UTC,
            true,
            true,
            true,
            true),
    TIMESTAMP(
            "TS",
            DataType.TIMESTAMP,
            true,
            true,
            true,
            true),
    CLOB(
            "CT",
            DataType.CLOB,
            false,
            true,
            true,
            true),
    BLOB(
            "BT",
            DataType.BLOB,
            false,
            true,
            false,
            false),
    STRING(
            "ST",
            DataType.STRING,
            true,
            true,
            true,
            true),
    ENUM(
            "EN",
            DataType.STRING,
            true,
            true,
            true,
            true),
    ENUM_REF(
            "ER",
            DataType.STRING,
            false,
            true,
            true,
            true),
    REF(
            "RF",
            DataType.LONG,
            false,
            true,
            true,
            true),
    REF_UNLINKABLE(
            "UR",
            DataType.LONG,
            false,
            true,
            true,
            true),
    REF_FILEUPLOAD(
            "CU",
            null,
            false,
            true,
            true,
            false),
    FOSTER_PARENT_ID(
            "FI",
            DataType.LONG,
            false,
            false,
            false,
            false),
    FOSTER_PARENT_TYPE(
            "FT",
            DataType.STRING,
            false,
            false,
            false,
            false),
    CATEGORY_COLUMN(
            "CC",
            DataType.STRING,
            false,
            false,
            false,
            false),
    SCRATCH(
            "SC",
            DataType.STRING,
            false,
            false,
            false,
            true),
    LIST_ONLY(
            "LO",
            null,
            true,
            true,
            true,
            false),
    CHILD(
            "CD",
            null,
            false,
            false,
            false,
            false),
    CHILD_LIST(
            "CL",
            null,
            false,
            false,
            false,
            false)
    ;

    private final String code;

    private final DataType dataType;

    private final boolean tableView;

    private final boolean formView;

    private final boolean supportFilter;

    private final boolean supportSetValue;

    private EntityFieldDataType(String code, DataType dataType, boolean tableView, boolean formView,
            boolean supportFilter, boolean supportSetValue) {
        this.code = code;
        this.dataType = dataType;
        this.tableView = tableView;
        this.formView = formView;
        this.supportFilter = supportFilter;
        this.supportSetValue = supportSetValue;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return STRING.code;
    }

    public DataType dataType() {
        return dataType;
    }

    public boolean isTableViewable() {
        return tableView;
    }

    public boolean isFormViewable() {
        return formView;
    }

    public boolean isSupportFilter() {
        return supportFilter;
    }

    public boolean isSupportSetValue() {
        return supportSetValue;
    }

    public boolean isSupportLingual() {
        return STRING.equals(this) || DATE.equals(this) || TIMESTAMP.equals(this) || TIMESTAMP_UTC.equals(this);
    }

    public boolean isEnumDataType() {
        return EntityFieldDataType.ENUM.equals(this) || EntityFieldDataType.ENUM_REF.equals(this);
    }

    public boolean isRefDataType() {
        return EntityFieldDataType.REF.equals(this) || EntityFieldDataType.REF_UNLINKABLE.equals(this)
                || EntityFieldDataType.ENUM_REF.equals(this) || EntityFieldDataType.CHILD.equals(this)
                || EntityFieldDataType.CHILD_LIST.equals(this)|| EntityFieldDataType.REF_FILEUPLOAD.equals(this);
    }

    public boolean isPrimitive() {
        return dataType != null;
    }

    public boolean isDate() {
        return DATE.equals(this);
    }

    public boolean isTimestamp() {
        return TIMESTAMP.equals(this) || TIMESTAMP_UTC.equals(this);
    }

    public boolean isBoolean() {
        return BOOLEAN.equals(this);
    }

    public boolean isScratch() {
        return SCRATCH.equals(this);
    }

    public boolean isEntityRef() {
        return EntityFieldDataType.REF.equals(this) || EntityFieldDataType.REF_UNLINKABLE.equals(this)
                || EntityFieldDataType.REF_FILEUPLOAD.equals(this) || EntityFieldDataType.CHILD.equals(this)
                || EntityFieldDataType.CHILD_LIST.equals(this);
    }

    public boolean isForeignKey() {
        return EntityFieldDataType.REF.equals(this) || EntityFieldDataType.REF_UNLINKABLE.equals(this)
                || EntityFieldDataType.ENUM_REF.equals(this);
    }

    public boolean isListOnly() {
        return EntityFieldDataType.LIST_ONLY.equals(this);
    }

    public boolean isChild() {
        return EntityFieldDataType.CHILD.equals(this);
    }

    public boolean isChildList() {
        return EntityFieldDataType.CHILD_LIST.equals(this);
    }

    public boolean isRefFileUpload() {
        return EntityFieldDataType.REF_FILEUPLOAD.equals(this);
    }

    public static EntityFieldDataType fromCode(String code) {
        return EnumUtils.fromCode(EntityFieldDataType.class, code);
    }

    public static EntityFieldDataType fromName(String name) {
        return EnumUtils.fromName(EntityFieldDataType.class, name);
    }

}
