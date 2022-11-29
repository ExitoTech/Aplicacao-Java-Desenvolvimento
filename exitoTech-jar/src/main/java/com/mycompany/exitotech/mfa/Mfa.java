package com.mycompany.exitotech.mfa;

import com.mycompany.exitotech.jar.gui.Dashboard;
import java.io.IOException;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.verify.CheckResponse;
import com.nexmo.client.verify.VerifyClient;
import com.nexmo.client.verify.VerifyRequest;
import com.nexmo.client.verify.VerifyResponse;
import com.nexmo.client.verify.VerifyStatus;
import javax.swing.JOptionPane;

public class Mfa {

//    // private String code;
//    private final NexmoClient client = new NexmoClient.Builder()
//            .apiKey("366f47eb")
//            .apiSecret("86TnTGgFEpcQMAKK")
//            .build();
//
//    private VerifyClient verifyClient;
//
//    // Configuração do cliente(número), mensagem e tamanho do código (sendo: 4 ou 6)
//    private final VerifyRequest request = new VerifyRequest("5511997599139", "Acess Code");
//    // request.setLength(6);
//
//    // Envio da msg ao usuário
//    private VerifyResponse verifyResponse;
//
//    // Validação do Token
//    private String requestId;;
    /**
     * @param code
     * @param args
     * @return
     * @throws NexmoClientException
     * @throws IOException
     */
//    public void setCode(String code) {
//        this.code = code;
//    }
//    public void setVerifyClient() {
//
//        verifyClient = client.getVerifyClient();
//
//    }
//
//    public void setVerifyResponse() throws IOException, NexmoClientException {
//
//        request.setLength(6);
//
//        verifyResponse = verifyClient.verify(request);
//
//    }
//
//    public void setRequestId() {
//
//        requestId = verifyResponse.getRequestId();
//    }
    public String codeOne() throws IOException, NexmoClientException {
        NexmoClient client = new NexmoClient.Builder()
                .apiKey("c20609ce")
                .apiSecret("LuQcivAIbSillBR8")
                .build();

        VerifyClient verifyClient = client.getVerifyClient();

        // Configuração do cliente(número), mensagem e tamanho do código (sendo: 4 ou 6)
        VerifyRequest request = new VerifyRequest("5511997599139", "Acess Code");
        request.setLength(6);

        // Envio da msg ao usuário
        VerifyResponse verifyResponse = verifyClient.verify(request);

        // Validação do Token
        String requestId = verifyResponse.getRequestId();

        System.out.println(requestId);
        
        return requestId;

    }

    public void validarToken(String codeApi, String userCode) throws IOException, NexmoClientException {

        NexmoClient client = new NexmoClient.Builder()
                .apiKey("c20609ce")
                .apiSecret("LuQcivAIbSillBR8")
                .build();

        VerifyClient verifyClient = client.getVerifyClient();
        
        CheckResponse checkResponse = verifyClient.check(codeApi, userCode);

        if (checkResponse.getStatus() == VerifyStatus.OK) {
            JOptionPane.showMessageDialog(null, "Sucesso!");
            new Dashboard().setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Código inválido!");
            System.out.print("ERRO!");

        }

    }

}
