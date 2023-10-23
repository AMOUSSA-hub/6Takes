package fr.amoussa.SixTakes.View;
import java.awt.*;

import javax.swing.*;

import fr.amoussa.SixTakes.Controller.CardFoldListener;
import fr.amoussa.SixTakes.Model.Fold;
import fr.amoussa.SixTakes.Model.Game;
import fr.amoussa.SixTakes.Utils.Icone;

public class GameBoard extends JPanel {

  private JPanel game_stack_pan;
  private JPanel player_stack_pan;
  private JPanel deck_pan;
  private Game modelG;

  public GameBoard(int nbr_player){

 this.setLayout(new GridBagLayout());
 GridBagConstraints gbc = new GridBagConstraints();

  this.deck_pan = new JPanel(new GridLayout(1,10));

  this.modelG = new Game(nbr_player); 
  setLayout(new GridLayout(2,1));
   this.game_stack_pan = new JPanel(new GridLayout(1,4));
   this.player_stack_pan = new JPanel(new GridLayout(nbr_player*2,2 ));
  JPanel left_side = new JPanel(new GridLayout(3,1 ));
  JPanel right_side = new JPanel(new GridLayout(1,3 ));
  JButton quit = new JButton("Quitter la partie");

  left_side.add(Box.createRigidArea(getPreferredSize()));
  left_side.add(game_stack_pan);
  left_side.add(Box.createRigidArea(getPreferredSize()));
  
  //right_side.add(Box.createRigidArea(getPreferredSize()));
  right_side.add(player_stack_pan);
  //right_side.add(Box.createRigidArea(getPreferredSize()));
  
   

    for (Fold f : modelG.getAllFolds()) {
      Card c = f.getLast();

      c.addMouseListener(new CardFoldListener(c));
      this.game_stack_pan.add(c);
    }
    
    
    for(int i = 1; i<= nbr_player-1; i++){
      
      this.player_stack_pan.add( new JLabel(new ImageIcon(Icone.player)));
      this.player_stack_pan.add(Box.createRigidArea(getPreferredSize()));
    }


    gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    gbc.gridy = 0;      // la plage de cellules commence à la deuxième ligne
    gbc.gridwidth = 2;  // la plage de cellules englobe deux colonnes
    gbc.gridheight = 2; // la plage de cellules englobe une seule ligne
    gbc.fill = GridBagConstraints.BOTH;     // n'occupe pas tout l'espace de la plage
    gbc.anchor = GridBagConstraints.CENTER; // se place au centre de la plage
    gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    gbc.weighty = 1.0;  // n'a pas besoin de hauteur supplémentaire
    gbc.insets = new Insets(1, 1, 1, 1);    // laisse 5 pixels de vide autour du composant    

  add(left_side,gbc);

    gbc.gridx = 1;      // la plage de cellules commence à la première colonne
    gbc.gridy = 0;      // la plage de cellules commence à la deuxième ligne
    gbc.gridwidth = 1;  // la plage de cellules englobe deux colonnes
    gbc.gridheight = 2; // la plage de cellules englobe une seule ligne
    gbc.fill = GridBagConstraints.BOTH;     // n'occupe pas tout l'espace de la plage
    gbc.anchor = GridBagConstraints.CENTER; // se place au centre de la plage
    gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    gbc.weighty = 1.0;  // n'a pas besoin de hauteur supplémentaire
    gbc.insets = new Insets(1, 1, 1, 1);    // laisse 5 pixels de vide autour du composant    

  add(right_side,gbc);

  gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    gbc.gridy = 1;      // la plage de cellules commence à la deuxième ligne
    gbc.gridwidth = 2;  // la plage de cellules englobe deux colonnes
    gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    gbc.fill = GridBagConstraints.HORIZONTAL;     // n'occupe pas tout l'espace de la plage
    gbc.anchor = GridBagConstraints.CENTER; // se place au centre de la plage
    gbc.weightx = 1.0;  // souhaite plus de largeur si possible
    gbc.weighty = 0.0;  // n'a pas besoin de hauteur supplémentaire
    gbc.insets = new Insets(1, 1, 1, 1);    // laisse 5 pixels de vide autour du composant    

  add(deck_pan,gbc);

  renderDeckPlayer();

    gbc.gridx = 0;      // la plage de cellules commence à la première colonne
    gbc.gridy = 1;      // la plage de cellules commence à la deuxième ligne
    gbc.gridwidth = 1;  // la plage de cellules englobe deux colonnes
    gbc.gridheight = 1; // la plage de cellules englobe une seule ligne
    gbc.fill = GridBagConstraints.HORIZONTAL;     // n'occupe pas tout l'espace de la plage
    gbc.anchor = GridBagConstraints.CENTER; // se place au centre de la plage
    gbc.weightx = 0.0;  // souhaite plus de largeur si possible
    gbc.weighty = 0.0;  // n'a pas besoin de hauteur supplémentaire
    gbc.insets = new Insets(20, 20, 20, 20);    // laisse 5 pixels de vide autour du composant   


  add(quit,gbc);

  
  }


  public void renderDeckPlayer(){
    for(Card c: modelG.getAllPlayers()[0].getHand()){
    deck_pan.add(c);
  }

  


  

  }

   


   
    
}
