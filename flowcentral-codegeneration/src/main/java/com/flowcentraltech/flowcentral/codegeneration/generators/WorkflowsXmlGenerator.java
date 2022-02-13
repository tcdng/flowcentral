/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

import com.flowcentraltech.flowcentral.application.util.InputWidgetUtils;
import com.flowcentraltech.flowcentral.configuration.xml.AppWorkflowConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppWorkflowWizardConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppWorkflowWizardsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppWorkflowsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.FilterConfig;
import com.flowcentraltech.flowcentral.configuration.xml.SetValuesConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfAlertConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfAlertsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfChannelConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfChannelsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfRoutingConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfRoutingsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfStepConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfStepsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfUserActionConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfUserActionsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfWizardConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfWizardStepConfig;
import com.flowcentraltech.flowcentral.configuration.xml.util.ConfigurationUtils;
import com.flowcentraltech.flowcentral.workflow.business.WorkflowModuleService;
import com.flowcentraltech.flowcentral.workflow.entities.WfChannel;
import com.flowcentraltech.flowcentral.workflow.entities.WfStep;
import com.flowcentraltech.flowcentral.workflow.entities.WfStepAlert;
import com.flowcentraltech.flowcentral.workflow.entities.WfStepRouting;
import com.flowcentraltech.flowcentral.workflow.entities.WfStepUserAction;
import com.flowcentraltech.flowcentral.workflow.entities.WfWizard;
import com.flowcentraltech.flowcentral.workflow.entities.WfWizardStep;
import com.flowcentraltech.flowcentral.workflow.entities.Workflow;
import com.flowcentraltech.flowcentral.workflow.entities.WorkflowFilter;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.core.util.NameUtils;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Workflows XML Generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("workflows-xml-generator")
public class WorkflowsXmlGenerator extends AbstractStaticArtifactGenerator {

    private static final String WORKFLOW_FOLDER = "apps/workflow/";

    @Configurable
    private WorkflowModuleService workflowModuleService;
    
    public WorkflowsXmlGenerator() {
        super("src/main/resources/apps/workflow/");
    }

    public void setWorkflowModuleService(WorkflowModuleService workflowModuleService) {
        this.workflowModuleService = workflowModuleService;
    }

