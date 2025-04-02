package modele.jeu;

import modele.plateau.*;

public class Tour extends Piece {
    public Tour(Plateau _plateau, String couleur) {
        super(_plateau, couleur);
        this.couleur = couleur;
        // La tour peut se déplacer en ligne (horizontal et vertical)
        casesAccessibles = new DecorateurCasesEnLigne(null); // Déplacement horizontal et vertical
    }
}
