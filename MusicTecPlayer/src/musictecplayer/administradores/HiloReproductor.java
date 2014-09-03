/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musictecplayer.administradores;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.player.Player;
import musictecplayer.constantes.Parametros;
import musictecplayer.vistas.Reproductor;

/**
 * @author Lucia Solis
 * @author Joseph Vega
 * @author Miller Ruiz
 */
public class HiloReproductor extends Thread {

    private volatile boolean blinker = true;
    final long interval = 1000;
    private volatile boolean threadSuspended = false;
    private Reproductor reproductor = null;

    /**
     * variables para reproducir
     */
    private Player player = null;

    public HiloReproductor(Reproductor reproductor) {
        this.reproductor = reproductor;
    }

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

    public synchronized void detener() {
        System.out.println("DETENER HILO");
        blinker = false;
        notify();
    }

    public synchronized void pausar() {

        threadSuspended = true;

        if (!threadSuspended) {
            notify();
        }
    }

    public synchronized void continuar() {

        threadSuspended = false;

        if (!threadSuspended) {
            notify();
        }
    }

}
