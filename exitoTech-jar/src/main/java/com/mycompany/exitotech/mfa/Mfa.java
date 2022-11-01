package com.mycompany.exitotech.mfa;

import java.io.IOException;
import java.util.Scanner;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.verify.CheckResponse;
import com.nexmo.client.verify.VerifyClient;
import com.nexmo.client.verify.VerifyRequest;
import com.nexmo.client.verify.VerifyResponse;
import com.nexmo.client.verify.VerifyStatus;

public class Mfa {

  /**
   * @param args
   * @throws NexmoClientException
   * @throws IOException
   */
  public static void main(String[] args) throws IOException, NexmoClientException {

    // 86TnTGgFEpcQMAKK
    // 366f47eb

    // Inicialização do cliente

    NexmoClient client = new NexmoClient.Builder()
        .apiKey("366f47eb")
        .apiSecret("86TnTGgFEpcQMAKK")
        .build();

    VerifyClient verifyClient = client.getVerifyClient();

    // Configuração do cliente(número), mensagem e tamanho do código (sendo: 4 ou 6)

    VerifyRequest request = new VerifyRequest("5511987343914", "Empresa deloitte");
    request.setLength(6);

    // Envio da msg ao usuário
    VerifyResponse verifyResponse = verifyClient.verify(request);

    // Validação do Token

    System.out.println("Digite o Código Recebido: ");

    Scanner input = new Scanner(System.in);
    String code = input.nextLine();

    String requestId = verifyResponse.getRequestId();
    CheckResponse checkResponse = verifyClient.check(requestId, code);

    if (checkResponse.getStatus() == VerifyStatus.OK) {
      System.out.print("SUCESSO!");
    } else {
      System.out.print("ERRO!");
    }

  }

}
