/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.util;

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.FactoryMap;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Workflow name utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class WorkflowNameUtils {

    public static final String RESERVED_WORKFLOW_APPLET_PREFIX = ApplicationNameUtils.RESERVED_FC_PREFIX + "wf_";

    public static final String RESERVED_WORKFLOW_WIZARD_PREFIX = ApplicationNameUtils.RESERVED_FC_PREFIX + "wfz_";

    private static final FactoryMap<String, WfAppletNameParts> wfAppletNameParts;

    private static final FactoryMap<String, WfWizardAppletNameParts> wfWizardAppletNameParts;

    static {
        wfAppletNameParts = new FactoryMap<String, WfAppletNameParts>()
            {

                @Override
                protected WfAppletNameParts create(String wfAppletName, Object... arg1) throws Exception {
                    String actAppletName = wfAppletName.substring(RESERVED_WORKFLOW_APPLET_PREFIX.length());
                    String[] po = StringUtils.charSplit(actAppletName, '_');
                    return new WfAppletNameParts(po[0], po[1]);
                }

            };

        wfWizardAppletNameParts = new FactoryMap<String, WfWizardAppletNameParts>()
            {

                @Override
                protected WfWizardAppletNameParts create(String wfWizardAppletName, Object... arg1) throws Exception {
                    String actAppletName = wfWizardAppletName.substring(RESERVED_WORKFLOW_WIZARD_PREFIX.length());
                    return new WfWizardAppletNameParts(actAppletName);
                }

            };
    }

    private WorkflowNameUtils() {

    }

    public static WfAppletNameParts getWfAppletNameParts(String wfAppletName) throws UnifyException {
        return wfAppletNameParts.get(wfAppletName);
    }

    public static String getWfAppletName(String workflowName, String stepName) {
        return RESERVED_WORKFLOW_APPLET_PREFIX + workflowName + "_" + stepName;
    }

    public static boolean isWfAppletName(String wfAppletName) {
        return wfAppletName.startsWith(RESERVED_WORKFLOW_APPLET_PREFIX);
    }

    public static WfWizardAppletNameParts getWfWizardAppletNameParts(String wfWizardAppletName) throws UnifyException {
        return wfWizardAppletNameParts.get(wfWizardAppletName);
    }

    public static String getWfWizardAppletName(String wfWizardName) {
        return RESERVED_WORKFLOW_WIZARD_PREFIX + wfWizardName;
    }

    public static boolean isWfWizardAppletName(String wfWizardAppletName) {
        return wfWizardAppletName.startsWith(RESERVED_WORKFLOW_WIZARD_PREFIX);
    }

    public static class WfAppletNameParts {

        private String workflow;

        private String stepName;

        public WfAppletNameParts(String workflow, String stepName) {
            this.workflow = workflow;
            this.stepName = stepName;
        }

        public String getWorkflow() {
            return workflow;
        }

        public String getStepName() {
            return stepName;
        }

    }

    public static class WfWizardAppletNameParts {

        private String wizard;

        public WfWizardAppletNameParts(String wizard) {
            this.wizard = wizard;
        }

        public String getWizard() {
            return wizard;
        }

    }
}
