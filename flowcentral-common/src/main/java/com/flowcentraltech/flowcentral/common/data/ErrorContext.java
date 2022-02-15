/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.Collection;
import java.util.List;

/**
 * Error context.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public interface ErrorContext {

    void addValidationError(String message);

    void addValidationError(FormMessage message);
    
    void addValidationError(String fieldName, String message);

    void clearValidationErrors();

    boolean isWithFormErrors();

    boolean isWithFieldErrors();

    boolean isWithFieldError(String fieldName);

    boolean isWithFieldError(Collection<String> fieldNames);

    String getFieldError(String fieldName);

    boolean isWithValidationErrors();

    List<FormMessage> getValidationErrors();

}
