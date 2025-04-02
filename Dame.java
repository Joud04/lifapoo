package modele.jeu;

import modele.plateau.*;

public class Dame extends Piece {
    private String couleur;
    public Dame(Plateau _plateau, String couleur) {
        super(_plateau, couleur);
        this.couleur = couleur;
        // La dame combine les déplacements du fou (diagonale) et de la tour (ligne)
        casesAccessibles = new DecorateurCasesEnLigne(new DecorateurCasesEnDiagonale(null)); // Déplacement diagonal + horizontal/vertical
    }
}
