package com.mycompany.reproductor.models;

import java.time.LocalDateTime;

public class Biblioteca {
    /**
     * clase biblioteca, maneja todas las bibliotecas y albergan la lista doble circular de las canciones
     */
    
    private Usuario usuario;
    private String nombre;
    private int nCanciones;
    private LocalDateTime fechaCreacion;
    public static Biblioteca primera = null;
    public static Biblioteca ultima = null;
    public Biblioteca siguiente;
    
    public static Playlist primerCancion = null;
    public static Playlist ultimaCancion = null;
    
    public Biblioteca(Usuario usuario, String nombre) {
        /**
         * constructor de biblioteca, crea una biblioteca nueva sin canciones y la agrega a una lista simple
         * 
         * @param usuario usuario que crea la biblioteca
         * @param nombre nombre de la biblioteca
         * 
         * @see Usuario
         */
        this.usuario = usuario;
        this.nombre = nombre;
        this.fechaCreacion = LocalDateTime.now();
        this.nCanciones = 0;
        this.siguiente = null;
        if(primera == null){
            primera = this;
            ultima = this;
        }
        else{
            ultima.siguiente = this;
            this.siguiente = null;
            ultima = this;
        }
    }
    
    public void agregarCancion(Playlist cancion){
        /**
         * agrega cancion a la playlist de la biblioteca, la playlist es una lista 
         * doble circular
         * 
         * @param cancion cancion a agregar a la playlist
         * 
         * @see Playlist
         */
        if(primerCancion == null){
            this.primerCancion = cancion;
            this.ultimaCancion = cancion;
            this.primerCancion.siguiente = ultimaCancion;
            this.ultimaCancion.siguiente = primerCancion;
            this.primerCancion.anterior = ultimaCancion;
            this.ultimaCancion.anterior = primerCancion;
        }
        else{
            cancion.anterior = ultimaCancion;
            cancion.siguiente = this.primerCancion;
            primerCancion.anterior = cancion;
            this.ultimaCancion.siguiente = cancion;
            this.ultimaCancion = cancion;
        }
    }
    
    public void eliminarCancion(Playlist cancion){
        /**
         * elimina una cancion de la playlist 
         * 
         * @param cancion cancion a eliminar
         * 
         * @see Playlist
         */
        Playlist aux = primerCancion.siguiente;
        Playlist anterior = primerCancion;
        if(cancion == primerCancion){
            ultimaCancion.siguiente = primerCancion.siguiente;
            primerCancion = primerCancion.siguiente;
            return;
        }
        while(aux != null){
            if(aux == cancion){
                anterior.siguiente = aux.siguiente;
                aux = aux.siguiente;
                break;
            }
            aux = aux.siguiente;
        }
    }
    
    public void eliminarBiblioteca(Biblioteca biblioteca){
        /**
         * eliminar una biblioteca, se elimina de la lista simple
         * 
         * @param biblioteca bilioteca a eliminar
         * 
         * @see Biblioteca
         */
        Biblioteca aux = primera;
        Biblioteca anterior = null;
        while(aux != null){
            if(primera == biblioteca){
                primera = primera.siguiente;
                break;
            }
            else if(aux == biblioteca){
                anterior.siguiente = aux.siguiente;
                aux = null;
                break;
            }
            else{
                anterior = aux;
                aux = aux.siguiente;
            }
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getnCanciones() {
        return nCanciones;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setnCanciones(int nCanciones) {
        this.nCanciones = nCanciones;
    }
    
    
}
