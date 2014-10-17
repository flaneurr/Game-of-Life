
package Logiikka;

import java.awt.Color;
import java.util.ArrayList;
/**
 * Abstahoi Game of Life-pelissä esiintyvät yhtenäiset kuviot, jotka koostuvat vierekkäisistä elossa olevista soluista.
 * Luokka sisältää kuvioon kuuluvat solut ja oman värinsä.
 * @author Kisuli
 */
public class Kuvio {
    
    /**
     * Lista kuvioon kuuluvista soluista.
     */
    private ArrayList<Solu> solut;
    /**
     * Kuvion väri. Kuvioon kuuluvat solut saavat värinsä kuviolta.
     */
    private Color vari;
    
    /**
     * Konstruktori, joka luo uuden kuvion, joka on parametrinä olevan värin värinen.
     * 
     * @param vari kuvion väri
     */
    public Kuvio(Color vari){
        this.solut = new ArrayList<>();
        this.vari = vari;
    }
    
    /**
     * Luo uuden kuvion. Kuvio on parametrinä olevan värin värinen ja siihen kuuluu parametrinä saadut solut.
     * 
     * @param vari kuvion väri
     * @param solut kuvioon kuuluvat solut
     */
    public Kuvio(Color vari, ArrayList<Solu> solut){
        this.solut = solut;
        this.vari = vari;
    }
    /**
     * Asettaa kuviolle värin.
     * @param vari kuvion uusi väri
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
