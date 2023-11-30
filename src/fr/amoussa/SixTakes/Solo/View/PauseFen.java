package fr.amoussa.SixTakes.Solo.View;


import java.awt.*;

import javax.swing.*;

public class PauseFen extends JDialog {



    public PauseFen(JFrame owner){
        super(owner,true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(200,200);



        JButton resume = new JButton("reprendre");
        JButton quit = new JButton("quitter");

        resume.addActionListener(e -> this.dispose());
        quit.addActionListener(e -> System.exit(0));


        add(resume,BorderLayout.WEST);
        add(quit, BorderLayout.EAST);
        setLocationRelativeTo(owner);
        pack();
        setVisible(true);

    }



    
}
