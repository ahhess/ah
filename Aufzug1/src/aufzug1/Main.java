/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufzug1;

import aufzug1.model.AufzugController;
import aufzug1.model.AufzugData;
import aufzug1.ui.EtagenFrame;
import aufzug1.ui.MainFrame;

/**
 *
 * @author Andy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * Set the Nimbus look and feel
         * 
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                
                AufzugData data = new AufzugData(5);                
                AufzugController controller = new AufzugController(data);
                
                MainFrame mainFrame = new MainFrame(controller);
                mainFrame.setVisible(true);
                
//                for (int i = 0; i < data.getAnzahlEtagen(); i++) {
//                    new EtagenFrame(controller, controller.getData().getEtage(i)).setVisible(true);
//                }
                
            }
        });
    }
}
