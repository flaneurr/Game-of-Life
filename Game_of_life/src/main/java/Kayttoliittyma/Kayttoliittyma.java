package Kayttoliittyma;

import Logiikka.Ruudukko;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Ruudukko ruudukko;
    private JButton[][] ruudukonNapit;
    
    public Kayttoliittyma(Ruudukko ruudukko){
        this.ruudukko = ruudukko;
        this.ruudukonNapit = new JButton[ruudukko.getKoko()][ruudukko.getKoko()];
        
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

    private JPanel luoRuudukko() {
        GridLayout layout = new GridLayout(ruudukko.getKoko(), ruudukko.getKoko());
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        
//        RuudukonKuuntelija ruudukonKuuntelija = new RuudukonKuuntelija(this.ruudukko);

        for (int i = 0; i < ruudukko.getKoko(); i++) {
            for (int j = 0; j < ruudukko.getKoko(); j++) {
                SoluNappi nappi = new SoluNappi(ruudukko.getSolu(i, j)); 
                ruudukonNapit[i][j] = nappi;
                SolunKuuntelija solunKuuntelija = new SolunKuuntelija(nappi,ruudukko.getSolu(i, j));
//                 tehdään napeista enemmän neliön mallisia
                nappi.setPreferredSize(new Dimension(10,10));
//                nappi.setSize(10, 10);
                nappi.setMinimumSize(new Dimension(10,10));
                nappi.setMaximumSize(new Dimension(10,10));
                panel.add(nappi);
                // napille action listener
                nappi.addActionListener(solunKuuntelija);
                nappi.setBackground(Color.white);
            }
        }

        return panel;
    }

    private JPanel luoValikko() {
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.setLayout(layout);

        JButton randomNappi = new JButton("Satunnainen alkutilanne");
        JButton tyhjennysNappi = new JButton("Tyhjennä ruudukko");
        JButton aloitusNappi = new JButton("Aloita peli");
        JButton lopetusNappi = new JButton("Lopeta peli");
        JButton askelNappi = new JButton("Askel eteenpäin");

        panel.add(randomNappi);
        panel.add(tyhjennysNappi);
        panel.add(aloitusNappi);
        panel.add(lopetusNappi);
        panel.add(askelNappi);

        NappienKuuntelija nappienKuuntelija = new NappienKuuntelija(this.ruudukko, ruudukonNapit);
        randomNappi.addActionListener(nappienKuuntelija);
        tyhjennysNappi.addActionListener(nappienKuuntelija);
        aloitusNappi.addActionListener(nappienKuuntelija);
        lopetusNappi.addActionListener(nappienKuuntelija);
        askelNappi.addActionListener(nappienKuuntelija);
        
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

}
