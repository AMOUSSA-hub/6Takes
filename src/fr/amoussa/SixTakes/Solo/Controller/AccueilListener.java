package fr.amoussa.SixTakes.Solo.Controller;
import java.awt.event.*;
import javax.swing.*;

import fr.amoussa.SixTakes.Multijoueur.View.Lobby;
import fr.amoussa.SixTakes.Solo.View.*;

public class AccueilListener implements ActionListener {

    private JFrame fen ;
    private JSpinner nbr_player;
    private JDialog jdial;

    public AccueilListener(JFrame f){
        this.fen = f;
    }
    public AccueilListener(JSpinner n, JDialog jd){
        this.nbr_player = n;
        this.jdial = jd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if( e.getActionCommand() =="Partie Solo"){
            this.fen.dispose();
            new FormNumberPlayer();
           
        }

        if( e.getActionCommand() =="Multijoueur"){
            String[] option = {"Créer une partie","Rejoindre une partie"};
            int c = JOptionPane.showOptionDialog(fen, "Choisissez :", "Multijoueur", JOptionPane.DEFAULT_OPTION, 0, null,option, e);
            
            if(c== 0){
                new Lobby();
            }
        } 
    }   
}
