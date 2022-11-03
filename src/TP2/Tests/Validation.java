package TP2.Tests;

import java.util.Random;

import enginCartes.CONFIGURATION;
import enginCartes.MoteurCartes;
import problemeVilles.PopulationVilles;

public class Validation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CONFIGURATION config= new CONFIGURATION();
		Random rand = new Random();
		
		//1.	Créer une population de Villes
		PopulationVilles popVilles= new PopulationVilles(config);
	
		
	
		
		
		
		
		
		
		//2.	Instancier un engin de cartes
		MoteurCartes enginCartes= new MoteurCartes(popVilles,config);
		
		//3.    Faire un appel à l’évaluation des scores
		enginCartes.evalueLesScores();
		
		//4.    Afficher l’engin de cartes
		enginCartes.toString();
		
		//5.	Faire un appel à l’élargissement de la population
		enginCartes.elargieLaPopulation();
		
		//6.    Faire un appel à l’évaluation des scores
		enginCartes.evalueLesScores();
		
		//7.    Afficher l’engin de cartes
		enginCartes.toString();
		
		//8.	Faire un appel à réduire la population
		enginCartes.reduitLaPopulation();
		
		//9.    Afficher l’engin de cartes
		enginCartes.toString();
	}
	
	private void lierLesVilles(PopulationVilles popVilles) {
		
		
	}

}
