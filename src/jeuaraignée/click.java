/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuaraignée;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ilyes
 */
public class click implements ActionListener{
    private JLabel message;
    private Joueur j1;
    private Joueur j2;
  
    private Partie p;
    private JLabel tour;
    private Grille g;
    private Case c;

    public click(Partie p,JLabel message, Joueur j1, Joueur j2,JLabel tour,Grille g) {
        this.p=p;
        this.message = message;
        this.j1 = j1;
        this.j2 = j2;
        this.tour=tour;
        this.g=g;
        this.c=c;
        
    }

  


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if (source instanceof Case){
            Case cas=(Case) source;
                 
            System.out.println(j2.getPions()+" "+j1.getPions());
            if ((!j1.gagnant())&&(!j2.gagnant())&&(j1.getPions()>=0)&& (j2.getPions()>0)){
            if (!cas.occupe){
            message.setText("");
            if  (j1.isTour(tour)){
                j1.jouer(cas);
                cas.cocher(j1.getImage());
                j2.setTour(true,tour);
                j1.setTour(false,tour);
            }
            else{
                
                j2.jouer(cas);
                cas.cocher(j2.getImage());
                j1.setTour(true,tour);
                j2.setTour(false,tour);
                
               // System.out.println(j1.gagnant()+" "+j2.gagnant());
                                
                 
                }
            }
        
         else message.setText("Case Occupée");
            }
       
            else if((!j1.gagnant())&&(!j2.gagnant())&&(j1.getPions()<=0)&&(j2.getPions()<=0)){
                   if(j1.isTour(tour)){
                       if (cas.occupe){
                          
                           if (j1.isCase(cas) && (j1.click==0)){
                               message.setText("");
                               j1.select(cas);
                               }
                            if (j1.isCase(cas) && (j1.click==1)){ 
                               message.setText("");
                              j1.select(cas);  
                            }
                             if (!j1.isCase(cas) && (j1.click==0 )){
                              message.setText("Case sélectionnée ne vous appartient pas");   
                             }
                             if (!j1.isCase(cas) && (j1.click==1)){
                              message.setText("Case sélectionnée non vide");   
                             }
                       }
                       else{
                           if ((j1.click==1)&&(j1.Deplacer(cas, j2,tour))){
                               message.setText("");
                               }
                           else if ((j1.click==1)&&(!j1.Deplacer(cas, j2,tour))){
                               message.setText("Déplacement impossible");
                           }
                       }
                   }
                   else if (j2.isTour(tour)){
                       if (cas.occupe){
                            
                           if (j2.isCase(cas) && (j2.click==0)){
                               message.setText("");
                               j2.select(cas);
                               }
                            if (j2.isCase(cas) && (j2.click==1)){ 
                               message.setText("");
                              j2.select(cas);  
                            }
                             if (!j2.isCase(cas) && (j2.click==0)){
                              message.setText("Case sélectionnée ne vous appartient pas");   
                             }
                             if (!j2.isCase(cas) && (j2.click==1)){
                              message.setText("Case sélectionnée non vide");   
                             }
                       }
                       else{
                           if ((j2.click==1)&&(j2.Deplacer(cas, j1,tour))){
                               message.setText("");
                               }
                           else if ((j2.click==1)&&(!j2.Deplacer(cas, j1,tour))){
                               message.setText("Déplacement impossible");
                           }
                       }
                       
                   }
            }
             if (j1.gagnant()){
                 tour.setText("Félicitaions "+j1.getPseudo()+"!!!");
                 g.desactiver();
                j1.activer();}
             if (j2.gagnant()){
                 tour.setText("Félicitaions "+j2.getPseudo()+"!!!");
                 g.desactiver();
                 j2.activer();
             }
             
          
        
            
        }    
    }
    
}
