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

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.List;

import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.AbstractListParam;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Previous steps parameters.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public class PrevStepsParams extends AbstractListParam {

    private List<? extends Listable> prevStepList;

    public PrevStepsParams(List<? extends Listable> prevStepList) {
        this.prevStepList = prevStepList;
    }

    public List<? extends Listable> getPrevStepList() {
        return prevStepList;
    }

    @Override
    public boolean isPresent() {
        return !DataUtils.isBlank(prevStepList);
    }
}
