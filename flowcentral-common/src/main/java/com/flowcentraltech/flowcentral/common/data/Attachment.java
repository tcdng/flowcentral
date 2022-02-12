/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.Arrays;

import com.tcdng.unify.core.constant.FileAttachmentType;

/**
 * Attachment.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class Attachment {

    private Long id;

    private FileAttachmentType type;

    private String name;

    private String title;

    private String fileName;

    private byte[] data;

    private long versionNo;

    private Attachment(Long id, FileAttachmentType type, String name, String title, String fileName, byte[] data,
            long versionNo) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.title = title;
        this.fileName = fileName;
        this.data = data;
        this.versionNo = versionNo;
    }

    public Long getId() {
        return id;
    }

    public FileAttachmentType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getData() {
        return data;
    }

    public long getVersionNo() {
        return versionNo;
    }

    public static Builder newBuilder(Long id, FileAttachmentType type, long versionNo) {
        return new Builder(id, type, versionNo);
    }

    public static Builder newBuilder(FileAttachmentType type) {
        return new Builder(null, type, 0L);
    }

    public static class Builder {

        private Long id;

        private FileAttachmentType type;

        private String name;

        private String title;

        private String fileName;

        private byte[] data;

        private long versionNo;

        public Builder(Long id, FileAttachmentType type, long versionNo) {
            this.id = id;
            this.type = type;
            this.versionNo = versionNo;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public Attachment build() {
            if (type == null) {
                throw new RuntimeException("Attachment type is required.");
            }

            if (name == null) {
                throw new RuntimeException("Attachment name is required.");
            }

            if (title == null) {
                throw new RuntimeException("Attachment title is required.");
            }

            if (data == null) {
                throw new RuntimeException("Attachment data is required.");
            }

            return new Attachment(id, type, name, title, fileName, data, versionNo);
        }
    }

    @Override
    public String toString() {
        return "Attachment [type=" + type + ", name=" + name + ", title=" + title + ", versionNo=" + versionNo
                + ", fileName=" + fileName + ", data=" + Arrays.toString(data) + "]";
    }
}
