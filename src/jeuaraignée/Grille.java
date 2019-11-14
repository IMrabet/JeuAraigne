/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuaraignée;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Shape;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ilyes
 */
public class Grille extends JPanel {
    private Case[] cases=new Case[9];
    

    public Grille() {
        super();
        this.setLayout(new GridLayout(3,3));
        Case.x1=0;
        Case.y1=1;
        for(int i=0;i<9;i++)
        {this.cases[i]=new Case();
        this. cases[i].setBackground(Color.WHITE);
        this.add(this.cases[i]);
         }
    }
   
    public void setActionLitener(Partie p,JLabel message,Joueur j1,Joueur j2,JLabel tour){
       for (Case c:this.cases){
            c.addActionListener(new click(p,message,j1,j2,tour,this));
        }
    }
    
   
    public void desactiver(){
            for(Case s:cases){
                if (!s.occupe){
                s.setBackground(new Color(215,215,215));
                }
                s.setEnabled(false);
            
        }
    }
    
}
    
    
