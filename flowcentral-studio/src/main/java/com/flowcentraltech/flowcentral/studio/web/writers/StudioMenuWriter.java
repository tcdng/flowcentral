/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.writers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.data.AppletDef;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.common.business.CodeGenerationProvider;
import com.flowcentraltech.flowcentral.common.business.CollaborationProvider;
import com.flowcentraltech.flowcentral.studio.business.StudioModuleService;
import com.flowcentraltech.flowcentral.studio.constants.StudioAppComponentType;
import com.flowcentraltech.flowcentral.studio.constants.StudioSessionAttributeConstants;
import com.flowcentraltech.flowcentral.studio.web.widgets.StudioMenuWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.core.util.json.JsonWriter;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.WriteWork;
import com.tcdng.unify.web.ui.widget.writer.AbstractPanelWriter;

/**
 * Studio menu writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(StudioMenuWidget.class)
@Component("fc-studiomenu-writer")
public class StudioMenuWriter extends AbstractPanelWriter {

    private static final String ORIGINAL_MENU_PATHID = "originalStudio.menu.pathID";

    @Configurable
    private StudioModuleService studioModuleService;

    @Configurable
    private ApplicationModuleService applicationModuleService;

    @Configurable
    private CollaborationProvider collaborationProvider;

    @Configurable
    private CodeGenerationProvider codeGenerationProvider;

    private List<StudioAppComponentType> menuCategoryList = Collections
            .unmodifiableList(Arrays.asList(StudioAppComponentType.CODEGENERATION, StudioAppComponentType.ENTITY, StudioAppComponentType.APPLET,
                    StudioAppComponentType.REFERENCE, StudioAppComponentType.CHART, StudioAppComponentType.DASHBOARD,
                    StudioAppComponentType.NOTIFICATION_TEMPLATE, StudioAppComponentType.REPORT_CONFIGURATION,
                    StudioAppComponentType.TABLE, StudioAppComponentType.FORM, StudioAppComponentType.WORKFLOW));

    private List<StudioAppComponentType> collaborationMenuCategoryList = Collections
            .unmodifiableList(Arrays.asList(StudioAppComponentType.COLLABORATION, StudioAppComponentType.CODEGENERATION,
                    StudioAppComponentType.ENTITY, StudioAppComponentType.APPLET, StudioAppComponentType.REFERENCE,
                    StudioAppComponentType.CHART, StudioAppComponentType.DASHBOARD,
                    StudioAppComponentType.NOTIFICATION_TEMPLATE, StudioAppComponentType.REPORT_CONFIGURATION,
                    StudioAppComponentType.TABLE, StudioAppComponentType.FORM, StudioAppComponentType.WORKFLOW));

    public final void setStudioModuleService(StudioModuleService studioModuleService) {
        this.studioModuleService = studioModuleService;
    }

    public final void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    public final void setCollaborationProvider(CollaborationProvider collaborationProvider) {
        this.collaborationProvider = collaborationProvider;
    }

    public final void setCodeGenerationProvider(CodeGenerationProvider codeGenerationProvider) {
        this.codeGenerationProvider = codeGenerationProvider;
    }

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        StudioMenuWidget studioMenuWidget = (StudioMenuWidget) widget;
        WriteWork work = studioMenuWidget.getWriteWork();
        writer.beginFunction("fuxstudio.rigStudioMenu");
        writer.writeParam("pId", studioMenuWidget.getId());
        writer.writeParam("pContId", studioMenuWidget.getContainerId());
        writer.writeParam("pCategoryId", studioMenuWidget.getCategoryId());
        // Resolves out of bean context error which usually happens on menu reload
        String originalPathId = (String) getSessionAttribute(ORIGINAL_MENU_PATHID);
        if (!StringUtils.isBlank(originalPathId)) {
            writer.writeCommandURLParam("pCmdURL", originalPathId);
        } else {
            originalPathId = getRequestContextUtil().getResponsePathParts().getControllerPathId();
            setSessionAttribute(ORIGINAL_MENU_PATHID, originalPathId);
            writer.writeCommandURLParam("pCmdURL");
        }

        writer.writeParam("pCurrSelCtrlId", studioMenuWidget.getCurrentSelCtrl().getId());
        writer.writeParam("pMenuCat", (JsonWriter) work.get(StudioMenuWidget.WORK_MENU_CATEGORIES));
        writer.writeParam("pMenuItems", (JsonWriter) work.get(StudioMenuWidget.WORK_MENU_ITEMS));
        writer.endFunction();
    }

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        StudioMenuWidget studioMenuWidget = (StudioMenuWidget) widget;
        writer.write("<div");
        writeTagAttributesWithTrailingExtraStyleClass(writer, studioMenuWidget, "g_fsm");
        writer.write("><div class=\"mheader\">");
        writer.write("<span>");
        writer.writeWithHtmlEscape(getSessionMessage("studio.menu.application.components"));
        writer.write("</span></div><div class=\"mbody\">");

        final boolean isCollaborationLicensed = collaborationProvider != null
                && collaborationProvider.isLicensedForCollaboration();
        final List<StudioAppComponentType> selMenuCategoryList = isCollaborationLicensed ? collaborationMenuCategoryList
                : menuCategoryList;
        StudioAppComponentType currCategory = studioMenuWidget.getCurrentSel();
        if (currCategory == null) {
            currCategory = isCollaborationLicensed ? StudioAppComponentType.COLLABORATION
                    : StudioAppComponentType.ENTITY;
            studioMenuWidget.setCurrentSel(currCategory);
        }

        final String applicationName = (String) getSessionAttribute(
                StudioSessionAttributeConstants.CURRENT_APPLICATION_NAME);
        final boolean application = !StringUtils.isBlank(applicationName);
        final boolean isCollaboration = StudioAppComponentType.COLLABORATION.equals(currCategory);
        final boolean isCodeGeneration = codeGenerationProvider != null
                && StudioAppComponentType.CODEGENERATION.equals(currCategory);
        final List<AppletDef> appletDefList = isCollaboration ? getCollaborationAppletDefs(applicationName)
                : (isCodeGeneration ? getCodeGenerationAppletDefs(applicationName)
                        : studioModuleService.findAppletDefs(applicationName, currCategory));

        writer.write("<div style=\"display:table;width:100%;height:100%;\"><div style=\"display:table-row;\">");
        // Category
        writer.write("<div class=\"menucatbar\" style=\"display:table-cell;vertical-align:top;\">");
        JsonWriter cjw = new JsonWriter();
        cjw.beginArray();
        if (application) {
            final String categoryId = studioMenuWidget.getCategoryId();
            final int catLen = selMenuCategoryList.size();
            for (int i = 0; i < catLen; i++) {
                final StudioAppComponentType category = selMenuCategoryList.get(i);
                writer.write("<div class=\"menucat");
                if (category.equals(currCategory)) {
                    writer.write(" activecat");
                } else {
                    writer.write("\" id=\"").write(categoryId).write(i);
                    cjw.beginObject();
                    cjw.write("index", i);
                    cjw.write("type", category.code());
                    cjw.endObject();
                }

                writer.write("\">");
                writer.write("<span class=\"symcat\">").write(resolveSymbolHtmlHexCode(category.icon()))
                        .write("</span>");
                writer.write("<span class=\"labelcat\">")
                        .writeWithHtmlEscape(resolveSessionMessage(category.caption2())).write("</span>");
                writer.write("</div>");
            }
        }
        cjw.endArray();
        writer.write("</div>");

        // Menu items
        writer.write("<div style=\"display:table-cell;vertical-align:top;\">");
        writer.write("<div class=\"menu\">");
        if (application) {
            writer.write("<div class=\"menucatcap\">");
            writer.writeWithHtmlEscape(resolveSessionMessage(currCategory.caption2()));
            writer.write("</div>");
        }
        writer.write("<ul>");
        JsonWriter mjw = new JsonWriter();
        mjw.beginArray();
        if (application) {
            for (AppletDef appletDef : appletDefList) {
                if (isCollaboration || isCodeGeneration || appletDef.isMenuAccess()) {
                    writer.write("<li id=\"item_").write(appletDef.getViewId()).write("\">");
                    writer.write("<span>").writeWithHtmlEscape(appletDef.getLabel()).write("</span>");
                    writer.write("</li>");
                    mjw.beginObject();
                    mjw.write("id", "item_" + appletDef.getViewId());
                    mjw.write("path", getContextURL(appletDef.getOpenPath()));
                    mjw.endObject();
                }
            }
        }
        mjw.endArray();
        writer.write("</ul></div>");
        writer.write("</div>");

        writer.write("</div></div>");

        WriteWork work = studioMenuWidget.getWriteWork();
        work.set(StudioMenuWidget.WORK_MENU_CATEGORIES, cjw);
        work.set(StudioMenuWidget.WORK_MENU_ITEMS, mjw);

        writer.writeStructureAndContent(studioMenuWidget.getCurrentSelCtrl());
        writer.write("</div></div>");
    }

    private List<AppletDef> getCollaborationAppletDefs(String applicationName) throws UnifyException {
        List<AppletDef> appletDefList = new ArrayList<AppletDef>();
        for (String appletName : collaborationProvider.getCollaborationApplets()) {
            appletDefList.add(applicationModuleService
                    .getAppletDef(ApplicationNameUtils.addVestigialNamePart(appletName, applicationName)));
        }
        return appletDefList;
    }

    private List<AppletDef> getCodeGenerationAppletDefs(String applicationName) throws UnifyException {
        List<AppletDef> appletDefList = new ArrayList<AppletDef>();
        for (String appletName : codeGenerationProvider.getCodeGenerationApplets()) {
            appletDefList.add(applicationModuleService
                    .getAppletDef(ApplicationNameUtils.addVestigialNamePart(appletName, applicationName)));
        }
        return appletDefList;
    }
}
