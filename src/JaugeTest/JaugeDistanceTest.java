package JaugeTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class JaugeDistanceTest {

	@Test
	public void testEstRouge() {
		JaugeDistance jd = new JaugeDistance(0, 100, 200);
		assertTrue(jd.estRouge());
	}

	@Test
	public void testEstVert() {
		JaugeDistance jd = new JaugeDistance(0, 100, 50);
		assertTrue(jd.estVert());
	}

	@Test
	public void testEstBleu() {
		JaugeDistance jd = new JaugeDistance(0, 100, -50);
		assertTrue(jd.estBleu());
	}

	@Test
	public void testIncrementer() {
		JaugeDistance jd = new JaugeDistance(0, 100, 99);
		jd.incrementer();
		assertTrue(jd.estRouge());
	}

	@Test
	public void testDecrementer() {
		JaugeDistance jd = new JaugeDistance(0, 100, 100);
		jd.decrementer();
		assertTrue(jd.estVert());
	}

	@Test
	public void testDansIntervalle() {
		JaugeDistance jd = new JaugeDistance(-345, 67899, 100);
		assertTrue(jd.estVert());
		assertFalse(jd.estBleu());
		assertFalse(jd.estRouge());
	}
	
	@Test
	public void testDeplacement() {
		JaugeDistance jd = new JaugeDistance(0, 67899, 2);
		
		jd.decrementer();
		jd.decrementer();
		
		assertTrue(jd.estBleu());
		assertFalse(jd.estVert());
		assertFalse(jd.estRouge());
		
		jd.incrementer();
		jd.incrementer();
		
		assertTrue(jd.estVert());
		assertFalse(jd.estBleu());
		assertFalse(jd.estRouge());
	}
	
	@Test
	public void testInferieurIntervalle() {
		JaugeDistance jd1 = new JaugeDistance(10, 67899, 0);
		assertTrue(jd1.estBleu());
		assertFalse(jd1.estVert());
		assertFalse(jd1.estRouge());
		
		JaugeDistance jd2 = new JaugeDistance(0, 67899, 0);
		assertTrue(jd2.estBleu());
		assertFalse(jd2.estVert());
		assertFalse(jd2.estRouge());
		
	}
	
	@Test
	public void testLimiteVigieMaxInferieurVigieMin() {
		JaugeDistance jd = new JaugeDistance(100, 0, 50);
		assertTrue(jd.estBleu() && jd.estRouge());
		assertFalse(jd.estVert());
	}

	@Test
	public void testMaxEgaleMin() {
		JaugeDistance jd1 = new JaugeDistance(100, 100, 200);
		assertTrue(jd1.estRouge());
		assertFalse(jd1.estVert());
		assertFalse(jd1.estBleu());
		
		JaugeDistance jd2 = new JaugeDistance(100, 100, 100);
		assertTrue(jd2.estRouge());
		assertTrue(jd2.estBleu());
		assertFalse(jd2.estVert());
	}
	
	@Test
	public void testSuperieurIntervalle() {
		JaugeDistance jd1 = new JaugeDistance(100, 200, 300);
		assertTrue(jd1.estRouge());
		assertFalse(jd1.estBleu());
		assertFalse(jd1.estVert());
		
		JaugeDistance jd2 = new JaugeDistance(100, 200, 200);
		assertTrue(jd2.estRouge());
		assertFalse(jd2.estBleu());
		assertFalse(jd2.estVert());
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