package TP2.Tests;


import TP2.Lien;
import TP2.Point2D;
import TP2.Ville;
import problemeVilles.PopulationVilles;

/**
 * Classe qui valide les données de la class Lien
 * @author Radhika Chatterjee Simon Pitre-Lamas
 *
 */
public class TestLien {

	public TestLien() {

	}

	public static void main(String[] args) {

		Point2D positionVilleSource = new Point2D(1.0, 2.0);
		Point2D positionVilleDest = new Point2D(10.0, 20.0);

		Ville villeSource = new Ville(0, positionVilleSource);
		Ville villeDest= new Ville(1, positionVilleDest);

		Ville villeAMuter = new Ville(99, new Point2D(99.0, 99.0));

		//Test Constructeur Lien() avec aucun paramètre
		Lien lien = new Lien();
		System.out.println("Test Constructeur de Lien vide: ---->  "
				+"\n"+lien.toString()
				+"\n");

		//Test Constructeur Lien() avec paramètre
		Lien lienAvecVille = new Lien(villeSource, villeDest);
		System.out.println("Test Constructeur Lien avec deux Villes"
				+ " '1.0, 2.0' et '10.0, 20.0': ---->  "
				+"\n"+lienAvecVille.toString()
				+"\n");

		//Test Accesseur getVilleSource()
		System.out.println("Test Accesseur qui retourne la ville source "
				+ " '1.0, 2.0' : ---->  "
				+"\n"+lienAvecVille.getVilleSource()
				+"\n");

		//Test Accesseur getVilleDestination()
		System.out.println("Test Accesseur qui retourne la ville destination "
				+ " '10.0, 20.0' : ---->  "
				+"\n"+lienAvecVille.getVilleDestination()
				+"\n");

		//Test mute() avec une autre ville
		System.out.println("Test le muttateur de lien qui retourne false si "
				+ "la ville reçue en paramètre ne correspond pas à la ville"
				+ "destination ou à la ville source: ---->  "
				+ "\n Avant le changement   --->  "
				+ lienAvecVille.toString()
				+"\n changer vSource ---> "+lienAvecVille.mute(villeSource, 0)
				+"\n changer vDest   ---> "+lienAvecVille.mute(villeSource, 1)
				+ "\n Après le changement   --->  "
				+ lienAvecVille.toString()
				+"\n");

		//Test mute() avec une autre ville
		System.out.println("Test le muttateur de lien qui retourne true si "
				+ "la ville reçue en paramètre a été changé à destination ou "
				+ "à la ville source: ---->  "
				+ "\n Avant le changement   --->  "
				+ lienAvecVille.toString()
				+"\n changer vSource --->  "
				+lienAvecVille.mute(new Ville(), 0)
				+"\n changer vDest   --->  "
				+lienAvecVille.mute(villeAMuter, 1)
				+ "\n Après le changement   --->  "
				+ lienAvecVille.toString()
				+"\n");
	}			

}
