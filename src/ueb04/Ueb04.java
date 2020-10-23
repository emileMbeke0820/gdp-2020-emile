package ueb04;


import java.util.Scanner;


public class Ueb04 {
    private static int counter = 0;

    public static void main(String[] args) {
        ProgrammEnde();

    }



    public static int anzahlLeerzeichen(String satz) {


        for (int i = 0; i < satz.length(); i++) {

            if (satz.charAt(i) == ' ') {
                counter++;
            }

        }
        return counter;
    }

    public static void vertausche(String text ) {
        /*String satz = "Nachts ist kälter als draußen my friends";
        String[] ch = satz.split(" ");
        String temp = ch[0];
        ch[0] = ch[ch.length - 1];
        ch[ch.length - 1] = temp;
        for (String s : ch) {
            System.out.print(s + " ");
        }*/


        text = text.trim();
        String first = text.substring(0, text.indexOf(" "));
        String last = text.substring(text.lastIndexOf(" "));
        String temp;

        temp = first;
        first = last;
        last = temp;
        String result = first + text.substring(text.indexOf(" "), text.lastIndexOf(" ") + 1) + last;
        System.out.println(result.trim());


    }

    public static void entferneVokal(String s) {

        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == 'a' || c == 'o' || c == 'u' || c == 'e') {
                s = s.replace(c, '\000');


            }
        }
        System.out.println(s);
    }

    public static void ProgrammEnde() {
        Scanner scan = new Scanner(System.in);
        char eingabe;
        do {
            System.out.println("Bitte ein Menü auswählen: ");
            System.out.println("A) Satz eingeben \n" + "B) Anzahl Leerzeichen bestimmen \n"
                    + "C) 1. und letztes Wort vertauschen \n" + "D) Alle Vokale entfernen \n" + "X) Ende");
            eingabe = scan.next().charAt(0);


            switch(eingabe) {
                case 'A':
                    System.out.println("Bitte einen Text eingeben: ");
                    String text;
                    break;
                case 'B':
                    System.out.println("Bitte einen Text eingeben: ");
                     text = scan.next();
                   System.out.println(anzahlLeerzeichen(text));
                    break;
                case 'C':
                    System.out.println("Bitte einen Zahl eingeben: ");
                    text = scan.next();
                    vertausche(text);
                    break;
                case 'D':
                    System.out.println("Bitte einen Zahl eingeben: ");
                    text = scan.next();
                    entferneVokal(text);
                    break;
            }


        } while (eingabe != 'X');

    }

}


