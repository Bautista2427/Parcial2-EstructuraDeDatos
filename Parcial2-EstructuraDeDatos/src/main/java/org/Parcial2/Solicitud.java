package org.Parcial2;

public class Solicitud {
    public enum Prioridad { ALTA, NORMAL }

    private final String codigo;
    private final Prioridad prioridad;
    private final int duracion;

    public Solicitud(String codigo, Prioridad prioridad, int duracion) {
        this.codigo = codigo;
        this.prioridad = prioridad;
        this.duracion = duracion;
    }

    public String getCodigo() { return codigo; }
    public Prioridad getPrioridad() { return prioridad; }
    public int getDuracion() { return duracion; }

    @Override
    public String toString() { return codigo + "(" + prioridad + "," + duracion + "min)"; }
}
