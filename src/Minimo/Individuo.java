/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minimo;

import java.util.Random;

/**
 *
 * @author Alumno
 */
public class Individuo {
    
    public int genotipo[];
    public int fenotipo;
    public double fitness;
    
    public Individuo(){
        this.genotipo = generarGenotipoAleatorio();
        this.fenotipo = calcularFenotipo();
        this.fitness = calcularFitness();
    }
    
    public Individuo(int genotipo[]){
        this.genotipo = genotipo;
        this.fenotipo = calcularFenotipo();
        this.fitness = calcularFitness();
    }

    private int[] generarGenotipoAleatorio() {
        int genAux[] = new int[10];
        Random ran = new Random();
        for(int x = 0; x<genAux.length;x++){
            genAux[x] = ran.nextInt(2);
        }
        return genAux;
    }
    private double calcularFitness() {
        double fitAux = (3 * (getFenotipo()*getFenotipo()*getFenotipo()))+(2*getFenotipo());
        
        return fitAux;
    }

    private int calcularFenotipo() {
        int fenAux = 0;
            if (this.getGenotipo()[9] == 1){
                fenAux += 1;
            }
            if (this.getGenotipo()[8] == 1){
                fenAux += 2 ;
            }
            if (this.getGenotipo()[7] == 1){
                fenAux += 4;
            }
            if (this.getGenotipo()[6] == 1){
                fenAux += 8;
            }
            if (this.getGenotipo()[5] == 1){
                fenAux += 16;
            }
            if (this.getGenotipo()[4] == 1){
                fenAux += 32;
            }
            if (this.getGenotipo()[3] == 1){
                fenAux += 64;
            }
            if (this.getGenotipo()[2] == 1){
                fenAux += 128;
            }
            if (this.getGenotipo()[1] == 1){
                fenAux += 256;
            }
            if (this.getGenotipo()[0] == 1){
                fenAux += 512;
            }
        
        return fenAux;
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }

    /**
     * @return the fenotipo
     */
    public int getFenotipo() {
        return fenotipo;
    }

    /**
     * @return the fitness
     */
    public double getFitness() {
        return fitness;
    }


}
