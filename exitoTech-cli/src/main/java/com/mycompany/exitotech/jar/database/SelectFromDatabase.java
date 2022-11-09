package com.mycompany.exitotech.jar.database;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.exitotech.jar.gui.Dashboard;
import com.mycompany.exitotech.jar.gui.HomeFuncionario;
import com.mycompany.exitotech.jar.gui.LoginMaquina;
import com.mycompany.exitotech.slack.app.SlackApp;
import java.io.IOException;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        String query = "SELECT * FROM funcionario WHERE email = '" + email + "' AND senha = '" + senha + "' ;";
        List<Funcionario> listUsers = con.query(query, new BeanPropertyRowMapper(Funcionario.class));

        for (Funcionario itemFuncionario : listUsers) {
            if (itemFuncionario.getEmail().equals(email) && itemFuncionario.getSenha().equals(senha)) {
                incremntoValidacao++;
            }
        }
        if (incremntoValidacao > 0) {
            JOptionPane.showMessageDialog(null, "Logado com Sucesso!");
            new Dashboard().setVisible(true);
        } else if (incremntoValidacao > 1) {
            JOptionPane.showMessageDialog(null, "Mais de um Usuario com mesmo Login!!");
        } else {
            JOptionPane.showMessageDialog(null, "Senha ou Email invalidos!");
            

        }
    }

    public void validarMaquina(String idNumero) {
        Integer id = Integer.parseInt(idNumero);

        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();

        String query = "SELECT * FROM maquina WHERE idMaquina = '" + idNumero + "'";
        Boolean existeMaquina = false;
        List<Maquina> listMaquinas = con.query(query, new BeanPropertyRowMapper(Maquina.class));

        for (int i = 0; i < listMaquinas.size(); i++) {
            if (id.equals(listMaquinas.get(i).getIdMaquina())) {
                existeMaquina = true;
            }
        }

        if (existeMaquina == true) {
            JOptionPane.showMessageDialog(null, "Máquina confirmada!");
            new LoginMaquina().setVisible(false);
            new HomeFuncionario().setVisible(true);
            insiraDados(id);
            captureDados(id);
        } else {
            JOptionPane.showMessageDialog(null, "Máquina não existe no banco!");
        }
    }

    public void SelecionarEmpresas() {
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();

        List<Funcionario> listUsers = con.query("SELECT * FROM Empresa;", new BeanPropertyRowMapper(Funcionario.class));
        for (Funcionario pokemon : listUsers) {
            System.out.println(listUsers);
        }

    }

    public void insiraDados(Integer id_maquina) {

        Looca looca = new Looca();
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();

        Timer timer = new Timer();
        TimerTask tarefa = new TimerTask() {
            @Override
            public void run() {

                Double usoProcessador = looca.getProcessador().getUso();
                Long memoria = looca.getMemoria().getTotal();
                Long memoriaEmuso = looca.getMemoria().getEmUso();
                Long porcentagem = memoriaEmuso * 100 / memoria;
                String simboloPCT = "%";

                System.out.println("------------------------------------------------");
                System.out.println("memoria Total: " + ConverteBytes(memoria) + " Mb");
                System.out.println("memoria em uso: " + ConverteBytes(memoriaEmuso) + " Mb");
                System.out.println("Porcentagem de memoria em uso: " + porcentagem + "%");
                System.out.println(String.format("Porcentagem de uso processador: %.0f%s ", usoProcessador, simboloPCT));
                System.out.println("------------------------------------------------");

                String query = String.format("Insert into capturas(usoCPU,usoRam,fk_maquina)"
                        + "Values(%.0f,%d,%d);", usoProcessador, porcentagem, id_maquina);
                con.execute(query);

                try {
                    SlackApp.validacao(id_maquina, usoProcessador, porcentagem);
                } catch (IOException ex) {
                    Logger.getLogger(SelectFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SelectFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        timer.scheduleAtFixedRate(tarefa, 0, 5000);

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

    public void captureDados(Integer id) {

        Looca looca = new Looca();
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();

        String nome = looca.getProcessador().getId();
        String processador = looca.getProcessador().getNome();
        String so = looca.getSistema().getSistemaOperacional();
        String ArquiteturaSO = looca.getSistema().getArquitetura() + "bits";
        Long SizeDisco = ConverteBytes(looca.getGrupoDeDiscos().getTamanhoTotal());
        Long SizeMemoria = ConverteBytes(looca.getMemoria().getTotal());

        System.out.println(nome);
        System.out.println("----------------");
        System.out.println(processador);
        System.out.println("----------------");
        System.out.println(so);
        System.out.println("----------------");
        System.out.println(ArquiteturaSO);
        System.out.println("----------------");
        System.out.println(SizeDisco /1000 + "GB");
        System.out.println("----------------");
        System.out.println(SizeMemoria / 1000 + "GB");
        System.out.println("----------------");

        String query = String.format("update maquina"
                + " set nomeMaquina = '%s',"
                + "processador = '%s',"
                + "sistemaOperacional = '%s',"
                + "arquiteturaSO = '%s', "
                + "memoriaRam = '%s',"
                + "memoriaMassa = '%s'"
                + "where idMaquina = %d;", nome, processador, so, ArquiteturaSO, SizeDisco /1000 + "GB", SizeMemoria/ 1000 + "GB", id);

        con.execute(query);

    }

}
