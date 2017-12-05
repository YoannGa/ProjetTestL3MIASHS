package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import EtatPassager.EtatPassagerChaine.Etat;

public class EtatPassagerChaineTest {

	@Test
	public void testAssis() {
		EtatPassagerChaine e = new EtatPassagerChaine(Etat.ASSIS);
		assertFalse(e.estExterieur());
		assertTrue(e.estAssis());
		assertFalse(e.estDebout());
	}
	
	@Test
	public void testDebout() {
		EtatPassagerChaine e = new EtatPassagerChaine(Etat.DEBOUT);
		assertFalse(e.estExterieur());
		assertFalse(e.estAssis());
		assertTrue(e.estDebout());
	}
	
	@Test
	public void testExterieur() {
		EtatPassagerChaine e = new EtatPassagerChaine(Etat.DEHORS);
		assertTrue(e.estExterieur());
		assertFalse(e.estAssis());
		assertFalse(e.estDebout());
	}
	
	@Test
	public void testEstInterieur() {
		EtatPassagerChaine e1 = new EtatPassagerChaine(Etat.ASSIS);
		assertTrue(e1.estInterieur());
		
		EtatPassagerChaine e2 = new EtatPassagerChaine(Etat.DEBOUT);
		assertTrue(e2.estInterieur());
		
		EtatPassagerChaine e3 = new EtatPassagerChaine(Etat.DEHORS);
		assertFalse(e3.estInterieur());
	}
	
	  public void run() {
	     System.out.print("Test de NomClasse:");

	     System.out.print(".");
	     testAssis();

	     System.out.print(".");
	     testDebout();	     
	     
	     System.out.print(".");
	     testEstInterieur();
	     
	     System.out.print(".");
	     testExterieur();

	     System.out.println("OK");
	  }
	 
}
