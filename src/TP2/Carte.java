package TP2;

import enginCartes.MoteurDistanceMoyenne;
import listeChaine.Liste;

public class Carte {

	MoteurDistanceMoyenne moteurDistanceMoyenne = null;
	double score;
	Liste liste;
	
	public Carte(MoteurDistanceMoyenne moteurDistanceMoyenne) {
		
		this.moteurDistanceMoyenne = moteurDistanceMoyenne;
		liste = new Liste();
		
	}
	
	public Carte(Object moteurDistanceMoyenne, Liste section1, 
			Liste section2) 
	{
		this.moteurDistanceMoyenne = 
				(MoteurDistanceMoyenne) moteurDistanceMoyenne;
		liste = section1.fusionnerListe(section2);
	}
	
	
	public int getNbLien() {
		return liste.getNbrElements();
	}
	
	public double getScore() {
		return score;
	}
	
	public void evalueScore(boolean afficher) {
		this.score = moteurDistanceMoyenne.getDistanceMoyenne(liste, true);
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
	
	@Override
	public String toString() {
		String message = "";
		
		for(int i=0; i<liste.getNbrElements(); i++) {
			message += liste.getElement(i).toString()
			+"\n";
		}
		
		return message;
		
	}
	
	
	
	
	
	
	
}
