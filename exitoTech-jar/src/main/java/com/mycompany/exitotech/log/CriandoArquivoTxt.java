/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exitotech.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.imageio.IIOException;
/**
 *
 * @author User
 */
public class CriandoArquivoTxt {
    
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd-MM-yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH-mm-ss").format(dataHoraAtual);

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
        
        

  public static void escreverTexto(String caminhoArquivo, String texto){
      try(             
           
              FileWriter criadorDeArquivos = new FileWriter(caminhoArquivo, true);
              BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
              PrintWriter escritorDeArquivos = new PrintWriter(buffer);
              ){ 
              
              escritorDeArquivos.append(texto);
      }catch(IOException e){
          e.printStackTrace();
      }
      
      
  }


}
