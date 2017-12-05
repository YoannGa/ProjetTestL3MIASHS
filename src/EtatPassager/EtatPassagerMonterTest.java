package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import EtatPassager.EtatPassagerMonter.Etat;

public class EtatPassagerMonterTest {

	@Test
	public void testAssis() {
		EtatPassagerMonter e = new EtatPassagerMonter(Etat.ASSIS);
		assertFalse(e.estExterieur());
		assertTrue(e.estAssis());
		assertFalse(e.estDebout());
	}
	
	@Test
	public void testDebout() {
		EtatPassagerMonter e = new EtatPassagerMonter(Etat.DEBOUT);
		assertFalse(e.estExterieur());
		assertFalse(e.estAssis());
		assertTrue(e.estDebout());
	}
	
	@Test
	public void testExterieur() {
		EtatPassagerMonter e = new EtatPassagerMonter(Etat.DEHORS);
		assertTrue(e.estExterieur());
		assertFalse(e.estAssis());
		assertFalse(e.estDebout());
	}
	
	@Test
	public void testEstInterieur() {
		EtatPassagerMonter e1 = new EtatPassagerMonter(Etat.ASSIS);
		assertTrue(e1.estInterieur());
		
		EtatPassagerMonter e2 = new EtatPassagerMonter(Etat.DEBOUT);
		assertTrue(e2.estInterieur());
		
		EtatPassagerMonter e3 = new EtatPassagerMonter(Etat.DEHORS);
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
