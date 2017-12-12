package JaugeTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class JaugeReelTest {

	@Test
	public void testEstRouge() {
		JaugeReel jn = new JaugeReel(0, 100, 100);
		assertTrue(jn.estRouge());
	}

	@Test
	public void testEstVert() {
		JaugeReel jn = new JaugeReel(0, 100, 50);
		assertTrue(jn.estVert());
	}

	@Test
	public void testEstBleu() {
		JaugeReel jn = new JaugeReel(0, 100, -50);
		assertTrue(jn.estBleu());
	}

	@Test
	public void testIncrementer() {
		JaugeReel jn = new JaugeReel(0, 100, 99);
		jn.incrementer();
		assertTrue(jn.estRouge());
	}

	@Test
	public void testDecrementer() {
		JaugeReel jn = new JaugeReel(0, 100, 100);
		jn.decrementer();
		
		assertTrue(jn.estVert());
	}

	@Test
	public void testDansIntervalle() {
		JaugeReel jn = new JaugeReel(-345, 67899, 100);
		assertTrue(jn.estVert());
		assertFalse(jn.estBleu());
		assertFalse(jn.estRouge());
	}
	
	@Test
	public void testDeplacement() {
		JaugeReel jn = new JaugeReel(0, 67899, 2);
		
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
		JaugeReel jn1 = new JaugeReel(10, 67899, 0);
		assertTrue(jn1.estBleu());
		assertFalse(jn1.estVert());
		assertFalse(jn1.estRouge());
		
		JaugeReel jn2 = new JaugeReel(0, 67899, 0);
		assertTrue(jn2.estBleu());
		assertFalse(jn2.estVert());
		assertFalse(jn2.estRouge());
		
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin() {
		JaugeReel jn = new JaugeReel(100, 0, 50);
		assertTrue(jn.estBleu() && jn.estRouge());
		assertFalse(jn.estVert());
	}

	@Test
	public void testMaxEgaleMin() {
		JaugeReel jn1 = new JaugeReel(100, 100, 200);
		assertTrue(jn1.estRouge());
		assertFalse(jn1.estVert());
		assertFalse(jn1.estBleu());
		
		JaugeReel jn2 = new JaugeReel(100, 100, 100);
		assertTrue(jn2.estRouge());
		assertTrue(jn2.estBleu());
		assertFalse(jn2.estVert());
	}
	
	@Test
	public void testSuperieurIntervalle() {
		JaugeReel jn1 = new JaugeReel(100, 200, 300);
		assertTrue(jn1.estRouge());
		assertFalse(jn1.estBleu());
		assertFalse(jn1.estVert());
		
		JaugeReel jn2 = new JaugeReel(100, 200, 200);
		assertTrue(jn2.estRouge());
		assertFalse(jn2.estBleu());
		assertFalse(jn2.estVert());
	}
	
	public void run() {
		System.out.print("Test de JaugeReel:");

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