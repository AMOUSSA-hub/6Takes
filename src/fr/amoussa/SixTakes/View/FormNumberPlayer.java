package fr.amoussa.SixTakes.View;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import fr.amoussa.SixTakes.Controller.*;
import fr.amoussa.SixTakes.Utils.Icone;
import fr.amoussa.SixTakes.View.*;

public class FormNumberPlayer extends JDialog {


    public FormNumberPlayer(){
        
        System.out.println();
        setSize(200,200);
        setLayout(new GridLayout(3,1));
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
