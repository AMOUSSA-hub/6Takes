package fr.amoussa.SixTakes.Solo.View;

import java.awt.*;

import javax.swing.*;

import fr.amoussa.SixTakes.Solo.Model.Game;
import fr.amoussa.SixTakes.Solo.Model.Round;

/**
 * Fenêtre pause.
 */
public class PauseFen extends JDialog {

    public PauseFen(JFrame owner, GameBoard view) {
        super(owner, true);
        setTitle("Pause");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(200, 200);

        JButton resume = new JButton("reprendre");
        JButton goHome = new JButton("retour au menu");
        JButton quit = new JButton("quitter");

        resume.addActionListener(e -> {
            view.setPaused(false);
            this.dispose();
        });
        goHome.addActionListener(e -> {
            owner.dispose();
            new Accueil();
        });
        quit.addActionListener(e -> System.exit(0));
        add(resume, BorderLayout.NORTH);
        add(goHome, BorderLayout.CENTER);
        add(quit, BorderLayout.SOUTH);
        setLocationRelativeTo(owner);
        pack();
        setVisible(true);

    }

}
