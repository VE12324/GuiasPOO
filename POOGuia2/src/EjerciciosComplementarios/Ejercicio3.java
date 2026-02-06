package EjerciciosComplementarios;
import java.util.*;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre;
        double monto;

        System.out.println("=== ///BIENVENIDOS A TIENDA VANE//// ===");
        System.out.print("Ingrese su nombre: ");
        nombre = sc.nextLine();

        System.out.print("Ingrese el monto de la compra: ");
        monto = sc.nextDouble();

        aplicarDescuento(nombre, monto);
    }

    static void aplicarDescuento(String nombre, double monto) {

        Random r = new Random();

        int bolita;
        String color = "";
        double descuento = 0;
        double total;

        bolita = r.nextInt(4) + 1;

        if (bolita == 1) {
            color = "Cafe";
            descuento = 0.10;
        }
        else if (bolita == 2) {
            color = "roja";
            descuento = 0.15;
        }
        else if (bolita == 3) {
            color = "azul";
            descuento = 0.25;
        }
        else if (bolita == 4) {
            color = "verde";
            descuento = 0.50;
        }

        total = monto - (monto * descuento);

        System.out.println("cliente: " + nombre);
        System.out.println("monto original: $" + monto);
        System.out.println("bolita: " + color);
        System.out.println("descuento: " + (descuento * 100) + "%");
        System.out.println("Total a pagar: $" + total);
    }


}
