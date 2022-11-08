package problemeVilles;

import TP2.Point2D;
import TP2.Ville;
import enginCartes.CONFIGURATION;

/**
 * La population de villes est la classe qui contient 
 * toutes les villes de la région. 
 * @author Radhika Chatterjee Simon Pitre-Lamas
 * */

public class PopulationVilles {

	private Ville[] lesVilles;// tableau contenant les villes de la région

	/***
	 * Constructeur par copie d’attributs (ou par paramètres). 
	 * Le constructeur doit prendre en charge l’initialisation 
	 * des config.getNbVilles() constituant la population. 
	 * Les villes sont à initialiser avec des numéros 
	 * qui se suivent {0,1,2,...,N-1} et des positions aléatoires entre 
	 * 0-config.getMaxX() et 0-config.getMaxY().
	 * 
	 * */
	public PopulationVilles(CONFIGURATION config) {

		//Initialiser le tableau avec le nbrVille de Villes
		this.lesVilles= new Ville[config.getNbVilles()];

		//Initialiser chaque ville avec un nombre et une position
		for(int i=0;i<lesVilles.length;i++) {	
			lesVilles[i]= new Ville(i,getPointsVille(config));
		}
	}

	/***
	 * Constructeur par copie d'attributs 
	 * 
	 * @param nbrVilles nbrville dans la région
	 * @param x valeur max du X
	 * @param y valeur max du y
	 */
	public PopulationVilles(int nbrVilles, double x, double y) {
		this.lesVilles= new Ville[nbrVilles];
		for(int i=0;i<lesVilles.length;i++) {	
			lesVilles[i]= new Ville(i,getPointsVilleAvecCoordoneeMinMax(x,y));
		}
	}

	/***
	 * @param config du region
	 * @return un point2D avec coordonne au hazard
	 */
	public Point2D getPointsVille(CONFIGURATION config) {
		double x= nbrAlea(0.0,config.getMaxX());
		double y= nbrAlea(0.0,config.getMaxY());
		Point2D point= new Point2D(x,y);
		return point;
	}

	/***
	 * @param x valeur max de X
	 * @param y valeur max de Y
	 * @return un point2D avec coordonne au hazard avec un min-max 
	 */
	private Point2D getPointsVilleAvecCoordoneeMinMax(double x, double y) {
		double px= nbrAlea(0.0,x);
		double py= nbrAlea(0.0,y);
		Point2D point= new Point2D(px,py);
		return point;
	}



	//Fonction qui retourne nombre aléatoire entre min-max incluses
	private double nbrAlea(double min, double max){
		return (double) Math.round(Math.random()* (max - min) + min);
	}	

	/***
	 * Retourne la ville à l’index. 
	 * @param numero de la ville
	 * @return ville trouvé ou null si pas trouvé
	 */
	public Ville getVille(int numero) {
		Ville v=null;

		if(numero!=lesVilles.length) {
			v=lesVilles[numero];
		}
		return v;
	} 

	/***
	 * Informatrice sur le nombre de villes définies.
	 * @return nombre de ville dans la région
	 */
	public int getNbVilles() {

		int nbrVilles=0;

		for(int i=0;i<lesVilles.length;i++) {	
			if(lesVilles[i]!=null) {
				nbrVilles++;
			}
		}		
		return nbrVilles;
	}


	/***
	 * Cette méthode construit et retourne une chaîne de caractères qui
	 *  représente toutes les villes de la population,
	 *   à raison d’une ville par ligne.
	 */
	@Override
	public String toString() {
		String message="";

		for(int i=0;i<lesVilles.length;i++) {	
			if(lesVilles[i]!=null) {
				message+=lesVilles[i].toString()+"\n";
			}
		}	
		return message;
	}
}
