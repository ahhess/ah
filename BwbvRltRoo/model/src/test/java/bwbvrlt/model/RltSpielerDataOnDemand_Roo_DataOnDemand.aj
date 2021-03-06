// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package bwbvrlt.model;

import bwbvrlt.model.RltSpieler;
import bwbvrlt.model.RltSpielerDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect RltSpielerDataOnDemand_Roo_DataOnDemand {
    
    declare @type: RltSpielerDataOnDemand: @Component;
    
    private Random RltSpielerDataOnDemand.rnd = new SecureRandom();
    
    private List<RltSpieler> RltSpielerDataOnDemand.data;
    
    public RltSpieler RltSpielerDataOnDemand.getNewTransientRltSpieler(int index) {
        RltSpieler obj = new RltSpieler();
        setBezirk(obj, index);
        setName(obj, index);
        setPassnr(obj, index);
        setVerein(obj, index);
        return obj;
    }
    
    public void RltSpielerDataOnDemand.setBezirk(RltSpieler obj, int index) {
        String bezirk = "be_" + index;
        if (bezirk.length() > 4) {
            bezirk = bezirk.substring(0, 4);
        }
        obj.setBezirk(bezirk);
    }
    
    public void RltSpielerDataOnDemand.setName(RltSpieler obj, int index) {
        String name = "name_" + index;
        obj.setName(name);
    }
    
    public void RltSpielerDataOnDemand.setPassnr(RltSpieler obj, int index) {
        String passnr = "passnr_" + index;
        obj.setPassnr(passnr);
    }
    
    public void RltSpielerDataOnDemand.setVerein(RltSpieler obj, int index) {
        String verein = "verein_" + index;
        obj.setVerein(verein);
    }
    
    public RltSpieler RltSpielerDataOnDemand.getSpecificRltSpieler(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        RltSpieler obj = data.get(index);
        Long id = obj.getId();
        return RltSpieler.findRltSpieler(id);
    }
    
    public RltSpieler RltSpielerDataOnDemand.getRandomRltSpieler() {
        init();
        RltSpieler obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return RltSpieler.findRltSpieler(id);
    }
    
    public boolean RltSpielerDataOnDemand.modifyRltSpieler(RltSpieler obj) {
        return false;
    }
    
    public void RltSpielerDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = RltSpieler.findRltSpielerEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'RltSpieler' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<RltSpieler>();
        for (int i = 0; i < 10; i++) {
            RltSpieler obj = getNewTransientRltSpieler(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
