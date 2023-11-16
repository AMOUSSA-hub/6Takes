package fr.amoussa.SixTakes.Controller;

import java.awt.event.*;
import fr.amoussa.SixTakes.View.*;

public class FoldListener implements MouseListener{

    private Card ca;
    private static boolean selectable = false;
    private Fold f;
    private static Fold foldSelected;

    public FoldListener(  Card c, Fold f){
        this.ca = c;
        this.f = f;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //System.out.println(this.f.getSumMalus());
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(selectable){
            ca.setHover(true);
            ca.repaint();
        }
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
         if(selectable){
            ca.setHover(false);
            ca.repaint();
         }


    }

    public static void setSelectable(boolean s){
        selectable = s;
    }   
}
