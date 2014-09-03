/**
 * Frame que va a agregar o modificar una canción de acuerdo a la opción 
 * ingresada. Además lo va a almacenar en una lista.
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
public class DetalleCancion extends javax.swing.JFrame {

    JFileChooser fileChooser = new JFileChooser(); 
    String[] ListaMusica = new String[15];
    /**
     */
    
    public DetalleCancion() {
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

        jLabelFondoPrincipal = new javax.swing.JLabel();
        jLabelFondoOpcion1 = new javax.swing.JLabel();
        jLabelOpcion1 = new javax.swing.JLabel();
        jLabelFondoCancelar = new javax.swing.JLabel();
        jLabelOpcion2 = new javax.swing.JLabel();
        jPanelGeneral = new javax.swing.JPanel();
        jLabelImagen = new javax.swing.JLabel();
        jLabelFondoOpcion2 = new javax.swing.JLabel();
        jLabelAceptar = new javax.swing.JLabel();
        jLabelCancelar = new javax.swing.JLabel();
        jLabelFondoExaminar = new javax.swing.JLabel();
        jLabelFondoAceptar = new javax.swing.JLabel();
        jLabelExaminar = new javax.swing.JLabel();
        jLabelExaminar1 = new javax.swing.JLabel();

        jLabelFondoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondo.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Canción");
        setResizable(false);

        jLabelFondoOpcion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondoOscuroAlbum.fw.png"))); // NOI18N

        jLabelOpcion1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelOpcion1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelOpcion1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOpcion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOpcion1.setText("General");
        jLabelOpcion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelFondoCancelar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFondoCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/tipoBusqueda.fw.png"))); // NOI18N

        jLabelOpcion2.setBackground(new java.awt.Color(0, 0, 0));
        jLabelOpcion2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelOpcion2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOpcion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOpcion2.setText("Detalles");
        jLabelOpcion2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelGeneralLayout = new javax.swing.GroupLayout(jPanelGeneral);
        jPanelGeneral.setLayout(jPanelGeneralLayout);
        jPanelGeneralLayout.setHorizontalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelGeneralLayout.setVerticalGroup(
            jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelFondoOpcion2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFondoOpcion2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondoOscuroAlbum.fw.png"))); // NOI18N

        jLabelAceptar.setBackground(new java.awt.Color(0, 0, 0));
        jLabelAceptar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelAceptar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAceptar.setText("Aceptar");
        jLabelAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelAceptarMouseReleased(evt);
            }
        });

        jLabelCancelar.setBackground(new java.awt.Color(0, 0, 0));
        jLabelCancelar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCancelar.setText("Cancelar");
        jLabelCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelCancelarMouseReleased(evt);
            }
        });

        jLabelFondoExaminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFondoExaminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/tipoBusqueda.fw.png"))); // NOI18N

        jLabelFondoAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFondoAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/tipoBusqueda.fw.png"))); // NOI18N

        jLabelExaminar.setBackground(new java.awt.Color(0, 0, 0));
        jLabelExaminar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelExaminar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExaminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExaminar.setText("Examinar");
        jLabelExaminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelExaminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelExaminarMouseReleased(evt);
            }
        });

        jLabelExaminar1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelExaminar1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelExaminar1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExaminar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelExaminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/iconobuscar.fw.png"))); // NOI18N
        jLabelExaminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelExaminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelExaminar1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelOpcion1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(jLabelFondoOpcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelOpcion2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(jLabelFondoOpcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 81, Short.MAX_VALUE)
                        .addComponent(jLabelFondoExaminar))
                    .addComponent(jLabelExaminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelFondoAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFondoCancelar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabelExaminar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFondoOpcion1)
                    .addComponent(jLabelFondoOpcion2)
                    .addComponent(jLabelFondoExaminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFondoCancelar))
                    .addComponent(jLabelFondoAceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabelExaminar1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOpcion1)
                    .addComponent(jLabelOpcion2)
                    .addComponent(jLabelAceptar)
                    .addComponent(jLabelExaminar)
                    .addComponent(jLabelCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabelFondoOpcion1.getAccessibleContext().setAccessibleParent(this);
        jLabelCancelar.getAccessibleContext().setAccessibleParent(jPanelGeneral);

        getAccessibleContext().setAccessibleName("DetalleCanción");

        setSize(new java.awt.Dimension(666, 507));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelarMouseReleased
        this.dispose();
    }//GEN-LAST:event_jLabelCancelarMouseReleased

    private void jLabelAceptarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAceptarMouseReleased
        JOptionPane.showMessageDialog(null, "Datos Almacenados Correctamente", 
                "", JOptionPane.INFORMATION_MESSAGE);
        jLabelCancelarMouseReleased(evt);
    }//GEN-LAST:event_jLabelAceptarMouseReleased

    private void jLabelExaminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExaminarMouseReleased
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo MP3", "mp3", "mp3"); 
        fileChooser.setFileFilter(filtro); 

        int seleccion = fileChooser.showOpenDialog(this);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) { 
            File file = fileChooser.getSelectedFile();
            
            JOptionPane.showMessageDialog(null, file);
            try { 
                
            } catch (Exception ex) { 
            } 
        } 
    }//GEN-LAST:event_jLabelExaminarMouseReleased

    private void jLabelExaminar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExaminar1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelExaminar1MouseReleased

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
            java.util.logging.Logger.getLogger(DetalleCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DetalleCancion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAceptar;
    private javax.swing.JLabel jLabelCancelar;
    private javax.swing.JLabel jLabelExaminar;
    private javax.swing.JLabel jLabelExaminar1;
    private javax.swing.JLabel jLabelFondoAceptar;
    private javax.swing.JLabel jLabelFondoCancelar;
    private javax.swing.JLabel jLabelFondoExaminar;
    private javax.swing.JLabel jLabelFondoOpcion1;
    private javax.swing.JLabel jLabelFondoOpcion2;
    private javax.swing.JLabel jLabelFondoPrincipal;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelOpcion1;
    private javax.swing.JLabel jLabelOpcion2;
    private javax.swing.JPanel jPanelGeneral;
    // End of variables declaration//GEN-END:variables
}
