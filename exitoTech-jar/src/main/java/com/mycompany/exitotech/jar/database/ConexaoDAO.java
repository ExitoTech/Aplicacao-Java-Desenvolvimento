package com.mycompany.exitotech.jar.database;

import java.awt.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoDAO {

    private JdbcTemplate connection;

    public void conexaoMysql() {
        BasicDataSource dataSource = new BasicDataSource();

        System.out.println("Conectando..");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/exitoTech");
        dataSource.setUsername("root");
        dataSource.setPassword("V1k1ng1!");
        System.out.println("Conectado!");

        connection = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }

    
    
}