package mantenimiento;
import java.util.*;
import javax.swing.*;
import java.util.Scanner;

    public class CuentaAhorro {

        private cliente titular;
        private double saldo;
        private ArrayList<transaccion> transacciones;

        public CuentaAhorro(cliente titular, double montoInicial) {
            this.titular = titular;
            this.saldo = montoInicial;
            this.transacciones = new ArrayList<>();

            // registrar apertura
            transaccion t = new transaccion(
                    "Deposito",
                    "Apertura de cuenta",
                    montoInicial,
                    saldo
            );

            transacciones.add(t);
        }

        public cliente getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }

        public ArrayList<transaccion> getTransacciones() {
            return transacciones;
        }
    }


