/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on 01.02.2011, 22:14:59
 */
package qlock2.ui;

import java.awt.GridLayout;

import qlock2.model.UhrzeitChangeListenerIF;
import qlock2.model.Uhrzeit;

import javax.swing.JLabel;

/**
 *
 * @author Andy
 */
public class MainFrame extends javax.swing.JFrame implements UhrzeitChangeListenerIF {

    /** Creates new form MainFrame */
    public MainFrame() {
        setTitle("AHs QlockTwo");
        initComponents();
        initComponents2();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMain = new javax.swing.JPanel();
        jpUhrzeit = new javax.swing.JPanel();
        jtfStunde = new javax.swing.JTextField();
        jtfMinute = new javax.swing.JTextField();
        jtfSekunde = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jpGrid = new javax.swing.JPanel();
        jpMinuten = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpMain.setLayout(new java.awt.BorderLayout());

        jtfStunde.setEditable(false);
        jtfStunde.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfStunde.setText("0");
        jtfStunde.setPreferredSize(new java.awt.Dimension(20, 20));
        jpUhrzeit.add(jtfStunde);

        jtfMinute.setEditable(false);
        jtfMinute.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfMinute.setText("0");
        jtfMinute.setPreferredSize(new java.awt.Dimension(20, 20));
        jpUhrzeit.add(jtfMinute);

        jtfSekunde.setEditable(false);
        jtfSekunde.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfSekunde.setText("0");
        jtfSekunde.setPreferredSize(new java.awt.Dimension(20, 20));
        jpUhrzeit.add(jtfSekunde);

        jButton1.setText("Pause");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jpUhrzeit.add(jButton1);

        jpMain.add(jpUhrzeit, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jpGridLayout = new javax.swing.GroupLayout(jpGrid);
        jpGrid.setLayout(jpGridLayout);
        jpGridLayout.setHorizontalGroup(
            jpGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
        );
        jpGridLayout.setVerticalGroup(
            jpGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        jpMain.add(jpGrid, java.awt.BorderLayout.CENTER);

        jpMinuten.add(jCheckBox1);
        jpMinuten.add(jCheckBox2);
        jpMinuten.add(jCheckBox3);
        jpMinuten.add(jCheckBox4);

        jpMain.add(jpMinuten, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jpMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (pause) {
            pause = false;
            jButton1.setText("Pause");
            jtfStunde.setEditable(false);
            jtfMinute.setEditable(false);
            jtfSekunde.setEditable(false);
            uhrzeit.setStd(Integer.parseInt(jtfStunde.getText()));
            uhrzeit.setMin(Integer.parseInt(jtfMinute.getText()));
            uhrzeit.setSek(Integer.parseInt(jtfSekunde.getText()));
            uhrzeit.updateListeners();
        } else {
            pause = true;
            jButton1.setText("Start");
            jtfStunde.setEditable(true);
            jtfMinute.setEditable(true);
            jtfSekunde.setEditable(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JPanel jpGrid;
    private javax.swing.JPanel jpMain;
    private javax.swing.JPanel jpMinuten;
    private javax.swing.JPanel jpUhrzeit;
    private javax.swing.JTextField jtfMinute;
    private javax.swing.JTextField jtfSekunde;
    private javax.swing.JTextField jtfStunde;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel jlBuchstabe[][] = new JLabel[10][11];
    private boolean pause = false;
    private Uhrzeit uhrzeit;

    public void update(Uhrzeit u) {
        if (!pause) {
            this.uhrzeit = u;
            jtfStunde.setText(Integer.toString(uhrzeit.getStd()));
            jtfMinute.setText(Integer.toString(uhrzeit.getMin()));
            jtfSekunde.setText(Integer.toString(uhrzeit.getSek()));
        }
    }

    private void initComponents2() {
        jpGrid.setLayout(new GridLayout(10, 11));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                JLabel label = new JLabel("O");
                jlBuchstabe[i][j]=label;
                jpGrid.add(label);
            }
        }
    }
}