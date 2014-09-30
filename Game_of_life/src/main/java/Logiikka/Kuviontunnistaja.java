package Logiikka;

import java.awt.Color;
import static java.awt.Color.BLACK;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Etsii ruudukosta yhtenäisiä alueita ja muodostaa niistä eri värisiä kuvioita.
 * @author Kisuli
 */
public class Kuviontunnistaja {

    private Ruudukko ruudukko;
    private ArrayList<Kuvio> kuviot;

    public Kuviontunnistaja(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.kuviot = new ArrayList<Kuvio>();
    }

    public void kerroVariKuviolle(Kuvio kuvio, Color vari) {
        kuvio.setVari(vari);
    }

    public void lisaaKuvio(Kuvio kuvio) {
        this.kuviot.add(kuvio);
    }
/**
 * Käy ruudukon läpi ja etsii sieltä kaikki yhtenäiset kuviot sekä värittää ne eri väreillä. Tässä samaan kuvioon
 * kuuluu kaksi solua, jotka ovat toistensa horisontaalisia tai vertikaalisia naapureita (diagonaalilla olevat naapurit
 * ovat siis eri kuviota, elleivät liity toisiinsa toisen solun kautta). Metodi tekee elävien solmujen kohdalla leveyssuuntaisen
 * haun elävien naapurien etsimiseksi.
 */
    public void etsiKuviot() {
        Solu[][] solut = this.ruudukko.getSolut();
        ArrayList<Solu> kaytetyt = new ArrayList<Solu>();
        for (int i = 0; i < solut.length; i++) {
            for (int j = 0; j < solut[i].length; j++) {
                if (solut[i][j].getTila()) { // tässä pitää myös stekata ettei mennä enää jo johonkin kuvioon kuuluvaan soluun
                    Solu lahto = solut[i][j];
                    Kuvio kuvio = new Kuvio(BLACK);
                    // tässä kutsutaan bfs, kun lähtösolmuna on tämä solu ja naapureina
                    // vertikaaliset ja horisontaaliset solut. Kuvioon lisätään soluja sitä 
                    // mukaan kun niitä löydetään.
                    bfsLuoKuvio(lahto, kuvio, solut, kaytetyt);
                }
            }
        }
    }

    /**
     * Tekee leveyssuuntaisen haun lähtösolusta ja lisää kaikki sen viereiset elossa olevat solut samaan kuvioon
     * @param lahto lähtösolmu, josta leveyssuuntainen haku aloitetaan
     * @param kuvio kuvio, johon tällä hetkellä lisätään soluja
     * @param solut ruudukon tuntema matriisi, jossa solut sijaitsevat
     * @param kaytetyt lista, jossa pidetään kirjaa läpikäydyistä soluista, jottei sama solu olisi osa useampaa kuviota
     */
    public void bfsLuoKuvio(Solu lahto, Kuvio kuvio, Solu[][] solut, ArrayList<Solu> kaytetyt) {
        ArrayDeque<Solu> jono = new ArrayDeque<Solu>();
        jono.add(lahto);
        while (!jono.isEmpty()) {
            Solu solu = jono.remove();
            int x = solu.getX();
            int y = solu.getY();
            // jokaiselle vierussolmulle, siis neljä tapausta: ylös, alas, vasen, oikea
            // ylös  
            if (solut[x - 1][y].getTila() && !kaytetyt.contains(solu)) {
                jono.add(solut[x - 1][y]);
                kuvio.lisaaSolu(solut[x - 1][y]);
            }
            // alas
            if (solut[x + 1][y].getTila() && !kaytetyt.contains(solu)) { // <-- näissä ei olla otettu huomioon reunoja!!!!
                jono.add(solut[x + 1][y]);
                kuvio.lisaaSolu(solut[x + 1][y]);
            }
            // vasen
            if (solut[x][y - 1].getTila() && !kaytetyt.contains(solu)) {
                jono.add(solut[x][y - 1]);
                kuvio.lisaaSolu(solut[x][y - 1]);
            }
            // oikea
            if (solut[x][y + 1].getTila() && !kaytetyt.contains(solu)) {
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
