package fr.amoussa.SixTakes.Solo.View;

import java.awt.*;

import javax.swing.*;

import fr.amoussa.SixTakes.Solo.Model.Game;
import fr.amoussa.SixTakes.Solo.View.FormNumberPlayer;
import fr.amoussa.SixTakes.Utils.Icone;

/**
 * Fenêtre de la partie.
 */
public class GameFen extends JFrame {

    public GameFen(int nbr_player) {
        setTitle("6Takes");
        int hauteur = (int) Icone.tailleEcran.getHeight();
        int largeur = (int) Icone.tailleEcran.getWidth();
        setSize((int) (largeur * 0.7), (int) (hauteur * 0.7));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GameBoard view = new GameBoard(nbr_player);
        Game model = new Game(nbr_player, view);

        add(view);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
