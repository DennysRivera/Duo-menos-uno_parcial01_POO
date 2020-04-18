package com.DARP.x00026919;

import javax.swing.*;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public class Main {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        byte opc;
        do {
            //try {
                opc = Byte.parseByte(JOptionPane.showInputDialog("Menú:\n1. Calcular pago para plaza fija\n2. Calcular pago para servicio profesioanl" +
                        "\n3. Mostrar totales\n4. Salir\nOpción:"));
                switch (opc){
                    case 1:
                        String nombre = JOptionPane.showInputDialog("Nombre del empleado:");
                        String puesto = JOptionPane.showInputDialog("Puesto del empleado:");
                        double salario = Double.parseDouble(JOptionPane.showInputDialog("Salario del empleado:"));
                        int extension = Integer.parseInt(JOptionPane.showInputDialog("Extensión del empleado:"));
                        Empleado plazaF = new PlazaFija(nombre, puesto, salario, extension);
                        CalculadoraImpuestos.calcularPago(plazaF);

                    default: JOptionPane.showMessageDialog(null, "Opción inválida");
                }
            //}
            /*
            catch (DataFormatException e){
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }*/
        } while (opc != 4);
    }
}
