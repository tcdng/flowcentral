/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
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
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractHttpPostEnvironmentDelegate extends AbstractEnvironmentDelegate {

    @Override
    protected String sendToDelegateDatasourceService(String jsonReq) throws UnifyException {
        String endpoint = getEndpoint();
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
