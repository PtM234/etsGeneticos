/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maximo;

import java.util.Arrays;
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
    
    public Individuo(int geno[]){
        this.genotipo = geno.clone();
        this.fenotipo = calcularFenotipo();
        this.fitness = calcularFitness();
    }



    private int calcularFenotipo() {
        int fenAux = 0;
            if (this.genotipo[9] == 1){
                fenAux += 1;
            }
            if (this.genotipo[8] == 1){
                fenAux += 2 ;
            }
            if (this.genotipo[7] == 1){
                fenAux += 4;
            }
            if (this.genotipo[6] == 1){
                fenAux += 8;
            }
            if (this.genotipo[5] == 1){
                fenAux += 16;
            }
            if (this.genotipo[4] == 1){
                fenAux += 32;
            }
            if (this.genotipo[3] == 1){
                fenAux += 64;
            }
            if (this.genotipo[2] == 1){
                fenAux += 128;
            }
            if (this.genotipo[1] == 1){
                fenAux += 256;
            }
            if (this.genotipo[0] == 1){
                fenAux += 512;
            }
        
        return fenAux;
    }
    
        private double calcularFitness() {
        double fitnessAux = (3 * (fenotipo*fenotipo*fenotipo)) + (2 * fenotipo);
        return fitnessAux;
    }

    private int[] generarGenotipoAleatorio() {

        int genAux[] = new int[10];
        for (int x=0;x<genAux.length;x++){
            Random ran = new Random();
            genAux[x] = ran.nextInt(2);
        }
        return genAux;
    }
    
        public int[] getGenotipo() {
        return genotipo;
    }

        public int getFenotipo() {
        return fenotipo;
    }

        public double getFitness() {
        return fitness;
    }
    
//    public static void main(String[] args) {
//        Individuo ind = new Individuo();
//        System.out.println(Arrays.toString(ind.genotipo));
//        System.out.println(ind.fenotipo);
//        System.out.println(ind.fitness);
//    }
}
