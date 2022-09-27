package de.hs_mannheim.informatik.bank.facade;

import java.util.Collection;

import de.hs_mannheim.informatik.bank.domain.Bank;
import de.hs_mannheim.informatik.bank.domain.Konto;

public class Banksystem {
	private Bank bank;
	
	public Banksystem(String bankname) {
		this.bank = new Bank(bankname);
	}
	
	public int kontoAnlegen(String name) {
		Konto k = new Konto(name);
		bank.addKonto(k);
		
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
}
