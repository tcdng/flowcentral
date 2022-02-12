/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.tcdng.unify.core.constant.AnnotationConstants;
import com.tcdng.unify.core.constant.HAlignType;

/**
 * Annotation used for specifying managed field format information.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Format {

    /** The field description */
    String description() default AnnotationConstants.NONE;

    /** The field formatter UPL descriptor */
    String formatter() default AnnotationConstants.NONE;

    /** The component name of associated list command */
    String list() default AnnotationConstants.NONE;

    /** Field horizontal alignment */
    HAlignType halign() default HAlignType.LEFT;

    /** The multi-part width ratio for field */
    int widthRatio() default -1;

    /** Indicates if field is masked */
    boolean mask() default false;
}
