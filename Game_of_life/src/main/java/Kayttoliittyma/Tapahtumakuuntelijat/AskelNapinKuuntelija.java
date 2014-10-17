
package Kayttoliittyma.Tapahtumakuuntelijat;

import Kayttoliittyma.Kayttoliittyma;
import Logiikka.Ruudukko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AskelNapinKuuntelija implements ActionListener{
    private Ruudukko ruudukko;
    private Kayttoliittyma kayttoliittyma;
    
    public AskelNapinKuuntelija(Ruudukko ruudukko, Kayttoliittyma kayttoliittyma){
        this.ruudukko = ruudukko;
        this.kayttoliittyma = kayttoliittyma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ruudukko.paivitaRuudukko();
        kayttoliittyma.piirraRuudukko();
    }
}
