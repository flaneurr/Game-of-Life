package Logiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 * Luokka sisältää matriisin soluja ja niiden päivityssäännön, jotka yhdessä
 * simuloivat Conwayn Game of Lifea.
 *
 * @author Kisuli
 */
public class Ruudukko {

    private Solu[][] solut;
    private Saanto saanto;
    private int koko;
    private ArrayList<Kuvio> kuviot;
    private Kuviontunnistaja kuviontunnistaja;

    public Ruudukko() {
        kuviot = new ArrayList<Kuvio>();
        kuviontunnistaja = new Kuviontunnistaja();
        this.koko = 50;
        ArrayList<Integer> syntyma = new ArrayList<>();
        syntyma.add(3);
        ArrayList<Integer> selviaminen = new ArrayList<>();
        selviaminen.add(2);
        selviaminen.add(3);

        this.saanto = new Saanto(syntyma, selviaminen);

        this.solut = new Solu[koko][koko];
        Random rand = new Random();

        for (int i = 0; i < solut.length; i++) {
            for (int j = 0; j < solut[i].length; j++) {
                // arvotaan alussa solu joko eläväksi tai kuolleeksi
                int arpa = rand.nextInt(2);
                boolean tila = true;
                if (arpa == 0) {
                    tila = false;
                }
                Solu solu = new Solu(i, j, tila);
                solut[i][j] = solu;
            }
        }
    }

    // konstruktori, joka luo kaikki solut alussa kuolleiksi
    public Ruudukko(int koko) {
        this.koko = koko;
        kuviot = new ArrayList<>();
        kuviontunnistaja = new Kuviontunnistaja();
        ArrayList<Integer> syntyma = new ArrayList<>();
        syntyma.add(3);
        ArrayList<Integer> selviaminen = new ArrayList<>();
        selviaminen.add(2);
        selviaminen.add(3);
        this.saanto = new Saanto(syntyma, selviaminen);
        this.solut = new Solu[koko][koko];
        for (int i = 0; i < solut.length; i++) {
            for (int j = 0; j < solut[i].length; j++) {
                Solu solu = new Solu(i, j, false);
                solut[i][j] = solu;
            }
        }
    }

    public void paivitaKuviot() {
        this.kuviot = kuviontunnistaja.etsiKuviot(this.solut);
    }

    public int getKoko() {
        return this.koko;
    }

    public Solu getSolu(int x, int y) {
        return this.solut[x][y];
    }

    /**
     * Luo uuden säännön, jonka perusteella määräytyy solujen tilan muutokset
     *
     * @param syntyma lista, joka sisältää ne solun naapurien lukumäärät, joilla
     * kuollut solu herää henkiin
     * @param selviaminen lista, jossa ne solun naapurien lukumäärät, joilla
     * elvä solu selviää
     */
    public void luoSaanto(ArrayList<Integer> syntyma, ArrayList<Integer> selviaminen) {
        this.saanto.setSyntyma(syntyma);
        this.saanto.setSelviaminen(selviaminen);
    }

    /**
     * Asettaa kaikki ruudukon solu kuolleksi
     */
    public void tyhjennaRuudukko() {
        for (int i = 0; i < this.solut.length; i++) {
            for (int j = 0; j < this.solut[i].length; j++) {
                getSolu(i, j).setTila(false);
            }
        }
    }

    public void muutaTiloja() {
        for (int i = 0; i < this.solut.length; i++) {
            getSolu(i, 0).setTila(true);
        }
    }

    /**
     * Asettaa ruudukon solut satunnaisiin tiloihin. Solulla on 50 %
     * todennäköisyys olla elossa.
     */
    public void satunnaistaRuudukko() {
        // tällä hetkellä satunnaistaa ruudukon siten, että noin puolet soluista elossa
        Random rand = new Random();
        for (int i = 0; i < this.solut.length; i++) {
            for (int j = 0; j < this.solut[i].length; j++) {
                int arpa = rand.nextInt(10);
                boolean tila = true;
                if (arpa > 2) {
                    tila = false;
                }
                getSolu(i, j).setTila(tila);
            }
        }
    }

