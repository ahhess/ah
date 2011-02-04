package qlock2.model;

import lombok.Getter;

/**
 * Erzeugt die Buchstaben und Worte.
 * @author Andy
 */
@Getter
public class WortFactory {

    private Wort worte[];
    private Buchstabe buchstaben[][] = new Buchstabe[11][10];

    public WortFactory(String sprache) {
        if("de".equals(sprache)){
            worte = new Wort[23];
//                        01234567890
            toBuchstaben("eskistafünf", 0);
            worte[0] = toWort(0, 0, 2);
            worte[1] = toWort(3, 0, 3);
            worte[2] = toWort(7, 0, 4);
            toBuchstaben("zehnbygvorg", 1);
            worte[3] = toWort(0, 1, 4);
            worte[4] = toWort(7, 1, 4);
            toBuchstaben("nachviertel", 2);
            worte[5] = toWort(0, 2, 4);
            worte[6] = toWort(4, 2, 7);
            toBuchstaben("halbvornach", 3);
            worte[7] = toWort(0, 3, 4);
            worte[8] = toWort(4, 3, 3);
            worte[9] = toWort(7, 3, 4);
            toBuchstaben("einsxamzwei", 4);
            worte[10]= toWort(0, 4, 4);
            worte[11]= toWort(7, 4, 4);
            toBuchstaben("dreiaujvier", 5);
            worte[12]= toWort(0, 5, 4);
            worte[13]= toWort(7, 5, 4);
            toBuchstaben("fünftosechs", 6);
            worte[14]= toWort(0, 6, 4);
            worte[15]= toWort(6, 6, 5);
            toBuchstaben("siebenlacht", 7);
            worte[16]= toWort(0, 7, 6);
            worte[17]= toWort(7, 7, 4);
            toBuchstaben("neunzehnelf", 8);
            worte[18]= toWort(0, 8, 4);
            worte[19]= toWort(4, 8, 4);
            worte[20]= toWort(8, 8, 3);
            toBuchstaben("zwölfunkuhr", 9);
            worte[21]= toWort(0, 9, 5);
            worte[22]= toWort(8, 9, 3);
        }
    }

    private void toBuchstaben(String s, int y){
        for(int i=0;i<s.length();i++){
            buchstaben[i][y] = new Buchstabe(s.substring(i,i+1), i, y);
        }
    }

    private Wort toWort(int x, int y, int l){
        Buchstabe[] b = new Buchstabe[l];
        for(int i=x;i<l;i++){
            b[i]=buchstaben[i][y];
        }
        return new Wort(b);
    }
}
//        final String DE =
//            // 01234567890
//              "eskistafünf" // 0
//            + "zehnbygvorg" // 1
//            + "nachviertel" // 2
//            + "halbvornach" // 3
//            + "einsxamzwei" // 4
//            + "dreiaujvier" // 5
//            + "fünftosechs" // 6
//            + "siebenlacht" // 7
//            + "neunzehnelf" // 8
//            + "zwölfunkuhr";// 9
//            int x=0, y=0;
//            for(int i=0;i<DE.length();i++){
//                buchstaben[x][y] = new Buchstabe(DE.substring(i,i), x, y);
//                x++;
//                if(x>=10){
//                    x=0;
//                    y++;
//                }
//            }
