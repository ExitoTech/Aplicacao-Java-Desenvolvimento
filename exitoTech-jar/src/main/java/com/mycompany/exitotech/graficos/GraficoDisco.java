package com.mycompany.exitotech.graficos;

import com.github.britooo.looca.api.core.Looca;
import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoDisco extends javax.swing.JFrame {

    public GraficoDisco() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Disco");
        setSize(500, 500);
        setLocationRelativeTo(null);
        criarGraficoDisco();
        setVisible(true);
    }


    public void criarGraficoDisco() {
        Looca looca = new Looca();

        DefaultPieDataset pizza = new DefaultPieDataset();
        pizza.setValue("Quantidade de discos", looca.getGrupoDeDiscos().getQuantidadeDeDiscos());
        pizza.setValue("Quantidade de volumes", looca.getGrupoDeDiscos().getQuantidadeDeVolumes());
        pizza.setValue("Tamanho Total", looca.getGrupoDeDiscos().getTamanhoTotal());

        JFreeChart graficoPie = ChartFactory.createPieChart("Uso de Disco", pizza, true, true, false);
        ChartPanel panel = new ChartPanel(graficoPie);
        add(panel);
    }

}