    @Override
    protected void doGenerate(ExtensionModuleStaticFileBuilderContext ctx, String applicationName, ZipOutputStream zos)
            throws UnifyException {
        // Workflows
        List<Long> workflowIdList = workflowModuleService.findWorkflowIdList(applicationName);
        if (!DataUtils.isBlank(workflowIdList)) {
            final String lowerCaseApplicationName = applicationName.toLowerCase();

            AppWorkflowsConfig workflowsConfig = new AppWorkflowsConfig();
            List<AppWorkflowConfig> workflowConfigList = new ArrayList<AppWorkflowConfig>();
            for (Long reportConfigId : workflowIdList) {
                AppWorkflowConfig appWorkflowConfig = new AppWorkflowConfig();
                Workflow workflow = workflowModuleService.findWorkflow(reportConfigId);
                final String filename = StringUtils.dashen(NameUtils.describeName(workflow.getName())) + ".xml";
                openEntry(filename, zos);

                WfConfig workflowConfig = new WfConfig();
                String descKey = getDescriptionKey(lowerCaseApplicationName, "workflow", workflow.getName());
                String labelKey = descKey + ".label";
                final String workflowDescKey = descKey;
                ctx.addMessage(StaticMessageCategoryType.WORKFLOW, descKey, workflow.getDescription());
                ctx.addMessage(StaticMessageCategoryType.WORKFLOW, labelKey, workflow.getLabel());

                workflowConfig.setName(workflow.getName());
                workflowConfig.setDescription("$m{" + descKey + "}");
                workflowConfig.setLabel("$m{" + labelKey + "}");
                workflowConfig.setDescFormat(workflow.getDescFormat());
                workflowConfig.setEntity(workflow.getEntity());

                // Filters
                if (!DataUtils.isBlank(workflow.getFilterList())) {
                    List<FilterConfig> filterList = new ArrayList<FilterConfig>();
                    for (WorkflowFilter workflowFilter : workflow.getFilterList()) {
                        FilterConfig filterConfig = InputWidgetUtils.getFilterConfig(workflowFilter.getFilter());
                        filterConfig.setName(workflowFilter.getName());
                        descKey = getDescriptionKey(workflowDescKey, "workflowfilter", workflowFilter.getName());
                        ctx.addMessage(StaticMessageCategoryType.WORKFLOW, descKey, workflowFilter.getDescription());
                        filterConfig.setDescription("$m{" + descKey + "}");
                        filterList.add(filterConfig);
                    }

                    workflowConfig.setFilterList(filterList);
                    ;
                }

                // Steps
                if (!DataUtils.isBlank(workflow.getStepList())) {
                    WfStepsConfig stepsConfig = new WfStepsConfig();
                    List<WfStepConfig> stepList = new ArrayList<WfStepConfig>();
                    for (WfStep wfStep : workflow.getStepList()) {
                        WfStepConfig wfStepConfig = new WfStepConfig();
                        descKey = getDescriptionKey(workflowDescKey, "workflowstep", wfStep.getName());
                        labelKey = descKey + ".label";
                        final String stepDescKey = descKey;
                        ctx.addMessage(StaticMessageCategoryType.WORKFLOW, descKey, wfStep.getDescription());
                        ctx.addMessage(StaticMessageCategoryType.WORKFLOW, labelKey, wfStep.getLabel());

                        wfStepConfig.setType(wfStep.getType());
                        wfStepConfig.setPriority(wfStep.getPriority());
                        wfStepConfig.setActionType(wfStep.getRecordActionType());
                        wfStepConfig.setName(wfStep.getName());
                        wfStepConfig.setDescription("$m{" + descKey + "}");
                        wfStepConfig.setLabel("$m{" + labelKey + "}");
                        wfStepConfig.setAppletName(wfStep.getAppletName());
                        wfStepConfig.setCriticalMinutes(wfStep.getCriticalMinutes());
                        wfStepConfig.setExpiryMinutes(wfStep.getExpiryMinutes());
                        wfStepConfig.setAudit(wfStep.isAudit());
                        wfStepConfig.setBranchOnly(wfStep.isBranchOnly());
                        wfStepConfig.setIncludeForwarder(wfStep.isIncludeForwarder());
                        wfStepConfig.setForwarderPreffered(wfStep.isForwarderPreffered());
                        wfStepConfig.setNextStepName(wfStep.getNextStepName());
                        wfStepConfig.setAltNextStepName(wfStep.getAltNextStepName());
                        wfStepConfig.setBinaryCondition(wfStep.getBinaryConditionName());
                        wfStepConfig.setReadOnlyCondition(wfStepConfig.getReadOnlyCondition());
                        wfStepConfig.setPolicy(wfStep.getPolicy());
                        wfStepConfig.setRule(wfStep.getRule());

                        // Set values
                        if (wfStep.getSetValues() != null) {
                            SetValuesConfig setValuesConfig = InputWidgetUtils
                                    .getSetValuesConfig(null, wfStep.getSetValues().getSetValues());
                            wfStepConfig.setSetValuesConfig(setValuesConfig);
                        }

                        // Routings
                        if (!DataUtils.isBlank(wfStep.getRoutingList())) {
                            WfRoutingsConfig wfRoutingsConfig = new WfRoutingsConfig();
                            List<WfRoutingConfig> wfRoutingConfigList = new ArrayList<WfRoutingConfig>();
                            for (WfStepRouting wfStepRouting : wfStep.getRoutingList()) {
                                WfRoutingConfig wfRoutingConfig = new WfRoutingConfig();
                                descKey = getDescriptionKey(stepDescKey, "routing", wfStepRouting.getName());
                                ctx.addMessage(StaticMessageCategoryType.WORKFLOW, descKey,
                                        wfStepRouting.getDescription());

                                wfRoutingConfig.setName(wfStepRouting.getName());
                                wfRoutingConfig.setDescription("$m{" + descKey + "}");
                                wfRoutingConfig.setCondition(wfStepRouting.getConditionName());
                                wfRoutingConfig.setNextStepName(wfStepRouting.getNextStepName());
                                wfRoutingConfigList.add(wfRoutingConfig);
                            }

                            wfRoutingsConfig.setWfRoutingConfigList(wfRoutingConfigList);
                            wfStepConfig.setWfRoutingsConfig(wfRoutingsConfig);
                        }

                        // UserActions
                        if (!DataUtils.isBlank(wfStep.getUserActionList())) {
                            WfUserActionsConfig wfUserActionsConfig = new WfUserActionsConfig();
                            List<WfUserActionConfig> wfUserActionConfigList = new ArrayList<WfUserActionConfig>();
                            for (WfStepUserAction wfStepUserAction : wfStep.getUserActionList()) {
                                WfUserActionConfig wfUserActionConfig = new WfUserActionConfig();
                                descKey = getDescriptionKey(stepDescKey, "useraction", wfStepUserAction.getName());
                                labelKey = descKey + ".label";
                                ctx.addMessage(StaticMessageCategoryType.WORKFLOW, descKey,
                                        wfStepUserAction.getDescription());
                                ctx.addMessage(StaticMessageCategoryType.WORKFLOW, labelKey,
                                        wfStepUserAction.getLabel());

                                wfUserActionConfig.setCommentRequirement(wfStepUserAction.getCommentRequirement());
                                wfUserActionConfig.setName(wfStepUserAction.getName());
                                wfUserActionConfig.setDescription("$m{" + descKey + "}");
                                wfUserActionConfig.setLabel("$m{" + labelKey + "}");
                                wfUserActionConfig.setNextStepName(wfStepUserAction.getNextStepName());
                                wfUserActionConfig.setOrderIndex(wfStepUserAction.getOrderIndex());
                                wfUserActionConfig.setValidatePage(wfStepUserAction.isValidatePage());
                                wfUserActionConfig.setForwarderPreferred(wfStepUserAction.isForwarderPreferred());
                                wfUserActionConfigList.add(wfUserActionConfig);
                            }

                            wfUserActionsConfig.setWfUserActionConfigList(wfUserActionConfigList);
                            wfStepConfig.setWfUserActionsConfig(wfUserActionsConfig);
                        }

                        // Alerts
                        if (!DataUtils.isBlank(wfStep.getAlertList())) {
                            WfAlertsConfig wfAlertsConfig = new WfAlertsConfig();
                            List<WfAlertConfig> wfAlertConfigList = new ArrayList<WfAlertConfig>();
                            for (WfStepAlert wfStepAlert : wfStep.getAlertList()) {
                                WfAlertConfig wfAlertConfig = new WfAlertConfig();
                                descKey = getDescriptionKey(stepDescKey, "alert", wfStepAlert.getName());
                                ctx.addMessage(StaticMessageCategoryType.WORKFLOW, descKey,
                                        wfStepAlert.getDescription());

                                wfAlertConfig.setType(wfStepAlert.getType());
                                wfAlertConfig.setNotificationType(wfStepAlert.getNotificationType());
                                wfAlertConfig.setName(wfStepAlert.getName());
                                wfAlertConfig.setDescription("$m{" + descKey + "}");
                                wfAlertConfig.setRecipientPolicy(wfStepAlert.getRecipientPolicy());
                                wfAlertConfig.setRecipientNameRule(wfStepAlert.getRecipientNameRule());
                                wfAlertConfig.setRecipientContactRule(wfStepAlert.getRecipientContactRule());
                                wfAlertConfig.setTemplate(wfStepAlert.getTemplate());
                                wfAlertConfig.setFireOnPrevStepName(wfStepAlert.getFireOnPrevStepName());
                                wfAlertConfig.setFireOnCondition(wfStepAlert.getFireOnConditionName());
                                wfAlertConfigList.add(wfAlertConfig);
                            }

                            wfAlertsConfig.setWfAlertConfigList(wfAlertConfigList);
                            wfStepConfig.setWfAlertsConfig(wfAlertsConfig);
                        }

                        stepList.add(wfStepConfig);
                    }

                    stepsConfig.setStepList(stepList);
                    workflowConfig.setStepsConfig(stepsConfig);
                }

                ConfigurationUtils.writeConfigNoEscape(workflowConfig, zos);
                closeEntry(zos);

                appWorkflowConfig.setConfigFile(WORKFLOW_FOLDER + filename);
                workflowConfigList.add(appWorkflowConfig);
                ctx.addMessageGap(StaticMessageCategoryType.WORKFLOW);
            }

            workflowsConfig.setWorkflowList(workflowConfigList);
            ctx.setWorkflowsConfig(workflowsConfig);
        }

        // Workflow Channels
        List<Long> wfChannelIdList = workflowModuleService.findWfChannelIdList(applicationName);
        if (!DataUtils.isBlank(wfChannelIdList)) {
            final String lowerCaseApplicationName = applicationName.toLowerCase();

            WfChannelsConfig appWfChannelsConfig = new WfChannelsConfig();
            List<WfChannelConfig> wfChannelConfigList = new ArrayList<WfChannelConfig>();
            for (Long wfChannelId : wfChannelIdList) {
                WfChannelConfig wfChannelConfig = new WfChannelConfig();
                WfChannel wfChannel = workflowModuleService.findWfChannel(wfChannelId);
                String descKey = getDescriptionKey(lowerCaseApplicationName, "workflowchannel", wfChannel.getName());
                String labelKey = descKey + ".label";
                ctx.addMessage(StaticMessageCategoryType.WORKFLOW, descKey, wfChannel.getDescription());
                ctx.addMessage(StaticMessageCategoryType.WORKFLOW, labelKey, wfChannel.getLabel());

                wfChannelConfig.setName(wfChannel.getName());
                wfChannelConfig.setDescription("$m{" + descKey + "}");
                wfChannelConfig.setLabel("$m{" + labelKey + "}");
                wfChannelConfig.setEntity(wfChannel.getEntity());
                wfChannelConfig.setDestination(wfChannel.getDestination());
                wfChannelConfig.setRule(wfChannel.getRule());
                wfChannelConfig.setDirection(wfChannel.getDirection());
                wfChannelConfigList.add(wfChannelConfig);
            }

            appWfChannelsConfig.setChannelList(wfChannelConfigList);
            ctx.setWfChannelsConfig(appWfChannelsConfig);
            ctx.addMessageGap(StaticMessageCategoryType.WORKFLOW);
        }

        // Workflow wizards
        List<Long> wfWizardIdList = workflowModuleService.findWfWizardIdList(applicationName);
        if (!DataUtils.isBlank(wfWizardIdList)) {
            final String lowerCaseApplicationName = applicationName.toLowerCase();

            AppWorkflowWizardsConfig workflowWizardsConfig = new AppWorkflowWizardsConfig();
            List<AppWorkflowWizardConfig> workflowWizardConfigList = new ArrayList<AppWorkflowWizardConfig>();
            for (Long wfWizardId : wfWizardIdList) {
                AppWorkflowWizardConfig appWorkflowWizardConfig = new AppWorkflowWizardConfig();
                WfWizard wfWizard = workflowModuleService.findWfWizard(wfWizardId);
                final String filename = StringUtils.dashen(NameUtils.describeName(wfWizard.getName())) + "-wizard.xml";
                openEntry(filename, zos);

                WfWizardConfig wfWizardConfig = new WfWizardConfig();
                String descKey = getDescriptionKey(lowerCaseApplicationName, "workflowwizard", wfWizard.getName());
                String labelKey = descKey + ".label";
                final String wizardDescKey = descKey;
                ctx.addMessage(StaticMessageCategoryType.WORKFLOW, descKey, wfWizard.getDescription());
                ctx.addMessage(StaticMessageCategoryType.WORKFLOW, labelKey, wfWizard.getLabel());

                wfWizardConfig.setName(wfWizard.getName());
                wfWizardConfig.setDescription("$m{" + descKey + "}");
                wfWizardConfig.setLabel("$m{" + labelKey + "}");
                wfWizardConfig.setEntity(wfWizard.getEntity());
                wfWizardConfig.setSubmitWorkflow(wfWizard.getSubmitWorkflow());

                // Steps
                if (!DataUtils.isBlank(wfWizard.getStepList())) {
                    List<WfWizardStepConfig> stepList = new ArrayList<WfWizardStepConfig>();
                    for (WfWizardStep wfWizardStep : wfWizard.getStepList()) {
                        WfWizardStepConfig wfWizardStepConfig = new WfWizardStepConfig();
                        descKey = getDescriptionKey(wizardDescKey, "step", wfWizardStep.getName());
                        labelKey = descKey + ".label";
                        ctx.addMessage(StaticMessageCategoryType.WORKFLOW, descKey, wfWizardStep.getDescription());
                        ctx.addMessage(StaticMessageCategoryType.WORKFLOW, labelKey, wfWizardStep.getLabel());

                        wfWizardStepConfig.setName(wfWizardStep.getName());
                        wfWizardStepConfig.setDescription("$m{" + descKey + "}");
                        wfWizardStepConfig.setLabel("$m{" + labelKey + "}");
                        wfWizardStepConfig.setForm(wfWizardStep.getForm());
                        wfWizardStepConfig.setReference(wfWizardStep.getReference());
                        stepList.add(wfWizardStepConfig);
                    }

                    wfWizardConfig.setStepList(stepList);
                }

                ConfigurationUtils.writeConfigNoEscape(wfWizardConfig, zos);
                closeEntry(zos);

                appWorkflowWizardConfig.setConfigFile(WORKFLOW_FOLDER + filename);
                workflowWizardConfigList.add(appWorkflowWizardConfig);
                ctx.addMessageGap(StaticMessageCategoryType.WORKFLOW);
            }

            workflowWizardsConfig.setWorkflowWizardList(workflowWizardConfigList);
            ctx.setWorkflowWizardsConfig(workflowWizardsConfig);
        }
    }

}