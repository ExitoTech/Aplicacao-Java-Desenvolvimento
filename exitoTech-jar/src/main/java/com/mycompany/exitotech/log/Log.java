package com.mycompany.exitotech.log;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author aluno
 */
public class Log {

    /**
     *
     * @author Tarifa
     */

    public static void main(String[] args) {

        System.out.println(" _____        _  _           _____              _     \n"
                + "|  ___|      (_)| |         |_   _|            | |    \n"
                + "| |__  __  __ _ | |_   ___    | |    ___   ___ | |__  \n"
                + "|  __| \\ \\/ /| || __| / _ \\   | |   / _ \\ / __|| '_ \\ \n"
                + "| |___  >  < | || |_ | (_) |  | |  |  __/| (__ | | | |\n"
                + "\\____/ /_/\\_\\|_| \\__| \\___/   \\_/   \\___| \\___||_| |_|\n"
                + "                                                      "
                + "                                                      ");

        System.out.println("Arquivos do diretório de Logs:");
        String path = "C:\\Users\\Pichau\\Downloads\\log";

        analyzePath(path);

    }

    // exibe informaçções sobre o arquivo que o usuário deseja
    public static void analyzePath(String path) {

        Scanner scln = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        // cria o objeto com base na entrada do usuário
        File name = new File(path);

        if (name.exists()) { // se o nome existir, gera saída das informações sobre ele

            System.out.printf("\nNome do Diretório:\t%s%s\n\t%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
                    name.getName(),
                    "\n\texiste",
                    (name.isFile() ? "\né um arquivo" : "não é um arquivo"),
                    (name.isDirectory() ? "\né um diretório" : "Não é um diretório"),
                    (name.isAbsolute() ? "\npath absoluto" : "path não absoluto"),
                    "\núltima modificação: ",
                    name.lastModified(), "\nTamanho: ", name.length(),
                    "\nPath: ", name.getPath(), "\nPath absoluto: ",
                    name.getAbsolutePath(), "\nParente: ", name.getParent());

            System.out.println("\n\n| ----------------------------------------- |" +
                    "\n| BEM VINDO AO SISTEMA DE LOGS - EXITO TECH |" +
                    "\n| ----------------------------------------- |" +
                    "\n| DIGITE A OPÇÃO DESEJADA:                  |" +
                    "\n| 1. VER TODOS LOGS........................ |" +
                    "\n| 2. LER CONTEÚDO ARQUIVO.................. |" +
                    "\n| 3. SAIR.................................. |" +
                    "\n| ----------------------------------------- |");

            Integer op = sc.nextInt();

            // if (op.equals(4))
            // System.out.println("\n\n| ------------SISTEMA ENCERRADO------------ |");
            // sc.close();

            do {

                switch (op) {
                    case 1:
                        if (name.isDirectory()) {

                            String diretory[] = name.list();
                            System.out.println("\n\nConteúdo Diretório:");

                            for (String diretoryName : diretory)
                                System.out.printf("%s\n", diretoryName);
                        }

                        else { // se não for arquivo ou diretório, gera saída da mensagem de erro
                            System.out.printf("%s %s", path, "Não existe");

                        }
                        op = sc.nextInt();

                        break;

                    case 2:

                        System.out.printf("Informe o nome de arquivo texto \n(Passando juntamente o dir)\n");

                        String nome = scln.nextLine();
                        System.out.printf("\nConteúdo do arquivo texto:\n");

                        try {
                            FileReader arq = new FileReader(nome);
                            BufferedReader readArq = new BufferedReader(arq);
                            String line = readArq.readLine(); // lê a primeira linha
                            do {
                                System.out.printf("%s\n", line);
                                line = readArq.readLine(); // lê da segunda até a última linha
                            } while (line != null);

                            arq.close();
                        } catch (IOException e) {
                            System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
                        }
                        System.out.println();
                        op = sc.nextInt();
                        break;

                    default:
                        System.out.println("\nEscolha Incorreta");
                }

            } while (!op.equals(3));

        }
    }
}
