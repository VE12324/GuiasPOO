package Ejercicios_Complementarios;
import javax.swing.*;

public class Ejercicio1 {
    public static void main(String[] args) {

        String primernumero;
        String segundonumero;
        int numero1, numero2;
        int suma;
        primernumero = JOptionPane.showInputDialog("Digite el primer numero");
        segundonumero = JOptionPane.showInputDialog("Digite el segundo numero");
        numero1 = Integer.parseInt(primernumero);
        numero2 = Integer.parseInt(segundonumero);

        if (numero1 >= 0 && numero2 >= 0 ){

            suma = numero1 + numero2;
            JOptionPane.showMessageDialog(null, "La suma es:" +  suma,"Resultado",JOptionPane.PLAIN_MESSAGE);
            System.exit(0);

        }else{

                JOptionPane.showMessageDialog(null,"No puedes ingresar numeros negativos");
        System.exit(0);
        }

    }
}
