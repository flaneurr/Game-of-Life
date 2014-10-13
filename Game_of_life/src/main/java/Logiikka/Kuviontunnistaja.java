package Logiikka;

import java.awt.Color;
import static java.awt.Color.BLACK;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Etsii ruudukosta yhtenäisiä alueita ja muodostaa niistä eri värisiä kuvioita.
 *
 * @author Kisuli
 */
public class Kuviontunnistaja {

    private ArrayList<Kuvio> kuviot;
    private Color[] varit;

    public Kuviontunnistaja() {
        this.kuviot = new ArrayList<>();
        this.varit = new Color[5];
        varit[0] = new Color(166, 19, 74);
        varit[1] = new Color(86, 169, 113); 
        varit[2] = new Color(0, 128, 128);
        varit[3] = new Color(163, 73, 164);
        varit[4] = new Color(64, 0, 128);
    }

    public void kerroVariKuviolle(Kuvio kuvio, Color vari) {
        kuvio.setVari(vari);
    }

    public void lisaaKuvio(Kuvio kuvio) {
        this.kuviot.add(kuvio);
    }

    /**
     * Käy ruudukon läpi ja etsii sieltä kaikki yhtenäiset kuviot sekä värittää
     * ne eri väreillä. Tässä samaan kuvioon kuuluu kaksi solua, jotka ovat
     * toistensa horisontaalisia tai vertikaalisia naapureita (diagonaalilla
     * olevat naapurit ovat siis eri kuviota, elleivät liity toisiinsa toisen
     * solun kautta). Metodi tekee elävien solmujen kohdalla leveyssuuntaisen
     * haun elävien naapurien etsimiseksi.
     *
     * @param solut ruudukon solut sisältävä matriisi
     * @return palauttaa listan löydetyistä kuvioista
     */
    public ArrayList<Kuvio> etsiKuviot(Solu[][] solut) {
        ArrayList<Solu> kaytetyt = new ArrayList<>();
        for (int i = 0; i < solut.length; i++) {
            for (int j = 0; j < solut[i].length; j++) {
                // tässä pitää myös stekata ettei mennä johonkin kuvioon kuuluvaan soluun
                if (solut[i][j].getTila() && !kaytetyt.contains(solut[i][j])) {
                    Solu lahto = solut[i][j];
                    // tarkistetaan otetaanko uusi kierros värejä
                    Kuvio kuvio = new Kuvio(Color.BLACK);
                    /* tässä kutsutaan bfs, kun lähtösoluna on tämä solu ja naapureina
                     * vertikaaliset ja horisontaaliset solut. Kuvioon lisätään soluja sitä 
                     * mukaan kun niitä löydetään.
                     */
                    bfsLuoKuvio(lahto, kuvio, solut, kaytetyt);
                    kuviot.add(kuvio);
                    kuvio.setVari(variKuvionKoonMukaan(kuvio));
                    kuvio.varitaSolut();
                }
            }
        }
        return this.kuviot;
    }

    public Color variKuvionKoonMukaan(Kuvio kuvio) {
        if (kuvio.getKoko() < 2) {
            return this.varit[0];
        } else if (kuvio.getKoko() < 3) {
            return this.varit[1];
        } else if (kuvio.getKoko() < 5) {
            return this.varit[2];
        } else if (kuvio.getKoko() < 6) {
            return this.varit[3];
        } else {
            return this.varit[4];
        }
    }

    /**
     * Tekee leveyssuuntaisen haun lähtösolusta ja lisää kaikki sen viereiset
     * elossa olevat solut samaan kuvioon
     *
     * @param lahto lähtösolmu, josta leveyssuuntainen haku aloitetaan
     * @param kuvio kuvio, johon tällä hetkellä lisätään soluja
     * @param solut ruudukon tuntema matriisi, jossa solut sijaitsevat
     * @param kaytetyt lista, jossa pidetään kirjaa läpikäydyistä soluista,
     * jottei sama solu olisi osa useampaa kuviota
     */
    public void bfsLuoKuvio(Solu lahto, Kuvio kuvio, Solu[][] solut, ArrayList<Solu> kaytetyt) {
        ArrayDeque<Solu> jono = new ArrayDeque<>();
        jono.add(lahto);
        kuvio.lisaaSolu(lahto);
        while (!jono.isEmpty()) {
            Solu solu = jono.remove();
            int x = solu.getX();
            int y = solu.getY();
            // jokaiselle vierussolmulle, siis neljä tapausta: ylös, alas, vasen, oikea
            // ylös  
            if (x - 1 >= 0 && solut[x - 1][y].getTila() && !kaytetyt.contains(solu)) {
                jono.add(solut[x - 1][y]);
                kuvio.lisaaSolu(solut[x - 1][y]);
            }
            // alas
            if (x + 1 < solut.length && solut[x + 1][y].getTila() && !kaytetyt.contains(solu)) { // <-- näissä ei olla otettu huomioon reunoja!!!!
                jono.add(solut[x + 1][y]);
                kuvio.lisaaSolu(solut[x + 1][y]);
            }
            // vasen
            if (y - 1 >= 0 && solut[x][y - 1].getTila() && !kaytetyt.contains(solu)) {
                jono.add(solut[x][y - 1]);
                kuvio.lisaaSolu(solut[x][y - 1]);
            }
            // oikea
            if (y + 1 < solut[x].length && solut[x][y + 1].getTila() && !kaytetyt.contains(solu)) {
                jono.add(solut[x][y + 1]);
                kuvio.lisaaSolu(solut[x][y + 1]);
            }
            kaytetyt.add(solu);
        }
    }

    public ArrayList<Kuvio> getKuviot() {
        return this.kuviot;
    }

}
