package fr.amoussa.SixTakes.Controller;

import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.text.PlainDocument;

import fr.amoussa.SixTakes.Model.Player;
import fr.amoussa.SixTakes.View.*;

public class DeckListener implements MouseListener{

    private Card ca;
    private Player p;
    private static Card last_clicked;

    public DeckListener(  Card c, Player p){
        this.ca = c;
        this.p = p; 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(last_clicked != null){
            last_clicked.setHover(false);
            last_clicked.repaint();
        }
        
        this.p.setSelectedCard(ca);
        ca.setHover(true);
        ca.repaint();
        last_clicked = ca;


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

        if(this.p.getSelectedCard() != ca){
            ca.setHover(false);
            ca.repaint();
        }

    } 
}

