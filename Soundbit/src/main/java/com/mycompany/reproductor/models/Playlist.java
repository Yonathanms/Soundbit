package com.mycompany.reproductor.models;

public class Playlist extends Cancion{
    /**
     * clase playlist solo contiene los punteros anterior y siguiente para hacer la lista doble
     * hereda todo de Cancion ya que almacenan los mismos datos
     */
    public Playlist siguiente;
    public Playlist anterior;  
    public Playlist() {
        /**
         * constructor de playlist, inicializa los punteros anterior y siguiente como nulos
         */
        this.siguiente = null;
        this.anterior = null;
    }
    
}
