/**
 * Clase que controla el hilo reproductor de la aplicación en el reproductor de 
 * musica. 
 */
package musictecplayer.administradores;

/**
 * @author Lucia  Solis
 * @author Joseph Vega
 * @author Miller Ruiz
 */
public class HiloReproductor extends Thread {

    private volatile boolean blinker = true;
    final long interval = 0;
    private volatile boolean threadSuspended = false;

    @Override
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

}
