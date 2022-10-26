package com.mycompany.exitotech.slack.app;

import com.github.britooo.looca.api.core.Looca;
import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

/**
 *
 * @author lucas
 */
public class SlackApp {

    private static String webHooksUrl = "https://hooks.slack.com/services/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";
    private static String oAuthToken = "xoxb-4140985148451-4220978468465-HoBrj1CNff6nz5NdUQdgqYTN";
    private static String slackChannel = "aplicativo-de-monitoramento-de-software";
    Looca looca = new Looca();

    public static void aviso() {
        Looca looca = new Looca();
        String cpu = String.format("%.1f", looca.getProcessador().getUso());
        if (looca.getProcessador().getUso() < 20) {
            enviarAoSlack("Uso da CPU: " +  cpu + "%");
        }else{
            enviarAoSlack("Uso da CPU: " + cpu + "%");
        }
    }

    public static void enviarAoSlack(String message) {
        try {
            StringBuilder msgbuilder = new StringBuilder();
            msgbuilder.append(message);

            Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();
            WebhookResponse wbResp = Slack.getInstance().send(webHooksUrl, payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
