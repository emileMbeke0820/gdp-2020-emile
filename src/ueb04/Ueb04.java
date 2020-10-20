package ueb04;

import java.util.Scanner;


public class Ueb04 {
    private static int counter = 0;

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {

        System.out.println("A) Satz eingeben \n" +
                "B) Anzahl Leerzeichen bestimmen \n" +
                "C) 1. und letztes Wort vertauschen \n" +
                "D) Alle Vokale entfernen \n" +
                "X) Ende");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte ein Menü auswählen: ");
        char eingabeMenu = scanner.nextLine().charAt(0);


        switch (eingabeMenu) {
            case 'A':
                System.out.println("Bitte einen Satz eingeben:");
               String satz = scanner.next();
               System.out.println(satz);
                break;
            case 'B':
                System.out.println(anzahlLeerzeichen());
                break;
            case 'C':
                vertausche();
                break;
            case 'D':
                System.out.println("Alle Vokale entfernen ");
                break;
            case 'X':
                System.out.println("Ende");
                break;
            default:
                System.out.println("Falsche Eingabe.");
                break;

        }
        scanner.close();
    }

    public static int anzahlLeerzeichen(){

        String satz = "ja va is a prog langu age ";
        for( int i = 0; i < satz.length(); i++){

            if(satz.charAt(i) == ' '){
                counter++;
            }

        }
        return counter;
    }
    public static void vertausche(){

        String satz = "Nachts ist kälter als draußen";





    }
}


