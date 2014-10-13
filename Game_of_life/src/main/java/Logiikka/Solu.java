
package Logiikka;

import java.awt.Color;
import static java.awt.Color.BLACK;
import java.util.ArrayList;

/**
 * Game of Lifen solu. On joko elossa tai kuollut ja tuntee oman värinsä.
 * 
 * @author Kisuli
 */
public class Solu {

    private boolean tila;
    private int x;
    private int y;
    private Color vari;

    public Solu(int x, int y, boolean tila) {
        
        this.x = x;
        this.y = y;
        this.tila = tila;
        this.vari = BLACK;
        
    }

    public void setVari(Color vari){
        this.vari = vari;
    }
    
    public Color getVari(){
        return this.vari;
    }
    
    public boolean getTila(){
        return this.tila;       
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }

    public void setTila (boolean tila){
        this.tila = tila;
    }
}
