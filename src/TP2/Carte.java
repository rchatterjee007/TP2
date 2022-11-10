package TP2;

import enginCartes.CONFIGURATION;
import enginCartes.MoteurDistanceMoyenne;
import listeChaine.Liste;
/***
 * Une carte contient une liste de liens. 
 * @author Radhika Chatterjee Simon Pitre-Lamas
 */
public class Carte {
	//Les méthodes qui aident au calcul de la distance moyenne.
	MoteurDistanceMoyenne moteurDistanceMoyenne = null;
	double score;//Sert à retenir le meilleur score à date.
	Liste liste;//Une liste qui contient les liens d’une carte.
	CONFIGURATION config;//Confid de la region

	/***
	 * Constructeur par paramètre, minimaliste. Reçoit et copie le paramètre
	 * dans l’attribut correspondant. 
	 * Le constructeur initialise aussi la liste vide.
	 * @param moteurDistanceMoyenne distance moyenne 
	 */
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne) {
		this.score = 0.0;
		this.moteurDistanceMoyenne = moteurDistanceMoyenne;
		this.liste = new Liste();
		this.config = new CONFIGURATION();
	}

	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne, Liste liste) {
		this.score = 0.0;
		this.moteurDistanceMoyenne = moteurDistanceMoyenne;
		this.liste = liste;
		this.config = new CONFIGURATION();
	}

	/***
	 * Constructeur par paramètres. 
	 * Retient la référence du moteurDistanceMoyenne. 
	 * Cette définition s’attarde aussi à l’attribution d’un contenu du liste.
	 * @param moteurDistanceMoyenne moteur de distance moyenne 
	 * @param section1 liste de liens d'une carte 
	 * @param section2 liste de liens d'une autre carte
	 */
	public Carte(Object moteurDistanceMoyenne, Liste section1, 
			Liste section2) 
	{
		this.moteurDistanceMoyenne = 
				(MoteurDistanceMoyenne) moteurDistanceMoyenne;
		this.liste = section1;
		/*
		for(int i =0; i<section2.getNbrElements(); i++) {
			Object elem = section2.getElement(i);
			this.liste.insererALaPosition(elem, this.getNbLien());
		}
		 */
		liste = liste.fusionnerListe(section2);
		score = 0.0;
	}

	/***
	 * Constructeur par paramètres. 
	 * Retient la référence du moteurDistanceMoyenne.
	 * Cette définition s’attarde aussi à l’attribution d’un contenu du liste.
	 * @param moteurDistanceMoyenne moteur de distance moyenne 
	 * @param section1 liste de liens d'une carte 
	 * @param section2 liste de liens d'une autre carte
	 * @param congif config de la regions des cartes
	 */
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne, Liste section1, 
			Liste section2, CONFIGURATION config) {

		this.moteurDistanceMoyenne = 
				(MoteurDistanceMoyenne) moteurDistanceMoyenne;
		liste = section1.fusionnerListe(section2);
		score = 0.0;
		this.config = config;
	}

	/***
	 * Constructeur avec parametres
	 * @param moteurDistanceMoyenne une distance moyenne 
	 * @param config configuration de la ville
	 */
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne, 
			CONFIGURATION config) {
		this(moteurDistanceMoyenne);
		this.config = config;

	}



	/***
	 * @return le nombre de liens de la carte.
	 */
	public int getNbLien() {
		return liste.getNbrElements();
	}

	/***
	 * @return le score.
	 */
	public double getScore() {
		return score;
	}


	/***
	 * @return la somme des distances des liens de la carte 
	 */
	public double obtenirSommeLongueurs() {
		double sommeL = 0;
		for(int i=0; i<liste.getNbrElements(); i++) {
			Lien lien = (Lien) liste.getElement(i);

			sommeL += lien.getDistance();
		}
		return sommeL;
	}

	/*
	 * evalueScore : Il s’agit de calculer le score obtenu par la multiplication
	 * de la distance obtenue du moteurDistanceMoyenne par la 
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
		if (liste.getNbrElements() > 0)
			this.score = (distanceM * penD) + (sommeL * penL) + 
			(nbrDeconnecte * penDeconnecte);
		else this.score = Double.POSITIVE_INFINITY;
	}

	/***
	 * Enlève le lien l’indice donné.
	 * @param indice du lien a retirer
	 */
	public void enleverLien(int indice) {
		liste.supprimer(indice);
	}

	/***
	 * Ajoute le lien à la fin.
	 * @param ceLien lien à ajouter 
	 */
	public void ajouterLienFin(Lien ceLien) {
		liste.insererALaPosition(ceLien, getNbLien());
	}

	/***
	 * 
	 * @param duDebut boolean qui determine si 
	 * la liste retourne va du début au indexCoupe 
	 * ou indexCoupe à fin de la liste 
	 * @param indexCoupe index du elem d'ou copier
	 * @return la copie d’une fraction de la liste de liens.
	 */
	public Liste obtientFraction(boolean duDebut, int indexCoupe) {

		Liste nouvelleListe;
		if(duDebut == true) {
			nouvelleListe = liste.copie(0, indexCoupe+1);
		} else {
			nouvelleListe = liste.copie(indexCoupe, getNbLien());
		}
		return nouvelleListe;
	}

	/***
	 * Créer et retourne une chaîne de caractères en filant tous les liens
	 *  de la carte, à raison d’un lien par ligne.
	 *  Après avoir enfilé tous les liens, ajouter le score.
	 */
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
