package com.mycompany.reproductor;

import com.mycompany.reproductor.models.Biblioteca;
import com.mycompany.reproductor.models.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import views.BibliotecaMenu;
import views.Inicio;
import views.InicioSesion;
import views.Registro;

/**
 * clase principal, maneja la informacion de la aplicacion e inicia el flujo de secuencia
 */
public class Reproductor {
    public static Inicio inicio = new Inicio();
    public static Registro registro = new Registro();
    public static InicioSesion inicioSesion = new InicioSesion();
    public static Usuario usuario = null;
    public static Usuario activo = null;
    public static Biblioteca bibliotecas = null;
    public static BibliotecaMenu menuBiblioteca = null;
    
    public static void main(String[] args) {
        inicio.setVisible(true);
        cargarUsuarios();
        usuario = usuario.primero;
        System.out.print(usuario.getCorreoElectronico());
    }
    
    public static void guardarUsuario(Usuario usuario){
        /**
         * funcion para guardar un usuario en el archivo txt 
         * 
         * @param usuario el nuevo usuario a guardar
         * 
         * @see Usuario
         */
        File file = new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\usuarios.txt");
 
        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write("\n" + usuario.getNombreCompleto() + "," + usuario.getCorreoElectronico() + "," + usuario.getProvincia() + "," + usuario.getContrasena());
                bw.close();
            }
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        cargarUsuarios();
    }
    
    public static void cargarUsuarios(){
        /**
         * funcion para cargar los usuarios, toma el archivo donde se encuentran y se cargan dentro
         * de una lista simple
         */
        Reproductor.usuario = null;
        
        File file = new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\usuarios.txt");
 
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                String[] data;
                while ((line = br.readLine()) != null) {
                    data = line.split(",");
                    Reproductor.usuario = new Usuario(data[0], data[1], data[2], data[3]); 
                }
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void cargarBibliotecas(){
        /**
         * carga las bibliotecas desde el archivo de texto hacia una lista simple de la aplicacion
         */
        Reproductor.bibliotecas = null;
        
        File file = new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\bibliotecas.txt");
 
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                String[] data;
                while ((line = br.readLine()) != null) {
                    data = line.split(",");
                    if(data[0].equals(Reproductor.activo.getCorreoElectronico())){
                        Reproductor.bibliotecas = new Biblioteca(activo, data[1]); 
                    }
                    
                }
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void guardarBibliotecas(Biblioteca nueva){
        /**
         * guarda una biblioteca nueva en el archivo de texto que controla el registro de las mismas
         * 
         * @param nueva bilbioteca nueva a guardar
         * 
         * @see Biblioteca
         */
        File file = new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\bibliotecas.txt");
 
        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(activo.getCorreoElectronico()+ "," + nueva.getNombre() + "\n");
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        cargarBibliotecas();
    }
    
    public static void guardarBibliotecas(){
        /**
         * guarda las bilbiotecas en la lista simple en el archivo de texto que maneja su registro
         */
        File file = new File("C:\\Users\\yonathanms146\\Desktop\\proyecto datos\\Soundbit\\Soundbit\\src\\main\\java\\data\\bibliotecas.txt");
 
        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
                Biblioteca aux = bibliotecas.primera;
                while(aux != null){
                    bw.write(activo.getCorreoElectronico()+ "," + aux.getNombre() + "\n");
                    aux = aux.siguiente;
                }
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
