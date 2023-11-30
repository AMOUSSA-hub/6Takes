package fr.amoussa.SixTakes.Solo.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.*;
import javax.swing.*;

import fr.amoussa.SixTakes.Solo.Model.Player;

public class ResultFrame extends JDialog {



    public ResultFrame(List<Player> p){

        List <Player> copyP = new ArrayList<>(p);

        setSize(200,200);
        setLayout(new GridLayout(p.size(),1,20,20));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        Collections.sort(copyP, Comparator.comparingInt(Player::getMalus));

        for(int i = 0; i<=p.size()-1;i++){

            System.out.println((i+1)+"er: joueur "+(p.indexOf(copyP.get(i))+1)+" "+copyP.get(i).getMalus()+" points");
            JLabel txt = new JLabel((i+1)+"er: joueur "+(p.indexOf(copyP.get(i))+1)+" "+copyP.get(i).getMalus()+" points");
            txt.setHorizontalAlignment(SwingConstants.CENTER); 
            add(txt);

        }



         pack();
       
         setVisible(true);

        

    }
    
}
