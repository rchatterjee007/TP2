package TP2;
/**
 * La classe Ville contient les informations relatives à 
 * une ville dans le problème. Toutes les villes sont situées 
 * dans un plan cartésien avec des coordonnées rectangulaires {X, Y}. 
 * @author radhikachatterjee
 * */
public class Ville {
	
	private int numero;
	private Point2D position;
	

	public Ville() {
		// TODO Auto-generated constructor stub
		numero=0;
		position= new Point2D();
	}

	public Ville(int numero, Point2D position) {
		super();
		this.numero = numero;
		this.position = position;
	}
	
	public Ville(Ville ville) {
		// TODO Auto-generated constructor stub
		this.numero=ville.numero;
		this.position=ville.position;
	}

	public int getNumero() {
		return numero;
	}

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
	 * */
	public double distanceAvec(Ville ville2) {
		double x=ville2.position.getX()-this.position.getX();
		double y=ville2.position.getY()-this.position.getY();
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	
}
