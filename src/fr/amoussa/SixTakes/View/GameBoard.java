package fr.amoussa.SixTakes.View;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;



import fr.amoussa.SixTakes.Model.Player;
import fr.amoussa.SixTakes.Utils.Icone;

public class GameBoard extends JPanel {

  private JPanel gameStackPan;
  private JPanel playerStackPan;
  private JPanel deckPan;
  private MyJLabel chrono;
  private JPanel selectedCardPan;
  private MyJLabel [] printScorePlayer;
  private JPanel localPlayerPanPlays;
  private  List<Fold> allFolds;
  
  public GameBoard(int nbr_player){

  //initialisation du panneau de jeu principal (qui contient tout)
  GridBagConstraints gbc = new GridBagConstraints();
  setLayout(new GridBagLayout());
  this.allFolds = new ArrayList<>();
  


  this.deckPan = new JPanel(new GridLayout(1,10,5,10));

 
  JPanel eastPan = new JPanel(new GridLayout(1,2 ));

  // Initialisation du panneau avec les 4 piles de jeu   
   this.gameStackPan = new JPanel(new GridLayout(1,4,10,10));

   // Initialisation du panneau où on va afficher les cartes joués par les joueurs
   this.playerStackPan = new JPanel(new GridLayout(nbr_player,2,5,10 ));

    JPanel localPlayerPan = new JPanel( new GridLayout(2,2,5,5));
    JPanel topLocalPlayerPanel = new JPanel(new GridLayout(1,2));
    JPanel chrono_pan = new JPanel();
    this.localPlayerPanPlays = new JPanel(new GridLayout(2,1));
    this.selectedCardPan = new JPanel(new GridLayout(nbr_player,1,10,10));


  JButton quit = new JButton("Quitter la partie");
  quit.addActionListener(e-> System.exit(0));
 
  

  this.chrono = new MyJLabel();
  this.chrono.setFont(new Font("Sérif",Font.BOLD,30));

  this.printScorePlayer = new MyJLabel[nbr_player]; 
  MyJLabel localPlayerScore = new MyJLabel("");
  this.printScorePlayer[0]= localPlayerScore;
  



this.gameStackPan.setBackground(new Color(55,131,65));
chrono_pan.setBackground(new Color(55,131,65));
localPlayerPan.setOpaque(false);
eastPan.setBackground(new Color(55,131,65));
this.setBackground(new Color(55,131,65));
this.deckPan.setBackground(new Color(55,131,65));
localPlayerPanPlays.setBackground(new Color(55,131,65));
playerStackPan.setBackground(new Color(55,131,65));
selectedCardPan.setOpaque(false);
topLocalPlayerPanel.setOpaque(false);
localPlayerScore.setOpaque(false);


  

  chrono_pan.add(chrono);
  

  eastPan.add(selectedCardPan);
  eastPan.add(playerStackPan);



  topLocalPlayerPanel.add(localPlayerScore);
  topLocalPlayerPanel.add(localPlayerPanPlays);

  
  localPlayerPan.add(topLocalPlayerPanel);
  localPlayerPan.add(deckPan);
  
   

  for(int i = 0; i<= 3; i++){

    Fold f = new Fold();
    allFolds.add(f) ;
    this.gameStackPan.add(f);

  }
    
    
    
    for(int i = 1; i<= nbr_player-1; i++){

      MyJLabel score = new MyJLabel("");
      
      this.playerStackPan.add( new JLabel(new ImageIcon(Icone.player)));
      this.playerStackPan.add(score);
      
      this.printScorePlayer[i] = score;

    }
    //Mise en place du panneau minuteur
    gbc.gridx = 1;      
    gbc.gridy = 1;      
    gbc.gridwidth = 1;  
    gbc.gridheight = 1; 
    gbc.fill = GridBagConstraints.HORIZONTAL;    
    gbc.anchor = GridBagConstraints.CENTER; 
    gbc.weightx = 0.0;  
    gbc.weighty = 0.0;  
    gbc.insets = new Insets(1, 1, 1, 1);       
    add(chrono_pan,gbc);

    //Mise en place du panneau des 4 piles
    gbc.gridx = 1;      
    gbc.gridy = 2;      
    gbc.gridwidth = 1;  
    gbc.gridheight = 1; 
    gbc.fill = GridBagConstraints.BOTH;    
    gbc.anchor = GridBagConstraints.CENTER; 
    gbc.weightx = 1.0; 
    gbc.weighty = 1.0;  
    gbc.insets = new Insets(5, 5, 5,5); 

  add(gameStackPan,gbc);
  
  //Mise en place du panneau avec les infos des joueurs non-locaux
   gbc.gridx = 2;      
    gbc.gridy = 2;      
    gbc.gridwidth = 1;  
    gbc.gridheight = 1; 
    gbc.fill = GridBagConstraints.BOTH;    
    gbc.anchor = GridBagConstraints.CENTER; 
    gbc.weightx = 1.0; 
    gbc.weighty = 1.0;  
    gbc.insets = new Insets(1, 1, 1, 1);  
  add(eastPan,gbc);

   //Mise en place du panneau avec les infos du joueur local
    gbc.gridx = 1;      
    gbc.gridy = 3;     
    gbc.gridwidth = 1;  
    gbc.gridheight = 1; 
    gbc.fill = GridBagConstraints.BOTH;    
    gbc.anchor = GridBagConstraints.CENTER; 
    gbc.weightx = 1.0;  
    gbc.weighty = 1.0;  
    gbc.insets = new Insets(1, 1, 1, 1);   
   // localPlayerPan.setMinimumSize(new Dimension(300, 150));  
  add(localPlayerPan,gbc);

 
//Mise en place du bouton quitter
    gbc.gridx = 2;     
    gbc.gridy = 3;     
    gbc.gridwidth = 1;  
    gbc.gridheight = 1; 
    gbc.fill = GridBagConstraints.HORIZONTAL;    
    gbc.anchor = GridBagConstraints.PAGE_END; 
    gbc.weightx = 0.0; 
    gbc.weighty = 0.0;  
    gbc.insets = new Insets(1, 1, 1, 1);   


  add(quit,gbc);

  
  }

/**
 * Affiche le jeu du joueur en local
 * @param decks
*/
  public void renderDeckLocalPlayer(List<Card> decks){

    for(Card c: decks){
    deckPan.add(c);
    }
  
  }
/**
 * Affiche les 4 piles du jeu 
 * @param folds
 */
  // public void renderFolds(Fold[] folds){ 
  //   for (Fold f : folds){
  //     Card c = f.getLast();

