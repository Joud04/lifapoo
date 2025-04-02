package modele.plateau;

import java.util.ArrayList;
import java.awt.Point;

public class DecorateurCasesEnCavalier extends DecorateurCasesAccessibles {

    public DecorateurCasesEnCavalier(DecorateurCasesAccessibles _baseDecorateur) {
        super(_baseDecorateur);
    }

    @Override
    public ArrayList<Case> getMesCasesAccessibles() {
        ArrayList<Case> casesAccessibles = new ArrayList<>();

        // Récupérer la position actuelle de la pièce
        Point positionActuelle = plateau.getPosition(piece);

        if (positionActuelle != null) {
            // Ajouter les positions possibles en "L"
            int[][] mouvements = {
                    {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, // Mouvements verticaux
                    {1, 2}, {1, -2}, {-1, 2}, {-1, -2}  // Mouvements horizontaux
            };

            for (int[] mouvement : mouvements) {
                Point nouvellePosition = new Point(
                        positionActuelle.x + mouvement[0],
                        positionActuelle.y + mouvement[1]
                );

                // Vérifier si la nouvelle position est dans la grille
                if (plateau.contenuDansGrille(nouvellePosition)) {
                    Case caseDestination = plateau.caseALaPosition(nouvellePosition);

                    // Vérifier si la case est libre ou occupée par une pièce ennemie
                    if (caseDestination.getPiece() == null || !caseDestination.getPiece().getCouleur().equals(piece.getCouleur())) {
                        casesAccessibles.add(caseDestination);
                    }
                }
            }
        }

        return casesAccessibles;
    }

}
