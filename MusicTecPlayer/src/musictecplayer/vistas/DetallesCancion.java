/**
 * Frame que podrá agregar y modificar las propiedades o caracteristicas de una
 * cancion y permitira agregarlos a una lista.
 */
package musictecplayer.vistas;

import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Lucia  Solis
 * @author Joseph Vega
 * @author Miller Ruiz
 */
public class DetallesCancion extends javax.swing.JFrame {
    
    JFileChooser fileChooser = new JFileChooser(); 
    String[] ListaMusica = new String[15];
    
    public DetallesCancion() {
        initComponents();
        reubicarcontroles();
    }
    
    public void reubicarcontroles(){
        System.out.println("Reubicar");
        
        /*jLabelAceptar.setLocation(cambioX + 2, cambioY + 2);
        jLabelCancelar
        jLabelExaminar
        jLabelExaminar1
        jLabelFondoAceptar
        jLabelFondoCancelar
        jLabelFondoExaminar
        jLabelFondoOpcion1
        jLabelFondoOpcion2
        jLabelFondoPrincipal
        jLabelImagen
        jLabelOpcion1
        jLabelOpcion2
        jPanelGeneral;*/
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelAceptar = new javax.swing.JLabel();
        jLabelCancelar = new javax.swing.JLabel();
        jLabelOpcion = new javax.swing.JLabel();
        jLabelBuscar = new javax.swing.JLabel();
        jLabelPortada = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();
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
        getContentPane().add(jLabelAceptar);
        jLabelAceptar.setBounds(400, 234, 115, 51);

        jLabelCancelar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCancelar.setText("Cancelar");
        getContentPane().add(jLabelCancelar);
        jLabelCancelar.setBounds(515, 234, 115, 51);

        jLabelOpcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondoOscuroAlbum.fw.png"))); // NOI18N
        getContentPane().add(jLabelOpcion);
        jLabelOpcion.setBounds(400, 230, 230, 60);

        jLabelBuscar.setBackground(new java.awt.Color(0, 0, 0));
        jLabelBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/iconobuscar.fw.png"))); // NOI18N
        getContentPane().add(jLabelBuscar);
        jLabelBuscar.setBounds(432, 12, 23, 26);

        jLabelPortada.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabelPortada);
        jLabelPortada.setBounds(430, 10, 200, 200);

        jLabel5.setText("Nombre:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 13, 41, 14);

        jLabel7.setText("Álbum:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 103, 33, 14);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Año:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(90, 240, 50, 14);

        jLabel9.setText("Género:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 193, 39, 14);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/cambiarTipoBusqueda.fw.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 234, 61, 56);

        jLabel11.setText("Autor:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 148, 31, 14);

        jLabel12.setText("Artista/Grupo:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 57, 69, 14);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Número Canción: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 240, 95, 14);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Número Disco:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(280, 240, 95, 14);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(90, 10, 330, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(90, 55, 330, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(90, 100, 330, 20);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(90, 145, 330, 20);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(90, 190, 330, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("de");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(200, 260, 15, 14);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("de");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(320, 260, 15, 14);

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        getContentPane().add(jFormattedTextField1);
        jFormattedTextField1.setBounds(90, 260, 50, 20);
        getContentPane().add(jFormattedTextField2);
        jFormattedTextField2.setBounds(220, 260, 35, 20);
        getContentPane().add(jFormattedTextField3);
        jFormattedTextField3.setBounds(280, 260, 35, 20);
        getContentPane().add(jFormattedTextField4);
        jFormattedTextField4.setBounds(160, 260, 35, 20);
        getContentPane().add(jFormattedTextField5);
        jFormattedTextField5.setBounds(340, 260, 35, 20);

        jLabelFondoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondo.png"))); // NOI18N
        getContentPane().add(jLabelFondoPrincipal);
        jLabelFondoPrincipal.setBounds(0, 0, 650, 350);

        setSize(new java.awt.Dimension(659, 348));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAceptar;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelCancelar;
    private javax.swing.JLabel jLabelFondoPrincipal;
    private javax.swing.JLabel jLabelOpcion;
    private javax.swing.JLabel jLabelPortada;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
