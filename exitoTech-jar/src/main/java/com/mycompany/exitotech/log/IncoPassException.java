package com.mycompany.exitotech.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class IncoPassException extends RuntimeException {

  /**
   *
   * @author Tarifa
   */

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Throwable#getMessage()
   */

  private String mensagem;

  public void salvarArq() {
    CriandoArquivoTxt arq = new CriandoArquivoTxt();
    arq.escreverTexto(
        String.format("C:\\Users\\Pichau\\Downloads\\log\\%s.ErroIncoPass.txt", arq.getData()),
        getMessage());

  }

  public void salvarLog(String cam, String path) throws IOException {
    CriandoArquivoTxt arq = new CriandoArquivoTxt();

    File name = new File(path);

    if (name.isDirectory()) {
      String diretory[] = name.list();
      for (String diretoryName : diretory) {
        if (diretoryName == String.format("C:\\Users\\Pichau\\Downloads\\log\\%s.ErroIncoPass.txt", arq.getData())) {
          FileWriter arqWr = new FileWriter(cam);
          PrintWriter writerArq = new PrintWriter(arqWr);
          writerArq.println(getMessage());
          arqWr.close();
          break;
        }
      }

    } else { // se não for arquivo ou diretório, gera saída da mensagem de erro
      System.out.printf("%s %s", path, "Não existe");
    }
  }

  /**
   * @param mensagem
   * @return
   */
  @Override
  public String getMessage() {
    this.mensagem = mensagem;
    LocalDateTime agora = LocalDateTime.now();

    // formatar a data
    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    String dataFormatada = formatterData.format(agora);

    // formatar a hora
    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    String horaFormatada = formatterHora.format(agora);
    // TODO Auto-generated method stub
    return String.format("\n[Erro] [%s] [%s]  (IncoPassException: Senha ou Login - incorreto)",
        dataFormatada,
        horaFormatada);
  }

}
