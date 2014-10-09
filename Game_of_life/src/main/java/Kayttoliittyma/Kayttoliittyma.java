package Kayttoliittyma;

import Logiikka.Ruudukko;
import Logiikka.Solu;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicBorders;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Ruudukko ruudukko;
    private JButton[][] ruudukonNapit;
    private Timer timer;
    private AskelNapinKuuntelija askelKuuntelija;
    private int delay;
    private boolean varitPaalla;

    public Kayttoliittyma(Ruudukko ruudukko) {
        this.varitPaalla = true;
        this.delay = 200;
        this.ruudukko = ruudukko;
        this.ruudukonNapit = new JButton[ruudukko.getKoko()][ruudukko.getKoko()];
        this.askelKuuntelija = new AskelNapinKuuntelija(ruudukko, this);
        this.timer = new Timer(delay, askelKuuntelija);
    }

    @Override
    public void run() {
        // asettaa otsikon
        frame = new JFrame("Game of Life");
        // ikkunan koko
        frame.setPreferredSize(new Dimension(700, 500));
        // kun painaa raksia, ohjelma sulkeutuu
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // kutsutaan metodia, joka luo kaikki sälät ikkunaan
        luoKomponentit(frame.getContentPane());
        // luodaan koko homma ja näytetään käyttäjälle
        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
//        container.setLayout(new GridBagLayout()); 
//        this.ruudukonNapit = luoRuudukko();
        container.add(luoValikko(), BorderLayout.SOUTH);
        container.add(luoRuudukko(), BorderLayout.CENTER);

    }

    /**
     * Luo ruudukon, joka koostuu JButtoneista
     *
     * @return palauttaa luodun ruudukon
     */
    private JPanel luoRuudukko() {
        GridLayout layout = new GridLayout(ruudukko.getKoko(), ruudukko.getKoko());
        JPanel panel = new JPanel();
        panel.setLayout(layout);

//        RuudukonKuuntelija ruudukonKuuntelija = new RuudukonKuuntelija(this.ruudukko);
        for (int i = 0; i < ruudukko.getKoko(); i++) {
            for (int j = 0; j < ruudukko.getKoko(); j++) {
                SoluNappi nappi = new SoluNappi(ruudukko.getSolu(i, j));
                ruudukonNapit[i][j] = nappi;
                SolunKuuntelija solunKuuntelija = new SolunKuuntelija(nappi, ruudukko.getSolu(i, j));
//                 tehdään napeista enemmän neliön mallisia
                nappi.setPreferredSize(new Dimension(10, 10));
//                nappi.setSize(10, 10);
                nappi.setMinimumSize(new Dimension(10, 10));
                nappi.setMaximumSize(new Dimension(10, 10));
                panel.add(nappi);
                // napille action listener
                nappi.addActionListener(solunKuuntelija);
                nappi.setBackground(Color.white);
            }
        }

        return panel;
    }

    /**
     * Luo valikon, jossa JButtonit pelin käyttämiseen.
     *
     * @return palauttaa luodun valikon
     */
    private JPanel luoValikko() {
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.setLayout(layout);

        JButton randomNappi = new JButton("Satunnainen alkutilanne");
        JButton tyhjennysNappi = new JButton("Tyhjennä ruudukko");
        JButton aloitusNappi = new JButton("Aloita peli");
        JButton lopetusNappi = new JButton("Lopeta peli");
        JButton askelNappi = new JButton("Askel eteenpäin");
        // lisätään vielä radio button, josta valitaan käytetäänkö varejä vai ei
        JRadioButton variNappi = new JRadioButton("Värit päällä/pois", true);

        panel.add(randomNappi);
        panel.add(tyhjennysNappi);
        panel.add(aloitusNappi);
        panel.add(lopetusNappi);
        panel.add(askelNappi);
        // varinappi paneliin
        panel.add(variNappi);

        AloitusNapinKuuntelija aloitusKuuntelija = new AloitusNapinKuuntelija(ruudukko, this);
        LopetusNapinKuuntelija lopetusKuuntelija = new LopetusNapinKuuntelija(ruudukko, this);
        RandomNapinKuuntelija randomKuuntelija = new RandomNapinKuuntelija(ruudukko, this);
        TyhjennysNapinKuuntelija tyhjennysKuuntelija = new TyhjennysNapinKuuntelija(ruudukko, this);
        // varinapille kuuntelija
        VariNapinKuuntelija variKuuntelija = new VariNapinKuuntelija(this);

        randomNappi.addActionListener(randomKuuntelija);
        tyhjennysNappi.addActionListener(tyhjennysKuuntelija);
        aloitusNappi.addActionListener(aloitusKuuntelija);
        lopetusNappi.addActionListener(lopetusKuuntelija);
        askelNappi.addActionListener(askelKuuntelija);
        // lisataan vielä varinapille kuuntelija
        variNappi.addActionListener(variKuuntelija);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton[][] getRuudukonNapit() {
        return this.ruudukonNapit;
    }

    /**
     * Lopettaa pelin päivittämisen.
     */
    public void lopetaPeli() {
        this.timer.stop();
    }

    /**
     * Aloittaa pelin päivittämisen ja jatkaa niin kauan, kunnes se lopetetaan.
     */
    public void aloitaPeli() {
        this.timer.start();
    }

    /**
     * Asettaa jokaiselle solulle sille kuuluvan värin tällä iteraatiolla.
     */
    public void piirraRuudukkoIlmanVareja() {
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
    }

    public void piirraRuudukko() {
        for (int i = 0; i < ruudukko.getKoko(); i++) {
            for (int j = 0; j < ruudukko.getKoko(); j++) {
                Solu solu = ruudukko.getSolu(i, j);
                boolean tila = solu.getTila();
                if (tila && varitPaalla) {
                    ruudukonNapit[i][j].setBackground(solu.getVari());
                } else if (tila && !varitPaalla) {
                    ruudukonNapit[i][j].setBackground(Color.black);
                } else {
                    ruudukonNapit[i][j].setBackground(Color.white);
                }
            }
        }
    }

    public Timer getTimer() {
        return this.timer;
    }

    public void varitPaalla(boolean varitPaalla) {
        this.varitPaalla = varitPaalla;
    }

    public boolean getVaritPaalla() {
        return this.varitPaalla;
    }
}
