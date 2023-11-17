package fr.amoussa.SixTakes.Model;

import java.util.*;

import fr.amoussa.SixTakes.View.Card;

public class FoldModel extends LinkedList<Card> {


    public FoldModel(){
     

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
    

    
}
