package mantenimiento;
import java.util.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class transaccion {

    private LocalDateTime fecha;
    private String tipo;
    private String descripcion;
    private double monto;
    private double saldo;

    public transaccion(String tipo, String descripcion, double monto, double saldo) {
        this.fecha = LocalDateTime.now();
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.monto = monto;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return fecha + " | " + tipo + " | " + descripcion +
                " | $" + monto + " | $" + saldo;
    }
}
