/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musictecplayer.administradores;

/**
 *
 * @author LU
 */
public class ListaDoblementeEnlazada {

    NodoDoblementeEnlazado cabeza;
    NodoDoblementeEnlazado cola;
    int size;

    public ListaDoblementeEnlazada() {
        size = 0;
        cabeza = new NodoDoblementeEnlazado(null, null, null);
        cola = new NodoDoblementeEnlazado(null, cabeza, null);
        cabeza.siguiente = cola;
        cola.siguiente = cola;
        cabeza.anterior = cabeza;

    }

    public int getSize() {
        return size;
    }

    public boolean estaVacia() {
        return size == 0;

    }

    public void agregarAlInicio(Object datos) {
        NodoDoblementeEnlazado nuevoNodo = new NodoDoblementeEnlazado(datos, cabeza, cabeza.siguiente);
        cabeza.siguiente = nuevoNodo;
        nuevoNodo.siguiente.anterior = nuevoNodo;
        size++;

    }

    public void agregarAlFinal(Object datos) {
        NodoDoblementeEnlazado nuevoNodo = new NodoDoblementeEnlazado(datos, cola.anterior, cola);
        cola.anterior= nuevoNodo;
        nuevoNodo.anterior.siguiente = nuevoNodo;
        size ++;
        
    }

    public Object getPrimero(){
        return cabeza.siguiente.datos;
        
    }
    public Object getUltimo (){
        return cola.anterior.datos;
        
    }
    // 
    
    class NodoDoblementeEnlazado {

        private Object datos;
        NodoDoblementeEnlazado anterior;
        NodoDoblementeEnlazado siguiente;
        boolean removido;

        public NodoDoblementeEnlazado(Object datos, NodoDoblementeEnlazado anterior, NodoDoblementeEnlazado siguiente) {
            this.datos = datos;
            this.anterior = anterior;
            this.siguiente = siguiente;
            this.removido = false;

        }

        /**
         * Imprime la informacion del nodo
         *
         * @return el contenido del nodo
         *
         */
        public String toString() {
            String resultado;
            if (datos == null) {
                resultado = "nulo";

            } else {
                resultado = datos.toString();

            }
            if (siguiente != cola) {
                resultado += (" " + siguiente.toString());
            }
            return resultado;
        }

    }// termina la clase NodoDoblementeEnlazado
}
