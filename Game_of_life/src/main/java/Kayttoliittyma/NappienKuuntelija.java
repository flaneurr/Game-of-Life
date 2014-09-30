package Kayttoliittyma;

import Logiikka.Ruudukko;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NappienKuuntelija implements ActionListener {

    private Ruudukko ruudukko;
    private boolean kaynnissa;
    private JButton[][] ruudukonNapit;

    public NappienKuuntelija(Ruudukko ruudukko, JButton[][] ruudukonNapit) {
        this.ruudukko = ruudukko;
        this.kaynnissa = false;
        this.ruudukonNapit = ruudukonNapit;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Satunnainen alkutilanne")) {
            ruudukko.satunnaistaRuudukko();
            piirraRuudukko();
        } else if (event.getActionCommand().equals("Askel eteenpäin")) {
            ruudukko.paivitaRuudukko();
            piirraRuudukko();
        } else if (event.getActionCommand().equals("Tyhjennä ruudukko")) {
            ruudukko.tyhjennaRuudukko();
            piirraRuudukko();
        } else if (event.getActionCommand().equals("Aloita peli")) {
            // peli alkaa tämänhetkisestä alkutilanteesta niin kauan, kunnes peli lopetetaan painikkeesta
            // jokaisen iteraation yhteydessä ruudukkon ulkoasu päivitetään vastaamaan solujen tiloja
            this.kaynnissa = true;            
            while (kaynnissa) {
                ruudukko.paivitaRuudukko();
                piirraRuudukko();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(NappienKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (event.getActionCommand().equals("Lopeta peli")) {
            // seuraavaa iteraatiota ei suoriteta, vaan peli pysähtyy ja solujen tilat pidetään sellaisenaan 
            this.kaynnissa = false;

        }
    }
    

    public void piirraRuudukko() {
        for (int i = 0; i < ruudukko.getKoko(); i++) {
            for (int j = 0; j < ruudukko.getKoko(); j++) {
                boolean tila = ruudukko.getSolu(i, j).getTila();
                if (tila) {
                    ruudukonNapit[i][j].setBackground(Color.black);
                } else {
                    ruudukonNapit[i][j].setBackground(Color.white);
                }
            }
        }
//        ruudukkoNapit.setOpaque(true);
    }

}
