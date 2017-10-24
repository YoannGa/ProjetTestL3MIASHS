package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import EtatPassager.EtatPassager.Etat;

public class EtatPassagerTest {

	@Test
	public void testAssis() {
		EtatPassager e = new EtatPassager(Etat.ASSIS);
		assertFalse(e.estExterieur());
		assertTrue(e.estAssis());
		assertFalse(e.estDebout());
	}
	
	@Test
	public void testDebout() {
		EtatPassager e = new EtatPassager(Etat.DEBOUT);
		assertFalse(e.estExterieur());
		assertFalse(e.estAssis());
		assertTrue(e.estDebout());
	}
	
	@Test
	public void testExterieur() {
		EtatPassager e = new EtatPassager(Etat.DEHORS);
		assertTrue(e.estExterieur());
		assertFalse(e.estAssis());
		assertFalse(e.estDebout());
	}
	
	@Test
	public void testEstInterieur() {
		EtatPassager e1 = new EtatPassager(Etat.ASSIS);
		assertTrue(e1.estInterieur());
		
		EtatPassager e2 = new EtatPassager(Etat.DEBOUT);
		assertTrue(e2.estInterieur());
		
		EtatPassager e3 = new EtatPassager(Etat.DEHORS);
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
