package TP2;
/**
 * Classe avec une coordonnee x et y 
 * 
 * @author radhikachatterjee
 * **/
public class Point2D {

	private double X;
	private double Y;

	public double getX() {
		return X;
	}

	public void setX(double x) {
		this.X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		this.Y = y;
	}

	public Point2D(Point2D xy) {
		this.X = xy.X;
		this.Y = xy.Y;
	}

	public Point2D(double x, double y) {
		super();
		this.X = x;
		this.Y = y;
	}

	public Point2D() {
		// TODO Auto-generated constructor stub		
		X=0.0;
		Y=0.0;
	}

	public boolean equals(Point2D xy) {
		return this.X==xy.X && this.Y==xy.Y;
	}


	protected Point2D clone(Point2D xy) throws CloneNotSupportedException  {
		// TODO Auto-generated method stub
		return (Point2D)xy.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "( X: "+this.X+" Y: "+this.Y+" )";
	}



}
