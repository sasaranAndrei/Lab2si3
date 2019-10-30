package Lab2;

import java.math.BigInteger;
import java.util.Scanner;

public class problemeLab2simple {
    static Scanner in = new Scanner(System.in);

    static void problema6_3 () {
        int a = Integer.MAX_VALUE;
        System.out.println("Before : " + a + " (maxim).");
        a++;
        System.out.println("After : " + a + " .");

        double b = 0.12345678987654321;
        float c = (float) b;
        System.out.println("Double : " + b);
        System.out.println("Floate : " + c);

        double d = 1.00000 / 3;
        double e = 2.00000 / 3;
        double sum = d + e;
        System.out.println("Suma numerelor " + d + " si " + e + " este egala cu " + sum);

    }

    static void problema6_12 () {
        System.out.println("Hello world!");

        System.out.print("Introduceti nr de numere introduse : ");
        int n = in.nextInt();
        Double[] x = new Double[100];
        for (int i = 0; i < n; i++)
            x[i] = in.nextDouble();
        for (int i = 0; i < n; i++)
            System.out.println(x[i]+" ");
    }

    static void problema6_4 (){
        BigInteger sum, pow;// = 0;

        sum = BigInteger.valueOf(0);
        pow = BigInteger.valueOf(1);

        for (int i = 0; i < 64; i++)
        {
            sum = sum.add(pow);
            pow = pow.multiply(BigInteger.valueOf(2));
        }
        System.out.println("Sunt " + sum + " boabe de grau.");

    }
    /*
    public static void main(String args[])
    {
        // define the range
        int max = 10;
        int min = 1;
        int range = max - min + 1;

        // generate random numbers within 1 to 10
        for (int i = 0; i < 10; i++) {
            int rand = (int)(Math.random() * range) + min;

            // Output is different everytime this code is executed
            System.out.println(rand);
        }
    }

     */
    public static void main (String[] args){
        problema6_12();
        System.out.println();
        problema6_3();
        System.out.println();
        problema6_4();
    }
}
