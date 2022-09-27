package de.hs_mannheim.informatik.bank.domain;

public class Konto {
	private static int kontozähler = 0;
	
	private int nummer;
	private long stand = 0;
	private String inhaber;

	public Konto(String inhaber) {
		nummer = 1000 + kontozähler++;
		this.inhaber = inhaber;
	}
	
	public int getKontonummer() {
		return nummer;
	}

	@Override
	public String toString() {
		return "Konto [nummer=" + nummer + ", inhaber=" + inhaber + "]";
	}
	
}
