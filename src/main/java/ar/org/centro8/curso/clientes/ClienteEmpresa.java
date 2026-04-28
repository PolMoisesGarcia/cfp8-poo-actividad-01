package ar.org.centro8.curso.clientes;

import lombok.Getter;

@Getter
public class ClienteEmpresa extends Cliente {

    private String nombreFantasia;
    private String cuit;


    public ClienteEmpresa(int nroCliente, String nombreFantasia, String cuit) {
        super(nroCliente);
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }


    @Override
    public String obtenerNombreCliente() {
        return this.nombreFantasia;
    }


    @Override
    public String toString() {
        return "ClienteEmpresa [nroCliente=" + getNroCliente()
                + ", nombreFantasia=" + obtenerNombreCliente()
                + ", cuit=" + this.cuit + "]";
    }
}
