package TP2;

public class Carte {

	MoteurDistanceMoyenne moteurDistanceMoyenne = null;
	int score;
	Liste liste;
	
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne) {
		
		this.moteurDistanceMoyenne = moteurDistanceMoyenne;
		liste = new Liste();
		
	}
	
	public Carte(Object moteurDistanceMoyenne, Liste section1, 
			Liste section2) 
	{
		
		liste = section1.fusionnerListe(section2);
	}
	
	
	public int getNbLien() {
		return liste.getNbrElements();
	}
	
	public int getScore() {
		return score;
	}
	
	public void evalueScore(boolean afficher) {
		
	}
	
	public void enleverLien(int indice) {
		liste.supprimer(indice);
	}
	
	public void ajouterLienFin(Lien ceLien) {
		liste.insererALaPosition(ceLien, getNbLien());
	}
	public Liste obtientFraction(boolean duDebut, int indexCoupe) {
		
		Liste nouvelleListe;
		if(duDebut == true) {
			nouvelleListe = liste.copie(0, indexCoupe);
		} else {
			nouvelleListe = liste.copie(indexCoupe, getNbLien());
		}
		return nouvelleListe;
	}
	
	
}
