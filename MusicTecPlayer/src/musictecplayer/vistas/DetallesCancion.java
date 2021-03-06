/**
 * @author Lucia Solis Ceciliano
 * @author Joseph Vega Vargas
 * @author Miller Ruiz Urbina
 */
package musictecplayer.vistas;

import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import musictecplayer.administradores.Cancion;
import musictecplayer.constantes.Parametros;

/**
 * Frame que permite agregar y modificar las propiedades de una canción y
 * agregarlos a una lista.
 */
public class DetallesCancion extends javax.swing.JFrame {

    /**
     * Variables Globales: Guardan las características del archivo buscado.
     */
    JFileChooser SelectorArchivos = new JFileChooser();
    JFileChooser SelectorFotos = new JFileChooser();

    /**
     * Variables Globales: Almacenan la dirección del archivo por agregar.
     */
    String DireccionMusica = null;
    String DireccionFoto = "";

    /**
     * Variables Globales: Asocia con el frame de Reproductor.java.
     */
    Reproductor reproductor;

    /**
     * Método constructor de la clase.
     *
     * @param reproductor
     */
    public DetallesCancion(Reproductor reproductor) {
        initComponents();
        this.reproductor = reproductor; //
    }

    /**
     * Busca la canción en el sistema y almacena su dirección.
     */
    public void BuscarCanción() {
        //Filtra los datos a buscar y los asigna al selector.
        FileNameExtensionFilter Filtro = new FileNameExtensionFilter("Archivos "
                + "MP3", "mp3", "mp3");
        SelectorArchivos.setFileFilter(Filtro);

        //Ejecuta el explorador de archivos con el Filtro de música.
        int seleccion = SelectorArchivos.showOpenDialog(this);

        //Condiciona si fue seleccionado algún archivo.
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            DireccionMusica = SelectorArchivos.getSelectedFile().getAbsolutePath();
            jTextFieldNombre.setText(SelectorArchivos.getSelectedFile()
                    .getName());
        } else {
            super.enable();
            this.dispose();
        }

