package de.hs_mannheim.informatik.bank.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class Bank implements Serializable {
	private String name;
	private HashMap<Integer, Konto> konten = new HashMap<>();
	
	public Bank(String name) {
		this.name = name;
	}
	
	public void addKonto(Konto k) {
		konten.put(k.getKontonummer(), k);
	}
	
	public String getName() {
		return name;
	}
	
	public Collection<Konto> getKontenliste() {
		return konten.values();
	}

	public Konto findeKonto(int kontonummer) {
		return konten.get(kontonummer);
	}
	
}
