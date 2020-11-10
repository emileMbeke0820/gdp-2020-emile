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



            double durchschnittPreis = durchschnitt(benzinPreis);
            System.out.format(Locale.US,"Anzahl Preise: %3d%n", maxlaenge);
            RechnePreis(benzinPreis);
            System.out.println();
            System.out.format(Locale.US,"Mittelwert: %9.2f%n", durchschnittPreis);


        }
        else {
            System.out.println("Es wurde kein Preis eingegeben!");
        }


    }

    public static void  RechnePreis(double [] preise) {


        double zahl1 = preise[0];
        double zahl2 = preise[0];

        for (double v : preise) {
            double temp;
            temp = v;
            if (temp > zahl1) {
                zahl1 = temp;
            }
            if(temp < zahl2){
                zahl2 = temp;
            }

        }
        double  kleinsterPreis = zahl2;
        double groessterPreis = zahl1;
        double spanne = groessterPreis - kleinsterPreis;
        System.out.format(Locale.US,"Kleinster Preis: %2.2f%n", kleinsterPreis);
        System.out.format(Locale.US,"Groesster Preis: %2.2f%n", groessterPreis);
        System.out.format(Locale.US,"Spanne: %13.2f", spanne);

    }
    public static double durchschnitt(double[] preise){

        double gesamt = 0;
        int anzahl = 0;
        for (double v : preise) {
            gesamt += v;

            if (v >= 1) {
                anzahl++;
            }
        }
        return gesamt/ anzahl;
    }


}
