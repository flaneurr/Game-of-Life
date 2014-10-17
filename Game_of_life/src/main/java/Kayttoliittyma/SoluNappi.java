
package Kayttoliittyma;

import Logiikka.Solu;
import java.awt.Graphics;
import javax.swing.JButton;


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
