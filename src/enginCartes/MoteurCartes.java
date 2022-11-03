package enginCartes;

/**
 * Cette classe Implemente le moteur de gestions de la population de cartes candidates

 * 
 * Liste des méthodes publiques: 
 *     - MoteurCartes, constructeur par paramètre
 *     - reduitLaPopulation, opération qui réduit la population à NB_CARTES_BASES
 *     - elargieLaPopulation, opération qui elargie la population à NB_CARTES_MAX
 *     - evalueLesScores, calcul les scores des cartes
 *     - afficheMeilleurSolution, affiche la meilleur solution
 *     - afficheMeilleurScore, affiche le meilleur score
 *     - toString, représentation de l'objet en chaine de caractères
 *     
 * Cette classe utilise votre liste chaînée, il se peut que vous devient ajuster 
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

import enginCartes.CONFIGURATION;
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
	public MoteurCartes(PopulationVilles popVilles, CONFIGURATION config){
		
		this.popVilles=popVilles;
		this.config=config;
	}
	

	/**
	 * reduit la population de carte en ne gardant que les CONFIGURATION.NB_CARTES_BASES
	 * ayant le plus bas score (minimization). Cette méthode opère sur les champs de la classe
	 */
	public void reduitLaPopulation(){
	
		// à compléter
	
	}

	/**
	 * elargie la population de carte en générant de nouvelles cartes qui sont des mix de cartes
	 * existantes. Cette méthode opère sur les champs de la classe.
	 */
	public void elargieLaPopulation(){

		// elargie la population en générant de nouveaux individus, qui combinent les gênes
		// des parents.
		
		// calcul la somme des scores de tous les parents
		double sommeScore = 0.0;
		
		for(int i=0;i<cartes.size();i++){
			sommeScore += cartes.get(i).getScore();
		}
		
		int nbCartesMax = config.getNbCartesMax();
		int nbCartesBase = config.getNbCartesBase();
		
		// pour tous les individues à générer
		for(int i=0;i<(nbCartesMax-nbCartesBase);i++){
			
			// selectionne 2 coupes de parents aléatoirement
			Liste section1 = obtientUneCoupe(sommeScore);
			Liste section2 = obtientUneCoupe(sommeScore);
			
			// assemble et ajoute le nouvel individu
			//cartes.add(new Carte(moteurDistanceMoyenne, section1, section2, config));
			cartes.add(new Carte(moteurDistanceMoyenne, section1, section2, config));

		}
	
	}

	/**
	 * Obtient une section de carte selectionné au hasard parmis la liste de cartes
	 * en proportion de leur score.
	 * 
	 * NOTE: la technique employé est de donner plus de poids aux cartes de bases ayant les plus mauvais
	 * 		 score. Cette approche augmente le mélange des éléments et aide à sortir des minimum locaux
	 * 
	 * NOTE: la technique tend également à favoriser les solutions courtes en applicant un retrait de liens
	 * 
	 * @param sommeScore somme des scores de la population de cartes
	 * @return une section de carte (ListeDChainee)
	 */
	private Liste obtientUneCoupe(double sommeScore){
		

		int i=0;
		double nbAlea = rand.nextDouble()*sommeScore;
		double accumulationScore = 0;
		Carte courante = null;
		
		int nbCartesBase = config.getNbCartesBase();
		
		// selectionne l'individu en proportion du score
		while(i<nbCartesBase && accumulationScore<=nbAlea){
			
			courante = cartes.get(i);
			accumulationScore += courante.getScore();
			
			i++;
		}
		System.out.println(courante.getNbLien());
		
		// obtient une fraction de l'individu
		Liste section = courante.obtientFraction(rand.nextBoolean(), 
				                           rand.nextInt(courante.getNbLien()));

		// applique une mutation si nécessaire
		if(rand.nextDouble() < config.getPourcentageMutation()){
			int indexLien = rand.nextInt(section.getNbrElements());
			
			((Lien)section.getElement(indexLien)).mute(popVilles
					           .getVille(rand.nextInt(popVilles.getNbVilles())), 
					           rand.nextInt(2));
		}

		// retire un lien pour favoriser solution courtes
		if(rand.nextDouble() < config.getPourcentageRetrait()){
			int indexLien = rand.nextInt(section.getNbrElements());
			section.supprimer(indexLien);
		}
		
		return section;
		
	}
	
	/**
	 * Calcul les scores des cartes
	 */
	public double evalueLesScores(){
		double score=0.0;
		// à compléter
		
		for (int i = 0; i < cartes.size(); i++)
        {
           score+=cartes.get(i).getScore();
        }
		return score;
		
	}
	
	/**
	 * Affiche la meilleur solution
	 */
	public Carte getMeilleurSolution(){
		return cartes.get(0);
	}

	/**
	 * Affiche le meilleur score
	 */
	public void afficheMeilleurScore(){
		System.out.println("Meilleur score: " + cartes.get(0).getScore());
		
	}
	
	/**
	 * Retourne une représentation chaine de caractère de l'objet
	 * 
	 *  @return Chaine de caractère représentant l'objet
	 */
	public String toString(){
    	
		String str = new String();
    	str += "Liste des Cartes\n";
    	
    	// affiche toutes les cartes
    	for(int i=0;i<cartes.size();i++){
    		str += "Carte: " + i + "------------------------------------";
    		str += cartes.get(i).toString();
    		str += "\n";
    	}
    	return str;
	}


	public void setPopulation(PopulationVilles popVilles) {
	
		// Évite pls appels à l'accesseur.
		int nbCartesBase = config.getNbCartesBase();

		// population de cartes
		cartes =
				new Vector<Carte>(nbCartesBase);

		// instancie un moteur de distance moyenne
		moteurDistanceMoyenne = new MoteurDistanceMoyenne(popVilles);
		this.popVilles = popVilles;

		// crée la population de cartes initiales
		for(int i=0; i < nbCartesBase; i++){

			// crée une nouvelle carte
			//	Carte temp = new Carte(moteurDistanceMoyenne, config);
			Carte temp = new Carte(moteurDistanceMoyenne);

			// selectionne 2 villes différentes au hasard
			for(int j=0;j<popVilles.getNbVilles()/2;j++){
				Ville villeA = popVilles.getVille(rand.nextInt(popVilles.getNbVilles()));
				Ville villeB = popVilles.getVille(rand.nextInt(popVilles.getNbVilles()));

				while(villeA == villeB){
					villeB = popVilles.getVille(rand.nextInt(popVilles.getNbVilles()));
				}

				//temp.ajouterLien(new Lien(villeA,villeB));
				temp.ajouterLienFin(new Lien(villeA,villeB));
			}

			// ajoute la carte à la liste
			cartes.addElement(temp);
		}

	}
	
}
