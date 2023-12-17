package fr.amoussa.SixTakes.Solo.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import java.awt.*;

import fr.amoussa.SixTakes.Solo.Model.Player;

public class ResultFrame extends JDialog {

    // Constructeur de la classe ResultFrame
    public ResultFrame(List<Player> joueurs) {
        // Création d'une copie de la liste des joueurs
        List<Player> joueursTriés = new ArrayList<>(joueurs);

        // Tri des joueurs en fonction du malus
        Collections.sort(joueursTriés, Comparator.comparingInt(Player::getMalus));

        // Configuration de la boîte de dialogue
        setTitle("Résultats");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création d'un panneau pour une meilleure mise en page
        JPanel panneauPrincipal = new JPanel(new GridLayout(joueurs.size() + 1, 1, 20, 20));
        panneauPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Ajout d'une étiquette de titre
        JLabel étiquetteTitre = new JLabel("Résultats Finaux");
        étiquetteTitre.setHorizontalAlignment(SwingConstants.CENTER);
        étiquetteTitre.setFont(new Font("Arial", Font.BOLD, 18));
        panneauPrincipal.add(étiquetteTitre);

        // Ajout des résultats des joueurs
        for (int i = 0; i < joueurs.size(); i++) {
            Player joueur = joueursTriés.get(i);
            String texteRésultat = String.format("%der : Joueur %d - %d points", i + 1, joueurs.indexOf(joueur) + 1, joueur.getMalus());
            JLabel étiquetteRésultat = new JLabel(texteRésultat);
            étiquetteRésultat.setHorizontalAlignment(SwingConstants.CENTER);

            // Attribution des couleurs en fonction de la position
            if (i == 0) {
                étiquetteRésultat.setForeground(Color.ORANGE);  // Or pour le premier joueur
            } else if (i == 1) {
                étiquetteRésultat.setForeground(Color.LIGHT_GRAY);  // Argent pour le deuxième joueur
            } else if (i == 2) {
                étiquetteRésultat.setForeground(new Color(205, 127, 50));  // Bronze pour le troisième joueur
            }

            panneauPrincipal.add(étiquetteRésultat);
        }

        // Ajout du panneau principal à la boîte de dialogue
        add(panneauPrincipal);

        // Configuration de la taille et de la visibilité
        pack();
        setVisible(true);
    }
}
