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
public class Poblacion {
    public ArrayList<Individuo> poblacion = new ArrayList<Individuo>();
    
    public Poblacion(int tamPob){
        for(int x = 0; x<tamPob; x++){
            Individuo e = new Individuo();
            poblacion.add(e);
        }
    }
    
    public Poblacion (ArrayList<Individuo> pobAux){
        this.poblacion = pobAux;
    }
    
    
    public void ordenarPoblacion(){
        
        //Mayor a menor
        for(int x = 1; x < this.poblacion.size(); x++) {
            for(int y = 0; y < (this.poblacion.size() - x); y++) {
                if(this.poblacion.get(y).getFitness()< this.poblacion.get(y+1).getFitness()){            
                    Individuo aux = new Individuo(this.poblacion.get(y).getGenotipo());
                    this.poblacion.set(y,new Individuo(this.poblacion.get(y+1).getGenotipo()));
                    this.poblacion.set(y+1,aux);         
                }
            }
        }
    }
    
    public Individuo getMejor(){
        int idMejor = 0;
        for(int x = 0 ; x < poblacion.size() ; x++){
            if (poblacion.get(x).getFitness()>poblacion.get(idMejor).getFitness()){
                idMejor = x;
            }
        }
        
        Individuo mejor  = new Individuo(poblacion.get(idMejor).getGenotipo());
        
        return mejor;
    }
    
    public ArrayList <Individuo> getNMejores(int ene){
        ArrayList<Individuo> mejores = new ArrayList<Individuo>();
        ordenarPoblacion();
        for (int x = 0; x < ene ; x++){
            Individuo e = new Individuo(this.poblacion.get(x).getGenotipo());
            System.out.println(e.fitness + Arrays.toString(e.getGenotipo()));
            mejores.add(e);
        }
        
        return mejores;
    }
    public static void main(String[] args) {
        Poblacion pob = new Poblacion (100);
        pob.getNMejores(30);
        
    }
}
