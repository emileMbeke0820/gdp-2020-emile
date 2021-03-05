package ueb05;

import java.io.InputStream;
import java.util.Scanner;

public class CliArray {

    static final class InvalidArraySizeException extends RuntimeException{

    }

    final double[] prices;
    private final Scanner input;

    public CliArray(String[] args, InputStream in) {
        prices = new double[parseArgs(args)];
        input = new Scanner(in);
    }

    public int parseArgs(String[] args) {
        try {
            return Integer.parseInt(args[0]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new InvalidArraySizeException();
        }
    }

    public double[] getPrices() {
        return prices;
    }

    public void readPrices() {
        for (int i = 0; i < prices.length; i++) {
            final String s = input.nextLine();
            if ("x".equalsIgnoreCase(s)) {
                break;
            } else {
                prices[i] = Float.parseFloat(s);
            }
        }
    }

    public static void main(String[] args) {
        try {
            final CliArray cliArray = new CliArray(args, System.in);
            cliArray.readPrices();
        } catch (InvalidArraySizeException e) {
            System.out.println("Es wurde keine gueltige Array-Laenge uebergeben!");
            System.exit(1);
        }
    }
}
