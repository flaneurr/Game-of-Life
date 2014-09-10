/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logiikka;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Kisuli
 */
public class Ruudukko {
    
    private Solu[][] solut;
    
    
    public Ruudukko (){ // todennäköisesti tulee useita konstruktoreja
        
        solut = new Solu[20][20];
        Random rand = new Random();
 
        for (int i = 0; i < solut.length ; i++){
            for (int j = 0 ; j < solut[i].length ; j++){
                int tila = rand.nextInt(2); // arvotaan alussa solu joko eläväksi tai kuolleeksi'
                Solu solu = new Solu(i,j,tila);
                solut[i][j] = solu;
            }
        }
    }
    
    public Solu getSolu(int x, int y){
        return this.solut[x][y];       
    }
    
    public void paivitaTilat(){
        // kutsutaan säännön päivitysmetodia, joka päivittää jokaisen solu tilan kerrallaan - muista aika-askleleet!
        Solu[][] edellinenRuudukko = solut.clone();
        ArrayList<Integer> syntyma = new ArrayList<Integer>();
        syntyma.add(2);
        ArrayList<Integer> selviaminen = new ArrayList<Integer>();
        selviaminen.add(2);
        selviaminen.add(3);
        
        Saanto saanto = new Saanto(syntyma, selviaminen);
        
        for (int i = 0; i < solut.length ; i++){
            for (int j = 0 ; j < solut[i].length ; j++){
                Solu solu = getSolu(i,j);
                solu.setTila(saanto.seuraavaTila(solu.getTila(), solu.montakoElavaaNaapuria()));
            }
        }
    }
    
    public void tulostaRuudukko(){
        for (int i = 0; i < solut.length ; i++){
            for (int j = 0 ; j < solut[i].length ; j++){
                System.out.print(Integer.toString(getSolu(i,j).getTila()));
            }
            System.out.println("");
        }
    }
    
}
