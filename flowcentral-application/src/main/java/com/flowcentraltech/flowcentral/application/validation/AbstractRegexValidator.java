/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.validation;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.tcdng.unify.core.ApplicationComponents;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.regex.RegexPatternStore;

/**
 * Convenient abstract base class for regex validators.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractRegexValidator extends AbstractValidator {

    private String regexKey;

    public AbstractRegexValidator(String regexKey, String failureMsg) {
        super(failureMsg);
        this.regexKey = regexKey;
    }

    @Override
    public boolean validate(String rule, Object val) throws UnifyException {
        if (val instanceof String) {
            return ((RegexPatternStore) getComponent(ApplicationComponents.APPLICATION_REGEXPATTERNSTORE))
                    .getPattern(getSessionLocale(), regexKey).matcher((String) val).matches();

        }

        return false;
    }

    @Override
    public List<? extends Listable> getRuleList(Locale locale) throws UnifyException {
        return Collections.emptyList();
    }

}
