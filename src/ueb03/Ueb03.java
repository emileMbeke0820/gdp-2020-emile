package ueb03;

import java.util.Scanner;

public class Ueb03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a min Number :");
        int mintNumber = sc.nextInt();
        System.out.println("Enter a max Number :");
        int maxtNumber = sc.nextInt();
        sc.close();


        for(int i = mintNumber; i<= maxtNumber; i++){
            System.out.format("%3d gerade: %-5b prim : %-5b dreieck : %-5b%n", i,isEven(i),isPrime(i), isTriangular(i));

        }
    }

    public static boolean isEven(int inputNumber) {

        return (inputNumber % 2 == 0);

    }

    public static boolean isPrime(int inputNumber)
    {
        boolean isItPrime = true;
        int i = 2;

        if(inputNumber < 2)
        {
            isItPrime = false;

            return isItPrime;
        }
        else
        {
            //for (int i = 2; i<= inputNumber/2; i++)
            while(i <= inputNumber/2)
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;

                    break;
                }
                i++;
            }

            return isItPrime;
        }
    }
    public static boolean isTriangular(int number) {
        boolean isTriangleNumber = true;
        int counter = 0;

        do {
            counter++;
            int firstStep = 8 * number + 1;
            int secondStep = (int) Math.sqrt(firstStep);



            if (secondStep * secondStep == firstStep) {
                return isTriangleNumber;
            } else {
                isTriangleNumber = false;
                return isTriangleNumber;
            }

        }while(counter <= number);



    }
}

