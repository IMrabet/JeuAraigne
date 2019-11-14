/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuaraignée;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Ilyes
 */
public class Joueur {

    static int n = 0;
    private int n1;
    private String pseudo;
    private boolean tour;
    private ArrayList<Case> cases;
    private int Pions = 3;
    private String image;
    private Case sel;
    public int click = 0;

    public Joueur(String pseudo) {
        this.pseudo = pseudo;
        cases = new ArrayList<Case>();
        n += 1;
        n1 = n;
        if (n1 % 2 == 1) {
            tour = true;
            image = ".\\Icone\\x.jpg";
        } else {
            tour = false;
            image = ".\\Icone\\tick.jpg";
        }
    }

    public String getPseudo() {
        return pseudo;
    }


    public void setTour(boolean tour, JLabel t) {
        this.tour = tour;
        if (tour) {
            t.setText("Le tour de " + this.pseudo);
        }
    }

    public boolean isTour(JLabel t) {
        if (tour) {
            t.setText("Le tour de " + this.pseudo);
        }
        return tour;
    }

    public ArrayList<Case> getCases() {
        return cases;
    }

    public int getPions() {
        return Pions;
    }

    public void jouer(Case c) {
        this.tour = false;
        this.cases.add(c);
        this.Pions -= 1;
    }

    public boolean gagnant() {
        boolean xdif = false;
        boolean ydif = false;
        boolean diag = false;
        boolean xeg = false;
        boolean yeg = false;
        if (this.cases.size() >= 3) {
            if ((cases.get(0).x == cases.get(1).x) && (cases.get(0).x == cases.get(2).x)) {
                xeg = true;
            }
            if ((cases.get(0).y == cases.get(1).y) && (cases.get(1).y == cases.get(2).y)) {
                yeg = true;
            }

            if ((cases.get(0).x == cases.get(0).y) && (cases.get(1).x == cases.get(1).y) && (cases.get(2).x == cases.get(2).y)) {
                diag = true;
            }
            if ((cases.get(0).x == 4 - cases.get(0).y) && (cases.get(1).x == 4 - cases.get(1).y) && (cases.get(2).x == 4 - cases.get(2).y)) {
                diag = true;
            }
            if ((cases.get(0).x != cases.get(1).x) && (cases.get(1).x != cases.get(2).x) && (cases.get(0).x != cases.get(2).x)) {
                xdif = true;
            }
            if ((cases.get(0).y != cases.get(1).y) && (cases.get(1).y != cases.get(2).y) && (cases.get(0).y != cases.get(2).y)) {
                ydif = true;
            }
            if (((diag && xdif) || (xeg && ydif) || (xdif && yeg))) {
                System.out.println(cases.get(0).x + " " + cases.get(1).x + " " + cases.get(2).x);
                System.out.println(cases.get(0).y + " " + cases.get(1).y + " " + cases.get(2).y);
                return (true);

            }

            return (false);

        } else {
            return (false);
        }

    }

    public void init() {
        Pions = 3;
        cases = new ArrayList<Case>();
        if (this.n1 % 2 == 1) {
            tour = true;
        } else {
            tour = false;
        }
    }

    public void select(Case c) {
        sel = c;
        if (cases.contains(c)) {
            click = 1;
        }
    }

    public boolean isCase(Case c) {
        return (cases.contains(c));
    }

    public Case getSel() {
        return sel;
    }

    public String getImage() {
        return image;
    }

    public boolean Deplacer(Case c, Joueur j, JLabel tour) {
        if ((sel != null) && (!c.occupe)) {
            boolean c1 = (sel.xcase() == c.xcase()) && ((sel.ycase() == 1 + c.ycase()) || (sel.ycase() == -1 + c.ycase()));
            boolean c2 = (sel.ycase() == c.ycase()) && ((sel.xcase() == 1 + c.xcase()) || (sel.xcase() == -1 + c.xcase()));
            boolean c3 = (sel.ycase() == -1 + c.ycase()) && (sel.xcase() == -1 + c.xcase());
            boolean c4 = (sel.ycase() == 1 + c.ycase()) && (sel.xcase() == 1 + c.xcase());
            boolean c5 = (sel.ycase() == 1 + c.ycase()) && (sel.xcase() == -1 + c.xcase());
            boolean c6 = (sel.ycase() == -1 + c.ycase()) && (sel.xcase() == 1 + c.xcase());

            if (c1 || c2 || c3 || c4 || c5 || c6) {
                this.tour = false;
                cases.remove(sel);
                cases.add(c);
                c.cocher(this.image);
                j.setTour(true, tour);
                click = 0;
                sel.decocher();
                sel = null;
                return (true);
            }

        }
        return (false);
    }

    public void activer() {
        for (Case s : cases) {
            s.setEnabled(true);
        }
    }
}
