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
public class Cruza {
    
    //Crear genotipos[]
    //Recorrer máscara
    //Tomar bits de los padres
    //poner en genotipos[]
    
    public static Individuo cruzaPorMascaraAleatoria(Individuo padre, Individuo madre){
        int mask[] = new int[10];
        for (int x=0;x<mask.length;x++){
            Random ran = new Random();
            mask[x] = ran.nextInt(2);
        }
        
        int genotipo1[] = new int[10];
        int genotipo2[] = new int[10];
        Individuo hijo1, hijo2;
        for (int x = 0 ; x < mask.length ; x++){
            
            if(mask[x] == 0){
                genotipo1[x] = padre.genotipo[x];
                genotipo2[x] = madre.genotipo[x];
            } else{
                genotipo1[x] = madre.genotipo[x];
                genotipo2[x] = padre.genotipo[x];
            }
        }
        hijo1 = new Individuo(genotipo1);
        hijo2 = new Individuo(genotipo2);
        
        
        if (hijo1.fitness>hijo2.fitness){
            return hijo1;
        }
        else{
            return hijo2;
        }
    }
    
    public static Individuo cruzaPorMascara(int mask[], Individuo padre, Individuo madre){
        int genotipo1[] = new int[10];
        int genotipo2[] = new int[10];
        Individuo hijo1, hijo2;
        for (int x = 0 ; x < mask.length ; x++){
            
            if(mask[x] == 0){
                genotipo1[x] = padre.genotipo[x];
                genotipo2[x] = madre.genotipo[x];
            } else{
                genotipo1[x] = madre.genotipo[x];
                genotipo2[x] = padre.genotipo[x];
            }
        }
        hijo1 = new Individuo(genotipo1);
        hijo2 = new Individuo(genotipo2);
        
        
        if (hijo1.fitness>hijo2.fitness){
            return hijo1;
        }
        else{
            return hijo2;
        }
    }
}
