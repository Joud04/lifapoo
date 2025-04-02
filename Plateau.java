/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.plateau;


import modele.jeu.Piece;
import modele.jeu.Roi;
import modele.jeu.Tour;
import modele.jeu.Pion;
import modele.jeu.Cavalier;
import modele.jeu.Fou;
import modele.jeu.Dame;
import java.awt.Point;
import java.util.HashMap;
import java.util.Observable;


public class Plateau extends Observable {

    public static final int SIZE_X = 8;
    public static final int SIZE_Y = 8;


    private HashMap<Case, Point> map = new  HashMap<Case, Point>(); // permet de récupérer la position d'une case à partir de sa référence
    private Case[][] grilleCases = new Case[SIZE_X][SIZE_Y]; // permet de récupérer une case à partir de ses coordonnées

    public Plateau() {
        initPlateauVide();
    }

    public Case[][] getCases() {
        return grilleCases;
    }

    private void initPlateauVide() {

        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                grilleCases[x][y] = new Case(this);
                map.put(grilleCases[x][y], new Point(x, y));
            }

        }

    }

    public void placerPieces() {
        // Placer les pions
        for (int x = 0; x < SIZE_X; x++) {
            grilleCases[x][1].arriverCase(new Pion(this, "noir")); // Pions noirs
            grilleCases[x][6].arriverCase(new Pion(this, "blanc")); // Pions blancs
        }

        // Placer les tours
        grilleCases[0][0].arriverCase(new Tour(this, "noir"));
        grilleCases[7][0].arriverCase(new Tour(this, "noir"));
        grilleCases[0][7].arriverCase(new Tour(this, "blanc"));
        grilleCases[7][7].arriverCase(new Tour(this, "blanc"));

        // Placer les cavaliers
        grilleCases[1][0].arriverCase(new Cavalier(this, "noir"));
        grilleCases[6][0].arriverCase(new Cavalier(this, "noir"));
        grilleCases[1][7].arriverCase(new Cavalier(this, "blanc"));
        grilleCases[6][7].arriverCase(new Cavalier(this, "blanc"));

        // Placer les fous
        grilleCases[2][0].arriverCase(new Fou(this, "noir"));
        grilleCases[5][0].arriverCase(new Fou(this, "noir"));
        grilleCases[2][7].arriverCase(new Fou(this, "blanc"));
        grilleCases[5][7].arriverCase(new Fou(this, "blanc"));

        // Placer les dames
        grilleCases[3][0].arriverCase(new Dame(this, "noir"));
        grilleCases[3][7].arriverCase(new Dame(this, "blanc"));

        // Placer les rois
        grilleCases[4][0].arriverCase(new Roi(this, "noir"));
        grilleCases[4][7].arriverCase(new Roi(this, "blanc"));

        setChanged();
        notifyObservers();

    }



    public void arriverCase(Case c, Piece p) {

        c.p = p;

    }

    public void deplacerPiece(Case c1, Case c2) {
        if (c1.p != null) {
            c1.p.allerSurCase(c2);

        }
        setChanged();
        notifyObservers();

    }


    /** Indique si p est contenu dans la grille
     */
    public boolean contenuDansGrille(Point p) {
        return p.x >= 0 && p.x < SIZE_X && p.y >= 0 && p.y < SIZE_Y;
    }

    public Case caseALaPosition(Point p) {
        Case retour = null;

        if (contenuDansGrille(p)) {
            retour = grilleCases[p.x][p.y];
        }
        return retour;
    }
    public Point getPosition(Piece piece) {
        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                if (grilleCases[x][y].getPiece() == piece) {
                    return new Point(x, y);
                }
            }
        }
        return null; // Si la pièce n'est pas trouvée
    }


}
