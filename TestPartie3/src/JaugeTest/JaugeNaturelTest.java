package JaugeTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class JaugeNaturelTest {

	@Test
	public void testEstRouge() {
		JaugeNaturel jn = new JaugeNaturel(0, 100, 200);
		assertTrue(jn.estRouge());
	}

	@Test
	public void testEstVert() {
		JaugeNaturel jn = new JaugeNaturel(0, 100, 50);
		assertTrue(jn.estVert());
	}

	@Test
	public void testEstBleu() {
		JaugeNaturel jn = new JaugeNaturel(0, 100, -50);
		assertTrue(jn.estBleu());
	}

	@Test
	public void testIncrementer() {
		JaugeNaturel jn = new JaugeNaturel(0, 100, 99);
		jn.incrementer();
		assertTrue(jn.estRouge());
	}

	@Test
	public void testDecrementer() {
		JaugeNaturel jn = new JaugeNaturel(0, 100, 100);
		jn.decrementer();
		assertTrue(jn.estVert());
	}

	@Test
	public void testDansIntervalle() {
		JaugeNaturel jn = new JaugeNaturel(-345, 67899, 100);
		assertTrue(jn.estVert());
		assertFalse(jn.estBleu());
		assertFalse(jn.estRouge());
	}
	
	@Test
	public void testDeplacement() {
		JaugeNaturel jn = new JaugeNaturel(0, 67899, 2);
		
		jn.decrementer();
		jn.decrementer();
		
		assertTrue(jn.estBleu());
		assertFalse(jn.estVert());
		assertFalse(jn.estRouge());
		
		jn.incrementer();
		jn.incrementer();
		
		assertTrue(jn.estVert());
		assertFalse(jn.estBleu());
		assertFalse(jn.estRouge());
	}
	
	@Test
	public void testInferieurIntervalle() {
		JaugeNaturel jn1 = new JaugeNaturel(10, 67899, 0);
		assertTrue(jn1.estBleu());
		assertFalse(jn1.estVert());
		assertFalse(jn1.estRouge());
		
		JaugeNaturel jn2 = new JaugeNaturel(0, 67899, 0);
		assertTrue(jn2.estBleu());
		assertFalse(jn2.estVert());
		assertFalse(jn2.estRouge());
		
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin() {
		JaugeNaturel jn = new JaugeNaturel(100, 0, 50);
		assertTrue(jn.estBleu() && jn.estRouge());
		assertFalse(jn.estVert());
	}

	@Test
	public void testMaxEgaleMin() {
		JaugeNaturel jn1 = new JaugeNaturel(100, 100, 200);
		assertTrue(jn1.estRouge());
		assertFalse(jn1.estVert());
		assertFalse(jn1.estBleu());
		
		JaugeNaturel jn2 = new JaugeNaturel(100, 100, 100);
		assertTrue(jn2.estRouge());
		assertTrue(jn2.estBleu());
		assertFalse(jn2.estVert());
	}
	
	@Test
	public void testSuperieurIntervalle() {
		JaugeNaturel jn1 = new JaugeNaturel(100, 200, 300);
		assertTrue(jn1.estRouge());
		assertFalse(jn1.estBleu());
		assertFalse(jn1.estVert());
		
		JaugeNaturel jn2 = new JaugeNaturel(100, 200, 200);
		assertTrue(jn2.estRouge());
		assertFalse(jn2.estBleu());
		assertFalse(jn2.estVert());
	}
	
	public void run() {
		System.out.print("Test de JaugeNaturel:");

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