package ueb05;

import java.util.Scanner;

public class MinimalCliArray {

    public static void main(String[] args) {
        double[] prices;
        try {
            prices = new double[Integer.parseInt(args[0])];
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Es wurde keine gueltige Array-Laenge uebergeben");
            System.exit(1);

            // just to let intellij know nothing else happens here
            throw new RuntimeException("");
        }

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < prices.length; i++) {
            final String s = input.nextLine();
            if ("x".equalsIgnoreCase(s)) {
                break;
            } else {
                prices[i] = Double.parseDouble(s);
            }
        }
    }
}
