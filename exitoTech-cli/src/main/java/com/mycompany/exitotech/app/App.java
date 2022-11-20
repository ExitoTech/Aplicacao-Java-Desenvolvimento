package com.mycompany.exitotech.app;

import java.util.Scanner;
import com.mycompany.exitotech.jar.database.ConexaoDAO;
import com.mycompany.exitotech.jar.database.SelectFromDatabase;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer numDigitado = 0;

        System.out.println(" _____        _  _           _____              _     \n"
                + "|  ___|      (_)| |         |_   _|            | |    \n"
                + "| |__  __  __ _ | |_   ___    | |    ___   ___ | |__  \n"
                + "|  __| \\ \\/ /| || __| / _ \\   | |   / _ \\ / __|| '_ \\ \n"
                + "| |___  >  < | || |_ | (_) |  | |  |  __/| (__ | | | |\n"
                + "\\____/ /_/\\_\\|_| \\__| \\___/   \\_/   \\___| \\___||_| |_|\n"
                + "                                                      "
                + "                                                      ");

        do {
            System.out.println("< ----- MENU ----- >");
            System.out.println("Digite 1 para login");
            System.out.println("Digite 0 para sair");
            numDigitado = sc.nextInt();

            if (numDigitado == 1) {
                System.out.println("< ----- LOGIN ----- >");
                SelectFromDatabase conexaoCLI = new SelectFromDatabase();
                Scanner scLoginUser = new Scanner(System.in);
                Integer numMaquina = 0;
                System.out.println("Digite o numero da sua maquina");
                numMaquina = scLoginUser.nextInt();
                
                conexaoCLI.validarMaquina(numMaquina.toString(),"inicio");

                scLoginUser.close();
                          
            } else if (numDigitado == 0) {
                System.out.println("Saindo...");
            }
        } while (numDigitado != 0);
        
    sc.close();
    
    }

}
