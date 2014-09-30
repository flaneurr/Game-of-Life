
package Kayttoliittyma;

import Logiikka.Ruudukko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class RuudukonKuuntelija implements ActionListener{

    private Ruudukko ruudukko;
    
    public RuudukonKuuntelija(Ruudukko ruudukko){
        this.ruudukko = ruudukko;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        // kun ruudukon nappia painetaan, niin sen tila muuttuu
        // miten tehdään? Pitääkö jokaisen napin tietää solu, johon se liittyy?
        Object nappi = event.getSource();
   
    }
    
}
