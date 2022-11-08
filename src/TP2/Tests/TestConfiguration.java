/**
 * 
 */
package TP2.Tests;

import TP2.Constantes;
import enginCartes.CONFIGURATION;

/**
 * Classe qui valide les données de la class CONFIGURATION
 * @author Radhika Chatterjee Simon Pitre-Lamas
 *
 */
public class TestConfiguration {

	/**
	 * 
	 */
	public TestConfiguration() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CONFIGURATION conf= new CONFIGURATION();

		// TEST getPourcentageMutation
		comparer(conf.getPourcentageMutation(),Constantes.POURCENTAGE_MUTATION);

		// TEST getPourcentageRetrait
		comparer(conf.getPourcentageRetrait(),Constantes.POURCENTAGE_RETRAIT);

		// TEST getMaxX
		comparer(conf.getMaxX(),Constantes.MAX_X);

		// TEST getMaxY
		comparer(conf.getMaxY(),Constantes.MAX_Y);

		// TEST getPenaliteLongeur
		comparer(conf.getPenaliteLongeur(),Constantes.PENALITE_LONGUEUR);

		// TEST getPenaliteDistance
		comparer(conf.getPenaliteDistance(),Constantes.PENALITE_DISTANCE);

		// TEST getPenaliteDeconnect
		comparer(conf.getPenaliteDeconnect(),Constantes.PENALITE_DECONNECTE);

		// TEST getNbVilles
		comparer(conf.getNbVilles(),Constantes.NB_VILLES);

		// TEST getNbIterations
		comparer(conf.getNbIterations(),Constantes.NB_ITERATIONS);

		// TEST getNbCartesBase
		comparer(conf.getNbCartesBase(),Constantes.NB_CARTES_BASE);

		// TEST getNbCartesMax
		comparer(conf.getNbCartesMax(),Constantes.NB_CARTES_MAX);

	}


	/**
	 * 
	 * @param objet1 valeur de l'attribut de la classe CONFIGURATION
	 * @param objet2 valeur de l'attribut de la classe Constantes
	 * 
	 * Compare les deux valeurs et print un message si les deux sont pareils ou non
	 */
	private static void comparer(Object objet1, Object objet2) {
		if(objet1==objet2) {
			System.out.println("ILS SONT PAREILS!");
		}
		else {
			System.out.println("ILS SONT PAREILS!");
		}
	}

}
