/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Report configuration.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
@XmlRootElement(name = "report")
public class ReportConfig extends BaseNameConfig {

    private String title;

    private String processor;

    private String reportable;

    private String template;

    private String layout;

    private ReportColumnsConfig columns;

    private ParametersConfig parameters;

    private FilterConfig filter;

    private boolean showGrandFooter;

    private boolean invertGroupColors;

    private boolean landscape;

    private boolean underlineRows;

    private boolean shadeOddRows;

    public String getTitle() {
        return title;
    }

    @XmlAttribute(required = true)
    public void setTitle(String title) {
        this.title = title;
    }

    public String getProcessor() {
        return processor;
    }

    @XmlAttribute
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getReportable() {
        return reportable;
    }

    @XmlAttribute
    public void setReportable(String reportable) {
        this.reportable = reportable;
    }

    public ReportColumnsConfig getColumns() {
        return columns;
    }

    @XmlElement
    public void setColumns(ReportColumnsConfig columns) {
        this.columns = columns;
    }

    public ParametersConfig getParameters() {
        return parameters;
    }

    @XmlElement
    public void setParameters(ParametersConfig parameters) {
        this.parameters = parameters;
    }

    public FilterConfig getFilter() {
        return filter;
    }

    @XmlElement(name = "filter")
    public void setFilter(FilterConfig filter) {
        this.filter = filter;
    }

    public String getTemplate() {
        return template;
    }

    @XmlAttribute
    public void setTemplate(String template) {
        this.template = template;
    }

    public String getLayout() {
        return layout;
    }

    @XmlAttribute
    public void setLayout(String layout) {
        this.layout = layout;
    }

    public boolean isShowGrandFooter() {
        return showGrandFooter;
    }

    @XmlAttribute
    public void setShowGrandFooter(boolean showGrandFooter) {
        this.showGrandFooter = showGrandFooter;
    }

    public boolean isInvertGroupColors() {
        return invertGroupColors;
    }

    @XmlAttribute
    public void setInvertGroupColors(boolean invertGroupColors) {
        this.invertGroupColors = invertGroupColors;
    }

    public boolean isLandscape() {
        return landscape;
    }

    @XmlAttribute
    public void setLandscape(boolean landscape) {
        this.landscape = landscape;
    }

    public boolean isUnderlineRows() {
        return underlineRows;
    }

    @XmlAttribute
    public void setUnderlineRows(boolean underlineRows) {
        this.underlineRows = underlineRows;
    }

    public boolean isShadeOddRows() {
        return shadeOddRows;
    }

    @XmlAttribute
    public void setShadeOddRows(boolean shadeOddRows) {
        this.shadeOddRows = shadeOddRows;
    }
}
