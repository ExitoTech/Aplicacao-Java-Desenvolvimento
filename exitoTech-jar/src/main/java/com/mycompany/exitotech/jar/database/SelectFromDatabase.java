package com.mycompany.exitotech.jar.database;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.exitotech.jar.gui.Dashboard;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.sql.RowSet;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Vini
 */
public class SelectFromDatabase {

    public void validarLogin(String email, String senha) {
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();

        Integer incremntoValidacao = 0;

        List<Empresa> listUsers = con.query("SELECT * FROM Empresa;", new BeanPropertyRowMapper(Empresa.class));

        for (Empresa itemEmpresa : listUsers) {
            if (itemEmpresa.getEmailEmpresa().equals(email) && itemEmpresa.getSenhaEmpresa().equals(senha)) {
                incremntoValidacao++;
            }
        }
        if (incremntoValidacao > 0) {
            JOptionPane.showMessageDialog(null, "Logado com Sucesso!");
            new Dashboard().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Senha ou Email invalidos!");
        }
    }

    public void validarMaquina(String idNumero) {
        Integer id = Integer.parseInt(idNumero);

        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();

        Boolean existeMaquina = false;
        List<Maquina> listMaquinas = con.query("SELECT * FROM Maquina;", new BeanPropertyRowMapper(Maquina.class));

        for (int i = 0; i < listMaquinas.size(); i++) {
            if (id.equals(listMaquinas.get(i).getIdMaquina())) {
                existeMaquina = true;
            }
        }

        if (existeMaquina == true) {
            JOptionPane.showMessageDialog(null, "Máquina confirmada!");
        } else {
            JOptionPane.showMessageDialog(null, "Máquina não existe no banco!");
        }
    }

    public void SelecionarEmpresas() {
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();

        List<Empresa> listUsers = con.query("SELECT * FROM Empresa;", new BeanPropertyRowMapper(Empresa.class));
        for (Empresa pokemon : listUsers) {
            System.out.println(listUsers);
        }

    }

    public void capturarDados() {
        Looca looca = new Looca();

        Double usoProcessador = looca.getProcessador().getUso();
        Long memoria = looca.getMemoria().getTotal();
        Long memoriaEmuso = looca.getMemoria().getEmUso();
        Long porcentagem = memoriaEmuso * 100 / memoria;

        System.out.println(String.format("Uso teorico %.2f", looca.getProcessador().getUso()));
        System.out.println(String.format("memoria %d", memoria));
        System.out.println("memoria em uso " + memoriaEmuso);
        System.out.println("Eu acho que dá certo");
        System.out.println(ConverteBytes(memoria));
        System.out.println(ConverteBytes(memoriaEmuso));
        System.out.println("Porcentagem" + porcentagem);

        insiraDados(porcentagem, usoProcessador);
    }

    public static Long ConverteBytes(long bytes) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes;
        }
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;

        }
        return bytes;
    }

    public void insiraDados(long porcentagemUsoMemoria, Double usoCpu) {
        Looca looca = new Looca();
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();
        Timer timer = new Timer();
        TimerTask tarefa = new TimerTask() {
            @Override
            public void run() {
                String query = String.format("Insert into capturas(usoCPU,usoRam,fk_maquina)"
                        + "Values(%.0f,%d,20000);", usoCpu, porcentagemUsoMemoria);

                con.execute(query);

            }
        };
        timer.scheduleAtFixedRate(tarefa, 0, (1000 * 3));
        capturarDados();
    }

}
