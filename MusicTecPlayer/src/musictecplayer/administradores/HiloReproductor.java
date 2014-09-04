package musictecplayer.administradores;

import java.io.IOException;
import javazoom.jl.player.Player;
import musictecplayer.constantes.Parametros;
import musictecplayer.vistas.Reproductor;

/**
 * @author Lucia Solis Ceciliano
 * @author Joseph Vega Vargas
 * @author Miller Ruiz Urbina
 * 
 * Clase que va a controlar el hilo reproductor de la musica en tiempo real
 */
public class HiloReproductor extends Thread {
    /**
     * Variables Globales:
     * @var blinker
     * @var interval
     * @var threadSuspended
     * @var reproductor
     * @var player 
     */
    private volatile boolean blinker = true;
    final long interval = 1000;
    private volatile boolean threadSuspended = false;
    private Reproductor reproductor = null;
    
    private Player player = null;

    /**
     * Método constructor de la clase
     * @param reproductor 
     */
    public HiloReproductor(Reproductor reproductor) {
        this.reproductor = reproductor;
    }

    /**
     * Método que controla si esta pausado o no el reproductor
     */
    public void run() {
        while (blinker == true) {
            try {
                Thread.sleep(interval);

                synchronized (this) {
                    while (threadSuspended && blinker == true) {
                        System.out.println("El hilo de reproduccion esta pausado");
                        wait();
                    }
                }
            } catch (InterruptedException e) {
            }
            //
            if (reproductor.getEstadoReproduccion() == Parametros.REPRODUCIENDO) {
                try {
                    int posicionCancion = reproductor.getReproductor().getFIS().available();
                    long songTotalLen = reproductor.getReproductor().getSongTotalLen();
                    reproductor.getjSliderPosicionCancion().setValue((int) (songTotalLen - posicionCancion));
                    System.out.println("Actualizando estado");
                    if (reproductor.getReproductor().getPlayer().isComplete()) {
                        reproductor.finalizarReproduccion();
                    }
                } catch (IOException ex) {
                    System.out.println("Error al actualizar estado de la cancion");
                    reproductor.finalizarReproduccion();
                }

            }
        }

        //
        System.out.println("Se ha detenido el hilo");
    }

    /**
     * Método que detiene los procesos del reproductor
     */
    public synchronized void detener() {
        System.out.println("DETENER HILO");
        blinker = false;
        notify();
    }

    /**
     * Método que pausa los procesos del reproductor
     */
    public synchronized void pausar() {

        threadSuspended = true;

        if (!threadSuspended) {
            notify();
        }
    }

    /**
     * Método que continua los procesos del reproductor
     */
    public synchronized void continuar() {

        threadSuspended = false;

        if (!threadSuspended) {
            notify();
        }
    }

}
