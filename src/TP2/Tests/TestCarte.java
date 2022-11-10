package TP2.Tests;

import TP2.Carte;
import TP2.Lien;
import TP2.Point2D;
import TP2.Ville;
import enginCartes.CONFIGURATION;
import enginCartes.MoteurDistanceMoyenne;
import listeChaine.Liste;
import problemeVilles.PopulationVilles;


/**
 * Classe qui valide les données de la class Carte
 * @author Radhika Chatterjee Simon Pitre-Lamas
 *
 */
public class TestCarte {

	public static void main(String[] args) {

		CONFIGURATION conf = new CONFIGURATION();
		PopulationVilles popsVille = new PopulationVilles(conf);
		MoteurDistanceMoyenne mtdm = new MoteurDistanceMoyenne(popsVille);

		Liste section1 = new Liste();
		Liste section2 = new Liste();

		//inserer des liens dans la liste
		for(int i=0; i<2; i++) {


			Ville villeSource = popsVille.getVille(i);
			Ville villeDest;

			int index = i;
			villeDest = popsVille.getVille(++index);

			Lien lien = new Lien(villeSource, villeDest);
			section1.insererALaPosition(lien, i);

		}

		for(int i=2; i<4; i++) {


			Ville villeSource = popsVille.getVille(i);
			Ville villeDest;

			int index = i;
			index++;
			if(index==4) {
				//La dernière ville à un lien avec la première
				villeDest = popsVille.getVille(0);
			} else {
				villeDest = popsVille.getVille(index);

			}

			Lien lien = new Lien(villeSource, villeDest);
			section2.insererALaPosition(lien, i);

		}





		//Test avec constructeur moteurDistanceMoyenne 
		Carte c= new Carte(mtdm);
		System.out.println(c.toString());

		//Valider que ces sections peuvent être utilisées avec le constructeur
		//par paramètres pour reconstruire une autre carte.
		Carte carte = new Carte(mtdm, section1, section2,conf);





		//Valider le fonctionnement de obtientFraction
		System.out.println("CARTE ORIGINALE: \n"+carte.toString());
		//debut a 3
		System.out.println("CARTE 0-3: \n"+(carte.obtientFraction(true, 3)));
		//3 a fin
		System.out.println("CARTE 3-4: \n"+(carte.obtientFraction(false, 3)));



		//Test getNbLiens()
		System.out.println("CARTE ORIGINALE: \n"+carte.toString());
		System.out.println("Nombre de liens dans la carte :"+
				carte.getNbLien());

		//Test getScore()
		carte.evalueScore(true);
		System.out.println("Score de la carte : "+ carte.getScore());

		//Test evalueScore(true())
		System.out.println("Score avec son affichage: \n");
		carte.evalueScore(true);
		System.out.println("Score de la carte : "+ carte.getScore());


		//Test evalueScore(true())
		System.out.println("Score avec sans son affichage: \n");
		carte.evalueScore(false);
		System.out.println("Score de la carte : "+ carte.getScore());


		//Test toString()
		System.out.println("Carte toString : \n"+carte.toString());


		//Test enlever Lien
		System.out.println("Carte avant enlever un lien : \n"+
				carte.toString());
		carte.enleverLien(2);
		System.out.println("Carte après enlever un lien  2: \n"+
				carte.toString());


		//Test ajouter lien 
		System.out.println("Carte avant ajouter un lien : \n"+
				carte.toString());

		Ville v1= new Ville(9,new Point2D());
		Ville v2= new Ville(15, new Point2D());
		Lien l= new Lien (v1,v2);

		carte.ajouterLienFin(l);
		System.out.println("Carte après ajouter un lien 9-15 : \n"+
				carte.toString());



	}

}
