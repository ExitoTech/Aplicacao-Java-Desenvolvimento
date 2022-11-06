/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.exitotech.jar.gui;

import com.mycompany.exitotech.jar.database.SelectFromDatabase;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author Vini
 */
public class HomeFuncionario extends javax.swing.JFrame {

    Integer miliesegundos = 0;
    Integer segundos = 0;
    Integer minutos = 0;
    Integer hora = 0;
    Boolean estado = true;

    public HomeFuncionario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        panel2 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnPausa = new javax.swing.JButton();
        btnFim = new javax.swing.JButton();

        panel1.setBackground(new java.awt.Color(190, 190, 190));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );

        panel2.setBackground(new java.awt.Color(190, 190, 190));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );

        jLabel3.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 252, 253));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img-logo-jar.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(190, 190, 190));

        lb1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb1.setText("00: 00: 00");

        lb2.setBackground(new java.awt.Color(190, 190, 190));
        lb2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lb2.setForeground(new java.awt.Color(245, 245, 245));
        lb2.setText("0000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(lb1)
                .addGap(18, 18, 18)
                .addComponent(lb2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb1)
                    .addComponent(lb2))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        btnInicio.setBackground(new java.awt.Color(0, 6, 51));
        btnInicio.setForeground(new java.awt.Color(245, 245, 245));
        btnInicio.setText("Inicio Jornada");
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
        });
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnPausa.setBackground(new java.awt.Color(0, 6, 51));
        btnPausa.setForeground(new java.awt.Color(245, 245, 245));
        btnPausa.setText("Pausa");
        btnPausa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPausaMouseClicked(evt);
            }
        });

        btnFim.setBackground(new java.awt.Color(0, 6, 51));
        btnFim.setForeground(new java.awt.Color(245, 245, 245));
        btnFim.setText("Fim Jornada");
        btnFim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFimMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPausa, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFim, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPausa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFim, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        
        String idMaquina = JOptionPane.showInputDialog(null, "Confirme o id da máquina novamente!");   
        
        SelectFromDatabase ativarExpediente = new SelectFromDatabase();

        ativarExpediente.validarMaquina(idMaquina, "ativado");
               
        
        estado = true;
        
        Thread thread = new Thread() {
            public void run() {
             for(;;){
                 if (estado == true) {
                     try {
                         sleep(1);
                         if (miliesegundos>=1000) {
                             miliesegundos = 0;
                             segundos++;
                         }
                         if (segundos>=60) {
                             miliesegundos = 0;
                             segundos = 0;
                             minutos++;
                         }
                         if (minutos>=60) {
                             miliesegundos = 0;
                             segundos = 0;
                             minutos = 0;
                             hora++;
                         }
                         lb1.setText(hora + " : " + minutos + " : " + segundos);
                         lb2.setText(""+miliesegundos);
                         miliesegundos ++;  
                     } catch (Exception e) {
                         
                     }
                 }
                 else{
                     break;
                 }
             }
            }
        };
        
        thread.start();
    }//GEN-LAST:event_btnInicioMouseClicked

    private void btnFimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFimMouseClicked
        Integer resposta = 0;
        resposta = JOptionPane.showConfirmDialog(null, "Deseja terminar seu expediente?");
        if (resposta == JOptionPane.YES_OPTION) {
            String idMaquina = JOptionPane.showInputDialog(null, "Digite o id da máquina para finalizar");

            SelectFromDatabase validarMaquina = new SelectFromDatabase();

            validarMaquina.validarMaquina(idMaquina, "desativada");

            estado = false;
            
            JOptionPane.showMessageDialog(null, "Deslogando..");
            System.exit(0);
        }
        else if(resposta == JOptionPane.NO_OPTION){
            estado = true;
        }
        else if(resposta == JOptionPane.CANCEL_OPTION){
            estado = true;
        }
    }//GEN-LAST:event_btnFimMouseClicked

    private void btnPausaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPausaMouseClicked
        // TODO add your handling code here:
        String idMaquina = JOptionPane.showInputDialog(null, "Digite o id da máquina para entrar em horário de almoço..");
        
        SelectFromDatabase validarMaquina = new SelectFromDatabase();
        
        validarMaquina.validarMaquina(idMaquina, "pausar");
        estado = false;
    }//GEN-LAST:event_btnPausaMouseClicked

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioActionPerformed

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
            java.util.logging.Logger.getLogger(HomeFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFim;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPausa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables
}
