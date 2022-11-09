package TP2;
/**
 * La classe Ville contient les informations relatives à 
 * une ville dans le problème. Toutes les villes sont situées 
 * dans un plan cartésien avec des coordonnées rectangulaires {X, Y}. 
 * @author Radhika Chatterjee Simon Pitre-Lamas
 * */
public class Ville {

	//Attributs de la classe Ville
	private int numero;//Un entier représentant le numéro unique de la ville.
	private Point2D position;//La position, Deux nombres réels (ou Point2D). 


	/**
	 * Constructeur par défaut qui initialise une ville vide
	 * */
	public Ville() {
		numero=0;
		position= new Point2D();//constructue par defaut x=0 et y=0
	}

	/**
	 * Constructeur par copie d'attributs 
	 * @param numero nouveau numero de la ville
	 * @param position nouveau position de la ville
	 * */
	public Ville(int numero, Point2D position) {
		super();
		this.numero = numero;
		this.position = position;
	}

	/**
	 * Constructeur par copie d'objet 
	 * 
	 * @param ville dont le numero et position seront à accorder à la ville
	 * */
	public Ville(Ville ville) {
		this.numero=ville.numero;
		this.position=ville.position;
	}

	/**
	 * Accesseur du numero de la ville
	 * */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return une chaîne de caractères avec les données de la ville 
	 * sous forme compacte (ex : « Ville# 1  (10.7, 5.2) »). 
	 * */
	public String toString() {
		return "« Ville# "+this.numero+"  ("+
				this.position.getX()+", "+this.position.getY()+") »";
	}


	/**
	 * Cette méthode calcule la distance avec la ville courante (this)
	 *  et une autre ville. La distance se calcule à l’aide l’équation 
	 *  de la distance euclidienne en 2 dimensions,
	 *   aussi appelée équation de Pythagore:
	 *   distance = √((x_2-x_1)²+(y_2-y_1)²)
	 *   
	 *   @param ville 2 la ville à comparer sa distance avec
	 * */
	public double distanceAvec(Ville ville2) {
		double x=ville2.position.getX()-this.position.getX();
		double y=ville2.position.getY()-this.position.getY();
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public boolean equals(Ville v) {
		return this.numero==v.numero&& this.position.equals(v.position);
	}
}