    /**
     * Solujen tilat päivitetään ruudukon säännön mukaan yhden iteraation
     * verran.
     */
    public void paivitaRuudukko() {

        // tehdään kopio edellisestä ruudukosta
        Solu[][] edellinenRuudukko = new Solu[solut.length][solut[0].length];
        for (int i = 0; i < solut.length; i++) {
            for (int j = 0; j < solut[i].length; j++) {
                Solu solu = solut[i][j];
                edellinenRuudukko[i][j] = new Solu(solu.getX(), solu.getX(), solu.getTila());
            }
        }
        // päivitetään ruudukon solujen tilat 
        for (int i = 0; i < solut.length; i++) {
            for (int j = 0; j < solut[i].length; j++) {
                Solu solu = getSolu(i, j);
                // lasketaan naapurien lkm
                int elavienNaapurienLkm = elavienNaapurienLkm(edellinenRuudukko, solu);
                // lasketaan solulle uusi tila
                solu.setTila(saanto.seuraavaTila(solu.getTila(), elavienNaapurienLkm));
            }
        }
        // päivitetään kuviot ja annetaan soluille udet värit.
        paivitaKuviot(); // <-aiheuttaa onglemia; peliä ei voi pelata eteenpäin kun tätä metodia kutsutaan
    }

    /**
     * Kertoo onko solun yläpuolinen naapuri elossa.
     *
     * @param edellinenRuudukko edellisen iteraation ruudukko
     * @param solu solu, jonka yläpuolista naapuria tarkastellaan
     * @return palauttaa 1, jos yläpuolinen naapuri on elossa ja 0, jos se on
     * kuollut
     */
    public int ylosElossa(Solu[][] edellinenRuudukko, Solu solu) {
        int elossa = 0;
        if (solu.getX() == 0) {
            if (edellinenRuudukko[edellinenRuudukko.length - 1][solu.getY()].getTila()) {
                elossa = 1;
            }
        } else {
            if (edellinenRuudukko[solu.getX() - 1][solu.getY()].getTila()) {
                elossa = 1;
            }
        }
        return elossa;
    }

    /**
     * Kertoo onko solun alapuolinen naapuri elossa.
     *
     * @param edellinenRuudukko edellisen iteraation ruudukko
     * @param solu solu, jonka alapuolista naapuria tarkastellaan
     * @return palauttaa 1, jos alapuolinen naapuri on elossa ja 0, jos se on
     * kuollut
     */
    public int alasElossa(Solu[][] edellinenRuudukko, Solu solu) {
        int elossa = 0;
        if (solu.getX() == edellinenRuudukko.length - 1) {
            if (edellinenRuudukko[0][solu.getY()].getTila()) {
                elossa = 1;
            }
        } else {
            if (edellinenRuudukko[solu.getX() + 1][solu.getY()].getTila()) {
                elossa = 1;
            }
        }
        return elossa;
    }

    /**
     * Kertoo onko solun oikeanpuolinen naapuri elossa.
     *
     * @param edellinenRuudukko edellisen iteraation ruudukko
     * @param solu solu, jonka oikeanpuolista naapuria tarkastellaan
     * @return palauttaa 1, jos oikeanpuolinen naapuri on elossa ja 0, jos se on
     * kuollut
     */
    public int oikeaElossa(Solu[][] edellinenRuudukko, Solu solu) {
        int elossa = 0;
        if (solu.getY() == edellinenRuudukko[solu.getX()].length - 1) {
            if (edellinenRuudukko[solu.getX()][0].getTila()) {
                elossa = 1;
            }
        } else {
            if (edellinenRuudukko[solu.getX()][solu.getY() + 1].getTila()) {
                elossa = 1;
            }
        }
        return elossa;
    }

