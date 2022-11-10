package enginCartes;

/**
 * Cette classe Implemente le moteur de gestions de la population de cartes 
 * candidates

 * 
 * Liste des méthodes publiques: 
 *     - MoteurCartes, constructeur par paramètre
 *     - reduitLaPopulation, opération qui réduit la population à 
 *     NB_CARTES_BASES
 *     - elargieLaPopulation, opération qui elargie la population à 
 *     NB_CARTES_MAX
 *     - evalueLesScores, calcul les scores des cartes
 *     - afficheMeilleurSolution, affiche la meilleur solution
 *     - afficheMeilleurScore, affiche le meilleur score
 *     - toString, représentation de l'objet en chaine de caractères
 *     
 * Cette classe utilise votre liste chaînée, 
 * il se peut que vous devient ajuster 
 * la signature des méthodes selon votre classe.
 *
 * @author Fred Simard | ETS, 
 * @version Automne 2022
 */

import java.util.Random;
import java.util.Vector;

import TP2.Carte;
import TP2.Lien;
import TP2.Ville;
import problemeVilles.PopulationVilles;

import listeChaine.Liste;

public class MoteurCartes {

	private PopulationVilles popVilles;
	private Vector<Carte> cartes; // à remplacer par collection Java
	private MoteurDistanceMoyenne moteurDistanceMoyenne;
	private Random rand = new Random();
	CONFIGURATION config;

	/**
	 * Constructeur par paramètre
	 * 
	 * @param popVilles, la population de villes
	 */
	/*
	 * Constructeur par paramètre. Il garde une copie de la référence à la
	 * population de Villes et de la configuration, il initialise un
	 * MoteurDistanceMoyenne et initialise le vecteur avec 
	 * config.getNbCartesBases
	 * cartes. Chaque carte doit recevoir un nombre de liens, 
	 * dont les villes sont
	 * choisies au hasard égales au nombre de villes divisé par 2.
	 */
	public MoteurCartes(PopulationVilles popVilles, CONFIGURATION config) {

		this.popVilles = popVilles;
		this.config = config;
		this.moteurDistanceMoyenne = new MoteurDistanceMoyenne(popVilles);
		cartes = new Vector<Carte>(config.getNbCartesBase());
		setPopulation(popVilles);
		//System.out.println("ZZZZ : "+cartes.get(0).getNbLien());
	}


	/**
	 * Reduit la population de carte en ne gardant que les
	 * CONFIGURATION.NB_CARTES_BASES ayant le plus bas score (minimization). 
	 * Cette méthode opère sur les champs de la classe
	 */
	public void reduitLaPopulation() {
		Vector<Carte> meilleurCartes = new Vector<Carte>();
		meilleurCartes.add(cartes.get(0));
		for(int i=1; i<cartes.size(); i++) {
			Carte carte = cartes.get(i);
			meilleurCartes = placer(carte, meilleurCartes);
			if(meilleurCartes.size() > config.getNbCartesBase()) {
				meilleurCartes.remove(meilleurCartes.size()-1);
			}
		}
		cartes = meilleurCartes;
	}


	/**
	 * Place une carte dans un vecteur de type carte en ordre croissant de score
	 * @param carte
	 * @param meilleurCartes
	 * @return un vecteur de carte
	 */
	private Vector<Carte> placer(Carte carte, Vector<Carte> meilleurCartes) {
		double scoreCarte = carte.getScore();
		double scoreCarteFin = meilleurCartes.
				get(meilleurCartes.size()-1).getScore();
		double scoreCarteDebut = meilleurCartes.
				get(meilleurCartes.size()-1).getScore();
		
		if(scoreCarte < scoreCarteDebut) {
			meilleurCartes.add(0, carte);
		}
		else if(scoreCarte > scoreCarteFin) {
			meilleurCartes.add(meilleurCartes.size(), carte);
		}
		else {
			int pos = 1;
			Boolean trouverPositon = false;
			while(trouverPositon) {
				double scoreCarteMilieu = meilleurCartes.get(pos).getScore();
				if(scoreCarte <= scoreCarteMilieu) {
					meilleurCartes.add(pos, carte);
					trouverPositon = true;
				} else {
					pos++;
				}
			}
		}
		
		return meilleurCartes;
	}


	/**
	 * elargie la population de carte en générant de nouvelles cartes qui 
	 * sont des mix de cartes existantes. Cette méthode opère 
	 * sur les champs de la classe.
	 */
	public void elargieLaPopulation() {
		// elargie la population en générant de nouveaux individus, 
		//qui combinent les gênes des parents.
		// calcul la somme des scores de tous les parents
		double sommeScore = 0.0;
		
		for (int i = 1; i < cartes.size(); i++) {
			sommeScore += cartes.get(i).getScore();
		}
		
		int nbCartesMax = config.getNbCartesMax();
		int nbCartesBase = config.getNbCartesBase();
		// pour tous les individues à générer
		for (int i = 0; i < (nbCartesMax - nbCartesBase); i++) {
			// selectionne 2 coupes de parents aléatoirement
			Liste section1 = obtientUneCoupe(sommeScore);
			Liste section2 = obtientUneCoupe(sommeScore);
			// assemble et ajoute le nouvel individu
			Carte carte = new Carte(moteurDistanceMoyenne, section1, 
					section2, config);
			
			if(carte.getNbLien() > 0) {
				cartes.add(carte);
			}
		}
	}


