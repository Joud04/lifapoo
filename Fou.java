package modele.jeu;

import modele.plateau.*;

public class Fou extends Piece {
    private String couleur;
    public Fou(Plateau _plateau, String couleur) {
        super(_plateau, couleur);
        this.couleur = couleur;
        // Le fou peut se déplacer en diagonale
        casesAccessibles = new DecorateurCasesEnDiagonale(null); // Déplacement diagonal
    }
}
