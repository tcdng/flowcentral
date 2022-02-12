/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.constants;

/**
 * Sequence part type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public enum SequencePartType {

    TEXT(
            "",
            ""),
    SEQUENCE_NUMBER(
            "{n:",
            ""),
    SEQUENCE_NUMBER_BY_DATE(
            "{N:",
            ""),
    LONG_YEAR(
            "{yyyy}",
            "____"),
    SHORT_YEAR(
            "{yy}",
            "__"),
    DAY_OF_MONTH(
            "{dd}",
            "_"),
    DAY_OF_YEAR(
            "{ddd}",
            "_");

    private final String track;

    private final String skeleton;

    private SequencePartType(String track, String skeleton) {
        this.track = track;
        this.skeleton = skeleton;
    }

    public String track() {
        return track;
    }

    public String skeleton() {
        return skeleton;
    }

    public boolean isSequenceNumber() {
        return SEQUENCE_NUMBER.equals(this) || SEQUENCE_NUMBER_BY_DATE.equals(this);
    }

    public boolean isDatePart() {
        return LONG_YEAR.equals(this) || SHORT_YEAR.equals(this) || DAY_OF_MONTH.equals(this)
                || DAY_OF_YEAR.equals(this);
    }

}
