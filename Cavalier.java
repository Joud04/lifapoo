package modele.jeu;

import modele.plateau.*;

import java.util.ArrayList;

public class Cavalier extends Piece {
    private String couleur;
    public Cavalier(Plateau _plateau, String couleur) {
        super(_plateau, couleur);
        this.couleur = couleur;
        // Le cavalier a des mouvements spécifiques (en "L")
        casesAccessibles = new DecorateurCasesEnCavalier(null); // Déplacement en "L"
    }
}
