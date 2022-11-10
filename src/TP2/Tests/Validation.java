package TP2.Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import TP2.Lien;
import TP2.Ville;
import enginCartes.CONFIGURATION;
import enginCartes.MoteurCartes;
import problemeVilles.PopulationVilles;

public class Validation {

	public static void main(String[] args) {

		CONFIGURATION config= new CONFIGURATION();

		// Crée une population de villes.
		PopulationVilles popVilles =
				new PopulationVilles(config.getNbVilles(),config.getMaxX(),
						config.getMaxY());

		// Instancier un engin de cartes
		MoteurCartes enginCartes = new MoteurCartes(popVilles,
				new CONFIGURATION());
		System.out.println(popVilles);

		// Évalue les scores une première fois.
		enginCartes.evalueLesScores(false);


		// Affiche l'itération courante.
		System.out.println("" + 1);

		// Itération d'optimisation: élargit, évalue et réduit.
		enginCartes.elargieLaPopulation();
		enginCartes.evalueLesScores(false);
		enginCartes.reduitLaPopulation();

		// Affiche le meilleur score courant.
		enginCartes.afficheMeilleurScore();


		// Affiche la population des villes.
		System.out.println(popVilles);

		// Affiche la meilleur solution.
		enginCartes.getMeilleurSolution();

	}	

}
