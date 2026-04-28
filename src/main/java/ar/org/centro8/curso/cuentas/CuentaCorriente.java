package ar.org.centro8.curso.cuentas;

import ar.org.centro8.curso.clientes.Cliente;
import ar.org.centro8.curso.documentos.Cheque;
import lombok.Getter;

@Getter
public class CuentaCorriente extends Cuenta {

    private double montoAutorizado;

    public CuentaCorriente(String nroCuenta, Cliente cliente, double saldo, double montoAutorizado) {
        super(nroCuenta, cliente, saldo);
        this.montoAutorizado = montoAutorizado;
    }

    public void depositarCheque(Cheque cheque) {
        if (cheque != null) {
            depositarEfectivo(cheque.getMonto());
        }
    }

    @Override
    public boolean extraerEfectivo(double monto) {
        boolean sePudoExtraer = false;
        double limiteInferior = 0 - this.montoAutorizado;

        if (monto > 0 && (getSaldo() - monto) >= limiteInferior) {
            double nuevoSaldo = getSaldo() - monto;
            setSaldo(nuevoSaldo);
            sePudoExtraer = true;
        }

        return sePudoExtraer;
    }

    @Override
    public String toString() {
        return "CuentaCorriente [nroCuenta=" + getNroCuenta()
                + ", montoAutorizado=" + this.montoAutorizado
                + ", cliente=" + getCliente().obtenerNombreCliente()
                + ", saldo=" + getSaldo() + "]";
    }

}
