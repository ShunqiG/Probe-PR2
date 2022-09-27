package de.hs_mannheim.informatik.bank.ui;

import java.util.Scanner;

import de.hs_mannheim.informatik.bank.facade.Banksystem;

public class UI {
	private Banksystem bs;
	Scanner sc = new Scanner(System.in);

	public UI(Banksystem bs) {
		this.bs = bs;
		hauptmenü();
	}

	private void hauptmenü() {
		System.out.println("Willkommen bei der " + bs.getBankname() + "!");

		mainloop: 
			while (true) {
				System.out.println();
				System.out.println("--------");
				System.out.println("Hauptmenü");
				System.out.println("1 -> Konten anzeigen");
				System.out.println("2 -> Konto anlegen");
				System.out.println("9 -> Beenden");
				System.out.println();

				System.out.print("> ");
				int input = Integer.parseInt(sc.nextLine());
				System.out.println();

				switch(input) {
					case 1: kontenAnzeigen(); break;
					case 2: kontoAnlegen(); break;
					case 9: break mainloop;
				}
			}

		System.out.println("Auf Wiedersehen!");

	} // hauptmenü

	private void kontenAnzeigen() {		
		String[] konten = bs.getKontenliste();
		if (konten.length > 0) {
			System.out.println("Folgende Konten sind aktuell verfügbar:");
			for (String s : konten) {
				System.out.println(s);
			}
		} else {
			System.out.println("Bisher keine Konten angelegt.");
		}
	}

	private void kontoAnlegen() {
		System.out.println("Bitte den Namen des Kontoinhabers angeben: ");
		String name = sc.nextLine();

		int kontonummer = bs.kontoAnlegen(name);
		System.out.println("Konto mit der Nummer " + kontonummer + " neu angelegt.");
	}

}
