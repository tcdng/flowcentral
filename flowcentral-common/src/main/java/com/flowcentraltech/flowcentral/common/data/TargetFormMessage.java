/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Target for message.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TargetFormMessage {

    private Set<String> targets;

    private FormMessage formMessage;

    public TargetFormMessage(Set<String> targets, FormMessage formMessage) {
        this.targets = targets;
        this.formMessage = formMessage;
    }

    public TargetFormMessage(FormMessage formMessage, String... targets) {
        this.targets = new HashSet<String>(Arrays.asList(targets));
        this.formMessage = formMessage;
    }

    public Set<String> getTargets() {
        return targets;
    }

    public boolean isWithTargets() {
        return targets != null && !targets.isEmpty();
    }

    public boolean isTarget(String target) {
        return targets.contains(target);
    }

    public FormMessage getFormMessage() {
        return formMessage;
    }

    @Override
    public String toString() {
        return "TargetFormMessage [targets=" + targets + ", formMessage=" + formMessage + "]";
    }
}
