package enginCartes;

import TP2.Constantes;

/**
 * La class qui retournes les valeurs des Constantes
 * @author Radhika Chatterjee Simon Pitre-Lamas
 * @version copyright A2022
 */
public final class CONFIGURATION {

	/*
	 * Attributs represantant les constantes 
	 * */
	private double pourcentageMutation;
	private double pourcentageRetrait;

	private double maxX;
	private double maxY;

	private double penaliteLongueur; 
	private double penaliteDistance;
	private int penaliteDeconnect;

	private int nbVilles;
	private int nbIterations;

	private int nbCartesBase;
	private int nbCartesMax;


	/**
	 * Constructeur par défaut qui initialise chaque attribut avec sa 
	 * valeur correspondant de la class Constantes
	 * 
	 * */
	public CONFIGURATION() {
		this.pourcentageMutation=Constantes.POURCENTAGE_MUTATION;
		this.pourcentageRetrait=Constantes.POURCENTAGE_RETRAIT;
		this.maxX=Constantes.MAX_X;
		this.maxY=Constantes.MAX_Y;
		this.penaliteLongueur=Constantes.PENALITE_LONGUEUR;
		this.penaliteDistance=Constantes.PENALITE_DISTANCE;
		this.penaliteDeconnect=Constantes.PENALITE_DECONNECTE;
		this.nbVilles=Constantes.NB_VILLES;
		this.nbIterations=Constantes.NB_ITERATIONS;
		this.nbCartesBase=Constantes.NB_CARTES_BASE;
		this.nbCartesMax=Constantes.NB_CARTES_MAX;
	}

	/**
	 * Accesseur de l'attribut pourcentageMutation
	 * */
	public double getPourcentageMutation() {
		return pourcentageMutation;
	}


	/**
	 * Accesseur de l'attribut pourcentageRetrait
	 * */
	public double getPourcentageRetrait() {
		return pourcentageRetrait;
	}


	/**
	 * Accesseur de l'attribut maxX
	 * */
	public double getMaxX() {
		return maxX;
	}


	/**
	 * Accesseur de l'attribut maxY
	 * */
	public double getMaxY() {
		return maxY;
	}


	/**
	 * Accesseur de l'attribut penaliteLongueur
	 * */
	public double getPenaliteLongeur() {
		return penaliteLongueur;
	}


	/**
	 * Accesseur de l'attribut penaliteDistance
	 * */
	public double getPenaliteDistance() {
		return penaliteDistance;
	}


	/**
	 * Accesseur de l'attribut penaliteDeconnect
	 * */
	public int getPenaliteDeconnect() {
		return penaliteDeconnect;
	}


	/**
	 * Accesseur de l'attribut nbVilles
	 * */
	public int getNbVilles() {
		return nbVilles;
	}


	/**
	 * Accesseur de l'attribut nbIterations
	 * */
	public int getNbIterations() {
		return nbIterations;
	}


	/**
	 * Accesseur de l'attribut nbCartesBase
	 * */
	public int getNbCartesBase() {
		return nbCartesBase;
	}


	/**
	 * Accesseur de l'attribut nbCartesMax
	 * */
	public int getNbCartesMax() {
		return nbCartesMax;
	}

}
