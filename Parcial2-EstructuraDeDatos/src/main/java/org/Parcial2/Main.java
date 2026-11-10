package org.Parcial2;

public class Main {
    public static void main(String[] args) {
        Pila<Operacion> h = new Pila<>();
        h.push(new Operacion("O1", Operacion.Estado.ANULADA));
        h.push(new Operacion("O2", Operacion.Estado.CONFIRMADA));
        h.push(new Operacion("O3", Operacion.Estado.CONFIRMADA));
        h.push(new Operacion("O4", Operacion.Estado.ANULADA));
        h.push(new Operacion("O5", Operacion.Estado.CONFIRMADA));
        System.out.println("E1 n=2: " + Ejercicios.obtenerUltimasConfirmadas(h, 2));
        System.out.println("E1 n=10: " + Ejercicios.obtenerUltimasConfirmadas(h, 10));
        System.out.println("E1 n=0: " + Ejercicios.obtenerUltimasConfirmadas(h, 0));
        System.out.println("E1 original: " + h);

        Pila<String> p = new Pila<>();
        for (int i = 1; i <= 6; i++) p.push("A" + i);
        System.out.println("E2 (2,4): " + Ejercicios.obtenerSegmento(p, 2, 4));
        System.out.println("E2 (3,3): " + Ejercicios.obtenerSegmento(p, 3, 3));
        System.out.println("E2 (1,6): " + Ejercicios.obtenerSegmento(p, 1, 6));
        System.out.println("E2 (5,7): " + Ejercicios.obtenerSegmento(p, 5, 7));
        System.out.println("E2 (0,2): " + Ejercicios.obtenerSegmento(p, 0, 2));
        System.out.println("E2 (4,2): " + Ejercicios.obtenerSegmento(p, 4, 2));
        System.out.println("E2 original: " + p);

        Cola<Solicitud> c = new Cola<>();
        c.encolar(new Solicitud("S1", Solicitud.Prioridad.NORMAL, 10));
        c.encolar(new Solicitud("S2", Solicitud.Prioridad.ALTA, 30));
        c.encolar(new Solicitud("S3", Solicitud.Prioridad.ALTA, 15));
        c.encolar(new Solicitud("S4", Solicitud.Prioridad.NORMAL, 5));
        System.out.println("E3 sin tiempo: " + Ejercicios.seleccionarSolicitudes(c, 0) + " | pendientes: " + c);
        System.out.println("E3 seleccionadas: " + Ejercicios.seleccionarSolicitudes(c, 25));
        System.out.println("E3 pendientes: " + c);

        NodoArbol<Integer> raiz = null;
        for (int v : new int[]{50, 30, 70, 20, 40, 60, 80, 55, 65}) raiz = insertar(raiz, v);
        System.out.println("E4a [30,60]: " + Ejercicios.contarEquiposEnRango(raiz, 30, 60) + " (esperado 5: 30,40,50,55,60)");
        System.out.println("E4a [0,100]: " + Ejercicios.contarEquiposEnRango(raiz, 0, 100) + " (esperado 9)");
        System.out.println("E4a [61,64]: " + Ejercicios.contarEquiposEnRango(raiz, 61, 64) + " (esperado 0)");
        System.out.println("E4a [60,30]: " + Ejercicios.contarEquiposEnRango(raiz, 60, 30) + " (esperado 0)");
        System.out.println("E4a vacío: " + Ejercicios.contarEquiposEnRango(null, 1, 5) + " (esperado 0)");
    }

    static NodoArbol<Integer> insertar(NodoArbol<Integer> r, int v) {
        if (r == null) return new NodoArbol<>(v, null);
        if (v < r.getElemento()) r.setHijoIzquierdo(insertar(r.getHijoIzquierdo(), v));
        else r.setHijoDerecho(insertar(r.getHijoDerecho(), v));
        return r;
    }
}
