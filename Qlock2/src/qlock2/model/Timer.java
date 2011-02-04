/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package qlock2.model;

/**
 *
 * @author Andy
 */
public class Timer implements Runnable, UhrzeitChangeListenerIF {
    
    private Uhrzeit uhrzeit;

    public void run() {
        while(true){
            try {
                Thread.sleep(1000);

                if(uhrzeit!=null){
                    uhrzeit.addSek(1);
                    System.out.println(uhrzeit);
                }
            } catch (InterruptedException ex) {
                //Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex);
            }
        }
    }

    public void update(Uhrzeit uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

}
