package com.game_of_life.game_of_life;

import Kayttoliittyma.Kayttoliittyma;
import Logiikka.Ruudukko;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Ruudukko ruudukko = new Ruudukko();
//        ruudukko.tulostaRuudukko();
//        
//        ruudukko.satunnaistaRuudukko();
//        System.out.println("");
//        ruudukko.tulostaRuudukko();
//        
//        ArrayList<Integer> syntyma = new ArrayList<>();
//        syntyma.add(3);
//        ArrayList<Integer> selviaminen = new ArrayList<>();
//        selviaminen.add(2);
//        selviaminen.add(3);
//        
//        ruudukko.luoSaanto(syntyma, selviaminen);
//        
//        System.out.println("");
//        ruudukko.paivitaRuudukko();
//        ruudukko.tulostaRuudukko();        
//        System.out.println("");
//        ruudukko.paivitaRuudukko();
//        ruudukko.tulostaRuudukko();
//        System.out.println("");
//        ruudukko.paivitaRuudukko();
//        ruudukko.tulostaRuudukko();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(ruudukko);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
