package ueb07;

import java.util.Scanner;

/**
 * created by EESSAMMB on 19.11.2020
 */

/*
class ImplementMethode {

    public static int getArrayLengthFromArgs(String args){
        int size = 0;
        for(int i = 0; i < args.length(); i++){
            char c = args.charAt(i);
            if(c >= '0' && c <= '9'){
                size = Integer.parseInt(args);
            }
            else{
                ImplementMethode.printErrorAndExit();
                return (-1);
            }
        }
        return size;
    }
    public static int getStrings(String[] userInput, int size, Scanner scanner){
        int counter = 0;
        while (counter < size){
            String input = scanner.nextLine();
            if(!exit(input)) {
                userInput[counter] = input;
                counter++;
            }
            else{
                return counter;
            }
        }
        return counter;
    }
    public static boolean exit(String input){
        return input.toUpperCase().equals("X");
    }

    public static String  shiftDigits(String s, int numero) {
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            char zahl = s.charAt(i);
            int number;
            if ((int) zahl > 47 && (int) zahl < 58) {
                if ((int) zahl == 57) {
                    number = 48;
                } else {
                    number = (int) zahl + 1;
                }
                sb.append((char) number);

            } else {
                sb.append(" ");
            }
        }
        return numero + " Ziffern erhöhen: "+ numero + " --> " + sb.toString();

    }


    public static String changeCapitalization(String s, int numero) {

        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < s.length(); j++) {

            int zahl = s.charAt(j);

            if (zahl > 64 && zahl < 91) {
                zahl += 32;
                sb.append((char) zahl);
                count++;
            } else if (zahl > 96 && zahl < 123) {
                zahl -= 32;
                sb.append((char) zahl);
                count++;


            } else {
                sb.append((char) zahl);
            }


        }
        return numero + " Groß-/Kleinschreibung vertauschen: " + s + " --> " + sb.toString() +  " (" + count + " Vertauschungen)";
        //return sb.toString() + " (" + count + " Vertauschungen)";
    }

    public static int power(int base, int exponent) {
        int potenzwert = 1;

        while (exponent > 0) {
            potenzwert *= base;
            exponent--;

        }

        return potenzwert;
    }

    public static int toNumber(String s) {

        int laenge = s.length(), i = 0;

        while (i < laenge && s.charAt(i) == ' ') {
            ++i;
        }
        if (i >= laenge) {
            return 0;
        }
        long res = 0;
        while (i < laenge && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (s.charAt(i++) - '0'); //Horner's Rule
        }

        return (int) res;
    }

    public static boolean hasCapital(String s) {

        boolean res = false;
        int laenge = 0;

        while (laenge < s.length() && !res) {

            res = ((int) (s.charAt(laenge)) > 64 && (int) (s.charAt(laenge)) < 91);

            laenge++;
        }

        return res;
    }

    public static String mirrorString(String s, int numero) {
        StringBuilder rev = new StringBuilder();
        int laenge = s.length();

        for (int i = laenge - 1; i >= 0; i--) {
            rev.append(s.charAt(i));
        }
        //return rev.toString();
        return numero + " Spiegeln: " + s + " --> " + rev.toString();
    }
    public static boolean hasNumbers(String input){
        int counter = 0;
        while(counter < input.length()) {
            char c = input.charAt(counter);
            if ((int) c > 47 && (int) c < 58) {
                return true;
            }
            counter++;
        }
        return false;
    }
    public static boolean hasLower(String input){
        int counter = 0;
        while(counter < input.length()) {
            char c = input.charAt(counter);
            if ((int) c > 96 && (int) c < 123 || (int) c == 32) {
                return true;
            }
            counter++;
        }
        return false;
    }
    public static int cases(String input){
        if(hasNumbers(input)){
            return 1;
        }else if (hasCapital(input)){
            return 2;
        } else if (hasLower(input)){
            return 3;
        }
        return 0;
    }
    public static void printErrorAndExit(){
        System.out.println("Es wurde keine gueltige Array-Laenge uebergeben!");
        System.exit(0);
    }


}
*/

