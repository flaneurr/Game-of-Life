
package Kayttoliittyma;

import Logiikka.Ruudukko;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TyhjennysNapinKuuntelijaTest {
    
    private Kayttoliittyma kayttis;
    private Ruudukko ruudukko;
    private TyhjennysNapinKuuntelija kuuntelija;
    
    public TyhjennysNapinKuuntelijaTest() {
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
        kuuntelija = new TyhjennysNapinKuuntelija(ruudukko, kayttis);
        
    }
    
    @After
    public void tearDown() {
    }

  
     @Test
     public void actionPerformedTyhjentaaRuudukon() {
         JButton testiNappi = new JButton();
         testiNappi.addActionListener(kuuntelija);
         testiNappi.doClick();
         assertEquals(ruudukko.kaikkiKuolleita(),true);
     }
}
