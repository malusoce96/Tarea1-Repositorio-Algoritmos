
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
    public Estructuras InsertEnd(String nombre, String artista, String genero, String album, int tiempo, String portada, String path){
        if (empty()){
            NodoCancion cancion = new NodoCancion(nombre,artista,genero,album,tiempo,portada,path);
            First = cancion;
            Last= cancion;
        }
        else{
            NodoCancion cancion = new NodoCancion(nombre,artista,genero,album,tiempo,portada,path);
            Last.next=cancion;
            cancion.prev=Last;
            Last=cancion;
        }
        return this;
    }
}
public class NodoCancion {
    String nombre;
    String artista;
    String genero;
    String album;
    int tiempo;
    String portada;
    String path;
    NodoCancion next;
    NodoCancion prev;
    /*
    metodo constructor .
    */

    public NodoCancion(String nombre, String artista, String genero, String album, int tiempo, String portada, String path) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.album = album;
        this.tiempo = tiempo;
        this.portada = portada;
        this.path = path;
        this.next = null;
        this.prev = null;
    }
   

    public void setNomnre(String nombre) {
        this.nombre = nombre;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public void setPath(String path) {
        this.path = path;
    } 
}