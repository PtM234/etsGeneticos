/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maximo;

import java.util.Random;

/**
 *
 * @author Alumno
 */
public class Seleccion {
    public static Individuo seleccionPorTorneo(Poblacion pob){
        Individuo e = new Individuo (pob.getMejor().getGenotipo());
        return e;
    }
    
    public static Individuo seleccionAleatoria(Poblacion pob){
        Random ran = new Random();
        Individuo e = new Individuo (pob.poblacion.get(ran.nextInt(pob.poblacion.size())).getGenotipo());
        return e;
    }
}
