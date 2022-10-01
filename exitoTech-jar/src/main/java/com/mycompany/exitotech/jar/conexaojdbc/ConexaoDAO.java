package com.mycompany.exitotech.jar.conexaojdbc;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.sql.RowSet;


public class ConexaoDAO {

    private String url = "jdbc:mysql://localhost:3306/bdExitoTech";
    private String user = "root";
    private String password = "vini@123";
    private java.sql.Connection con = null;
        
    public void conexaoMysql(){
        try {
//            JOptionPane.showConfirmDialog(null, "Inicializando conexão");
            System.out.println("Inicializando conexão");
            con = DriverManager.getConnection(url,user,password);
//            JOptionPane.showMessageDialog(null, "Conexão realizada!");
             System.out.println("Conexão realizada!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro está localizado na classe de 'conexãoDAO'" + ex.getMessage());
        }

    }
    
        public void selecionarTudo(String query){
        try {
            ResultSet resultSet = con.createStatement().executeQuery(query);
            while(resultSet.next()){
                System.out.println("Nome da empresa:" + resultSet.getString("Nome"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na classe 'conexãoDAO', metodo 'selecionarTudo'. " + e.getMessage());
        }
    }

        public  void Insert(String query){
        try {
            RowSet resultSet = (RowSet) con.createStatement().executeQuery(query);
            while(resultSet.next()){
                System.out.println("Inserir na empresa:" + resultSet.getString("Nome"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na classe 'conexãoDAO', metodo 'Insert'. " + e.getMessage());
        }
        }
}
