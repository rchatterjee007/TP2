/**
 * 
 */
package TP2.Tests;

import enginCartes.CONFIGURATION;

/**
 * @author radhikachatterjee
 *
 */
public class TestConfiguration {

	/**
	 * 
	 */
	public TestConfiguration() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CONFIGURATION conf= new CONFIGURATION();
		
		// TEST getPourcentageMutation
		System.out.println(conf.getPourcentageMutation());
		
		// TEST getPourcentageRetrait
		System.out.println(conf.getPourcentageRetrait());
				
		// TEST getMaxX
		System.out.println(conf.getMaxX());
				
		// TEST getMaxY
		System.out.println(conf.getMaxY());
				
		// TEST getPenaliteLongeur
		System.out.println(conf.getPenaliteLongeur());
				
		// TEST getPenaliteDistance
		System.out.println(conf.getPenaliteDistance());
				
		// TEST getPenaliteDeconnect
		System.out.println(conf.getPenaliteDeconnect());
				
		// TEST getNbVilles
		System.out.println(conf.getNbVilles());
				
		// TEST getNbIterations
		System.out.println(conf.getNbIterations());
		
		// TEST getNbCartesBase
		System.out.println(conf.getNbCartesBase());
				
		// TEST getNbCartesMax
		System.out.println(conf.getNbCartesMax());
		
	}

}
