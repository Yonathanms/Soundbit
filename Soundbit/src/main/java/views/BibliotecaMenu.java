package views;

import com.mycompany.reproductor.Reproductor;
import com.mycompany.reproductor.models.Biblioteca;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javazoom.jl.decoder.JavaLayerException;

public class BibliotecaMenu extends javax.swing.JFrame{
    /**
     * menu de bilbiotecas, despliega las bibliotecas del usuario
    */
    
    private JPanel panel;
    private ArrayList<JButton> botones = new ArrayList<>();
    public BibliotecaMenu() {
        /**
         * constructor, inicializa los componentes del JFrame y carga las bibliotecas en la interfaz
         */
        initComponents();
        cargarBibliotecas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agregarBBtn = new javax.swing.JButton();
        eliminarBiblioteca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        agregarBBtn.setText("Agregar biblioteca");
        agregarBBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarBBtnMouseClicked(evt);
            }
        });

        eliminarBiblioteca.setText("Eliminar biblioteca");
        eliminarBiblioteca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarBibliotecaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(agregarBBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminarBiblioteca)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarBBtn)
                    .addComponent(eliminarBiblioteca))
                .addContainerGap(271, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void cargarBibliotecas(){
        /**
         * carga las bibliotecas en la interfaz grafica, recorre las bibliotecas del usuario
         * y crea n botones con los nombres de las bibliotecas
         */
        panel = new JPanel();
        panel.setBounds(1,100,500,500);
        add(panel);
        Biblioteca biblioteca = Reproductor.bibliotecas.primera;
        while(biblioteca != null){
            JButton boton = new JButton("<html> Usuario: " + Reproductor.activo.getNombreCompleto() + "<br/>Nombre: " +
                                        biblioteca.getNombre() + "<br/>Número de canciones: " + String.valueOf(biblioteca.getnCanciones() +
                                        "</html>"));
            boton.addActionListener(e -> {
                try {
                    buttonPressed(boton);
                } catch (IOException ex) {
                    Logger.getLogger(BibliotecaMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(BibliotecaMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(BibliotecaMenu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JavaLayerException ex) {
                    Logger.getLogger(BibliotecaMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            panel.add(boton);
            panel.validate();
            panel.repaint();
            botones.add(boton);
            biblioteca = biblioteca.siguiente;
        }
    }
    
    static void buttonPressed(JButton boton) throws IOException, UnsupportedAudioFileException, LineUnavailableException, JavaLayerException{
        /**
         * accion que se realiza al presionar una biblioteca
         * se accede al nombre de la bilbioteca y se va a las canciones que esta contiene
         */
        Biblioteca biblioteca = Reproductor.bibliotecas.primera;
        Reproductor.menuBiblioteca.setVisible(false);
        while(biblioteca != null){
            if(boton.getText().contains(biblioteca.getNombre())){
                MusicReproducer rep = new MusicReproducer(biblioteca);
                rep.setVisible(true);   
            }
            biblioteca = biblioteca.siguiente;
        }
        
    }
    
    private void agregarBBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarBBtnMouseClicked
        /**
         * agrega una biblioteca a la lista de bibliotecas, tambien se agrega a la interfaz
         */
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la nueva biblioteca");    
        Biblioteca nueva = new Biblioteca(Reproductor.activo, nombre);
        Reproductor.guardarBibliotecas(nueva);
        JButton boton = new JButton("<html> Usuario: " + Reproductor.activo.getNombreCompleto() + "<br/>Nombre: " +
                                        nueva.getNombre() + "<br/>Número de canciones: " + String.valueOf(nueva.getnCanciones() +
                                        "</html>"));
        panel.add(boton);
        panel.validate();
        botones.add(boton);
        panel.repaint();
    }//GEN-LAST:event_agregarBBtnMouseClicked

    private void eliminarBibliotecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarBibliotecaMouseClicked
        /**
         * elimina una biblioteca de la lista de bibliotecas y tambien de la interfaz
         */
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la nueva biblioteca");    
        Biblioteca eliminar = Reproductor.bibliotecas.primera;
        while(eliminar != null){
            if(eliminar.getNombre().equals(nombre)){
                break;
            }else{
                eliminar = eliminar.siguiente;
            }
        }
        eliminar.eliminarBiblioteca(eliminar);
        for(JButton boton : botones){
            if(boton.getText().contains(nombre)){
                panel.remove(boton);
                panel.validate();
                panel.repaint();
            }
        }
        Reproductor.guardarBibliotecas();
    }//GEN-LAST:event_eliminarBibliotecaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBBtn;
    private javax.swing.JButton eliminarBiblioteca;
    // End of variables declaration//GEN-END:variables

}
