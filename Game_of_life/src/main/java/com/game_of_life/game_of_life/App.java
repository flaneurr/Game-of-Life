package com.game_of_life.game_of_life;

import Kayttoliittyma.Kayttoliittyma;
import Logiikka.Ruudukko;
import javax.swing.SwingUtilities;

/**
 * Käynistää Game of Life-ojelman.
 *
 */
public class App {

    private static Ruudukko ruudukko;

    public static void main(String[] args) {
        ruudukko = new Ruudukko(50);
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(ruudukko);
        SwingUtilities.invokeLater(kayttoliittyma);

    }

}
