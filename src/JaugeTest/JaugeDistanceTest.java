package JaugeTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class JaugeDistanceTest {

	@Test
	public void testEstRouge() {
		JaugeDistance jn = new JaugeDistance(100, 200);
		assertTrue(jn.estRouge());
	}

	@Test
	public void testEstVert() {
		JaugeDistance jn = new JaugeDistance(100, 50);
		assertTrue(jn.estVert());
	}

	@Test
	public void testEstBleu() {
		JaugeDistance jn = new JaugeDistance(100, -50);
		assertTrue(jn.estBleu());
	}

	@Test
	public void testIncrementer() {
		JaugeDistance jn = new JaugeDistance(100, 99);
		jn.incrementer();
		assertTrue(jn.estRouge());
	}

	@Test
	public void testDecrementer() {
		JaugeDistance jn = new JaugeDistance(100, 100);
		jn.decrementer();
		assertTrue(jn.estVert());
	}

	@Test
	public void testDansIntervalle() {
		JaugeDistance jn = new JaugeDistance(67899, 100);
		assertTrue(jn.estVert());
		assertFalse(jn.estBleu());
		assertFalse(jn.estRouge());
	}
	
	@Test
	public void testDeplacement() {
		JaugeDistance jn = new JaugeDistance(67899, 2);
		
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
		JaugeDistance jn1 = new JaugeDistance(67899, 0);
		assertTrue(jn1.estBleu());
		assertFalse(jn1.estVert());
		assertFalse(jn1.estRouge());
		
		JaugeDistance jn2 = new JaugeDistance(67899, 0);
		assertTrue(jn2.estBleu());
		assertFalse(jn2.estVert());
		assertFalse(jn2.estRouge());
		
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin() {
		JaugeDistance jn = new JaugeDistance(0, 50);
		assertTrue(jn.estBleu() && jn.estRouge());
		assertFalse(jn.estVert());
	}

	@Test
	public void testMaxEgaleMin() {
		JaugeDistance jn1 = new JaugeDistance(100, 200);
		assertTrue(jn1.estRouge());
		assertFalse(jn1.estVert());
		assertFalse(jn1.estBleu());
		
		JaugeDistance jn2 = new JaugeDistance(100, 100);
		assertTrue(jn2.estRouge());
		assertTrue(jn2.estBleu());
		assertFalse(jn2.estVert());
	}
	
	@Test
	public void testSuperieurIntervalle() {
		JaugeDistance jn1 = new JaugeDistance(200, 300);
		assertTrue(jn1.estRouge());
		assertFalse(jn1.estBleu());
		assertFalse(jn1.estVert());
		
		JaugeDistance jn2 = new JaugeDistance(200, 200);
		assertTrue(jn2.estRouge());
		assertFalse(jn2.estBleu());
		assertFalse(jn2.estVert());
	}
	
	public void run() {
		System.out.print("Test de JaugeDistance:");

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