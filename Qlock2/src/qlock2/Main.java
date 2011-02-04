/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package qlock2;

import qlock2.model.Timer;
import qlock2.model.Uhrzeit;
import qlock2.ui.MainFrame;

/**
 *
 * @author Andy
 */
public class Main {

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        final Uhrzeit uhrzeit = new Uhrzeit(12, 59, 55);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                uhrzeit.register(mainFrame);
                mainFrame.setVisible(true);
            }
        });

        Timer timer = new Timer();
        timer.update(uhrzeit);
        uhrzeit.register(timer);
        new Thread(timer).start();
    }

}
