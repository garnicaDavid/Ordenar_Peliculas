//Clase Pelicula.
package Entidades;

//Declaramos los atributos que tendrá la pelicula en privado.
public class Pelicula {
    private String titulo;
    private String director;
    private String hora;
//Metodos constructores.
    public Pelicula() {
    }
    public Pelicula(String titulo, String director, String hora){
    this.titulo = titulo;
    this.director = director;
    this.hora = hora;
    }
//Metodos getters y setters para acceder a los atributos privado.
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
    //Cada vez que mostremos la pelicula que creamos, tendrá
    //este formato, Titulo, Director y Hora.
    @Override
    public String toString() {
        return "Pelicula{" + "Titulo= " + titulo + ", Director= " + director + ", hora= " + hora + '}';
    }
    
}