        if (DireccionMusica == null) {
            //super.enable();
            this.dispose();
        }
    }

    /**
     * Crea un mensaje de error en la interfaz gráfica
     *
     * @param mensaje
     * @param titulo
     */
    public void mostrarMensajeError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Crea un mensaje de información en la interfaz gráfica
     *
     * @param mensaje
     * @param titulo
     */
    public void mostrarMensajeInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelAceptar = new javax.swing.JLabel();
        jLabelCancelar = new javax.swing.JLabel();
        jLabelOpcion = new javax.swing.JLabel();
        jLabelBuscar = new javax.swing.JLabel();
        jLabelPortada = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelAlbum = new javax.swing.JLabel();
        jLabelAño = new javax.swing.JLabel();
        jLabelGenero = new javax.swing.JLabel();
        jLabelArtista = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldArtista = new javax.swing.JTextField();
        jTextFieldAlbum = new javax.swing.JTextField();
        jTextFieldGenero = new javax.swing.JTextField();
        jFormattedTextFieldYear = new javax.swing.JFormattedTextField();
        jLabelFondoPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Detalles de la canción");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(643, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabelAceptar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelAceptar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAceptar.setText("Aceptar");
        jLabelAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelAceptarMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelAceptar);
        jLabelAceptar.setBounds(122, 234, 113, 51);

        jLabelCancelar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCancelar.setText("Cancelar");
        jLabelCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelCancelarMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelCancelar);
        jLabelCancelar.setBounds(234, 234, 113, 51);

        jLabelOpcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondoOscuroAlbum.fw.png"))); // NOI18N
        getContentPane().add(jLabelOpcion);
        jLabelOpcion.setBounds(120, 230, 230, 60);

        jLabelBuscar.setBackground(new java.awt.Color(0, 0, 0));
        jLabelBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/iconobuscar.fw.png"))); // NOI18N
        jLabelBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelBuscarMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelBuscar);
        jLabelBuscar.setBounds(372, 32, 23, 26);

        jLabelPortada.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabelPortada);
        jLabelPortada.setBounds(370, 30, 250, 250);

        jLabelNombre.setText("Nombre:");
        getContentPane().add(jLabelNombre);
        jLabelNombre.setBounds(11, 20, 100, 20);

        jLabelAlbum.setText("Álbum:");
        getContentPane().add(jLabelAlbum);
        jLabelAlbum.setBounds(11, 120, 100, 20);

        jLabelAño.setText("Año:");
        getContentPane().add(jLabelAño);
        jLabelAño.setBounds(11, 220, 100, 20);

        jLabelGenero.setText("Género:");
        getContentPane().add(jLabelGenero);
        jLabelGenero.setBounds(11, 170, 100, 20);

        jLabelArtista.setText("Artista/Grupo:");
        getContentPane().add(jLabelArtista);
        jLabelArtista.setBounds(11, 70, 100, 20);
        getContentPane().add(jTextFieldNombre);
        jTextFieldNombre.setBounds(10, 40, 337, 25);
        getContentPane().add(jTextFieldArtista);
        jTextFieldArtista.setBounds(10, 90, 337, 25);
        getContentPane().add(jTextFieldAlbum);
        jTextFieldAlbum.setBounds(10, 140, 337, 25);
        getContentPane().add(jTextFieldGenero);
        jTextFieldGenero.setBounds(10, 190, 337, 25);

        jFormattedTextFieldYear.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jFormattedTextFieldYear);
        jFormattedTextFieldYear.setBounds(10, 240, 80, 25);

        jLabelFondoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondo.png"))); // NOI18N
        getContentPane().add(jLabelFondoPrincipal);
        jLabelFondoPrincipal.setBounds(0, 0, 660, 350);

        setSize(new java.awt.Dimension(659, 348));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la ventana y vuelve al menú principal.
     *
     * @param evt
     */
    private void jLabelCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelarMouseReleased
        //super.enable();
        this.dispose();
    }//GEN-LAST:event_jLabelCancelarMouseReleased

    /**
     * Almacena la canción en la clase y cierra luego la ventana para volver al
     * menú principal.
     *
     * @param evt
     */
    private void jLabelAceptarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAceptarMouseReleased
        try {
            //Asigna en variables los jTextField
            String nombreCancion = jTextFieldNombre.getText().trim();
            String nombreAlbum = jTextFieldAlbum.getText().trim();
            String nombreArtista = jTextFieldArtista.getText().trim();
            String year = jFormattedTextFieldYear.getText().trim();
            String nombreGenero = jTextFieldGenero.getText().trim();
            
            
            if (DireccionMusica==null){
                
                mostrarMensajeError("No seleccionó el archivo mp3", "MusicTECPlayer");
                jLabelCancelarMouseReleased(evt);
                return;
            }
            
            String rutaCancion = DireccionMusica.trim();
            String rutaImagenCancion = DireccionFoto.trim();

            //Condiciona si los datos están bien scritos
            if (nombreAlbum.equals(Parametros.SIN_ASIGNAR)
                    || nombreArtista.equals(Parametros.SIN_ASIGNAR)
                    || nombreCancion.equals(Parametros.SIN_ASIGNAR)
                    || nombreGenero.equals(Parametros.SIN_ASIGNAR)
                    || year.equals(Parametros.SIN_ASIGNAR)
                    || rutaCancion.equals(Parametros.SIN_ASIGNAR)
                    || year.length() != 4) {

                mostrarMensajeError("Por favor completar todos los datos",
                        "MusicTECPlayer");
            } else {
                //Instancia a la clase para almacenar los datos.
                Cancion nuevaCancion = new Cancion(nombreCancion, nombreArtista,
                        nombreGenero, nombreAlbum, year, rutaCancion,rutaImagenCancion);

                //Funciones que se le asignan al frame Reproductor.java.
                Reproductor.listaCanciones.agregarAlInicio(nuevaCancion);
                reproductor.actualizarListaCanciones();

                mostrarMensajeInformacion("La canción fue agregada "
                        + "correctamente", "Correcto");

                //Método de cierre de la ventana
                jLabelCancelarMouseReleased(evt);
            }
        } catch (HeadlessException e) {
            mostrarMensajeError("Error en el registro de los datos", "Error");
        }
    }//GEN-LAST:event_jLabelAceptarMouseReleased

    /**
     * Busca la portada en el sistema y almacena su dirección.
     *
     * @param evt
     */
    private void jLabelBuscarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuscarMouseReleased
        //Filtra los datos a buscar y los asigna al selector.
        FileNameExtensionFilter Filtro = new FileNameExtensionFilter("jpg / png",
                "jpg", "png");
        SelectorFotos.setFileFilter(Filtro);

        //Ejecuta el explorador de archivos con el Filtro de imágenes
        int Seleccion = SelectorFotos.showOpenDialog(this);

        //Condiciona si fue seleccionado algún archivo
        if (Seleccion == JFileChooser.APPROVE_OPTION) {
            DireccionFoto = SelectorFotos.getSelectedFile().getAbsolutePath();

            //Inserta la imagen en la etiqueta
            try {
                ImageIcon icon = new ImageIcon(DireccionFoto);
                Icon icono = new ImageIcon(icon.getImage()
                        .getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                jLabelPortada.setIcon(icono);

            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_jLabelBuscarMouseReleased

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Reproductor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextFieldYear;
    private javax.swing.JLabel jLabelAceptar;
    private javax.swing.JLabel jLabelAlbum;
    private javax.swing.JLabel jLabelArtista;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelCancelar;
    private javax.swing.JLabel jLabelFondoPrincipal;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelOpcion;
    private javax.swing.JLabel jLabelPortada;
    private javax.swing.JTextField jTextFieldAlbum;
    private javax.swing.JTextField jTextFieldArtista;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
