package com.mycompany.exitotech.recuperar.senha;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vini
 */
public class OpenLink {

    private String guia;

    public OpenLink(String link) {
        this.guia = "https://exito-tech.azurewebsites.net/recuperarSenha.html";
    }

    public String getLink() {
        return guia;
    }

    public void setLink(String link) {
        this.guia = link;
    }

    public void AbrirGuiaRecuperacao() throws IOException {

        try {
            URI link = new URI(guia);
            Desktop.getDesktop().browse(link);
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir Link...");
        }

    }

}
