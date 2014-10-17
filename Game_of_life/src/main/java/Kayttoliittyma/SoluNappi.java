
package Kayttoliittyma;

import Logiikka.Solu;
import java.awt.Graphics;
import javax.swing.JButton;
/**
 * Solunappi on JButton, joka tuntee siihen liittyvän solun.
 * 
 * @author crkaukin
 */

public class SoluNappi extends JButton{
    
    private Solu solu;
    
    public SoluNappi(Solu solu){
        super();
        this.solu = solu;
    }
    
    public Solu getSolu(){
        return this.solu;
    }
}
