
/**
 * Clase que tendrá todos los procesos y atributos de las canciones de la 
 * aplicación. Y guardará´por medio de Nodos cada canción.
 */
package musictecplayer.administradores;

/**
 * @author Lucia  Solis
 * @author Joseph Vega
 * @author Miller Ruiz
 */

public class Estructuras { 
    NodoCancion  First; //Puntero al primer nodo de la lista
    NodoCancion  Last; // Puntero al ultimo nodo de la lista
    {
        First = null; //Inicializacion de los punteros
        Last = null; //Inicializacion de los punteros
    }
    /*
    Este es el metodo que verifica si la lista esta vacia
    */
    public boolean empty(){ 
        if (First==null)                   
            return true;
        else
            return false;
    }
    
    
    /*
    Este es el metetodo de insercion , es insercion al final
    */
    public Estructuras InsertEnd(String nombre, String artista, String genero, String album, int año, String portada, String path){
        if (empty()){
            NodoCancion cancion = new NodoCancion(nombre,artista,genero,album,año,portada,path);
            First = cancion;
            Last= cancion;
        }
        else{
            NodoCancion cancion = new NodoCancion(nombre,artista,genero,album,año,portada,path);
            Last.next=cancion;
            cancion.prev=Last;
            Last=cancion;
        }
        return this;
    }

    /**
    *Metodo que busca por artista
    *Para  hacer el algoritmo se necesitan una nueva lista donde se van acumular los resultados de la busqueda
    *un puntero auxiliar para hacer las iteracione y recorrer la lista
    *luego genera un ciclo while donde se va a recorrer la lista e ir buscando cuales de los nodos cumplen con lo buscado
    *si el nodo no contiene lo buscado solo sigue adelante, al final se tendra una lista con los nodos que contengan lo que se busca
    */

    public Estructuras buscarArtista(String search){
        Estructuras listaArtista = new Estructuras ();
        NodoCancion prev = null;
        NodoCancion here = First;
        while (here != Last){
            if (here.artista==search){
                listaArtista.InsertEnd(here.nombre, here.artista, here.genero, here.album, here.año, here.portada, here.path);
                here = here.next;
            }
            else{
                here=here.next;
            }
         
        }
        return listaArtista;
       
       
    }
    
    /**
    *Metodo que busca por album
    *Para  hacer el algoritmo se necesitan una nueva lista donde se van acumular los resultados de la busqueda
    *un puntero auxiliar para hacer las iteracione y recorrer la lista
    *luego genera un ciclo while donde se va a recorrer la lista e ir buscando cuales de los nodos cumplen con lo buscado
    *si el nodo no contiene lo buscado solo sigue adelante, al final se tendra una lista con los nodos que contengan lo que se busca
    */
    
    public Estructuras buscarAlbum(String search){
        Estructuras listaAlbum = new Estructuras ();
        NodoCancion prev = null;
        NodoCancion here = First;
        while (here != Last){
            if (here.album == search){
                listaAlbum.InsertEnd(here.nombre, here.artista, here.genero, here.album, here.año, here.portada, here.path);
                here = here.next;
            }
            else{
                here=here.next;
            }
         
        }
        return listaAlbum;
       
       
    }
    
    /**
    *Metodo que busca por genero
    *Para  hacer el algoritmo se necesitan una nueva lista donde se van acumular los resultados de la busqueda
    *un puntero auxiliar para hacer las iteracione y recorrer la lista
    *luego genera un ciclo while donde se va a recorrer la lista e ir buscando cuales de los nodos cumplen con lo buscado
    *si el nodo no contiene lo buscado solo sigue adelante, al final se tendra una lista con los nodos que contengan lo que se busca
    */
    
    public Estructuras buscarGenero(String search){
        Estructuras listaGenero = new Estructuras ();
        NodoCancion prev = null;
        NodoCancion here = First;
        while (here != Last){
            if (here.genero == search){
                listaGenero.InsertEnd(here.nombre, here.artista, here.genero, here.album, here.año, here.portada, here.path);
                here = here.next;
            }
            else{
                here=here.next;
            }
         
        }
        return listaGenero;
       
       
    }
    
    /**
    *Metodo que busca por nombre
    *Para  hacer el algoritmo se necesitan una nueva lista donde se van acumular los resultados de la busqueda
    *un puntero auxiliar para hacer las iteracione y recorrer la lista
    *luego genera un ciclo while donde se va a recorrer la lista e ir buscando cuales de los nodos cumplen con lo buscado
    *si el nodo no contiene lo buscado solo sigue adelante, al final se tendra una lista con los nodos que contengan lo que se busca
    */
    
    public Estructuras buscarNombre(String search){
        Estructuras listaNombre = new Estructuras ();
        NodoCancion prev = null;
        NodoCancion here = First;
        while (here != Last){
            if (here.nombre == search){
                listaNombre.InsertEnd(here.nombre, here.artista, here.genero, here.album, here.año, here.portada, here.path);
                here = here.next;
            }
            else{
                here=here.next;
            }
         
        }
        return listaNombre;
       
       
    }
   
    /**
    *Metodo delete
    *En este metodo hace una busqueda por nombre que cuando encuentra el nodo con el nombre buscado
    *se ajustan los punteros al siguiente y al anterior para eliminar y asi el recolector de basura destruye el 
    *nodo.
    */
    
    public boolean delete(String name){
        NodoCancion prev = null;
        NodoCancion here = First;
        while(here!=Last){
            if (here.nombre==name){
                if(prev==null){
                    First = here.next;
                    First.prev=null;
                }
                else{
                    prev.next = here.next;
                    NodoCancion temp = here.next;
                    temp.prev=prev;
                }
                return true;
                }
            prev=here;
            here=here.next;
            }
        if (name==Last.nombre){
            Last=here.prev;
            return true;
        }
        return false;
    }
}


class NodoCancion {
    String nombre;
    String artista;
    String genero;
    String album;
    int año;
    String portada;
    String path;
    NodoCancion next;
    NodoCancion prev;
    /*
    metodo constructor .
    */

    public NodoCancion(String nombre, String artista, String genero, String album, int año, String portada, String path) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.album = album;
        this.año = año;
        this.portada = portada;
        this.path = path;
        this.next = null;
        this.prev = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public NodoCancion getNext() {
        return next;
    }

    public void setNext(NodoCancion next) {
        this.next = next;
    }

    public NodoCancion getPrev() {
        return prev;
    }

    public void setPrev(NodoCancion prev) {
        this.prev = prev;
    }
   


}