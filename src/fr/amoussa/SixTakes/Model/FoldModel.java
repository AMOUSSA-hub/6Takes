package fr.amoussa.SixTakes.Model;

import java.util.*;

import fr.amoussa.SixTakes.View.Card;

public class FoldModel extends LinkedList<Card> {


    public FoldModel(){
     

    }

     public int clearStack(){
            int malus = getSumMalus();
            this.clear();
             return malus;
     }


    public int getSumMalus(){         
        int sum =0;
        for (Card c : this){
            sum += c.getMalus();
        }
        return sum;
    }


    @Override
    public boolean add(Card e) {
        // TODO Auto-generated method stub
    
        
        
     return super.add(e);   
    }
    

    
}