  //     this.gameStackPan.add(c);
  //   }


  // }
/**
 * Affiche le minuteur
 * @param t
 */
  public void renderChrono(String s){
    this.chrono.setText(s);
  
  } 
/**
 * Affiche les cartes jouées par les joueurs
 * @param plays
 */
  public void renderPlays(List<Card> plays){

    selectedCardPan.removeAll();


    for (Card c :  plays){
      

      if(plays.get(0) == c && c.getMouseListeners().length != 0 ){
        this.localPlayerPanPlays.add(c);
      }else{
        selectedCardPan.add(c);
      }
        if(c.getMouseListeners().length != 0){
        c.removeMouseListener(c.getMouseListeners()[0]);
      }

    }
    this.localPlayerPanPlays.repaint();
    selectedCardPan.repaint();
    selectedCardPan.revalidate();


  }
/**
 * Affiche les scores
 * @param p
 */
  public void renderScores(List<Player> p){

    for(int i = 0; i<= p.size()-1;i++){

      if (i==0){
        printScorePlayer[i].setText("MON SCORE: "+p.get(i).getMalus());

      }else{ printScorePlayer[i].setText("SCORE: "+p.get(i).getMalus());}
       
    }
  }

  public List<Fold> getAllFolds(){
    return this.allFolds;
  }


   


   
    
}



