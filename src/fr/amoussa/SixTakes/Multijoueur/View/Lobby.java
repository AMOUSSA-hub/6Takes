package fr.amoussa.SixTakes.Multijoueur.View;

import javax.swing.*;
import java.awt.BorderLayout;
import java.util.*;

import fr.amoussa.SixTakes.Solo.View.GameFen;

public class Lobby extends JDialog {



    public Lobby(){
        System.out.println();
        setSize(200,200);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         setLocationRelativeTo(null);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList playerList = new JList<>(listModel);
        listModel.addElement("Joueur 1");
        JButton confirm = new JButton("Lancer la partie");
        setResizable(false);
    
    

        //confirm.addActionListener(e ->{new GameFen((Integer)nbr_player.getValue());this.dispose();});
        add(playerList,BorderLayout.NORTH);
        add(confirm,BorderLayout.SOUTH);
        pack();
       
        setVisible(true);
    }



    
    
    
}
