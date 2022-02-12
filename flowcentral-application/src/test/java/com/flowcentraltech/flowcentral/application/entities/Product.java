/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.application.constants.ProductCategory;
import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Test product bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table
public class Product extends BaseAuditEntity {

    @ForeignKey
    private ProductCategory category;

    @Column(name = "PRODUCT_NM")
    private String name;

    @Column(name = "PRODUCT_DESC")
    private String description;

    @Column(length = 512, nullable = true)
    private String notes;

    @Column
    private Double costPrice;

    @Column
    private Double salesPrice;

    @ListOnly(key = "category", property = "description")
    private String categoryDesc;

    public Product(ProductCategory category, String name, String description, Double costPrice, Double salesPrice) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.costPrice = costPrice;
        this.salesPrice = salesPrice;
    }

    public Product() {

    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    @Override
    public String toString() {
        return StringUtils.toXmlString(this);
    }

}
