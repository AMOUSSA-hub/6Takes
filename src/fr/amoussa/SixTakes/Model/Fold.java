package fr.amoussa.SixTakes.Model;

import java.util.*;

import fr.amoussa.SixTakes.View.Card;

public class Fold extends LinkedList<Card> {

    public Fold(){
     

    }

    public void addCard( Card c){
        this.add(c);

    }

    // public int clearStack(){
    //         return 0;
    // }


    public int sumPoints(){         
        int sum =0;
        for (Card c : this){
            sum += c.getMalus();
        }
        return sum;
    }
    
    
}
