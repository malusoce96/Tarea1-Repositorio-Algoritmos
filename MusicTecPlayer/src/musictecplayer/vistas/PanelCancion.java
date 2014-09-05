/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musictecplayer.vistas;

import javax.swing.JLabel;

/**
 *
 * @author LUCIA
 */
public class PanelCancion extends javax.swing.JPanel {

    String cancion, artista, album, genero, año;

    /**
     * Creates new form PanelCancion
     */
    public PanelCancion(String cancion, String artista, String album, String genero, String año) {
        initComponents();
        jLabelValorCancion.setText(cancion);
        jLabelValorArtista.setText(artista);
        jLabelValorAlbum.setText(album);
        jLabelValorGenero.setText(genero);
        jLabelValorAño.setText(año);
        jLabelValorCancion.setToolTipText(cancion);

        this.cancion = cancion;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.año = año;
        
    }

    public void crearPanelCancion() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImagenCancion = new javax.swing.JLabel();
        jLabelCacion = new javax.swing.JLabel();
        jLabelValorCancion = new javax.swing.JLabel();
        jLabelArtista = new javax.swing.JLabel();
        jLabelValorArtista = new javax.swing.JLabel();
        jLabelAlbum = new javax.swing.JLabel();
        jLabelValorAlbum = new javax.swing.JLabel();
        jLabelGenero = new javax.swing.JLabel();
        jLabelValorGenero = new javax.swing.JLabel();
        jLabelValorAño = new javax.swing.JLabel();
        jLabelAño = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(305, 400));
        setLayout(null);

        jLabelImagenCancion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/caratulas/prince royce.jpg"))); // NOI18N
        jLabelImagenCancion.setToolTipText("");
        add(jLabelImagenCancion);
        jLabelImagenCancion.setBounds(60, 10, 170, 170);

        jLabelCacion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelCacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCacion.setText("Canción:");
        add(jLabelCacion);
        jLabelCacion.setBounds(20, 190, 60, 20);

        jLabelValorCancion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelValorCancion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelValorCancion.setText("________________");
        add(jLabelValorCancion);
        jLabelValorCancion.setBounds(80, 190, 150, 20);

        jLabelArtista.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelArtista.setForeground(new java.awt.Color(255, 255, 255));
        jLabelArtista.setText("Artista:");
        add(jLabelArtista);
        jLabelArtista.setBounds(20, 230, 60, 20);

        jLabelValorArtista.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelValorArtista.setForeground(new java.awt.Color(255, 255, 255));
        jLabelValorArtista.setText("________________");
        add(jLabelValorArtista);
        jLabelValorArtista.setBounds(80, 230, 150, 20);

        jLabelAlbum.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelAlbum.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAlbum.setText("Álbum:");
        add(jLabelAlbum);
        jLabelAlbum.setBounds(20, 270, 60, 20);

        jLabelValorAlbum.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelValorAlbum.setForeground(new java.awt.Color(255, 255, 255));
        jLabelValorAlbum.setText("________________");
        add(jLabelValorAlbum);
        jLabelValorAlbum.setBounds(80, 270, 150, 20);

        jLabelGenero.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelGenero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGenero.setText("Género:");
        add(jLabelGenero);
        jLabelGenero.setBounds(20, 310, 60, 20);

        jLabelValorGenero.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelValorGenero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelValorGenero.setText("________________");
        add(jLabelValorGenero);
        jLabelValorGenero.setBounds(80, 310, 150, 20);

        jLabelValorAño.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelValorAño.setForeground(new java.awt.Color(255, 255, 255));
        jLabelValorAño.setText("________________");
        add(jLabelValorAño);
        jLabelValorAño.setBounds(80, 350, 150, 20);

        jLabelAño.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelAño.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAño.setText("Año:");
        add(jLabelAño);
        jLabelAño.setBounds(20, 350, 60, 20);
        add(jSeparator1);
        jSeparator1.setBounds(0, 2, 290, 10);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAlbum;
    private javax.swing.JLabel jLabelArtista;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelCacion;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelImagenCancion;
    private javax.swing.JLabel jLabelValorAlbum;
    private javax.swing.JLabel jLabelValorArtista;
    private javax.swing.JLabel jLabelValorAño;
    private javax.swing.JLabel jLabelValorCancion;
    private javax.swing.JLabel jLabelValorGenero;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}