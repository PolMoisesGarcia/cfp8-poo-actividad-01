package ar.org.centro8.curso.cuentas;

import ar.org.centro8.curso.clientes.Cliente;
import lombok.Getter;

@Getter
public class CajaDeAhorro extends Cuenta {

    private double tasaInteres;

    public CajaDeAhorro(String nroCuenta, Cliente cliente, double saldo, double tasaInteres) {
        super(nroCuenta, cliente, saldo);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public boolean extraerEfectivo(double monto) {
        boolean sePuedeExtraer = false;

        if (monto > 0 && monto <= getSaldo()) {
            double nuevoSaldo = getSaldo() - monto;
            setSaldo(nuevoSaldo);
            sePuedeExtraer = true;
        }

        return sePuedeExtraer;
    }

    public void cobrarInteres() {
        double interes = getSaldo() * this.tasaInteres;
        double saldoMasInteres = getSaldo() + interes;
        setSaldo(saldoMasInteres);
    }

    @Override
    public String toString() {
        return "CajaDeAhorro [nroCuenta=" + getNroCuenta()
                + ", tasaInteres=" + this.tasaInteres
                + ", cliente=" + getCliente().obtenerNombreCliente()
                + ", saldo=" + getSaldo() + "]";
    }

}
