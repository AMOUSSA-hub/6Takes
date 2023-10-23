package fr.amoussa.SixTakes.Utils;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Icone {

    public final static Image bull = new ImageIcon("res/images/taureau.png").getImage();
    public final static Image player = new ImageIcon("res/images/player.png").getImage().getScaledInstance(30 , 30, Image.SCALE_DEFAULT);
    public static  Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
}