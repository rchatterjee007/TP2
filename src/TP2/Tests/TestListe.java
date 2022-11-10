package TP2.Tests;

import TP2.Lien;
import TP2.Ville;
import listeChaine.Liste;

/**
 * Classe qui valide les données de la class Liste
 * @author Radhika Chatterjee Simon Pitre-Lamas
 *
 */
public class TestListe {

	public static void main(String[] args) {

		Liste l = new Liste();
		Ville v = null;
		Ville vd = null;

		for(int i =0; i<20; i++) {

			v = new Ville();
			vd = new Ville();

			Lien lien = new Lien(v, vd);
			//test Insertion À la position
			l.insererALaPosition(lien, i);
		}

		v = new Ville();
		vd = new Ville();
		Lien lien = new Lien(v, vd);



		//test Insertion À la position milieu
		l.insererALaPosition(lien, 4);	
		System.out.println(l.toString());

		//test Insertion À la position debut
		l.insererALaPosition(lien, 0);	
		System.out.println(l.toString());

		//test Insertion À la position fin
		l.insererALaPosition(lien, l.getNbrElements());	
		System.out.println(l.toString());



		//TEST SUPPRIMER milieu 
		l.supprimer(1);
		System.out.println(l.toString());

		//TEST SUPPRIMER debut 
		l.supprimer(0);
		System.out.println(l.toString());

		//TEST SUPPRIMER fin 
		l.supprimer(l.getNbrElements()-1);
		System.out.println(l.toString());




		//Test fusionner liste
		System.out.println("Test fusion de liste (l2 et l3)"+"/n");

		Liste l2 = new Liste();
		Liste l3 = new Liste();

		for(int i=0; i<10; i++) {
			l2.insererALaPosition(i, i);
		}
		for(int i=0; i<4; i++) {
			l3.insererALaPosition(i, i);
		}
		System.out.println("ToString liste 2 :");
		System.out.println(l2);
		System.out.println("/n"+"ToString liste 3:");
		System.out.println(l3);

		//Test fusioner avec deux listes
		Liste lRe = l2.fusionnerListe(l3);
		System.out.println("Avec deux liste : /n" + lRe);

		//Test fusioner liste vide avec liste
		lRe = new Liste().fusionnerListe(l3);
		System.out.println("Avec liste vide et liste : /n" + lRe);

		//Test fusionner avec liste avec liste vide
		lRe = l2.fusionnerListe(new Liste());
		System.out.println("Avec liste et liste vide : /n" + lRe);
	}

}
