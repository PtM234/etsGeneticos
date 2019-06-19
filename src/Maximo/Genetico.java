/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maximo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alumno
 */
public class Genetico {
    
    public Poblacion pobActual;
    public int tamP, numG;
    public double probMuta;
    
    public Genetico(int tamanoPoblacion, int numeroGeneraciones, double probabilidadMuta){
        this.tamP = tamanoPoblacion;
        this.numG = numeroGeneraciones;
        this.probMuta = probabilidadMuta;
        this.pobActual = new Poblacion(tamP);
    }
    
    public void Evolucionar(){
        
        for (int x = 1 ; x < numG ; x++){
            ArrayList<Individuo> aux = new ArrayList<Individuo>();
            for(int y = 0; y < tamP; y++){
                Individuo padre = new Individuo(Seleccion.seleccionAleatoria(this.pobActual).getGenotipo());
                Individuo madre = new Individuo(Seleccion.seleccionAleatoria(this.pobActual).getGenotipo());
                
                
                Individuo mejor = new Individuo(Cruza.cruzaPorMascaraAleatoria(padre, madre).getGenotipo());
                mejor = new Individuo(Muta.muta(mejor).getGenotipo());
//                if (padre.fitness>madre.fitness){
//                    if(padre.fitness>mejor.fitness){
//                        aux.add(padre);
//                    }
//                } else{
//                if (madre.fitness>padre.fitness){
//                    if(madre.fitness>mejor.fitness){
//                        aux.add(madre);
//                    }
//                } else{
                aux.add(mejor);
//                }
//                }
            }
            this.pobActual = new Poblacion(aux);
            System.out.println("Poblacion: " + x + " Fitness: " + this.pobActual.getMejor().fitness + " Fenotipo: " + this.pobActual.getMejor().getFenotipo() + " Genotipo: " + Arrays.toString(this.pobActual.getMejor().getGenotipo()));
        }
    }
    
    public static void main(String[] args) {
        Genetico gen = new Genetico(100, 10000, 0.7);
        gen.Evolucionar();
    }
}
