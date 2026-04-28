package ar.org.centro8.curso.cuentas;

import ar.org.centro8.curso.clientes.ClienteEmpresa;
import lombok.Getter;

@Getter
public class CuentaConvertibilidad extends CuentaCorriente {

    private double saldoDolares;

    public CuentaConvertibilidad(String nroCuenta, ClienteEmpresa cliente, double saldo, double montoAutorizado,
            double saldoDolares) {
        super(nroCuenta, cliente, saldo, montoAutorizado);
        this.saldoDolares = saldoDolares;
    }

    public void depositarDolares(double monto) {
        if (monto > 0) {
            this.saldoDolares = this.saldoDolares + monto;
        }
    }

    public boolean extraerDolares(double monto) {
        boolean sePudoExtraer = false;

        if (monto > 0 && monto <= this.saldoDolares) {
            this.saldoDolares = this.saldoDolares - monto;
            sePudoExtraer = true;
        }

        return sePudoExtraer;
    }

    public void convertirPesosADolares(double montoPesos, double tasaConversion) {
        if (montoPesos > 0 && tasaConversion > 0 && montoPesos <= getSaldo()) {
            double dolaresConvertidos = montoPesos / tasaConversion;
            double nuevoSaldoPesos = getSaldo() - montoPesos;

            setSaldo(nuevoSaldoPesos);
            this.saldoDolares = this.saldoDolares + dolaresConvertidos;
        }
    }

    public void convertirDolaresAPesos(double montoDolares, double tasaConversion) {
        if (montoDolares > 0 && tasaConversion > 0 && montoDolares <= this.saldoDolares) {
            double pesosConvertidos = montoDolares * tasaConversion;
            double nuevoSaldoPesos = getSaldo() + pesosConvertidos;

            this.saldoDolares = this.saldoDolares - montoDolares;
            setSaldo(nuevoSaldoPesos);
        }
    }

    @Override
    public String toString() {
        return "CuentaConvertibilidad [nroCuenta=" + getNroCuenta()
                + ", saldoDolares=" + this.saldoDolares
                + ", montoAutorizado=" + getMontoAutorizado()
                + ", cliente=" + getCliente().obtenerNombreCliente()
                + ", saldo=" + getSaldo() + "]";
    }

}
