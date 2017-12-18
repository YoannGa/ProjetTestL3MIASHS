package JaugeTest;


public class JaugeNegatif  implements Jauge{
  private long valeur;
  private final long min;
  private final long max;

  
  public JaugeNegatif(long vigieMin, long vigieMax, long depart) throws IllegalArgumentException{
	  if(vigieMin>=vigieMax) { throw new IllegalArgumentException();}
	  valeur = -depart;
	  min = -vigieMin;
	  max = -vigieMax;
    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
     */
  }


  
  public boolean estRouge() {
    return valeur <= max;
  }

 
  public boolean estVert() {
    //return !(estBleu() && estRouge());
    return valeur < min && valeur > max;
  }

 
  public boolean estBleu() {
    return valeur >= min;
  }

  
  
  
  public void incrementer() {
    valeur--;
  }

  
  public void decrementer() {	
	  valeur++;
  }


  
  @Override
  public String toString() {
    return "<" + valeur + " [" + min + "," + max + "]>";
  }
}
