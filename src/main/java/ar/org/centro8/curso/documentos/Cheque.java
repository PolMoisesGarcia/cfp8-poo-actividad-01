package ar.org.centro8.curso.documentos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Cheque {

    private final double monto;
    private final String bancoEmisor;
    private final String fechaDePago;

    @Override
    public String toString() {
        return "Cheque [monto=" + this.monto
                + ", bancoEmisor=" + this.bancoEmisor
                + ", fechaDePago=" + this.fechaDePago + "]";
    }

}
