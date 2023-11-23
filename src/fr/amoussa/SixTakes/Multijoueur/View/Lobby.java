package fr.amoussa.SixTakes.Multijoueur.View;

import javax.swing.*;
import java.util.*;

import fr.amoussa.SixTakes.Solo.View.GameFen;

public class Lobby extends JDialog {



    public Lobby(){
        System.out.println();
        setSize(200,200);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         setLocationRelativeTo(null);
        JSpinner nbr_player = new JSpinner(new SpinnerNumberModel(2,2,10,1) );
        JButton confirm = new JButton("Ok");
        add(new JLabel("<html>Sélectionner le nombre de joueurs<br>(de 2 à 10 joueurs)</html>"));
        setResizable(false);

        confirm.addActionListener(e ->{new GameFen((Integer)nbr_player.getValue());this.dispose();});
        add(nbr_player);
        add(confirm);
        pack();
       
        setVisible(true);
    }



    
    
    
}
