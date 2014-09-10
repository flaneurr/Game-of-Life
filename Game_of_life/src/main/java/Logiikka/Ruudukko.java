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
    private Saanto saanto;
    
    public Ruudukko (){ 
        ArrayList<Integer> syntyma = new ArrayList<>();
        syntyma.add(3);
        ArrayList<Integer> selviaminen = new ArrayList<>();
        selviaminen.add(2);
        selviaminen.add(3);
        
        this.saanto = new Saanto(syntyma, selviaminen);
        
        this.solut = new Solu[20][20];
        Random rand = new Random();
 
        for (int i = 0; i < solut.length ; i++){
            for (int j = 0 ; j < solut[i].length ; j++){
                int tila = rand.nextInt(2); // arvotaan alussa solu joko eläväksi tai kuolleeksi
                Solu solu = new Solu(i,j,tila);
                solut[i][j] = solu;
            }
        }
    }
    
    public Solu getSolu(int x, int y){
        return this.solut[x][y];       
    }
    
    public void luoSaanto(ArrayList<Integer> syntyma, ArrayList<Integer> selviaminen){
        this.saanto.setSyntyma(syntyma);
        this.saanto.setSelviaminen(selviaminen);
    }
    
    public void paivitaRuudukko(){
        Solu[][] edellinenRuudukko = solut.clone();
        
        for (int i = 0; i < solut.length ; i++){
            for (int j = 0 ; j < solut[i].length ; j++){
               Solu solu = getSolu(i,j);
               // lasketaan naapurien lkm
               int elavienNaapurienLkm = elavienNaapurienLkm(edellinenRuudukko, solu);
               // lasketaan solulle uusi tila
               solu.setTila(saanto.seuraavaTila(solu.getTila(), elavienNaapurienLkm));
            }
        }
    }
    
    public int elavienNaapurienLkm(Solu[][] edellinenRuudukko, Solu solu){
        int lkm = 0;
        int x = solu.getX();
        int y = solu.getY();
        
        if (x == 0 && y == 0){
            lkm =+ edellinenRuudukko[0][edellinenRuudukko[x].length-1].getTila();
            lkm =+ edellinenRuudukko[edellinenRuudukko.length-1][0].getTila();
            lkm =+ edellinenRuudukko[x+1][y].getTila();
            lkm =+ edellinenRuudukko[x][y+1].getTila();
        } else if (x == 0 && y == edellinenRuudukko[0].length-1){
            lkm =+ edellinenRuudukko[x][0].getTila();
            lkm =+ edellinenRuudukko[edellinenRuudukko.length-1][y].getTila();
            lkm =+ edellinenRuudukko[x+1][y].getTila();
            lkm =+ edellinenRuudukko[x][y-1].getTila();
        } else if (x == edellinenRuudukko.length-1 && y == 0){
            lkm =+ edellinenRuudukko[0][y].getTila();
            lkm =+ edellinenRuudukko[x][edellinenRuudukko[x].length-1].getTila();
            lkm =+ edellinenRuudukko[x-1][y].getTila();
            lkm =+ edellinenRuudukko[x][y+1].getTila();            
        } else if (x == edellinenRuudukko.length-1 && y == edellinenRuudukko[x].length-1){
            lkm =+ edellinenRuudukko[x][0].getTila();
            lkm =+ edellinenRuudukko[0][y].getTila();
            lkm =+ edellinenRuudukko[x-1][y].getTila();
            lkm =+ edellinenRuudukko[x][y-1].getTila();
        } else if (x == 0){
            lkm =+ edellinenRuudukko[edellinenRuudukko.length-1][y].getTila();
            lkm =+ edellinenRuudukko[x][y-1].getTila();
            lkm =+ edellinenRuudukko[x+1][y].getTila();
            lkm =+ edellinenRuudukko[x][y+1].getTila();
        } else if (y == 0){
            lkm =+ edellinenRuudukko[x][edellinenRuudukko[x].length-1].getTila();
            lkm =+ edellinenRuudukko[x-1][y].getTila();
            lkm =+ edellinenRuudukko[x+1][y].getTila();
            lkm =+ edellinenRuudukko[x][y+1].getTila();
        } else if (x == edellinenRuudukko.length-1){
            lkm =+ edellinenRuudukko[x][y+1].getTila();
            lkm =+ edellinenRuudukko[x][y-1].getTila();
            lkm =+ edellinenRuudukko[x-1][y].getTila();
            lkm =+ edellinenRuudukko[0][y].getTila();
        } else if (y == edellinenRuudukko[0].length-1){
            lkm =+ edellinenRuudukko[x-1][y].getTila();
            lkm =+ edellinenRuudukko[x][y-1].getTila();
            lkm =+ edellinenRuudukko[x+1][y].getTila();
            lkm =+ edellinenRuudukko[x][0].getTila();
        } else {
            lkm =+ edellinenRuudukko[x-1][y].getTila();
            lkm =+ edellinenRuudukko[x][y-1].getTila();
            lkm =+ edellinenRuudukko[x+1][y].getTila();
            lkm =+ edellinenRuudukko[x][y+1].getTila();
        }
        
        return lkm;
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
