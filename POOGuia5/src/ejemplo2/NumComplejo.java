package ejemplo2.clases;

import ejemplo2.interfaces.INumero;

public class NumComplejo implements INumero {
    // Campos privados para almacenar la parte real y la parte imaginaria
    private double real;
    private double imaginario;

    // CONSTRUCTORES
    public NumComplejo() {
        this.real = 0.0;
        this.imaginario = 0.0;
    }

    public NumComplejo(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    public NumComplejo(double real) {
        this.real = real;
        this.imaginario = 0.0;
    }

    // ENCAPSULAMIENTO (Getters y Setters)
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginario() {
        return imaginario;
    }

    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }

    // MÉTODO TOSTRING para mostrar el número complejo según las especificaciones
    @Override
    public String toString() {
        // Caso 1: Ambos son cero -> "0.00"
        if (real == 0 && imaginario == 0) {
            return String.format("%.2f", 0.0);
        }

        // Caso 2: Solo imaginario es cero -> mostrar solo parte real
        if (imaginario == 0) {
            return String.format("%.2f", real);
        }

        // Caso 3: Solo real es cero -> mostrar solo parte imaginaria
        if (real == 0) {
            return String.format("%.2fi", imaginario);
        }

        // Caso 4: Ambos son diferentes de cero
        // Determinamos el signo para la parte imaginaria
        if (imaginario > 0) {
            return String.format("%.2f + %.2fi", real, imaginario);
        } else {
            // imaginario es negativo, mostramos con signo menos
            return String.format("%.2f - %.2fi", real, Math.abs(imaginario));
        }
    }

    // MÉTODO LOCAL: Calcula la conjugada del número complejo
    public INumero Conjugada() {
        // La conjugada cambia el signo de la parte imaginaria
        return new NumComplejo(this.real, -this.imaginario);
    }

    // IMPLEMENTACIÓN DE MÉTODOS DE LA INTERFACE INumero

    // Suma de números complejos: (a+bi) + (c+di) = (a+c) + (b+d)i
    @Override
    public INumero Sumarle(INumero valor) {
        if (valor instanceof NumComplejo) {
            NumComplejo otro = (NumComplejo) valor;
            double nuevaReal = this.real + otro.real;
            double nuevaImag = this.imaginario + otro.imaginario;
            return new NumComplejo(nuevaReal, nuevaImag);
        }
        // Si no es un número complejo, retornamos una copia de este mismo
        return new NumComplejo(this.real, this.imaginario);
    }

    // División de números complejos (versión simplificada para principiantes)
    // (a+bi) / (c+di) = [(a+bi)*(c-di)] / (c^2 + d^2)
    @Override
    public INumero Dividir(INumero valor) {
        if (valor instanceof NumComplejo) {
            NumComplejo otro = (NumComplejo) valor;

            // Para evitar división por cero
            if (otro.real == 0 && otro.imaginario == 0) {
                return new NumComplejo(0, 0); // Retornar cero si el divisor es cero
            }

            // Fórmula: (a+bi)/(c+di) = [(a+bi)*(c-di)] / (c^2 + d^2)
            double denominador = (otro.real * otro.real) + (otro.imaginario * otro.imaginario);

            // Multiplicamos numerador por conjugado del denominador
            double nuevaReal = (this.real * otro.real + this.imaginario * otro.imaginario) / denominador;
            double nuevaImag = (this.imaginario * otro.real - this.real * otro.imaginario) / denominador;

            return new NumComplejo(nuevaReal, nuevaImag);
        }
        return new NumComplejo(this.real, this.imaginario);
    }

    // Potencia de números complejos (versión solo para exponente entero positivo)
    // Para un estudiante principiante, implementamos solo casos simples
    @Override
    public INumero ElevarA(int n) {
        if (n == 0) {
            // Cualquier número elevado a 0 es 1
            return new NumComplejo(1, 0);
        }

        if (n == 1) {
            // Elevado a 1 es el mismo número
            return new NumComplejo(this.real, this.imaginario);
        }

        // Para n > 1, usamos multiplicación repetida
        NumComplejo resultado = new NumComplejo(this.real, this.imaginario);

        for (int i = 1; i < n; i++) {
            // Multiplicamos resultado por el número original
            // Fórmula: (a+bi)*(c+di) = (ac - bd) + (ad + bc)i
            double r = resultado.real;
            double img = resultado.imaginario;

            double nuevaReal = (r * this.real) - (img * this.imaginario);
            double nuevaImag = (r * this.imaginario) + (img * this.real);

            resultado.real = nuevaReal;
            resultado.imaginario = nuevaImag;
        }

        return resultado;
    }
}