package fr.amoussa.SixTakes.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import fr.amoussa.SixTakes.Controller.FoldListener;

public class Fold extends JPanel {

    private boolean hover= false;

    Fold(){
        this.setOpaque(false);
        this.addMouseListener(new FoldListener(this));
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }


@Override
public Component add(Component comp) {

    Card c = (Card)comp;
    setLayout(new GridLayout(this.getComponentCount()+1,1, 0,5));
    return super.add(c);
}


@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
if (hover){this.setBorder( new LineBorder(Color.BLACK, 5, true));}
else{this.setBorder(null);}
}

    
}
