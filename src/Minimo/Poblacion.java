/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minimo;

import java.util.ArrayList;

/**
 *
 * @author tapia
 */
public class Poblacion {
    ArrayList<Individuo> poblacion = new ArrayList<Individuo>();
    
    public Poblacion(int tamPob){
        for(int x = 0 ; x < tamPob ; x++){
            Individuo e = new Individuo();
            poblacion.add(e);
        }
    }
    
    public Poblacion(ArrayList<Individuo> pobAux){
        this.poblacion = (ArrayList<Individuo>) pobAux.clone();
    }
    
    public Individuo getMejor(){
        int idMejor = 0;
        for(int x = 0; x < poblacion.size(); x++){
            if(poblacion.get(x).getFitness()<poblacion.get(idMejor).getFitness()){
                idMejor = x;
            }
        }
        Individuo mejor = new Individuo(poblacion.get(idMejor).getGenotipo());
        
        return mejor;
    }
    
    public void ordenarPoblacion(){
        for (int x = 0; x <poblacion.size(); x++){
            for (int y = 1; y < poblacion.size()-1;y++){
                Individuo aux;
                if (poblacion.get(x).getFitness()>poblacion.get(y).getFitness()){
                    aux =  new Individuo(poblacion.get(x).getGenotipo());
                    poblacion.get(x).genotipo = poblacion.get(y).getGenotipo();
                    poblacion.get(y).genotipo = aux.getGenotipo();
                }
            }
            
        }
    }
    
    public ArrayList<Individuo> getNMejores(int tam){
        ArrayList<Individuo> aux = new ArrayList<Individuo>();
        ordenarPoblacion();
        if(tam<poblacion.size()){
            for(int x = 0; x < tam ; x++){
                Individuo e = new Individuo(poblacion.get(x).getGenotipo());
                aux.add(e);
            }
        }      
        return aux;
    }
    
    
    public static void main(String[] args) {
        Poblacion pob = new Poblacion(100);
        pob.getNMejores(30);
    }
}
