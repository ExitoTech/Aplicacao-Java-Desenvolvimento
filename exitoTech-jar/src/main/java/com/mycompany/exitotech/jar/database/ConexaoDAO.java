package com.mycompany.exitotech.jar.database;

import java.awt.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoDAO {

    private JdbcTemplate connection;

    public void conexaoMysql() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://srvexitotech.database.windows.net;database=bdExitoTech");
        dataSource.setUsername("adminExitoTech");
        dataSource.setPassword("#Gfgrupo2");

        connection = new JdbcTemplate(dataSource);
        System.out.println("conectado!");
    }

    public JdbcTemplate getConnection() {
        return connection;
    }

    
    
}
