package com.mycompany.exitotech.slack.app;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.jfree.data.json.impl.JSONObject;

/**
 *
 * @author lucas
 */
public class SlackApp {
    private static HttpClient client = HttpClient.newHttpClient();
    private static final String url = "https://hooks.slack.com/services/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";
    
    public static void validacao(Integer id_maquina, Double usoProcessador, Long usoRam) throws IOException, InterruptedException{
        JSONObject json = new JSONObject();
        String usoCpu = String.format("%.0f", usoProcessador);
        
        if(usoProcessador > 75){
            json.put("text", "A máquina: " + id_maquina + " está com o uso da CPU acima do normal, seria interessante verificar a máquina."
                    + "\nUso da CPU: " + usoCpu + "%");
            enviarMensagem(json);
        }
        
        if(usoRam > 75){
            json.put("text", "A máquina: " + id_maquina + " está com o uso da memória RAM acima do normal, é interessante verificar a máquina."
                    + "\nUso da memória RAM: " + usoRam + "%");
            enviarMensagem(json);
        }
        SlackApp.enviarMensagem(json);
    }

    public static void enviarMensagem(JSONObject content) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
        
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        
        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }
}
