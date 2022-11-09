package TP2;

/**
 * La classe lien représente une connexion ferroviaire entre deux villes.
 * Elle contient une référence à chacune des deux villes connectées. 
 * 
 * @author Radhika Chatterjee Simon Pitre-Lamas
 * @version copyright A2022
 */
/**
 * @author radhikachatterjee
 *
 */
public class Lien {

	//Attributs 
	private Ville villeSource;
	private Ville villeDestination;

	/**
	 * Constructeur par défaut qui initialise les deux ville à vide 
	 * */
	public Lien() {
		
		this.villeDestination= null;
		this.villeSource= null;
		
		//this.villeDestination= new Ville();
		//this.villeSource= new Ville();
	}

	/**
	 * Constructeur par copie d'attribut
	 * @param villeSource Ville source du lien
	 * @param villeDestination Ville destination du lien
	 * */
	public Lien(Ville villeSource, Ville villeDestination) {
		super();
		this.villeSource = villeSource;
		this.villeDestination = villeDestination;
	}

	/**
	 * Constructeur par copie d'objet
	 * @param lien dont les valeurs sont à copier dans ce lien
	 */
	public Lien(Lien lien) {
		// TODO Auto-generated constructor stub

		this.villeDestination= lien.villeDestination;
		this.villeSource= lien.villeSource;
	}


	/**
	 * Acesseur de la ville Source 
	 * */
	public Ville getVilleSource() {
		return villeSource;
	}

	/**
	 * Mutateur de la ville Souce
	 * 
	 * @param villeSouce nouvelle ville source du lien  
	 * */
	public void setVilleSource(Ville villeSource) {
		this.villeSource = villeSource;
	}

	/**
	 * Acesseur de la ville Destination 
	 * */
	public Ville getVilleDestination() {
		return villeDestination;
	}

	/**
	 * Mutateur de la ville destination
	 * 
	 * @param villeSouce nouvelle ville destination du lien  
	 * */
	public void setVilleDestination(Ville villeDestination) {
		this.villeDestination = villeDestination;
	}

	/*
	 * Retourne la distance entre les deux villes du lien.
	 * **/
	public double getDistance() {
		return this.villeSource.distanceAvec(this.villeDestination);
	} 

	/**
	 * Retourne true, si la ville reçue en paramètre est 
	 * l’une des deux villes connectées; false, sinon.
	 * **/
	public boolean estMembre(Ville ville) {
		return villeSource.equals(ville) || villeDestination.equals(ville);
	}

	/**
	 * Retourne une référence à la ville 
	 * qui complémente la ville reçue en paramètre.
	 *  Dans le cas où la ville reçue n’est pas membre, 
	 *  la méthode retourne null.
	 * */

	public Ville getDest(Ville ville) {
		Ville uneVille=null;

		if(villeSource.equals(ville)) {
			uneVille=this.villeDestination;
		}
		if(villeDestination.equals(ville)) {
			uneVille=this.villeSource;
		}
		else if(this.estMembre(ville)==false) {
			uneVille=null;
		}
		return uneVille;	
	}

	/**
	 * Retourne une copie du lien. 
	 * */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Ville)this.clone();
	}

	/**
	 * Retourne une chaîne de caractères qui représente les deux villes 
	 * connectées sur une seule ligne.
	 * */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String message ="Depart: "+villeSource.toString()+
				" --->  Destination: "+villeDestination.toString();
		return message;
	} 

	/**
	 * Cette méthode sert à modifier le lien en assignant une nouvelle ville 
	 * selon la position {0 pour source et  1 pour destination}. 
	 * 
	 * 1.	La nouvelle ville ne soit pas membre du lien
	 * 2.	Si l’opération est valide, la nouvelleVille est mise à la position 
	 * 		donnée et la méthode retourne true.Sinon, la méthode retourne false.

	 * */
	public boolean mute(Ville nouvelleVille, int position) {
		boolean changementEffectue=false;	
		if(!this.estMembre(nouvelleVille)) {
			//SI CETTE VILLE NE FAIT PAS PARTIE DU LIEN...
			
			if(position==0) {
				
				this.setVilleSource(nouvelleVille);
				changementEffectue=true;
				
			}else if(position==1) {
				
				this.setVilleDestination(nouvelleVille);
				changementEffectue=true;
			}
		}

		return changementEffectue;
	}
}
