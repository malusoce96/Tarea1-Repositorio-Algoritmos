/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musictecplayer.administradores;

import java.util.Iterator;

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
        cola.anterior = nuevoNodo;
        nuevoNodo.anterior.siguiente = nuevoNodo;
        size++;

    }

    public Object getPrimero() {
        return cabeza.siguiente.datosNodo;

    }

    public Object getUltimo() {
        return cola.anterior.datosNodo;

    }

    public void remover(NodoDoblementeEnlazado nodoAEliminar) {
        if (nodoAEliminar != cabeza && nodoAEliminar != cola && !nodoAEliminar.removido) {
            nodoAEliminar.anterior.siguiente = nodoAEliminar.siguiente;
            nodoAEliminar.siguiente.anterior = nodoAEliminar.anterior;
            nodoAEliminar.removido = true;
            size--;

        }
    }

    public Object removerPrimero() {
        NodoDoblementeEnlazado primero = cabeza.siguiente;
        remover(primero);
        return primero.datosNodo;
    }

    public Object removerUltimo() {
        NodoDoblementeEnlazado ultimo = cola.anterior;
        remover(ultimo);
        return ultimo.datosNodo;
    }

    public Iterator getIteradorLista() {
        return new IteradorListaDoblementeEnlazada();
    }

    public void vaciarLista() {
        Iterator elementos = getIteradorLista();
        while (elementos.hasNext()) {
            elementos.next();
            elementos.remove();
        }
    }

    public boolean contiene(Object datos) {
        Iterator elements = getIteradorLista();
        while (elements.hasNext()) {
            if (datos.equals(elements.next())) {
                return true;
            }
        }
        return false;
    }
    
    

    public boolean removerPrimeraConcidencia(Object datos) {
        Iterator elements = getIteradorLista();
        while (elements.hasNext()) {
            if (datos.equals(elements.next())) {
                elements.remove();
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (estaVacia()) {
            return "()";
        } else {
            return "(" + cabeza.siguiente + ")";
        }
    }

    // 
    class NodoDoblementeEnlazado {

        private Object datosNodo;
        NodoDoblementeEnlazado anterior;
        NodoDoblementeEnlazado siguiente;
        boolean removido;

        public NodoDoblementeEnlazado(Object datos, NodoDoblementeEnlazado anterior, NodoDoblementeEnlazado siguiente) {
            this.datosNodo = datos;
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
            if (datosNodo == null) {
                resultado = "nulo";

            } else {
                resultado = datosNodo.toString();

            }
            if (siguiente != cola) {
                resultado += (" " + siguiente.toString());
            }
            return resultado;
        }

    }// termina la clase NodoDoblementeEnlazado

    class IteradorListaDoblementeEnlazada implements Iterator {

        NodoDoblementeEnlazado nodoActual = cabeza;

        /**
         * omite los nodos removidos
         *
         */
        void omitirNodosRemovidos() {  //
            while (nodoActual.siguiente.removido) {
                nodoActual = nodoActual.siguiente;
            }
        }

        @Override
        public void remove() {
            ListaDoblementeEnlazada.this.remover(nodoActual);
        }

        /**
         * Verifica si un nodo no removido tiene siguiente
         *
         * @return
         */
        public boolean hasNext() {
            NodoDoblementeEnlazado nodoTemporal = nodoActual;
            while (nodoTemporal.siguiente.removido) {
                nodoTemporal = nodoTemporal.siguiente;
            }
            return nodoTemporal.siguiente != cola;
        }

        /**
         *
         * @return retorna el siguiente
         */
        public Object next() {
            // omite los nodos removidos
            omitirNodosRemovidos();
            // actualiza el nodo actual
            nodoActual = nodoActual.siguiente;
            if (nodoActual != cola) {
                return nodoActual.datosNodo;
            } else {
                //se  envia un nulo si no cuenta con nodo siguiente
                return null;
            }

        }

    }

    // A test program for the ListOfObjects class...
    public static void main(String args[]) {

//        System.out.println("Probando lista de canciones");
//
//        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
//        System.out.println(lista.toString());
//        Cancion nuevaCancion = new Cancion("lucy", "The Beatles", "terror", "hola", "1987", "");
//        //System.out.println("Cancion insertada: \n" + nuevaCancion.toString());
//
//        lista.agregarAlInicio(nuevaCancion);
//
//        nuevaCancion = new Cancion("dancing", "Benito", "bailable", "hola", "1987", "");
//
//        lista.agregarAlInicio(nuevaCancion);
//
//        nuevaCancion = new Cancion("pachanga", "Benito", "bailable", "hola", "1987", "");
//
//        lista.agregarAlInicio(nuevaCancion);
//
//        System.out.println("La lista actual es: \n");
//        System.out.println(lista.toString());
//        System.out.println("Contiene: " + lista.contiene(nuevaCancion));
//        
//        lista.removerPrimeraConcidencia(nuevaCancion);
//        
//        System.out.println("La lista actual es: \n");
//        System.out.println(lista.toString());
        
//        System.out.println("Testing ListOfObjects...");
//        ListaDoblementeEnlazada list = new ListaDoblementeEnlazada();
//        System.out.println("empty list: " + list);
//        list.agregarAlInicio("b");
//        list.agregarAlFinal("c");
//        list.agregarAlInicio("a");
//        list.agregarAlFinal("d");
//        //
//        System.out.println("abcd? " + list);
//        System.out.println("contains a? " + list.contiene("a"));
//        System.out.println("contains b? " + list.contiene("b"));
//        System.out.println("contains d? " + list.contiene("d"));
//        System.out.println("contains e? " + list.contiene("e"));
//        list.removerPrimeraConcidencia("c");
//        System.out.println("after removing c: " + list);
//        list.removerPrimeraConcidencia("a");
//        System.out.println("after removing a: " + list);
//        list.removerPrimeraConcidencia("f");
//        System.out.println("after removing f: " + list);
//        list.removerPrimeraConcidencia("d");
//        System.out.println("after removing d: " + list);
//        list.removerPrimeraConcidencia("b");
//        System.out.println("after removing b: " + list);
//        list.agregarAlInicio("b");
//        list.agregarAlFinal("c");
//        list.agregarAlInicio("a");
//        list.agregarAlFinal("d");
//        System.out.println("abcd? " + list);
//        list.vaciarLista();
//        System.out.println("after clearing: " + list);
//        list.agregarAlInicio("b");
//        list.agregarAlFinal("c");
//        list.agregarAlInicio("a");
//        list.agregarAlFinal("d");
//        System.out.println("abcd? " + list);
//        Iterator it1, it2, it3;
//        it1 = list.getIteradorLista();
//        it2 = list.getIteradorLista();
//        it3 = list.getIteradorLista();
//        System.out.println("it1 is at " + it1.next());
//        System.out.println("it1 is at " + it1.next());
//        System.out.println("it2 is at " + it2.next());
//        System.out.println("it2 is at " + it2.next());
//        System.out.println("it2 is at " + it2.next());
//        System.out.println("it3 is at " + it3.next());
//        System.out.println("it1 is removing its current item ");
//        it1.remove();
//        System.out.println(list);
//        System.out.println("it2 is removing its current item ");
//        it2.remove();
//        System.out.println(list);
//        System.out.println("it3 is advancing directly to " + it3.next());
//        System.out.println("it1 has next? " + it1.hasNext());
//        System.out.println("it1 is advancing directly to " + it1.next());
//        System.out.println("it1 has next? " + it1.hasNext());
//        System.out.println("it2 is advancing directly to " + it2.next());
    }

}
