/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntity;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.FactoryMap;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Application name utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class ApplicationNameUtils {

    public static final String RESERVED_FC_PREFIX = "__";

    private static final FactoryMap<String, ApplicationEntityNameParts> applicationNameParts;

    private static final FactoryMap<String, EntityAssignRuleNameParts> assignRuleNameParts;

    static {
        applicationNameParts = new FactoryMap<String, ApplicationEntityNameParts>()
        {

            @Override
            protected ApplicationEntityNameParts create(String longName, Object... arg1) throws Exception {
                try {
                    String[] po = StringUtils.dotSplit(longName);
                    return new ApplicationEntityNameParts(longName, po[0], po[1]);
                } catch (Exception e) {
                    throw new RuntimeException("Name parts error: longName = " + longName, e);
                }
            }

        };
        
        assignRuleNameParts = new FactoryMap<String, EntityAssignRuleNameParts>()
        {

            @Override
            protected EntityAssignRuleNameParts create(String assignRule, Object... arg1) throws Exception {
                try {
                    String[] po = StringUtils.charSplit(assignRule, ':');
                    if (po.length == 4) {
                        return new EntityAssignRuleNameParts(po[0], po[1], po[2], po[3]);
                    } else {
                        return new EntityAssignRuleNameParts(po[0], po[1], po[2], null);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Name parts error: assignRule = " + assignRule, e);
                }
            }

        };
    }

    private ApplicationNameUtils() {

    }

    public static EntityAssignRuleNameParts getEntityAssignRuleNameParts(String assignRule) throws UnifyException {
        return assignRuleNameParts.get(assignRule);
    }

    public static String getApplicationEntityLongName(String applicationName, String entityName) {
        return StringUtils.dotify(applicationName, entityName);
    }

    public static ApplicationEntityNameParts getApplicationEntityNameParts(String longName) throws UnifyException {
        return applicationNameParts.get(longName);
    }

    public static String ensureLongNameReference(String defaultApplicationName, String entityName) {
        if (!StringUtils.isBlank(entityName)) {
            if (entityName.indexOf('.') > 0) {
                return entityName;
            }

            return ApplicationNameUtils.getApplicationEntityLongName(defaultApplicationName, entityName);
        }

        return null;
    }

    public static List<String> getApplicationEntityLongNames(List<? extends BaseApplicationEntity> appEntityList) {
        if (!DataUtils.isBlank(appEntityList)) {
            List<String> list = new ArrayList<String>();
            for (BaseApplicationEntity appEntity : appEntityList) {
                list.add(ApplicationNameUtils.getApplicationEntityLongName(appEntity.getApplicationName(),
                        appEntity.getName()));
            }

            return list;
        }

        return Collections.emptyList();
    }

    public static List<ListData> getListableList(List<? extends BaseApplicationEntity> appEntityList) throws UnifyException {
        if (!DataUtils.isBlank(appEntityList)) {
            List<ListData> list = new ArrayList<ListData>();
            for (BaseApplicationEntity appEntity : appEntityList) {
                list.add(new ListData(ApplicationNameUtils.getApplicationEntityLongName(appEntity.getApplicationName(),
                        appEntity.getName()), appEntity.getDescription()));
            }

            DataUtils.sortAscending(list, ListData.class, "listDescription");
            return list;
        }

        return Collections.emptyList();
    }
    
    public static String addVestigialNamePart(String longName, String vestigial) {
        return longName + "_0_" + vestigial;
    }
    
    public static String removeVestigialNamePart(String longName) {
        int index = longName.indexOf("_0_");
        if (index > 0) {
            return longName.substring(0, index);
        }
        
        return longName;
    }
}
