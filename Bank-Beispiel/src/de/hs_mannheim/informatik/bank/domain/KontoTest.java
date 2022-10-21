package de.hs_mannheim.informatik.bank.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KontoTest {

	@Test
	void testKontoBasics() {
		Konto k = new Konto("Müller", 0);
		assertEquals("Müller", k.getInhaber());
		assertEquals(1000, k.getKontonummer());
		assertEquals(0, k.getKontostand());	
	}
	
	@Test
	void testKontoEinUndAuszahlung() {
		Konto k = new Konto("Müller", 0);
		Konto k2 = new Konto("Mayer", 1);
		
		assertEquals("Mayer", k2.getInhaber());
		assertNotEquals(k.getKontonummer(), k2.getKontonummer());
		
		k2.einzahlen(100, "Test", "Einzahlung", "JUnit");
		assertEquals(100, k2.getKontostand());
		
		assertTrue(k2.auszahlen(50, "Test", "Auszahlung", "JUnit"));
		assertEquals(50, k2.getKontostand());

		assertFalse(k2.auszahlen(500, "Test", "Auszahlung", "JUnit"));
		assertEquals(50, k2.getKontostand());
	}

}
