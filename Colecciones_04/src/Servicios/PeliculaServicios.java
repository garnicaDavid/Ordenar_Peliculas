/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Pelicula;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class PeliculaServicios {
    
    static Scanner input = new Scanner(System.in).useDelimiter("\n");
    
    //Creamos la pelicula con su Titulo, Director y duración en horas.
    public Pelicula crearPelicula(){
        Pelicula peli = new Pelicula();
    boolean trueFalse = false;
        System.out.print("Titulo : ");
        peli.setTitulo(input.next());
        System.out.print("Director : ");
        peli.setDirector(input.next());
        System.out.print("Duración en Horas (0,0,0) : ");
        String hora = input.next();
        //Le damos un formato en horas 00:00:00
        peli.setHora(formatoHora(hora));
    return peli;
    }
    
    
    //Metodo de poner las peliculas de 1 hora en adelante.
    public ArrayList<Pelicula> peliculasUnaHora(ArrayList<Pelicula> peliculas){
    ArrayList<Pelicula> peliculaUnaHora = new ArrayList();
    for(int i=0;i<peliculas.size();i++){
        int num = Integer.parseInt((peliculas.get(i).getHora()).substring(0, 2));
        if(num>=1){
            peliculaUnaHora.add(peliculas.get(i));
        }
    }
        return peliculaUnaHora;
    }
    //Ordenar las pelicuals de Mayor a Menor.
    public ArrayList<Pelicula> peliculasHoraMayorMenor(ArrayList<Pelicula> peliculas){
    for(int i=0;i<peliculas.size();i++){
        for(int j=0;j<peliculas.size()-1;j++){
            peliculas = ordenamientoBurbuja(i,j,peliculas.get(j+1).getHora(),peliculas.get(j).getHora(), peliculas);
        }
    }
        return peliculas;
    }
    public ArrayList<Pelicula> peliculasHoraMenorMayor(ArrayList<Pelicula> peliculas){
    for(int i=0;i<peliculas.size();i++){
        for(int j=0;j<peliculas.size()-1;j++){
            peliculas = ordenamientoBurbuja(i,j,peliculas.get(j).getHora(),peliculas.get(j+1).getHora(), peliculas);
        }
    }
        return peliculas;
    }
    public ArrayList<Pelicula> peliculasTituloOrdenado(ArrayList<Pelicula> peliculas){
        for(int i=0;i<peliculas.size();i++){
        for(int j=0;j<peliculas.size()-1;j++){
            peliculas = ordenamientoBurbuja(i,j,peliculas.get(j).getTitulo(),peliculas.get(j+1).getTitulo(), peliculas);
        }
    }
    
        return peliculas;
    }
    public ArrayList<Pelicula> peliculasDirectorOrdenado(ArrayList<Pelicula> peliculas){
        for(int i=0;i<peliculas.size();i++){
        for(int j=0;j<peliculas.size()-1;j++){
            peliculas = ordenamientoBurbuja(i,j,peliculas.get(j).getDirector(),peliculas.get(j+1).getDirector(), peliculas);
        }
    }
        return peliculas;
    }
    
    //Metodo de ordenamiento burbuja, es ordenar un array! ya sea de menor a mayor o Mayor a menor.
    public ArrayList<Pelicula> ordenamientoBurbuja(int i, int j,String uno, String dos, ArrayList<Pelicula> peliculas){
            if(uno.compareToIgnoreCase(dos)>0){
             Pelicula auxiliar = peliculas.get(j);
             peliculas.set(j, peliculas.get(j+1));
             peliculas.set(j+1,auxiliar);
            }
        
    return peliculas;
    }
    
    public void mostrarPantalla(ArrayList<Pelicula> peliculas){
    Iterator <Pelicula> lista = peliculas.iterator();
        while(lista.hasNext()){
            Pelicula indexPeli = lista.next();
            System.out.println(indexPeli);
    }
    }
    
    public boolean menu(ArrayList<Pelicula> peliculas){
    boolean trueFalse = true;
        System.out.println("------- MENU ------");
        System.out.println("A) Películas con una duración mayor a 1 hora.");
        System.out.println("B) Ordenar las películas por Hora (de mayor a menor)");
        System.out.println("C) Ordenar las películas por Hora (de menor a mayor)");
        System.out.println("D) Ordenar las películas por Titulo, alfabéticamente");
        System.out.println("E) Ordenar las películas por Director, alfabéticamente");
        System.out.println("F) SALIR.");
        System.out.print("Ingrese una opción : ");
        String respuesta = input.next();
        switch(respuesta){
            case "A" :
            case "a" : mostrarPantalla(peliculasUnaHora(peliculas));
                       break;
            case "B" :
            case "b" : mostrarPantalla(peliculasHoraMayorMenor(peliculas));
                       break;
            case "C" :
            case "c" : mostrarPantalla(peliculasHoraMenorMayor(peliculas));
                       break;
            case "D" :
            case "d" : mostrarPantalla(peliculasTituloOrdenado(peliculas));
                       break;
            case "E" :
            case "e" : mostrarPantalla(peliculasDirectorOrdenado(peliculas));
                       break;
            case "F" :
            case "f" : trueFalse = false;
                       break;
            default : System.out.println("Error, vuelva a intentar.");
        }
        return trueFalse;
    }
    
    
    
    public static String formatoHora(String hora){
    DecimalFormat dc = new DecimalFormat("00.#");
    String formato="";
    //Recibimos la hora con un formato de (1,3,56) o (1.3.56) y lo cambiamos a (01:03:56)
    if(hora.contains(".") || hora.contains(":") || hora.contains(" ")){
    hora = hora.replaceAll("\\.", ",");
    hora = hora.replaceAll(":", ",");
    hora = hora.replaceAll(" ", ",");
    }
        
    if(hora.contains(",")){
    String horaFormato[] = hora.split(",");
        //Controlamos la equivalencia de segundo a minuto y minuto a horas (01:08:62 a 01:09:02).
        for(int i=(horaFormato.length-1);i>0;i--){
        int num = Integer.parseInt(horaFormato[i]);
            if(num>59){
            horaFormato[i-1] = String.valueOf((Integer.parseInt(horaFormato[i-1]))+1);
            horaFormato[i] = String.valueOf(num-60);
            }
        }
        //retornamos el formato de la hora
        for(int i=0;i<horaFormato.length;i++){
             horaFormato[i] = dc.format(Integer.parseInt(horaFormato[i]));
               if((i+1)==horaFormato.length){
                   if(horaFormato.length==2 &&((i+1)==horaFormato.length)){
                    formato += horaFormato[i]+":00";
                    } else {
                   formato += horaFormato[i];
                   }
               } else {
               formato += horaFormato[i]+":";
               }
              }
          return formato;
    }
    //Si existe o no existe un valor usamos isEmpty.
    if(!(hora.isEmpty())){
        if(Integer.parseInt(hora)>=0){
        formato = dc.format(Integer.parseInt(hora))+":00:00";
        return formato;
    }
    }
    return formato = "00:00:00";
    }
    
    
    
}
