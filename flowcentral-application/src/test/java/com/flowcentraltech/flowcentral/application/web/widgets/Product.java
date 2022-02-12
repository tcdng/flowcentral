/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

/**
 * Test product bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class Product {

    private String name;

    private String description;

    private Double costPrice;

    private Double salesPrice;

    public Product(String name, String description, Double costPrice, Double salesPrice) {
        this.name = name;
        this.description = description;
        this.costPrice = costPrice;
        this.salesPrice = salesPrice;
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

}
