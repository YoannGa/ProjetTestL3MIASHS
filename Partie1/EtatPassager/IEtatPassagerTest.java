package EtatPassager;

import static org.junit.Assert.*;

import org.junit.Test;

import EtatPassager.EtatPassager.Etat;

public class IEtatPassagerTest {

	/*
	 * Prend un boolean en paramètre afin de definir quelle classe utiliser;
	 * 
	 * true = EtatPassagerchaine;
	 * false = EtatPassager;
	 */
	private IEtatPassager creerAssis(boolean e) {
		if (e) {
			return new EtatPassagerChaine("ASSIS");
		} else {
			return new EtatPassager(Etat.ASSIS);
		}
	}
	private IEtatPassager creerDebout(boolean e) {
		if (e) {
			return new EtatPassagerChaine("DEBOUT");
		} else {
			return new EtatPassager(Etat.DEBOUT);
		}
	}
	private IEtatPassager creerDehors(boolean e) {
		if (e) {
			return new EtatPassagerChaine("DEHORS");
		} else {
			return new EtatPassager(Etat.DEHORS);
		}
	}
	
	@Test
	public void testAssis() {
		IEtatPassager e = creerAssis(true);
		assertFalse(e.estExterieur());
		assertTrue(e.estAssis());
		assertFalse(e.estDebout());
	}
	
	@Test
	public void testDebout() {
		IEtatPassager e = creerDebout(true);
		assertFalse(e.estExterieur());
		assertFalse(e.estAssis());
		assertTrue(e.estDebout());
	}
	
	@Test
	public void testExterieur() {
		IEtatPassager e = creerDehors(true);
		assertTrue(e.estExterieur());
		assertFalse(e.estAssis());
		assertFalse(e.estDebout());
	}
	
	@Test
	public void testEstInterieur() {
		IEtatPassager e1 = creerAssis(true);
		assertTrue(e1.estInterieur());
		
		IEtatPassager e2 = creerDebout(true);
		assertTrue(e2.estInterieur());
		
		IEtatPassager e3 = creerDehors(true);
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
