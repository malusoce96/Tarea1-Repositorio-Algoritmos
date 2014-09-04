/**
 * @author Lucia Solis Ceciliano  
 * @author Joseph Vega Vargas
 * @author Miller Ruiz Urbina
 */

package musictecplayer.administradores; //Paquete Netbeans 8.0

/**
 * Clase que contiene todos los atributos de una canción, y mediante gets y sets
 * se puede editar un atributo.
 */
public class Cancion {
    /**
     * Variables Globales:
     * Controlan los atributos de una canción.
     */
    private String nombre;
    private String artista;
    private String genero;
    private String album;
    private String año;
    private String rutaCancion;
    private String rutaImagen;

    /**
     * Método constructor de la clase.
     * 
     * @param nombre
     * @param artista
     * @param genero
     * @param album
     * @param año
     * @param rutaCancion
     * @param rutaImagen 
     */
    public Cancion(String nombre, String artista, String genero, String album, 
            String año, String rutaCancion, String rutaImagen) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.album = album;
        this.año = año;
        this.rutaCancion = rutaCancion;
        this.rutaImagen = rutaImagen;
    }
    
    /**
     * Devuelve el nombre de la canción.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Devuelve el artista de la canción.
     * @return artista
     */
    public String getArtista() {
        return artista;
    }
    
    /**
     * Devuelve el género de la canción.
     * @return genero
     */
    public String getGenero() {
        return genero;
    }
    
    /**
     * Devuelve el álbum de la canción.
     * @return album
     */
    public String getAlbum() {
        return album;
    }
    
    /**
     * Devuelve el año de la canción.
     * @return año
     */
    public String getAño() {
        return año;
    }
    
    /**
     * Devuelve la ruta de la canción.
     * @return rutaCancion
     */
    public String getRutaCancion() {
        return rutaCancion;
    }
    
    /**
     * Devuelve la ruta de la imagen de la canción.
     * @return rutaImagen
     */
    public String getRutaImagen() {
        return rutaImagen;
    }
    
    /**
     * Edita indirectamente el nombre de la canción.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Edita indirectamente el artista de la canción.
     * @param artista 
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }
    
    /**
     * Edita indirectamente el género de la canción.
     * @param genero 
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    /**
     * Edita indirectamente el álbum de la canción.
     * @param album 
     */
    public void setAlbum(String album) {
        this.album = album;
    }
    
    /**
     * Edita indirectamente el año de la canción.
     * @param año 
     */
    public void setAño(String año) {
        this.año = año;
    }
    
    /**
     * Edita indirectamente la ruta de la canción.
     * @param rutaCancion 
     */
    public void setRutaCancion(String rutaCancion) {
        this.rutaCancion = rutaCancion;
    }
    
    /**
     * Edita indirectamente la ruta de la imagen de la canción.
     * @param rutaImagen 
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    /**
     * Imprime todos los atributos de la canción.
     * @return resultado
     */
    @Override
    public String toString() {
        String resultado = "Nodo:"
                + "\n" + nombre 
                + "\n" + artista 
                + "\n" + album 
                + "\n" + genero 
                + "\n" + año 
                + "\n" + rutaCancion 
                + "\n" + rutaImagen + "\n";
        
        return resultado;
    }
}