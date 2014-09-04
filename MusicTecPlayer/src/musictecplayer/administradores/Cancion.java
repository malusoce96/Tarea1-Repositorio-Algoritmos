/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musictecplayer.administradores;

/**
 *
 * @author MILLER
 * @author JOSEPH
 * @author LUCIA
 */
public class Cancion {

    private String nombre;
    private String artista;
    private String genero;
    private String album;
    private String año;
    private String rutaCancion;
    private String rutaImagen;

    /**
     * Cancion
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

    public String getPath() {
        return rutaCancion;
    }

    public void setPath(String path) {
        this.rutaCancion = path;
    }

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

//PROBANDO desde maquina vistual!
