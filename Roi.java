/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.jeu;

import modele.plateau.*;

public class Roi extends Piece {
    public Roi(Plateau _plateau, String couleur) {
        super(_plateau, couleur);
        this.couleur = couleur; // Initialisation correcte de la couleur
        casesAccessibles = new DecorateurCasesEnLigne(new DecorateurCasesEnDiagonale(null));
    }
}


