package musictecplayer.administradores;

/**
 * @author Lucia Solis Ceciliano  
 * @author Joseph Vega Vargas
 * @author Miller Ruiz Urbina
 * 
 * Clase que va a almacenar los datos de las canciones y va a permitir realizar
 * todos los procesos necesarios en las canciones
 */
public class Cancion {
    /**
     * Variables Globales:
     * @var nombre, artista, genero, album, año, rutaCancion, rutaImagen: 
     * controlan los atributos de las canciones
     */
    private String nombre;
    private String artista;
    private String genero;
    private String album;
    private String año;
    private String rutaCancion;
    private String rutaImagen;

    /**
     * Método constructor de la clase
     * 
     * @param nombre
     * @param artista
     * @param genero
     * @param album
     * @param año
     * @param rutaCancion
     * @param rutaImagen 
     */
    public Cancion(String nombre, String artista, String genero, String album, String año, String rutaCancion, String rutaImagen) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.album = album;
        this.año = año;
        this.rutaCancion = rutaCancion;
        this.rutaImagen = rutaImagen;
    }

    /**
     * Metodos Get permiten obtener el datos solicitado de las variables
     * Metodos Set permiten modificar los datos indirectamente a la variable
     * @return String || int
     */
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
    public String getAño() {
        return año;
    }
    public void setAño(String año) {
        this.año = año;
    }
    public String getRutaCancion() {
        return rutaCancion;
    }
    public String getRutaImagen() {
        return rutaImagen;
    }
    public void setRutaCancion(String rutaCancion) {
        this.rutaCancion = rutaCancion;
    }
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    /**
     * Método que imprime los datos para la comprobación del almacenaje
     * @return 
     */
    @Override
    public String toString() {
        String resultado = "";
        resultado += "Nodo:\n"
                + nombre + "\n"
                + artista + "\n"
                + album + "\n"
                + año + "\n"
                + rutaCancion + "\n";
        return resultado;
    }
}
