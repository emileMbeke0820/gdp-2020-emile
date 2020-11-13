package ueb06;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * created by EESSAMMB on 06.11.2020
 */
public class Ueb06 {



    public static void main(String[] args) {

        int i;
        String input = "" ;


        Scanner scanner = new Scanner(System.in);
        if(args[0] == null || ("0").equals(args[0]) || args[0].indexOf("0") == 0){
            System.out.println("Es wurde keine gueltige Array-Laenge uebergeben!");
            System.exit(1);
        }
        int laenge = -1;


        try {
            laenge = Integer.parseInt(args[0]);
        }catch (NumberFormatException e){
            System.out.println("Es wurde keine gueltige Array-Laenge uebergeben!");
            System.exit(1);
        }

        // Create an array of laenge references
        PetrolStation [] eingabe = new PetrolStation[laenge];

        System.out.println("Enter " + laenge+ " Tankstellen");
        for ( i = 0; i < eingabe.length; i++) {

            eingabe[i] = new PetrolStation(); //create object



            try {
                System.out.println(" Enter Marke: ");
                String marken = scanner.next();
                eingabe[i].setMarke(marken);

            }
            catch (NullPointerException e){
                System.out.println(e.getMessage());
                scanner.next();
            }

            int pltz = -1;
            do {
                try {
                    System.out.println(" Enter PLZ: ");

                    pltz = scanner.nextInt();
                    eingabe[i].setPlz(pltz);
                }
                catch (InputMismatchException e){
                    System.out.println(e.getMessage());
                    scanner.next();
                }

            }while(pltz < 10000 || pltz > 99999);


            String orte = "";

            do {
                try {
                    System.out.println(" Enter Ort: ");
                    orte = scanner.next();
                    eingabe[i].setOrt(orte);
                }
                catch (NullPointerException e){
                    System.out.println(e.getMessage());
                    scanner.next();
                }
            }while (orte.length() < 5);


            double preis = -1;


            do {
                try {
                    System.out.println(" Enter Price: ");
                    input = scanner.next();
                    preis = Double.parseDouble(input);
                    eingabe[i].setPreis(preis);
                }
                catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                    scanner.next();
                }
            }while (preis < 1 || preis > 2 || input.length() > 4);

        }

        System.out.println("Print all Tankstelen: ");
        for (PetrolStation petrolStation : eingabe) {
            System.out.println(petrolStation.getMarke() + "\n" + petrolStation.getOrt() + "\n" + petrolStation.getPlz() + "\n" + petrolStation.getPreis()  + "\n" );
        }

    }

}
