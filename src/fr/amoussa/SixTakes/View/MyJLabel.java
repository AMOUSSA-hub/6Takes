package fr.amoussa.SixTakes.View;

import java.awt.Color;

import javax.swing.JLabel;

public class MyJLabel extends JLabel {


   public MyJLabel(String s){
        super(s);
        this.setForeground(Color.white);
    }

    MyJLabel(){
        this.setForeground(Color.white);
    }
    
}
