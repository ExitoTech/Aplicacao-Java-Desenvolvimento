package com.mycompany.exitotech.jar.database;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.exitotech.jar.gui.Dashboard;
import com.mycompany.exitotech.jar.gui.HomeFuncionario;
import com.mycompany.exitotech.jar.gui.LoginMaquina;
import com.mycompany.exitotech.jar.gui.MFA;
import com.mycompany.exitotech.log.CriandoArquivoTxt;
import com.mycompany.exitotech.slack.app.SlackApp;
import com.nexmo.client.NexmoClientException;
import java.io.IOException;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Vini
 */
public class SelectFromDatabase {

    public void validarConexao() {
        try {
            ConexaoDAO connection = new ConexaoDAO();
            connection.conexaoMysql();
            JdbcTemplate con = connection.getConnection();

        } catch (RuntimeException t) {
            CriandoArquivoTxt arq = new CriandoArquivoTxt();

            arq.escreverTexto(String.format("C:\\Users\\lucas\\Desktop\\ExitoTech\\Aplicacao-Java-Desenvolvimento\\exitoTech-jar\\logs\\log-conexao-%s-%s.txt", arq.getData(), arq.getHora()),
                    String.format("log-conexao-%s-%s: Falha na conexão DAO", arq.getData(), arq.getHora()));
            t.getMessage();
            System.out.println("erro na conexão DAO");
        }
    }

    public void validarLogin(String email, String senha) throws IOException, NexmoClientException {
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();
        //connection.conexaoMysqlLocal();
        //JdbcTemplate conLocal = connection.getConnection();

        Integer incrementoValidacao = 0;

        String query = "SELECT * FROM funcionario WHERE email = '" + email + "' AND senha = '" + senha + "' ;";
        List<Funcionario> listUsers = con.query(query, new BeanPropertyRowMapper(Funcionario.class));
//        List<Funcionario> listUsersLocal = conLocal.query(query, new BeanPropertyRowMapper(Funcionario.class));

        for (Funcionario itemFuncionario : listUsers) {
            if (itemFuncionario.getEmail().equals(email) && itemFuncionario.getSenha().equals(senha)) {
                incrementoValidacao++;
            }
        }

//        for (Funcionario itemFuncionario : listUsersLocal) {
//            if (itemFuncionario.getEmail().equals(email) && itemFuncionario.getSenha().equals(senha)) {
//                incrementoValidacao++;
//            }
//        }

        if (incrementoValidacao > 0) {
            JOptionPane.showMessageDialog(null, "Logado com Sucesso!");

            if (listUsers.get(0).getQrCode().equals(0)) {
                new Dashboard().setVisible(true);
            } else {
                new MFA().setVisible(true);
            }

          

        } else {
            JOptionPane.showMessageDialog(null, "Senha ou Email invalidos!");
            CriandoArquivoTxt arq = new CriandoArquivoTxt();

            arq.escreverTexto(String.format("C:\\Users\\lucas\\Desktop\\ExitoTech\\Aplicacao-Java-Desenvolvimento\\exitoTech-jar\\logs\\log-falha-login-%s-%s.txt", arq.getData(), arq.getHora()),
                    String.format("falha-login-%s-%s: Falha no login, usuario ou senha invalidos", arq.getData(), arq.getHora()));
            throw new RuntimeException("Erro de login");
        }

    }

