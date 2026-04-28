package ar.org.centro8.curso.clientes;

import lombok.Getter;

@Getter
public class ClienteIndividual extends Cliente { 

    private String nombre;
    private String apellido;
    private String dni;
    
    public ClienteIndividual(int nroCliente, String nombre, String apellido, String dni) {
        super(nroCliente);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String obtenerNombreCliente() {
        return this.nombre + " " + this.apellido;
    }

    @Override
    public String toString() {
        return "ClienteIndividual [nroCliente=" + getNroCliente()
                + ", nombre=" + obtenerNombreCliente()
                + ", dni=" + this.dni + "]";
    }

}
