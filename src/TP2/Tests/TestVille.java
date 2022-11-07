package TP2.Tests;

import TP2.Point2D;
import TP2.Ville;

/**
 * Classe qui valide les données de la class Ville
 * @author Radhika Chatterjee Simon Pitre-Lamas
 *
 */
public class TestVille {

	public TestVille() {
	}

	public static void main(String[] args) {
		//TEST CONSTRUCTEUR VIDE 
		Ville v1= new Ville();
		System.out.println("Test Constructeur Vide du ville: ---->   "
				+v1.toString());

		//TEST CONSTRUCTEUR AVEC PARAMS
		Point2D p1= new Point2D(10.7,5.2);
		Ville v2= new Ville(1,p1);
		System.out.println("Test Constructeur avec des paramétres du ville 1: "
				+ "---->   "+v2.toString());

		//TEST CONSTRUCTEUR AVEC OBJET
		Ville v3= new Ville(v2);
		System.out.println("Test Constructeur avec un objet Ville 1 : ---->   "
				+v3.toString());

		//Test Accesseur
		System.out.println("Test Accesseur du ville   "
				+ "Le numéro de la ville: ---->   "+v2.getNumero());

		//Test toString()
		System.out.println("Test toString du ville: ---->   "+v3.toString());

		//Test distanceAvec() avec une vrai distance
		System.out.println("Test distanceAvec entre ville 0 et ville 1: ---->"
				+ "   "+v1.distanceAvec(v2));

		//Test distanceAvec() avec une distance 0 
		System.out.println("Test distanceAvec entre ville 1 et ville 1: ---->"
				+ "   "+v2.distanceAvec(v3));



	}
}
