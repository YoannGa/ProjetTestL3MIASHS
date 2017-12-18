package tec;

import EtatPassager.EtatPassager;

public class PassagerStandard implements Usager, Passager {
	private String nom;
	private EtatPassager etat;
	private int arret;
	
	public PassagerStandard(String n, int a) {
		this.nom = n;
		this.arret = a;
		this.etat = new EtatPassager(EtatPassager.Etat.DEHORS);		
	}

	@Override
	public boolean estDehors() {		
		return etat.estExterieur();
	}
	

	@Override
	public boolean estAssis() {
		return etat.estAssis();
	}

	@Override
	public boolean estDebout() {
		return etat.estDebout();
	}

	@Override
	public void accepterSortie() {
		this.etat = new EtatPassager(EtatPassager.Etat.DEHORS);		
	}

	@Override
	public void accepterPlaceAssise() {
		this.etat = new EtatPassager(EtatPassager.Etat.ASSIS);		
	}

	@Override
	public void accepterPlaceDebout() {
		this.etat = new EtatPassager(EtatPassager.Etat.DEBOUT);		
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		if(numeroArret == this.arret) {
			bus.demanderSortie(this);
			}
	}

	@Override
	public String nom() {
		return this.nom;
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		if(t instanceof Autobus) {
		
			((Autobus) t).demanderPlaceAssise(this);
			if(this.estDehors()) {
				((Autobus) t).demanderPlaceDebout(this);
			}
			if(this.estDehors()) {
				throw new UsagerInvalideException("");
			}
		}
	}
	
	@Override 
	public String toString(){
		// A FAIRE
		return null;
		
	}

}
