/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.data.SequenceDef;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Sequence code generator
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface SequenceCodeGenerator extends UnifyComponent {

    /**
     * Gets the skeleton string for the supplied the sequence definition;
     * 
     * @param sequenceDefintion
     *                          the sequence definition
     * @return the sequence skeleton.
     * @throws UnifyException
     *                        if an error occurs
     */
    String getCodeSkeleton(String sequenceDefintion) throws UnifyException;

    /**
     * Gets sequence definition.
     * 
     * @param sequenceDefintion the definition string
     * @return the definition object
     * @throws UnifyException if an error occurs
     */
    SequenceDef getSequenceDefinition(String sequenceDefintion) throws UnifyException;
    
    /**
     * Gets the next sequence code for the supplied sequence definition and current
     * date.
     * 
     * @param ownerId the sequence owner Id
     * @param sequenceDefintion
     *                          the sequence definition
     * @return the next sequence code
     * @throws UnifyException
     *                        if an error occurs
     */
    String getNextSequenceCode(String ownerId, String sequenceDefintion) throws UnifyException;

    /**
     * Gets the next sequence code for the supplied sequence definition and date.
     * 
     * @param ownerId the sequence owner Id
     * @param sequenceDefintion
     *                          the sequence definition
     * @param date
     *                          the sequence date
     * @return the next sequence code
     * @throws UnifyException
     *                        if an error occurs
     */
    String getNextSequenceCode(String ownerId, String sequenceDefintion, Date date) throws UnifyException;
}
