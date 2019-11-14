/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuaraignée;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ilyes
 */
public class SaisieNoms extends JPanel {
    private JFrame fr;
    private JTextField nom1;
    private JTextField nom2;
    private JButton valider;
    private JLabel message;

    public SaisieNoms(JFrame fr) {
        super();
       fr.setPreferredSize(new Dimension(400,400));
        this.fr = fr;
        fr.setContentPane(this);
        nom1=new JTextField("");
        nom2=new JTextField("");
        valider=new JButton("valider");
        message=new JLabel("");
        this.setLayout(new GridLayout(7,1));
        this.add(new JLabel("Saisissez les noms des joueurs"));
        this.add(new JLabel("Joueur 1:"));
        this.add(nom1);
        nom1.setPreferredSize(new Dimension(400,100));
        this.add(new JLabel("Joueur 2:"));
        this.add(nom2);
        nom2.setPreferredSize(new Dimension(400,100));
        this.add(valider);
        this.add(message);
    }
    public void Start(){
        valider.addActionListener(new StartJeu(fr,nom1,nom2,message));
    }
    
}
