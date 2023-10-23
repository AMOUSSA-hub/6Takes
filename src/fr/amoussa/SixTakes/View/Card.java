package fr.amoussa.SixTakes.View;

import javax.swing.*;
import java.awt.*;
import fr.amoussa.SixTakes.Controller.*;
import fr.amoussa.SixTakes.Utils.Icone;


public class Card extends JComponent {

    private int malus;
    private int value;
    private boolean hover= false;

    public Card(int v ){
        this.value = v;
        setSize(getPreferredSize());
        
        

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

    if(this.hover){
        p.setColor(Color.YELLOW);
        p.drawRoundRect(2,2,(int)Math.round(this.getWidth())+3,(int)Math.round(this.getHeight())+3,15,15);
        }

    p.setColor(Color.BLACK);
     p.drawRoundRect(0,0,(int)Math.round(this.getWidth()),(int)Math.round(this.getHeight()),15,15);
     p.drawString(this.value+"",(int)Math.round(this.getWidth()*0.05)+5 , (int)Math.round(this.getWidth()*0.1)+5);
        for(int a = 0 ; a < this.malus; a++){
        p.drawImage(Icone.bull, (int)Math.round(this.getWidth()*0.03+a*15),(int)Math.round(this.getWidth()*0.09),25,25,null);
        }
    }

  

    public void setHover(boolean b){
        this.hover = b ;

    }

}
