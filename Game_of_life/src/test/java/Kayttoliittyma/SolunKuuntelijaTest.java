package Kayttoliittyma;

import Logiikka.Ruudukko;
import Logiikka.Solu;
import java.awt.Color;
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
public class SolunKuuntelijaTest {

    private JButton testiNappi;
    private Solu solu;
    private SolunKuuntelija kuuntelija;

    public SolunKuuntelijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testiNappi = new JButton();
        solu = new Solu(0, 0, true);
        kuuntelija = new SolunKuuntelija(testiNappi, solu);
        testiNappi.addActionListener(kuuntelija);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void NapinPainaminenMuuttaaSolunTilaa() {
        testiNappi.doClick();
        assertEquals(solu.getTila(), false);
    }

    @Test
    public void NapinPainaminenMuuttaaNapinVaria() {
        testiNappi.doClick();
        assertEquals(testiNappi.getBackground(), Color.black);
    }
}
