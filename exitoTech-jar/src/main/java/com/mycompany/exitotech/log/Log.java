package com.mycompany.exitotech.log;


import java.io.File;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author aluno
 */
public class Log {


    // exibe informaçções sobre o arquivo que o usuário deseja
    public void analyzePath(String path) {

        //cria o objeto com base na entrada do usuário
        File name = new File(path);

        if (name.exists()) { //se o nome existir, gera saída das informações sobre ele

            System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s", name.getName(), "existe",
                    (name.isFile() ? "é um arquivo" : "não é um arquivo"),
                    (name.isDirectory() ? "é um diretório" : "Não é um diretório"),
                    (name.isAbsolute() ? "path absoluto" : "path não absoluto"),
                    "última modificação: ",
                    name.lastModified(), "Tamanho: ", name.length(),
                    "Path: ", name.getPath(), "Path absoluto: ",
                    name.getAbsolutePath(), "Parente: ", name.getParent());

            if (name.isDirectory()) {

                String diretory[] = name.list();
                System.out.println("\nzn Conteúdo Diretório:\n");

                for (String directoryName : diretory) {
                    System.out.printf("%s\n", directoryName);
                }

            }
        } else { // se não for arquivo ou diretório, gera saída da mensagem de erro
            System.out.printf(";%s %s", path, "Não existe");

        }

    }

}
