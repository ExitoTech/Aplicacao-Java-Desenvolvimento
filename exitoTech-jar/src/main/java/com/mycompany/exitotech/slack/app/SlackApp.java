package com.mycompany.exitotech.slack.app;
import com.github.britooo.looca.api.core.Looca;
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
    
    public static void validacao(Integer id_maquina){
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();
        Looca looca = new Looca();
        String queryWh = String.format("SELECT emp.webHook AS webHook\n" +
                        "FROM maquina AS maq \n" +
                        "JOIN setor AS ser\n" +
                        "ON ser.idSetor = maq.fk_setor\n" +
                        "RIGHT JOIN empresa AS emp\n" +
                        "ON ser.fk_Empresa = emp.idEmpresa WHERE idMaquina = %d;", id_maquina);
        
        String queryRam = String.format("SELECT avg(usoRam) FROM capturas WHERE "
                + "idCaptura in (SELECT TOP 5 idCaptura FROM capturas ORDER BY idCaptura DESC);", id_maquina);
        
        String queryCpu = String.format("SELECT avg(usoCpu) FROM capturas WHERE "
                + "idCaptura in (SELECT TOP 5 idCaptura FROM capturas ORDER BY idCaptura DESC)", id_maquina);
        
        String querySetor = String.format("SELECT idSetor as setor \n" +
                        "FROM maquina AS maq\n" +
                        "JOIN setor AS ser\n" +
                        "ON ser.idSetor = maq.fk_setor\n" +
                        "RIGHT JOIN empresa AS emp\n" +
                        "ON ser.fk_Empresa = emp.idEmpresa WHERE idMaquina = %d;", id_maquina);
        
        List webHook = con.queryForList(queryWh);
        List setor = con.queryForList(querySetor);
        
        String wh = webHook.toString().replace("[{webHook=", "").replace("}]", "");
        String set = setor.toString().replace("[{setor=", "").replace("}]", "");
        
        Double usoProcessador = looca.getProcessador().getUso();
        Long memoria = looca.getMemoria().getTotal();
        Long memoriaEmuso = looca.getMemoria().getEmUso();
        Long usoRam = memoriaEmuso * 100 / memoria;
                
        System.out.println("\n\nEstou no Slack!!!\n\n");
        
//        Timer timer =  new Timer();
//        TimerTask slack = new TimerTask() {
//            @Override
//            public void run() {
                List capturaRam = con.queryForList(queryRam);
                List capturaCpu = con.queryForList(queryCpu);
                
                if(wh == null || wh.equals("")){
                    System.out.println("\nNenhum Slack cadastrado/encontrado.\n");
                }else{
                    url = wh;
                    JSONObject json = new JSONObject();
                    String usoCpu = String.format("%.0f", usoProcessador);

                    if(usoProcessador >= 75){
                        json.put("text", "A máquina: " + id_maquina + " do setor: " + set + " está com o uso da CPU acima do normal, é recomendado verificar a máquina."
                                + "\nUso da CPU: " + usoCpu + "%");
                        try {
                            enviarMensagem(json);
                        } catch (IOException ex) {
                            Logger.getLogger(SlackApp.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SlackApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if(usoRam >= 75){
                            json.put("text", "A máquina: " + id_maquina + " do setor: " + set + " está com o uso da memória RAM acima do normal, é recomendado verificar a máquina."
                                    + "\nUso da memória RAM: " + usoRam + "%");
                        try {
                            enviarMensagem(json);
                        } catch (IOException ex) {
                            Logger.getLogger(SlackApp.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SlackApp.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
//        };
//        timer.scheduleAtFixedRate(slack, 0, 10000);
//    }

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