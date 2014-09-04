/**
 * Frame que podrá agregar y modificar las propiedades o caracteristicas de una
 * cancion y permitira agregarlos a una lista.
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

/**
 * @author Lucia  Solis
 * @author Joseph Vega
 * @author Miller Ruiz
 */
public class DetallesCancion extends javax.swing.JFrame {
    
    JFileChooser fileChooser = new JFileChooser(); 
    String ListaMusica;
    
    public DetallesCancion() {
        initComponents();
        reubicarcontroles();
    }
    
    public void BuscarCanción(){
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo "
                + "MP3", "mp3", "mp3"); 
        fileChooser.setFileFilter(filtro); 

        int seleccion = fileChooser.showOpenDialog(this); 
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            ListaMusica = fileChooser.getSelectedFile().getAbsolutePath();
            //jLabelPortada.setIcon(fileChooser.getSelectedFile().);
            jTextFieldNombre.setText(fileChooser.getSelectedFile().getName());
        }
    }
    
    public void reubicarcontroles(){
        System.out.println("Reubicar");
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
        jLabelAutor = new javax.swing.JLabel();
        jLabelArtista = new javax.swing.JLabel();
        jLabelNumeroCancion = new javax.swing.JLabel();
        jLabelNumeroDisco = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldArtista = new javax.swing.JTextField();
        jTextFieldAlbum = new javax.swing.JTextField();
        jTextFieldAutor = new javax.swing.JTextField();
        jTextFieldGenero = new javax.swing.JTextField();
        jLabelTitulo1 = new javax.swing.JLabel();
        jLabelTitulo2 = new javax.swing.JLabel();
        jFormattedTextFieldAño = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNumeroCancion2 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNumeroDisco1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNumeroCancion1 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNumeroDisco2 = new javax.swing.JFormattedTextField();
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
        jLabelAceptar.setBounds(405, 234, 115, 51);

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
        jLabelCancelar.setBounds(520, 234, 115, 51);

        jLabelOpcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondoOscuroAlbum.fw.png"))); // NOI18N
        getContentPane().add(jLabelOpcion);
        jLabelOpcion.setBounds(405, 230, 230, 60);

        jLabelBuscar.setBackground(new java.awt.Color(0, 0, 0));
        jLabelBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/iconobuscar.fw.png"))); // NOI18N
        jLabelBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelBuscarMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelBuscar);
        jLabelBuscar.setBounds(422, 14, 23, 26);

        jLabelPortada.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabelPortada);
        jLabelPortada.setBounds(420, 12, 200, 200);

        jLabelNombre.setText("Nombre:");
        getContentPane().add(jLabelNombre);
        jLabelNombre.setBounds(10, 13, 90, 21);

        jLabelAlbum.setText("Álbum:");
        getContentPane().add(jLabelAlbum);
        jLabelAlbum.setBounds(10, 103, 90, 21);

        jLabelAño.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAño.setText("Año:");
        getContentPane().add(jLabelAño);
        jLabelAño.setBounds(50, 240, 50, 14);

        jLabelGenero.setText("Género:");
        getContentPane().add(jLabelGenero);
        jLabelGenero.setBounds(10, 193, 90, 21);

        jLabelAutor.setText("Autor:");
        getContentPane().add(jLabelAutor);
        jLabelAutor.setBounds(10, 148, 90, 21);

        jLabelArtista.setText("Artista/Grupo:");
        getContentPane().add(jLabelArtista);
        jLabelArtista.setBounds(10, 57, 90, 21);

        jLabelNumeroCancion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumeroCancion.setText("Número Canción: ");
        getContentPane().add(jLabelNumeroCancion);
        jLabelNumeroCancion.setBounds(125, 240, 105, 14);

        jLabelNumeroDisco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumeroDisco.setText("Número Disco:");
        getContentPane().add(jLabelNumeroDisco);
        jLabelNumeroDisco.setBounds(260, 240, 95, 14);
        getContentPane().add(jTextFieldNombre);
        jTextFieldNombre.setBounds(100, 10, 300, 25);
        getContentPane().add(jTextFieldArtista);
        jTextFieldArtista.setBounds(100, 55, 300, 25);
        getContentPane().add(jTextFieldAlbum);
        jTextFieldAlbum.setBounds(100, 100, 300, 25);
        getContentPane().add(jTextFieldAutor);
        jTextFieldAutor.setBounds(100, 145, 300, 25);
        getContentPane().add(jTextFieldGenero);
        jTextFieldGenero.setBounds(100, 190, 300, 25);

        jLabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo1.setText("de");
        getContentPane().add(jLabelTitulo1);
        jLabelTitulo1.setBounds(170, 260, 15, 21);

        jLabelTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo2.setText("de");
        getContentPane().add(jLabelTitulo2);
        jLabelTitulo2.setBounds(300, 260, 15, 21);

        jFormattedTextFieldAño.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        getContentPane().add(jFormattedTextFieldAño);
        jFormattedTextFieldAño.setBounds(50, 260, 50, 25);

        jFormattedTextFieldNumeroCancion2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        getContentPane().add(jFormattedTextFieldNumeroCancion2);
        jFormattedTextFieldNumeroCancion2.setBounds(190, 260, 35, 25);

        jFormattedTextFieldNumeroDisco1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        getContentPane().add(jFormattedTextFieldNumeroDisco1);
        jFormattedTextFieldNumeroDisco1.setBounds(260, 260, 35, 25);

        jFormattedTextFieldNumeroCancion1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        getContentPane().add(jFormattedTextFieldNumeroCancion1);
        jFormattedTextFieldNumeroCancion1.setBounds(130, 260, 35, 25);

        jFormattedTextFieldNumeroDisco2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        getContentPane().add(jFormattedTextFieldNumeroDisco2);
        jFormattedTextFieldNumeroDisco2.setBounds(320, 260, 35, 25);

        jLabelFondoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondo.png"))); // NOI18N
        getContentPane().add(jLabelFondoPrincipal);
        jLabelFondoPrincipal.setBounds(0, 0, 660, 350);

        setSize(new java.awt.Dimension(659, 348));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelarMouseReleased
        this.hide();
        super.enable();
    }//GEN-LAST:event_jLabelCancelarMouseReleased

    private void jLabelAceptarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAceptarMouseReleased
        Cancion Ca = new Cancion("","","","","","");
        try{
            Ca.setAlbum(jTextFieldAlbum.getText());
            Ca.setArtista(jTextFieldArtista.getText());
            Ca.setAño(jFormattedTextFieldAño.getText());
            Ca.setGenero(jTextFieldGenero.getText());
            Ca.setNombre(jTextFieldNombre.getText());
            
            JOptionPane.showMessageDialog(null, "Canción agregada correctamente",
                    "Correcto",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error de registro","Erorr",
                    JOptionPane.ERROR_MESSAGE);
        }
        jLabelCancelarMouseReleased(evt);
    }//GEN-LAST:event_jLabelAceptarMouseReleased

    private void jLabelBuscarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuscarMouseReleased
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG",
                "jpg","png"); 
        fileChooser.setFileFilter(filtro); 

        int seleccion = fileChooser.showOpenDialog(this); 
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String fichero = fileChooser.getSelectedFile().getAbsolutePath();
            
            try{
               ImageIcon icon = new ImageIcon(fichero);
               Icon icono = new ImageIcon(icon.getImage()
                       .getScaledInstance(200, 200, Image.SCALE_DEFAULT));
               jLabelPortada.setText(null);
               jLabelPortada.setIcon( icono );
            }catch(Exception ex){
            }
        }
    }//GEN-LAST:event_jLabelBuscarMouseReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetallesCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Reproductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextFieldAño;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumeroCancion1;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumeroCancion2;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumeroDisco1;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumeroDisco2;
    private javax.swing.JLabel jLabelAceptar;
    private javax.swing.JLabel jLabelAlbum;
    private javax.swing.JLabel jLabelArtista;
    private javax.swing.JLabel jLabelAutor;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelCancelar;
    private javax.swing.JLabel jLabelFondoPrincipal;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumeroCancion;
    private javax.swing.JLabel jLabelNumeroDisco;
    private javax.swing.JLabel jLabelOpcion;
    private javax.swing.JLabel jLabelPortada;
    private javax.swing.JLabel jLabelTitulo1;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JTextField jTextFieldAlbum;
    private javax.swing.JTextField jTextFieldArtista;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
