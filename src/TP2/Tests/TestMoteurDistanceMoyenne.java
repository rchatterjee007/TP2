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
		/*
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
		
		
		Carte carte = new Carte(mtdm, section1, section2, conf);
		*/
		Liste liste = new Liste();
		Random rand = new Random();
		for (int j = 0; j < popsVille.getNbVilles(); j++) {
			Ville villeA = popsVille.getVille(rand.nextInt(popsVille.getNbVilles()));
			Ville villeB = popsVille.getVille(rand.nextInt(popsVille.getNbVilles()));

			while (villeA == villeB) {
				villeB = popsVille.getVille(rand.nextInt(popsVille.getNbVilles()));
			}

			// temp.ajouterLien(new Lien(villeA,villeB));
			liste.insererALaPosition(new Lien(villeA, villeB), liste.getNbrElements());
		}
		Carte carte = new Carte(mtdm, liste);
		carte.evalueScore(true);
		
	}
}
