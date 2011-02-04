/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qlock2.model;

import java.util.ArrayList;
import lombok.Data;

@Data
/**
 *
 * @author Andy
 */
public class Uhrzeit {

    private int std = 12, min = 59, sek = 55;
    private ArrayList<UhrzeitChangeListenerIF> listeners = new ArrayList<UhrzeitChangeListenerIF>();

    public Uhrzeit() {
    }

    public Uhrzeit(int std, int min, int sek) {
        this.std = std;
        this.min = min;
        this.sek = sek;
    }

    public void register(UhrzeitChangeListenerIF l) {
        listeners.add(l);
        System.out.println("registered: " + l);
    }

    public void updateListeners() {
        for (UhrzeitChangeListenerIF l : listeners) {
            l.update(this);
        }
    }

    @Override
    public String toString() {
        return "" + std + ":" + min + ":" + sek;
    }

    public void addSek(int i) {
        sek += i;
        if (sek >= 60) {
            sek = 0;
            min++;
            if (min >= 60) {
                min = 0;
                std++;
                if (std >= 13) {
                    std = 1;
                }
            }
        }
        updateListeners();
    }
}
