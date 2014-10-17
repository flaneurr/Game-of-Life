
package Kayttoliittyma.Tapahtumakuuntelijat;

import Logiikka.Solu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Kisuli
 */
public class SolunKuuntelija implements ActionListener{
    
    private JButton nappi;
    private Solu solu;
    
    public SolunKuuntelija(JButton nappi, Solu solu){
        this.nappi = nappi;
        this.solu = solu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(solu.getTila()){
            solu.setTila(false);
            nappi.setBackground(Color.white);
        }else {
            solu.setTila(true);
            nappi.setBackground(Color.black);
        }
    }
    
}
