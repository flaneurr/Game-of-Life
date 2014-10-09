
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
    
    public void setVari(Color vari){
        this.vari = vari;
    }
    
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
    
    public ArrayList<Solu> getSolut(){
        return this.solut;
    }
    
    public Color getVari(){
        return this.vari;
    }
    
    public int getKoko(){
        return solut.size();
    }
}
