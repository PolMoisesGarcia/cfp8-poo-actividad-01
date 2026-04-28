package ar.org.centro8.curso.clientes;

import lombok.Getter;

@Getter
public abstract class Cliente {

    private int nroCliente;

    public Cliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }

    public abstract String obtenerNombreCliente();

}
