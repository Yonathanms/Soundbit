package views;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mycompany.reproductor.models.Biblioteca;
import com.mycompany.reproductor.models.Cancion;
import com.mycompany.reproductor.models.Playlist;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javazoom.jl.decoder.JavaLayerException;

public class Favoritas extends javax.swing.JFrame {

    Biblioteca playlist;
    JPanel panel;
    
    public Favoritas(Biblioteca playlist) throws IOException {
        /**
         * interfaz que muesta las canciones favoritas del usuario
         * 
         * @param playlist playlist del usuario a la que se quiere acceder a sus favoritas
         */
        initComponents();
        this.playlist = playlist;
        panel = new JPanel();
        panel.setBounds(1,52,400,150);
        add(panel);
        cargarFavoritas();
    }

    public void cargarFavoritas() throws FileNotFoundException, IOException{
        /**
         * funcion para mostrar todas las canciones favoritas de la playlist
         */
        this.playlist.primerCancion = null;
        ObjectMapper mapper = new XmlMapper();
        InputStream inputStream = new FileInputStream(new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\canciones.xml"));
        TypeReference<ArrayList<Cancion>> typeReference = new TypeReference<ArrayList<Cancion>>() {};
        ArrayList<Cancion> canciones = mapper.readValue(inputStream, typeReference);
        for(Cancion song : canciones){
            if(song.getNombreBiblioteca().equals(this.playlist.getNombre()) && song.isFavorita()){
                JButton boton = new JButton(song.getTitulo());
                panel.add(boton);
                panel.validate();
                panel.repaint(); 
            }
        }
        inputStream.close();
    }    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atrasBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        atrasBtn.setText("Atrás");
        atrasBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atrasBtn)
                .addContainerGap(322, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(332, Short.MAX_VALUE)
                .addComponent(atrasBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasBtnMouseClicked
        this.setVisible(false);
        try {
            MusicReproducer mr = new MusicReproducer(this.playlist);
            mr.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Favoritas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Favoritas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Favoritas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            Logger.getLogger(Favoritas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_atrasBtnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasBtn;
    // End of variables declaration//GEN-END:variables
}
