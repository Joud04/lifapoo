package modele.plateau;

import java.util.ArrayList;
import java.awt.Point;


public class DecorateurCasesEnLigne extends DecorateurCasesAccessibles {
    public DecorateurCasesEnLigne(DecorateurCasesAccessibles _baseDecorateur) {
        super(_baseDecorateur);
    }


    @Override
    public ArrayList<Case> getMesCasesAccessibles() {
        ArrayList<Case> casesAccessibles = new ArrayList<>();

        // Récupérer la position actuelle de la pièce
        Point positionActuelle = plateau.getPosition(piece);

        if (positionActuelle != null) {
            // Directions possibles pour les déplacements en ligne
            Direction[] directions = {Direction.haut, Direction.bas, Direction.gauche, Direction.droite};

            for (Direction direction : directions) {
                Point nouvellePosition = new Point(positionActuelle);

                // Parcourir dans chaque direction jusqu'à rencontrer un obstacle ou sortir du plateau
                while (true) {
                    switch (direction) {
                        case haut:
                            nouvellePosition.y -= 1;
                            break;
                        case bas:
                            nouvellePosition.y += 1;
                            break;
                        case gauche:
                            nouvellePosition.x -= 1;
                            break;
                        case droite:
                            nouvellePosition.x += 1;
                            break;
                    }

                    // Vérifier si la position est dans la grille
                    if (!plateau.contenuDansGrille(nouvellePosition)) {
                        break; // Sortir si hors du plateau
                    }

                    Case caseDestination = plateau.caseALaPosition(nouvellePosition);

                    // Vérifier si la case est libre ou occupée par une pièce ennemie
                    if (caseDestination.getPiece() == null) {
                        casesAccessibles.add(caseDestination);
                    } else if (!caseDestination.getPiece().getCouleur().equals(piece.getCouleur())) {
                        casesAccessibles.add(caseDestination);
                        break; // Arrêter si une pièce ennemie est rencontrée
                    } else {
                        break; // Arrêter si une pièce alliée est rencontrée
                    }
                }
            }
        }

        return casesAccessibles;
    }

}
