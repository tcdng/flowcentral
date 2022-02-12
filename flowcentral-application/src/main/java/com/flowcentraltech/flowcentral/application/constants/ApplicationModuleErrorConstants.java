/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.constants;

/**
 * Application module error constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ApplicationModuleErrorConstants {

    /**
     * Attempt to swap filter condition information compound type to simple type.
     */
    String FILTERCONDITIONINFO_ATTEMPT_SWAP_COMPOUND_SIMPLE = "APPLICATION_0001";

    /**
     * Attempt to insert filter condition in simple condition.
     */
    String FILTERCONDITIONINFO_INSERT_IN_SIMPLE_CONDITION = "APPLICATION_0002";

    /**
     * Filter condition type {0} is not supported for field type {1}.
     */
    String FILTERCONDITIONINFO_FIELD_UNSUPPORTED_CONDITION = "APPLICATION_0003";

    /** Column {0} is unknown for table definition {1}. */
    String TABLE_DEFINTION_UNKNOWN_COLUMN = "APPLICATION_0004";

    /**
     * Can not find entity with name {0} of type {1} in application {2}.
     */
    String CANNOT_FIND_APPLICATION_ENTITY = "APPLICATION_0005";

    /** Unable to resolve reserved applet {0}. */
    String UNABLE_TO_RESOLVE_RESERVED_APPLET = "APPLICATION_0006";

    /**
     * Unable to import data {0} with existing unique record {1}.
     */
    String UNABLE_LOAD_DATA_WITH_EXISTING_UNIQUE_RECORD = "APPLICATION_0007";

}
