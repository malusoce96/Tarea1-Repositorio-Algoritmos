/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musictecplayer.administradores;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 * @author Lucia Solis
 * @author Joseph Vega
 * @author Miller Ruiz
 */
public class HiloReproductor extends Thread {

    private volatile boolean blinker = true;
    final long interval = 0;
    private volatile boolean threadSuspended = false;

    /**
     * variables para reproducir
     */
    FileInputStream FIS;
    BufferedInputStream BIS;

    public long pauseLocation;
    public long songTotalLen;
    public String fileLocation;

    public Player player;

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

            //Codigo a ejecutar
            System.out.println("Se esta ejecutando la cancion");
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

        threadSuspended = !threadSuspended;

        if (!threadSuspended) {
            notify();
        }
    }
    
    public synchronized void detenerCancion(){
        
    }
    
    

}
