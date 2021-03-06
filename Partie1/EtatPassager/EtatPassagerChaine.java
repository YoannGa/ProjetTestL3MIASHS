/** coucou clarisse <3
 * 
 */
package EtatPassager;

/**
 * @author clarisse.lou & Yoann GATHIGNOL
 *
 */
/**
 * Cette classe repr�sente l'�tat d'un passager dans un transport.
 * Il y a un �tat � l'exterieur du transport (dehors) et deux �tats � 
 * l'int�rieur (assis, debout).
 *  
 * Les instances de cette classe sont des objets constants.
 **/
public class EtatPassagerChaine implements IEtatPassager {

  private final String monEtat;

  /**
   * Construit une instance en pr�cisant l'�tat du passager.
   * 
   * @param e  valeur de l'�tat.
   */
  public EtatPassagerChaine(String e) {
    monEtat = e;

    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
     */
  }


  /**
   * Le passager est-il � l'ext�rieur du transport ?
   *
   * @return vrai si instanciation avec DEHORS;
   */
  public boolean estExterieur() {
	  return monEtat == "DEHORS";
  }

  /**
   * Le passager est-il assis � l'int�rieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS;
   */
  public boolean estAssis() {
    return monEtat == "ASSIS";
  }

  /**
   * Le passager est-il debout � l'int�rieur du transport ?
   *
   * @return vrai si instanciation avec DEBOUT;
   */
  public boolean estDebout() {
	  return monEtat == "DEBOUT";
  }

  /**
   * Le passager est-il a l'int�rieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS ou DEBOUT.
   */
  public boolean estInterieur() {
	  return !this.estExterieur();
  }



  /**
   * Cette m�thode est herit�e de la classe {@link java.lang.Object}.
   * Tr�s utile pour le d�bogage, elle permet de fournir une 
   * cha�ne de caract�res correspondant � l'�tat d'un objet.
   * <p> Un code par d�faut est d�finit dans 
   * {@link java.lang.Object#toString() la classe Object} 
   * Il faut adapter (red�finir) le code de cette m�thode � chaque classe.
   *
   * Pour les cha�nes de cararct�res, l'op�rateur + correspond a la concat�nation. 
   */
  @Override
  public String toString() {
    return "<" + monEtat + ">";
  }
}