public class Ueb07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (args.length != 0 && !args[0].equals("0")) {
            int size = getArrayLengthFromArgs(args[0]);
            String[] userInput = new String[size];
            getStrings(userInput, size, scanner);
            for (int i = 0; i < userInput.length; i++) {
                if (userInput[i] != null) {
                    int caseCounter = cases(userInput[i]);
                    switch (caseCounter) {
                        case 1:
                            shiftDigits(userInput[i], i + 1);
                            break;
                        case 2:
                            changeCapitalization(userInput[i], i + 1);
                            break;
                        case 3:
                            mirrorString(userInput[i], i + 1);
                            break;
                    }
                }
            }
        } else {
            printErrorAndExit();
        }
    }

    public static void printErrorAndExit() {
        System.out.println("Es wurde keine gueltige Array-Laenge uebergeben!");
        System.exit(0);
    }

    public static int getArrayLengthFromArgs(String args) {
        int size = 0;
        for (int i = 0; i < args.length(); i++) {
            char c = args.charAt(i);
            if (c >= '0' && c <= '9') {
                size = Integer.parseInt(args);
            } else {
                printErrorAndExit();
            }
        }
        return size;
    }

    public static void getStrings(String[] userInput, int size, Scanner scanner){
        int counter = 0;
        while (counter < size){
            String input = scanner.nextLine();
            if(!exit(input)) {
                userInput[counter] = input;
                counter++;
            }
            else{
                return;
            }
        }
    }
    public static boolean exit(String input){
        return input.toUpperCase().equals("X");
    }
    public static void shiftDigits(String input, int number){
        StringBuilder newOne = new StringBuilder();
        int counter = 0;
        while(counter < input.length()) {
            char c = input.charAt(counter);
            if ((int) c > 47 && (int) c < 57) {
                newOne.append((char) (c + 1));
            } else if ((int)c == 57){
                newOne.append(0);
            }
            counter++;
        }
        System.out.println(number + " Ziffern erhöhen: "+ input + " --> " + newOne.toString());
    }
    public static void changeCapitalization(String input, int number){
        StringBuilder newOne = new StringBuilder();
        int counter = 0;
        int changes = 0;
        while(counter < input.length()) {
            char c = input.charAt(counter);
            if ((int) c > 64 && (int) c < 91) {
                newOne.append((char) (c + 32));
                changes++;
            } else if((int) c > 96 && (int) c < 123){
                newOne.append((char) (c - 32));
                changes++;
            } else{
                newOne.append(c);
            }
            counter++;
        }
        System.out.println(number + " Groß-/Kleinschreibung vertauschen: " + input + " --> " + newOne.toString() +  " (" + changes + " Vertauschungen)");
    }
    public static void mirrorString(String input, int number){
        StringBuilder newOne = new StringBuilder();
        int counter = input.length() - 1;
        while(counter >= 0) {
            char c = input.charAt(counter);
            if ((int) c > 96 && (int) c < 123 || (int) c == 32) {
                newOne.append(c);
            }
            counter--;
        }
        System.out.println(number + " Spiegeln:  --> " + newOne.toString());
    }
    public static boolean hasNumbers(String input){
        int counter = 0;
        while(counter < input.length()) {
            char c = input.charAt(counter);
            if (( c >= '0' &&  c <= '9')) {
                return true;
            }
            counter++;
        }
        return false;
    }
    public static boolean hasCapital(String input){
        int counter = 0;
        while(counter < input.length()) {
            char c = input.charAt(counter);

            if ((int) c > 64 && (int) c < 91) {
                return true;
            }
            counter++;
        }
        return false;
    }
    public static boolean hasLower(String input){
        int counter = 0;
        while(counter < input.length()) {
            char c = input.charAt(counter);
            if ((int) c > 96 && (int) c < 123 || (int) c == 32) {
                return true;
            }
            counter++;
        }
        return false;
    }
    public static int cases(String input){
        if(hasNumbers(input)){
            return 1;
        }else if (hasCapital(input)){
            return 2;
        } else if (hasLower(input)){
            return 3;
        }
        return 0;
    }
}



