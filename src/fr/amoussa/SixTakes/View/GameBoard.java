package fr.amoussa.SixTakes.View;
import java.awt.*;

import javax.swing.*;

import fr.amoussa.SixTakes.Model.Fold;
import fr.amoussa.SixTakes.Model.Game;

public class GameBoard extends JComponent {

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
   this.player_stack_pan = new JPanel(new GridLayout(nbr_player+2,1 ));
  JPanel left_side = new JPanel(new GridLayout(3,1 ));
  JPanel right_side = new JPanel(new GridLayout(1,3 ));
  
  left_side.add(Box.createRigidArea(getPreferredSize()));
  left_side.add(game_stack_pan);
  left_side.add(Box.createRigidArea(getPreferredSize()));
  
  right_side.add(Box.createRigidArea(getPreferredSize()));
  right_side.add(player_stack_pan);
  right_side.add(Box.createRigidArea(getPreferredSize()));
   

    for (Fold f : modelG.getAllFolds()) {
      this.game_stack_pan.add(f.getLast());
    }
    
    
    for(int i = 1; i<= nbr_player; i++){
      this.player_stack_pan.add(new Card(6));
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

  for(Card c: modelG.getAllPlayers()[0].getHand()){
    deck_pan.add(c);
  }


  
  }

    @Override
    protected void paintComponent(Graphics g) {
        /// obligatoire : on crée un nouveau pinceau pour pouvoir le modifier plus tard
    Graphics p = g.create();
    // obligatoire : si le composant n'est pas censé être transparent
    if (this.isOpaque()) {
      // obligatoire : on repeint toute la surface avec la couleur de fond
      p.setColor(this.getBackground());
      p.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    p.setColor(new Color(235,231,130));
    p.fillRect(0, 0, this.getWidth(), this.getHeight());

  
  }


   
    
}
