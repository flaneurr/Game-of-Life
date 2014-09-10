/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import java.util.ArrayList;

/**
 *
 * @author Kisuli
 */
public class Solu {

    private int tila; // Solu joko elossa tai kuollut, elossa = 1, kuollut = 0.
    private ArrayList<Solu> naapurit; // miten naapurien alustus hoidetaan?
    private int x;
    private int y;

    public Solu(int x, int y, int tila) {
        
        this.x = x;
        this.y = y;
        this.tila = tila;
        
    }
    
    public int getTila(){
        return this.tila;       
    }
    
    public void setTila (int tila){
        this.tila = tila;
    }
    
    public ArrayList<Solu> getNaapurit(){
        return this.naapurit;
    }
    
    public int montakoElavaaNaapuria(){
        int elavatNaapurit = 0;
        for (Solu naapuri : this.naapurit){
            if (naapuri.getTila() == 1){
                elavatNaapurit++;
            }          
        }
        return elavatNaapurit;
    }

}
