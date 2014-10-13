/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logiikka;

import static java.awt.Color.BLACK;
import static java.awt.Color.RED;
import java.util.ArrayList;
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
public class KuviontunnistajaTest {
    
    private ArrayList<Solu> solut;
    private Kuvio kuvio;
    private Solu solu;
    private Kuviontunnistaja tunnistaja;
    private Ruudukko ruudukko;
    
    public KuviontunnistajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        solu = new Solu(0, 0, true);
        solut = new ArrayList<Solu>();
        solut.add(solu);
        kuvio = new Kuvio(BLACK,solut);
        ruudukko = new Ruudukko(20);
        tunnistaja = new Kuviontunnistaja();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void kuvionLisaminenOnnistuu(){
        tunnistaja.lisaaKuvio(kuvio);
        assertEquals(tunnistaja.getKuviot().isEmpty(), false);
    }
    
    @Test 
    public void kertooVarinKuviolleOikein(){
        tunnistaja.kerroVariKuviolle(kuvio, RED);
        assertEquals(kuvio.getVari(), RED);
    }
    
    @Test
    public void kuvioTunnistetaan(){
        ruudukko.getSolu(0, 1).setTila(true);
        tunnistaja.etsiKuviot(ruudukko.getSolut());
        assertEquals(tunnistaja.getKuviot().size(), 1);
    }

}
