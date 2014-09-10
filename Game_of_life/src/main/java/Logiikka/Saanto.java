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
public class Saanto {
    
    private ArrayList<Integer> syntyma;
    private ArrayList<Integer> selviaminen;
    
    public Saanto (ArrayList<Integer> syntyma, ArrayList<Integer> selviaminen ){
        this.syntyma = syntyma; 
        this.selviaminen = selviaminen;
    }
    
    public int seuraavaTila(int edellinenTila, int naapurienLkm){
        int seuraavaTila = 0;
        if (edellinenTila == 1 && selviaminen.contains(naapurienLkm)){
            seuraavaTila = 1;
        } else if (edellinenTila == 0 && syntyma.contains(naapurienLkm)){
            seuraavaTila = 1;
        }
        return seuraavaTila;
        
    }
    
    public void setSyntyma(ArrayList<Integer> syntyma){
        this.syntyma = syntyma;
    }
    
    public void lisaaSyntyma(int uusi){
        this.syntyma.add(uusi);
    }
    
    public void lisaaSelviaminen(int uusi){
        this.selviaminen.add(uusi);
    }
    
    public void setSelviaminen (ArrayList<Integer> selviaminen){
        this.selviaminen = selviaminen;
    }
    
    public ArrayList<Integer> getSyntyma(){
        return this.syntyma;       
    }
    
    public ArrayList<Integer> getSelviytyminen(){
        return this.selviaminen;
    }
    
}
