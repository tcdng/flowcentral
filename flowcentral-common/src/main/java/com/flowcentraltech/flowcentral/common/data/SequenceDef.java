/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.List;

/**
 * Sequence definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SequenceDef {

    private final String skeleton;

    private final List<SequencePartDef> partList;

    private final boolean withDatePart;

    public SequenceDef(String skeleton, List<SequencePartDef> partList, boolean withDatePart) {
        this.skeleton = skeleton;
        this.partList = partList;
        this.withDatePart = withDatePart;
    }

    public String getSkeleton() {
        return skeleton;
    }

    public List<SequencePartDef> getPartList() {
        return partList;
    }

    public boolean isWithDatePart() {
        return withDatePart;
    }

    @Override
    public String toString() {
        return "SequenceDef [skeleton=" + skeleton + ", partList=" + partList + ", withDatePart=" + withDatePart + "]";
    }

}
