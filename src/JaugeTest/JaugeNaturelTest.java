package JaugeTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeNaturelTest {
	
	JaugeNaturel jaV;
	JaugeNaturel jaR;
	JaugeNaturel jaB;
	
	@Before
	public void setUp() throws Exception {
		jaV = new JaugeNaturel(2, 0, 10);
		jaR = new JaugeNaturel(22, 10, 20);
		jaB = new JaugeNaturel(14, 20, 30);
	}

	

	@Test
	public void testDansIntervalle() {
		assertTrue(!jaV.estBleu());
		assertTrue(jaV.estVert());
		assertTrue(!jaV.estRouge() );
		
	}

	@Test
	public void testEstRouge() {
		assertTrue(jaR.estRouge());
	}

	@Test
	public void testEstVert() {
		assertTrue(jaV.estVert());
	}

	@Test
	public void testEstBleu() {
		assertTrue(jaB.estBleu());
	}


	@Test
	public void testDeplacement() {
		
	}

	

}
