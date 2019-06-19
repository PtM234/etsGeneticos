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
public class Muta {
    public static Individuo muta (Individuo ind){
        Random ran = new Random();
        int pos = ran.nextInt(ind.genotipo.length);
        if (ind.genotipo[pos] == 1){
            ind.genotipo[pos] = 0;
        } else{
            if(ind.genotipo[pos] == 0){
            ind.genotipo[pos] = 1;
            }
        }
        
        return ind;
    }
}
