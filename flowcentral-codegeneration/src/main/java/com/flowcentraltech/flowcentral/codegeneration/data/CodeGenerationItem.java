/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.data;

/**
 * Code generation item.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class CodeGenerationItem {

    private String sourceName;

    private String basePackage;
    
    private String filename;
    
    private byte[] data;

    public CodeGenerationItem(String basePackage, String sourceName) {
        this.basePackage = basePackage;
        this.sourceName = sourceName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    
}
