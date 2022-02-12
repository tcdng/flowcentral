/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.business;

import com.flowcentraltech.flowcentral.application.constants.ApplicationModuleNameConstants;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.EntityExpressionDef;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.core.script.ScriptingEngine;

/**
 * Entity expression set-value generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(ApplicationModuleNameConstants.ENTITYEXPRESSION_SETVALUE_GENERATOR)
public class EntityExpressionSetValueGenerator extends AbstractFieldSetValueGenerator {

    @Configurable
    private ScriptingEngine scriptingEngine;

    public void setScriptingEngine(ScriptingEngine scriptingEngine) {
        this.scriptingEngine = scriptingEngine;
    }

    @Override
    public Object generate(EntityDef entityDef, ValueStore valueStore, String rule) throws UnifyException {
        EntityExpressionDef entityExpressionDef = entityDef.getExpressionDef(rule);
        return scriptingEngine.evaluate(Object.class, entityExpressionDef.getExpression(),
                entityDef.extractValues(valueStore));
    }

}
