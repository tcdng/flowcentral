/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels;

import com.flowcentraltech.flowcentral.common.business.CollaborationProvider;
import com.flowcentraltech.flowcentral.studio.web.panels.applet.StudioAppComponentApplet;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.ui.widget.AbstractPanel;

/**
 * Convenient abstract base class for studio editor page panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@UplBinding("web/studio/upl/studioeditorpagepanel.upl")
public abstract class AbstractStudioEditorPagePanel extends AbstractPanel {

    @Configurable
    private CollaborationProvider collaborationProvider;

    public void setCollaborationProvider(CollaborationProvider collaborationProvider) {
        this.collaborationProvider = collaborationProvider;
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();
        final StudioAppComponentApplet applet = (StudioAppComponentApplet) getValueStore().getValueObject();
        final boolean isCollaboration = applet.isCollaboration() && collaborationProvider != null
                && collaborationProvider.isLicensedForCollaboration();
        final boolean isEditable = !applet.getCtx().isReadOnly();
        if (isCollaboration) {
            AbstractStudioEditorPage editorPage = getValue(AbstractStudioEditorPage.class);
            if (isEditable) {
                editorPage.setDisplayItemCounterClass("fc-dispcountergreen");
                editorPage.setDisplayItemCounter(
                        resolveSessionMessage("$m{entityformapplet.form.collaboration.editable}"));
            } else {
                editorPage.setDisplayItemCounterClass(null);
                editorPage.setDisplayItemCounter(
                        resolveSessionMessage("$m{entityformapplet.form.collaboration.viewonly}"));
            }
        }
        setVisible("displayCounterLabel", isCollaboration);
    }

    protected boolean isAppletContextReadOnly() throws UnifyException {
        return ((StudioAppComponentApplet) getValueStore().getValueObject()).getCtx().isReadOnly();
    }
}
