package problemeVilles;

import TP2.Point2D;
import TP2.Ville;
import enginCartes.CONFIGURATION;

/**
 * La population de villes est la classe qui contient toutes les villes de la région. 
 * @author radhikachatterjee
 * */

public class PopulationVilles {

	private Ville[] lesVilles;

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


	public Point2D getPointsVille(CONFIGURATION config) {
		double x= nbrAlea(0.0,config.getMaxX());
		double y= nbrAlea(0.0,config.getMaxY());
		Point2D point= new Point2D(x,y);
		return point;
	}


	private double nbrAlea(double min, double max){
		return (double) Math.round(Math.random()* (max - min) + min);
	}	

	public Ville getVille(int numero) {
		Ville v=null;
		
		if(numero!=lesVilles.length) {
			v=lesVilles[numero];
		}
		return v;
	} 

	public int getNbVilles() {

		int nbrVilles=0;

		for(int i=0;i<lesVilles.length;i++) {	
			if(lesVilles[i]!=null) {
				nbrVilles++;
			}
		}		
		return nbrVilles;
	}


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
