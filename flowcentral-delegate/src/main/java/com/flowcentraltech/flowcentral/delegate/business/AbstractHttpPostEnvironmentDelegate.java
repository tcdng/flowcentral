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

package com.flowcentraltech.flowcentral.delegate.business;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.tcdng.unify.core.UnifyException;

/**
 * Convenient abstract base class for HTTP Post environment delegates.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public abstract class AbstractHttpPostEnvironmentDelegate extends AbstractJsonEnvironmentDelegate {

    @Override
    protected String sendToDelegateProcedureService(String jsonReq) throws UnifyException {
        String endpoint = getEndpoint() + "/procedure";
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            try (OutputStream out = conn.getOutputStream()) {
                out.write(jsonReq.getBytes("utf-8"));
                out.flush();
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }
        } catch (Exception e) {
            this.throwOperationErrorException(e);
        }

        return response.toString();
    }

    @Override
    protected String sendToDelegateDatasourceService(String jsonReq) throws UnifyException {
        String endpoint = getEndpoint() + "/datasource";
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            try (OutputStream out = conn.getOutputStream()) {
                out.write(jsonReq.getBytes("utf-8"));
                out.flush();
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }
        } catch (Exception e) {
            this.throwOperationErrorException(e);
        }

        return response.toString();
    }

    protected abstract String getEndpoint() throws UnifyException;
}
