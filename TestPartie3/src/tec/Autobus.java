package tec;

import java.util.ArrayList;

import JaugeTest.JaugeNaturel;

public class Autobus implements Transport, Bus {
	
	JaugeNaturel nbPlacesAssises;
	JaugeNaturel nbPlacesDebout;	
	ArrayList<Passager> passagers;
	int arretActuel;
	
	public Autobus(int assises, int debout) {
		passagers = new ArrayList<>();
		nbPlacesAssises = new JaugeNaturel(0, assises, assises);
		nbPlacesAssises = new JaugeNaturel(0, debout, debout);
		arretActuel = 0; 
	}
	

	@Override
	public boolean aPlaceAssise() {
		return !nbPlacesAssises.estBleu();
	}

	@Override
	public boolean aPlaceDebout() {
		return !nbPlacesDebout.estBleu();
	}

	@Override
	public void demanderPlaceAssise(Passager p) {
		if(this.aPlaceAssise()) {
			p.accepterPlaceAssise();
			this.nbPlacesAssises.decrementer();
			this.passagers.add(p);
		}
	}

	@Override
	public void demanderPlaceDebout(Passager p) {
		if(this.aPlaceDebout()) {
			p.accepterPlaceDebout();
			this.nbPlacesDebout.decrementer();
			this.passagers.add(p);
		}
	}

	@Override
	public void demanderChangerEnDebout(Passager p) {
		p.accepterPlaceDebout();	
		this.nbPlacesAssises.incrementer();
		this.nbPlacesDebout.decrementer();
	}

	@Override
	public void demanderChangerEnAssis(Passager p) {
		p.accepterPlaceAssise();
		this.nbPlacesAssises.decrementer();
		this.nbPlacesDebout.incrementer();
	}

	@Override
	public void demanderSortie(Passager p) {
		if(p.estAssis()) {
			this.nbPlacesAssises.incrementer();
		}else {
			this.nbPlacesDebout.incrementer();
		}
		p.accepterSortie();	
	}

	@Override
	public void allerArretSuivant() throws UsagerInvalideException {		
		this.arretActuel++;
		System.out.println("Prochaine arret : arret n°" + this.arretActuel +"...");
		for(Passager p : this.passagers) {
			p.nouvelArret(this, this.arretActuel);
		}
	}
	
	

}