    public void validarMaquina(String idNumero, String metodo) {
        Integer id = Integer.parseInt(idNumero);
        String atividade = "desativado";
        String inserirStatus;

        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();
        connection.conexaoMysqlLocal();
        JdbcTemplate conLocal = connection.getConnection();

        String query = "SELECT * FROM maquina WHERE idMaquina = '" + idNumero + "'";
        Boolean existeMaquina = false;
        List<Maquina> listMaquinas = con.query(query, new BeanPropertyRowMapper(Maquina.class));
        List<Maquina> listMaquinasLocal = conLocal.query(query, new BeanPropertyRowMapper(Maquina.class));

        for (int i = 0; i < listMaquinas.size(); i++) {
            if (id.equals(listMaquinas.get(i).getIdMaquina())) {
                existeMaquina = true;
            }
        }

        for (int i = 0; i < listMaquinasLocal.size(); i++) {
            if (id.equals(listMaquinasLocal.get(i).getIdMaquina())) {
                existeMaquina = true;
            }
        }
        if (existeMaquina == true) {
            if (metodo.equals("inicio")) {
                atividade = "inicio";
                insiraDados(id);
                captureDados(id);

                inserirStatus = String.format("update maquina set statusMaquina = '" + atividade + "' where idMaquina = '" + id + "' ;");
                new HomeFuncionario().setVisible(true);
                con.execute(inserirStatus);
                conLocal.execute(inserirStatus);

            } else if (metodo.equals("ativado")) {
                atividade = "ativado";

                inserirStatus = String.format("update maquina set statusMaquina = '" + atividade + "' where idMaquina = '" + id + "' ;");
                con.execute(inserirStatus);
                conLocal.execute(inserirStatus);

            } else if (metodo.equals("pausar")) {
                JOptionPane.showMessageDialog(null, "Bom almoço!");
                atividade = "pausado";

                inserirStatus = String.format("update maquina set statusMaquina = '" + atividade + "' where idMaquina = '" + id + "' ;");
                con.execute(inserirStatus);
                conLocal.execute(inserirStatus);

            } else {
                atividade = "desativado";

                inserirStatus = String.format("update maquina set statusMaquina = '" + atividade + "' where idMaquina = '" + id + "' ;");
                con.execute(inserirStatus);
                conLocal.execute(inserirStatus);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Máquina não existe no banco!");
        }

    }

    public void insiraDados(Integer id_maquina) {
        Looca looca = new Looca();
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();
        connection.conexaoMysqlLocal();
        JdbcTemplate conLocal = connection.getConnection();

        Timer timer = new Timer();
        TimerTask tarefa = new TimerTask() {
            @Override
            public void run() {

                Double usoProcessador = looca.getProcessador().getUso();
                Long memoria = looca.getMemoria().getTotal();
                Long memoriaEmuso = looca.getMemoria().getEmUso();
                Long porcentagem = memoriaEmuso * 100 / memoria;
                Long SizeDisco = looca.getGrupoDeDiscos().getTamanhoTotal();
                Long SizeEmUso = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel();
                Long porcentagemDisco = SizeEmUso * 100 / SizeDisco;
                String simboloPCT = "%";

                System.out.println("------------------------------------------------");
                System.out.println("memoria Total: " + ConverteBytes(memoria) + " Mb");
                System.out.println("memoria em uso: " + ConverteBytes(memoriaEmuso) + " Mb");
                System.out.println("Porcentagem de memoria em uso: " + porcentagem + "%");
                System.out.println(String.format("Porcentagem de uso processador: %.0f%s ", usoProcessador, simboloPCT));
                System.out.println(String.format("Porcentagem de uso  Disco: %d%s ", porcentagemDisco, simboloPCT));
                System.out.println("------------------------------------------------");

                String query = String.format("Insert into capturas(usoCPU,usoRam,usoDisco,fk_maquina)"
                        + "Values(%.0f,%d,%d,%d);", usoProcessador, porcentagem, porcentagemDisco, id_maquina);
                con.execute(query);
                conLocal.execute(query);
            }
        };
        timer.scheduleAtFixedRate(tarefa, 0, 5000);

        TimerTask slack = new TimerTask() {
            @Override
            public void run() {
                try {
                    SlackApp.validacao(id_maquina);
                } catch (IOException ex) {
                    Logger.getLogger(SelectFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SelectFromDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        timer.scheduleAtFixedRate(slack, 0, 30000);
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
        connection.conexaoMysqlLocal();
        JdbcTemplate conLocal = connection.getConnection();

        String nome = looca.getProcessador().getId();
        String processador = looca.getProcessador().getNome();
        String so = looca.getSistema().getSistemaOperacional();
        String ArquiteturaSO = looca.getSistema().getArquitetura() + "bits";
        Long SizeDisco = ConverteBytes(looca.getGrupoDeDiscos().getTamanhoTotal());
        Long SizeMemoria = ConverteBytes(looca.getMemoria().getTotal());

        if (SizeDisco < 1000) {
            SizeDisco /= 1000;
        }

        System.out.println(nome);
        System.out.println("----------------");
        System.out.println(processador);
        System.out.println("----------------");
        System.out.println(so);
        System.out.println("----------------");
        System.out.println(ArquiteturaSO);
        System.out.println("----------------");
        System.out.println(SizeDisco + "GB");
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
                + "where idMaquina = %d;", nome, processador, so, ArquiteturaSO, SizeMemoria / 1000 + "GB", SizeDisco + "GB", id);

        con.execute(query);
        conLocal.execute(query);
    }

    public void insiraHorasTrabalhadas(Integer hora, Integer minutos, Integer horaPausa, Integer minutosPausa, String idMaquina) {
        ConexaoDAO connection = new ConexaoDAO();
        connection.conexaoMysql();
        JdbcTemplate con = connection.getConnection();
        connection.conexaoMysqlLocal();
        JdbcTemplate conLocal = connection.getConnection();

        Integer ano = LocalDate.now().getYear();
        Integer mes = LocalDate.now().getMonthValue();
        Integer dia = LocalDate.now().getDayOfMonth();

        String query = String.format("insert into bancoDeHora(dataRegistro,horasTrabalhadas,tempoPausa,fk_maquina)"
                + "values('%d-%d-%d','%d:%d','%d:%d',%s);", ano, mes, dia, hora, minutos, horaPausa, minutosPausa, idMaquina);

        con.execute(query);
        conLocal.execute(query);

    }
}
