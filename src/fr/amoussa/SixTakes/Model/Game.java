package fr.amoussa.SixTakes.Model;

import java.util.*;

import fr.amoussa.SixTakes.View.Card;
import fr.amoussa.SixTakes.View.GameBoard;

public class Game extends Timer {

    private Player[] allPlayers;
    private ArrayList<FoldModel> allFolds;
    private GameBoard gm;
    
    

    public Game( int nbr_player,GameBoard view){
        this.gm = view;
        this.allPlayers = new Player[nbr_player];
        this.allFolds = new  ArrayList<>();

        for(int i = 0; i< 4; i++){
          this.allFolds.add(new FoldModel());
        }

        for(int a = 0; a < nbr_player; a++){
          this.allPlayers[a] = new Player();
        }

        this.Deal();

        view.renderDeckLocalPlayer(allPlayers[0].getHand());
        view.renderScores(allPlayers);

        startRound();


    }


    public void Deal(){
     List<Card> deck = new LinkedList<Card>();
     for(int i = 1 ; i <= 104; i++){
        Card c = new Card(i);
        deck.add(c);
     }

     Random r = new Random();
     for(int i = 0 ; i <= allFolds.size()-1;  i++){
      Card c =deck.remove(r.nextInt(deck.size()));
       allFolds.get(i).add(c);
       this.gm.getAllFolds()[i].add(c);
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

    public List<FoldModel> getAllFolds(){
      return this.allFolds;
    }


    public void  getAllPlays() {
      List<Card> allPlays = new ArrayList<>();
      for(int i = 0; i< allPlayers.length; i++){
          if(allPlayers[i].getSelectedCard() == null){
              allPlayers[i].SelectRandomCard();
          }
          
              System.out.println("Le joueur "+(i+1)+" a joué la carte "+allPlayers[i].getSelectedCard().getValue());
              allPlays.add(allPlayers[i].getSelectedCard()) ;
        
      }

      gm.renderPlays(allPlays);
      try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
      this.makePlays(allPlays);

    }


    public void startRound(){schedule(new Round(5,this), 1000,1000);}

    public GameBoard getView(){return this.gm;}

    public void makePlays(List<Card> plays){


      while ( plays.size() != 0) {
       
          try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}

          Card c = Collections.min(plays, Comparator.comparingInt(Card::getValue));
          System.out.println(c.getValue());
         this.dispactchCardInFolds(c);
          plays.remove(c);
          this.gm.renderPlays(plays);
          System.out.println(plays.size());

    
      }

  


    }
    
    public boolean dispactchCardInFolds( Card c ){

      List <FoldModel> copyallFolds  =  new ArrayList<>(this.allFolds);
      int nbrFoldTested = 0;
      boolean cardPlaced = false;
      while (nbrFoldTested != 4 && !cardPlaced ) {
        FoldModel f = Collections.max(copyallFolds, Comparator.comparingInt(element -> element.getLast().getValue()));
        System.out.println(c.getValue()+" > "+f.getLast().getValue());

          if(c.getValue()> f.getLast().getValue()){
            
            System.out.println("la carte "+c.getValue()+" va aller dans la "+allFolds.indexOf(f)+"eme pile");
            allFolds.get(allFolds.indexOf(f)).add(c);

            this.gm.getAllFolds()[allFolds.indexOf(f)].add(c);
            cardPlaced = true;
            
          }
          nbrFoldTested++;
          copyallFolds.remove(f);
      }

      if(!cardPlaced){

       System.out.println("le joueur ayant joué "+c.getValue()+" doit faire un choix"); 

       }

      
      return true;
    }

   
}

class Round extends TimerTask{
  
    public Card c;
    public int time;
    public Game g;

    Round(int t,Game g){
        this.time = t;
        this.g = g;
        
    }
      
    @Override
    public void run() {
    
    this.g.getView().renderChrono(this.time);
      if(this.time == 0){
        this.g.getAllPlays();
          cancel();
        }
      
      
        this.time--;
        
    }
}
