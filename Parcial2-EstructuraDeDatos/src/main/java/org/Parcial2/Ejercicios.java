package org.Parcial2;

public class Ejercicios {
    public static Pila<Operacion> obtenerUltimasConfirmadas(Pila<Operacion> historial, int n) {
        Pila<Operacion> resultado = new Pila<>();
        if (n <= 0) return resultado;

        Pila<Operacion> auxiliar = new Pila<>();
        Pila<Operacion> encontradas = new Pila<>();
        int contador = 0;

        while (!historial.estaVacia()) {
            Operacion op = historial.pop();
            auxiliar.push(op);
            if (contador < n && op.getEstado() == Operacion.Estado.CONFIRMADA) {
                encontradas.push(op);
                contador++;
            }
        }

        while (!auxiliar.estaVacia()) {
            historial.push(auxiliar.pop());
        }

        while (!encontradas.estaVacia()) {
            resultado.push(encontradas.pop());
        }
        return resultado;
    }


    public static <T> Pila<T> obtenerSegmento(Pila<T> original, int inicio, int fin) {
        Pila<T> resultado = new Pila<>();
        if (inicio < 1 || inicio > fin) return resultado;

        Pila<T> auxiliar = new Pila<>();
        Pila<T> segmento = new Pila<>();
        int posicion = 0;

        while (posicion < fin && !original.estaVacia()) {
            T elemento = original.pop();
            posicion++;
            auxiliar.push(elemento);
            if (posicion >= inicio) {
                segmento.push(elemento);
            }
        }

        while (!auxiliar.estaVacia()) {
            original.push(auxiliar.pop());
        }

        if (posicion < fin) return resultado;

        while (!segmento.estaVacia()) {
            resultado.push(segmento.pop());
        }
        return resultado;
    }


    public static Cola<Solicitud> seleccionarSolicitudes(Cola<Solicitud> pendientes, int minutosDisponibles) {
        Cola<Solicitud> seleccionadas = new Cola<>();
        if (minutosDisponibles <= 0) return seleccionadas;

        int restante = minutosDisponibles;
        Cola<Solicitud> resto = new Cola<>();

        while (!pendientes.estaVacia()) {
            Solicitud s = pendientes.desencolar();
            if (s.getPrioridad() == Solicitud.Prioridad.ALTA && s.getDuracion() <= restante) {
                seleccionadas.encolar(s);
                restante -= s.getDuracion();
            } else {
                resto.encolar(s);
            }
        }

        while (!resto.estaVacia()) {
            Solicitud s = resto.desencolar();
            if (s.getPrioridad() == Solicitud.Prioridad.NORMAL && s.getDuracion() <= restante) {
                seleccionadas.encolar(s);
                restante -= s.getDuracion();
            } else {
                pendientes.encolar(s);
            }
        }
        return seleccionadas;
    }


    public static int contarEquiposEnRango(NodoArbol<Integer> raiz, int limiteInferior, int limiteSuperior) {
        if (raiz == null || limiteInferior > limiteSuperior) return 0;

        int codigo = raiz.getElemento();

        if (codigo < limiteInferior) {
            return contarEquiposEnRango(raiz.getHijoDerecho(), limiteInferior, limiteSuperior);
        }
        if (codigo > limiteSuperior) {
            return contarEquiposEnRango(raiz.getHijoIzquierdo(), limiteInferior, limiteSuperior);
        }

        return 1
                + contarEquiposEnRango(raiz.getHijoIzquierdo(), limiteInferior, limiteSuperior)
                + contarEquiposEnRango(raiz.getHijoDerecho(), limiteInferior, limiteSuperior);
    }
}
