/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.data.EntityClassDef;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.RefDef;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.constant.FileAttachmentType;
import com.tcdng.unify.core.criterion.Update;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.ui.widget.control.AbstractFileUploadViewHandler;
import com.tcdng.unify.web.ui.widget.data.FileAttachmentInfo;

/**
 * File upload view handler for blob references.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("refblob-fileuploadviewhandler")
public class RefBlobFileUploadViewHandler extends AbstractFileUploadViewHandler {

    @Configurable
    private ApplicationModuleService applicationService;

    @Configurable
    private EnvironmentService environmentService;

    public final void setApplicationService(ApplicationModuleService applicationService) {
        this.applicationService = applicationService;
    }

    public final void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object save(Object id, String category, FileAttachmentType type, String filename, byte[] attachment)
            throws UnifyException {
        final RefDef refDef = applicationService.getRefDef(category);
        final EntityClassDef entityClassDef = applicationService.getEntityClassDef(refDef.getEntity());
        final EntityDef entityDef = entityClassDef.getEntityDef();
        final String blobFieldName = entityDef.getBlobFieldName();
        final String blobDescFieldName = entityDef.getBlobDescFieldName();
        if (id == null) {
            Entity inst = entityClassDef.newInst();
            DataUtils.setBeanProperty(inst, blobFieldName, attachment);
            if (!StringUtils.isBlank(blobDescFieldName)) {
                DataUtils.setBeanProperty(inst, blobDescFieldName, filename);
            }

            return environmentService.create(inst);
        }

        Update update = new Update().add(blobFieldName, attachment);
        if (!StringUtils.isBlank(blobDescFieldName)) {
            update.add(blobDescFieldName, filename);
        }
        environmentService.updateById((Class<? extends Entity>) entityClassDef.getEntityClass(), id, update);
        return id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public FileAttachmentInfo retrive(Object id, String category, FileAttachmentType type) throws UnifyException {
        final RefDef refDef = applicationService.getRefDef(category);
        final EntityClassDef entityClassDef = applicationService.getEntityClassDef(refDef.getEntity());
        final EntityDef entityDef = entityClassDef.getEntityDef();
        final String blobFieldName = entityDef.getBlobFieldName();
        final String blobDescFieldName = entityDef.getBlobDescFieldName();
        Entity inst = environmentService.find((Class<? extends Entity>) entityClassDef.getEntityClass(), id);
        byte[] attachment = DataUtils.getBeanProperty(byte[].class, inst, blobFieldName);
        String filename = !StringUtils.isBlank(blobDescFieldName)
                ? DataUtils.getBeanProperty(String.class, inst, blobDescFieldName)
                : null;

        FileAttachmentInfo fileAttachmentInfo = new FileAttachmentInfo(type);
        fileAttachmentInfo.setFilename(filename);
        fileAttachmentInfo.setAttachment(attachment);
        return fileAttachmentInfo;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void delete(Object id, String category, Object parentId, String parentCategory, String parentFieldName)
            throws UnifyException {
        final RefDef refDef = applicationService.getRefDef(category);
        final EntityClassDef entityClassDef = applicationService.getEntityClassDef(refDef.getEntity());
        if (parentId != null && !StringUtils.isBlank(parentCategory) || !StringUtils.isBlank(parentFieldName)) {
            final EntityClassDef _parentEntityClassDef = applicationService.getEntityClassDef(parentCategory);
            environmentService.updateById((Class<? extends Entity>) _parentEntityClassDef.getEntityClass(), parentId,
                    new Update().add(parentFieldName, null));
        }
        environmentService.delete((Class<? extends Entity>) entityClassDef.getEntityClass(), id);
    }

}
