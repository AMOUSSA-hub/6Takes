package fr.amoussa.SixTakes.Controller;

import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.text.PlainDocument;

import fr.amoussa.SixTakes.Model.Player;
import fr.amoussa.SixTakes.View.*;

public class CardHandListener implements MouseListener{

    private Card ca;
    private Player p;

    public CardHandListener(  Card c, Player p){
        this.ca = c;
        this.p = p; 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        this.p.setSelectedCard(ca);


       

        new Timer().schedule(new MyTask(ca) , 5*1000);//5 secondes de temps de latence
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

    public void ezef(){
        System.out.println("qege");
    }


    
}

class MyTask extends TimerTask{

    public Card c;

    MyTask(Card c){
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println("Vous avez sélectionné la carte " +this.c.getValue());
    }

}
