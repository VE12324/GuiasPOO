package EjerciciosComplementarios;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double a, b, c;

        System.out.print("Ingrese a : ");
        a = sc.nextDouble();

        System.out.print("Ingrese b : ");
        b = sc.nextDouble();

        System.out.print("Ingrese c : ");
        c = sc.nextDouble();

        calcularRaices(a, b, c);
        sc.close();
    }

    static double determinante(double a, double b, double c) {

        double d;

        d = (b * b) - (4 * a * c);

        return d;
    }

    static void calcularRaices(double a, double b, double c) {

        double d;

        if (a == 0) {
            System.out.println("No es una ecuacion cuadratica");
            return;
        }

        d = determinante(a, b, c);
        System.out.println("determinante: " + d);

        if (d > 0) {

            double x1, x2;

            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);

            System.out.println("Tiene dos raices reales :");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
        else if (d == 0) {

            double x;
            x = -b / (2 * a);


            System.out.println("Tiene una sola raiz :");

            System.out.println("x = " + x);
        }
        else {

            double real, imaginaria;

            real = -b / (2 * a);
            imaginaria = Math.sqrt(-d) / (2 * a);

            System.out.println("Tiene raices complejas : ");
            System.out.println("x 1 = " + real + " + " + imaginaria + "i");
            System.out.println("x 2 = " + real + " - " + imaginaria + "i");
        }

    }


}
