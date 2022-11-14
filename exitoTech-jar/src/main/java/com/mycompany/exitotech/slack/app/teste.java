
package com.mycompany.exitotech.slack.app;

import com.mycompany.exitotech.jar.database.ConexaoDAO;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
public class teste {
    public static void main(String[] args) {
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysqlLocal();
        JdbcTemplate con = connection.getConnection();
        String query = "SELECT emp.webHook AS webHook\n" +
                        "FROM maquina AS maq \n" +
                        "JOIN setor AS ser\n" +
                        "ON ser.idSetor = maq.fk_setor\n" +
                        "RIGHT JOIN empresa AS emp\n" +
                        "ON ser.fk_Empresa = emp.idEmpresa WHERE idEmpresa = 2;"    ;
        List webHook = con.queryForList(query);
        System.out.println(webHook.toString().replace("[{webHook=", "").replace("}]", ""));
    }
}
