package JaugeTest;

/**
 * Réalisation d'une Jauge avec des entiers naturels.
 * <p>
 * Un objet Jauge définit un niveau et un intervalle ouvert ]vigieMin, vigieMax[.
 * Le niveau d'une jauge n'est pas limité aux valeurs dans l'intervalle.
 * <p>
 * L'état d'une jauge correspond à la position de son niveau par rapport à
 * l'intervalle ]vigieMin, vigieMax[.
 * Une jauge définit trois etats :
 * <ul>
 * <li>vert niveau dans l'intervalle,
 * <li>rouge niveau supérieur à l'intervalle,
 * <li>bleu niveau inférieur à l'intervalle.
 * </ul>
 *
 * @author georgy
 * @since 2006-2007
 */
public class JaugeDistance implements Jauge{
  
  private long distMin;
  private long distMax;

  /**
   * Construit une instance en précisant la valeur de départ de la Jauge
   * et l'intervalle de vigie.
   *
   * @param vigieMin valeur minimale de l'intervalle de vigie.
   * @param vigieMax valeur maximale de l'intervalle de vigie.
   * @param depart   valeur initiale de la jauge. 
   */
  public JaugeDistance(long min, long max,long valeur) {
   
    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
     */
	  this.distMin=valeur - min;
	  this.distMax=valeur - max;	  
  }


  /**
   * L'état de la jauge est-il rouge ?
   *
   * @return vrai si niveau >=  vigieMax.
   *
   */
  public boolean estRouge() {
    return distMax>=0;
  }

  /**
   * L'état de la jauge est-il vert ?
   *
   * @return vrai si niveau appartient à ]vigieMin, vigieMax[.
   *
   */
  public boolean estVert() {
    
    return distMin > 0 && distMax < 0;
  }

  /**
   * L'état de la jauge est-il bleu ?
   *
   * @return vrai si niveau <= vigieMin.
   */
  public boolean estBleu() {
    return distMin <= 0;
  }

  
  
  /**
   * Incrémente le niveau d'une unité.
   * L'état peut devenir supérieur à vigieMax.
   */
  public void incrementer() {
    distMin++;
    distMax++;
    
  }

  /**
   * Décrémente le niveau d'une unité.
   * L'état peut devenir inférieur à la vigieMin.
   */
  public void decrementer() {	
	  distMin--;
	  distMax--;
  }


 

@Override
  public String toString() {
    return  " [ Distance du min : "+ distMin + ", Distance du max : " + distMax +" ]";
  }
}
