/**
 * @author Lucia Solis Ceciliano  
 * @author Joseph Vega Vargas
 * @author Miller Ruiz Urbina
 */

package musictecplayer.constantes;

/**
 * Clase que contiene algunos atributos del reproductor de música que van a ser 
 * utilizados durante la ejecución de proyecto.
 */
public class Parametros {
    /**
     * Constantes Globales:
     * Evaluan la acción actual del reproductor de música.
     */
    public final static int DETENIDO = 0;
    public final static int PAUSADO = 1;
    public final static int REPRODUCIENDO = 2;
    
    /**
     * Constantes Globales:
     * Evaluan el tipo de busqueda avanzada actual.
     */
    public final static int ARTISTA = 0;
    public final static int ALBUM = 1;
    public final static int GENERO = 2;
    public final static int CANCION = 3; 
    
    /**
     * Constantes Globales:
     * 
     */
    public final static int MODO_LISTA = 0;
    public final static int MODO_CARATULAS = 1;

    /**
     * Constantes Globales:
     * 
     */
    public final static String BUSQUEDA_POR_ARTISTA = "Artista";
    public final static String BUSQUEDA_POR_ALBUM = "Álbum";
    public final static String BUSQUEDA_POR_GENERO = "Género";
    public final static String BUSQUEDA_POR_CANCION = "Canción"; 
    
    /**
     * Constantes Globales:
     * Evaluan que los datos tengan algo asignado.
     */
    public final static String SIN_ASIGNAR = "";
}
