package TP2;
/**
 * Classe avec une coordonnee x et y 
 * 
 * @author radhikachatterjee Simon Pitre-Lamas
 * **/
public class Point2D {

	private double X;
	private double Y;

	/***
	 * Accesseur du x d'un point 
	 * @return x
	 */
	public double getX() {
		return X;
	}

	/***
	 * Mutateur du x d'un point 
	 * @param nouveau valeur du x d'un point 2D
	 */
	public void setX(double x) {
		this.X = x;
	}

	/***
	 * Accesseur du y d'un point 
	 * @return y
	 */
	public double getY() {
		return Y;
	}

	/***
	 * Mutateur du y d'un point 
	 * @param nouveau valeur du y d'un point 2D
	 */
	public void setY(double y) {
		this.Y = y;
	}

	//Constructeur par objet
	public Point2D(Point2D xy) {
		this.X = xy.X;
		this.Y = xy.Y;
	}

	//Constructeur par copie d'attributs
	public Point2D(double x, double y) {
		super();
		this.X = x;
		this.Y = y;
	}

	//Constructeur par défaut
	public Point2D() {
		// TODO Auto-generated constructor stub		
		X=0.0;
		Y=0.0;
	}

	//Comparaison des deux points2D
	public boolean equals(Point2D xy) {
		return this.X==xy.X && this.Y==xy.Y;
	}

	//Retourne un nouveau point2D 
	protected Point2D clone(Point2D xy) throws CloneNotSupportedException  {
		// TODO Auto-generated method stub
		return (Point2D)xy.clone();
	}
	
	//Retourne un point2D en caractères 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "( X: "+this.X+" Y: "+this.Y+" )";
	}
}
