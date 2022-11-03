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
		// TODO Auto-generated method stub
		
		CONFIGURATION config= new CONFIGURATION();
		
		//1.	Créer une population de Villes
		PopulationVilles popVilles= new PopulationVilles(config);
		//lierLesVilles(popVilles);
		
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
	
	private static void lierLesVilles(PopulationVilles popVilles) {
		int indexRandom=0;
		for(int i=0;i<popVilles.getNbVilles();i++) {
			List<Integer> indexDesVillesEnLiens = new ArrayList<>();
			indexRandom=nbrAlea(i+1,popVilles.getNbVilles());
			Ville Source= popVilles.getVille(i);
			indexDesVillesEnLiens.add(i);
			//la ville destination est aléatoire, alors tant que cette ville
			//n'est pas une ville source ou destination 
		
			if() {
				
			}
			Ville Destination=popVilles.getVille(indexRandom);	
			Lien lien=new Lien(Source,Destination);	
		}
	}
	private static int nbrAlea(int min, int max){
		return (int) Math.round(Math.random()* (max - min) + min);
	}	

}
