/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuaraignée;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;


/**
 *
 * @author Ilyes
 */
public class Partie extends JPanel{
    private Grille g;
    private JLabel message;
    private Joueur j1;
    private Joueur j2;
    private JLabel tour;
    private JButton exit;
    private JButton restart;
    private JFrame fr;

    public Partie(JFrame fr,Joueur j1, Joueur j2) {
        super();
    message=new JLabel("");
    JPanel score=new JPanel();
    JPanel vide=new JPanel();
    tour=new JLabel("Le tour de "+j1.getPseudo());
    JPanel boutons=new JPanel();
    this.fr=fr;
    this.j1 = j1;
    this.j2 = j2;
    this.restart=new JButton ("Nouvelle Partie");
    this.exit=new JButton ("Quitter");
    this.setLayout(new BorderLayout());
    this.add(score,BorderLayout.EAST);
    this.add(vide,BorderLayout.WEST);
    score.setPreferredSize(new Dimension(50,200));
    vide.setPreferredSize(new Dimension(50,200));
    boutons.setPreferredSize(new Dimension(200,100));
    JPanel south=new JPanel();
    this.add(south,BorderLayout.SOUTH);
    south.add(boutons);
    south.add(message);
    message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    south.setLayout(new GridLayout(2,1));
    boutons.setLayout(new BoxLayout(boutons,BoxLayout.X_AXIS));
    boutons.setPreferredSize(new Dimension(800,100));
    boutons.add(Box.createHorizontalGlue());
    boutons.add(restart);
    boutons.add(exit);
    boutons.add(Box.createHorizontalGlue());
    JPanel p=new JPanel();
    p.setPreferredSize(new Dimension(200,100));
    p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
    p.add(Box.createHorizontalGlue());
    p.add(tour);
    p.add(Box.createHorizontalGlue());
    this.add(p,BorderLayout.NORTH); 
    g=new Grille();
    this.add(g,BorderLayout.CENTER);
    Font font = new Font("Arial",Font.BOLD,22);
    message.setFont(font);
    boutons.setFont(font);
    tour.setFont(font);
        
    }
    public void Start(){
        //restart.addActionListener(new Restart(this,j1,j2));
        g.setActionLitener(this,message,this.j1,this.j2,tour);
        exit.addActionListener(new Quitter(fr));
        restart.addActionListener(new Restart(fr,j1,j2));
    }

    
  
}
