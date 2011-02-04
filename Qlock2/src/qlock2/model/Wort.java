package qlock2.model;

import java.util.Arrays;
import lombok.Data;

@Data
/**
 *
 * @author Andy
 */
public class Wort {

    private boolean leuchtet = false;
    private Buchstabe[] buchstaben;

    public Wort(Buchstabe[] buchstaben) {
         this.buchstaben=buchstaben;
    }

    @Override
    public String toString() {
        return Arrays.toString(buchstaben);
    }
    
}
