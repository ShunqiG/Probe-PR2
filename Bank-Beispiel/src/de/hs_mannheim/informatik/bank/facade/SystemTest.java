package de.hs_mannheim.informatik.bank.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class SystemTest {

	@Test
	void smokeTest() throws Exception {
		Banksystem bs = new Banksystem("Testsystem");
		
		assertNotNull(bs);
		assertEquals(0, bs.getKontenliste().length);
		assertEquals("Testsystem", bs.getBankname());
	}

}
