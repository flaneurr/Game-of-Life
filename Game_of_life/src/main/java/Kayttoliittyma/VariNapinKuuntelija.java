/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kisuli
 */
public class VariNapinKuuntelija implements ActionListener {

    private Kayttoliittyma kayttoliittyma;

    public VariNapinKuuntelija(Kayttoliittyma kayttoliittyma){
        this.kayttoliittyma = kayttoliittyma;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        kayttoliittyma.varitPaalla(!kayttoliittyma.getVaritPaalla());
    }

}
