/**
 * @author Lucia Solis Ceciliano  
 * @author Joseph Vega Vargas
 * @author Miller Ruiz Urbina
 */

package musictecplayer.administradores;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Clase que tiene los controles del reproductor y maneja todas las opciones 
 * para reproducir la música.
 */
public class ReproductorLogico {
    /**
     * Variables Globales:
     * 
     */
    FileInputStream FIS = null;
    BufferedInputStream BIS = null;
    
    /**
     * Variables Globales:
     * 
     */
    private long pauseLocation = 0;
    private long songTotalLen = 0;
    private String fileLocation = null;
    
    /**
     * Variables Globales:
     * 
     */
    private Player player = null;

    /**
     * Método constructor de la clase.
     */
    public ReproductorLogico() {
    }

    /**
     * Devuelve lo que tiene en reproducción.
     * @return player
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * Devuelve la posición donde quedo la pausa de la pista.
     * @return pauseLocation
     */
    public long getPauseLocation() {
        return pauseLocation;
    }

    /**
     * Edita indirectamente la posición donde quedo la pausa de la pista.
     * @param pauseLocation 
     */
    public void setPauseLocation(long pauseLocation) {
        this.pauseLocation = pauseLocation;
    }

    /**
     * Devuelve la posición total de la pista.
     * @return songTotalLen
     */
    public long getSongTotalLen() {
        return songTotalLen;
    }

    /**
     * Edita indirectamente la posición total de la pista.
     * @param songTotalLen 
     */
    public void setSongTotalLen(long songTotalLen) {
        this.songTotalLen = songTotalLen;
    }

    /**
     * Devuelve la dirección de la pista.
     * @return fileLocation
     */
    public String getFileLocation() {
        return fileLocation;
    }

    /**
     * Edita indirectamente la dirección de la pista.
     * @param fileLocation 
     */
    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    /**
     * Devuelve una opción de la ejecución del reproductor
     * @return 
     */
    public FileInputStream getFIS() {
        return FIS;
    }
    
    /**
     * Detiene la reproducción de la pieza y reinicia todas las configuraciones
     * al inicio.
     */
    public void stop() {
        //Condiciona si existe algo en reproducción
        if (player != null) {

            player.close(); //Cierra la pieza
            //Inicializa los controles
            pauseLocation = 0;
            songTotalLen = 0;
//            try {
//                FIS.close();
//                BIS.close();
//
//            } catch (IOException ex) {
//                System.out.println("Error al leer archivo: stop");
//            } catch (Exception ex) {
//                System.out.println("Error inesperado: stop");
//            }
        }

    }

    /**
     * Detiene la reproducción momentaneamente para luego pueda ser ejecutada.
     */
    public void pause() {
        //Condiciona si existe algo en reproducción
        if (player != null) {
            try {
                pauseLocation = FIS.available();
                player.close();
            } catch (IOException ex) {
                System.out.println("Error al pausar: pausar");
            }
        }
    }
    
    /**
     * Comienza la ejecución del reproductor de musica 
     * @param ruta 
     */
    public void play(String ruta) {
        try {
            //Iniciadores del reproductor
            FIS = new FileInputStream(ruta);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            songTotalLen = FIS.available();
            
            //Localización de la pista
            fileLocation = ruta + "";

        } catch (FileNotFoundException ex) {
            System.out.println("Error al cargar archivo: play");
        } catch (JavaLayerException ex) {
            System.out.println("Error al reproducir archivo: play");
        } catch (IOException ex) {
            System.out.println("Error al leer archivo: play");
        }
        
        //Ejecuta el reproductor
        new Thread() {
            @Override
            public void run() {
                try { player.play();
                } catch (JavaLayerException ex) {
                    System.out.println("Error en el hilo reproductor: play");
                }
                System.out.println("Termino el hilo de PLAY");
            }
        }.start();
    }

    /**
     * Continua la reproducción a partir de la posición de donde quedó
     */
    public void resume() {
        try {
            //Iniciadores del reproductor
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            
            //Comienza en la posicion de la pausa
            FIS.skip(songTotalLen - pauseLocation);

        } catch (FileNotFoundException ex) {
            System.out.println("Error al cargar archivo: continuar");
        } catch (JavaLayerException ex) {
            System.out.println("Error al reproducir archivo: continuar");
        } catch (IOException ex) {
            System.out.println("Error al leer archivo: continuar");
        }

        //Ejecuta el reproductor
        new Thread() {
            @Override
            public void run() {
                try { player.play();
                } catch (JavaLayerException ex) {
                    System.out.println("Error en el hilo reproductor: play");
                }
                System.out.println("Termino el hilo de RESUME");
            }
        }.start();
    }
}
