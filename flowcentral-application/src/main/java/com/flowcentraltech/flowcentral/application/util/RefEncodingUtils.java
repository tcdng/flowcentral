/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

/**
 * Reference encoding utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class RefEncodingUtils {

    public static String encodeRefValue(int index, String refLongName, String value) {
        return new StringBuilder().append(index).append(':').append(refLongName).append(':').append(value).toString();
    }
    
    public static RefDecodedValue decodeRefValue(Object refValue) {
        if (refValue != null) {
            String[] parts = String.valueOf(refValue).split(":");
            if (parts.length == 3) {
                return new RefDecodedValue(Integer.valueOf(parts[0]), parts[1], parts[2]);
            }
            
            return new RefDecodedValue(refValue);
        }
        
        return null;
    }
}
