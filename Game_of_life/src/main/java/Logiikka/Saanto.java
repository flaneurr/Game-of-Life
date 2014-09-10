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
    
    private ArrayList<Integer> syntyma; // pitäiskö näiden olla jotain listoja mielummin?
    private ArrayList<Integer> selviaminen;
    
    public Saanto (){
        this.syntyma = new ArrayList<Integer>();
        this.selviaminen = new ArrayList<Integer>();
    }
    
    public void setSyntyma(ArrayList<Integer> syntyma){
        this.syntyma = syntyma;
    }
    
    public void setSelviaminen (ArrayList<Integer> selviaminen){
        this.selviaminen = selviaminen;
    }
    
}
