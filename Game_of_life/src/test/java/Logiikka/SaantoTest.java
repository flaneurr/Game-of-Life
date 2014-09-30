package Logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logiikka.Saanto;
import Logiikka.Solu;
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
public class SaantoTest {
    
    private Saanto saanto;
    private Solu kuollutSolu;
    private Solu elavaSolu;
    private ArrayList<Integer> lista;
    
    public SaantoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        saanto = new Saanto(new ArrayList<Integer>(),new ArrayList<Integer>());
        kuollutSolu = new Solu(0,0,false);
        elavaSolu = new Solu(0,0,true);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test public void lisaaminenOnnistuuSelviaminen(){
        int uusi = 2;
        saanto.lisaaSelviaminen(uusi);
        assertEquals(saanto.getSelviytyminen().size(), 1);
    }
    
    @Test public void lisaaminenOnnistuuSyntyma(){
        int uusi = 2;
        saanto.lisaaSyntyma(uusi);
        assertEquals(saanto.getSyntyma().size(), 1);
    }
    
    @Test public void seuraavaTilaKuollutEloon(){
        int naapurienLkm = 3;
        saanto.lisaaSyntyma(3);
        boolean seuraavaTila = saanto.seuraavaTila(kuollutSolu.getTila(), naapurienLkm);
        assertEquals(seuraavaTila, true);
    }

    @Test public void seuraavaTilaElavaSelviaa(){
        int naapurienLkm = 3;
        saanto.lisaaSelviaminen(3);
        boolean seuraavaTila = saanto.seuraavaTila(elavaSolu.getTila(), naapurienLkm);
        assertEquals(seuraavaTila, true);
    }
    
    @Test public void seuraavaTilaElavaKuolee(){
        int naapurienLkm = 2;
        saanto.lisaaSelviaminen(3);
        boolean seuraavaTila = saanto.seuraavaTila(elavaSolu.getTila(), naapurienLkm);
        assertEquals(seuraavaTila, false);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
