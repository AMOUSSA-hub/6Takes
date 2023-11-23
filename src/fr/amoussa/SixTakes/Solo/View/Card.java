package fr.amoussa.SixTakes.Solo.View;

import javax.swing.*;
import java.awt.*;

import fr.amoussa.SixTakes.Solo.Model.Player;
import fr.amoussa.SixTakes.Utils.Icone;


public class Card extends JComponent {

    private int malus;
    private int value;
    private boolean hover= false;
    private Player owner;

    public Card(int v ){
        this.value = v;
        setMinimumSize(new Dimension(50,70));
        setPreferredSize(new Dimension(50,70));
        
        

    if(v%11 ==0){
            if(v== 55){
                this.malus = 7; 
            }
            else{this.malus = 5;}
    }

     else if(v%10 ==0){this.malus = 3;}

      else if(v%5 ==0){this.malus = 2;}

    else{this.malus = 1;}
        
    }

   

    public int getMalus() {
        return malus;
    }

    public int getValue() {
        return value;
    }

    public void setOwner(Player p ){this.owner = p;}
    
    public Player getOwner(){
        return this.owner;
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

    

        p.setColor(Color.white);
        p.fillRoundRect(0,0,(int)Math.round(this.getWidth()),(int)Math.round(this.getHeight()),15,15);

    p.setColor(Color.BLACK);
     p.drawString(this.value+"",(int)Math.round(this.getWidth()*0.05)+5 , (int)Math.round(this.getHeight()*0.1)+5);
        for(int a = 0 ; a < this.malus; a++){
        p.drawImage(Icone.bull, (int)Math.round(this.getWidth()*0.01+a*10)-5,(int)Math.round((this.getHeight()*0.1)+10),20,20,null);
        }

        if(this.hover){
        p.setColor(Color.RED);
        p.drawRoundRect(0,0,(int)Math.round(this.getWidth()),(int)Math.round(this.getHeight()),15,15);
        }
    }

  

    public void setHover(boolean b){
        this.hover = b ;

    }

    public static  boolean switchApplied;

    public static Card[] bubbleSort(Card[] cards, int i){

        System.out.println("appel recursif");
        if (i == 0){
            switchApplied = false;
        }

        if(cards[i].getValue() > cards[i+1].getValue()){
                Card stock = cards[i];
                cards[i] = cards[i+1];
                cards[i+1] = stock;

                if(!switchApplied){
                    switchApplied = true;
                }
        }

        if( i< cards.length-2){
            return bubbleSort(cards, i+1);
        }else{

            if(switchApplied){
                return bubbleSort(cards, 0);
            }
        }

         if(switchApplied){
            switchApplied = false;
        }
        return cards;
    }
}
