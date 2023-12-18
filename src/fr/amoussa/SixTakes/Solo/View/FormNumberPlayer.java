package fr.amoussa.SixTakes.Solo.View;

import javax.swing.*;
import java.awt.*;
/**
 * Fenetre permettant de choisir le nombre de joueur
 */
public class FormNumberPlayer extends JDialog {

    private static final int DEFAULT_WIDTH = 200;
    private static final int DEFAULT_HEIGHT = 200;

    public FormNumberPlayer() {
        //setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new GridLayout(3, 1));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       

        JSpinner nbrPlayerSpinner = new JSpinner(new SpinnerNumberModel(2, 2, 10, 1));
        JButton confirmButton = new JButton("Ok");

        JPanel midPanel = new JPanel(new FlowLayout());

        // Add margins and align components
        add(new JLabel("<html>Sélectionner le nombre de joueurs<br>(de 2 à 10 joueurs)</html>"));
        add(midPanel);
        midPanel.add(nbrPlayerSpinner);
        midPanel.add(confirmButton);

        confirmButton.addActionListener(e -> {new GameFen((Integer) nbrPlayerSpinner.getValue());this.dispose();});

        pack();
        setResizable(false);
         setLocationRelativeTo(null);
        setVisible(true);
    }
}
