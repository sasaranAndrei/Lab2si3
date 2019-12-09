package Lab3;

import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;


public class Lab3probleme {
    static Scanner in  = new Scanner(System.in);
    static boolean isPrime (int x)
    {
        if (x < 2) return false;
        if (x%2==0 && x!=2) return false;
        for (int d=3; d*d<=x;d+=2)
            if (x%d==0) return false;
        return true;
    }
    static boolean isSumOf2Primes (int x) {
        for (int i = 2; i <= x / 2; i++)
            if (isPrime(i) && isPrime(x - i))
                return true;
        return false;
    }
    static void problema4_1 (){
        System.out.println("Introduceti capetele intervalului ");
        int m = in.nextInt();
        int n = in.nextInt();

        int max = Math.max(m, n); // setam capetele
        int min = m + n - max; // forului de parcurgere

        min = min + min%2; // daca e par e ok iar daca e impar luam urm element
        max = max - max%2; // la fel si pt max
        // pt a porni si a termina cu un numar par
        for (int i = min; i <= max; i+=2) // parcurgem doar nr pare
        {
            if (isSumOf2Primes(i))
                System.out.println(i + " verifica");
        }
    }
    static double functieGrad2 (int a, int b, int c, double x) {
        double rez = ((double) a*x*x + (double) b*x + (double) c);
        return rez;
    }

    static void problema4_2 () {

        double eps = 1e-2;
        double xn1 = 0, xn = 0;
        double rap = 0, backUp = 0;
        int a, b, c, index;

        do {
            System.out.println("Introduceti coeficientii functiei f");
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            if (0 == a) System.out.println("ECUATIE DE GR 2 , A != 0"); // a != pt ax^2 + bx +c
            if (b * b - 4 * a * c < 0) System.out.println("ECUATIE DE GR2 FARA RADACINI REALE");  // delta > 0
        }
        while (0 == a || (b * b - 4 * a * c) < 0);

        for (eps = 1e-2; eps > 1e-6; eps /= 10) {
            rap = 0;
            backUp = 0;
            index = 0;
            do {
                xn = backUp;
                rap = functieGrad2(a, b, c, xn) / functieGrad2(0, 2 * a, b, xn);
                xn1 = xn - rap;
                backUp = xn1;
                index++;
            }
            while (Math.abs(xn1 - xn) > eps);
            System.out.println("Pentru o precizie de Epsilon = " + eps + ", solutia " + xn1 + " a fost gasita dupa " + index + " iteratii.");
        }
        // f = 1 -9  18
        // f = 1 -1 -6
        // f = 1 -32 128
    }
    static void calculeazaConVoc (String cuvant){
        int vowels = 0, consonants = 0;//, digits = 0, spaces = 0;
        char ch;
        cuvant = cuvant.toLowerCase(); // FACE CA TOT SIRU SA AIBA NUMA LITERE MICI
        for(int i = 0; i < cuvant.length(); ++i)
        {
            ch = cuvant.charAt(i); // TRANSFORMAREA UNUI ELEMENT CARACTER DIN VECTORUL STRING[] IN CHAR
            if(ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                ++vowels;
            }
            else if((ch >= 'a'&& ch <= 'z')) {
                ++consonants;
            }
                /*
                else if( ch >= '0' && ch <= '9')
                {
                    ++digits;
                }
                else if (ch ==' ')
                {
                    ++spaces;
                }

                 */
        }
        System.out.println("Cuvantul este format din " + vowels + " vocale si " + consonants + " consoane.");

    }
    static void determinaIndici (String cuvant, char vocala){
        System.out.println("Indicii pe care apare vocala " + vocala + " in cuvantul " + cuvant + " sunt :");
        for (int i = 0 ; i < cuvant.length(); i++) {
            char ch = cuvant.charAt(i); // TRANSFORMAREA UNUI ELEMENT CARACTER DIN VECTORUL STRING[] IN CHAR
            if (ch == vocala)
                System.out.print(i + " ");
        }
    }
    static void problema4_3 (){
        System.out.println("Introduceti un cuvant si o vocala");
        String cuvant = new String();
        cuvant = in.nextLine();
        char vocala = in.next().charAt(0); // CITIREA UNUI SINGUR CARACTER
        System.out.println("Cuvantul introdus este " + cuvant + ", iar vocala introdusa este " + vocala);
        calculeazaConVoc(cuvant);
        determinaIndici(cuvant, vocala);
    }
    static int combinariNK (int n, int k) {
        if (n < k) return 0;
        if (n == k || k == 0) return 1;
        return combinariNK(n-1,k) + combinariNK(n-1,k-1);
    }
    static void problema4_4 (){
        System.out.println("Sansele de castig la loto sunt : ");
        System.out.println(Math.pow(combinariNK(49,6), -1));
    }
    static boolean eInUrna (int nr, int extrase[]){
        for (int i = 0; i < 6; i++)
            if (extrase[i] == nr)
                return false;
        return true; // daca a fost comparat cu toate numerele extrase si a ajuns aici inseamna ca e in urna

    }
    static void problema4_5 () {
        int[] extrase = new int[]{ -1, -1, -1, -1, -1, -1 };
        int rand;

        System.out.println("In aceasta seara, la extragerea la loto au picat numerele  : ");
        for (int i = 0; i < 6; i++) {
            do {
                rand = (int)(Math.random()*1223) + 1;
                rand %= 49; // ne asiguram ca numerele sunt
                rand = rand + 1; // in intervalul [1..49]
            }
            while (!eInUrna(rand, extrase)); // nu putem extrage acelasi numar de 2 ori dintr o urna
            extrase[i] = rand;
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(extrase[i] + " ");
        }

    }
    public static void main (String[] args){
        //  problema4_1();
        //  problema4_2();
        // problema4_3();
        //   problema4_4();
        problema4_5();
        System.out.println();
    }
}
