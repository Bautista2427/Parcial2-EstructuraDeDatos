package org.Parcial2;

public class Cola<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamano;

    public void encolar(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (estaVacia()) primero = nuevo; else ultimo.setSiguiente(nuevo);
        ultimo = nuevo;
        tamano++;
    }

    public T desencolar() {
        if (estaVacia()) throw new RuntimeException("Cola vacía");
        T dato = primero.getDato();
        primero = primero.getSiguiente();
        if (primero == null) ultimo = null;
        tamano--;
        return dato;
    }

    public T verPrimero() {
        if (estaVacia()) throw new RuntimeException("Cola vacía");
        return primero.getDato();
    }

    public boolean estaVacia() { return primero == null; }
    public int tamano() { return tamano; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Nodo<T> n = primero; n != null; n = n.getSiguiente()) {
            sb.append(n.getDato());
            if (n.getSiguiente() != null) sb.append(" -> ");
        }
        return sb.length() == 0 ? "(vacía)" : sb.toString();
    }
}