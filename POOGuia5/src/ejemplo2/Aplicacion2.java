package ejemplo2.aplicacion;

import ejemplo2.clases.NumFraccionario;
import ejemplo2.clases.NumComplejo;
import ejemplo2.interfaces.INumero;
import java.util.ArrayList;

public class Aplicacion2 {

    // METODO PARA EL EJERCICIO 2
    // Metodo que recibe una colección de fracciones y las suma
    public static void procesarFracciones(ArrayList<NumFraccionario> listaFracciones) {
        System.out.println("\n--- EJERCICIO 2: Procesando colección de fracciones ---");

        // Verificar si la lista está vacía o es nula
        if(listaFracciones == null || listaFracciones.size() == 0) {
            System.out.println("Datos recibidos son incompletos, fin de ejecución del método");
            return;
        }

        // Mostrar todas las fracciones de la lista
        System.out.println("Fracciones recibidas:");
        for(int i = 0; i < listaFracciones.size(); i++) {
            System.out.println("  Fracción " + (i+1) + ": " + listaFracciones.get(i));
        }

        // Calcular la suma de todas las fracciones
        // Empezamos con la primera fracción como base
        NumFraccionario suma = new NumFraccionario(
                listaFracciones.get(0).getNum(),
                listaFracciones.get(0).getDeno()
        );

        // Sumamos las siguientes fracciones
        for(int i = 1; i < listaFracciones.size(); i++) {
            suma = (NumFraccionario) suma.Sumarle(listaFracciones.get(i));
        }

        // Mostrar el resultado
        System.out.println("La suma total es: " + suma);
        System.out.println("En decimal: " + suma.aDecimal());
    }

