package ejemplo1;

import java.util.Scanner;

public class Aplicacion1 {

    public static void main(String[] args) {

        IPago metodopago = null;

        Scanner sc = new Scanner(System.in);

        float monto;
        int tipopago;
        String resultado;

        System.out.println("Tienda de conveniencia\n");
        System.out.print("Ingrese valor del monto a realizar: $ ");
        monto = sc.nextFloat();

        System.out.println("\nMetodos de Pago:");
        System.out.println("\t1. Tarjeta de credito");
        System.out.println("\t2. Bitcoins");
        System.out.println("\t3. Efectivo");
        System.out.print("Seleccione numero con metodo de pago del monto ingresado: ");
        tipopago = sc.nextInt();

        switch (tipopago) {
            case 1:
                metodopago = new PagoConTarjeta();
                break;
            case 2:
                metodopago = new PagoConBitcoin();
                break;
            case 3:
                metodopago = new PagoConEfectivo();
                break;
        }

        if (metodopago == null) {
            System.out.println("ERROR: No eligio un metodo de pago valido");
        } else {
            resultado = metodopago.ProcesarPago(monto);
            System.out.println(resultado);
        }

        sc.close();
    }
}