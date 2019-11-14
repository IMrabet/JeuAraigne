/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuaraignée;


import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Ilyes
 */
public class Case extends JButton {
    static int x1=-1,y1=1;
    public int x,y;
    public boolean occupe;
    private String c;
    
    public Case() {
        super();
        this.occupe = false;
        if (x1<3){
            x1+=1;
        }
        else{
            y1=y1+1;
            x1=1;
        }
        x=x1;
        y=y1;
        
    }
    public void cocher(String C){
            this.c=C;
            this.occupe=true;
            ImageIcon i=new ImageIcon(new ImageIcon(getClass().getResource(c)).getImage().getScaledInstance(this.getWidth(), this.getHeight(),Image.SCALE_SMOOTH));
            this.setIcon( i );
    }
   public void decocher(){
            this.c=null;
            this.occupe=false;
            Icon i=null;
            this.setIcon( i );
    }


    public String getC() {
        return c;
    }

    public int xcase() {
        return x;
    }

    public int ycase() {
        return y;
    }
    
    
        
       
}
    
