package ueb04;

import java.util.Scanner;

public class Ueb04 {

    public static void main(String[] args) {
        ProgrammEnde();
    }

    public static int countSpaces(String satz) {
        int counter = 0;
        for (int i = 0; i < satz.length(); i++) {
            if (satz.charAt(i) == ' ') {
                counter++;
            }
        }
        return counter;
    }
    public static void swapFirstAndLastWord(String text ) {
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
    public static void removeVowels(String s) {
        s = s.toLowerCase();
        System.out.println(s.replace('a', '\000').replace('e', '\000').replace('i', '\000').replace('o', '\000').replace('u', '\000'));
       /* for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'o' || c == 'u' || c == 'e') {
                s = s.replace(c, '\000');
            }
        }
        System.out.println(s);*/
    }
    public static void ProgrammEnde() {
        Scanner scan = new Scanner(System.in);
        char eingabe;
        String satz ="";
        do {
            System.out.println("Bitte ein Menü auswählen: ");
            System.out.println("A) Satz eingeben \n" + "B) Anzahl Leerzeichen bestimmen \n"
                    + "C) 1. und letztes Wort vertauschen \n" + "D) Alle Vokale entfernen \n" + "X) Ende");
            eingabe = scan.nextLine().charAt(0);

            switch(eingabe) {
                case 'A':
                    System.out.println("Bitte einen Text eingeben: ");
                    satz = scan.nextLine();
                    break;
                case 'B':
                    System.out.println(countSpaces(satz));
                    break;
                case 'C':
                    swapFirstAndLastWord(satz);
                    break;
                case 'D':
                    removeVowels(satz);
                    break;
                case 'X':
                    System.out.println("Tschüs!");
                    break;
            }

        } while (eingabe != 'X');
    }
}
