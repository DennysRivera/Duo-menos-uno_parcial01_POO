package com.DARP.x00026919;

public final class CalculadoraImpuestos {
    private static double totalRenta, totalISSS, totalAFP;

    private CalculadoraImpuestos(){}

    public static double calcularPago(Empleado emp){
        double pago, restante;
        if (emp instanceof PlazaFija) {
            totalAFP += 0.0625 * emp.salario;
            totalISSS += 0.03 * emp.salario;
            restante = emp.salario - totalAFP - totalISSS;
            if (restante <= 472.00) totalRenta += 0;
            else if (restante > 472.00 && restante <= 895.24) totalRenta += 0.1 * (restante - 472) + 17.67;
            else if (restante > 895.24 && restante <= 2038.10) totalRenta += 0.2 * (restante - 895.24) + 60;
            else totalRenta += 0.3 * (restante - 2038.10) + 288.57;
            pago = restante - totalRenta;
        }
        else{
            totalRenta += 0.1 * emp.salario;
            pago = emp.salario - totalRenta;
        }
        return pago;
    }

    public static String mostrarTotales(){
        return "Total de\nISSS: " + totalISSS + "\tAFP: " + totalAFP + "\nRenta: " + totalRenta;
    }
}
