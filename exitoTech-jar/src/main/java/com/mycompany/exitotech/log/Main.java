/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exitotech.log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd-MM-yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH-mm-ss").format(dataHoraAtual);
        CriandoArquivoTxt.escreverTexto(String.format("C:\\Users\\User\\Desktop\\log\\%s-%s",data, hora),
                "Aleatoria");
        
        System.out.println(data);
        System.out.println(hora);
    }
}
