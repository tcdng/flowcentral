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

package com.flowcentraltech.flowcentral.common.business;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.Update;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;

/**
 * Environment delegate utilities.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public interface EnvironmentDelegateUtilities extends UnifyComponent {
    
    /**
     * Encode object ID
     * 
     * @param id
     *           the object ID
     * @return the encoded ID
     * @throws UnifyException
     *                        if an error occurs
     */
    Long encodeDelegateObjectId(Object id) throws UnifyException;

    /**
     * Encode version number.
     * 
     * @param versionNo
     *                  the version number
     * @return the encoded version number
     * @throws UnifyException
     *                        if an error occurs
     */
    Long encodeDelegateVersionNo(Object versionNo) throws UnifyException;

    /**
     * Encode entity query
     * 
     * @param query
     *              the query
     * @return the encoded query
     * @throws UnifyException
     *                        if an error occurs
     */
    String encodeDelegateQuery(Query<? extends Entity> query) throws UnifyException;

    /**
     * Encode entity query order
     * 
     * @param query
     *              the query
     * @return the encoded order by
     * @throws UnifyException
     *                        if an error occurs
     */
    String encodeDelegateOrder(Query<? extends Entity> query) throws UnifyException;

    /**
     * Encode update
     * 
     * @param update
     *               the update
     * @return the encoded update
     * @throws UnifyException
     *                        if an error occurs
     */
    String encodeDelegateUpdate(Update update) throws UnifyException;

    /**
     * Encodes an entity record.
     * 
     * @param inst
     *             the
     * @return
     * @throws UnifyException
     */
    String[] encodeDelegateEntity(Entity inst) throws UnifyException;

    /**
     * Resolves long name for supplied entity class.
     * 
     * @param entityClass
     *                    the entity class
     * @return the long name
     * @throws UnifyException
     *                        if an error occurs
     */
    String resolveLongName(Class<? extends Entity> entityClass) throws UnifyException;
}