    /**
     * Kertoo onko solun vasemmanpuolinen naapuri elossa.
     *
     * @param edellinenRuudukko edellisen iteraation ruudukko
     * @param solu solu, jonka vasemmanpuolista naapuria tarkastellaan
     * @return palauttaa 1, jos vasemmanpuolinen naapuri on elossa ja 0, jos se
     * on kuollut
     */
    public int vasenElossa(Solu[][] edellinenRuudukko, Solu solu) {
        int elossa = 0;
        if (solu.getY() == 0) {
            if (edellinenRuudukko[solu.getX()][edellinenRuudukko[solu.getX()].length - 1].getTila()) {
                elossa = 1;
            }
        } else {
            if (edellinenRuudukko[solu.getX()][solu.getY() - 1].getTila()) {
                elossa = 1;
            }
        }
        return elossa;
    }

    /**
     * Kertoo onko solun vasemmanpuolinen ylänurkkanaapuri elossa.
     *
     * @param edellinenRuudukko edellisen iteraation ruudukko
     * @param solu solu, jonka vasemmanpuolista ylänurkkanaapuria tarkastellaan
     * @return palauttaa 1, jos vasemmanpuolinen ylänurkkanaapuri on elossa ja
     * 0, jos se on kuollut
     */
    // toimii
    public int vasenYlaElossa(Solu[][] edellinenRuudukko, Solu solu) {
        int elossa = 0;
        if (solu.getX() == 0 && solu.getY() == 0) {
            if (edellinenRuudukko[edellinenRuudukko.length - 1][edellinenRuudukko[0].length - 1].getTila()) {
                elossa = 1;
            }
        } else if (solu.getX() == 0) {
            if (edellinenRuudukko[edellinenRuudukko.length - 1][solu.getY() - 1].getTila()) {
                elossa = 1;
            }
        } else if (solu.getY() == 0) {
            if (edellinenRuudukko[solu.getX() - 1][edellinenRuudukko[solu.getX()].length - 1].getTila()) {
                elossa = 1;
            }
        } else {
            if (edellinenRuudukko[solu.getX() - 1][solu.getY() - 1].getTila()) {
                elossa = 1;
            }
        }
        return elossa;
    }

    /**
     * Kertoo onko solun oikeanpuolinen ylänurkkanaapuri elossa.
     *
     * @param edellinenRuudukko edellisen iteraation ruudukko
     * @param solu solu, jonka oikeanpuolista ylänurkkanaapuria tarkastellaan
     * @return palauttaa 1, jos oikeaanpuolinen ylänurkkanaapuri on elossa ja 0,
     * jos se on kuollut
     */
    // toimii!
    public int oikeaYlaElossa(Solu[][] edellinenRuudukko, Solu solu) {
        int elossa = 0;
        if (solu.getX() == 0 && solu.getY() == edellinenRuudukko[solu.getX()].length - 1) {
            if (edellinenRuudukko[edellinenRuudukko.length - 1][0].getTila()) {
                elossa = 1;
            }
        } else if (solu.getX() == 0) {
            if (edellinenRuudukko[edellinenRuudukko.length - 1][solu.getY() + 1].getTila()) {
                elossa = 1;
            }
        } else if (solu.getY() == edellinenRuudukko[solu.getX()].length - 1) {
            if (edellinenRuudukko[solu.getX() - 1][0].getTila()) {
                elossa = 1;
            }
        } else {
            if (edellinenRuudukko[solu.getX() - 1][solu.getY() + 1].getTila()) {
                elossa = 1;
            }
        }
        return elossa;
    }

