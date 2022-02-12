/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.tcdng.unify.core.util.StringUtils;

/**
 * Code generation utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class CodeGenerationUtils {

    private CodeGenerationUtils() {

    }

    public static Map<String, String> splitMessageReplacements(String replacementList) {
        Map<String, String> replacements = Collections.emptyMap();
        if (!StringUtils.isBlank(replacementList)) {
            replacements = new HashMap<String, String>();
            String[] items = replacementList.split("\\|");
            for (String item : items) {
                String[] replacement = item.split("=");
                if (replacement.length == 2) {
                    replacements.put(replacement[0], replacement[1]);
                }
            }
            
            replacements = Collections.unmodifiableMap(replacements);
        }

        return replacements;
    }
}
