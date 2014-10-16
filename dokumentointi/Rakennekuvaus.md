#####Rakennekuvaus

Ohjelman logiikka koostuu viidestä luokasta. Ne voidaan jakaa karkeasti Game of Life-pelin säännöt toteuttaviin luokkiin ja solujen värityksestä vastaaviin luokkiin.

Pelin säännöt ovat totetutettuna Ruudukko-, Saanto-, ja Solu-luokissa. Ruudukko sisältää Soluja ja hoitaa Solujen tilojen muutokset. Ruudukko sisältää metodit Solujen tilojen satunnaistamiselle, asettamiselle kuolleeksi ja päivittämiselle voimassa olevan päivitysssäännön mukaan. Ruudukko tarkistaa Solujen elossa olevien naapurien lukumäärän, kun solujen tilat päivitetään säännön mukaan. Ruudukko tuntee myös Saanto-luokan olion, jota hyödynnetään Solujen tilan päivityksessä.

Solut ovat Game of Lifen alkeellisia rakennuspalikoita, jotak tietävät vain koordinaattinsa, tilansa ja värinsä. Solu-luokassa on metodit Solun tilan ja värin muuttamiseen.

Saanto-luokka sisältää kaksi listaa, joilla on kuoleen solun henkiin herättämiseksi ja elävän solun selviämiseksi tarvittavat elävien naapurien lukumäärät. Ruudukko tarkistaa aina solujen tilan päivittämisen aikana Saannon metodia, jolla tarkistetaan onko tietty Solu kuollut vai elossa sen elävien naapurien lukumäärän perusteella.

Ruudukko tuntee myös Kuviontunnistajan, joka etsii ruudukon Solujen muodostamia yhtenäisiä kuvioita ja värittää ne kuvion koon mukaan. Kuviontunnistaja pitää kirjaa Kuvioista. Kuvio-luokan ilmentyvät tietävät oman värinsä ja sisältää Solut, jotka muodostavat kyseisen Kuvion. Solujen väri-atrribuutti on peräisin siltä Kuviolta, johon Solu kuuluu.
