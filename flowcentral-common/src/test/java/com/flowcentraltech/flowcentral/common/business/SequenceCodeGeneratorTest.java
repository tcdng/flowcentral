/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.flowcentraltech.flowcentral.common.AbstractFlowCentralTest;
import com.flowcentraltech.flowcentral.common.constants.SequencePartType;
import com.flowcentraltech.flowcentral.common.data.SequenceDef;
import com.flowcentraltech.flowcentral.common.data.SequencePartDef;

/**
 * Sequence code generator tests
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SequenceCodeGeneratorTest extends AbstractFlowCentralTest {

    private SequenceCodeGenerator scg;

    @Test
    public void testGetSequenceDefinition() throws Exception {
        SequenceDef sequenceDef = scg.getSequenceDefinition("LOT{n:8}");
        assertNotNull(sequenceDef);
        
        List<SequencePartDef> partList = sequenceDef.getPartList();
        assertNotNull(partList);
        assertEquals(2, partList.size());
        
        SequencePartDef partDef = partList.get(0);
        assertNotNull(partDef);
        assertEquals(SequencePartType.TEXT, partDef.getType());
        assertEquals("LOT", partDef.getText());
        assertEquals(0, partDef.getNumLen());
        
        partDef = partList.get(1);
        assertNotNull(partDef);
        assertEquals(SequencePartType.SEQUENCE_NUMBER, partDef.getType());
        assertNull(partDef.getText());
        assertEquals(8, partDef.getNumLen());
        
        assertFalse(sequenceDef.isWithDatePart());
    }
    
    @Test
    public void testGetNextSequenceCode() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR, 145);
        cal.set(Calendar.YEAR, 2002);
        Date date = cal.getTime();
        
        String code = scg.getNextSequenceCode("test", "QT{n:10}", date);
        assertEquals("QT0000000001", code);
        code = scg.getNextSequenceCode("test", "QT{n:10}", date);
        assertEquals("QT0000000002", code);
        
        code = scg.getNextSequenceCode("test", "{n:10}QT", date);
        assertEquals("0000000001QT", code);
        
        code = scg.getNextSequenceCode("test", "PC{n:0}", date);
        assertEquals("PC1", code);
        
        code = scg.getNextSequenceCode("test", "{n:0}PC", date);
        assertEquals("1PC", code);
        
        code = scg.getNextSequenceCode("test", "PC/{yyyy}/{n:0}", date);
        assertEquals("PC/2002/1", code);
        code = scg.getNextSequenceCode("test", "PC/{yyyy}/{n:0}", date);
        assertEquals("PC/2002/2", code);
        
        code = scg.getNextSequenceCode("test", "{yyyy}/PC/{n:0}", date);
        assertEquals("2002/PC/1", code);
        code = scg.getNextSequenceCode("test", "{yyyy}/PC/{n:0}", date);
        assertEquals("2002/PC/2", code);
        
        code = scg.getNextSequenceCode("test", "GT{yyyy}/PC/{n:0}", date);
        assertEquals("GT2002/PC/1", code);
        code = scg.getNextSequenceCode("test", "GT{yyyy}/PC/{n:0}", date);
        assertEquals("GT2002/PC/2", code);
        
        code = scg.getNextSequenceCode("test", "GT{dd}/{yyyy}/PC/{ddd}/{n:0}", date);
        assertEquals("GT25/2002/PC/145/1", code);
        code = scg.getNextSequenceCode("test", "GT{dd}/{yyyy}/PC/{ddd}/{n:0}", date);
        assertEquals("GT25/2002/PC/145/2", code);

        code = scg.getNextSequenceCode("test", "GT{dd}/{yy}/PC/{ddd}/{n:0}", date);
        assertEquals("GT25/02/PC/145/1", code);
    }

    @Test
    public void testGetNextSequenceCodeByDate() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR, 145);
        cal.set(Calendar.YEAR, 2002);
        Date date1 = cal.getTime();
        cal.set(Calendar.DAY_OF_YEAR, 207);
        cal.set(Calendar.YEAR, 2014);
        Date date2 = cal.getTime();
        
        String code = scg.getNextSequenceCode("test", "QT{N:10}", date1);
        assertEquals("QT0000000001", code);
        code = scg.getNextSequenceCode("test", "QT{N:10}", date1);
        assertEquals("QT0000000002", code);
        code = scg.getNextSequenceCode("test", "QT{N:10}", date2);
        assertEquals("QT0000000001", code);
        code = scg.getNextSequenceCode("test", "QT{N:10}", date2);
        assertEquals("QT0000000002", code);
        
        code = scg.getNextSequenceCode("test", "{N:10}QT", date1);
        assertEquals("0000000001QT", code);
        code = scg.getNextSequenceCode("test", "{N:10}QT", date1);
        assertEquals("0000000002QT", code);
        code = scg.getNextSequenceCode("test", "{N:10}QT", date2);
        assertEquals("0000000001QT", code);
        code = scg.getNextSequenceCode("test", "{N:10}QT", date2);
        assertEquals("0000000002QT", code);
        
        code = scg.getNextSequenceCode("test", "PC{N:0}", date1);
        assertEquals("PC1", code);
        code = scg.getNextSequenceCode("test", "PC{N:0}", date1);
        assertEquals("PC2", code);
        code = scg.getNextSequenceCode("test", "PC{N:0}", date2);
        assertEquals("PC1", code);
        code = scg.getNextSequenceCode("test", "PC{N:0}", date2);
        assertEquals("PC2", code);

        code = scg.getNextSequenceCode("test", "GT{dd}/{yyyy}/PC/{ddd}/{N:0}", date1);
        assertEquals("GT25/2002/PC/145/1", code);
        code = scg.getNextSequenceCode("test", "GT{dd}/{yyyy}/PC/{ddd}/{N:0}", date1);
        assertEquals("GT25/2002/PC/145/2", code);
        code = scg.getNextSequenceCode("test", "GT{dd}/{yyyy}/PC/{ddd}/{N:0}", date2);
        assertEquals("GT26/2014/PC/207/1", code);
        code = scg.getNextSequenceCode("test", "GT{dd}/{yyyy}/PC/{ddd}/{N:0}", date2);
        assertEquals("GT26/2014/PC/207/2", code);
    }
    
    @Override
    protected void onSetup() throws Exception {
        scg = (SequenceCodeGenerator) getComponent("common-sequencecodegenerator");
    }

    @Override
    protected void onTearDown() throws Exception {

    }

}