    /**
     * Kertoo onko solun oikeanpuolinen alanurkkanaapuri elossa.
     *
     * @param edellinenRuudukko edellisen iteraation ruudukko
     * @param solu solu, oikeanpuolinen alanurkkanaapuria tarkastellaan
     * @return palauttaa 1, jos oikeanpuolinen alanurkkanaapuri on elossa ja 0,
     * jos se on kuollut
     */
    // toimii 
    public int oikeaAlaElossa(Solu[][] edellinenRuudukko, Solu solu) {
        int elossa = 0;
        if (solu.getX() == edellinenRuudukko.length - 1 && solu.getY() == edellinenRuudukko[solu.getX()].length - 1) {
            if (edellinenRuudukko[0][0].getTila()) {
                elossa = 1;
            }
        } else if (solu.getX() == edellinenRuudukko.length - 1) {
            if (edellinenRuudukko[0][solu.getY() + 1].getTila()) {
                elossa = 1;
            }
        } else if (solu.getY() == edellinenRuudukko[solu.getX()].length - 1) {
            if (edellinenRuudukko[solu.getX() + 1][0].getTila()) {
                elossa = 1;
            }
        } else {
            if (edellinenRuudukko[solu.getX() + 1][solu.getY() + 1].getTila()) {
                elossa = 1;
            }
        }
        return elossa;
    }

    /**
     * Kertoo onko solun vasemmanpuolinen alanurkkanaapuri elossa.
     *
     * @param edellinenRuudukko edellisen iteraation ruudukko
     * @param solu solu, vasemmanpuolinen alanurkkanaapuria tarkastellaan
     * @return palauttaa 1, jos vasemmanpuolinen alanurkkanaapuri on elossa ja
     * 0, jos se on kuollut
     */
    // toimii
    public int vasenAlaElossa(Solu[][] edellinenRuudukko, Solu solu) {
        int elossa = 0;
        if (solu.getX() == edellinenRuudukko.length - 1 && solu.getY() == 0) {
            if (edellinenRuudukko[0][solut[0].length - 1].getTila()) {
                elossa = 1;
            }
        } else if (solu.getX() == edellinenRuudukko.length - 1) {
            if (edellinenRuudukko[0][solu.getY() - 1].getTila()) {
                elossa = 1;
            }
        } else if (solu.getY() == 0) {
            if (edellinenRuudukko[solu.getX() + 1][edellinenRuudukko[solu.getY()].length - 1].getTila()) {
                elossa = 1;
            }
        } else {
            if (edellinenRuudukko[solu.getX() + 1][solu.getY() - 1].getTila()) {
                elossa = 1;
            }
        }
        return elossa;
    }

    /**
     * Laskee kuinka monta solun kahdeksasta naapurista on elossa.
     *
     * @param edellinenRuudukko edellisen iteraation ruudukko
     * @param solu solu, jonka aapureiden lukumäärää lasketaan
     * @return
     */
    public int elavienNaapurienLkm(Solu[][] edellinenRuudukko, Solu solu) {
        int lkm = +ylosElossa(edellinenRuudukko, solu) + alasElossa(edellinenRuudukko, solu) + vasenElossa(edellinenRuudukko, solu) + oikeaElossa(edellinenRuudukko, solu)
                + oikeaAlaElossa(edellinenRuudukko, solu) + vasenAlaElossa(edellinenRuudukko, solu) + oikeaYlaElossa(edellinenRuudukko, solu) + vasenYlaElossa(edellinenRuudukko, solu);
        return lkm;
    }

    public void tulostaRuudukko() {
        int tila;
        for (int i = 0; i < solut.length; i++) {
            for (int j = 0; j < solut[i].length; j++) {
                if (getSolu(i, j).getTila()) {
                    tila = 1;
                } else {
                    tila = 0;
                }
                System.out.print(Integer.toString(tila));
            }
            System.out.println("");
        }
    }

    // yksinkertainen getteri Kuviontunnistajaa varten
    public Solu[][] getSolut() {
        return this.solut;
    }

    public boolean kaikkiKuolleita() {
        for (int i = 0; i < solut.length; i++) {
            for (int j = 0; j < solut[i].length; j++) {
                if (solut[i][j].getTila()) {
                    return false;
                }
            }
        }
        return true;
    }

}
