/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.notification.business;

import java.util.List;

import com.flowcentraltech.flowcentral.common.data.Recipient;
import com.flowcentraltech.flowcentral.notification.constants.NotificationHostServerConstants;
import com.flowcentraltech.flowcentral.notification.constants.NotificationModuleNameConstants;
import com.flowcentraltech.flowcentral.notification.data.NotificationChannelDef;
import com.flowcentraltech.flowcentral.notification.data.NotificationChannelMessage;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.constant.NetworkSecurityType;
import com.tcdng.unify.core.notification.BulkSms;
import com.tcdng.unify.core.notification.Sms;
import com.tcdng.unify.core.notification.SmsServer;
import com.tcdng.unify.core.notification.SmsServerConfig;

/**
 * SMS notification messaging channel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(NotificationModuleNameConstants.SMSMESSAGINGCHANNEL)
public class SmsNotificationMessagingChannel extends AbstractNotificationMessagingChannel {

    @Configurable
    private SmsServer smsServer;

    public void setSmsServer(SmsServer smsServer) {
        this.smsServer = smsServer;
    }

    @Override
    public boolean sendMessage(NotificationChannelDef notifChannelDef, NotificationChannelMessage notifChannelMessage) {
        try {
            ensureServerConfigured(notifChannelDef);
            return sendSms(notifChannelDef, notifChannelMessage);
        } catch (UnifyException e) {
            logError(e);
        }

        return false;
    }

    @Override
    public void sendMessages(NotificationChannelDef notifChannelDef,
            NotificationChannelMessage... notifChannelMessages) {
        for (NotificationChannelMessage _msg : notifChannelMessages) {
            sendSms(notifChannelDef, _msg);
        }
    }

    private void ensureServerConfigured(NotificationChannelDef notifChannelDef) throws UnifyException {
        final String configCode = notifChannelDef.getName();
        if (!notifChannelDef.isChannelConfigured() || !smsServer.isConfigured(configCode)) {
            SmsServerConfig smsServerConfig = SmsServerConfig.newBuilder()
                    .hostAddress(notifChannelDef.getPropValue(String.class,
                            NotificationHostServerConstants.ADDRESS_PROPERTY))
                    .hostPort(
                            notifChannelDef.getPropValue(Integer.class, NotificationHostServerConstants.PORT_PROPERTY))
                    .useSecurityType(notifChannelDef.getPropValue(NetworkSecurityType.class,
                            NotificationHostServerConstants.SECURITYTYPE_PROPERTY))
                    .username(notifChannelDef.getPropValue(String.class,
                            NotificationHostServerConstants.USERNAME_PROPERTY))
                    .password(notifChannelDef.getPropValue(String.class,
                            NotificationHostServerConstants.PASSWORD_PROPERTY))
                    .build();
            smsServer.configure(configCode, smsServerConfig);
            notifChannelDef.setChannelConfigured();
        }
    }

    private boolean sendSms(NotificationChannelDef notifChannelDef, NotificationChannelMessage notifChannelMessage) {
        try {
            List<Recipient> recipientList = notifChannelMessage.getRecipients();
            if (recipientList.size() == 1) {
                Sms sms = Sms.newBuilder().fromSender(notifChannelDef.getSenderContact())
                        .toRecipient(recipientList.get(0).getContact()).containingMessage(notifChannelMessage.getBody())
                        .build();
                smsServer.sendSms(notifChannelDef.getName(), sms);
            } else {
                BulkSms.Builder bsb = BulkSms.newBuilder();
                for (Recipient recipient : recipientList) {
                    bsb.toRecipient(recipient.getContact());
                }

                bsb.fromSender(notifChannelDef.getSenderContact()).containingMessage(notifChannelMessage.getBody());
                smsServer.sendSms(notifChannelDef.getName(), bsb.build());
            }

            notifChannelMessage.setSent(true);
            return true;
        } catch (UnifyException e) {
            logError(e);
        }

        return false;
    }

}