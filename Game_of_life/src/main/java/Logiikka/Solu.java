package Logiikka;

import java.awt.Color;
import static java.awt.Color.BLACK;
import java.util.ArrayList;

/**
 * Game of Lifen solu. On joko elossa tai kuollut ja tuntee oman värinsä.
 *
 * @author Kisuli
 */
public class Solu {

    /**
     * Solun tila. Solu on joko elossa(true) tai kuollut(false).
     */
    private boolean tila;
    /**
     * Solun x-koordinaatti.
     */
    private int x;
    /**
     * Solun y-koordinaatti.
     */
    private int y;
    /**
     * Solun väri. Solu esiintyy tämän värisenä, kun se on elossa.
     */
    private Color vari;

    /**
     * Luo uuden solun.
     *
     * @param x solun x-koordinaatti
     * @param y solun y-koordinaatti
     * @param tila solun tila
     */
    public Solu(int x, int y, boolean tila) {

        this.x = x;
        this.y = y;
        this.tila = tila;
        this.vari = BLACK;

    }

    /**
     * Asettaa solulle uuden värin.
     *
     * @param vari solun uusi väri
     */
    public void setVari(Color vari) {
        this.vari = vari;
    }

    /**
     * Palauttaa solun tämänhetkisen värin.
     *
     * @return solun väri
     */
    public Color getVari() {
        return this.vari;
    }

    /**
     * Palauttaa solun tilan.
     *
     * @return solun tila
     */
    public boolean getTila() {
        return this.tila;
    }

    /**
     * Palauttaa solun x-koordinaatin.
     *
     * @return solun x-koordinaatti
     */
    public int getX() {
        return this.x;
    }

    /**
     * Palauttaa solun y-koordinaatin.
     *
     * @return solun y-koordinaatti
     */
    public int getY() {
        return this.y;
    }

    /**
     * Asettaa solulle uuden tilan
     *
     * @param tila solun uusi tila
     */
    public void setTila(boolean tila) {
        this.tila = tila;
    }
}
