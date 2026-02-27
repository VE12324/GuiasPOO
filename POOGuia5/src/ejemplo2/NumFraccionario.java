package ejemplo2.clases;

import ejemplo2.interfaces.INumero;
import ejemplo2.interfaces.IComparable;

public class NumFraccionario implements INumero, IComparable {
    // Campos privados
    private int num;
    private int deno;

    // Encapsulamiento
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDeno() {
        return deno;
    }

    public void setDeno(int deno) {

        if(deno != 0)
            this.deno = deno;
    }


    public NumFraccionario() {
        setNum(0);
        setDeno(1);
    }

    public NumFraccionario(int num, int deno) {
        setDeno(1);
        setNum(num);
        setDeno(deno);
    }

    public NumFraccionario(int entero) {

        setNum(entero);
        setDeno(1);
    }

    // METODO TOSTRING MODIFICADO PARA EL EJERCICIO 1

    @Override
    public String toString() {

        if(deno == 1)
            return String.valueOf(num);


        if(Math.abs(num) < Math.abs(deno))
            return num + "/" + deno;

        boolean esNegativa = (num < 0);
        int numeradorAbs = Math.abs(num);
        int denominadorAbs = Math.abs(deno);


        int parteEntera = numeradorAbs / denominadorAbs;
        int nuevoNumerador = numeradorAbs % denominadorAbs;


        if(nuevoNumerador == 0) {
            if(esNegativa)
                return "-" + parteEntera;
            else
                return String.valueOf(parteEntera);
        }


        int mcd = calcularMCD(nuevoNumerador, denominadorAbs);
        nuevoNumerador = nuevoNumerador / mcd;
        int nuevoDenominador = denominadorAbs / mcd;


        if(esNegativa)
            return "-" + parteEntera + "(" + nuevoNumerador + "/" + nuevoDenominador + ")";
        else
            return parteEntera + "(" + nuevoNumerador + "/" + nuevoDenominador + ")";
    }


    public int calcularMCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    public int calcularMCM(int a, int b) {
        int mcm;
        if (a == 0 || b == 0) {
            return 0; // El MCM con 0 es 0
        }
        mcm = (a * b) / calcularMCD(a, b);
        return mcm;
    }

    public int calcularMCM(NumFraccionario a, NumFraccionario b) {

        return calcularMCM(a.getDeno(), b.getDeno());
    }

    public int calcularMCD(NumFraccionario a, NumFraccionario b) {

        return calcularMCD(a.getDeno(), b.getDeno());
    }


    public NumFraccionario Simplificar() {
        int mcd = calcularMCD(getNum(), getDeno());
        setNum(getNum() / mcd);
        setDeno(getDeno() / mcd);

        return new NumFraccionario(getNum(), getDeno());
    }


    public NumFraccionario Simplificar(int num, int deno) {
        NumFraccionario r = new NumFraccionario();
        int mcd = calcularMCD(num, deno);
        r.setNum(num / mcd);
        r.setDeno(deno / mcd);
        return r;
    }

    private boolean EsNegativa() {

        if(this.getNum() < 0) return true;
        return false;
    }

    public double aDecimal() {

        return (double)this.getNum() / (double)this.getDeno();
    }


    @Override
    public INumero Sumarle(INumero valor) {

        NumFraccionario s = new NumFraccionario();


        if (valor instanceof NumFraccionario) {
            NumFraccionario a, b;
            a = new NumFraccionario(getNum(), getDeno());
            b = (NumFraccionario) valor;


            int mcm = calcularMCM(a.getDeno(), b.getDeno());

            s.setNum(mcm / a.getDeno() * a.getNum() + mcm / b.getDeno() * b.getNum());
            s.setDeno(mcm);


            s = s.Simplificar(s.getNum(), s.getDeno());
        }
        return s;
    }


    @Override
    public INumero Dividir(INumero valor) {
        NumFraccionario resultado = new NumFraccionario();

        if (valor instanceof NumFraccionario) {
            NumFraccionario divisor = (NumFraccionario) valor;


            int nuevoNum = this.getNum() * divisor.getDeno();
            int nuevoDeno = this.getDeno() * divisor.getNum();

            resultado = new NumFraccionario(nuevoNum, nuevoDeno);
            resultado = resultado.Simplificar(resultado.getNum(), resultado.getDeno());
        }
        return resultado;
    }


    @Override
    public INumero ElevarA(int n) {
        NumFraccionario resultado = new NumFraccionario();


        int nuevoNum = (int) Math.pow(this.getNum(), Math.abs(n));
        int nuevoDeno = (int) Math.pow(this.getDeno(), Math.abs(n));

        if (n < 0) {

            int temp = nuevoNum;
            nuevoNum = nuevoDeno;
            nuevoDeno = temp;
        }

        resultado = new NumFraccionario(nuevoNum, nuevoDeno);
        resultado = resultado.Simplificar(resultado.getNum(), resultado.getDeno());
        return resultado;
    }


    @Override
    public boolean EsMayorQue(IComparable valor) {
        if(valor instanceof NumFraccionario){

            NumFraccionario p1, p2;
            p1 = new NumFraccionario(getNum(), getDeno());
            p2 = (NumFraccionario) valor;

            if(!p1.EsNegativa() && !p2.EsNegativa()) { // Si ambas son positivas
                if(p1.aDecimal() > p2.aDecimal()) return true;
            }
            else if(p1.EsNegativa() && p2.EsNegativa()) { // si ambas son negativas

                if(p2.aDecimal() > p1.aDecimal()) return true;
            }
            else {

                if(!this.EsNegativa()) return true;
            }
        }
        return false;
    }
}