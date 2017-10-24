package JaugeTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeNaturelTest {
	
	JaugeNaturel jaV;
	JaugeNaturel jaR;
	JaugeNaturel jaB1;
	
	@Before
	public void setUp() throws Exception {
		jaV = new JaugeNaturel(2, 0, 10);
		jaR = new JaugeNaturel(22, 10, 20);
		jaB1 = new JaugeNaturel(14, 20, 30);
	}


	@Test
	public void testDansIntervalle() {
		assert !jaV.estBleu() : "Ne doit pas etre bleu";
		assert jaV.estVert() : "Doit �tre vert";
		assert !jaV.estRouge() : "Ne doit pas �tre rouge";
	}

	@Test
	public void testEstRouge() {
		assert jaV.estRouge() : "Doit �tre rouge";
	}

	@Test
	public void testEstVert() {
		assert jaV.estVert() : "Doit �tre vert";
	}

	@Test
	public void testEstBleu() {
		assert jaV.estBleu() : "Doit �tre bleu";
	}

	@Test
	public void testIncrementer() {
		assert !jaV.estBleu() : "Ne doit pas etre bleu";
		assert !jaV.estVert() : "Ne doit pas �tre vert";
		assert jaV.estRouge() : "Doit �tre rouge";
	}

	@Test
	public void testDecrementer() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
