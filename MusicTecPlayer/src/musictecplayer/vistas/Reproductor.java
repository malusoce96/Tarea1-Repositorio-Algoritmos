/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musictecplayer.vistas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import musictecplayer.administradores.Cancion;
import musictecplayer.administradores.HiloReproductor;
import musictecplayer.administradores.ListaDoblementeEnlazada;
import musictecplayer.administradores.ReproductorLogico;
import musictecplayer.constantes.Parametros;

/**
 * @author Lucia Solis
 * @author Joseph Vega
 * @author Miller Ruiz
 */
public class Reproductor extends javax.swing.JFrame implements ActionListener {

    private int estadoReproduccion = Parametros.DETENIDO;// 0 stop, 1 pausado, 2 reproduciendo
    private int tipoBusqueda = Parametros.ARTISTA;// 0 artista, 1 album, 2 genero,3 cancion 

    private String rutaCancionActual = "";

    private ReproductorLogico reproductor = null;

    private HiloReproductor hiloReproductor = null;

    public static ListaDoblementeEnlazada listaCanciones = new ListaDoblementeEnlazada();

    JPopupMenu popupMenuListaTotalCanciones;
    JPopupMenu popupMenuListaPlaylist;
    JMenuItem menuItemAgregarAPlaylist, menuItemEliminar, menuItemModificar, menuItemVerMetaData, menuItemBorrarPlaylist;

    int modoVista = Parametros.MODO_LISTA;

    JPanel panelPrincipal = new JPanel();

    PanelCancion panelCancionActual = null;

