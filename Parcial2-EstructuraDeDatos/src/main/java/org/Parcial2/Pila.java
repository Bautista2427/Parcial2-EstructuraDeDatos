package org.Parcial2;

public class Pila<T> {
    private Nodo<T> tope;
    private int tamano;

    public void push(T elemento) {
        tope = new Nodo<>(elemento, tope);
        tamano++;
    }

    public T pop() {
        if (estaVacia()) throw new RuntimeException("Pila vacía");
        T dato = tope.getDato();
        tope = tope.getSiguiente();
        tamano--;
        return dato;
    }

    public T peek() {
        if (estaVacia()) throw new RuntimeException("Pila vacía");
        return tope.getDato();
    }

    public boolean estaVacia() { return tope == null; }
    public int tamano() { return tamano; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Nodo<T> n = tope; n != null; n = n.getSiguiente()) {
            sb.append(n.getDato());
            if (n.getSiguiente() != null) sb.append(" -> ");
        }
        return sb.length() == 0 ? "(vacía)" : sb.toString();
    }
}
