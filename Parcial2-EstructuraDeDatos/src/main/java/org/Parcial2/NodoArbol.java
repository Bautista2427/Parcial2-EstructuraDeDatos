package org.Parcial2;

public class NodoArbol<T> {
    private T elemento;
    private NodoArbol<T> padre;
    private NodoArbol<T> hijoIzquierdo;
    private NodoArbol<T> hijoDerecho;

    public NodoArbol(T elemento, NodoArbol<T> padre) {
        this.elemento = elemento;
        this.padre = padre;
    }

    public T getElemento() { return elemento; }
    public NodoArbol<T> getPadre() { return padre; }
    public NodoArbol<T> getHijoIzquierdo() { return hijoIzquierdo; }
    public NodoArbol<T> getHijoDerecho() { return hijoDerecho; }

    public void setElemento(T elemento) { this.elemento = elemento; }
    public void setPadre(NodoArbol<T> padre) { this.padre = padre; }
    public void setHijoIzquierdo(NodoArbol<T> hijo) { this.hijoIzquierdo = hijo; }
    public void setHijoDerecho(NodoArbol<T> hijo) { this.hijoDerecho = hijo; }
}