    public static void main(String[] args) {
        //instancias de clase NumFraccionario
        NumFraccionario f0, f1, f2, f3, f4;
        NumFraccionario r1, r2, r3;
        //para almacenar calculos
        int mcm, mcd;

        System.out.println("OPERACIONES CON FRACCIONES");
        System.out.println("==========================\n");

        //inicializa instancias
        f0 = new NumFraccionario();
        f1 = new NumFraccionario(2, 5); // 2/5
        f2 = new NumFraccionario(3, 8); // 3/8
        f3 = new NumFraccionario(-168, 210); // -168/210
        f4 = new NumFraccionario(3); // 3/1

        System.out.format("Las fracciones para las pruebas seran: %s, %s, %s, %s y %s\n\n",
                f0, f1, f2, f3, f4);

        // Pruebas de MCM y MCD
        System.out.println("--- PRUEBAS DE MCM Y MCD ---");
        mcm = f0.calcularMCM(63, 105);
        mcd = f0.calcularMCD(63, 105);
        System.out.format("El mcm de 63 y 105 es %d, el mcd es %d\n", mcm, mcd);

        mcm = f0.calcularMCM(f1, f2);
        mcd = f0.calcularMCD(f1, f2);
        System.out.format("El mcm de los denominadores de %s y %s es %d, el mcd es %d\n\n",
                f1, f2, mcm, mcd);

        // Pruebas de simplificación
        System.out.println("--- PRUEBAS DE SIMPLIFICACIÓN ---");
        System.out.format("La fraccion equivalente y simplificada de %s ", f3);
        r1 = f3.Simplificar();
        System.out.format("es %s\n", r1);

        System.out.format("La fraccion equivalente y simplificada de 300/270 es %s\n\n",
                f0.Simplificar(300, 270));

        // Prueba de decimal
        System.out.println("--- PRUEBA DE CONVERSIÓN A DECIMAL ---");
        f0 = new NumFraccionario(-23, 125); //fraccion -23/125
        System.out.format("El valor decimal de la fraccion %s es %.4f\n\n",
                f0, f0.aDecimal());

        // EJERCICIO 1: Demostración de fracciones mixtas
        System.out.println("=== EJERCICIO 1: FRACCIONES MIXTAS ===");
        System.out.println("--------------------------------------");

        // Creamos las fracciones del ejemplo
        NumFraccionario mix1 = new NumFraccionario(52, 14);
        NumFraccionario mix2 = new NumFraccionario(-280, 84);
        NumFraccionario mix3 = new NumFraccionario(-525, 140);

        System.out.println("52/14 en formato mixto = " + mix1);
        System.out.println("-280/84 en formato mixto = " + mix2);
        System.out.println("-525/140 en formato mixto = " + mix3);
        System.out.println();

        // EJERCICIO 2: Demostración del metodo procesarFracciones
        System.out.println("=== EJERCICIO 2: PROCESAR COLECCIÓN DE FRACCIONES ===");
        System.out.println("-----------------------------------------------------");

        // Crear una colección (ArrayList) con varias fracciones
        ArrayList<NumFraccionario> lista1 = new ArrayList<>();
        lista1.add(new NumFraccionario(1, 2));  // 1/2
        lista1.add(new NumFraccionario(1, 3));  // 1/3
        lista1.add(new NumFraccionario(1, 4));  // 1/4
        lista1.add(new NumFraccionario(1, 5));  // 1/5
        lista1.add(new NumFraccionario(1, 6));  // 1/6

        // Procesar la colección
        procesarFracciones(lista1);

        // Probar con una lista vacía
        System.out.println("\nProbando con lista vacía:");
        ArrayList<NumFraccionario> listaVacia = new ArrayList<>();
        procesarFracciones(listaVacia);

        // Probar con lista null
        System.out.println("\nProbando con lista null:");
        procesarFracciones(null);

        System.out.println();

        // Demostración de Sumarle (de la práctica anterior)
        System.out.println("=== DEMOSTRACIÓN DE SUMARLE ===");
        System.out.println("-------------------------------");
        r2 = (NumFraccionario) f1.Sumarle(f2);
        System.out.format("La suma de %s con %s es %s\n", f1, f2, r2);

        //suma un entero con la fraccion
        f0 = (NumFraccionario) f1.Sumarle(f4);
        System.out.format("Suma de %s y %s es %s\n\n", f1, f4, f0);

        // Demostración de EsMayorQue
        System.out.println("=== DEMOSTRACIÓN DE ESMAYORQUE ===");
        System.out.println("----------------------------------");
        if(f1.EsMayorQue(f4))
            System.out.format("La fraccion %s es mayor que %s\n", f1, f4);
        else
            System.out.format("La fraccion %s es mayor que %s\n\n", f4, f1);

        // Demostración de Dividir
        System.out.println("=== DEMOSTRACIÓN DE DIVIDIR ===");
        System.out.println("-------------------------------");
        NumFraccionario dividendo = new NumFraccionario(2, 3);
        System.out.println("Dividendo base: " + dividendo);

        NumFraccionario divisor1 = new NumFraccionario(4, 9);
        INumero resultado1 = dividendo.Dividir(divisor1);
        System.out.format("%s / %s = %s\n", dividendo, divisor1, resultado1);

        NumFraccionario divisor2 = new NumFraccionario(-3, 7);
        INumero resultado2 = dividendo.Dividir(divisor2);
        System.out.format("%s / %s = %s\n", dividendo, divisor2, resultado2);

        NumFraccionario divisor3 = new NumFraccionario(-28, 16);
        INumero resultado3 = dividendo.Dividir(divisor3);
        System.out.format("%s / %s = %s\n", dividendo, divisor3, resultado3);

        NumFraccionario divisor4 = new NumFraccionario(16);
        INumero resultado4 = dividendo.Dividir(divisor4);
        System.out.format("%s / %s = %s\n\n", dividendo, divisor4, resultado4);

        // Demostración de ElevarA
        System.out.println("=== DEMOSTRACIÓN DE ELEVARA ===");
        System.out.println("-------------------------------");

        NumFraccionario f5 = new NumFraccionario(1, 3);
        INumero pot1 = f5.ElevarA(2);
        System.out.format("(%s)^2 = %s\n", f5, pot1);

        NumFraccionario f6 = new NumFraccionario(3);
        INumero pot2 = f6.ElevarA(-4);
        System.out.format("(%s)^-4 = %s\n", f6, pot2);

        NumFraccionario f7 = new NumFraccionario(1, 2);
        INumero pot3 = f7.ElevarA(-3);
        System.out.format("(%s)^-3 = %s\n", f7, pot3);

        NumFraccionario f8 = new NumFraccionario(-6, 10);
        INumero pot4 = f8.ElevarA(-3);
        System.out.format("(%s)^-3 = %s\n", f8, pot4);

        NumFraccionario f9 = new NumFraccionario(3, 2);
        INumero pot5 = f9.ElevarA(3);
        System.out.format("(%s)^3 = %s\n", f9, pot5);

        NumFraccionario f10 = new NumFraccionario(12, 16);
        INumero pot6 = f10.ElevarA(3);
        System.out.format("(%s)^3 = %s\n\n", f10, pot6);

        // EJERCICIO 3: Demostración de números complejos
        System.out.println("=== EJERCICIO 3: NÚMEROS COMPLEJOS ===");
        System.out.println("--------------------------------------");

        // Crear algunos números complejos
        NumComplejo c1 = new NumComplejo(5, -3);
        NumComplejo c2 = new NumComplejo(0, 6.27);
        NumComplejo c3 = new NumComplejo(-8.4, 0);
        NumComplejo c4 = new NumComplejo(0, 0);
        NumComplejo c5 = new NumComplejo(-8.4, -2);
        NumComplejo c6 = new NumComplejo(6.1, 4);

        // Mostrar cómo se imprimen según toString
        System.out.println("--- Prueba del método toString ---");
        System.out.println("5 - 3i se muestra como: " + c1);
        System.out.println("0 + 6.27i se muestra como: " + c2);
        System.out.println("-8.4 + 0i se muestra como: " + c3);
        System.out.println("0 + 0i se muestra como: " + c4);
        System.out.println("-8.4 - 2i se muestra como: " + c5);
        System.out.println("6.1 + 4i se muestra como: " + c6);

        // Demostrar el metodo Conjugada
        System.out.println("\n--- Demostración de Conjugada ---");
        System.out.println("El conjugado de " + c1 + " es " + c1.Conjugada());
        System.out.println("El conjugado de " + c5 + " es " + c5.Conjugada());

        // Demostrar suma de complejos
        System.out.println("\n--- Demostración de Suma de Complejos ---");
        NumComplejo sumaComplejos = (NumComplejo) c1.Sumarle(c6);
        System.out.println(c1 + " + " + c6 + " = " + sumaComplejos);

        // Otra suma
        NumComplejo c7 = new NumComplejo(3, 2);
        NumComplejo c8 = new NumComplejo(1, 4);
        NumComplejo suma2 = (NumComplejo) c7.Sumarle(c8);
        System.out.println(c7 + " + " + c8 + " = " + suma2);

        // Demostrar división de complejos
        System.out.println("\n--- Demostración de División de Complejos ---");
        NumComplejo c9 = new NumComplejo(3, 2);
        NumComplejo c10 = new NumComplejo(1, -1);
        NumComplejo division = (NumComplejo) c9.Dividir(c10);
        System.out.println("(" + c9 + ") / (" + c10 + ") = " + division);

        // Demostrar potencia de complejos (solo exponentes positivos)
        System.out.println("\n--- Demostración de Potencia de Complejos ---");
        NumComplejo c11 = new NumComplejo(1, 1);
        NumComplejo potencia = (NumComplejo) c11.ElevarA(3);
        System.out.println("(" + c11 + ")^3 = " + potencia);

        NumComplejo c12 = new NumComplejo(2, 0);
        NumComplejo potencia2 = (NumComplejo) c12.ElevarA(4);
        System.out.println("(" + c12 + ")^4 = " + potencia2);
    }
}