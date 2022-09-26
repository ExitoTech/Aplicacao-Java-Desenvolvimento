package com.mycompany.exitotech.jar.conexaojdbc;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {

    public Connection conectarDB() {
        Connection conexao = null;
        try {
            String urlDeConexao = "jdbc:mysql://localhost:3306/nomeDoBd?user=root&password=";
            conexao = (Connection) DriverManager.getConnection(urlDeConexao);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro está localizado na classe de 'conexãoDAO'" + erro.getMessage());
        }

        return conexao;
    }

}
