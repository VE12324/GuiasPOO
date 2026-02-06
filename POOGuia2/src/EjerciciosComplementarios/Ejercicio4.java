package EjerciciosComplementarios;

import java.util.*;

public class Ejercicio4 {

    static HashMap<String, String> libros = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {

            System.out.println(" === ////BIENVENIDO A BIBLIOTECA VANE//// ===");
            System.out.println("1. agregar libro");
            System.out.println("2. ver libros");
            System.out.println("3. editar libro");
            System.out.println("4. borrar libro");
            System.out.println("5. Salir");
            System.out.print("opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    agregar();
                    break;

                case 2:
                    mostrar();
                    break;

                case 3:
                    actualizar();
                    break;

                case 4:
                    eliminar();
                    break;

                case 5:
                    System.out.println("gracias por venir");
                    break;

                default:
                    System.out.println("opcion incorrecta");
            }

        } while (opcion != 5);

    }

    static void agregar() {

        String isbn = pedirISBN();

        if (isbn == null) return;

        System.out.print("titulo: ");
        String titulo = sc.nextLine();

        libros.put(isbn, titulo);

        System.out.println("Libro guardado");
    }

    static void mostrar() {

        if (libros.isEmpty()) {
            System.out.println("no hay libros");
            return;
        }

        System.out.println("LIBROS:");

        for (String i : libros.keySet()) {

            System.out.println(i + " - " + libros.get(i));
        }
    }

    static void actualizar() {

        String isbn = pedirISBN();

        if (isbn == null) return;

        if (!libros.containsKey(isbn)) {
            System.out.println("no existe");
            return;
        }

        System.out.print("nevo titulo: ");
        String titulo = sc.nextLine();

        libros.put(isbn, titulo);

        System.out.println("actualizado");
    }

    static void eliminar() {

        String isbn = pedirISBN();

        if (isbn == null) return;

        libros.remove(isbn);

        System.out.println("Eliminado");
    }

    static String pedirISBN() {

        String isbn;
        int cont = 0;

        while (cont < 3) {

            System.out.print("ISBN : ");
            isbn = sc.nextLine();

            if (isbn.matches("\\d{3}-\\d{10}")) {
                return isbn;
            }

            cont++;
            System.out.println("esta mal escrito (" + cont + "/3)");
        }
        return null;
    }
}