    /**
     * Creates new form Reproductor
     */
    public Reproductor() {
        initComponents();
        crearReproductor();

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        jScrollPaneCancionesConCaratula.getViewport().add(panelPrincipal);

        jScrollPaneCancionesConCaratula.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        jScrollPaneCancionesConCaratula.setVisible(false);

//        jListListaCanciones.addMouseListener(new MouseAdapter() {
//            public void mousePressed(MouseEvent e) {
//                if (SwingUtilities.isRightMouseButton(e)) {
//                    JList list = (JList) e.getSource();
//                    int row = list.locationToIndex(e.getPoint());
//                    list.setSelectedIndex(row);
//                    System.out.println("row+ " + row);
//                }
//            }
//
//        });
//        jSliderPosicionCancion.setPaintTicks(true);
//        jSliderPosicionCancion.setMajorTickSpacing(50);
//        jSliderPosicionCancion.setMinorTickSpacing(10);
        jSliderPosicionCancion.setPaintLabels(true);

        jLabelVolumen.setVisible(false);
        jSliderVolumen.setVisible(false);
//
        jSliderPosicionCancion.addChangeListener(
                new ChangeListener() {  // clase interna anónima

                    @Override
                    public void stateChanged(ChangeEvent ce) {

                        if (estadoReproduccion == Parametros.PAUSADO || estadoReproduccion == Parametros.DETENIDO) {

                            System.out.println("VALOR: " + jSliderPosicionCancion.getValue());
                            //reproductor.pause();
                            reproductor.setPauseLocation(reproductor.getSongTotalLen() - jSliderPosicionCancion.getValue());
                            //reproductor.resume();
                        }
                    }

                } // fin de la clase interna anónima

        ); // fin de la llamada a addChangeListener
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {

                if (reproductor != null) {
                    reproductor.stop();
                }

                if (hiloReproductor != null) {
                    hiloReproductor.detener();
                }

                System.exit(0);
            }
        });

        popupMenuListaTotalCanciones = new JPopupMenu();
        popupMenuListaTotalCanciones.add(menuItemAgregarAPlaylist = new JMenuItem("Agregar a la lista Reproducción"));
        popupMenuListaTotalCanciones.add(menuItemEliminar = new JMenuItem("Eliminar"));
        popupMenuListaTotalCanciones.add(menuItemModificar = new JMenuItem("Modificar"));
        popupMenuListaTotalCanciones.add(menuItemVerMetaData = new JMenuItem("Ver información"));

        popupMenuListaPlaylist = new JPopupMenu();
        popupMenuListaPlaylist.add(menuItemBorrarPlaylist = new JMenuItem("Limpiar lista de reproducción"));

        jListListaCanciones.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                // if right mouse button clicked (or me.isPopupTrigger())
                if (SwingUtilities.isRightMouseButton(me)
                        && !jListListaCanciones.isSelectionEmpty()
                        && jListListaCanciones.locationToIndex(me.getPoint())
                        == jListListaCanciones.getSelectedIndex()) {
                    popupMenuListaTotalCanciones.show(jListListaCanciones, me.getX(), me.getY());
                }
            }
        }
        );

        jListListaCancionesPlaylist.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                // if right mouse button clicked (or me.isPopupTrigger())
                if (SwingUtilities.isRightMouseButton(me)
                        && !jListListaCancionesPlaylist.isSelectionEmpty()
                        && jListListaCancionesPlaylist.locationToIndex(me.getPoint())
                        == jListListaCancionesPlaylist.getSelectedIndex()) {
                    popupMenuListaPlaylist.show(jListListaCancionesPlaylist, me.getX(), me.getY());
                }
            }
        }
        );

        menuItemAgregarAPlaylist.addActionListener(this);
        menuItemEliminar.addActionListener(this);
        menuItemModificar.addActionListener(this);
        menuItemVerMetaData.addActionListener(this);
        menuItemBorrarPlaylist.addActionListener(this);

        DefaultListModel modeloListaPlayList = new DefaultListModel();

        jListListaCancionesPlaylist.setModel(modeloListaPlayList);

    }

    public void actualizarPanelPrincipal() {
        
        panelPrincipal = new JPanel();

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        jScrollPaneCancionesConCaratula.getViewport().add(panelPrincipal);

        jScrollPaneCancionesConCaratula.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        modoVista = Parametros.MODO_LISTA;
        jLabelModoVista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/modoNombre.fw.png"))); // NOI18N
        jScrollPaneCancionesConCaratula.setVisible(false);

    }

    public void crearReproductor() {
        reproductor = new ReproductorLogico();
        reproductor.stop();

        hiloReproductor = new HiloReproductor(this);
        hiloReproductor.start();
        hiloReproductor.pausar();

    }

    public void actualizarListaCanciones() {
        Iterator elements = listaCanciones.getIteradorLista();
        jListListaCanciones.removeAll();

        DefaultListModel modeloListaCanciones = new DefaultListModel();

        while (elements.hasNext()) {
            Object objetoActual = elements.next();
            Cancion cancionActual = (Cancion) (objetoActual);
            String nombre = cancionActual.getNombre();
            modeloListaCanciones.addElement(nombre);

            String cancion, artista, album, genero, año;

            cancion = cancionActual.getNombre();
            artista = cancionActual.getArtista();
            album = cancionActual.getAlbum();
            genero = cancionActual.getGenero();
            año = cancionActual.getAño();

            PanelCancion panelCancion = new PanelCancion(cancion, artista, album, genero, año);

            panelCancion.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
                    // if right mouse button clicked (or me.isPopupTrigger())
                    if (SwingUtilities.isRightMouseButton(me)) {
                        popupMenuListaTotalCanciones.show(panelCancion, me.getX(), me.getY());
                        panelCancionActual = (PanelCancion) me.getSource();
                        jListListaCanciones.setVisible(false);
                    }
                }
            }
            );

            panelPrincipal.add(panelCancion);

        }

        jListListaCanciones.setModel(modeloListaCanciones);
        jListListaCanciones.setVisible(true);
    }

    public void actualizarListaCancionesSegun(String tipoBusqueda, String valorABuscar) {
        Iterator elements = listaCanciones.getIteradorLista();
        jListListaCanciones.removeAll();

        DefaultListModel modeloListaCanciones = new DefaultListModel();

        panelPrincipal.removeAll();

        if (tipoBusqueda.equals(Parametros.BUSQUEDA_POR_ALBUM)) {

            while (elements.hasNext()) {
                Object objetoActual = elements.next();
                Cancion cancionActual = (Cancion) (objetoActual);
                String nombreCancionActual = cancionActual.getNombre();
                String nombreAlbum = cancionActual.getAlbum();
                if (nombreAlbum.toUpperCase().contains(valorABuscar.toUpperCase())) {
                    modeloListaCanciones.addElement(nombreCancionActual);

                    String cancion, artista, album, genero, año;

                    cancion = cancionActual.getNombre();
                    artista = cancionActual.getArtista();
                    album = cancionActual.getAlbum();
                    genero = cancionActual.getGenero();
                    año = cancionActual.getAño();

                    PanelCancion panelCancion = new PanelCancion(cancion, artista, album, genero, año);

                    panelCancion.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent me) {
                            // if right mouse button clicked (or me.isPopupTrigger())
                            if (SwingUtilities.isRightMouseButton(me)) {
                                popupMenuListaTotalCanciones.show(panelCancion, me.getX(), me.getY());
                                panelCancionActual = (PanelCancion) me.getSource();
                                jListListaCanciones.setVisible(false);
                            }
                        }
                    }
                    );

                    panelPrincipal.add(panelCancion);

                }
            }

        } else if (tipoBusqueda.equals(Parametros.BUSQUEDA_POR_ARTISTA)) {

            while (elements.hasNext()) {
                Object objetoActual = elements.next();
                Cancion cancionActual = (Cancion) (objetoActual);
                String nombreCancionActual = cancionActual.getNombre();
                String nombreArtista = cancionActual.getArtista();
                if (nombreArtista.toUpperCase().contains(valorABuscar.toUpperCase())) {
                    modeloListaCanciones.addElement(nombreCancionActual);

                    String cancion, artista, album, genero, año;

                    cancion = cancionActual.getNombre();
                    artista = cancionActual.getArtista();
                    album = cancionActual.getAlbum();
                    genero = cancionActual.getGenero();
                    año = cancionActual.getAño();

                    PanelCancion panelCancion = new PanelCancion(cancion, artista, album, genero, año);

                    panelCancion.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent me) {
                            // if right mouse button clicked (or me.isPopupTrigger())
                            if (SwingUtilities.isRightMouseButton(me)) {
                                popupMenuListaTotalCanciones.show(panelCancion, me.getX(), me.getY());
                                panelCancionActual = (PanelCancion) me.getSource();
                            }
                        }
                    }
                    );

                    panelPrincipal.add(panelCancion);

                }
            }

        } else if (tipoBusqueda.equals(Parametros.BUSQUEDA_POR_CANCION)) {

            while (elements.hasNext()) {
                Object objetoActual = elements.next();
                Cancion cancionActual = (Cancion) (objetoActual);
                String nombreCancionActual = cancionActual.getNombre();

                if (nombreCancionActual.toUpperCase().contains(valorABuscar.toUpperCase())) {
                    modeloListaCanciones.addElement(nombreCancionActual);

                    String cancion, artista, album, genero, año;

                    cancion = cancionActual.getNombre();
                    artista = cancionActual.getArtista();
                    album = cancionActual.getAlbum();
                    genero = cancionActual.getGenero();
                    año = cancionActual.getAño();

                    PanelCancion panelCancion = new PanelCancion(cancion, artista, album, genero, año);

                    panelCancion.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent me) {
                            // if right mouse button clicked (or me.isPopupTrigger())
                            if (SwingUtilities.isRightMouseButton(me)) {
                                popupMenuListaTotalCanciones.show(panelCancion, me.getX(), me.getY());
                                panelCancionActual = (PanelCancion) me.getSource();
                            }
                        }
                    }
                    );

                    panelPrincipal.add(panelCancion);

                }
            }

        } else if (tipoBusqueda.equals(Parametros.BUSQUEDA_POR_GENERO)) {

            while (elements.hasNext()) {
                Object objetoActual = elements.next();
                Cancion cancionActual = (Cancion) (objetoActual);
                String nombreCancionActual = cancionActual.getNombre();
                String nombreGenero = cancionActual.getGenero();
                if (nombreGenero.toUpperCase().contains(valorABuscar.toUpperCase())) {
                    modeloListaCanciones.addElement(nombreCancionActual);

                    String cancion, artista, album, genero, año;

                    cancion = cancionActual.getNombre();
                    artista = cancionActual.getArtista();
                    album = cancionActual.getAlbum();
                    genero = cancionActual.getGenero();
                    año = cancionActual.getAño();

                    PanelCancion panelCancion = new PanelCancion(cancion, artista, album, genero, año);

                    panelCancion.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent me) {
                            // if right mouse button clicked (or me.isPopupTrigger())
                            if (SwingUtilities.isRightMouseButton(me)) {
                                popupMenuListaTotalCanciones.show(panelCancion, me.getX(), me.getY());
                                panelCancionActual = (PanelCancion) me.getSource();
                            }
                        }
                    }
                    );

                    panelPrincipal.add(panelCancion);

                }
            }
        }

        jListListaCanciones.setModel(modeloListaCanciones);
    }

    public ReproductorLogico getReproductor() {
        return reproductor;
    }

    public JSlider getjSliderPosicionCancion() {
        return jSliderPosicionCancion;
    }

    public int getEstadoReproduccion() {
        return estadoReproduccion;
    }

    private void escogerArchivo() {
        DetallesCancion DC = new DetallesCancion(this);
        DC.BuscarCanción();
        DC.show();
    }

    private void modificarCancion() {

        if (modoVista == Parametros.MODO_LISTA) {

            if (jListListaCanciones.getSelectedIndex() < 0) {
                return;
            }

            Object nombreCancionActual = jListListaCanciones.getSelectedValue();
            Cancion cancionObtenida = (Cancion) listaCanciones.getCancion((String) nombreCancionActual);

            if (cancionObtenida != null) {
                ModificarCancion DC = new ModificarCancion(this, cancionObtenida);

                DC.setVisible(true);
            }

        } else {
            String nombreCancionActual = panelCancionActual.getCancion();
            Cancion cancionObtenida = (Cancion) listaCanciones.getCancion((String) nombreCancionActual);
            if (cancionObtenida != null) {
                ModificarCancion DC = new ModificarCancion(this, cancionObtenida);

                DC.setVisible(true);
            }

        }

    }

    public void finalizarReproduccion() {
        System.out.println("Stop");

        reproductor.stop();

        estadoReproduccion = Parametros.DETENIDO;
        hiloReproductor.pausar();
        jLabelPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/play.fw.png"))); // NOI18N
        jSliderPosicionCancion.setValue(0);

    }

    public void reubicarControles() {
        System.out.println("Reubicar");
        int cambioY = 480; //500
        int cambioX = 40; //390
        jLabelAnterior.setLocation(cambioX + 2, cambioY + 2);
        jLabelStop.setLocation(cambioX + 46, cambioY + 0);
        jLabelPlay.setLocation(cambioX + 94, cambioY + 2);
        jLabelAleatorio.setLocation(cambioX + 142, cambioY + 2);
        jLabelSiguiente.setLocation(cambioX + 190, cambioY + 2);

        jSliderPosicionCancion.setLocation(cambioX + 3, cambioY - 23);
        jLabelFondoAlbun1.setLocation(cambioX + 3, cambioY - 80);

        jLabelFondoAlbun2.setLocation(cambioX + 3, cambioY - 130);
        jLabelFondoAlbun3.setLocation(cambioX + 3, cambioY - 180);
        jLabelFondoAlbun.setLocation(cambioX + 13, cambioY - 170);
        jLabelFondoPlaylist.setLocation(cambioX - 5, cambioY - 340);
        jSliderVolumen.setLocation(cambioX + 201, cambioY - 150);
        jLabelVolumen.setLocation(cambioX + 200, cambioY - 60);

//        System.out.println(jLabelFondoPlaylist.getLocation().toString());
//        System.out.println(jLabelStop.getLocation().toString());
//        System.out.println(jLabelPlay.getLocation().toString());
//        System.out.println(jLabelAleatorio.getLocation().toString());
//        System.out.println(jLabelSiguiente.getLocation().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneCancionesConCaratula = new javax.swing.JScrollPane();
        jScrollPaneListaCanciones = new javax.swing.JScrollPane();
        jListListaCanciones = new javax.swing.JList();
        jScrollPaneListaCancionesReproduccion = new javax.swing.JScrollPane();
        jListListaCancionesPlaylist = new javax.swing.JList();
        jLabelModoVista = new javax.swing.JLabel();
        jLabelPlaylist = new javax.swing.JLabel();
        jLabelMenu = new javax.swing.JLabel();
        jLabelFondoMenu = new javax.swing.JLabel();
        jLabelFondoPlaylist = new javax.swing.JLabel();
        jSliderPosicionCancion = new javax.swing.JSlider();
        jSliderVolumen = new javax.swing.JSlider();
        jLabelVolumen = new javax.swing.JLabel();
        jLabelFondoAlbun = new javax.swing.JLabel();
        jLabelFondoAlbun1 = new javax.swing.JLabel();
        jLabelFondoAlbun2 = new javax.swing.JLabel();
        jLabelFondoAlbun3 = new javax.swing.JLabel();
        jLabelCambiarTipo = new javax.swing.JLabel();
        jLabelTipoBusqueda = new javax.swing.JLabel();
        jLabelFondoTipo = new javax.swing.JLabel();
        jLabelIconoBuscar = new javax.swing.JLabel();
        jTextFieldTextoBusqueda = new javax.swing.JTextField();
        jLabelBarraBusqueda = new javax.swing.JLabel();
        jLabelAnterior = new javax.swing.JLabel();
        jLabelAleatorio = new javax.swing.JLabel();
        jLabelStop = new javax.swing.JLabel();
        jLabelSiguiente = new javax.swing.JLabel();
        jLabelPlay = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();
        jLabelFondoPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(643, 569));
        setMinimumSize(new java.awt.Dimension(643, 569));
        setPreferredSize(new java.awt.Dimension(643, 569));
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPaneCancionesConCaratula.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPaneCancionesConCaratula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jScrollPaneCancionesConCaratula);
        jScrollPaneCancionesConCaratula.setBounds(310, 140, 310, 400);

        jListListaCanciones.setBackground(new java.awt.Color(0, 0, 0));
        jListListaCanciones.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jListListaCanciones.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPaneListaCanciones.setViewportView(jListListaCanciones);

        getContentPane().add(jScrollPaneListaCanciones);
        jScrollPaneListaCanciones.setBounds(310, 140, 310, 400);

        jListListaCancionesPlaylist.setBackground(new java.awt.Color(0, 0, 0));
        jListListaCancionesPlaylist.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jListListaCancionesPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPaneListaCancionesReproduccion.setViewportView(jListListaCancionesPlaylist);

        getContentPane().add(jScrollPaneListaCancionesReproduccion);
        jScrollPaneListaCancionesReproduccion.setBounds(50, 180, 220, 90);

        jLabelModoVista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/modoNombre.fw.png"))); // NOI18N
        jLabelModoVista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelModoVistaMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelModoVista);
        jLabelModoVista.setBounds(590, 120, 34, 14);

        jLabelPlaylist.setBackground(new java.awt.Color(0, 0, 0));
        jLabelPlaylist.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPlaylist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPlaylist.setText("Lista de Reproducción");
        getContentPane().add(jLabelPlaylist);
        jLabelPlaylist.setBounds(40, 150, 230, 21);

        jLabelMenu.setBackground(new java.awt.Color(0, 0, 0));
        jLabelMenu.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelMenu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMenu.setText("Agregar");
        jLabelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelMenuMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelMenu);
        jLabelMenu.setBounds(42, 45, 120, 50);

        jLabelFondoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/tipoBusqueda.fw.png"))); // NOI18N
        jLabelFondoMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabelFondoMenu);
        jLabelFondoMenu.setBounds(40, 40, 123, 60);

        jLabelFondoPlaylist.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFondoPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondoPlayList.fw.png"))); // NOI18N
        getContentPane().add(jLabelFondoPlaylist);
        jLabelFondoPlaylist.setBounds(35, 140, 246, 146);

        jSliderPosicionCancion.setValue(0);
        jSliderPosicionCancion.setOpaque(false);
        getContentPane().add(jSliderPosicionCancion);
        jSliderPosicionCancion.setBounds(43, 457, 228, 26);

        jSliderVolumen.setOrientation(javax.swing.JSlider.VERTICAL);
        jSliderVolumen.setToolTipText("");
        jSliderVolumen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSliderVolumen.setOpaque(false);
        getContentPane().add(jSliderVolumen);
        jSliderVolumen.setBounds(241, 330, 10, 90);

        jLabelVolumen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/volumenSinFondo.fw.png"))); // NOI18N
        getContentPane().add(jLabelVolumen);
        jLabelVolumen.setBounds(240, 420, 20, 30);

        jLabelFondoAlbun.setBackground(new java.awt.Color(0, 0, 0));
        jLabelFondoAlbun.setOpaque(true);
        getContentPane().add(jLabelFondoAlbun);
        jLabelFondoAlbun.setBounds(53, 310, 210, 140);

        jLabelFondoAlbun1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondoOscuroAlbum.fw.png"))); // NOI18N
        getContentPane().add(jLabelFondoAlbun1);
        jLabelFondoAlbun1.setBounds(43, 400, 230, 57);

        jLabelFondoAlbun2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondoOscuroAlbum.fw.png"))); // NOI18N
        getContentPane().add(jLabelFondoAlbun2);
        jLabelFondoAlbun2.setBounds(43, 350, 230, 57);

        jLabelFondoAlbun3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondoOscuroAlbum.fw.png"))); // NOI18N
        getContentPane().add(jLabelFondoAlbun3);
        jLabelFondoAlbun3.setBounds(43, 300, 230, 57);

        jLabelCambiarTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/cambiarTipoBusqueda.fw.png"))); // NOI18N
        jLabelCambiarTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCambiarTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelCambiarTipoMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelCambiarTipo);
        jLabelCambiarTipo.setBounds(325, 40, 61, 56);

        jLabelTipoBusqueda.setBackground(new java.awt.Color(0, 0, 0));
        jLabelTipoBusqueda.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabelTipoBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTipoBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTipoBusqueda.setText("Artista");
        getContentPane().add(jLabelTipoBusqueda);
        jLabelTipoBusqueda.setBounds(260, 58, 70, 21);

        jLabelFondoTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/tipoBusqueda.fw.png"))); // NOI18N
        jLabelFondoTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabelFondoTipo);
        jLabelFondoTipo.setBounds(258, 40, 70, 56);

        jLabelIconoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/iconobuscar.fw.png"))); // NOI18N
        jLabelIconoBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelIconoBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelIconoBuscarMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelIconoBuscar);
        jLabelIconoBuscar.setBounds(410, 55, 23, 26);

        jTextFieldTextoBusqueda.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldTextoBusqueda.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTextFieldTextoBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTextoBusqueda.setBorder(null);
        jTextFieldTextoBusqueda.setOpaque(false);
        getContentPane().add(jTextFieldTextoBusqueda);
        jTextFieldTextoBusqueda.setBounds(440, 50, 160, 30);

        jLabelBarraBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/buscar.fw.png"))); // NOI18N
        getContentPane().add(jLabelBarraBusqueda);
        jLabelBarraBusqueda.setBounds(390, 40, 234, 56);

        jLabelAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/anterior.fw.png"))); // NOI18N
        jLabelAnterior.setToolTipText("Anterior");
        jLabelAnterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelAnteriorMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelAnterior);
        jLabelAnterior.setBounds(42, 482, 44, 56);

        jLabelAleatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/aleatorio.fw.png"))); // NOI18N
        jLabelAleatorio.setToolTipText("Modo aleatorio");
        jLabelAleatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAleatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelAleatorioMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelAleatorio);
        jLabelAleatorio.setBounds(182, 482, 48, 56);

        jLabelStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/stop.fw.png"))); // NOI18N
        jLabelStop.setToolTipText("Detener");
        jLabelStop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelStopMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelStop);
        jLabelStop.setBounds(86, 480, 48, 59);

        jLabelSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/siguiente.fw.png"))); // NOI18N
        jLabelSiguiente.setToolTipText("Siguiente");
        jLabelSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelSiguienteMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelSiguiente);
        jLabelSiguiente.setBounds(230, 482, 45, 56);

        jLabelPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/play.fw.png"))); // NOI18N
        jLabelPlay.setToolTipText("Reproducir");
        jLabelPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelPlayMouseReleased(evt);
            }
        });
        getContentPane().add(jLabelPlay);
        jLabelPlay.setBounds(134, 482, 48, 56);

        jLabelFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondoReproductorV2.fw.png"))); // NOI18N
        getContentPane().add(jLabelFondo);
        jLabelFondo.setBounds(10, 0, 624, 560);

        jLabelFondoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/fondo.png"))); // NOI18N
        getContentPane().add(jLabelFondoPrincipal);
        jLabelFondoPrincipal.setBounds(0, 0, 660, 590);

        setSize(new java.awt.Dimension(659, 608));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAleatorioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAleatorioMouseReleased
        // TODO add your handling code here
        System.out.println("Aleatorio");

        if (jListListaCancionesPlaylist.getSelectedIndex() < 0) {
            return;
        }

        finalizarReproduccion();

        reproduccirAleatorioCancion();

    }//GEN-LAST:event_jLabelAleatorioMouseReleased

    private void jLabelStopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelStopMouseReleased
        // TODO add your handling code here:
        finalizarReproduccion();

    }//GEN-LAST:event_jLabelStopMouseReleased

    private void jLabelAnteriorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAnteriorMouseReleased
        // TODO add your handling code here:
        System.out.println("Anterior");

        if (jListListaCancionesPlaylist.getSelectedIndex() < 0) {
            return;
        }

        finalizarReproduccion();

        reproduccirAnteriorCancion();


    }//GEN-LAST:event_jLabelAnteriorMouseReleased

    private void jLabelSiguienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSiguienteMouseReleased
        // TODO add your handling code here:
        System.out.println("Siguiente");

        if (jListListaCancionesPlaylist.getSelectedIndex() < 0) {
            return;
        }

        finalizarReproduccion();

        reproduccirSiguienteCancion();

    }//GEN-LAST:event_jLabelSiguienteMouseReleased

    private void jLabelCambiarTipoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCambiarTipoMouseReleased
        // TODO add your handling code here:
        if (tipoBusqueda == Parametros.ARTISTA) {
            tipoBusqueda = Parametros.ALBUM;
            jLabelTipoBusqueda.setText("Álbum");
        } else if (tipoBusqueda == Parametros.ALBUM) {
            tipoBusqueda = Parametros.GENERO;
            jLabelTipoBusqueda.setText("Género");
        } else if (tipoBusqueda == Parametros.GENERO) {
            tipoBusqueda = Parametros.CANCION;
            jLabelTipoBusqueda.setText("Canción");
        } else if (tipoBusqueda == Parametros.CANCION) {
            tipoBusqueda = Parametros.ARTISTA;
            jLabelTipoBusqueda.setText("Artista");
        }
    }//GEN-LAST:event_jLabelCambiarTipoMouseReleased

    private void jLabelPlayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPlayMouseReleased
        // TODO add your handling code here:

        if (jListListaCancionesPlaylist.getSelectedIndex() < 0) {
            return;
        }

        reproduccirPlayList();


    }//GEN-LAST:event_jLabelPlayMouseReleased

    public void reproduccirSiguienteCancion() {
        int selectedIndex = jListListaCancionesPlaylist.getSelectedIndex();
        if (selectedIndex == jListListaCancionesPlaylist.getModel().getSize() - 1) {
            jListListaCancionesPlaylist.setSelectedIndex(0);

        } else {
            jListListaCancionesPlaylist.setSelectedIndex(selectedIndex + 1);
        }

        reproduccirPlayList();
    }

    public void reproduccirAleatorioCancion() {

        Random r = new Random(System.currentTimeMillis());;
        int Low = 0;
        int High = jListListaCancionesPlaylist.getModel().getSize();
        //int indiceActual = jListListaCancionesPlaylist.getSelectedIndex();

        if (jListListaCancionesPlaylist.getSelectedIndex() >= 0) {

            int numeroAletorio;

            if (High > 0) {
                numeroAletorio = r.nextInt(High - Low) + Low;
            } else {
                numeroAletorio = 0;
            }

//        while (indiceActual == numeroAletorio){
//            numeroAletorio = r.nextInt(High - Low) + Low;
//        }
            System.out.println("Aleatorio: " + numeroAletorio);

            jListListaCancionesPlaylist.setSelectedIndex(numeroAletorio);

            reproduccirPlayList();
        }
    }

    public void reproduccirAnteriorCancion() {
        int selectedIndex = jListListaCancionesPlaylist.getSelectedIndex();
        if (selectedIndex == 0) {
            jListListaCancionesPlaylist.setSelectedIndex(jListListaCancionesPlaylist.getModel().getSize() - 1);

        } else {
            jListListaCancionesPlaylist.setSelectedIndex(selectedIndex - 1);
        }

        reproduccirPlayList();
    }

    public void reproduccirPlayList() {
        if ((jListListaCancionesPlaylist.getModel().getSize()) > 0 && jListListaCancionesPlaylist.getSelectedIndex() >= 0) {

            Object nombreCancionActual = jListListaCancionesPlaylist.getSelectedValue();
            Cancion cancionObtenida = (Cancion) listaCanciones.getCancion((String) nombreCancionActual);

            if (cancionObtenida != null) {
                rutaCancionActual = cancionObtenida.getRutaCancion();

                if (!rutaCancionActual.equals("")) {

                    if (estadoReproduccion == Parametros.DETENIDO) {
                        estadoReproduccion = Parametros.REPRODUCIENDO;
                        System.out.println("D-Reproducir");
                        jLabelPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/pause.fw.png"))); // NOI18N

                        reproductor.play(rutaCancionActual);
                        hiloReproductor.continuar();

                        System.out.println("Longitud: " + reproductor.getSongTotalLen());

                        jSliderPosicionCancion.setMaximum((int) reproductor.getSongTotalLen());
                        jSliderPosicionCancion.setValue((int) reproductor.getPauseLocation());

                        //reproductor.resume();
                    } else if (estadoReproduccion == Parametros.PAUSADO) {
                        System.out.println("P-Reproducir");
                        estadoReproduccion = Parametros.REPRODUCIENDO;
                        jLabelPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/pause.fw.png"))); // NOI18N

                        reproductor.resume();
                        hiloReproductor.continuar();

                        jSliderPosicionCancion.setMaximum((int) reproductor.getSongTotalLen());
                        jSliderPosicionCancion.setValue((int) reproductor.getPauseLocation());

                    } else if (estadoReproduccion == Parametros.REPRODUCIENDO) {
                        estadoReproduccion = Parametros.PAUSADO;
                        System.out.println("R-Pausar");
                        jLabelPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/play.fw.png"))); // NOI18N

                        reproductor.pause();
                        hiloReproductor.pausar();
                    }
                }

            }
        }
    }

    public void rotarPlayList() {

    }

    private void jLabelMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMenuMouseReleased
        escogerArchivo();
        
        actualizarPanelPrincipal();
        actualizarListaCanciones();
    }//GEN-LAST:event_jLabelMenuMouseReleased

    private void jLabelIconoBuscarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoBuscarMouseReleased
        // TODO add your handling code here:
        buscarCanciones();
    }//GEN-LAST:event_jLabelIconoBuscarMouseReleased

    private void jLabelModoVistaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelModoVistaMouseReleased
        // TODO add your handling code here:
        if (modoVista == Parametros.MODO_LISTA) {
            modoVista = Parametros.MODO_CARATULAS;
            jLabelModoVista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/modoCaratulas.fw.png"))); // NOI18N
            jScrollPaneCancionesConCaratula.setVisible(true);
            jScrollPaneListaCanciones.setVisible(false);
        } else {
            modoVista = Parametros.MODO_LISTA;
            jLabelModoVista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/modoNombre.fw.png"))); // NOI18N
            jScrollPaneCancionesConCaratula.setVisible(false);
            jScrollPaneListaCanciones.setVisible(true);
        }
    }//GEN-LAST:event_jLabelModoVistaMouseReleased

    public void cambiarAModoLista() {
        modoVista = Parametros.MODO_LISTA;
        jLabelModoVista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/musictecplayer/vistas/img/modoNombre.fw.png"))); // NOI18N
        jScrollPaneCancionesConCaratula.setVisible(false);
        jScrollPaneListaCanciones.setVisible(true);
    }

    public void buscarCanciones() {
        String tipoBusqueda = jLabelTipoBusqueda.getText();
        String valorABuscar = jTextFieldTextoBusqueda.getText().trim();
        if (valorABuscar.equals(Parametros.SIN_ASIGNAR)) {
            //finalizarReproduccion();

            actualizarPanelPrincipal();
            actualizarListaCanciones();
        } else {

            actualizarPanelPrincipal();
            actualizarListaCancionesSegun(tipoBusqueda, valorABuscar);

        }
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Reproductor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Reproductor().setVisible(true);
                Reproductor reproductor = new Reproductor();
                reproductor.reubicarControles();
                reproductor.setVisible(true);
                reproductor.repaint();

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAleatorio;
    private javax.swing.JLabel jLabelAnterior;
    private javax.swing.JLabel jLabelBarraBusqueda;
    private javax.swing.JLabel jLabelCambiarTipo;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelFondoAlbun;
    private javax.swing.JLabel jLabelFondoAlbun1;
    private javax.swing.JLabel jLabelFondoAlbun2;
    private javax.swing.JLabel jLabelFondoAlbun3;
    private javax.swing.JLabel jLabelFondoMenu;
    private javax.swing.JLabel jLabelFondoPlaylist;
    private javax.swing.JLabel jLabelFondoPrincipal;
    private javax.swing.JLabel jLabelFondoTipo;
    private javax.swing.JLabel jLabelIconoBuscar;
    private javax.swing.JLabel jLabelMenu;
    private javax.swing.JLabel jLabelModoVista;
    private javax.swing.JLabel jLabelPlay;
    private javax.swing.JLabel jLabelPlaylist;
    private javax.swing.JLabel jLabelSiguiente;
    private javax.swing.JLabel jLabelStop;
    private javax.swing.JLabel jLabelTipoBusqueda;
    private javax.swing.JLabel jLabelVolumen;
    private javax.swing.JList jListListaCanciones;
    private javax.swing.JList jListListaCancionesPlaylist;
    private javax.swing.JScrollPane jScrollPaneCancionesConCaratula;
    private javax.swing.JScrollPane jScrollPaneListaCanciones;
    private javax.swing.JScrollPane jScrollPaneListaCancionesReproduccion;
    private javax.swing.JSlider jSliderPosicionCancion;
    private javax.swing.JSlider jSliderVolumen;
    private javax.swing.JTextField jTextFieldTextoBusqueda;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {

        System.out.println("Obteniendo click");

        if (ae.getSource() == menuItemAgregarAPlaylist) {
            // add
            if (modoVista == Parametros.MODO_LISTA) {
                DefaultListModel modeloLista = (DefaultListModel) jListListaCancionesPlaylist.getModel();
                modeloLista.addElement(jListListaCanciones.getSelectedValue());
            } else {
                String cancion = panelCancionActual.getCancion();
                DefaultListModel modeloLista = (DefaultListModel) jListListaCancionesPlaylist.getModel();
                modeloLista.addElement(cancion);
            }

        } else if (ae.getSource() == menuItemEliminar) {

            if (modoVista == Parametros.MODO_LISTA) {
                int indiceSeleccionado = jListListaCanciones.getSelectedIndex();

                String nombreCancionSeleccionada = (String) jListListaCanciones.getSelectedValue();

                System.out.println("Eliminar: " + indiceSeleccionado);

                listaCanciones.removerPrimeraConcidencia(nombreCancionSeleccionada);

                jListListaCancionesPlaylist.removeAll();

                DefaultListModel modeloListaCancionesPlaylist = new DefaultListModel();
                jListListaCancionesPlaylist.setModel(modeloListaCancionesPlaylist);
            } else {
                String nombreCancionSeleccionada = panelCancionActual.getCancion();

                listaCanciones.removerPrimeraConcidencia(nombreCancionSeleccionada);

                jListListaCancionesPlaylist.removeAll();

                DefaultListModel modeloListaCancionesPlaylist = new DefaultListModel();
                jListListaCancionesPlaylist.setModel(modeloListaCancionesPlaylist);

            }

            actualizarPanelPrincipal();
            actualizarListaCanciones();
            cambiarAModoLista();

        } else if (ae.getSource() == menuItemBorrarPlaylist) {
            limpiarPlaylist();
        } else if (ae.getSource() == menuItemModificar) {
            modificarCancion();
            actualizarPanelPrincipal();
            actualizarListaCanciones();
            cambiarAModoLista();
            System.out.println("Se desea modificar");
        }
        
        actualizarListaCanciones();

    }

    public void limpiarPlaylist() {
        jListListaCancionesPlaylist.removeAll();
        DefaultListModel modeloListaCancionesPlaylist = new DefaultListModel();
        jListListaCancionesPlaylist.setModel(modeloListaCancionesPlaylist);
        finalizarReproduccion();
    }
}
