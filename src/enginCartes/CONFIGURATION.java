package enginCartes;

import TP2.Constantes;

/**
 * La class qui retournes les valeurs des Constantes
 * 
 * @author Radhika Chatterjee
 * @author radhikachatterjee Simon Pitre-Lamas
 * @version copyright A2022
 */
public class CONFIGURATION {

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



	public CONFIGURATION() {
		// TODO Auto-generated constructor stub
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

	public double getPourcentageMutation() {
		return pourcentageMutation;
	}



	public double getPourcentageRetrait() {
		return pourcentageRetrait;
	}



	public double getMaxX() {
		return maxX;
	}



	public double getMaxY() {
		return maxY;
	}



	public double getPenaliteLongeur() {
		return penaliteLongueur;
	}



	public double getPenaliteDistance() {
		return penaliteDistance;
	}



	public int getPenaliteDeconnect() {
		return penaliteDeconnect;
	}



	public int getNbVilles() {
		return nbVilles;
	}



	public int getNbIterations() {
		return nbIterations;
	}



	public int getNbCartesBase() {
		return nbCartesBase;
	}



	public int getNbCartesMax() {
		return nbCartesMax;
	}

}
