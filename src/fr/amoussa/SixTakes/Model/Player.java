package fr.amoussa.SixTakes.Model;

import java.util.*;

import fr.amoussa.SixTakes.Controller.CardHandListener;
import fr.amoussa.SixTakes.View.*;


public class Player {

    private List<Card> hand;
    private int malus;
    private Card selectedCard;
      
    public Player(){
        this.malus = 0;
        this.hand = new ArrayList<Card>(); 
      }

      public void addCardToHand(Card c){
        c.addMouseListener(new CardHandListener(c,this));
        this.hand.add(c);  
      }

      public void removeCardToHand(Card c){
        
        this.hand.remove(c);
      }



      public void printHand(){
        System.out.println("");
 System.out.printf("[ ");
        for(Card c : this.hand){
          
            System.out.printf("%d ,",c.getValue());

        }
         System.out.printf("] ");
      }

    public List<Card> getHand(){
      return this.hand;
    }

    public void setSelectedCard(Card sc) {
        this.selectedCard = sc;
    }
      
     
}
