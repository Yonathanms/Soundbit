package views;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mycompany.reproductor.Reproductor;
import com.mycompany.reproductor.models.Biblioteca;
import com.mycompany.reproductor.models.Cancion;
import com.mycompany.reproductor.models.MP3Player;
import com.mycompany.reproductor.models.Playlist;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled. *;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicReproducer extends javax.swing.JFrame{
    /**
     * reproductor de musica, muestra las canciones de la bilioteca y las reproduce 
     */
    public static Biblioteca playlist;
    private JPanel panel;
    private ArrayList<JButton> botones = new ArrayList<>();
    private boolean first = true;
    private FileInputStream actualSongFile = null;
    private Playlist actualSong = null;
    private MP3Player player;
    
    public MusicReproducer(Biblioteca playlist) throws IOException, UnsupportedAudioFileException, LineUnavailableException, JavaLayerException{
        /**
         * constructor del reproductor, incializa las variables del JFrame
         * 
         * @param playlist playlist que se desea empezar a reproducir
         * 
         * @see Biblioteca
         */
        this.playlist = playlist;
        panel = new JPanel();
        panel.setBounds(1,52,400,150);
        add(panel);
        initComponents();
        jLabel2.setText(playlist.getNombre());
        cargarCanciones();
        if(this.playlist.primerCancion != null){
            actualSong = this.playlist.primerCancion;
            actualSongFile = new FileInputStream(actualSong.getPath());
            player = new MP3Player(actualSongFile);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        plaBtn = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        agregarCancionBtn = new javax.swing.JButton();
        favsBtn = new javax.swing.JButton();
        atrasBtn1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        volumenArriba = new javax.swing.JButton();
        volumenAbajo = new javax.swing.JButton();
        pauseBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Biblioteca: ");

        plaBtn.setText("Play");
        plaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plaBtnMouseClicked(evt);
            }
        });

        anterior.setText("Anterior");
        anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anteriorMouseClicked(evt);
            }
        });

        siguiente.setText("Siguiente");
        siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siguienteMouseClicked(evt);
            }
        });

        agregarCancionBtn.setText("Agregar canción");
        agregarCancionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarCancionBtnMouseClicked(evt);
            }
        });

        favsBtn.setText("Favoritas");
        favsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favsBtnMouseClicked(evt);
            }
        });

        atrasBtn1.setText("Atrás");
        atrasBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasBtn1MouseClicked(evt);
            }
        });

        jLabel2.setText("jLabel2");

        volumenArriba.setText("Volumen arriba");

        volumenAbajo.setText("Volumen abajo");

        pauseBtn.setText("Pausa");
        pauseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(atrasBtn1)
                        .addGap(368, 368, 368))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pauseBtn)
                            .addComponent(plaBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(siguiente)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(favsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volumenArriba)
                    .addComponent(volumenAbajo)
                    .addComponent(agregarCancionBtn))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(agregarCancionBtn)
                    .addComponent(favsBtn)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addComponent(volumenArriba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anterior)
                            .addComponent(siguiente)
                            .addComponent(volumenAbajo))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(plaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pauseBtn)
                        .addGap(19, 19, 19)))
                .addComponent(atrasBtn1)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cargarCanciones() throws FileNotFoundException, IOException{
        /**
         * carga las canciones del xml a la playlist actual, solo se cargan las que pertenecen
         * a la biblioteca actual
         * tambien despliega las canciones en la interfaz en forma de botones
         */
        try{
            this.playlist.primerCancion = null;
            ObjectMapper mapper = new XmlMapper();
            InputStream inputStream = new FileInputStream(new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\canciones.xml"));
            TypeReference<ArrayList<Cancion>> typeReference = new TypeReference<ArrayList<Cancion>>() {};
            ArrayList<Cancion> canciones = mapper.readValue(inputStream, typeReference);
            Playlist play;
            for(Cancion song : canciones){
                if(song.getNombreBiblioteca().equals(this.playlist.getNombre())){
                    play = new Playlist();
                    play.setNombreBiblioteca(this.playlist.getNombre());
                    play.setTitulo(song.getTitulo());
                    play.setArtista(song.getArtista());
                    play.setGenero(song.getGenero());
                    play.setAlbum(song.getAlbum());
                    play.setAnio(song.getAnio());
                    play.setFavorita(song.isFavorita());
                    play.setPath(song.getPath());
                    this.playlist.agregarCancion(play);
                    if(first){
                        JButton boton = new JButton(song.getTitulo());
                        boton.addActionListener(e -> songButtonPressed(boton, this.playlist));
                        panel.add(boton);
                        panel.validate();
                        panel.repaint();
                        botones.add(boton);
                    }
                }
            }
            inputStream.close();
            actualSong = this.playlist.primerCancion;
            actualSongFile = new FileInputStream(actualSong.getPath());
            player = new MP3Player(actualSongFile);
            first= false;
        }
        catch(Exception e){
            e.printStackTrace();
            }
        }
    
    private void agregarCancionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarCancionBtnMouseClicked
        /**
         * agrega una canciona la bilioteca, abre el gestor de archivos para que 
         * el usuario elija el archivo
         */
        final JFileChooser fc = new JFileChooser(); 
        int returnVal = fc.showOpenDialog(this);
        File file = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            
        } else {
            System.out.println("Open command cancelled by user.");
        }
        System.out.println(returnVal);
        try {

            InputStream input = new FileInputStream(file);
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            String titulo = metadata.get("title");
            String artista = metadata.get("xmpDM:artist");
            String genero = metadata.get("xmpDM:genre");
            String album = metadata.get("xmpDM:album");
            int release = Integer.parseInt(metadata.get("xmpDM:releaseDate"));
            
            Cancion cancion = new Cancion();
            cancion.setNombreBiblioteca(this.playlist.getNombre());
            cancion.setTitulo(titulo);
            cancion.setArtista(artista);
            cancion.setGenero(genero);
            cancion.setAlbum(album);
            cancion.setAnio(release);
            cancion.setFavorita(false);
            cancion.setPath(file.getAbsolutePath());
            JButton boton = new JButton(cancion.getTitulo());
            boton.addActionListener(e -> songButtonPressed(boton, this.playlist));
            panel.add(boton);
            panel.validate();
            panel.repaint();
            botones.add(boton);
            cargarAlXML(cancion);
            
            cargarCanciones();
            
        } catch (FileNotFoundException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        } catch (SAXException e) {
        e.printStackTrace();
        } catch (TikaException e) {
        e.printStackTrace();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MusicReproducer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(MusicReproducer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_agregarCancionBtnMouseClicked

    private void favsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favsBtnMouseClicked
        /**
         * navega hacia las canciones favoritas
         */
        this.setVisible(false);
        
        Favoritas favs = null;
        try {
            favs = new Favoritas(this.playlist);
        } catch (IOException ex) {
            Logger.getLogger(MusicReproducer.class.getName()).log(Level.SEVERE, null, ex);
        }
        favs.setVisible(true);
        
    }//GEN-LAST:event_favsBtnMouseClicked

    private void atrasBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasBtn1MouseClicked
        this.setVisible(false);
        Reproductor.menuBiblioteca.setVisible(true);
        
    }//GEN-LAST:event_atrasBtn1MouseClicked

    private void plaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plaBtnMouseClicked
        /**
         * reproduce una cancion
         */
        player = new MP3Player(actualSongFile);
        player.start();
    }//GEN-LAST:event_plaBtnMouseClicked

    private void pauseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseBtnMouseClicked
        /**
         * pausa una cancion
         */
        player.stop();
    }//GEN-LAST:event_pauseBtnMouseClicked

    private void siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseClicked
        /**
         * va hacia la siguiente cancion en la lista
         */
        player.stop();
        actualSong = actualSong.siguiente;
        try {
            actualSongFile = new FileInputStream(actualSong.getPath());
            player = new MP3Player(actualSongFile);
            player.start();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MusicReproducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_siguienteMouseClicked

    private void anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorMouseClicked
        /**
         * va a la cancion anterior en la lista
         */
        player.stop();
        actualSong = actualSong.anterior;
        try {
            actualSongFile = new FileInputStream(actualSong.getPath());
            player = new MP3Player(actualSongFile);
            player.start();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MusicReproducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_anteriorMouseClicked

    public void cargarAlXML(Cancion cancion) throws SAXException, IOException, ParserConfigurationException, TransformerException{
        /**
         * carga una nueva cancion en el xml para guardar su registro
         * 
         * @param cancion nueva cancion
         * 
         * @see Cancion
         */
        File xmlFile = new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\canciones.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        Element documentElement = document.getDocumentElement();
        Element textNode = document.createElement("nombreBiblioteca");
        textNode.setTextContent(cancion.getNombreBiblioteca());
        Element textNode1 = document.createElement("titulo");
        textNode1.setTextContent(cancion.getTitulo());
        Element textNode2 = document.createElement("genero");
        textNode2.setTextContent(cancion.getGenero());
        Element nodeElement = document.createElement("cancion");
        Element textNode3 = document.createElement("artista");
        textNode3.setTextContent(cancion.getArtista());
        Element textNode4 = document.createElement("album");
        textNode4.setTextContent(cancion.getAlbum());
        Element textNode5 = document.createElement("anio");
        textNode5.setTextContent(String.valueOf(cancion.getAnio()));
        Element textNode6 = document.createElement("path");
        textNode6.setTextContent(cancion.getPath());
        Element textNode7 = document.createElement("favorita");
        textNode7.setTextContent(String.valueOf(cancion.isFavorita()));
        nodeElement.appendChild(textNode);
        nodeElement.appendChild(textNode1);
        nodeElement.appendChild(textNode2);
        nodeElement.appendChild(textNode3);
        nodeElement.appendChild(textNode4);
        nodeElement.appendChild(textNode5);
        nodeElement.appendChild(textNode6);
        nodeElement.appendChild(textNode7);
        documentElement.appendChild(nodeElement);
        document.replaceChild(documentElement, documentElement);
        Transformer tFormer =
        TransformerFactory.newInstance().newTransformer();
        tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
        Source source = new DOMSource(document);
        Result result = new StreamResult(xmlFile);
        tFormer.transform(source, result);
    }
    
    public void songButtonPressed(JButton boton, Biblioteca bib){
        /**
         * accion que sucede al presionar una cancion, se navega hacia una nueva ventana para 
         * desplegar sus datos
         */
        String nombre = boton.getText();
        Playlist cancion = this.playlist.primerCancion;
        while(cancion != null){
            if(cancion.getTitulo().equals(nombre)){
                VerCancion ver = new VerCancion(cancion, bib);
                ver.setVisible(true);
                this.setVisible(false);
                break;
            }
            cancion = cancion.siguiente;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCancionBtn;
    private javax.swing.JButton anterior;
    private javax.swing.JButton atrasBtn1;
    private javax.swing.JButton favsBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton pauseBtn;
    private javax.swing.JButton plaBtn;
    private javax.swing.JButton siguiente;
    private javax.swing.JButton volumenAbajo;
    private javax.swing.JButton volumenArriba;
    // End of variables declaration//GEN-END:variables

}