	/**
	 * Obtient une section de carte selectionné au hasard parmis la 
	 * liste de cartes en proportion de leur score.
	 * 
	 * NOTE: la technique employé est de donner plus de poids 
	 * aux cartes de bases ayant les plus mauvais score. 
	 * Cette approche augmente le mélange des éléments
	 * et aide à sortir des minimum locaux
	 * 
	 * NOTE: la technique tend également à favoriser les solutions courtes en
	 * applicant un retrait de liens
	 * 
	 * @param sommeScore somme des scores de la population de cartes
	 * @return une section de carte (ListeDChainee)
	 */
	private Liste obtientUneCoupe(double sommeScore) {
		int i = 0;
		double nbAlea = rand.nextDouble() * sommeScore;
		double accumulationScore = 0;
		Carte courante = null;
		int nbCartesBase = config.getNbCartesBase();
		// selectionne l'individu en proportion du score
		
		while (i < nbCartesBase && accumulationScore <= nbAlea) {
			courante = cartes.get(i);
			accumulationScore += courante.getScore();
			i++;
		}
		
		System.out.println("Carte " + cartes.size());
		System.out.println("Nbr liens : " + courante.getNbLien());
		
		Liste section = new Liste();
		Boolean bool = rand.nextBoolean();
		int nbrLiens = courante.getNbLien();
		int randInt = rand.nextInt(nbrLiens);
		// obtient une fraction de l'individu
		section = courante.obtientFraction(bool, randInt);
		// applique une mutation si nécessaire
		
		if (rand.nextDouble() < config.getPourcentageMutation()) {
			int indexLien = rand.nextInt(section.getNbrElements());
			((Lien) section.getElement(indexLien)).mute
			(popVilles.getVille(rand.nextInt(popVilles.getNbVilles())),
					rand.nextInt(2));
		}
		// retire un lien pour favoriser solution courtes
		double dalea = rand.nextDouble();
		
		if (dalea < config.getPourcentageRetrait()) {
			int nbelem = section.getNbrElements();
			int indexLien = rand.nextInt(nbelem);
			section.supprimer(indexLien);
		}
		return section;
	}


	/**
	 * Calcul les scores des cartes
	 */
	public void evalueLesScores(Boolean afficher) {
		for (int i = 0; i < cartes.size(); i++) {
			cartes.get(i).evalueScore(afficher);
		}
	}


	/**
	 * Calcul le score de la meilleur carte
	 */
	public void evalueScoreMeilleurCartes(Boolean afficher) {
		cartes.get(0).evalueScore(afficher);
	}


	/**
	 * Affiche la meilleur solution
	 */
	public Carte getMeilleurSolution() {
		return cartes.get(0);
	}


	/**
	 * Affiche le meilleur score
	 */
	public void afficheMeilleurScore() {
		System.out.println("Meilleur score: " + cartes.get(0).getScore());
	}


	/**
	 * Retourne une représentation chaine de caractère de l'objet
	 * 
	 * @return Chaine de caractère représentant l'objet
	 */
	public String toString() {
		String str = new String();
		str += "Liste des Cartes\n";
		// affiche toutes les cartes
		for (int i = 0; i < cartes.size(); i++) {
			str += "Carte: " + i + "------------------------------------" +"\n";
			str += cartes.get(i).toString();
			str += "\n";
		}
		return str;
	}

	/***
	 * Set une population dans une carte 
	 * @param popVilles villes de la cartes
	 */
	public void setPopulation(PopulationVilles popVilles) {
		// Évite pls appels à l'accesseur.
		int nbCartesBase = config.getNbCartesBase();
		// population de cartes
		cartes = new Vector<Carte>(nbCartesBase);
		// instancie un moteur de distance moyenne
		moteurDistanceMoyenne = new MoteurDistanceMoyenne(popVilles);
		this.popVilles = popVilles;
		// crée la population de cartes initiales
		
		for (int i = 0; i < nbCartesBase; i++) {
			// crée une nouvelle carte
			// Carte temp = new Carte(moteurDistanceMoyenne, config);
			Carte temp = new Carte(moteurDistanceMoyenne, config);
			// selectionne 2 villes différentes au hasard
			
			for (int j = 0; j < popVilles.getNbVilles() /2; j++) {
				Ville villeA = popVilles.getVille
						(rand.nextInt(popVilles.getNbVilles()));
				Ville villeB = popVilles.getVille
						(rand.nextInt(popVilles.getNbVilles()));
				
				while (villeA == villeB) {
					villeB = popVilles.getVille
							(rand.nextInt(popVilles.getNbVilles()));
				}
				// temp.ajouterLien(new Lien(villeA,villeB));
				temp.ajouterLienFin(new Lien(villeA, villeB));
			}
			// ajoute la carte à la liste
			cartes.addElement(temp);
		}
	}
}
