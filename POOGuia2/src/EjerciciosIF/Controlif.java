package EjerciciosIF;

import java.util.*;
import javax.swing.*;

public class Controlif {
    public static void main(String[] args) {
        ejemplo3();
    }
    static void ejemplo1(){
        Scanner reader = new Scanner(System.in);
        int Var1,Var2;
        System.out.print("Ingrese numero1: ");
        Var1=reader.nextInt();
        System.out.print("Ingrese numero2: ");
        Var2=reader.nextInt();
        if(Var1==Var2)
            System.out.print("Los numeros ingresados son iguales ");
        else
            System.out.println("Los numeros ingresados No son iguales ");
    }

    static void ejemplo2(){
        String v1="";
        v1=JOptionPane.showInputDialog("Ingrese un valor");
        if(v1==null)
            JOptionPane.showMessageDialog(null,"Apretaste cancelar");
        else {
            if(v1.equals(""))
                JOptionPane.showMessageDialog(null,
                        "No ingresaste nada");
            else
                JOptionPane.showMessageDialog(null,
                        "El valor de V1 es: "+v1);
        }
        System.exit(0);
    }

    /*static void ejemplo3(){
        int result = JOptionPane.showConfirmDialog(null,
                "Replace existing selection?");
        System.out.println(
                "El numero devuelto por showConfirmDialog es: "+result);
        if (result == JOptionPane.YES_OPTION)
            System.out.println("Yes");
        else if (result == JOptionPane.NO_OPTION)
            System.out.println("No");
        else if (result  == JOptionPane.CANCEL_OPTION)
            System.out.println("Cancel");
        else if (result == JOptionPane.CLOSED_OPTION)
            System.out.println("Closed");
        System.exit(0);
    }*/

    static void ejemplo3(){
        int result = JOptionPane.showConfirmDialog(null,
                "Replace existing selection?");
        System.out.println(
                "El numero devuelto por showConfirmDialog es: "+result);

        switch (result) {

            case JOptionPane.YES_OPTION:
                System.out.println("yes");
                break;

            case JOptionPane.NO_OPTION:
                System.out.println("no");
                break;

            case JOptionPane.CANCEL_OPTION:
                System.out.println("cancel");
                break;

            case JOptionPane.CLOSED_OPTION:
                System.out.println("closed");
                break;
        }
        System.exit(0);
    }


    static void ejemplo4(){


        double sueldo=0;
        sueldo= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario"));

        while(sueldo<0){
            JOptionPane.showMessageDialog(null,
                    "El sueldo debe ser mayor a 0");
            sueldo= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario"));
        }

        String[] options = {"Hombre","Mujer"};
        int genero = JOptionPane.showOptionDialog(
                null,                        // parent component (null = center on screen)
                "Elija su genero", // message
                "Eleccion de genero",            // title
                JOptionPane.DEFAULT_OPTION,  // option type
                JOptionPane.QUESTION_MESSAGE,// message type (icon)
                null,                        // custom icon (null = default)
                options,                     // button labels
                options[0]                   // default selected button
        );
        if (sueldo>300) {
            double AFP = sueldo * 0.0625;
            sueldo -= AFP;
        }

        if (genero==0){
            double ISSS = sueldo*0.03;
            double Renta = sueldo*0.1;
            sueldo -= (ISSS+Renta);
        }

        JOptionPane.showMessageDialog(null,
                "El sueldo total es :" + sueldo);

        System.exit(0);

    }


}
