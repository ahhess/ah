/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufzug1.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy
 */
public class Etage {
    
    private static final Logger LOGGER = Logger.getLogger(Etage.class.getName());
    
    private String label = null;
    private boolean angefordert = false;
            
    public Etage(String label) {
        setLabel(label);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setAngefordert(boolean angefordert) {
        this.angefordert = angefordert;
        LOGGER.log(Level.FINER, "setAngefordert={0}", angefordert);
    }

    public boolean isAngefordert() {
        return angefordert;
    }
    
}
