###Aihemäärittely

####Aihe:
Tämä on ohjelma, joka toteuttaa graafisesti John Conwayn Game of Lifen. Game of Life on tunnettu soluautomaatti, jossa kukin solu on tietyllä ajanhetkellä joko "elossa" tai "kuollut". Tätä sanotaan solun *tilaksi*. Solujen tila riippuu tietyn säännön mukaan sen naapureiden tiloista, ja tilaa päivitetään kullakin aika-askeleella. Perinteisessä Game of Lifessa solu syntyy, kun sillä on kolme naapuria ja selviää hengissä kolmella tai kahdella naapurilla. Käyttäjä voi kuitenkin vapaasti valita ohjelman käyttämän säännön. Vaikka Game of Lifen säännöt ovat hyvin yksinkertaiset, niin solut käyttäytyvät kuitenkin hyvin ennalta-arvaamattomasti ja monimutkaisesti.

Toisena ominaisuutena ohjelmassa on solujen värittäminen. Solun ollessa kuollut solu on valkoinen, mutta elossa olevan solun väri riippuu sen ympärillä olevien elävien solujen määrästä. Ohjelma etsii ruudukosta yhtenäisiä elävien solujen alueita ja värittää ne sen mukaan, montako solua kyseiseen alueeseen kuuluu. Käytössä olevia värejä on viisi.

####Toiminnot:
- Pelin käynnistäminen
  - Käynnistää simulaation ja jatkaa niin kauan kunnes peli pysäytetään
- Pelin pysäyttäminen
- Pelin edistäminen yhdellä askeleella
- Solun tilan vaihtaminen
  - Klikkaamalla solua milloin tahansa ohjelman suorituksen aikana
- Satunnaisen tilanteen arpominen
  - Noin 30 % soluista elossa
- Ruudukon tyhjentäminen
  - Kaikkien solujen tilan muuttaminen kuolleeksi
- Säännön vaihtaminen
  - Valittavana on mikä tahansa mahdollinen sääntö
- Värien käyttäminen
  - Käyttäjä voi valita käyttävänsä solujen väritystä tai laittaa ominaisuuden pois päältä


