package JaugeTest;

public interface Jauge {
	
	  


	 
	  public boolean estRouge();
	  
	 

	  /**
	   * L'�tat de la jauge est-il vert ?
	   *
	   * @return vrai si niveau appartient � ]vigieMin, vigieMax[.
	   *
	   */
	  public boolean estVert() ;

	 
	  public boolean estBleu();
	  public void incrementer();
	  public void decrementer() ;
	  
	 

}
