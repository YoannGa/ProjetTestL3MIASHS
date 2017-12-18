package JaugeTest;


public class JaugeReel implements Jauge{
  private float valeur;
  
  
  
 

private final float min;
  private final float max;

  
  public JaugeReel(long vigieMin, long vigieMax, long depart) throws IllegalArgumentException {
	  if(vigieMin>=vigieMax) { throw new IllegalArgumentException();}
	  valeur = (float)depart/1000;
	  min =  (float)vigieMin/1000;
	  max =  (float)vigieMax/1000;
    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
     */
  }


  public boolean estRouge() {
    return valeur >= max;
  }

  public boolean estVert() {
    return valeur < max && valeur > min;
   
  }

  
  public boolean estBleu() {
    return valeur <= min;
  }

  
  
  
  public void incrementer() {
    valeur= (float)valeur + (float)0.001;
  }

  
  public void decrementer() {	
	  valeur= (float)valeur-(float)0.001;
  }


  
  @Override
  public String toString() {
    return "<" + valeur + " [" + min + "," + max + "]>";
  }
}
