package JaugeTest;


public class JaugeNaturel  implements Jauge{
  private long valeur;
  private final long min;
  private final long max;

  /**
   * Construit une instance en précisant la valeur de départ de la Jauge
   * et l'intervalle de vigie.
   *
   * @param vigieMin valeur minimale de l'intervalle de vigie.
   * @param vigieMax valeur maximale de l'intervalle de vigie.
   * @param depart   valeur initiale de la jauge. 
   */
  public JaugeNaturel(long vigieMin, long vigieMax, long depart) throws IllegalArgumentException {
	  if(vigieMin>=vigieMax) { throw new IllegalArgumentException();}
    valeur = depart;
    min = vigieMin;
    max = vigieMax;
    
  }


  public boolean estRouge() {
    return valeur >= max;
  }

  
  public boolean estVert() {
    //return !(estBleu() && estRouge());
    return valeur > min && valeur < max;
  }

  
  public boolean estBleu() {
    return valeur <= min;
  }

  
  
  
  public void incrementer() {
    valeur++;
  }

  
  public void decrementer() {	
	  valeur--;
  }

  
  @Override
  public String toString() {
    return "<" + valeur + " [" + min + "," + max + "]>";
  }
}
