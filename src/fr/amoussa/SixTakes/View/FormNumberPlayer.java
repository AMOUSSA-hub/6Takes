package fr.amoussa.SixTakes.View;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import fr.amoussa.SixTakes.Controller.*;
import fr.amoussa.SixTakes.View.*;

public class FormNumberPlayer extends JDialog {


    public FormNumberPlayer(){
        
        
        setLocation(800,350);
        setSize(300,200);
        setLayout(new GridLayout(3,1));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JSpinner nbr_player = new JSpinner(new SpinnerNumberModel(2,2,10,1) );
        JButton confirm = new JButton("Ok");
        add(new JLabel("Sélectionner le nombre de joueurs"));

        confirm.addActionListener(new AccueilListener(nbr_player,this));
        add(nbr_player);
        add(confirm);
        pack();
        setVisible(true);
    }



    
    
}
