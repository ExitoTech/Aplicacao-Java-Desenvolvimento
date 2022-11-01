package com.mycompany.exitotech.log;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import com.github.seratch.jslack.api.audit.Actions.File;

public class Log {

  public static void main(String[] args) {
    File arquivo = new File("arquivo.txt");

    if (!arquivo.exists()) {
      arquivo.createNewFile();
    }
    List<String> lista = new ArrayList<>();
    lista.add("Fazendo um log simples");
    lista.add("Usuario: Joãozinho Fez uma alteração neste hora: "
        + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));

    Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
  }

}
