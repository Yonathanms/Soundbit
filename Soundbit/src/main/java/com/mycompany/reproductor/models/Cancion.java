package com.mycompany.reproductor.models;

import java.io.File;

public class Cancion {
    /**
     * clase cancion, alberga la informacion que viene desde el xml 
     */
    private String nombreBiblioteca;
    private String titulo;
    private String genero;
    private String artista;
    private String album;
    private int anio;
    private String path;
    private boolean favorita;
    
    //son puros setters y getters esta clase no hace mucho solo sirve para almacenar informacion (metadata)
    
    public String getGenero() {
        return genero;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public int getAnio() {
        return anio;
    }

    public String getPath() {
        return path;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }
    
    
}
