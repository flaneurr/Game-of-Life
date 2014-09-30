
package Logiikka;

import java.util.ArrayList;

/**
 * Kuvaa Game of Lifessa olevaa joukkoa sääntöjä, jotka määräävät solujen tilan seuraavan kierroksen aikana.
 * @author Kisuli
 */
public class Saanto {
    
    private ArrayList<Integer> syntyma;
    private ArrayList<Integer> selviaminen;
    
    public Saanto (ArrayList<Integer> syntyma, ArrayList<Integer> selviaminen ){
        this.syntyma = syntyma; 
        this.selviaminen = selviaminen;
    }
    /**
     *  Määrittää solun tilan nykyisellä iteraatiolla Game of Lifessa
     * @param edellinenTila kertoo mikä solun tila oli edellisellä iteraatiolla
     * @param naapurienLkm kertoo solun elossa olevien naapurien lukumäärän
     * @return 
     */
    public boolean seuraavaTila(boolean edellinenTila, int naapurienLkm){
        boolean seuraavaTila = false;
        if (edellinenTila == true && selviaminen.contains(naapurienLkm)){
            seuraavaTila = true;
        } else if (edellinenTila == false && syntyma.contains(naapurienLkm)){
            seuraavaTila = true;
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
