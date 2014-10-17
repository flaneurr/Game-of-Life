package Logiikka;

import java.util.ArrayList;

/**
 * Kuvaa Game of Lifessa olevaa joukkoa sääntöjä, jotka määräävät solujen tilan
 * seuraavan kierroksen aikana.
 *
 * @author Kisuli
 */
public class Saanto {

    /**
     * Lista elävien naapurien lukumääristä, joilla kuollut solu herää henkiin.
     */
    private ArrayList<Integer> syntyma;
    /**
     * Lista elävien naapurien lukumääristä, joilla elävä solu selviää.
     */
    private ArrayList<Integer> selviaminen;

    /**
     * Luo uuden säännön.
     *
     * @param syntyma lista niistä elävien naapurien lukumääristä, joilla
     * kuollut solu herää henkiin
     * @param selviaminen lista niistä elävien naapurien lukumääristä, joilla
     * elävä solu selviää
     */
    public Saanto(ArrayList<Integer> syntyma, ArrayList<Integer> selviaminen) {
        this.syntyma = syntyma;
        this.selviaminen = selviaminen;
    }

    /**
     * Määrittää solun tilan nykyisellä iteraatiolla Game of Lifessa
     *
     * @param edellinenTila kertoo mikä solun tila oli edellisellä iteraatiolla
     * @param naapurienLkm kertoo solun elossa olevien naapurien lukumäärän
     * @return solun seuraava tila (true = elossa, false = kuollut)
     */
    public boolean seuraavaTila(boolean edellinenTila, int naapurienLkm) {
        boolean seuraavaTila = false;
        if (edellinenTila == true && selviaminen.contains(naapurienLkm)) {
            seuraavaTila = true;
        } else if (edellinenTila == false && syntyma.contains(naapurienLkm)) {
            seuraavaTila = true;
        }
        return seuraavaTila;

    }

    /**
     * Asettaa uuden syntymäsäännön.
     *
     * @param syntyma lista niistä elävien naapurien lukumääristä, joilla
     * kuollut solu herää henkiin
     */
    public void setSyntyma(ArrayList<Integer> syntyma) {
        this.syntyma = syntyma;
    }

    /**
     * Lisää uuden kokonaisluvun syntyma-listaan.
     *
     * @param uusi
     */
    public void lisaaSyntyma(int uusi) {
        this.syntyma.add(uusi);
    }

    /**
     * Lisää uuden kokonaisluvun selviaminen-listaan.
     *
     * @param uusi
     */
    public void lisaaSelviaminen(int uusi) {
        this.selviaminen.add(uusi);
    }

    /**
     * Asettaa uuden selviamisssäännön.
     *
     * @param uusi lista niistä elävien naapurien lukumääristä, joilla elävä
     * solu selviää
     */
    public void setSelviaminen(ArrayList<Integer> selviaminen) {
        this.selviaminen = selviaminen;
    }

    public ArrayList<Integer> getSyntyma() {
        return this.syntyma;
    }

    public ArrayList<Integer> getSelviytyminen() {
        return this.selviaminen;
    }

    /**
     * Poistaa parametrina olevan elävien naapurien lukumäärän, jolla kuollut
     * solu syntyy, jos luku löytyy syntyma-listalta.
     *
     * @param synt poistettava elävien naapurien lukumäärä
     */
    public void poistaSyntyma(int synt) {
        if (this.syntyma.contains(synt)) {
            for (int i = 0; i < syntyma.size(); i++) {
                if (syntyma.get(i) == synt) {
                    syntyma.remove(i);
                }
            }
        }
    }

    /**
     * Poistaa parametrina olevan elävien naapurien lukumäärän, jolla elävä solu selviää,
     * jos luku löytyy syntyma-listalta.
     *
     * @param selv
     */
    public void poistaSelviaminen(int selv) {
        if (this.selviaminen.contains(selv)) {
            {
                for (int i = 0; i < selviaminen.size(); i++) {
                    if (selviaminen.get(i) == selv) {
                        selviaminen.remove(i);
                    }
                }
            }
        }
    }

}
