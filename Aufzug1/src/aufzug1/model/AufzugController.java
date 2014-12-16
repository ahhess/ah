package aufzug1.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy
 */
public class AufzugController {
    
    private static final Logger LOGGER = Logger.getLogger(AufzugController.class.getName());
    
    private AufzugData data;
    
    public AufzugController(AufzugData data) {
        LOGGER.info("init");
        this.data = data;
    }

    public AufzugData getData() {
        return data;
    }
    
    public void fordereAufzugAnFuerEtage(Etage etage){
        etage.setAngefordert(true);
    }

    public void tuereOeffnen(){
        if(data.isAufzugInEtage()){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
            data.setTuereZu(false);
        }
    }

    public void tuereSchliessen(){
        if(!data.isTuereZu()){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
            data.setTuereZu(true);
        }
    }
    
    public void fahre(){
    	tuereSchliessen();
    }
}
