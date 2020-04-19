package com.DARP.x00026919;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        byte opc = 0;
        String nombre = "", puesto = "";
        double salario = 0;
        do {
            try {
                opc = Byte.parseByte(JOptionPane.showInputDialog("Menú:\n1. Calcular pago para plaza fija\n2. Calcular pago para servicio profesional" +
                        "\n3. Mostrar totales\n4. Salir\nOpción:"));
                switch (opc) {
                    case 1:
                        int extension = 0;
                        do {
                            try {
                                nombre = JOptionPane.showInputDialog("Nombre del empleado:");
                                puesto = JOptionPane.showInputDialog("Puesto del empleado:");
                                if (nombre.trim().equals("") || puesto.trim().equals("")) throw new BlankSpaceException("Error");
                                do {
                                    salario = Double.parseDouble(JOptionPane.showInputDialog("Salario del empleado:"));
                                    if (salario < 0.01) JOptionPane.showMessageDialog(null, "Cantidad inválida");
                                } while (salario < 0.01);
                                do {
                                    extension = Integer.parseInt(JOptionPane.showInputDialog("Extensión del empleado:"));
                                    if (extension < 1) JOptionPane.showMessageDialog(null, "Extensión inválida");
                                } while (extension < 1);
                                Empleado plazaF = new PlazaFija(nombre, puesto, salario, extension);
                                JOptionPane.showMessageDialog(null, "Sueldo después de descuentos de\n" + nombre +
                                        ", " + puesto + ": $" + CalculadoraImpuestos.calcularPago(plazaF));

                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Campo vacío");
                            } catch (BlankSpaceException ex) {
                                JOptionPane.showMessageDialog(null, "Campos vacíos");
                            } catch (Exception e){
                                JOptionPane.showMessageDialog(null, "Error\nVolviendo al menú");
                                break;
                            }
                        } while (nombre.trim().equals("") || puesto.trim().equals("") || salario == 0 || extension == 0);
                        break;

                    case 2:
                        int meses = 0;
                        do {
                            try {
                                nombre = JOptionPane.showInputDialog("Nombre del empleado:");
                                puesto = JOptionPane.showInputDialog("Puesto del empleado:");
                                if (nombre.trim().equals("") || puesto.trim().equals(""))
                                    throw new BlankSpaceException("Error");
                                do {
                                    salario = Double.parseDouble(JOptionPane.showInputDialog("Salario del empleado:"));
                                    if (salario < 0.01) JOptionPane.showMessageDialog(null, "Cantidad inválida");
                                } while (salario < 0.01);
                                do {
                                    meses = Integer.parseInt(JOptionPane.showInputDialog("Meses que dura el contrato:"));
                                    if (meses < 1 || meses > 12)
                                        JOptionPane.showMessageDialog(null, "Cantidad inválida");
                                } while (meses < 1 || meses > 12);
                                Empleado servicioP = new ServicioProfesional(nombre, puesto, salario, meses);
                                JOptionPane.showMessageDialog(null, "Sueldo después de descuentos de \n" + nombre +
                                        ", " + puesto + ": $" + CalculadoraImpuestos.calcularPago(servicioP));

                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Campo vacío");
                            } catch (BlankSpaceException ex) {
                                JOptionPane.showMessageDialog(null, "Campos vacíos");
                            } catch (Exception e){
                                JOptionPane.showMessageDialog(null, "Error\nVolviendo al menú");
                                break;
                            }
                        } while (nombre.trim().equals("") || puesto.trim().equals("") || salario == 0 || meses == 0);
                        break;

                    case 3: JOptionPane.showMessageDialog(null, CalculadoraImpuestos.mostrarTotales()); break;
                    case 4: break;
                    default: JOptionPane.showMessageDialog(null, "Opción inválida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opc != 4);
    }
}
