package com.DARP.x00026919;

public final class CalculadoraImpuestos {
    private static double totalRenta, totalISSS, totalAFP;

    private CalculadoraImpuestos(){}

    public static double calcularPago(Empleado emp){
        double pago, restante, AFP = 0, ISSS = 0, renta;
        if (emp instanceof PlazaFija) {
            AFP = 0.0625 * emp.getSalario();
            ISSS = 0.03 * emp.getSalario();
            restante = emp.getSalario() - AFP - ISSS;
            if (restante >= 0.01 && restante <= 472.00) renta = 0;
            else if (restante > 472.00 && restante <= 895.24) renta = 0.1 * (restante - 472) + 17.67;
            else if (restante > 895.24 && restante <= 2038.10) renta = 0.2 * (restante - 895.24) + 60;
            else renta = 0.3 * (restante - 2038.10) + 288.57;
            pago = restante - renta;
        }
        else{
           renta = 0.1 * emp.getSalario();
            pago = emp.getSalario() - renta;
        }

        totalAFP += AFP;
        totalISSS += ISSS;
        totalRenta += renta;

        return pago;
    }

    public static String mostrarTotales(){
        return "Total de\nISSS: " + totalISSS + "\nAFP: " + totalAFP + "\nRenta: " + totalRenta;
    }
}
