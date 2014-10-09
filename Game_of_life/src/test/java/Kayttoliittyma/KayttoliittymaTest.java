
package Kayttoliittyma;

import Logiikka.Ruudukko;
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
public class KayttoliittymaTest {
    
    private Kayttoliittyma kayttis;
    
    public KayttoliittymaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Ruudukko ruudukko = new Ruudukko(50);
        kayttis = new Kayttoliittyma(ruudukko);
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void pelinAloitusPelittaa() {
         kayttis.aloitaPeli();
         assertEquals(kayttis.getTimer().isRunning(),true);
     }
     
     public void pelinLopetusPelittaa(){
         kayttis.aloitaPeli();
         kayttis.lopetaPeli();
         assertEquals(kayttis.getTimer().isRunning(), false);
     }
}
