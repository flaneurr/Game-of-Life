package Logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class RuudukkoTest {

    private Ruudukko ruudukko;

    public RuudukkoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ruudukko = new Ruudukko(3);
        for (int i = 0; i < ruudukko.getSolut().length; i++) {
            for(int j = 0; j < ruudukko.getSolut()[i].length; j++){
                ruudukko.getSolu(i, j).setTila(true);
            }
        }
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void saannonLuominenOnnistuu(){
        ArrayList<Integer> selviaminen = new ArrayList<Integer>();
        ArrayList<Integer> syntyma = new ArrayList<Integer>();
        selviaminen.add(8);
        syntyma.add(8);
        ruudukko.luoSaanto(syntyma, selviaminen);
        ruudukko.paivitaRuudukko();
        assertEquals(ruudukko.getSolu(1, 1).getTila(), true);
    }
    
    @Test
    public void elavienNaapurienLkmToimii() {
        int lkm = ruudukko.elavienNaapurienLkm(ruudukko.getSolut(), ruudukko.getSolu(1, 1));
        assertEquals(lkm, 8);
    }

    @Test
    public void ylosElossaReuna() {
        ruudukko.getSolu(ruudukko.getSolut().length - 1, ruudukko.getSolut()[0].length - 1).setTila(true);
        int elossa = ruudukko.ylosElossa(ruudukko.getSolu(0, 0));
        assertEquals(elossa, 1);
    }

    @Test
    public void alasElossaReuna() {
        ruudukko.getSolu(0, ruudukko.getSolut()[0].length - 1).setTila(true);
        int elossa = ruudukko.alasElossa(ruudukko.getSolu(ruudukko.getSolut().length - 1, ruudukko.getSolut()[0].length - 1));
        assertEquals(elossa, 1);
    }

    @Test
    public void vasenElossaReuna() {
        ruudukko.getSolu(0, ruudukko.getSolut()[0].length - 1).setTila(true);
        int elossa = ruudukko.vasenElossa(ruudukko.getSolu(0, 0));
        assertEquals(elossa, 1);
    }

    @Test
    public void oikeaElossaReuna() {
        ruudukko.getSolu(0, ruudukko.getSolut()[0].length - 1).setTila(true);
        int elossa = ruudukko.oikeaElossa(ruudukko.getSolu(ruudukko.getSolut().length - 1, ruudukko.getSolut()[0].length - 1));
        assertEquals(elossa, 1);
    }

    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
