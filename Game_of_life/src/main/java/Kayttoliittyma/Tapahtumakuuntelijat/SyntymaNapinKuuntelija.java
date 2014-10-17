package Kayttoliittyma.Tapahtumakuuntelijat;

import Logiikka.Saanto;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
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
           saanto.lisaaSyntyma(naapurienLkm); // mistä tiedetään mikä luku poistetaan?
           // pitäiskö tehä oma checkbox ja overridaa toString antamaan luku, joka on labelina
       } else {
           // poistetaan ruudukosta sääntö
           saanto.poistaSyntyma(naapurienLkm);
       }
    }

}
