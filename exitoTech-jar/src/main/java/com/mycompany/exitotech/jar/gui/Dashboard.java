package com.mycompany.exitotech.jar.gui;
import com.github.britooo.looca.api.core.Looca;
import com.mycompany.exitotech.graficos.GraficoMemoria;
import com.mycompany.exitotech.graficos.GraficoDisco;
import com.mycompany.exitotech.graficos.GraficoProcessos;
public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GerarGraficoPizza = new javax.swing.JButton();
        ListarHardware = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GerarGraficoPizza.setBackground(new java.awt.Color(0, 6, 51));
        GerarGraficoPizza.setForeground(new java.awt.Color(255, 255, 255));
        GerarGraficoPizza.setText("USO DE MEMORIA");
        GerarGraficoPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarGraficoPizzaActionPerformed(evt);
            }
        });

        ListarHardware.setBackground(new java.awt.Color(0, 6, 51));
        ListarHardware.setForeground(new java.awt.Color(255, 255, 255));
        ListarHardware.setText("LISTAR HARDWARE");
        ListarHardware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarHardwareActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 6, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SAIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(GerarGraficoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListarHardware, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(GerarGraficoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(ListarHardware, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GerarGraficoPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarGraficoPizzaActionPerformed
       GraficoMemoria graficoMemoria = new GraficoMemoria();
        graficoMemoria.criarGraficoMemoria();
        
        GraficoDisco graficoDisco = new GraficoDisco();
        graficoDisco.criarGraficoDisco();
        
        GraficoProcessos graficoProcessos = new GraficoProcessos();
        graficoProcessos.criarGraficoProcessos();
    }//GEN-LAST:event_GerarGraficoPizzaActionPerformed

    private void ListarHardwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarHardwareActionPerformed
        Looca looca = new Looca();
        System.out.println(looca.getProcessador());
    }//GEN-LAST:event_ListarHardwareActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GerarGraficoPizza;
    private javax.swing.JButton ListarHardware;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
