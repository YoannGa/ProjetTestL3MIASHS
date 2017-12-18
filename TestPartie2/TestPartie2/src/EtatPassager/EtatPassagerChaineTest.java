package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

public class EtatPassagerChaineTest {

	@Test
	public void testAssis() {
		EtatPassagerChaine e = new EtatPassagerChaine("ASSIS");
		assertFalse(e.estExterieur());
		assertTrue(e.estAssis());
		assertFalse(e.estDebout());
	}
		
	@Test
	public void testDebout() {
		EtatPassagerChaine e = new EtatPassagerChaine("DEBOUT");
		assertFalse(e.estExterieur());
		assertFalse(e.estAssis());
		assertTrue(e.estDebout());
	}
	
	@Test
	public void testExterieur() {
		EtatPassagerChaine e = new EtatPassagerChaine("DEHORS");
		assertTrue(e.estExterieur());
		assertFalse(e.estAssis());
		assertFalse(e.estDebout());
	}
	
	@Test
	public void testEstInterieur() {
		EtatPassagerChaine e1 = new EtatPassagerChaine("ASSIS");
		assertTrue(e1.estInterieur());
		
		EtatPassagerChaine e2 = new EtatPassagerChaine("DEBOUT");
		assertTrue(e2.estInterieur());
		
		EtatPassagerChaine e3 = new EtatPassagerChaine("DEHORS");
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
