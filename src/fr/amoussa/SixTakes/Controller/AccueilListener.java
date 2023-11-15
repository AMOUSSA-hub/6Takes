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
            JOptionPane.showMessageDialog(fen, "Cette section n'est pas encore disponible", "Info",
        JOptionPane.INFORMATION_MESSAGE);
            
        } 
    }   
}
