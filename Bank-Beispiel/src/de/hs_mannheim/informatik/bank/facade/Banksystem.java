package de.hs_mannheim.informatik.bank.facade;

import java.util.Collection;

import de.hs_mannheim.informatik.bank.domain.Bank;
import de.hs_mannheim.informatik.bank.domain.Girokonto;
import de.hs_mannheim.informatik.bank.domain.Konto;

public class Banksystem {
	private Bank bank;
	
	public Banksystem(String bankname) {
		this.bank = new Bank(bankname);
	}
	
	public int kontoAnlegen(String name, int auswahl) {
		Konto k;
		
		if (auswahl == 1) 
			k = new Konto(name);
		else 
			k = new Girokonto(name);
		
		bank.addKonto(k);
		
//		System.out.println(k instanceof Girokonto);
		
		return k.getKontonummer();
	}
	
	public String[] getKontenliste() {
		Collection<Konto> konten = bank.getKontenliste();
		String[] liste = new String[konten.size()];
		
		int i = 0;
		for (Konto k : konten) {
			liste[i++] = k.toString(); 
		}
		
		return liste;
	}
	
	public String getBankname() {
		return bank.getName();
	}

	public long geldEinzahlen(int kontonummer, long betrag) {
		Konto konto = bank.findeKonto(kontonummer);
		konto.einzahlen(betrag, "Einzahlung am Schalter", "Einzahlung", konto.getInhaber());
	
		return konto.getKontostand();
	}
	
	public boolean geldAuszahlen(int kontonummer, long betrag) {
		Konto konto = bank.findeKonto(kontonummer);
		
		return konto.auszahlen(betrag, "Auszahlung am Schalter", "Auszahlung", konto.getInhaber());
	}

	public String[] erstelleKontoauszug(int kontonummer) {
		Konto konto = bank.findeKonto(kontonummer);
		
		return konto.getKontobewegungen();
	}

	public boolean überweisungBeauftragen(int startkonto, int zielkonto, long betrag, String verwendungszweck) {
		Konto start = bank.findeKonto(startkonto);
		Konto ziel = bank.findeKonto(zielkonto);
		
		if (start instanceof Girokonto && ziel instanceof Girokonto) {
			return ((Girokonto)start).überweise((Girokonto)ziel, betrag, verwendungszweck);
		}
			
		return false;
	}

	public long getKontostand(int kontonummer) {
		Konto konto = bank.findeKonto(kontonummer);
		
		return konto.getKontostand();
	}

}
