package programmePrincipal;

/**
 * Cette classe contient le code pour démarrer et gérer la simulation numérique
 * pour relier des villes entres elles (voir énoncé tp1 partie 3 inf111).
 *
 * Liste des méthodes publiques:
 *     - main (static), programme principal
 *
 * @author Fred Simard | ETS,
 * @révision Pierre Bélisle | ETS,
 * @version Automne 2022
 */

import problemeVilles.PopulationVilles;
import enginCartes.MoteurCartes;
import enginCartes.CONFIGURATION;


import enginCartes.MoteurDistanceMoyenne;
import listeChainee.ListeDChainee;


public class ProgrammePrincipal{

	/**
	 * Développe le problème, exécute la méthode de résolution et
	 * affiche le résultat
	 *
	 * @param args, inutilisé
	 */
    public static void main(String[] args){

        // Crée une population de villes.
    	PopulationVilles popVilles =
    			new PopulationVilles(CONFIGURATION.NOMBRE_VILLES,
    												  CONFIGURATION.MAX_X,
    												  CONFIGURATION.MAX_Y);

        // Crée une population de cartes.
        MoteurCartes enginCartes = new MoteurCartes(popVilles,new CONFIGURATION());


        System.out.println(popVilles);

        // Évalue les scores une première fois.
    	enginCartes.evalueLesScores();

        // Maintenant, on procède à la boucle d'optimisation pour 
    	// trouver la solution.
        for(int i=0;i<CONFIGURATION.NB_ITERATIONS;i++)
        {
        	// Affiche l'itération courante.
        	System.out.println("" + i);

        	// Itération d'optimisation: élargit, évalue et réduit.
        	enginCartes.elargitLaPopulation();
        	enginCartes.evalueLesScores();
        	enginCartes.reduitLaPopulation();

        	// Affiche le meilleur score courant.
        	enginCartes.afficheMeilleurScore();

        }

        // Affiche la population des villes.
        System.out.println(popVilles);

        // Affiche la meilleur solution.
        enginCartes.afficheMeilleurSolution();
    }

}

