/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufzug1.ui;

import aufzug1.model.AufzugController;
import aufzug1.model.Etage;
import java.awt.Color;

/**
 *
 * @author Andy
 */
public class EtagenFrame extends javax.swing.JFrame {

    private AufzugController controller;
    private Etage etage;
    
    /**
     * Creates new form EtagenFrame
     */
    public EtagenFrame(AufzugController controller, Etage etage) {
        this.controller=controller;
        this.etage=etage;
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

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setBackground(Color.red);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
