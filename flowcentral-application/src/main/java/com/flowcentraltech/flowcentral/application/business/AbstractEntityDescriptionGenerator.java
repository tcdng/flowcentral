/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.business;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.util.RefDecodedValue;
import com.flowcentraltech.flowcentral.application.util.RefEncodingUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Convenient abstract base class for entity description generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractEntityDescriptionGenerator extends AbstractFieldSetValueGenerator {

    private String refLongName;

    private String srcFieldName;

    public AbstractEntityDescriptionGenerator(String refLongName, String srcFieldName) {
        this.refLongName = refLongName;
        this.srcFieldName = srcFieldName;
    }

    public AbstractEntityDescriptionGenerator(String srcFieldName) {
        this.srcFieldName = srcFieldName;
    }

    @Override
    public final Object generate(EntityDef entityDef, ValueStore valueStore, String rule) throws UnifyException {
        logDebug("Generating description for refLongName [{0}] and srcFieldName [{1}]...", refLongName, srcFieldName);
        String _refLongName = null;
        Long _instId = null;
        if (!StringUtils.isBlank(refLongName)) {
            // Resolved target
            _refLongName = refLongName;
            _instId = valueStore.retrieve(Long.class, srcFieldName);
        } else {
            // Unresolved target
            String encRef = valueStore.retrieve(String.class, srcFieldName);
            RefDecodedValue decRef = RefEncodingUtils.decodeRefValue(encRef);
            if (decRef != null) {
                _refLongName = decRef.getRefLongName();
                if (!StringUtils.isBlank((String) decRef.getValue())) {
                    _instId = Long.valueOf((String) decRef.getValue());
                }
            }
        }

        if (_refLongName != null && _instId != null) {
            return applicationService().getEntityDescriptionByRef(_refLongName, _instId);
        }

        return null;
    }

}
