package com.mycompany.exitotech.jar.gui;
import com.github.britooo.looca.api.core.Looca;
import com.mycompany.exitotech.graficos.GraficoMemoria;
import com.mycompany.exitotech.graficos.GraficoProcessos;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GerarGraficoPizza = new javax.swing.JButton();
        ListarHardware = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GerarGraficoPizza.setBackground(new java.awt.Color(0, 6, 51));
        GerarGraficoPizza.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        GerarGraficoPizza.setForeground(new java.awt.Color(255, 255, 255));
        GerarGraficoPizza.setText("USO DE MEMORIA");
        GerarGraficoPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarGraficoPizzaActionPerformed(evt);
            }
        });

        ListarHardware.setBackground(new java.awt.Color(0, 6, 51));
        ListarHardware.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ListarHardware.setForeground(new java.awt.Color(255, 255, 255));
        ListarHardware.setText("LISTAR HARDWARE");
        ListarHardware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarHardwareActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(0, 6, 51));
        btnSair.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img-logo-jar.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GerarGraficoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ListarHardware, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GerarGraficoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListarHardware, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GerarGraficoPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarGraficoPizzaActionPerformed
       gerarGrafico();
    }//GEN-LAST:event_GerarGraficoPizzaActionPerformed

    private void ListarHardwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarHardwareActionPerformed
     listarHardware();
    }//GEN-LAST:event_ListarHardwareActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
     sair();
    }//GEN-LAST:event_btnSairActionPerformed

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
                new Dashboard().configSystemTray();
            }
        });
    }
    
     public void configSystemTray() {
        SystemTray tray = SystemTray.getSystemTray();

        Image img = Toolkit.getDefaultToolkit().getImage("src/main/resources/assets/img-logo-jar.png");

        ActionListener gerarGrafico = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               gerarGrafico();
            }
        };

        ActionListener listarHard = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 listarHardware();
            }
        };

        ActionListener sair = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               sair();
            }
        };
        
  //      ActionListener AbraAplicacao = new ActionListener() {
  //          public void actionPerformed(ActionEvent e) {
  //              new HomeFuncionario().setState(JFrame.MAXIMIZED_BOTH);
  //              
  //           }
  //      };
        
        
        PopupMenu popup = new PopupMenu();
        MenuItem gerarGraficos = new MenuItem();
        MenuItem listarHardwares = new MenuItem();
        MenuItem btnSair = new MenuItem();
        
        gerarGraficos.addActionListener(gerarGrafico);
        gerarGraficos.setLabel("Gr??ficos");
        
        listarHardwares.addActionListener(listarHard);
        listarHardwares.setLabel("Listar Hardware");
        
        btnSair.addActionListener(sair);
        btnSair.setLabel("Sair");
        
        popup.add(gerarGraficos);
        popup.add(listarHardwares);
        popup.add(btnSair);
        
        TrayIcon trayIcon = new TrayIcon(img, "ExitoTech", popup);
        // set the TrayIcon properties
        // ...
        trayIcon.setImageAutoSize(true);
        //trayIcon.addActionListener(AbraAplicacao);
        // add the tray image
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.err.println(e);
        }
             
    }
     
     public void gerarGrafico(){
        GraficoMemoria graficoMemoria = new GraficoMemoria();
        graficoMemoria.criarGraficoMemoria();
        
        GraficoProcessos graficoProcessos = new GraficoProcessos();
        graficoProcessos.criarGraficoProcessos();
     
     }
     
     public void listarHardware(){
        Looca looca = new Looca();
        System.out.println(looca.getProcessador());
     }
     
     public void sair(){
        JOptionPane.showMessageDialog(null, "Realmente deseja sair?");
        System.exit(1);
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GerarGraficoPizza;
    private javax.swing.JButton ListarHardware;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
