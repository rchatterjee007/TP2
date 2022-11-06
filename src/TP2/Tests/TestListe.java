package TP2.Tests;

import TP2.Lien;
import TP2.Ville;
import listeChaine.Liste;

public class TestListe {
	
	public static void main(String[] args) {
		
		Liste l = new Liste();
		Ville v = null;
		Ville vd = null;
		
		for(int i =0; i<20; i++) {
			
			v = new Ville();
			vd = new Ville();
			
			Lien lien = new Lien(v, vd);
			
			l.insererALaPosition(lien, i);
		}
		
		v = new Ville();
		vd = new Ville();
		Lien lien = new Lien(v, vd);
		
		l.insererALaPosition(lien, 4);
		
		System.out.println(l.toString());
		
		l.supprimer(1);
		
		System.out.println(l.toString());
		
		l.supprimer(19);
		
		System.out.println(l.toString());
		
		l.supprimer(6);
		
		System.out.println(l.toString());
	}

}
