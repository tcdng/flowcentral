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
package com.flowcentraltech.flowcentral.application.data;

import java.util.List;

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.core.util.StringUtils.StringToken;

/**
 * Reference definition
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public class RefDef extends BaseApplicationEntityDef {

    private String entity;

    private String searchField;

    private String searchTable;

    private String selectHandler;

    private String filterGenerator;

    private String filterGeneratorRule;

    private FilterDef filter;

    private List<StringToken> listFormat;

    public RefDef(String entity, String searchField, String searchTable, String selectHandler, String filterGenerator,
            String filterGeneratorRule, FilterDef filter, List<StringToken> listFormat, String longName,
            String description, Long id, long version) throws UnifyException {
        super(ApplicationNameUtils.getApplicationEntityNameParts(longName), description, id, version);
        this.entity = entity;
        this.searchField = searchField;
        this.searchTable = searchTable;
        this.selectHandler = selectHandler;
        this.filterGenerator = filterGenerator;
        this.filterGeneratorRule = filterGeneratorRule;
        this.filter = filter;
        this.listFormat = listFormat;
    }

    public String getEntity() {
        return entity;
    }

    public String getSearchField() {
        return searchField;
    }

    public String getSearchTable() {
        return searchTable;
    }

    public String getSelectHandler() {
        return selectHandler;
    }

    public List<StringToken> getListFormat() {
        return listFormat;
    }

    public boolean isWithListFormat() {
        return listFormat != null;
    }

    public String getFilterGenerator() {
        return filterGenerator;
    }

    public String getFilterGeneratorRule() {
        return filterGeneratorRule;
    }

    public FilterDef getFilter() {
        return filter;
    }

    public boolean isWithSearchField() {
        return !StringUtils.isBlank(searchField);
    }

    public boolean isWithSearchTable() {
        return !StringUtils.isBlank(searchTable);
    }

    public boolean isWithFilter() {
        return filter != null;
    }

    public boolean isWithFilterGenerator() {
        return filterGenerator != null;
    }

    public boolean isWithCondition() {
        return filter != null || filterGenerator != null;
    }

    @Override
    public String toString() {
        return "RefDef [entity=" + entity + ", searchField=" + searchField + ", searchTable=" + searchTable
                + ", filterGenerator=" + filterGenerator + ", filterGeneratorRule=" + filterGeneratorRule + ", filter="
                + filter + ", getLongName()=" + getLongName() + ", getName()=" + getName() + ", getDescription()="
                + getDescription() + "]";
    }
}
