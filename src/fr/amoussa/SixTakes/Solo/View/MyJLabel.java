package fr.amoussa.SixTakes.Solo.View;

import java.awt.Color;

import javax.swing.JLabel;

/**
 * Zone de texte personnalisée.
 */
public class MyJLabel extends JLabel {

    public MyJLabel(String s) {
        super(s);
        this.setForeground(Color.white);
    }

    MyJLabel() {
        this.setForeground(Color.white);
    }

}
