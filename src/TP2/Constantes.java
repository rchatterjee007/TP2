package TP2;

/**
 * Les constantes de départ de la simulation.
 * 
 * @author Pierre Bélisle
 * @version copyright A2022
 */
public class Constantes {

	// Les détails vous seront données dans les énoncés au bon moment.
	// Ayez ce fichier à porter de vue
	public static final double POURCENTAGE_MUTATION = 0.5;
	public static final double POURCENTAGE_RETRAIT = 0.5;

	public static final double MAX_X = 3000.0;
	public static final double MAX_Y = MAX_X;

	public static final double PENALITE_LONGUEUR = (double)(2000.0/MAX_X); //20.0
	public static final double PENALITE_DISTANCE = (double)(100.0/MAX_X); //1
	public static final int PENALITE_DECONNECTE = 1000;
	
	//8
	public static final int NB_VILLES = 8;
	public static final int NB_ITERATIONS = 26;
	//20
	//4
	public static final int NB_CARTES_BASE = 2;
	public static final int NB_CARTES_MAX = 4;

}
