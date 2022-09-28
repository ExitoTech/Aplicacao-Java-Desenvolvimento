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

public class GraficoMemoria extends javax.swing.JFrame {

    public GraficoMemoria() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Memória");
        setSize(500, 500);
        setLocationRelativeTo(null);
        criarGraficoMemoria();
        setVisible(true);
    }


    public void criarGraficoMemoria() {
        Looca looca = new Looca();

        DefaultPieDataset pizza = new DefaultPieDataset();
        pizza.setValue("Em uso", looca.getMemoria().getEmUso());
        pizza.setValue("Disponivel", looca.getMemoria().getDisponivel());
        pizza.setValue("Total", looca.getMemoria().getTotal());

        JFreeChart graficoPie = ChartFactory.createPieChart("Uso de Memória", pizza, true, true, false);
        ChartPanel panel = new ChartPanel(graficoPie);
        add(panel);
    }

}

