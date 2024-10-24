//32-95 chars encrypt. outside, subtract RANGE
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple o?=substitution ciphero?= where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 *
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1; //RANGE = 64

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {

		boolean checker = true;


		for (int i = 0; i < plainText.length(); i++) {

			if ( ( plainText.charAt(i) < LOWER_RANGE )  || ( plainText.charAt(i) > UPPER_RANGE )) {

				checker = false;
			}

		}

		return checker;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {

		//If the plainText is not in bounds, the method returns invalid
		boolean checker = true;
		checker = isStringInBounds(plainText);
		if (checker == false) {
			return "The selected string is not in bounds, Try again.";
		}
		
		
		// encryption string

		String encrypted = "";

		for (int i = 0; i < plainText.length(); i++) {

			//range application
			char temp = (char)(plainText.charAt(i) + key);
			while((temp > UPPER_RANGE)) {
				temp = (char)(temp - RANGE);
			}
			while((temp < LOWER_RANGE)) {
				temp = (char)(temp + RANGE);
			}
			encrypted = encrypted + "" + temp;

		}

		return encrypted;


	}

	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {


		// setting belassostr to be plaintext size or larger while looping itself


		String fullCompare = "";

		do {
			for (int k = 0; k < bellasoStr.length(); k++) {
				fullCompare = (String)(fullCompare + bellasoStr.charAt(k));
			}
		}
		while(plainText.length() > fullCompare.length());


		// encryption string

		String encrypted = "";

		for (int i = 0; i < plainText.length(); i++) {

			//range application
			char temp = (char)(plainText.charAt(i) + fullCompare.charAt(i));
			while((temp > UPPER_RANGE)) {
				temp = (char)(temp - RANGE);
			}
			while((temp < LOWER_RANGE)) {
				temp = (char)(temp + RANGE);
			}
			
			encrypted = encrypted + "" + temp;

		}

		return encrypted;

	}

	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {


		// decryption string

		String decrypted = "";

		for (int i = 0; i < encryptedText.length(); i++) {

			//range application
			char temp = (char)(encryptedText.charAt(i) - key);
			while((temp > UPPER_RANGE)) {
				temp = (char)(temp - RANGE);
			}
			while((temp < LOWER_RANGE)) {
				temp = (char)(temp + RANGE);
			}
			decrypted = decrypted + "" + temp;

		}

		return decrypted;

	}

	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {

		String fullCompare = "";

		do {
			for (int k = 0; k < bellasoStr.length(); k++) {
				fullCompare = (String)(fullCompare + bellasoStr.charAt(k));
			}
		}
		while(encryptedText.length() > fullCompare.length());

		// decryption string

		String decrypted = "";

		for (int i = 0; i < encryptedText.length(); i++) {

			//range application
			char temp = (char)(encryptedText.charAt(i) - fullCompare.charAt(i));
			while((temp > UPPER_RANGE)) {
				temp = (char)(temp - RANGE);
			}
			while((temp < LOWER_RANGE)) {
				temp = (char)(temp + RANGE);
			}
			decrypted = decrypted + "" + temp;

		}
		return decrypted;
	}
}
