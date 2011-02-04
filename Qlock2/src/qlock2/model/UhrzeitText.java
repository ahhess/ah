/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package qlock2.model;

/**
 *
 * @author Andy
 */
public class UhrzeitText {

    private String sprache;

    private String stunde[];
    private String uhr[];
    private String vorNachMin[];
    private String vor;
    private String nach;
    private String halb;
    private int stdkorr = 0;

    public UhrzeitText(String sprache) {
        this.sprache = sprache;
        if(sprache==null)
            sprache="de";
        if("de".equals(sprache)){
            stunde = "Uhr,eins,zwei,drei,vier,fünf,sechs,sieben,acht,neun,zehn,elf,zwölf,eins".split(",");
            uhr = stunde.clone();
            uhr[1] = "ein";
            stdkorr = 1;
            //         0   1    2    3        4     5   6   7     8       9     10   11
            vorNachMin = "-,fünf,zehn,viertel,zwanzig,fünf,-,fünf,zwanzig,viertel,zehn,fünf".split(",");
            vor = "vor";
            nach = "nach";
            halb = "halb";
        } else if("en".equals(sprache)) {
            stunde = "o'clock,one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,one".split(",");
            uhr = stunde.clone();
            //         0   1    2    3        4     5   6   7     8       9     10   11
            vorNachMin = "-,five,ten,quarter,twenty,five,-,five,twenty,quarter,ten,five".split(",");
            vor = "to";
            nach = "past";
            halb = "half past";
        }
    }

    public String getUhrzeitText(Uhrzeit uhrzeit){
        int m = uhrzeit.getMin() / 5;
        if(m == 0){
            return uhr[uhrzeit.getStd()] + " " + uhr[0];
        }
        if(m<5){
            return vorNachMin[m] + " " + nach + " " + stunde[uhrzeit.getStd()];
        }
        if(m==5){
            return vorNachMin[m] + " " + vor + " " + halb + " " + stunde[uhrzeit.getStd()+stdkorr];
        }
        if(m==6){
            return halb + " " + stunde[uhrzeit.getStd()+stdkorr];
        }
        if(m==7){
            return vorNachMin[m] + " " + nach + " " + halb + " " + stunde[uhrzeit.getStd()+stdkorr];
        }
        return vorNachMin[m] + " " + vor + " " + stunde[uhrzeit.getStd()+stdkorr];
    }

    public static void main(String args[]) {
        String sprachen[] = {"de","en"};
        for(String s : sprachen) {
            UhrzeitText t = new UhrzeitText(s);
            Uhrzeit u = new Uhrzeit(1,0,0);
            for(int i=0;i<150;i++){
                System.out.println(u + " : " + t.getUhrzeitText(u));
                for(int j=0;j<5;j++){
                    u.addSek(60);
                }
            }
        }
    }
}

/*
 * fünf vor halb eins
 * halb eins
 * fünf nach halb eins
 * zwanzig vor eins / zehn nach halb eins
 * viertel vor eins
 * zehn vor eins
 * fünf vor eins
 *
 * EIN uhr
 * fünf nach eins
 * zehn nach eins
 * viertel nach eins
 * zwanzig nach eins / zehn vor halb zwei
 *
 */
