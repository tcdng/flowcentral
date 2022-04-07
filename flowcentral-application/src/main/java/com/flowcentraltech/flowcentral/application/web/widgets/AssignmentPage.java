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

package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.business.EntityBasedFilterGenerator;
import com.flowcentraltech.flowcentral.application.data.AssignmentPageDef;
import com.flowcentraltech.flowcentral.application.data.EntityClassDef;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.EntityFieldDef;
import com.flowcentraltech.flowcentral.application.data.RefDef;
import com.flowcentraltech.flowcentral.application.web.data.AppletContext;
import com.flowcentraltech.flowcentral.common.business.policies.SweepingCommitPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.Restriction;
import com.tcdng.unify.core.data.BeanValueStore;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.ui.widget.EventHandler;

/**
 * Assignment page object.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public class AssignmentPage {

    private final AppletContext ctx;

    private final SweepingCommitPolicy sweepingCommitPolicy;

    private final AssignmentPageDef assignmentPageDef;

    private final EntityClassDef entityClassDef;

    private final Object baseId;

    private final BreadCrumbs breadCrumbs;

    private final EventHandler[] assnSwitchOnChangeHandlers;

    private String displayItemCounter;

    private String displayItemCounterClass;

    private List<Long> assignedIdList;

    private BeanTable entryBeanTable;

    private String entryTable;

    private String entryTablePolicy;

    private String assgnUpdatePolicy;

    public AssignmentPage(AppletContext ctx, EventHandler[] assnSwitchOnChangeHandlers,
            SweepingCommitPolicy sweepingCommitPolicy, AssignmentPageDef assignmentPageDef,
            EntityClassDef entityClassDef, Object baseId, BreadCrumbs breadCrumbs, String entryTable,
            String entryTablePolicy, String assgnUpdatePolicy) {
        this.ctx = ctx;
        this.assnSwitchOnChangeHandlers = assnSwitchOnChangeHandlers;
        this.sweepingCommitPolicy = sweepingCommitPolicy;
        this.assignmentPageDef = assignmentPageDef;
        this.entityClassDef = entityClassDef;
        this.baseId = baseId;
        this.breadCrumbs = breadCrumbs;
        this.entryTable = entryTable;
        this.entryTablePolicy = entryTablePolicy;
        this.assgnUpdatePolicy = assgnUpdatePolicy;
    }

    public String getMainTitle() {
        return breadCrumbs.getLastBreadCrumb().getTitle();
    }

    public String getSubTitle() {
        return breadCrumbs.getLastBreadCrumb().getSubTitle();
    }

    public BreadCrumbs getBreadCrumbs() {
        return breadCrumbs;
    }

    public AppletUtilities getAu() {
        return ctx.getAu();
    }

    public AppletContext getCtx() {
        return ctx;
    }

    public AssignmentPageDef getAssignmentPageDef() {
        return assignmentPageDef;
    }

    public EntityDef getEntityDef() {
        return entityClassDef.getEntityDef();
    }

    public Object getBaseId() {
        return baseId;
    }

    public String getDisplayItemCounter() {
        return displayItemCounter;
    }

    public void setDisplayItemCounter(String displayItemCounter) {
        this.displayItemCounter = displayItemCounter;
    }

    public String getDisplayItemCounterClass() {
        return displayItemCounterClass;
    }

    public void setDisplayItemCounterClass(String displayItemCounterClass) {
        this.displayItemCounterClass = displayItemCounterClass;
    }

    public void clearDisplayItem() {
        displayItemCounter = null;
        displayItemCounterClass = null;
    }

    public List<Long> getAssignedIdList() {
        return assignedIdList;
    }

    public void setAssignedIdList(List<Long> assignedIdList) {
        this.assignedIdList = assignedIdList;
    }

    public void switchOnChange() throws UnifyException {
        if (isEntryTableMode()) {
            getEntryBeanTable().fireOnChange();
        }        
    }
    
    public BeanTable getEntryBeanTable() throws UnifyException {
        if (isEntryTableMode() && entryBeanTable == null) {
            entryBeanTable = new BeanTable(ctx.getAu(), ctx.getAu().getTableDef(entryTable), true);
            if (!StringUtils.isBlank(entryTablePolicy)) {
                BeanTablePolicy policy = ctx.getAu().getComponent(BeanTablePolicy.class, entryTablePolicy);
                entryBeanTable.setPolicy(policy);
            }
        }

        return entryBeanTable;
    }

    public boolean isEntryTableMode() {
        return !StringUtils.isBlank(entryTable);
    }

    @SuppressWarnings("unchecked")
    public void loadAssignedList() throws UnifyException {
        if (isEntryTableMode()) {
            // Assigned list
            List<Entity> resultList = (List<Entity>) ctx.getEnvironment()
                    .listAll(Query.of((Class<? extends Entity>) entityClassDef.getEntityClass())
                            .addEquals(assignmentPageDef.getBaseField(), baseId));
            Set<Long> selected = new HashSet<Long>();
            for (Entity inst : resultList) {
                selected.add((Long) inst.getId());
            }

            List<Long> assignedIdList = ctx.getEnvironment().getAssignedList(
                    (Class<? extends Entity>) entityClassDef.getEntityClass(), Long.class,
                    assignmentPageDef.getBaseField(), baseId, assignmentPageDef.getAssignField());
            // Add unassigned list
            final EntityFieldDef _assignFieldDef = entityClassDef.getEntityDef()
                    .getFieldDef(assignmentPageDef.getAssignField());
            final RefDef _assignRefDef = _assignFieldDef.getRefDef();
            final EntityClassDef _assignEntityClassDef = ctx.getAu().getEntityClassDef(_assignRefDef.getEntity());
            Query<? extends Entity> query = Query.of((Class<? extends Entity>) _assignEntityClassDef.getEntityClass());
            if (_assignRefDef.isWithFilterGenerator()) {
                RefDef _baseRefDef = entityClassDef.getEntityDef().getFieldDef(assignmentPageDef.getBaseField())
                        .getRefDef();
                EntityClassDef _baseEntityClassDef = ctx.getAu().getEntityClassDef(_baseRefDef.getEntity());
                Entity baseInst = ctx.getAu().getEnvironment()
                        .listLean((Class<? extends Entity>) _baseEntityClassDef.getEntityClass(), baseId);
                Restriction br = ctx.getAu()
                        .getComponent(EntityBasedFilterGenerator.class, _assignRefDef.getFilterGenerator())
                        .generate(new BeanValueStore(baseInst).getReader(), _assignRefDef.getFilterGeneratorRule());
                query.addRestriction(br);
            } else if (_assignRefDef.isWithFilter()) {
                Restriction br = _assignRefDef.getFilter().getRestriction(_assignEntityClassDef.getEntityDef(), null,
                        ctx.getAu().getNow());
                query.addRestriction(br);
            }

            if (!assignedIdList.isEmpty()) {
                query.addNotAmongst("id", assignedIdList);
            } else {
                query.ignoreEmptyCriteria(true);
            }

            final EntityDef _entityDef = entityClassDef.getEntityDef();
            for (Long unAssignId : ctx.getEnvironment().valueList(Long.class, "id", query)) {
                Entity entity = entityClassDef.newInst();
                DataUtils.setBeanProperty(entity, assignmentPageDef.getBaseField(), baseId);
                DataUtils.setBeanProperty(entity, assignmentPageDef.getAssignField(), unAssignId);
                ctx.getAu().populateListOnlyFields(_entityDef, entity);
                resultList.add(entity); // Addition is done here
            }

            final BeanTable _beanTable = getEntryBeanTable();
            _beanTable.setSwitchOnChangeHandlers(assnSwitchOnChangeHandlers);
            _beanTable.setSelected(selected);
            _beanTable.setSourceObject(resultList);
        } else {
            assignedIdList = ctx.getEnvironment().getAssignedList(
                    (Class<? extends Entity>) entityClassDef.getEntityClass(), Long.class,
                    assignmentPageDef.getBaseField(), baseId, assignmentPageDef.getAssignField());
        }
    }

    @SuppressWarnings("unchecked")
    public void commitAssignedList(boolean reload) throws UnifyException {
        if (isEntryTableMode()) {
            List<? extends Entity> assignedList = (List<? extends Entity>) getEntryBeanTable().getSelectedItems();
            String updatePolicy = !StringUtils.isBlank(assgnUpdatePolicy) ? assgnUpdatePolicy
                    : assignmentPageDef.getUpdatePolicy();
            ctx.getEnvironment().updateAssignedList(sweepingCommitPolicy, updatePolicy,
                    (Class<? extends Entity>) entityClassDef.getEntityClass(), assignmentPageDef.getBaseField(), baseId,
                    assignedList);
            if (reload) {
                loadAssignedList();
            }
        } else {
            String updatePolicy = !StringUtils.isBlank(assgnUpdatePolicy) ? assgnUpdatePolicy
                    : assignmentPageDef.getUpdatePolicy();
            ctx.getEnvironment().updateAssignedList(sweepingCommitPolicy, updatePolicy,
                    (Class<? extends Entity>) entityClassDef.getEntityClass(), assignmentPageDef.getBaseField(), baseId,
                    assignmentPageDef.getAssignField(), assignedIdList);
        }
    }
}
