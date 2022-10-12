/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exitotech.slack.app;
import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
/**
 *
 * @author lucas
 */
public class SlackApp {
    private static String webHooksUrl= "https://hooks.slack.com/services/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";
    private static String oAuthToken = "xoxb-4140985148451-4220978468465-HoBrj1CNff6nz5NdUQdgqYTN";
    private static String slackChannel = "aplicativo-de-monitoramento-de-software";
    public static void main(String[] args) {
        sendMessageToSlack("Primeira mensagem para o Slack usando Automação");
    }
    
    public static void sendMessageToSlack(String message){
        try{
            StringBuilder msgbuilder = new StringBuilder();
            msgbuilder.append(message);

            Payload payload = Payload.builder().channel(slackChannel).text(msgbuilder.toString()).build();
            WebhookResponse wbResp = Slack.getInstance().send(webHooksUrl, payload);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
