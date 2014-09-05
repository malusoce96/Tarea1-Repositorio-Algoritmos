/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musictecplayer.administradores;

import java.util.Iterator;

/** Esta clase es un lista doblemente enlazada la cual permite guardar  las 
 * canciones del reproductor
 *
 * @author LU
 */
public class ListaDoblementeEnlazada {

    NodoDoblementeEnlazado cabeza;
    NodoDoblementeEnlazado cola;
    int size;
    
    /** Contructor de la clase, inicializa los atributos
     * 
     */
    public ListaDoblementeEnlazada() {
        size = 0;
        cabeza = new NodoDoblementeEnlazado(null, null, null);
        cola = new NodoDoblementeEnlazado(null, cabeza, null);
        cabeza.siguiente = cola;
        cola.siguiente = cola;
        cabeza.anterior = cabeza;

    }
    /**Obtiene el tamaño de lista 
     * 
     * @return tamaño de la lista
     */
    public int getSize() {
        return size;
    }
    /**Pregunta si la clase esta vacia
     * 
     * @return si la lista esta vacia, TRUE: esta, False: caso contrario 
     */
    public boolean estaVacia() {
        return size == 0;

    }
    
    /**Este metodo agrega al inicio la lista 
     * 
     * @param datos: atributos de la cancion 
     */
    public void agregarAlInicio(Object datos) {
        NodoDoblementeEnlazado nuevoNodo = new NodoDoblementeEnlazado(datos, cabeza, cabeza.siguiente);
        cabeza.siguiente = nuevoNodo;
        nuevoNodo.siguiente.anterior = nuevoNodo;
        size++;

    }
    /**Este metodo agrega al final la lista 
     * 
     * @param datos: atributos de la canción 
     */
    public void agregarAlFinal(Object datos) {
        NodoDoblementeEnlazado nuevoNodo = new NodoDoblementeEnlazado(datos, cola.anterior, cola);
        cola.anterior = nuevoNodo;
        nuevoNodo.anterior.siguiente = nuevoNodo;
        size++;

    }
    /**Este método obtiene el primero de la lista
     * 
     * @return el primer elemento de la lista 
     */
    public Object getPrimero() {
        return cabeza.siguiente.datosNodo;

    }
    /**Este método obtiene el ultimo de la lista
     * 
     * @return ultimo de la lista
     */
    public Object getUltimo() {
        return cola.anterior.datosNodo;

    }
    /**Este método remueve un elemento de la lista
     * 
     * @param nodoAEliminar : el nodo a eliminar
     */
    public void remover(NodoDoblementeEnlazado nodoAEliminar) {
        if (nodoAEliminar != cabeza && nodoAEliminar != cola && !nodoAEliminar.removido) {
            nodoAEliminar.anterior.siguiente = nodoAEliminar.siguiente;
            nodoAEliminar.siguiente.anterior = nodoAEliminar.anterior;
            nodoAEliminar.removido = true;
            size--;

        }
    }
    /**Este método remueve el primer elemento de la lista 
     * 
     * @return el primer nodo
     */
    public Object removerPrimero() {
        NodoDoblementeEnlazado primero = cabeza.siguiente;
        remover(primero);
        return primero.datosNodo;
    }
    /**Este método remueve el ultimo de la lista
     * 
     * @return ultimo de la lista
     */
    public Object removerUltimo() {
        NodoDoblementeEnlazado ultimo = cola.anterior;
        remover(ultimo);
        return ultimo.datosNodo;
    }
    /**Obtiene el iterador de la lista
     * 
     * @return iterador de la lista
     */
    public Iterator getIteradorLista() {
        return new IteradorListaDoblementeEnlazada();
    }
    /**Este método vacía la lista
     * 
     */
    public void vaciarLista() {
        Iterator elementos = getIteradorLista();
        while (elementos.hasNext()) {
            elementos.next();
            elementos.remove();
        }
    }
    /**muestra si un dato de la canción esta contenida en la lista
     * 
     * @param datos: atributos de la canción
     * @return True si esta contenido o false de lo contrario
     */
    public boolean contiene(Object datos) {
        Iterator elements = getIteradorLista();
        while (elements.hasNext()) {
            if (datos.equals(elements.next())) {
                return true;
            }
        }
        return false;
    }
    /**Este método obtinen el nodo que contiene el nombre de la cancion ingresada 
     * 
     * @param nombre: nombre de la cancion
     * @return retorna el nodo que contiene la cancion si se encuentra, en caso
     * contrario retorna nulo
     */
    public Object getCancion(String nombre) {
        Iterator elements = getIteradorLista();
        while (elements.hasNext()) {
            Object nodoActual = elements.next();
            Cancion cancionActual = (Cancion)(nodoActual);
            if (cancionActual.getNombre().equals(nombre)) {
                return cancionActual;
            }
        }
        return null;
    }
    /**Remueve la primera cancion que se encuentre con el nombre ingresado
     * 
     * @param nombre: nombre de la cancion a remover
     * @return True: si la cancion se encontro y se elimino, false de lo contrario
     */
    public boolean removerPrimeraConcidencia(String nombre) {
        Iterator elements = getIteradorLista();
        while (elements.hasNext()) {
            if (nombre.equals(((Cancion)elements.next()).getNombre())) {
                elements.remove();
                return true;
            }
        }
        return false;
    }
    /**Remueve la primera cancion con todas las caracteristicas dadas
     * 
     * @param datos: atributos de la canción 
     * @return True: si la cancion se encontro y se elimino, false de lo contrario
     */
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
    /**Imprime el contenido de la lista
     * 
     * @return retorna cadena de strings que contiene los elementos de la lista
     */
    public String toString() {
        if (estaVacia()) {
            return "()";
        } else {
            return "(" + cabeza.siguiente + ")";
        }
    }

    // 
    
    /** Esta clase donde se crea el nodo de la lista enlazada
     * 
     */
   
    public class NodoDoblementeEnlazado {

        private Object datosNodo;
        NodoDoblementeEnlazado anterior;
        NodoDoblementeEnlazado siguiente;
        boolean removido;
        
        /**Contructor de la clases
         * 
         * @param datos: atributos de la canción
         * @param anterior: nodo anterior
         * @param siguiente: nodo siguiente
         */
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
    /**Este es el contructor de la lista doblemente enlazada
     * 
     * @param args 
     */
    //public static void main(String args[]) {

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
 //   }

}
