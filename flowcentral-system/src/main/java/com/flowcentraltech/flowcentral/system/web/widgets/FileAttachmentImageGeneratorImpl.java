/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.web.widgets;

import java.io.IOException;
import java.io.OutputStream;

import com.flowcentraltech.flowcentral.common.business.FileAttachmentProvider;
import com.flowcentraltech.flowcentral.common.data.Attachment;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.Singleton;
import com.tcdng.unify.core.resource.AbstractImageGenerator;
import com.tcdng.unify.core.resource.ImageFormat;

/**
 * Implementation of file attachment image generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Singleton(false)
@Component("fileattachment-imagegenerator")
public class FileAttachmentImageGeneratorImpl extends AbstractImageGenerator implements FileAttachmentImageGenerator {

    @Configurable
    private FileAttachmentProvider fileAttachmentProvider;

    private String category;

    private String entityName;

    private String attachmentName;

    private Long entityInstId;

    private byte[] photo;

    public void setFileAttachmentProvider(FileAttachmentProvider fileAttachmentProvider) {
        this.fileAttachmentProvider = fileAttachmentProvider;
    }

    @Override
    public ImageFormat generate(OutputStream outputStream) throws UnifyException {
        try {
            outputStream.write(photo);
            outputStream.flush();
        } catch (IOException e) {
            throwOperationErrorException(e);
        } finally {
            photo = null;
        }

        return ImageFormat.WILDCARD;
    }

    @Override
    public boolean isReady() throws UnifyException {
        if (photo == null) {
            Attachment attachment = fileAttachmentProvider.retrieveFileAttachment(category, entityName, entityInstId,
                    attachmentName);
            if (attachment != null) {
                photo = attachment.getData();
                return true;
            }
        }

        return false;
    }

    @Override
    public void init(String category, String entityName, String attachmentName) {
        this.category = category;
        this.entityName = entityName;
        this.attachmentName = attachmentName;
    }

    @Override
    public void prepareGenerationFor(Long entityInstId) {
        this.entityInstId = entityInstId;
    }

}
