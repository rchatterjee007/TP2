package TP2;

import enginCartes.CONFIGURATION;
import enginCartes.MoteurDistanceMoyenne;
import listeChaine.Liste;

public class Carte {

	MoteurDistanceMoyenne moteurDistanceMoyenne = null;
	double score;
	Liste liste;
	CONFIGURATION config;

	/*
public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne) {
	
	this.moteurDistanceMoyenne = moteurDistanceMoyenne;
	score = 0.0;
	liste = new Liste();
	
}
	*/
public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne, CONFIGURATION config) {
		score = 0.0;
		this.moteurDistanceMoyenne = moteurDistanceMoyenne;
		liste = new Liste();
		this.config = config;
		
	}
	
	public Carte(Object moteurDistanceMoyenne, Liste section1, 
			Liste section2) 
	{
		this.moteurDistanceMoyenne = 
				(MoteurDistanceMoyenne) moteurDistanceMoyenne;
		liste = section1.fusionnerListe(section2);
		score = 0.0;
	}
	
	
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne, Liste section1, 
			Liste section2, CONFIGURATION config) {
		
		this.moteurDistanceMoyenne = 
				(MoteurDistanceMoyenne) moteurDistanceMoyenne;
		liste = section1.fusionnerListe(section2);
		score = 0.0;
		this.config = config;
	}

	public int getNbLien() {
		return liste.getNbrElements();
	}
	
	public double getScore() {
		return score;
	}
	
	public double obtenirSommeLongueurs() {
		double sommeL = 0;
		for(int i=0; i<liste.getNbrElements(); i++) {
			Lien lien = (Lien) liste.getElement(i);
			
			sommeL += lien.getDistance();
		}
		return sommeL;
	}
	
	/*
	 * evalueScore : Il s’agit de calculer le score obtenu par la 
	 * multiplication de la distance obtenue du moteurDistanceMoyenne par la 
	 * pénalité de distance + la somme des longueurs multipliée par la pénalité 
	 * de longueur + la pénalité déconnecte.
	 */
	public void evalueScore(boolean afficher) {
		double distanceM = moteurDistanceMoyenne.
				getDistanceMoyenne(liste, afficher);
		double penD = config.getPenaliteDistance();
		double sommeL = obtenirSommeLongueurs();
		double penL = config.getPenaliteLongeur();
		double penDeconnecte = config.getPenaliteDeconnect();
		double nbrDeconnecte = moteurDistanceMoyenne.getNbNonConnecte();
		this.score = distanceM * penD + sommeL * penL + 
				nbrDeconnecte * penDeconnecte;
	}

	public void enleverLien(int indice) {
		liste.supprimer(indice);
	}
	
	public void ajouterLienFin(Lien ceLien) {
		liste.insererALaPosition(ceLien, getNbLien());
	}
	
	public Liste obtientFraction(boolean duDebut, int indexCoupe) {
		/*
		if(indexCoupe == 0 && duDebut == true) {
			indexCoupe++;
		}
		*/
		Liste nouvelleListe;
		if(duDebut == true) {
			nouvelleListe = liste.copie(0, indexCoupe);
		} else {
			nouvelleListe = liste.copie(indexCoupe, getNbLien());
		}
		return nouvelleListe;
	}
	
	
	@Override
	public String toString() {
		String message = "";
		
		for(int i=0; i<liste.getNbrElements(); i++) {
			message += liste.getElement(i).toString()
			+"\n";
		}
		
		return message;
		
	}
	
	
	
	
	
	
	
}
