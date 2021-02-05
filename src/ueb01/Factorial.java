package ueb01;

/**
 * created by EESSAMMB on 21.01.2021
 */
public class Factorial {

    public static void main(String[] args) {
        Factorial ausgabe = new Factorial();
        System.out.println(ausgabe.facto(8));
    }
    public int facto(int zahl){
        if(zahl < 2){
            return 1;
        }
        else{
            return zahl*facto(zahl-1);
        }
    }
}
