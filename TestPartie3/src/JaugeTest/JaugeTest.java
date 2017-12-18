package JaugeTest;
import java.util.Scanner;
import static org.junit.Assert.*;

import org.junit.Test;

public class JaugeTest {
	
	Scanner a = new Scanner(System.in);
	String typeATester;
	
	
	public Jauge creerJauge(String typeJauge, long min, long max, long val) {
			Jauge j;
			
			
			if(typeJauge.equals("JaugeDistance")){
				j = new JaugeDistance(min, max, val);				
				return j;
			}else if(typeJauge.equals("JaugeNaturel")){
				j = new JaugeNaturel(min, max, val);
				return j;				
			}else if(typeJauge.equals("JaugeNegatif")){
				j = new JaugeNegatif(min, max, val);				
				return j;
			}else if(typeJauge.equals("JaugeReel")){
				j = new JaugeReel(min, max, val);
				return j;	
			}
			
			return null;
	}
	
	//Creation d'un certain type de jauge
	
	
	

	@Test
	public void testEstRouge() {
		for(TypesJauge type : TypesJauge.values()){
			Jauge j = creerJauge(type.toString(), 0, 100, 100);
			assertTrue(j.estRouge());
		}
	}

	@Test
	public void testEstVert() {	
		for(TypesJauge type : TypesJauge.values()){
			Jauge j = creerJauge(type.toString(), 0, 100, 50);
			assertTrue(j.estVert());
		}
	}

	@Test
	public void testEstBleu() {	
		for(TypesJauge type : TypesJauge.values()){
			Jauge j = creerJauge(type.toString(), 0, 100, -50);
			assertTrue(j.estBleu());
		}
	}

	@Test
	public void testIncrementer() {	
		for(TypesJauge type : TypesJauge.values()){
			Jauge j = creerJauge(type.toString(), 0, 100, 99);
			j.incrementer();
			assertTrue(j.estRouge());
		}
	}

	@Test
	public void testDecrementer() {	
		for(TypesJauge type : TypesJauge.values()){
			Jauge j = creerJauge(type.toString(), 0, 100, 100);
			j.decrementer();
			assertTrue(j.estVert());
		}
	}

	@Test
	public void testDansIntervalle() {
		for(TypesJauge type : TypesJauge.values()){
			Jauge j = creerJauge(type.toString(), -345, 67899, 100);
			assertTrue(j.estVert());
			assertFalse(j.estBleu());
			assertFalse(j.estRouge());
		}
	}
	
	@Test
	public void testDeplacement() {	
		for(TypesJauge type : TypesJauge.values()){
			Jauge j = creerJauge(type.toString(), 0, 67899, 2);
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
	}
	
	@Test
	public void testInferieurIntervalle() {
		for(TypesJauge type : TypesJauge.values()){
			Jauge j = creerJauge(type.toString(), 10, 67899, 0);		
			assertTrue(j.estBleu());
			assertFalse(j.estVert());
			assertFalse(j.estRouge());
		
			Jauge j2 = creerJauge(type.toString(), 0, 67899, 0);
			assertTrue(j2.estBleu());
			assertFalse(j2.estVert());
			assertFalse(j2.estRouge());
		}
	}
	
	/* TESTS DE LA PREMIERE PARTIE
	@Test
	public void testLimiteVigieMaxInferieurVigieMin() {
		for(TypesJauge type : TypesJauge.values()){
			Jauge j = creerJauge(type.toString(), 100, 0, 50);
			assertTrue(j.estBleu() && j.estRouge());
			assertFalse(j.estVert());
		}
	}
	
	

	@Test
	public void testMaxEgaleMin() {
		for(TypesJauge type : TypesJauge.values()){
			Jauge j = creerJauge(type.toString(), 100, 100, 200);
			assertTrue(j.estRouge());
			assertFalse(j.estVert());
			assertFalse(j.estBleu());
		
			Jauge j2 = creerJauge(type.toString(), 100, 100, 100);
			assertTrue(j2 .estRouge());
			assertTrue(j2.estBleu());
			assertFalse(j2.estVert());
		}
	}
	
	*/
	@Test
	public void testCreationNonValide ( ) {
		for(TypesJauge type : TypesJauge.values()){
		
			try {
				Jauge inverse = creerJauge (type.toString(), 78 , 13 , 0 ) ;
				assert false : "erreur exception non levée sur le constructeur de la classe " + type.toString() + " quand min > max";
			}catch(IllegalArgumentException e) {}// Exception levée comme prévu :)
							
			try {			
				Jauge egale = creerJauge(type.toString(), -45 , -45, -45);
				assert false : "ERREUR : exception non levée sur le constructeur de la classe " + type.toString()+ "quand min == max ";
			}catch(IllegalArgumentException e) {}// Exception levée comme prévu :) 			
		}
	}
	
	
	@Test
	public void testExceptionControlee ( ) throws ClassNotFoundException {
		// throw new ClassNotFoundException( " Attention " ) ;
		
		
		}


	
	@Test
	public void testSuperieurIntervalle() {
		for(TypesJauge type : TypesJauge.values()){
			Jauge j = creerJauge(type.toString(), 100, 200, 300);
			assertTrue(j.estRouge());
			assertFalse(j.estBleu());
			assertFalse(j.estVert());
		
			Jauge j2 = creerJauge(type.toString(), 100, 200, 200);
			assertTrue(j2.estRouge());
			assertFalse(j2.estBleu());
			assertFalse(j2.estVert());
		}
	}
	
	public void run() {
		System.out.print("Test de Jauge");
		
		System.out.print("Choisir un type de Jauge à tester : ");
		typeATester = a.next();
		
		System.out.print(".");
		testDansIntervalle();
		
		System.out.print(".");
		testDeplacement();

		System.out.print(".");
		testInferieurIntervalle();
		
		System.out.print(".");
		//testLimiteVigieMaxInferieurVigieMin();

		System.out.print(".");
		//testMaxEgaleMin();

		System.out.print(".");
		testSuperieurIntervalle();
		
		testCreationNonValide();
		
		try {
			testExceptionControlee();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("OK");
	}

}