/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.writers;

import java.util.Arrays;
import java.util.List;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.constant.HAlignType;
import com.tcdng.unify.web.ui.widget.ResponseWriter;

/**
 * Listing generator writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ListingGeneratorWriter {

    private ResponseWriter writer;

    private List<ListingColumn> tableColumnList;

    private int sectionColumns;

    private int sectionColumnWidth;

    private int currentSectionColumn;

    private boolean inSection;

    private boolean alternatingColumn;

    public ListingGeneratorWriter(ResponseWriter writer) {
        this.writer = writer;
    }

    public void beginSection(String label, int sectionColumns, int widthPercent, HAlignType horizontalAlign,
            boolean alternatingColumn) throws UnifyException {
        if (sectionColumns <= 0) {
            throw new RuntimeException("Section columns must be greater than zero.");
        }

        if (inSection) {
            throw new RuntimeException("Section already begun.");
        }

        this.sectionColumns = sectionColumns;
        this.sectionColumnWidth = 100 / sectionColumns;
        this.currentSectionColumn = 0;
        this.alternatingColumn = alternatingColumn;
        writer.write("<div class=\"flsection\"><span>").writeResolvedSessionMessage(label).write("</span></div>");
        int leftMargin = 0;
        if (HAlignType.CENTER.equals(horizontalAlign)) {
            leftMargin = (100 - widthPercent) / 2;
        } else if (HAlignType.RIGHT.equals(horizontalAlign)) {
            leftMargin = 100 - widthPercent;
        }

        writer.write("<div class=\"flsectionbody\" style=\"width:").write(widthPercent).write("%;margin-left:")
                .write(leftMargin).write("%;\">"); // Begin section body
        inSection = true;
    }

    public void beginTable(ListingColumn... columns) throws UnifyException {
        if (!inSection) {
            throw new RuntimeException("No section started.");
        }

        if (tableColumnList != null) {
            throw new RuntimeException("Table already begun.");
        }

        if (currentSectionColumn == 0) {
            writer.write("<div class=\"flsectionbodyrow\">"); // Begin section row
        }

        currentSectionColumn++;

        tableColumnList = Arrays.asList(columns);
        writer.write("<div class=\"flsectionbodycell");
        if (alternatingColumn && (currentSectionColumn % 2) == 0) {
            writer.write(" flgray");
        }
        writer.write("\" style=\"width:").write(sectionColumnWidth).write("%;\">");
        writer.write("<div class=\"fltable\">");
    }

    public void writeRow(ListingCell... cells) throws UnifyException {
        if (tableColumnList == null) {
            throw new RuntimeException("No table is started.");
        }

        if (cells.length != tableColumnList.size()) {
            throw new IllegalArgumentException(
                    "Length of supplied cells does not match current section number of columns.");
        }

        writer.write("<div class=\"flrow\">");
        for (int cellIndex = 0; cellIndex < cells.length; cellIndex++) {
            ListingColumn column = tableColumnList.get(cellIndex);
            ListingCell cell = cells[cellIndex];
            writer.write("<div class=\"flcell\" style=\"width:").write(column.getWidthPercent()).write("%;\">");
            writer.write("<span class=\"flcontent ").write(cell.getType().styleClass()).write(" ")
                    .write(column.getAlign().styleClass()).write("\">");
            if (cell.isWithContent()) {
                writer.writeResolvedSessionMessage(cell.getContent());
            }
            writer.write("</span>");
            writer.write("</div>");
        }

        writer.write("</div>");
    }

    public void endTable() throws UnifyException {
        if (tableColumnList == null) {
            throw new RuntimeException("No table is started.");
        }

        tableColumnList = null;
        writer.write("</div></div>");

        if (currentSectionColumn == sectionColumns) {
            currentSectionColumn = 0;
            writer.write("</div>"); // End section row
        }
    }

    public void endSection() throws UnifyException {
        if (tableColumnList != null) {
            throw new RuntimeException("Current table is not ended.");
        }

        if (!inSection) {
            throw new RuntimeException("No section started.");
        }

        if (currentSectionColumn > 0 && currentSectionColumn < sectionColumns) {
            for (; currentSectionColumn < sectionColumns; currentSectionColumn++) {
                writer.write("<div class=\"flsectionbodycell\" style=\"width:").write(sectionColumnWidth)
                        .write("%;\"></div>");
            }

            currentSectionColumn = 0;
            writer.write("</div>");// End section row
        }

        writer.write("</div>"); // End section body
        inSection = false;
    }
}
