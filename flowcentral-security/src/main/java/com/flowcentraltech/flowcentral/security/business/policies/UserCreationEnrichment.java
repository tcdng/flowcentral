/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.security.business.policies;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.common.annotation.EntityReferences;
import com.flowcentraltech.flowcentral.common.business.policies.AbstractWfEnrichmentPolicy;
import com.flowcentraltech.flowcentral.security.constants.SecurityModuleSysParamConstants;
import com.flowcentraltech.flowcentral.system.business.SystemModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.data.ValueStoreReader;
import com.tcdng.unify.core.data.ValueStoreWriter;
import com.tcdng.unify.core.security.OneWayStringCryptograph;
import com.tcdng.unify.core.security.PasswordGenerator;

/**
 * User creation enrichment.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@EntityReferences({ "security.user" })
@Component(name = "usercreation-enrichment", description = "$m{security.enrichmentpolicy.usercreation}")
public class UserCreationEnrichment extends AbstractWfEnrichmentPolicy {

    @Configurable
    private SystemModuleService systemModuleService;

    @Configurable("oneway-stringcryptograph")
    private OneWayStringCryptograph passwordCryptograph;

    public void setSystemModuleService(SystemModuleService systemModuleService) {
        this.systemModuleService = systemModuleService;
    }

    public void setPasswordCryptograph(OneWayStringCryptograph passwordCryptograph) {
        this.passwordCryptograph = passwordCryptograph;
    }

    @Override
    public void enrich(ValueStoreWriter wfItemWriter, ValueStoreReader wfItemReader, String rule)
            throws UnifyException {
        PasswordGenerator passwordGenerator = (PasswordGenerator) getComponent(systemModuleService
                .getSysParameterValue(String.class, SecurityModuleSysParamConstants.USER_PASSWORD_GENERATOR));
        int passwordLength = systemModuleService.getSysParameterValue(int.class,
                SecurityModuleSysParamConstants.USER_PASSWORD_LENGTH);

        String plainPassword = passwordGenerator.generatePassword(wfItemReader.read(String.class, "loginId"),
                passwordLength);
        String encryptedPassword = passwordCryptograph.encrypt(plainPassword);
        wfItemWriter.writeScratch("plainPassword", plainPassword);
        wfItemWriter.write("password", encryptedPassword);
    }

    @Override
    public List<? extends Listable> getRuleList(Locale locale) throws UnifyException {
        return Collections.emptyList();
    }
}
