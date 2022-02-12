/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.FormType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.FormTypeXmlAdapter;

/**
 * Form configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFormConfig extends BaseNameConfig {

    private List<FormAnnotationConfig> annotationList;

    private List<FormActionConfig> actionList;

    private List<FormTabConfig> tabList;

    private List<RelatedListConfig> relatedList;

    private List<FormStatePolicyConfig> formStatePolicyList;

    private List<FieldValidationPolicyConfig> fieldValidationPolicyList;

    private List<FormValidationPolicyConfig> formValidationPolicyList;

    private List<FormReviewPolicyConfig> formReviewPolicyList;

    private FormType type;
    
    private String entity;

    private String listingGenerator;

    private String consolidatedValidation;

    private String consolidatedReview;

    private String consolidatedState;

    public AppFormConfig() {
        this.type = FormType.INPUT;
    }
    
    public List<FormAnnotationConfig> getAnnotationList() {
        return annotationList;
    }

    @XmlElement(name = "annotation")
    public void setAnnotationList(List<FormAnnotationConfig> annotationList) {
        this.annotationList = annotationList;
    }

    public List<FormActionConfig> getActionList() {
        return actionList;
    }

    @XmlElement(name = "action")
    public void setActionList(List<FormActionConfig> actionList) {
        this.actionList = actionList;
    }

    public List<FormTabConfig> getTabList() {
        return tabList;
    }

    @XmlElement(name = "tab", required = true)
    public void setTabList(List<FormTabConfig> tabList) {
        this.tabList = tabList;
    }

    public List<RelatedListConfig> getRelatedList() {
        return relatedList;
    }

    @XmlElement(name = "relatedList")
    public void setRelatedList(List<RelatedListConfig> relatedList) {
        this.relatedList = relatedList;
    }

    public List<FormStatePolicyConfig> getFormStatePolicyList() {
        return formStatePolicyList;
    }

    @XmlElement(name = "formStatePolicy")
    public void setFormStatePolicyList(List<FormStatePolicyConfig> formStatePolicyList) {
        this.formStatePolicyList = formStatePolicyList;
    }

    public List<FieldValidationPolicyConfig> getFieldValidationPolicyList() {
        return fieldValidationPolicyList;
    }

    @XmlElement(name = "fieldValidationPolicy")
    public void setFieldValidationPolicyList(List<FieldValidationPolicyConfig> fieldValidationPolicyList) {
        this.fieldValidationPolicyList = fieldValidationPolicyList;
    }

    public List<FormValidationPolicyConfig> getFormValidationPolicyList() {
        return formValidationPolicyList;
    }

    @XmlElement(name = "formValidationPolicy")
    public void setFormValidationPolicyList(List<FormValidationPolicyConfig> formValidationPolicyList) {
        this.formValidationPolicyList = formValidationPolicyList;
    }

    public List<FormReviewPolicyConfig> getFormReviewPolicyList() {
        return formReviewPolicyList;
    }

    @XmlElement(name = "formReviewPolicy")
    public void setFormReviewPolicyList(List<FormReviewPolicyConfig> formReviewPolicyList) {
        this.formReviewPolicyList = formReviewPolicyList;
    }

    public FormType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(FormTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setType(FormType type) {
        this.type = type;
    }

    public String getEntity() {
        return entity;
    }

    @XmlAttribute(required = true)
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getListingGenerator() {
        return listingGenerator;
    }

    @XmlAttribute
    public void setListingGenerator(String listingGenerator) {
        this.listingGenerator = listingGenerator;
    }

    public String getConsolidatedValidation() {
        return consolidatedValidation;
    }

    @XmlAttribute
    public void setConsolidatedValidation(String consolidatedValidation) {
        this.consolidatedValidation = consolidatedValidation;
    }

    public String getConsolidatedReview() {
        return consolidatedReview;
    }

    @XmlAttribute
    public void setConsolidatedReview(String consolidatedReview) {
        this.consolidatedReview = consolidatedReview;
    }

    public String getConsolidatedState() {
        return consolidatedState;
    }

    @XmlAttribute
    public void setConsolidatedState(String consolidatedState) {
        this.consolidatedState = consolidatedState;
    }

}
