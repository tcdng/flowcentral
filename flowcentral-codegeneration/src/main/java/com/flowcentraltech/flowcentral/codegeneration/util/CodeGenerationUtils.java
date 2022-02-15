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

package com.flowcentraltech.flowcentral.codegeneration.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.tcdng.unify.core.util.StringUtils;

/**
 * Code generation utilities.
 * 
 * @author FlowCentral Technologies Limited
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
