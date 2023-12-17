package fr.amoussa.SixTakes.Solo.View;


import javax.swing.*;

import fr.amoussa.SixTakes.Solo.Controller.*;

import java.awt.*;


public class Accueil extends JFrame {


    public Accueil(){


        getContentPane().setBackground(new Color(55,131,65));
        
        setSize(300,200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        JButton solo = new JButton("Partie Solo");
        JButton multi = new JButton("Multijoueur");
        JButton quit = new JButton("Quitter");

        add(solo);
        add(multi);
        add(quit);
        solo.addActionListener(new AccueilListener(this));
        multi.addActionListener(new AccueilListener(this));
        quit.addActionListener(e -> this.dispose());
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    } 
}
