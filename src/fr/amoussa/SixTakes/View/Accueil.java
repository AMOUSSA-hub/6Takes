package fr.amoussa.SixTakes.View;


import javax.swing.*;

import fr.amoussa.SixTakes.Controller.*;

import java.awt.*;


public class Accueil extends JFrame {


    public Accueil(){
        setLocation(800,350);
        setSize(300,200);
        setLayout(new GridLayout(3,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton solo = new JButton("Partie Solo");
        JButton multi = new JButton("Multijoueur");
        JButton quit = new JButton("Quitter");

        add(solo);
        add(multi);
        add(quit);
        solo.addActionListener(new AccueilListener(this));
        multi.addActionListener(new AccueilListener(this));
        quit.addActionListener(new AccueilListener(this));

        setVisible(true);




    }
    
}
