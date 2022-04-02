/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author David
 */
public class Pelicula {
    private String titulo;
    private String director;
    private String hora;

    public Pelicula() {
    }
    
    public Pelicula(String titulo, String director, String hora){
    this.titulo = titulo;
    this.director = director;
    this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "Titulo= " + titulo + ", Director= " + director + ", hora= " + hora + '}';
    }
    
}
