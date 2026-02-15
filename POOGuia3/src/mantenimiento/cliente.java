package mantenimiento;
import java.util.*;
import javax.swing.*;
import java.util.Scanner;

public class cliente {

    private String nombre;
    private String dui;

    public cliente(String nombre, String dui) {
        this.nombre = nombre;
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDui() {
        return dui;
    }

    @Override
    public String toString() {
        return nombre + " (dui: " + dui + ")";
    }
}
