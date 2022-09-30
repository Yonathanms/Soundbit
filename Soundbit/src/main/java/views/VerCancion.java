package views;
import com.mycompany.reproductor.models.Biblioteca;
import com.mycompany.reproductor.models.Playlist;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javazoom.jl.decoder.JavaLayerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class VerCancion extends javax.swing.JFrame {
    /**
     * interfaz para modificar la metadata de una cancion
     */
    
    Biblioteca bib;
    Playlist cancion;
    public VerCancion(Playlist cancion, Biblioteca bib) {
        
        /**
         * crea una nueva interfaz de la cancion, carga su metadata y la muestra en textos
         * 
         * @param cancion cancion de la que se quiere ver la metadata
         * @param bib biblioteca a la que pertenece
         * 
         * @see Playlist
         * @see Biblioteca
         */
        
        initComponents();
        this.bib = bib;
        this.cancion = cancion;
        titulo.setText(cancion.getTitulo());
        anio.setText(String.valueOf(cancion.getAnio()));
        genero.setText(cancion.getGenero());
        artista.setText(cancion.getArtista());
        album.setText(cancion.getAlbum());
        if(cancion.isFavorita()){
            agregarFavs.setVisible(false);
            eliminarFavs.setVisible(true);
        }else{
            eliminarFavs.setVisible(false);
            agregarFavs.setVisible(true);
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agregarFavs = new javax.swing.JButton();
        eliminarCancion = new javax.swing.JButton();
        text = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        text1 = new javax.swing.JLabel();
        genero = new javax.swing.JTextField();
        text2 = new javax.swing.JLabel();
        artista = new javax.swing.JTextField();
        text3 = new javax.swing.JLabel();
        album = new javax.swing.JTextField();
        text4 = new javax.swing.JLabel();
        anio = new javax.swing.JTextField();
        atrasBtn = new javax.swing.JButton();
        eliminarFavs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        agregarFavs.setText("Agregar a favoritas");
        agregarFavs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarFavsMouseClicked(evt);
            }
        });

        eliminarCancion.setText("Eliminar de la bilioteca");
        eliminarCancion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarCancionMouseClicked(evt);
            }
        });

        text.setText("Título");

        text1.setText("Género");

        text2.setText("Artista");

        text3.setText("Álbum");

        text4.setText("Año");

        atrasBtn.setText("Atrás");
        atrasBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasBtnMouseClicked(evt);
            }
        });

        eliminarFavs.setText("Eliminar de favoritas");
        eliminarFavs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarFavsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text)
                        .addGap(28, 28, 28)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(atrasBtn)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(text4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(text3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(album, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(artista, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(text1)
                                .addGap(18, 18, 18)
                                .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(eliminarCancion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarFavs))
                    .addComponent(eliminarFavs, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarFavs)
                    .addComponent(eliminarCancion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminarFavs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text1)
                    .addComponent(genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text2)
                    .addComponent(artista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text3)
                    .addComponent(album, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text4)
                    .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(atrasBtn)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarCancionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarCancionMouseClicked
        /**
         * elimina una cancion de la biblioteca y tambien la elimina del xml
         */
        this.bib.eliminarCancion(this.cancion);
        try {
            eliminarXML();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(this,"Cancion eliminada correctamente"); 
        this.setVisible(false);
        try {
            MusicReproducer mr = new MusicReproducer(this.bib);
            mr.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_eliminarCancionMouseClicked

    private void eliminarXML() throws ParserConfigurationException, SAXException, IOException, TransformerException, XPathExpressionException{
        /**
         * elimina una cancion del xml 
         */
        File xmlFile = new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\canciones.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document = dbf.newDocumentBuilder().parse(xmlFile);

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expression = xpath.compile("//canciones/cancion[titulo/text()='" + this.cancion.getTitulo() + "']");

        Node b13Node = (Node) expression.evaluate(document, XPathConstants.NODE);
        b13Node.getParentNode().removeChild(b13Node);

        Transformer tFormer =
        TransformerFactory.newInstance().newTransformer();
        tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
        Source source = new DOMSource(document);
        Result result = new StreamResult(xmlFile);
        tFormer.transform(source, result);
    }
    
    private void atrasBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasBtnMouseClicked
        /**
         * navega hacia el reproductor y guarda la metadata de la cancion en caso de haber sido modificada
         */
        try {
            eliminarXML();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            File xmlFile = new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\canciones.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            Element documentElement = document.getDocumentElement();
            Element textNode = document.createElement("nombreBiblioteca");
            textNode.setTextContent(cancion.getNombreBiblioteca());
            Element textNode1 = document.createElement("titulo");
            textNode1.setTextContent(titulo.getText());
            Element textNode2 = document.createElement("genero");
            textNode2.setTextContent(genero.getText());
            Element nodeElement = document.createElement("cancion");
            Element textNode3 = document.createElement("artista");
            textNode3.setTextContent(artista.getText());
            Element textNode4 = document.createElement("album");
            textNode4.setTextContent(album.getText());
            Element textNode5 = document.createElement("anio");
            textNode5.setTextContent(anio.getText());
            Element textNode6 = document.createElement("path");
            textNode6.setTextContent(cancion.getPath());
            Element textNode7 = document.createElement("favorita");
            textNode7.setTextContent(String.valueOf(this.cancion.isFavorita()));
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
        catch(Exception e){
            e.printStackTrace();
        }
        this.setVisible(false);
        try {
            MusicReproducer mr = new MusicReproducer(this.bib);
            mr.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(VerCancion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_atrasBtnMouseClicked

    private void agregarFavsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarFavsMouseClicked
        /**
         * agrega una cancion a favoritas y guarda los cambios en el xml
         */
        File xmlFile = new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\canciones.xml");
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();
            XPathExpression expression = xpath.compile("//canciones/cancion[titulo/text()='" + this.cancion.getTitulo() + "']");
            
            Node b13Node = (Node) expression.evaluate(document, XPathConstants.NODE);
            
            b13Node.getParentNode().removeChild(b13Node);
            
            Transformer tFormer =
            TransformerFactory.newInstance().newTransformer();
            tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
            Source source = new DOMSource(document);
            Result result = new StreamResult(xmlFile);
            tFormer.transform(source, result);
            
            modificarFavorito();
        }catch(Exception e){
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this,"Cancion agregada a favoritas!"); 
        agregarFavs.setVisible(false);
        eliminarFavs.setVisible(true);
    }//GEN-LAST:event_agregarFavsMouseClicked

    private void eliminarFavsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarFavsMouseClicked
        /**
         * elimina una cancion de favoritos y guarda los cambios en el xml
         */
        File xmlFile = new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\canciones.xml");
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();
            XPathExpression expression = xpath.compile("//canciones/cancion[titulo/text()='" + this.cancion.getTitulo() + "']");
            
            Node b13Node = (Node) expression.evaluate(document, XPathConstants.NODE);
            
            b13Node.getParentNode().removeChild(b13Node);
            
            Transformer tFormer =
            TransformerFactory.newInstance().newTransformer();
            tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
            Source source = new DOMSource(document);
            Result result = new StreamResult(xmlFile);
            tFormer.transform(source, result);
            
            modificarFavorito();
        }catch(Exception e){
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this,"Cancion eliminada de favoritas!"); 
        agregarFavs.setVisible(true);
        eliminarFavs.setVisible(false);
    }//GEN-LAST:event_eliminarFavsMouseClicked
    
    private void modificarFavorito() throws SAXException, IOException, TransformerException, ParserConfigurationException{
        /**
         * modifica el si una cancion es favorita o no en el xml
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
        if(this.cancion.isFavorita()){
            textNode7.setTextContent(String.valueOf(false));
            this.cancion.setFavorita(false);
        }
        else{
            textNode7.setTextContent(String.valueOf(true));
            this.cancion.setFavorita(true);
        } 
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarFavs;
    private javax.swing.JTextField album;
    private javax.swing.JTextField anio;
    private javax.swing.JTextField artista;
    private javax.swing.JButton atrasBtn;
    private javax.swing.JButton eliminarCancion;
    private javax.swing.JButton eliminarFavs;
    private javax.swing.JTextField genero;
    private javax.swing.JLabel text;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    private javax.swing.JLabel text4;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
