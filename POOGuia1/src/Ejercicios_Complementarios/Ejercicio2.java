package Ejercicios_Complementarios;
import javax.swing.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        double cap1;
        double cap2;
        double cap3;
        String capacitor1;
        String capacitor2;
        String capacitor3;

        capacitor1 = JOptionPane.showInputDialog("Ingrese el capacitor número 1");
        capacitor2 = JOptionPane.showInputDialog("Ingrese el capacitor número 2");
        capacitor3 = JOptionPane.showInputDialog("Ingrese el capacitor número 3");
        cap1 = Double.parseDouble(capacitor1);
        cap2 = Double.parseDouble(capacitor2);
        cap3 = Double.parseDouble(capacitor3);


        if (cap1 <= 0 || cap2 <= 0 || cap3 <= 0) {
            JOptionPane.showMessageDialog(null,
                    "No se permiten valores negativos");
            System.exit(0);
        } else {

            System.out.println("Tus datos ingresados son:");
            System.out.println("");
            System.out.println("Capacitor 1: " + cap1 + "µF");
            System.out.println("Capacitor 1: " + cap1 + "µF");
            System.out.println("Capacitor 2: " + cap2 + "µF");
            System.out.println("Capacitor 3: " + cap3 + "µF");

            double serie = Serie(cap1, cap2, cap3);
            double paralelo = Paralelo(cap1, cap2, cap3);

            System.out.println("RESULTADOS:");
            System.out.println("Capacitor equivalente en serie: " + serie + " µF");
            System.out.println("Capacitor equivalente en paralelo: " + paralelo + " µF");

        }


    }

    public static double Serie(double cap1, double cap2, double cap3) {
        return 1.0 / (1.0 / cap1 + 1.0 / cap2 + 1.0 / cap3);
    }

    public static double Paralelo(double cap1, double cap2, double cap3) {
        return cap1 + cap2 + cap3;
    }
}
