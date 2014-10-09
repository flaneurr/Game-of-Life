/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Logiikka.Ruudukko;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kisuli
 */
public class AskelNapinKuuntelijaTest {

    private Kayttoliittyma kayttis;
    private Ruudukko ruudukko;
    private AskelNapinKuuntelija kuuntelija;

    public AskelNapinKuuntelijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ruudukko = new Ruudukko(5);
        kayttis = new Kayttoliittyma(ruudukko);
        kuuntelija = new AskelNapinKuuntelija(ruudukko, kayttis);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void askelNappiMuuttaaRuudukkoa() {
        // solulla koordinaateissa 2,2 on kolme naapuria, sen pitäisi herätä henkiin
        ruudukko.getSolu(1, 1).setTila(true);
        ruudukko.getSolu(1, 2).setTila(true);
        ruudukko.getSolu(2, 1).setTila(true);
        JButton testiNappi = new JButton();
        testiNappi.addActionListener(kuuntelija);
        testiNappi.doClick();
        assertEquals(ruudukko.getSolu(2, 2), true);
    }
}
