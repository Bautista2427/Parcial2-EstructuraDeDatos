package org.Parcial2;

public class Operacion {
    public enum Estado { CONFIRMADA, ANULADA }

    private final String codigo;
    private final Estado estado;

    public Operacion(String codigo, Estado estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return codigo + "(" + estado + ")";
    }
}
