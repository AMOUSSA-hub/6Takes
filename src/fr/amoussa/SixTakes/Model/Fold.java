package fr.amoussa.SixTakes.Model;

import java.util.*;

import fr.amoussa.SixTakes.Controller.FoldListener;
import fr.amoussa.SixTakes.View.Card;

public class Fold extends LinkedList<Card> {

    private LinkedList<Card> cards ;

    public Fold(){
     

    }

    // public int clearStack(){
    //         return 0;
    // }


    public int getSumMalus(){         
        int sum =0;
        for (Card c : this){
            sum += c.getMalus();
        }
        return sum;
    }
    
    @Override
    public boolean add(Card c) {
        c.addMouseListener(new FoldListener(c,this));
        return super.add(c);
    }
    
}
