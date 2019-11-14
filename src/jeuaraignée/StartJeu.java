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
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Ilyes
 */
public class StartJeu implements ActionListener{
    private JFrame fr;
    private JTextField nom1,nom2;
    private JLabel message;

    public StartJeu(JFrame fr, JTextField nom1, JTextField nom2, JLabel message) {
        this.fr = fr;
        this.nom1 = nom1;
        this.nom2 = nom2;
        this.message = message;
    }

  
  

    
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((!nom1.getText().equals(""))&&(!nom2.getText().equals(""))){
            message.setText("");    
            fr.dispose();
            Joueur j1=new Joueur(nom1.getText());
            Joueur j2=new Joueur(nom2.getText());
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
        else message.setText("Saisissez deux noms");
    }
    
}

