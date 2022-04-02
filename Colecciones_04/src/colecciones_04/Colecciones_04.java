/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones_04;

import Entidades.Pelicula;
import Servicios.PeliculaServicios;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para
esto, tendremos una clase Pelicula con el titulo, director y duración de la película (en
horas). Implemente las clases y métodos necesarios para esta situación, teniendo en
cuenta lo que se pide a continuación:
* 
En el main deberemos tener un bucle que crea un objeto Pelicula pidiéndole al
usuario todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si
quiere crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:
• Mostrar en pantalla todas las películas.
• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo
en pantalla.
• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo
en pantalla.
• Ordenar las películas por titulo, alfabéticamente y mostrarlo en pantalla.
• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 * @author David
 */
public class Colecciones_04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    PeliculaServicios servicio = new PeliculaServicios();
    ArrayList<Pelicula> listaPeliculas = new ArrayList();
    boolean trueFalse = true;
    int cantidadPeliculas = 0;
    //Creamos la pelicula y agregamos a la lista de peliculas.
    while(trueFalse){
        cantidadPeliculas++;
        System.out.println("Creando pelicula N° "+cantidadPeliculas+" :");
        listaPeliculas.add(servicio.crearPelicula());
        
        System.out.println("¿Quiere agregar otra pelicula? (s/n) : ");
        String respuesta = input.next();
        if(!(respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("s"))){
            trueFalse = false;
        }
    }
    
    //Muestro la lista de peliculas.
    Iterator<Pelicula> it = listaPeliculas.iterator();
    while(it.hasNext()){
    Pelicula indexPeli = it.next();
        System.out.println(indexPeli);
    }
    
    //Voy al menu para ordenar de mayor a menor.
    while(!trueFalse){
        trueFalse = !(servicio.menu(listaPeliculas));
    }
    }
    
    
}
