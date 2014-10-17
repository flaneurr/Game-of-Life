package Kayttoliittyma;

import Kayttoliittyma.Tapahtumakuuntelijat.AloitusNapinKuuntelija;
import Kayttoliittyma.Tapahtumakuuntelijat.AskelNapinKuuntelija;
import Kayttoliittyma.Tapahtumakuuntelijat.LopetusNapinKuuntelija;
import Kayttoliittyma.Tapahtumakuuntelijat.RandomNapinKuuntelija;
import Kayttoliittyma.Tapahtumakuuntelijat.SelviamisNapinKuuntelija;
import Kayttoliittyma.Tapahtumakuuntelijat.SolunKuuntelija;
import Kayttoliittyma.Tapahtumakuuntelijat.TyhjennysNapinKuuntelija;
import Kayttoliittyma.Tapahtumakuuntelijat.SyntymaNapinKuuntelija;
import Kayttoliittyma.Tapahtumakuuntelijat.VariNapinKuuntelija;
import Logiikka.Ruudukko;
import Logiikka.Solu;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 * Game of Life -ohjelman graafinen käyttöliittymä.
 *
 * @author crkaukin
 */
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
        frame.setPreferredSize(new Dimension(1050, 600)); // 780,530
        // kun painaa raksia, ohjelma sulkeutuu
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // kutsutaan metodia, joka luo kaikki sälät ikkunaan
        luoKomponentit(frame.getContentPane());
        // luodaan koko homma ja näytetään käyttäjälle
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo graafisen käyttöliittymän komponentit.
     *
     * @param container container-olio, joka sisältää ohjelman valikot
     */
    public void luoKomponentit(Container container) {
        GridBagLayout gridLayout = new GridBagLayout();
        container.setLayout(gridLayout);
        // luodaan valikko pelin hallitsemiseksi
        JPanel valikkoPaneeli = luoValikko();
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.VERTICAL;
        c.insets = new Insets(20, 20, 20, 20);
        c.ipadx = 50;
        c.gridx = 1;
        c.gridy = 0;
        container.add(valikkoPaneeli);
        //gridLayout.setConstraints(valikkoPaneeli, c);       

        // luodaan ruudukko soluja
        JPanel ruudukkoPaneeli = luoRuudukko();
        GridBagConstraints d = new GridBagConstraints();
        d.anchor = GridBagConstraints.CENTER;
        d.insets = new Insets(20, 20, 20, 20);
        d.fill = GridBagConstraints.BOTH;
        d.ipadx = 50;
        container.add(ruudukkoPaneeli);
        gridLayout.setConstraints(ruudukkoPaneeli, c);

        // luodaan valikko, josta voidaan muokata sääntöjä
        JPanel saantoPaneeli = luoSaantoValikko();
        GridBagConstraints e = new GridBagConstraints();
        e.gridy = 0;
        e.gridx = 2;
        e.insets = new Insets(20, 20, 20, 20);
        gridLayout.setConstraints(saantoPaneeli, e);
        container.add(saantoPaneeli);

    }

    /**
     * Luo valikon Game of lifen sääntöjen muuttamiseksi.
     *
     * @return sääntöpaneeli
     */
    private JPanel luoSaantoValikko() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(10, 2);
        layout.setVgap(5);
        layout.setHgap(10);
        panel.setLayout(layout);
        //tekstit
        JTextArea syntymat = new JTextArea("Solu syntyy");
        syntymat.setBackground(null);
        JTextArea selviamiset = new JTextArea("Solu selviää");
        selviamiset.setBackground(null);
        //napit
        JCheckBox syntymaNappi0 = new JCheckBox("0");
        JCheckBox syntymaNappi1 = new JCheckBox("1");
        JCheckBox syntymaNappi2 = new JCheckBox("2");
        JCheckBox syntymaNappi3 = new JCheckBox("3", true);
        JCheckBox syntymaNappi4 = new JCheckBox("4");
        JCheckBox syntymaNappi5 = new JCheckBox("5");
        JCheckBox syntymaNappi6 = new JCheckBox("6");
        JCheckBox syntymaNappi7 = new JCheckBox("7");
        JCheckBox syntymaNappi8 = new JCheckBox("8");

        JCheckBox selviamisNappi0 = new JCheckBox("0");
        JCheckBox selviamisNappi1 = new JCheckBox("1");
        JCheckBox selviamisNappi2 = new JCheckBox("2", true);
        JCheckBox selviamisNappi3 = new JCheckBox("3", true);
        JCheckBox selviamisNappi4 = new JCheckBox("4");
        JCheckBox selviamisNappi5 = new JCheckBox("5");
        JCheckBox selviamisNappi6 = new JCheckBox("6");
        JCheckBox selviamisNappi7 = new JCheckBox("7");
        JCheckBox selviamisNappi8 = new JCheckBox("8");

        SyntymaNapinKuuntelija syntKuuntelija0 = new SyntymaNapinKuuntelija(this.ruudukko.getSaanto(), 0);
        SyntymaNapinKuuntelija syntKuuntelija1 = new SyntymaNapinKuuntelija(this.ruudukko.getSaanto(), 1);
        SyntymaNapinKuuntelija syntKuuntelija2 = new SyntymaNapinKuuntelija(this.ruudukko.getSaanto(), 2);
        SyntymaNapinKuuntelija syntKuuntelija3 = new SyntymaNapinKuuntelija(this.ruudukko.getSaanto(), 3);
        SyntymaNapinKuuntelija syntKuuntelija4 = new SyntymaNapinKuuntelija(this.ruudukko.getSaanto(), 4);
        SyntymaNapinKuuntelija syntKuuntelija5 = new SyntymaNapinKuuntelija(this.ruudukko.getSaanto(), 5);
        SyntymaNapinKuuntelija syntKuuntelija6 = new SyntymaNapinKuuntelija(this.ruudukko.getSaanto(), 6);
        SyntymaNapinKuuntelija syntKuuntelija7 = new SyntymaNapinKuuntelija(this.ruudukko.getSaanto(), 7);
        SyntymaNapinKuuntelija syntKuuntelija8 = new SyntymaNapinKuuntelija(this.ruudukko.getSaanto(), 8);

        syntymaNappi0.addItemListener(syntKuuntelija0);
        syntymaNappi1.addItemListener(syntKuuntelija1);
        syntymaNappi2.addItemListener(syntKuuntelija2);
        syntymaNappi3.addItemListener(syntKuuntelija3);
        syntymaNappi4.addItemListener(syntKuuntelija4);
        syntymaNappi5.addItemListener(syntKuuntelija5);
        syntymaNappi6.addItemListener(syntKuuntelija6);
        syntymaNappi7.addItemListener(syntKuuntelija7);
        syntymaNappi8.addItemListener(syntKuuntelija8);

        SelviamisNapinKuuntelija selvKuuntelija0 = new SelviamisNapinKuuntelija(this.ruudukko.getSaanto(), 0);
        SelviamisNapinKuuntelija selvKuuntelija1 = new SelviamisNapinKuuntelija(this.ruudukko.getSaanto(), 1);
        SelviamisNapinKuuntelija selvKuuntelija2 = new SelviamisNapinKuuntelija(this.ruudukko.getSaanto(), 2);
        SelviamisNapinKuuntelija selvKuuntelija3 = new SelviamisNapinKuuntelija(this.ruudukko.getSaanto(), 3);
        SelviamisNapinKuuntelija selvKuuntelija4 = new SelviamisNapinKuuntelija(this.ruudukko.getSaanto(), 4);
        SelviamisNapinKuuntelija selvKuuntelija5 = new SelviamisNapinKuuntelija(this.ruudukko.getSaanto(), 5);
        SelviamisNapinKuuntelija selvKuuntelija6 = new SelviamisNapinKuuntelija(this.ruudukko.getSaanto(), 6);
        SelviamisNapinKuuntelija selvKuuntelija7 = new SelviamisNapinKuuntelija(this.ruudukko.getSaanto(), 7);
        SelviamisNapinKuuntelija selvKuuntelija8 = new SelviamisNapinKuuntelija(this.ruudukko.getSaanto(), 8);

        selviamisNappi0.addItemListener(selvKuuntelija0);
        selviamisNappi1.addItemListener(selvKuuntelija1);
        selviamisNappi2.addItemListener(selvKuuntelija2);
        selviamisNappi3.addItemListener(selvKuuntelija3);
        selviamisNappi4.addItemListener(selvKuuntelija4);
        selviamisNappi5.addItemListener(selvKuuntelija5);
        selviamisNappi6.addItemListener(selvKuuntelija6);
        selviamisNappi7.addItemListener(selvKuuntelija7);
        selviamisNappi8.addItemListener(selvKuuntelija8);

        // lisätään napit paneeliin
        panel.add(syntymat);
        panel.add(selviamiset);

        panel.add(syntymaNappi0);
        panel.add(selviamisNappi0);

        panel.add(syntymaNappi1);
        panel.add(selviamisNappi1);

        panel.add(syntymaNappi2);
        panel.add(selviamisNappi2);

        panel.add(syntymaNappi3);
        panel.add(selviamisNappi3);

        panel.add(syntymaNappi4);
        panel.add(selviamisNappi4);

        panel.add(syntymaNappi5);
        panel.add(selviamisNappi5);

        panel.add(syntymaNappi6);
        panel.add(selviamisNappi6);

        panel.add(syntymaNappi7);
        panel.add(selviamisNappi7);

        panel.add(syntymaNappi8);
        panel.add(selviamisNappi8);

        return panel;

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
        for (int i = 0; i < ruudukko.getKoko(); i++) {
            for (int j = 0; j < ruudukko.getKoko(); j++) {
                SoluNappi nappi = new SoluNappi(ruudukko.getSolu(i, j));
                ruudukonNapit[i][j] = nappi;
                SolunKuuntelija solunKuuntelija = new SolunKuuntelija(nappi, ruudukko.getSolu(i, j));
                //tehdään napeista enemmän neliön mallisia
                nappi.setPreferredSize(new Dimension(10, 10));
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
     * Luo valikon, joka sisältää JButtonit pelin käyttämiseen.
     *
     * @return palauttaa luodun valikon
     */
    private JPanel luoValikko() {
        /*
         * Luodaan paneeli ja sille layout.
         */
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(6, 1);
        layout.setVgap(15);
        panel.setLayout(layout);
        /*
         * Luodaan napit.
         */
        JButton randomNappi = new JButton("Satunnainen alkutilanne");
        JButton tyhjennysNappi = new JButton("Tyhjennä ruudukko");
        JButton aloitusNappi = new JButton("Aloita peli");
        JButton lopetusNappi = new JButton("Lopeta peli");
        JButton askelNappi = new JButton("Askel eteenpäin");
        JRadioButton variNappi = new JRadioButton("Värit päällä/pois", true);
        /*
         * Lisätään napit paneeliin.
         */
        panel.add(aloitusNappi);
        panel.add(lopetusNappi);
        panel.add(askelNappi);
        panel.add(randomNappi);
        panel.add(tyhjennysNappi);
        panel.add(variNappi);
        /*
         * Luodaan ja lisätään napeille action listenerit.
         */
        AloitusNapinKuuntelija aloitusKuuntelija = new AloitusNapinKuuntelija(ruudukko, this);
        LopetusNapinKuuntelija lopetusKuuntelija = new LopetusNapinKuuntelija(ruudukko, this);
        RandomNapinKuuntelija randomKuuntelija = new RandomNapinKuuntelija(ruudukko, this);
        TyhjennysNapinKuuntelija tyhjennysKuuntelija = new TyhjennysNapinKuuntelija(ruudukko, this);
        VariNapinKuuntelija variKuuntelija = new VariNapinKuuntelija(this);

        randomNappi.addActionListener(randomKuuntelija);
        tyhjennysNappi.addActionListener(tyhjennysKuuntelija);
        aloitusNappi.addActionListener(aloitusKuuntelija);
        lopetusNappi.addActionListener(lopetusKuuntelija);
        askelNappi.addActionListener(askelKuuntelija);
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

    /**
     * Asettaa ohjelman ottamaan värit käyttöön tai pois käytöstä riippuen
     * parametrista.
     *
     * @param varitPaalla true, jos värit halutaan käyttöön ja false, jos värit
     * halutaan pois käytöstä
     */
    public void varitPaalla(boolean varitPaalla) {
        this.varitPaalla = varitPaalla;
    }

    /**
     * Kertoo käyttääkö ohjelma tällä hetkellä värejä solujen piirtämisessä.
     *
     * @return palauttaa true, jos värit ovat käytössä ja false, jos värit eivät
     * ole käytössä
     */
    public boolean getVaritPaalla() {
        return this.varitPaalla;
    }
}
