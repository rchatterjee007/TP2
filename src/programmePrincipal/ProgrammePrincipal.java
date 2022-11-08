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


public class ProgrammePrincipal{

	/**
	 * Développe le problème, exécute la méthode de résolution et
	 * affiche le résultat
	 *
	 * @param args, inutilisé
	 */
    public static void main(String[] args){

        // Crée une population de villes.
    	CONFIGURATION config= new CONFIGURATION();
    	PopulationVilles popVilles =
    			new PopulationVilles(config.getNbVilles(),config.getMaxX(),config.getMaxY());

        // Crée une population de cartes.
        MoteurCartes enginCartes = new MoteurCartes(popVilles,new CONFIGURATION());


        System.out.println(popVilles);

        // Évalue les scores une première fois.
    	enginCartes.evalueLesScores(false);

        // Maintenant, on procède à la boucle d'optimisation pour 
    	// trouver la solution.
        for(int i=0;i<config.getNbIterations();i++)
        {
        	// Affiche l'itération courante.
        	System.out.println("" + i);

        	// Itération d'optimisation: élargit, évalue et réduit.
        	enginCartes.elargieLaPopulation();
        	enginCartes.evalueLesScores(false);
        	enginCartes.reduitLaPopulation();

        	// Affiche le meilleur score courant.
        	enginCartes.afficheMeilleurScore();

        }

        // Affiche la population des villes.
        System.out.println(popVilles);
        enginCartes.evalueLesScores(false);
        // Affiche la meilleur solution.
        enginCartes.getMeilleurSolution();
        
        
    }

}

