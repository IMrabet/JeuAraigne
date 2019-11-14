/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuaraignée;


import javax.swing.JFrame;

/**
 *
 * @author Ilyes
 */
public class JeuAraignée {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame f=new JFrame("Araignée");
        
        SaisieNoms j=new SaisieNoms(f);
        j.Start();
        f.setResizable(false);
        f.setContentPane(j);
        

        
        
        
        
//       Case[] cases;
//        Case.x=0;
//        Case.y=1;
//       cases=new Case[9];
//        for(Case s:cases)
//        {s=new Case();
//            System.out.println(s.x+ ", "+s.y);
//        }
        
        
        f.setVisible(true);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
