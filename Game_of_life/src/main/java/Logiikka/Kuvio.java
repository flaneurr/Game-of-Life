
package Logiikka;

import java.awt.Color;
import java.util.ArrayList;
/**
 * Abstahoi Game of Life-pelissä esiintyvät yhtenäiset kuviot. Sisältää kuvioon kuuluvat solut ja oman värinsä.
 * @author Kisuli
 */
public class Kuvio {
    
    private ArrayList<Solu> solut;
    private Color vari;
    
    public Kuvio(Color vari){
        this.solut = new ArrayList<>();
        this.vari = vari;
    }
    
    public Kuvio(Color vari, ArrayList<Solu> solut){
        this.solut = solut;
        this.vari = vari;
    }
    /**
     * Asettaa kuviolle värin.
     * @param vari 
     */
    public void setVari(Color vari){
        this.vari = vari;
    }
    /**
     * Lisää solun kuvioon.
     * 
     * @param solu lisättävä solu
     */
    public void lisaaSolu(Solu solu){
        this.solut.add(solu);
    }
    /**
     *  Värittää jokaisen kuvion solun kuvion omalla värillä.
     */
    public void varitaSolut(){
        for (Solu solu : solut){
            solu.setVari(this.vari);
        }
    }
    /**
     * Palauttaa listan kuvioon kuuluvista soluista.
     * @return lista kuvioon kuuluvista soluista
     */
    public ArrayList<Solu> getSolut(){
        return this.solut;
    }
    /**
     * Palauttaa kuvion värin.
     * 
     * @return kuvion väri
     */
    public Color getVari(){
        return this.vari;
    }
    /**
     * Palauttaa kuvioon kuuluvien solujen lukumäärän.
     * @return kuvioon kuuluvien solujen lukumäärä
     */
    public int getKoko(){
        return solut.size();
    }
}
