package fr.amoussa.SixTakes.View;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.*;

import fr.amoussa.SixTakes.Utils.Icone;
import fr.amoussa.SixTakes.View.FormNumberPlayer;

public class GameFen extends JFrame {


    public GameFen(int nbr_player){

        int hauteur = (int)Icone.tailleEcran.getHeight(); 
        int largeur = (int)Icone.tailleEcran.getWidth();
        setLocation(0,0);
        setSize(largeur,hauteur);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        add(new GameBoard(nbr_player));
        
        setVisible(true);
        
        
    }

   
    
}
