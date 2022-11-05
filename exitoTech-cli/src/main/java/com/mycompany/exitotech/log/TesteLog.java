package com.mycompany.exitotech.log;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class TesteLog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Scanner input = new Scanner(System.in);
        Log aplicacao = new Log();
        
        System.out.println("Entre com o nome do arquivo ou diretório: ");
        aplicacao.analyzePath(input.nextLine());
        
    }
    
}
