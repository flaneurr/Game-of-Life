/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logiikka;

import java.awt.Color;
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
public class KuvioTest {
    
    private Solu solu;
    private ArrayList<Solu> solut;
    private Kuvio tyhjaKuvio;
    private Kuvio kuvio;
    private Color toinenVari;
    
    public KuvioTest() {
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
        tyhjaKuvio = new Kuvio(BLACK);
        kuvio = new Kuvio(BLACK,solut);
        toinenVari = RED;
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void variVaihtuu(){
        kuvio.setVari(toinenVari);
        kuvio.varitaSolut();
        assertEquals(kuvio.getSolut().get(0).getVari(), toinenVari);
    }
    
    @Test
    public void solunLisaaminenOnnistuu(){
        tyhjaKuvio.lisaaSolu(solu);
        assertEquals(kuvio.getSolut().isEmpty(), false);
    }

}
