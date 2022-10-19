package de.hs_mannheim.informatik.bank.infrastructure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistenz {
	private static final String BANK_DATEI = "bank.ser";
	private static final String ZÄHLER_DATEI = "zähler.ser";
	
	public static boolean sindDatenGespeichert() {
		return new File(BANK_DATEI).exists();
	}

	public static void speichereBankDaten(Object bank) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BANK_DATEI));
		oos.writeObject(bank);
		oos.close();
	}
	
	public static void speichereKontozähler(int kontozähler) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ZÄHLER_DATEI));
		oos.writeInt(kontozähler);
		oos.close();
	}
	
	public static Object ladeBankDaten() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BANK_DATEI));
		Object bank = ois.readObject();
		ois.close();
		
		return bank;
	}
	
	public static int ladeKontozähler() throws FileNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ZÄHLER_DATEI));
		int zähler = ois.readInt();
		ois.close();
		
		return zähler; 
	}

}
