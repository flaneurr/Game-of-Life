package Kayttoliittyma.Tapahtumakuuntelijat;

import Logiikka.Saanto;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Kuuntelee valintalaatikoita, jotka muuttavat solujen selviämissääntöjä.
 * 
 * @author Kisuli
 */
public class SelviamisNapinKuuntelija implements ItemListener {

    private Saanto saanto;
    private int naapurienLkm;

    public SelviamisNapinKuuntelija(Saanto saanto, int naapurienLkm) {
        this.saanto = saanto;
        this.naapurienLkm = naapurienLkm;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED){
           // lisätään ruudukkoon sääntö
           saanto.lisaaSelviaminen(naapurienLkm); 
       } else {
           // poistetaan ruudukosta sääntö
           saanto.poistaSelviaminen(naapurienLkm);
       }
    }
}
