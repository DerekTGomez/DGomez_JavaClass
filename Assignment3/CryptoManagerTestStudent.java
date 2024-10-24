import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("ABC"));
		assertFalse(CryptoManager.isStringInBounds("~!@#$%^&*()"));
	}

	@Test
	void testCaesarEncryption() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("~", 3));
		assertEquals("BCDEFGHI", CryptoManager.caesarEncryption("ABCDEFGH", 1));
		assertEquals("@ABCDEFG", CryptoManager.caesarEncryption("ABCDEFGH", -1));
	}

	@Test
	void testBellasoEncryption() {
		assertEquals("BDFEGIHJ", CryptoManager.bellasoEncryption("ABCDEFGH", "ABC"));
		assertEquals("FGHIJKLM", CryptoManager.bellasoEncryption("ABCDEFGH", "EEEEEEEEEEEEEEEEEEEEEEEEEEEE"));
	}

	@Test
	void testCaesarDecryption() {
		assertEquals("ABCDEFGH", CryptoManager.caesarDecryption("BCDEFGHI", 1));
		assertEquals("ABCDEFGH", CryptoManager.caesarDecryption("@ABCDEFG", -1));
	}

	@Test
	void testBellasoDecryption() {
		assertEquals("ABCDEFGH", CryptoManager.bellasoDecryption("BDFEGIHJ", "ABC"));
		assertEquals("ABCDEFGH", CryptoManager.bellasoDecryption("FGHIJKLM", "EEEEEEEEEEEEEEEEEEEEEEEEEEEE"));
	}

}