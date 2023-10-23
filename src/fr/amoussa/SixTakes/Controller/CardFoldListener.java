package fr.amoussa.SixTakes.Controller;

import java.awt.event.*;
import fr.amoussa.SixTakes.View.*;

public class CardFoldListener implements MouseListener{

    private Card ca;

    public CardFoldListener(  Card c){
        this.ca = c;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        System.out.println(this.ca.getValue());
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ca.setHover(true);
        ca.repaint();
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        ca.setHover(false);
        ca.repaint();


    }

 


    
}
