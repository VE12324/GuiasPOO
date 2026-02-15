package mantenimiento;
import java.util.*;
import javax.swing.*;
import java.util.Scanner;

public class menu {

    static ArrayList<cliente> clientes = new ArrayList<>();
    static ArrayList<CuentaAhorro> cuentas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n=== ////// MANTENIMIENTO DE CUENTAS ///////// ===");
            System.out.println("A) registrar un cliente");
            System.out.println("B) abrir una cuenta de ahorro");
            System.out.println("C) salir");
            System.out.print("seleccione una opcion: ");

            opcion = sc.nextLine().toUpperCase().charAt(0);

            switch (opcion) {
                case 'A':
                    registrarCliente();
                    break;
                case 'B':
                    abrirCuenta();
                    break;
                case 'C':
                    System.out.println("saliendo del sistema...");
                    break;
                default:
                    System.out.println("opcion invalida.");
            }

        } while (opcion != 'C');
    }

    public static void registrarCliente() {

        System.out.print("ingrese nombre del cliente: ");
        String nombre = sc.nextLine();

        System.out.print("ingrese DUI: ");
        String dui = sc.nextLine();

        cliente nuevo = new cliente(nombre, dui);
        clientes.add(nuevo);

        System.out.println("clientes registrados (" + clientes.size() + "):");
        System.out.println("# datos del Cliente");

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }

        System.out.println("-> presione Enter para regresar al menu");
        sc.nextLine();
    }

    public static void abrirCuenta() {

        if (clientes.isEmpty()) {
            System.out.println("no hay clientes registrados.");
            return;
        }

        System.out.println("clientes registrados:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }

        System.out.print("seleccione el numero del cliente: ");
        int numero = Integer.parseInt(sc.nextLine());

        cliente seleccionado = clientes.get(numero - 1);

        System.out.print("ingrese monto inicial: ");
        double monto = Double.parseDouble(sc.nextLine());

        CuentaAhorro nuevaCuenta = new CuentaAhorro(seleccionado, monto);
        cuentas.add(nuevaCuenta);

        System.out.println("* titular de Cuenta: " + seleccionado);
        System.out.println("* saldo actual: $" + nuevaCuenta.getSaldo());
        System.out.println("| fecha | tipo | descripcion | monto | Saldo |");

        for (transaccion t : nuevaCuenta.getTransacciones()) {
            System.out.println(t);
        }

        System.out.println("-> presione Enter para regresar al menu");
        sc.nextLine();
    }
}
