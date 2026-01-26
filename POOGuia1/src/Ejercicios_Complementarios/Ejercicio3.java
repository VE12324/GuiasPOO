package Ejercicios_Complementarios;
import javax.swing.*;

public class Ejercicio3 {

    public static final double DENSIDAD = 750;

    public static void main(String[] args) {

        double radio = pedirRadio();
        double altura = pedirAltura();
        double volumen = calcularVolumen(radio, altura);
        double dieselLitros = convertirLitros(volumen);
        double gasolinaKg = convertirGasolina(volumen);


        Resultado(radio, altura, dieselLitros, gasolinaKg);
    }

    public static double pedirRadio() {
        String dato = JOptionPane.showInputDialog("Ingrese el radio del tanque: ");
        return Double.parseDouble(dato);
    }

    public static double pedirAltura() {
        String dato = JOptionPane.showInputDialog("Ingrese la altura del tanque: ");
        return Double.parseDouble(dato);
    }

    public static double calcularVolumen(double radio, double altura) {
        return Math.PI * radio * radio * altura;
    }

    public static double convertirLitros(double volumen) {
        return volumen * 1000;
    }

    public static double convertirGasolina(double volumen) {
        return volumen * DENSIDAD;
    }

    public static void Resultado(double radio, double altura, double dieselLitros, double gasolinaKg) {

        System.out.println("LAS MEDIDAS DEL TANQUE SON:");
        System.out.println("Radio: " + radio + " m");
        System.out.println("Altura: " + altura + " m");

        System.out.println("RESULTADOS:");
        System.out.println("Volumen maximo diesel: " + dieselLitros + " litros");
        System.out.println("Cantidad maxima gasolina: " + gasolinaKg + " kg");
    }
}
