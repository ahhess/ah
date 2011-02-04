package qlock2.model;

import lombok.Data;

@Data
public class Buchstabe {

    private String text = "";
    private boolean leuchtet = false;
    private int x;
    private int y;

    public Buchstabe(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return text;
    }

}
