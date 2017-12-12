package JaugeTest;

public interface Jauge {
	
	  


	 
	  public boolean estRouge();
	  
	 

	  /**
	   * L'état de la jauge est-il vert ?
	   *
	   * @return vrai si niveau appartient à ]vigieMin, vigieMax[.
	   *
	   */
	  public boolean estVert() ;

	 
	  public boolean estBleu();
	  public void incrementer();
	  public void decrementer() ;
	  
	 

}
