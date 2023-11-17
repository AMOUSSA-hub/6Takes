package fr.amoussa.SixTakes.View;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import fr.amoussa.SixTakes.Controller.FoldListener;

public class Fold extends JPanel {

    Fold(){
        this.setOpaque(false);
    }


@Override
public Component add(Component comp) {

    Card c = (Card)comp;
    c.addMouseListener(new FoldListener(c,this));
    setLayout(new GridLayout(this.getComponentCount()+1,1, 0,5));
   //System.out.println(getComponentCount()+" cartes dans cette pile");
    return super.add(c);
}

    
}
