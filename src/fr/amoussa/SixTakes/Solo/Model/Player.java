package fr.amoussa.SixTakes.Solo.Model;

import java.util.*;

import fr.amoussa.SixTakes.Solo.Controller.DeckListener;
import fr.amoussa.SixTakes.Solo.View.*;


public class Player {

    private List<Card> hand;
    private int malus;
    private Card selectedCard;
    
      
    public Player(){
        this.malus = 0;
        this.hand = new ArrayList<Card>(); 
      }

      public void addCardToHand(Card c){
        c.addMouseListener(new DeckListener(c,this));
        this.hand.add(c);  
      }

      public Card removeCardFromHand(Card c){
        
        this.hand.remove(c);

        return c;
      }



      public void printHand(){
 System.out.printf("[ ");
        for(Card c : this.hand){
          
            System.out.printf("%d ,",c.getValue());

        }
         System.out.println("] ");
      }

    public List<Card> getHand(){
      return this.hand;
    }

    public void setSelectedCard(Card sc) {
        this.selectedCard = sc;
    }

    public Card getSelectedCard(){  
      Card c =  this.selectedCard;
      return removeCardFromHand(c);
    }

    public void SelectRandomCard(){
      Random r = new Random();

      if(hand.size() != 1){setSelectedCard(hand.get(r.nextInt(hand.size()-1)));}
      else{setSelectedCard(hand.get(0));}
        

    }

    public int getMalus(){return this.malus;}

    public void addMalus(int m){ this.malus += m; }

    public void resetCardSelection(){
      this.selectedCard.setHover(false);
      this.selectedCard.repaint();
      this.selectedCard.revalidate();
      this.selectedCard = null;
    }

   
      
     
}
