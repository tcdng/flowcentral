/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.constant.DataType;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Input type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_INPUTTYPE")
@StaticList(name = "inputtypelist", description = "$m{staticlist.inputtypelist}")
public enum InputType implements EnumConst {

    CHAR(
            "CH",
            false,
            DataType.CHAR),
    CHAR_ARRAY(
            "CHA",
            true,
            DataType.CHAR),
    BOOLEAN(
            "BL",
            false,
            DataType.BOOLEAN),
    BOOLEAN_ARRAY(
            "BLA",
            true,
            DataType.BOOLEAN),
    SHORT(
            "SH",
            false,
            DataType.SHORT,
            DataType.INTEGER,
            DataType.LONG),
    SHORT_ARRAY(
            "SHA",
            true,
            DataType.SHORT,
            DataType.INTEGER,
            DataType.LONG),
    INTEGER(
            "IN",
            false,
            DataType.INTEGER,
            DataType.LONG),
    INTEGER_ARRAY(
            "INA",
            true,
            DataType.INTEGER,
            DataType.LONG),
    LONG(
            "LN",
            false,
            DataType.LONG),
    LONG_ARRAY(
            "LNA",
            true,
            DataType.LONG),
    FLOAT(
            "FL",
            false,
            DataType.FLOAT,
            DataType.DOUBLE,
            DataType.DECIMAL),
    FLOAT_ARRAY(
            "FLA",
            true,
            DataType.FLOAT,
            DataType.DOUBLE,
            DataType.DECIMAL),
    DOUBLE(
            "DB",
            false,
            DataType.DOUBLE,
            DataType.DECIMAL),
    DOUBLE_ARRAY(
            "DBA",
            true,
            DataType.DOUBLE,
            DataType.DECIMAL),
    DECIMAL(
            "DC",
            false,
            DataType.DECIMAL),
    DECIMAL_ARRAY(
            "DCA",
            true,
            DataType.DECIMAL),
    DATE(
            "DT",
            false,
            DataType.DATE),
    DATE_ARRAY(
            "DTA",
            true,
            DataType.DATE),
    DATETIME(
            "TS",
            false,
            DataType.TIMESTAMP,
            DataType.TIMESTAMP_UTC),
    DATETIME_ARRAY(
            "TSA",
            true,
            DataType.TIMESTAMP,
            DataType.TIMESTAMP_UTC),
    STRING(
            "ST",
            false,
            DataType.STRING,
            DataType.CLOB),
    STRING_ARRAY(
            "STA",
            true,
            DataType.STRING,
            DataType.CLOB);

    private final String code;

    private final Set<DataType> compatibleTypes;

    private final boolean array;

    private InputType(String code, boolean array, DataType... compatibleTypes) {
        this.code = code;
        this.array = array;
        if (compatibleTypes == null || compatibleTypes.length == 0) {
            this.compatibleTypes = Collections.emptySet();
        } else {
            this.compatibleTypes = new HashSet<DataType>(Arrays.asList(compatibleTypes));
        }
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return STRING.code;
    }

    public boolean array() {
        return array;
    }

    public boolean isCompatible(DataType dataType) {
        if (DataType.BLOB.equals(dataType) || DataType.CLOB.equals(dataType)) {
            return false;
        }

        return compatibleTypes.contains(dataType);
    }

    public static InputType fromCode(String code) {
        return EnumUtils.fromCode(InputType.class, code);
    }

    public static InputType fromName(String name) {
        return EnumUtils.fromName(InputType.class, name);
    }
}
