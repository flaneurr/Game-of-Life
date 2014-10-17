package Kayttoliittyma.Tapahtumakuuntelijat;

import Kayttoliittyma.Kayttoliittyma;
import Logiikka.Ruudukko;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Kuuntelee solunappia, joka satunnaistaa ruudukon solujen tilat.
 *
 * @author crkaukin
 */
public class RandomNapinKuuntelija implements ActionListener {

    private Ruudukko ruudukko;
    private Kayttoliittyma kayttoliittyma;

    public RandomNapinKuuntelija(Ruudukko ruudukko, Kayttoliittyma kayttoliittyma) {
        this.ruudukko = ruudukko;
        this.kayttoliittyma = kayttoliittyma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ruudukko.satunnaistaRuudukko();
        ruudukko.paivitaKuviot();
        kayttoliittyma.piirraRuudukko();
    }

}
