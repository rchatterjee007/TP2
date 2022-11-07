package TP2.Tests;


import enginCartes.CONFIGURATION;
import problemeVilles.PopulationVilles;

/**
 * Classe qui valide les données de la class PopulationVilles
 * @author Radhika Chatterjee Simon Pitre-Lamas
 *
 */
public class TestPopulationVilles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		CONFIGURATION config = new CONFIGURATION();
		
		//Test Constructeur PopulationVilles()
		PopulationVilles popVilles = new PopulationVilles(config);
		System.out.println("Test Constructeur de PopulationVilles: ---->"
				+"\n"+popVilles.toString());
		
		
		//Test Accesseur getPointVille()
		System.out.println("Test Accesseur des points de la Ville ---->"
				+ " avec config comme paramètre: ---->   "
				+"\n"+popVilles.getPointsVille(config)
				+"\n");
		
		//Test Accesseur getVille()
		System.out.println("Test Accesseur de la Ville +"
				+ " avec 0 comme paramètre: ---->   "
				+"\n"+popVilles.getVille(0)
				+"\n");
		
		//Test toString()
		System.out.println("Test affichage des références aux Villes"
				+ " incluant les positions et les numéros: ---->"
				+"\n"+popVilles.toString()
				+"\n");
		
		//Test toString()

		System.out.println("Test affichage de populations de villes ---->"
				+"\n Première ville : "+popVilles.getVille(0)
				+"\n"+popVilles.toString()
				+" Dernière ville : "
				+popVilles.getVille(popVilles.getNbVilles()-1)
				+"\n");

	}
	
	

}
