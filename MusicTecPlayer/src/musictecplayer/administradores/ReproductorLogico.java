package musictecplayer.administradores;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


/**
 * @author Lucia Solis
 * @author Joseph Vega
 * @author Miller Ruiz
 */
public class ReproductorLogico {
    
    
    

    FileInputStream FIS = null;
    BufferedInputStream BIS = null;

    public long pauseLocation = 0;
    public long songTotalLen = 0;
    public String fileLocation = null;

    public Player player = null;

    public ReproductorLogico() {
        
       
    }
    
    
    

    public void stop() {
        if (player != null) {
            player.close();

            pauseLocation = 0;
            songTotalLen = 0;
        }
    }

    public void pause() {
        if (player != null) {
            try {
                pauseLocation = FIS.available();
                player.close();
            } catch (IOException ex) {
                System.out.println("Error al pausar");
            }
        }
    }

    public void play(String ruta) {
        try {
            FIS = new FileInputStream(ruta);
            BIS = new BufferedInputStream(FIS);

            player = new Player(BIS);

            songTotalLen = FIS.available();

            fileLocation = ruta + "";

            new Thread() {
                @Override
                public void run() {
                    try {
                        player.play();
                    } catch (JavaLayerException ex) {
                        System.out.println("Error en el hilo reproductor: play");
                    }
                }
            }.start();

        } catch (FileNotFoundException ex) {

            System.out.println("Error al cargar archivo: play");

        } catch (JavaLayerException ex) {

            System.out.println("Error al reproducir archivo: play");

        } catch (IOException ex) {

            System.out.println("Error al leer archivo: play");
        
        } catch (Exception ex) {
            System.out.println("Error inesperado: play");
        }

    }

    public void resume() {
        try {
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);

            player = new Player(BIS);

            FIS.skip(songTotalLen - pauseLocation);

            new Thread() {
                @Override
                public void run() {
                    try {
                        player.play();
                    } catch (JavaLayerException ex) {
                        System.out.println("Error en el hilo reproductor: play");
                    }
                }
            }.start();

        } catch (FileNotFoundException ex) {

            System.out.println("Error al cargar archivo: continuar");

        } catch (JavaLayerException ex) {

            System.out.println("Error al reproducir archivo: continuar");

        } catch (IOException ex) {

            System.out.println("Error al leer archivo: continuar");

        } catch (Exception ex) {
            System.out.println("Error inesperado: continuar");
        }
    }
}
