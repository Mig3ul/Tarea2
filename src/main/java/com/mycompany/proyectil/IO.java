package com.mycompany.proyectil;
import javax.swing.JOptionPane;
public class IO {

    //leer una cadena de texto
    public static String leerTexto(String msg){
        String entrada;
        entrada = JOptionPane.showInputDialog(null, msg);
        return entrada;
    }
    //leer un numero
    public static double leerDouble(String msg){
        double entrada;
        entrada = Double.parseDouble(JOptionPane.showInputDialog(null, msg));
        return entrada;
    }
    //leer un entero
    public static int leerEntero(String msg){
        int entrada;
        entrada = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        return entrada;
    }
    //leer char
    public static char leerChar(String msg){
        char entrada;
        entrada = JOptionPane.showInputDialog(msg).charAt(0);
        return entrada;
    }
    //mostrar un mensaje
    public static void mostrarMensaje(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
}