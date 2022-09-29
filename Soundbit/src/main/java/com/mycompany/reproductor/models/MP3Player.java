package com.mycompany.reproductor.models;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MP3Player extends Thread{
    
    /**
     * clase para reproducir musica, hereda de thread para reproducir en segundo plano
     */
    
    private FileInputStream songFile;
    
    public Player player;

    public MP3Player(FileInputStream songFile) {
        /**
         * constructor, crea una nueva instancia de reproductor de mp3
         * 
         * @param songFile archivo de musica que se desea reproducir
         * 
         * @see FileInputStream
         */
        this.songFile = songFile;
    }
    
    public void run(){
        /**
         * metodo run heredado de thread, se llama al iniciar un thread
         * reproduce la cancion que se alberga en esta clase
         */
        try {
            player = new Player(songFile);
            player.play();
        } catch (JavaLayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FileInputStream getSongFile() {
        return songFile;
    }

    public void setSongFile(FileInputStream songFile) {
        this.songFile = songFile;
    }
    
    
}
