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
    private GridLayout gl;

    Fold(){
        this.setOpaque(false);
        this.addMouseListener(new FoldListener(this));
        this.gl = new GridLayout(1,1,0,5);
        this.setLayout(gl);
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public void clearStack(){
        this.removeAll();
        this.gl.setRows(1);
    }


@Override
public Component add(Component comp) {

    Card c = (Card)comp;
    this.gl.setRows(this.getComponentCount()+1);
    return super.add(c);
}


@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
if (hover){this.setBorder( new LineBorder(Color.BLACK, 5, true));}
else{this.setBorder(null);}
}

    
}
