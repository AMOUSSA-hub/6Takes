package fr.amoussa.SixTakes.Solo.Model;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


import fr.amoussa.SixTakes.Solo.Controller.FoldListener;
import fr.amoussa.SixTakes.Solo.View.Card;
import fr.amoussa.SixTakes.Solo.View.GameBoard;
import fr.amoussa.SixTakes.Solo.View.ResultFrame;

public class Game extends Timer {

    private List <Player> allPlayers;
    private ArrayList<FoldModel> allFolds;
    private GameBoard gm;
    private int roundRemaining;
    
    

    public Game( int nbr_player,GameBoard view){
        this.gm = view;
        this.allFolds = new  ArrayList<>();
        this.allPlayers = new ArrayList<>();
        this.roundRemaining = 10;

        for(int i = 0; i< 4; i++){
          this.allFolds.add(new FoldModel());
        }

        for(int a = 0; a < nbr_player; a++){
          this.allPlayers.add(new Player()) ;
        }

        this.Deal();

        view.renderDeckLocalPlayer(allPlayers.get(0).getHand());
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
       this.gm.getAllFolds().get(i).add(c);
     }

       for(Player p : allPlayers){

        while(p.getHand().size() !=10){
          Card c =deck.remove(new Random().nextInt(deck.size()));
          c.setOwner(p);
          p.addCardToHand(c);
        }
        p.printHand();

       } 

    }

    public List <Player> getAllPlayers() {
        return this.allPlayers;
    }

    public List<FoldModel> getAllFolds(){
      return this.allFolds;
    }


    public void  getAllPlays() {
      List<Card> allPlays = new ArrayList<>();
      for(Player p : this.allPlayers){
      Card  c  = p.getSelectedCard();

          if(c == null){
              p.SelectRandomCard();
            c = p.getSelectedCard();
          }
          
              System.out.println("Le joueur "+(allPlayers.indexOf(p)+1)+" a joué la carte "+c.getValue());
              allPlays.add(c) ;
              p.resetCardSelection();
        
      }

      gm.renderPlays(allPlays);
      try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
      this.makePlays(allPlays);
      this.gm.renderScores(allPlayers);

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

    
      }

      this.roundRemaining--;

      if(roundRemaining!=0){
        startRound();

      }else{
        System.out.println("la partie est finie");
        this.gm.renderScores(allPlayers);
        // JOptionPane.showMessageDialog(this.gm, "La partie est finie", "Fin",
        // JOptionPane.INFORMATION_MESSAGE);
        new ResultFrame(allPlayers);


      }

  


    }
    
    public boolean dispactchCardInFolds( Card c ){

      List <FoldModel> copyallFolds  =  new ArrayList<>(this.allFolds);
      int nbrFoldTested = 0;
      boolean cardPlaced = false;
      while (nbrFoldTested != 4 && !cardPlaced ) {
        FoldModel f = Collections.max(copyallFolds, Comparator.comparingInt(element -> element.getLast().getValue()));
     

          if(c.getValue()> f.getLast().getValue()){
            
            System.out.println( "la carte "+c.getValue()+" qui a été jouée par le joueur "+(getAllPlayers().indexOf(c.getOwner())+1)+" va aller dans la "+(allFolds.indexOf(f)+1)+"eme pile");

            if(f.size()==5){
              c.getOwner().addMalus(allFolds.get(getAllFolds().indexOf(f)).clearStack());
              this.gm.getAllFolds().get(getAllFolds().indexOf(f)).clearStack();

            }

            allFolds.get(allFolds.indexOf(f)).add(c);
            this.gm.getAllFolds().get(allFolds.indexOf(f)).add(c);
            cardPlaced = true;
            
          }
          nbrFoldTested++;
          copyallFolds.remove(f);
      }

      if(!cardPlaced){

        if(this.allPlayers.indexOf(c.getOwner()) == 0 ){
          System.out.println("Vous devez faire un choix");
          ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
          scheduler.scheduleAtFixedRate(new FoldSelection(5,this), 0,1,TimeUnit.SECONDS);
          try {Thread.sleep(5500);} catch (InterruptedException e) {e.printStackTrace();}
          scheduler.shutdown();

          int rankFoldSelected;
          if(FoldListener.getFoldSelected() != null){

            rankFoldSelected = this.gm.getAllFolds().indexOf(FoldListener.getFoldSelected()); 
          }else{ rankFoldSelected = new Random().nextInt(3);} 

          System.out.println("Vous avez sélectionné le "+(rankFoldSelected+1)+"eme plie et vous récolter donc un malus de "+allFolds.get(rankFoldSelected).getSumMalus()+" points");

          c.getOwner().addMalus(allFolds.get(rankFoldSelected).clearStack());
          this.gm.getAllFolds().get(rankFoldSelected).clearStack();
          
          allFolds.get(rankFoldSelected).add(c);
          this.gm.getAllFolds().get(rankFoldSelected).add(c);


        }
        else{


                  FoldModel f = Collections.min(allFolds, Comparator.comparingInt(element -> element.getSumMalus()));
      
                  int rankFoldSelected = allFolds.indexOf(f); 

                          System.out.println("Le joueur "+(allPlayers.indexOf(c.getOwner())+1)+" a pris la pile "+(rankFoldSelected+1));


                  c.getOwner().addMalus(f.clearStack());
          this.gm.getAllFolds().get(rankFoldSelected).clearStack();
          allFolds.get(rankFoldSelected).add(c);
          this.gm.getAllFolds().get(rankFoldSelected).add(c);

        
        }


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
        System.out.println("Commencement nouveau round");
        
    }
      
    @Override
    public void run() {
    
    this.g.getView().renderChrono("Il vous reste " +this.time+" secondes pour jouer");
      if(this.time == 0){
         this.g.getView().renderChrono("");
        this.g.getAllPlays();
          cancel();
        }
      
      
        this.time--;
        
    }
}


class FoldSelection extends TimerTask{
  
    public Card c;
    public int time;
    public Game g;

    FoldSelection(int t,Game g){
        this.time = t;
        this.g = g;
        FoldListener.setSelectable(true);
        
    }
      
    @Override
    public void run() {
    this.g.getView().renderChrono("<html>Choisissez une pile <br>"+this.time+"</html>");
      if(this.time == 0){
        this.g.getView().renderChrono("");
       FoldListener.setSelectable(false);
          cancel();
        }

      
        this.time--;
        
    }
}



