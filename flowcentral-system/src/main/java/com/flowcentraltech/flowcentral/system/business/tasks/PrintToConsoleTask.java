/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.business.tasks;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Parameter;
import com.tcdng.unify.core.annotation.Schedulable;
import com.tcdng.unify.core.task.AbstractTask;
import com.tcdng.unify.core.task.TaskInput;
import com.tcdng.unify.core.task.TaskMonitor;
import com.tcdng.unify.core.task.TaskOutput;

/**
 * Print to console task.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = "printtoconsole-task", description = "Print to Console Task")
@Schedulable(parameters = {
        @Parameter(name = "lineText", description = "Line Text", editor = "!ui-text", type = String.class,
                mandatory = true),
        @Parameter(name = "lineCount", description = "Line Count", editor = "!ui-integer precision:3 size:16",
                type = Integer.class, mandatory = true) })
public class PrintToConsoleTask extends AbstractTask {

    @Override
    public void execute(TaskMonitor taskMonitor, TaskInput input, TaskOutput output) throws UnifyException {
        String lineText = input.getParam(String.class, "lineText");
        int lineCount = input.getParam(int.class, "lineCount");
        if (lineText != null) {
            for (int i = 0; i < lineCount; i++) {
                System.out.println(lineText);
            }
        }
    }

}
