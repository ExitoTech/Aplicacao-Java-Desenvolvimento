package com.mycompany.exitotech.jar.conexaojdbc;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.RowSet;


public class ConexaoDAO {

    private String url = "jdbc:mysql://localhost:3306/bdExitoTech";
    private String user = "root";
    private String password = "V1k1ng1!";
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
    
        public void entrar(String email,String senha){
            
            String query = "SELECT * FROM empresa WHERE emailempresa = '" + email + "' AND senhaempresa = '" + senha + "' ;";
            
        try {
            ResultSet resultSet = con.createStatement().executeQuery(query);
            while(resultSet.next()){
                System.out.println("Entrando com usuario " + resultSet.getString("Nome"));
            }
        } catch (SQLException e) {
            System.out.println("Erro na classe 'conexãoDAO', metodo 'entrar'. " + e.getMessage());
        }
    }

        public  void Insert(String nome,String Cnpj,String email,String senha,String porte,String Logradouro,String uf,String CEP){
            
            String query = String.format(" INSERT INTO empresa (nome,cnpj,emailempresa,senhaempresa,porteempresa,logradouro,uf,cep)"
                    + "Values ('%s','%s','%s','%s','%s','%s','%s','%s');", nome,Cnpj,email,senha,porte,Logradouro,uf,CEP);
            
        try {
            
            Statement st = con.createStatement();
            int m  = st.executeUpdate(query);
            
            if(m == 1){
                System.out.println("Inserindo na tabela empresa:" +  query);
            }
        } catch (SQLException e) {
            System.out.println("Erro na classe 'conexãoDAO', metodo 'Insert'. " + e.getMessage());
        }
        }
}
