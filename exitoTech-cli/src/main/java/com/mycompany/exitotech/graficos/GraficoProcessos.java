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

public class GraficoProcessos extends javax.swing.JFrame {

    public GraficoProcessos() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Processos");
        setSize(500, 500);
        setLocationRelativeTo(null);
        criarGraficoProcessos();
        setVisible(true);
    }

    public void criarGraficoProcessos() {
        Looca looca = new Looca();

        DefaultPieDataset pizza = new DefaultPieDataset();
        pizza.setValue("Total de processos", looca.getGrupoDeProcessos().getTotalProcessos());
        pizza.setValue("Quantidade de threads", looca.getGrupoDeProcessos().getTotalThreads());

        JFreeChart graficoPie = ChartFactory.createPieChart("Processos", pizza, true, true, false);
        ChartPanel panel = new ChartPanel(graficoPie);
        add(panel);
    }

}
