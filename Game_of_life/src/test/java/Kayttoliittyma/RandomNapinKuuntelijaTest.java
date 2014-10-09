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
public class RandomNapinKuuntelijaTest {

    private Kayttoliittyma kayttis;
    private Ruudukko ruudukko;
    private RandomNapinKuuntelija kuuntelija;

    public RandomNapinKuuntelijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ruudukko = new Ruudukko();
        kayttis = new Kayttoliittyma(ruudukko);
        kuuntelija = new RandomNapinKuuntelija(ruudukko, kayttis);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void RadmonNapinPainaminenRandomoiRuudukon() {
        JButton testiNappi = new JButton();
        testiNappi.addActionListener(kuuntelija);
        testiNappi.doClick();
        assertEquals(ruudukko.kaikkiKuolleita(),false);
    }
}
