package Kayttoliittyma.Tapahtumakuuntelijat;

import Logiikka.Saanto;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Kuuntelee valintalaatikoita, jotka muuttavat solujen syntymissääntöjä.
 * 
 * @author Kisuli
 */
public class SyntymaNapinKuuntelija implements ItemListener {

    private Saanto saanto;
    private int naapurienLkm;
    
    public SyntymaNapinKuuntelija(Saanto saanto, int naapurienLkm){
        this.saanto = saanto;
        this.naapurienLkm = naapurienLkm;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       if (e.getStateChange() == ItemEvent.SELECTED){
           // lisätään ruudukkoon sääntö
           saanto.lisaaSyntyma(naapurienLkm); 
       } else {
           // poistetaan ruudukosta sääntö
           saanto.poistaSyntyma(naapurienLkm);
       }
    }

}
