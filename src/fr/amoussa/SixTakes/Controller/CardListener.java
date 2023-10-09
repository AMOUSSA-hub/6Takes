package fr.amoussa.SixTakes.Controller;

import java.awt.event.*;
import fr.amoussa.SixTakes.View.*;

public class CardListener implements MouseListener{

    private Card ca;

    public CardListener(  Card c){
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
       
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

 


    
}
