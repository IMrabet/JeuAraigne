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
public class Quitter implements ActionListener{
    private JFrame fr;
    public Quitter(JFrame fr) {
        this.fr=fr;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        fr.dispose();
        fr=new JFrame("Araignée");
        SaisieNoms ch=new SaisieNoms(fr);
        ch.Start();
        fr.setVisible(true);
        fr.setResizable(false);
        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
