package fr.amoussa.SixTakes.Utils;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Icone {

    static ClassLoader loader = Thread.currentThread().getContextClassLoader();

    //MODE ARCHIVE
    // public final static Image bull = new ImageIcon(loader.getResource("images/taureau.png")).getImage();
    // public final static Image player = new ImageIcon(loader.getResource("images/player.png")).getImage().getScaledInstance(30 , 30, Image.SCALE_DEFAULT);

    //MODE LOCAL
    public final static Image bull = new ImageIcon("res/images/taureau.png").getImage();
    public final static Image player = new ImageIcon("res/images/player.png").getImage().getScaledInstance(30 , 30, Image.SCALE_DEFAULT);
    public final static Image home_Image = new ImageIcon("res/images/6_qui_prend_!.jpg").getImage();


    public static  Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
}
