
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
    
    /* tässä pitäisi muuttaa solun ulkonäköä siten, että se olisi tasaisen värinen ilman
    * varjostuksia ja ehkä reunoilla. Solujen tulisi olla aina neliön muotoisia. Vaihtoetoja: 
    * uusi kuva joka liimataan napin päälle/metodeilla muoataan ulkonäköä. Pitääkö tämä metodi
    * overridaa? 
    */
//    @Override
//    public void paintComponent(Graphics g){
//        
//    }
    
}
