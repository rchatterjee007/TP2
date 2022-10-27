package TP2;

public class Liste {
	
	private class Noeud{
		
		private Object element;
		private Noeud suivant;
		
		private Noeud(Object element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
		}
	}
	
	private Noeud debut;
	private Noeud fin;
	
	//Position de la dernière opération
	private Noeud pc;
	private int nbElements;
	
	private int iterateur;
	
	public Liste() {
		initListe();
	}

	private void initListe() {
		debut = null;
		fin = null;
		pc = null;
		nbElements = 0;
		iterateur=0;
	}
	
	public void insererALaPosition(Object element, int position) {
		
		//La liste est vide
		if(nbElements == 0) {
			
			debut = new Noeud(element, null);
			fin = debut;
			pc = debut;
		}
		//La liste contient des noeuds et on ajoute au début
		else if(position == 0) {
			
			debut = new Noeud(element, this.debut);
			pc = debut;
			iterateur = 0;
			
		}
		//La liste contient des noeuds et on ajoute à la fin
		else if(position >= nbElements) {
			fin.suivant = new Noeud(element, null);
			fin = fin.suivant;
			pc = fin;
			iterateur = nbElements;
			
		}
		//La liste contient des noeuds et on ajoute ni à la fin ni au début
		else{
			deplacerPc(position);
			/*
			 * On fait une copie du pc et on remplace l'element du pc et son
			 * adresse.
			 * 
			 * 1. On crée un Noeud en lui donnant l'element du pc et l'adress 
			 * 	  du prochain noeud.
			 * 
			 *2.  On donne au pc l'adress de ce noeud et on donne l'element 
			 *	  envoyer en paramètre.
			 *    
			*/
			pc.suivant = new Noeud(this.pc.element, this.pc.suivant);
			pc.element = element;
			
			if(pc == fin) {
				fin = fin.suivant;
			}
		}
		nbElements++;
	}

	public void deplacerPc(int position) {
		if(position < iterateur) {
			Noeud tmp = debut;
			for(int i=0; i<position; i++) {
				tmp = tmp.suivant;
			}
			pc = tmp;
		}
		else {
			for(int i=iterateur; i<position; i++) {
				pc = pc.suivant;
			}
		}
		iterateur = position;
		
	}
	
	public Object getElement(int position) {
		deplacerPc(position);
		return pc.element;
	}
	
	
	public void supprimer(int position) {
		
		//Supprimer au début
		if(position == 0 || nbElements == 1) {
			supprimerDebut();
		}
		//Supprimer à la fin
		else if(position == nbElements - 1) {
			supprimerFin(position);
		} 
		//Supprimer
		else {
			supprimerMilieu(position);
		}
		nbElements--;
	}
	
	
	private void supprimerMilieu(int position) {
		
		deplacerPc(position);
		

		pc.element = pc.suivant.element;
		pc.suivant = pc.suivant.suivant;
		
		if(pc.suivant == null) {
			fin = pc;
		}
		
		
	}

	private void supprimerFin(int position) {
		
		deplacerPc(position - 1);
		fin = pc;
		pc.suivant = null;
		
		
	}

	private void supprimerDebut() {
		debut = debut.suivant;
		if(debut == null) {
			fin = null;
		}
		pc = debut;
		
	}
	

	public int getNbrElements() {
		return nbElements;
	}
	
	
	public Liste fusionnerListe(Liste liste) {
		
		Liste nouvelleListe = new Liste();
		
		for(int i=0; i<this.getNbrElements(); i++) {
			
			Object tmp = this.getElement(i);
			nouvelleListe.insererALaPosition(tmp, i);
		}
		
		for(int i=0; i<liste.getNbrElements(); i++) {
			
			Object tmp = liste.getElement(i);
			nouvelleListe.insererALaPosition(tmp, nouvelleListe.nbElements);
		}
		
		
		return nouvelleListe;
	}
	
	public Liste copie(int debut, int fin) {
		
		Liste nouvelleListe = new Liste();
		Object element;
		
		for(int i=debut; i<fin; i++) {
			element = this.getElement(i);
			
			nouvelleListe.insererALaPosition(element, i);
		}
		return nouvelleListe;
	}
	
	
	@Override
	public String toString() {
		String message = "";
		Object tmp = null;
		for(int i=0; i<nbElements; i++) {
			tmp = getElement(i);
			message += "Elements " +i+ " --->  " + tmp +"\n";
		}
		return message;
	}
}
