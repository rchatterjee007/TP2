package TP2.Tests;
import java.util.Random;

import TP2.Carte;
import TP2.Lien;
import TP2.Ville;
import enginCartes.CONFIGURATION;
import enginCartes.MoteurDistanceMoyenne;
import listeChaine.Liste;
import problemeVilles.PopulationVilles;
/**
 * Classe qui valide les données de la class MoteurDistanceMoyenne
 * @author Radhika Chatterjee Simon Pitre-Lamas
 *
 */
public class TestMoteurDistanceMoyenne {

	public static void main(String[] args) {

		CONFIGURATION conf = new CONFIGURATION();
		PopulationVilles popsVille = new PopulationVilles(conf);
		MoteurDistanceMoyenne mtdm = new MoteurDistanceMoyenne(popsVille);
		Liste liste = new Liste();
		Random rand = new Random();
		for (int j = 0; j < popsVille.getNbVilles(); j++) {
			Ville villeA = popsVille.getVille
					(rand.nextInt(popsVille.getNbVilles()));
			Ville villeB = popsVille.getVille
					(rand.nextInt(popsVille.getNbVilles()));

			while (villeA == villeB) {
				villeB = popsVille.getVille
						(rand.nextInt(popsVille.getNbVilles()));
			}

			// temp.ajouterLien(new Lien(villeA,villeB));
			liste.insererALaPosition
			(new Lien(villeA, villeB), liste.getNbrElements());
		}
		Carte carte = new Carte(mtdm, liste);
		carte.evalueScore(true);

	}
}
