package ueb05;

import java.util.Locale;
import java.util.Scanner;

/**
 * created by EESSAMMB on 29.10.2020
 */
public class Ueb05 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int eingaben = 0;
        if(args.length == 0 || args[0] == null || args[0].equals("0")){
            System.out.println("Es wurde keine gueltige Array-Laenge uebergeben!");
            System.exit(1);
        }
        int maxlaenge = -1;


        try {
            maxlaenge = Integer.parseInt(args[0]);
        }catch (NumberFormatException e){
            System.out.println("Es wurde keine gueltige Array-Laenge uebergeben!");
            System.exit(1);
        }
        double [] benzinPreis = new double[maxlaenge];
        String eingabe;

        do {
            System.out.println("Bitte BenzinPreis von 1 bis 2 eingeben: ");
            eingabe = scan.nextLine();

            if(eingabe.toLowerCase().equals("x")){
                System.out.println("Das Programm wird beendet.");
            }
            else{
                try{
                   double preis =  Double.parseDouble(eingabe);
                    if(preis >= 1 && preis <= 2 && eingabe.length() <= 4){
                        benzinPreis[eingaben] = preis;
                        eingaben++;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Es wurde ein ungueltiger Preis eingegeben!");
                }
            }
        }while(!(eingabe.equals("x") || eingabe.equals("X")) && eingaben < maxlaenge);

        if(eingaben != 0){

            double kleinsterPreis = kleinsterPreis(benzinPreis);
            double groessterPreis = groesterPreis(benzinPreis);
            double durchschnittPreis = durchschnitt(benzinPreis);
            double spanne = groessterPreis - kleinsterPreis;

            System.out.format(Locale.US,"Anzahl Preise: %2d%n", eingaben);
            System.out.format(Locale.US,"Kleinster Preis: %2.2f%n", kleinsterPreis);
            System.out.format(Locale.US,"Groesster Preis: %2.2f%n", groessterPreis); //Ergebnis print
            System.out.format(Locale.US,"Mittelwert: %2.2f%n", durchschnittPreis);
            System.out.format(Locale.US, "Spanne: %2.2f", spanne);
        }
        else {
            System.out.println("Es wurde kein Preis eingegeben!");
        }


    }

    public static double  kleinsterPreis(double [] preise) {


        double zahl1 = preise[0];

        for (int i = 0; i < preise.length; i++) {
            double temp = 0;
            temp = preise[i];
            if((temp < zahl1) && (temp >= 1) ){
                zahl1 = temp;
            }

        }
        return zahl1;
    }
    public static double  groesterPreis(double [] preise) {


        double zahl1 = preise[0];

        for (int i = 0; i < preise.length; i++) {
            double temp = 0;
            temp = preise[i];
            if(temp > zahl1 ){
                zahl1 = temp;
            }

        }
        return zahl1;
    }
    public static double durchschnitt(double[] preise){

        double gesamt = 0;
        int anzahl = 0;
        for (int i = 0; i < preise.length ; i++) {
            gesamt += preise[i];

            if(preise[i] >= 1){
                anzahl++;
            }
        }
        return gesamt/ anzahl;
    }


}
