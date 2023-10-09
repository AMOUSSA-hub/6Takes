package fr.amoussa.SixTakes.Model;

import java.util.*;


import fr.amoussa.SixTakes.View.Card;

public class Game {

    private Player[] allPlayers;
    private Fold[] allFolds;
    

    public Game( int nbr_player){
        this.allPlayers = new Player[nbr_player];
        this.allFolds = new Fold[4];

        for(int i = 0; i< this.allFolds.length; i++){
          this.allFolds[i]= new Fold();
        }

        for(int a = 0; a < nbr_player; a++){
          this.allPlayers[a] = new Player();
        }

        this.Deal();


    }


    public void Deal(){
     List<Card> deck = new LinkedList<Card>();
     for(int i = 1 ; i <= 104; i++){
        Card c = new Card(i);
        deck.add(c);
     }


     for(Fold f : this.allFolds){
       f.addCard(deck.remove(new Random().nextInt(deck.size())));
     }

       for(Player p : allPlayers){

        while(p.getHand().size() !=10){
          p.addCardToHand(deck.remove(new Random().nextInt(deck.size())));
        }
        p.printHand();

       } 

    }

    public Player[] getAllPlayers() {
        return this.allPlayers;
    }

    public Fold[] getAllFolds(){
      return this.allFolds;
    }
   
}
