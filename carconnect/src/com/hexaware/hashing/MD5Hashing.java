package com.hexaware.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class for generating MD5 hashes from strings.
 */
public class MD5Hashing {

	/**
	 * Generates an MD5 hash from the provided string.
	 * 
	 * @param password the string to hash
	 * @return the MD5 hash of the input string
	 */
	public static String doHashing(String password) {
		StringBuilder sb = null;
		try {
			// Create a MessageDigest instance for MD5
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");

			// Update the digest with the bytes from the password string
			messageDigest.update(password.getBytes());

			// Get the hash bytes
			byte[] resultByteArray = messageDigest.digest();

			// Convert the bytes to a hexadecimal string representation
			sb = new StringBuilder();
			for (byte b : resultByteArray) {
				sb.append(String.format("%02x", b));
			}
		} catch (NoSuchAlgorithmException e) {
			// Handle the case where the MD5 algorithm is not available
			e.printStackTrace();
		}

		// Return the hexadecimal string representation of the MD5 hash
		return sb.toString();
	}
}
