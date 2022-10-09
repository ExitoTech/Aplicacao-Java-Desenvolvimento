package com.mycompany.exitotech.jar.conexaojdbc;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author Vini
 */
public class SelectAll {

    public void SelecionarEmpresas() {
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();

        List<Empresa> listUsers = con.query("SELECT * FROM Empresa;", new BeanPropertyRowMapper(Empresa.class));
        for (Empresa pokemon : listUsers) {
            System.out.println(listUsers);
        }

    }
}
