package com.mycompany.reproductor.models;

public class Usuario {
    /**
     * clase usuario, almacena la informacion de los usuarios
     */
    private String nombreCompleto;
    private String correoElectronico;
    private String provincia;
    private String contrasena;
    public static Usuario primero = null;
    public static Usuario ultimo = null;
    public Usuario siguiente = null;
    
    public Usuario(String nombreCompleto, String correoElectronico, String provincia, String contrasena) {
        /**
         * constructor de usuarios, guarda la informacion y lo agrega a una lista simple
         * 
         * @param nombreCompleto nombre completo del usuario
         * @param correoElectronico correo electrico del usuario
         * @param provincia provincia del usuario
         * @param contrasena contrasena del usuario para ingresar a la aplicacion
         * 
         */
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.provincia = provincia;
        this.contrasena = contrasena;
        this.siguiente = null;
        if(primero == null){
            primero = this;
            ultimo = this;
        }
        else{
            ultimo.siguiente = this;
            ultimo = this;
        }
    }
    
    //getters y setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
