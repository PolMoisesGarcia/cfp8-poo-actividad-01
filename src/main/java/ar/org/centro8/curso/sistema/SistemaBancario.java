package ar.org.centro8.curso.sistema;

import java.util.ArrayList;

import ar.org.centro8.curso.clientes.Cliente;
import ar.org.centro8.curso.cuentas.Cuenta;

public class SistemaBancario {

    private ArrayList<Cuenta> cuentas;
    private ArrayList<Cliente> clientes;

    public SistemaBancario() {
        this.cuentas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente != null) {
            this.clientes.add(cliente);
        }
    }

    public void agregarCuenta(Cuenta cuenta) {
        if (cuenta != null) {
            this.cuentas.add(cuenta);
        }
    }

    public void mostrarClientes() {
        for (Cliente cliente : this.clientes) {
            System.out.println(cliente);
        }
    }

    public void mostrarCuentas() {
        for (Cuenta cuenta : this.cuentas) {
            System.out.println(cuenta);
        }
    }

}
