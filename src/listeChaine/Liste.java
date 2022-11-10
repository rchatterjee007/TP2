package listeChaine;

/**
 * Une liste chaîné
 * @author Radhika Chatterjee Simon Pitre-Lamas
 * */
public class Liste {
	/***
	 * Sous class Noeud qui représente un elem du liste 
	 * avec sa valeur et la référence de l'elem suivant
	 * 
	 */
	private class Noeud{

		//Attributs 
		private Object element;
		private Noeud suivant;

		/***
		 * Constructeur par copie d'attributs
		 */
		private Noeud(Object element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
		}
	}


	private Noeud debut;//Elem du début
	private Noeud fin;//Dernier elem

	//Position de la dernière opération
	private Noeud pc;
	private int nbElements;//Nombre d'elem dans liste 

	private int iterateur;// Iterateur 

	/***
	 * Constructeur par défaut qui initialise une liste vide
	 */
	public Liste() {
		initListe();
	}


	/***
	 * Méthode qui initialise les attributs d'une liste vide
	 */
	private void initListe() {
		debut = null;
		fin = null;
		pc = null;
		nbElements = 0;
		iterateur=0;
	}

	/***
	 * Methode Insertion
	 * @param element Nouveau Objet à insérer dans la liste 
	 * @param position à laquelle il faut insérer l'élément
	 */
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

	/***
	 * Déplacement du position courante à une position
	 * @param position à laquelle se retrouve l'element
	 */
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

	/***
	 * Trouver l'élement de la position donné
	 * @param position ou il faut retouner l'élément
	 * @return l'élément de la position 
	 */
	public Object getElement(int position) {
		deplacerPc(position);
		return pc.element;
	}

	/***
	 * Supprimer un élément
	 * @param position à laquelle il faut supprimer l'élément 
	 */
	public void supprimer(int position) {

		//Supprimer au début
		if(position == 0) {
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

	/***
	 * Supprimer un élément
	 * @param position à laquelle il faut supprimer l'élément
	 */
	private void supprimerMilieu(int position) {
		deplacerPc(position);
		pc.element = pc.suivant.element;
		pc.suivant = pc.suivant.suivant;
		if(pc.suivant == null) {
			fin = pc;
		}
	}

	/***
	 * Supprimer un élément
	 * @param position à laquelle il faut supprimer l'élément (N/A)
	 */
	private void supprimerFin(int position) {

		deplacerPc(position - 1);
		fin = pc;
		pc.suivant = null;


	}

	/***
	 * Supprimer un élément
	 * @param position à laquelle il faut supprimer l'élément (N/A)
	 */
	private void supprimerDebut() {


		debut = debut.suivant;
		if(debut == null) {
			fin = null;
		}
		pc = debut;

	}

	/***
	 * Retourne le nombre d'éléments dans la liste 
	 * @return nombre d'éléments dans la liste 
	 */
	public int getNbrElements() {
		return nbElements;
	}

	/***
	 * Combine deux listes en une 
	 * @param liste à combiner dans la présente (this)
	 * @return la nouvelle liste avec les éléments des deux listes
	 */
	public Liste fusionnerListe(Liste liste) {

		Liste nouvelleListe = this;
		for(int i=0; i<liste.getNbrElements(); i++) {

			Object tmp = liste.getElement(i);
			nouvelleListe.insererALaPosition(tmp, nouvelleListe.nbElements);
		}


		return nouvelleListe;
	}

	/***
	 * Nouvelle liste  
	 * @param debut premier elem de la liste 
	 * @param fin dernier elem de la liste 
	 * @return une copie de la liste fournie
	 */
	public Liste copie(int debut, int fin) {

		Liste nouvelleListe = new Liste();
		Object element;
		//SI UN ELEM SEULEMENT 
		if(debut == fin) {
			element = this.getElement(debut);

			nouvelleListe.insererALaPosition(element, debut);

		}
		else {
			for(int i=debut; i<fin; i++) {
				element = this.getElement(i);

				nouvelleListe.insererALaPosition(element, i);
			}

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
