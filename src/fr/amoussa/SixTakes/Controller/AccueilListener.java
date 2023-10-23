package fr.amoussa.SixTakes.Controller;

import java.awt.event.*;

import javax.swing.*;

import fr.amoussa.SixTakes.View.*;

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
            this.fen.dispose();
            
        }


        if( e.getActionCommand() =="Quitter"){
            System.exit(0);
        }

        if( e.getActionCommand() =="Ok"){
            new GameFen((Integer)nbr_player.getValue());
            this.jdial.dispose();
        }
    
    }
    
}
