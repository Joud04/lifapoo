package modele.jeu;

import modele.plateau.*;

public class Pion extends Piece {
    private String couleur;
    public Pion(Plateau _plateau, String couleur) {
        super(_plateau, couleur);
        this.couleur = couleur;
        // Le pion peut se déplacer en ligne (1 case en avant) et capturer en diagonale
        casesAccessibles = new DecorateurCasesEnLigne(null); // Déplacement en ligne
    }
}
