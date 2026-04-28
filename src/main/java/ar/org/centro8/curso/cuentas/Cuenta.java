package ar.org.centro8.curso.cuentas;

import ar.org.centro8.curso.clientes.Cliente;
import lombok.Getter;

@Getter
public abstract class Cuenta {

    private String nroCuenta;
    private Cliente cliente;
    private double saldo;

    public Cuenta(String nroCuenta, Cliente cliente, double saldo) {
        this.nroCuenta = nroCuenta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositarEfectivo(double monto) {
        if (monto > 0) {
            this.saldo = this.saldo + monto;
        }
    }

    public abstract boolean extraerEfectivo(double monto);

}
