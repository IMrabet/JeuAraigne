/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuaraignée;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Ilyes
 */
public class Restart implements ActionListener{
    private JFrame fr;
    private Joueur j1;
    private Joueur j2;

    public Restart(JFrame fr, Joueur j1, Joueur j2) {
        this.fr = fr;
        this.j1 = j1;
        this.j2 = j2;
    }
    
  

    
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        fr.dispose();
        j1.init();
        j2.init();
        fr=new JFrame("Araignée");
        Partie jeu=new Partie(fr,j1,j2);
        jeu.Start();
        fr.setResizable(false);
        fr.setPreferredSize(new Dimension(800,800));
        fr.setContentPane(jeu);
        
        fr.setVisible(true);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
