/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.util;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.FactoryMap;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Generator name utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class GeneratorNameUtils {

    private static final FactoryMap<String, GeneratorNameParts> generatorNameParts;

    static {
        generatorNameParts = new FactoryMap<String, GeneratorNameParts>()
            {

                @Override
                protected GeneratorNameParts create(String fullName, Object... arg1) throws Exception {
                    try {
                        String[] po = StringUtils.charSplit(fullName, ':');
                        return new GeneratorNameParts(fullName, po[0], po[1]);
                    } catch (Exception e) {
                        throw new RuntimeException("Name parts error: fullName = " + fullName, e);
                    }
                }

            };
    }

    private GeneratorNameUtils() {

    }

    public static String getGeneratorFullName(String componentName, String rule) {
        return componentName + ':' + rule;
    }

    public static GeneratorNameParts getGeneratorNameParts(String fullName) throws UnifyException {
        return generatorNameParts.get(fullName);
    }

    public static boolean isFullNameWithParts(String fullName) {
        return fullName.indexOf(':') > 0;
    }

}
