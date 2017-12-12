package JaugeTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class JaugeTest {
	
	Jauge j,j2;
	
	public void creerJauge() {
		
	}
	
	//Creation d'un certain type de jauge
	
	
	

	@Test
	public void testEstRouge() {		
		assertTrue(j.estRouge());
	}

	@Test
	public void testEstVert() {		
		assertTrue(j.estVert());
	}

	@Test
	public void testEstBleu() {		
		assertTrue(j.estBleu());
	}

	@Test
	public void testIncrementer() {		
		j.incrementer();
		assertTrue(j.estRouge());
	}

	@Test
	public void testDecrementer() {		
		j.decrementer();
		assertTrue(j.estVert());
	}

	@Test
	public void testDansIntervalle() {		
		assertTrue(j.estVert());
		assertFalse(j.estBleu());
		assertFalse(j.estRouge());
	}
	
	@Test
	public void testDeplacement() {		
		j.decrementer();
		j.decrementer();
		
		assertTrue(j.estBleu());
		assertFalse(j.estVert());
		assertFalse(j.estRouge());
		
		j.incrementer();
		j.incrementer();
		
		assertTrue(j.estVert());
		assertFalse(j.estBleu());
		assertFalse(j.estRouge());
	}
	
	@Test
	public void testInferieurIntervalle() {
		
		assertTrue(j.estBleu());
		assertFalse(j.estVert());
		assertFalse(j.estRouge());
		
		
		assertTrue(j2.estBleu());
		assertFalse(j2.estVert());
		assertFalse(j2.estRouge());
		
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin() {
		
		assertTrue(j.estBleu() && j.estRouge());
		assertFalse(j.estVert());
	}

	@Test
	public void testMaxEgaleMin() {
		
		assertTrue(j.estRouge());
		assertFalse(j.estVert());
		assertFalse(j.estBleu());
		
	
		assertTrue(j2 .estRouge());
		assertTrue(j2.estBleu());
		assertFalse(j2.estVert());
	}
	
	@Test
	public void testSuperieurIntervalle() {
		
		assertTrue(j.estRouge());
		assertFalse(j.estBleu());
		assertFalse(j.estVert());
		
	
		assertTrue(j2.estRouge());
		assertFalse(j2.estBleu());
		assertFalse(j2.estVert());
	}
	
	public void run() {
		System.out.print("Test de Jauge");

		System.out.print(".");
		testDansIntervalle();
		
		System.out.print(".");
		testDeplacement();

		System.out.print(".");
		testInferieurIntervalle();
		
		System.out.print(".");
		testLimiteVigieMaxInferieurVigieMin();

		System.out.print(".");
		testMaxEgaleMin();

		System.out.print(".");
		testSuperieurIntervalle();

		System.out.println("OK");
	}

}