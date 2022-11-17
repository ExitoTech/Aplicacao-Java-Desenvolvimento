package com.mycompany.exitotech.slack.app;
import com.mycompany.exitotech.jar.database.ConexaoDAO;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.jfree.data.json.impl.JSONObject;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author lucas
 */
public class SlackApp {
    private static HttpClient client = HttpClient.newHttpClient();
    private static String url;
    
    public static void validacao(Integer id_maquina, Double usoProcessador, Long usoRam) throws IOException, InterruptedException{
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysqlLocal();
        JdbcTemplate con = connection.getConnection();
        String query1 = String.format("SELECT emp.webHook AS webHook\n" +
                        "FROM maquina AS maq \n" +
                        "JOIN setor AS ser\n" +
                        "ON ser.idSetor = maq.fk_setor\n" +
                        "RIGHT JOIN empresa AS emp\n" +
                        "ON ser.fk_Empresa = emp.idEmpresa WHERE idMaquina = %d;", id_maquina);
        
        String query2 = String.format("select top 5 usoCPu, usoRam, idCaptura from "
                + "capturas where fk_maquina = %d order by idCaptura desc;", id_maquina);
        List webHook = con.queryForList(query1);
        String wh = webHook.toString().replace("[{webHook=", "").replace("}]", "");
        
                if(wh == null || wh.equals("")){
                    System.out.println("\n Nenhum Slack cadastrado/encontrado.\n");
                }else{
                    url = wh;
                    JSONObject json = new JSONObject();
                    String usoCpu = String.format("%.0f", usoProcessador);

                    if(usoProcessador > 1){
                        json.put("text", "A máquina: " + id_maquina + " está com o uso da CPU acima do normal, seria interessante verificar a máquina."
                                + "\nUso da CPU: " + usoCpu + "%");
                        try {
                            enviarMensagem(json);
                        } catch (IOException ex) {
                            Logger.getLogger(SlackApp.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SlackApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if(usoRam > 1){
                        try {
                            json.put("text", "A máquina: " + id_maquina + " está com o uso da memória RAM acima do normal, é interessante verificar a máquina."
                                    + "\nUso da memória RAM: " + usoRam + "%");
                            enviarMensagem(json);
                        } catch (IOException ex) {
                            Logger.getLogger(SlackApp.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SlackApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
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
