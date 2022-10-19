package de.hs_mannheim.informatik.bank.domain;

import java.io.Serializable;

public class Girokonto extends Konto implements Serializable {

	public Girokonto(String inhaber) {
		super(inhaber);
	}
	
	public boolean überweise(Girokonto ziel, long betrag, String zweck) {
		if (super.getKontostand() - betrag >= 0) {
			this.auszahlen(betrag, zweck, "Überweisungsausgang", super.getInhaber());
			ziel.einzahlen(betrag, zweck, "Überweisungseingang", super.getInhaber());
			
			return true;
		}
			
		return false;
	}
	
	@Override
	public String toString() {
		return "Giro-" + super.toString();
	}

}
