package fr.amoussa.SixTakes.View;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.*;

import fr.amoussa.SixTakes.View.FormNumberPlayer;

public class GameFen extends JFrame {


    public GameFen(int nbr_player){
        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int hauteur = (int)tailleEcran.getHeight(); 
        int largeur = (int)tailleEcran.getWidth();
        setLocation(0,0);
        setSize(largeur,hauteur);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        add(new GameBoard(nbr_player));
        
        setVisible(true);
        
        
    }

   
    
}
