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
	private IEtatPassager creerAssis(String e) {
		if (e == "EtatPassagerChaine") {
			return new EtatPassagerChaine("ASSIS");
		} else if (e == "EtatPassager") {
			return new EtatPassager(Etat.ASSIS);
		}
		return null;
	}
	private IEtatPassager creerDebout(String e) {
		if (e == "EtatPassagerChaine") {
			return new EtatPassagerChaine("DEBOUT");
		} else if (e == "EtatPassager") {
			return new EtatPassager(Etat.DEBOUT);
		}
		return null;
	}
	private IEtatPassager creerDehors(String e) {
		if (e == "EtatPassagerChaine") {
			return new EtatPassagerChaine("DEHORS");
		} else if (e == "EtatPassager") {
			return new EtatPassager(Etat.DEHORS);
		}
		return null;
	}
	
	@Test
	public void testAssis() {
		IEtatPassager e = creerAssis("EtatPassagerChaine");
		assertFalse(e.estExterieur());
		assertTrue(e.estAssis());
		assertFalse(e.estDebout());
	}
	
	@Test
	public void testDebout() {
		IEtatPassager e = creerDebout("EtatPassagerChaine");
		assertFalse(e.estExterieur());
		assertFalse(e.estAssis());
		assertTrue(e.estDebout());
	}
	
	@Test
	public void testExterieur() {
		IEtatPassager e = creerDehors("EtatPassager");
		assertTrue(e.estExterieur());
		assertFalse(e.estAssis());
		assertFalse(e.estDebout());
	}
	
	@Test
	public void testEstInterieur() {
		IEtatPassager e1 = creerAssis("EtatPassagerChaine");
		assertTrue(e1.estInterieur());
		
		IEtatPassager e2 = creerDebout("EtatPassagerChaine");
		assertTrue(e2.estInterieur());
		
		IEtatPassager e3 = creerDehors("EtatPassagerChaine");
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
