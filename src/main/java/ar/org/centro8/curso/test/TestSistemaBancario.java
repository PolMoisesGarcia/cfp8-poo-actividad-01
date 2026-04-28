package ar.org.centro8.curso.test;

import ar.org.centro8.curso.clientes.ClienteEmpresa;
import ar.org.centro8.curso.clientes.ClienteIndividual;
import ar.org.centro8.curso.cuentas.CajaDeAhorro;
import ar.org.centro8.curso.cuentas.CuentaConvertibilidad;
import ar.org.centro8.curso.cuentas.CuentaCorriente;
import ar.org.centro8.curso.documentos.Cheque;
import ar.org.centro8.curso.sistema.SistemaBancario;

public class TestSistemaBancario {

    public static void main(String[] args) {

        SistemaBancario banco = new SistemaBancario();

        ClienteIndividual cliente1 = new ClienteIndividual(1, "Pol", "García", "12345678");
        ClienteEmpresa cliente2 = new ClienteEmpresa(2, "TechSoft", "30-12345678-9");

        banco.agregarCliente(cliente1);
        banco.agregarCliente(cliente2);

        CajaDeAhorro caja = new CajaDeAhorro("CA001", cliente1, 100000, 0.05);
        CuentaCorriente corriente = new CuentaCorriente("CC001", cliente1, 50000, 20000);
        CuentaConvertibilidad convertibilidad = new CuentaConvertibilidad("CV001", cliente2, 200000, 50000, 1000);

        banco.agregarCuenta(caja);
        banco.agregarCuenta(corriente);
        banco.agregarCuenta(convertibilidad);

        System.out.println("CLIENTES");
        banco.mostrarClientes();

        System.out.println("\nCUENTAS");
        banco.mostrarCuentas();


        System.out.println("\nOPERACIONES CAJA DE AHORRO");
        caja.depositarEfectivo(10000);
        caja.extraerEfectivo(15000);
        caja.cobrarInteres();
        System.out.println(caja);


        System.out.println("\nOPERACIONES CUENTA CORRIENTE");
        Cheque cheque = new Cheque(25000, "Banco Nacion", "29/04/2026");
        corriente.depositarCheque(cheque);
        boolean sePudoExtraerCorriente = corriente.extraerEfectivo(96000);
        if (sePudoExtraerCorriente) {
            System.out.println("Extraccion en cuenta corriente: true");
        } else {
            System.out.println("Extraccion en cuenta corriente: false");
            System.out.println("No se pudo extraer el monto solicitado. Saldo insuficiente, se excedio el limite de descubierto.");
        }
        System.out.println(corriente);


        System.out.println("\nOPERACIONES CUENTA CONVERTIBILIDAD");
        convertibilidad.depositarEfectivo(30000); // tiene 230 mil pesos
        convertibilidad.depositarDolares(500); //                        -> tiene 1500 dólares
        convertibilidad.extraerEfectivo(100000); // queda 130 mil pesos
        convertibilidad.extraerDolares(200); //                          -> queda 1300 dólares
        convertibilidad.convertirPesosADolares(50000, 1000); //          -> 50 dólares + 1300 dólares - 100 dólares
        //  = 1250 dólares
        convertibilidad.convertirDolaresAPesos(100, 1200); // tiene 130 + 120 da 250 mil pesos pero usa 50 mil pesos 
        // para convertir a dólares, le queda 200 mil
        System.out.println(convertibilidad);
    }

}
