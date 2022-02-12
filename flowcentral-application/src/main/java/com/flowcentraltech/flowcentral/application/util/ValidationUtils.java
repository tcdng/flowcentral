/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

/**
 * Validation utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class ValidationUtils {

    private ValidationUtils() {

    }

    public static boolean isBlank(Object val) {
        if (val instanceof String) {
            return ((String) val).trim().isEmpty();
        }

        return val == null;
    }

    public static boolean isLessThanMinLen(String val, int minLen) {
        return minLen > 0 && val.trim().length() < minLen;
    }

    public static boolean isGreaterThanMaxLen(String val, int maxLen) {
        return maxLen > 0 && val.trim().length() > maxLen;
    }
}
