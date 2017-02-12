/*package com.jtw.encryption;

import java.security.SecureRandom;
import java.util.Date;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class EncryptJWT {

	public static void main(String[] args) {
		// Generate random 256-bit (32-byte) shared secret
		SecureRandom random = new SecureRandom();
		byte[] sharedSecret = new byte[32];
		random.nextBytes(sharedSecret);

		// Create HMAC signer
		JWSSigner signer = new MACSigner(sharedSecret);

		// Prepare JWT with claims set
		JWTClaimsSet claimsSet = new JWTClaimsSet();
		claimsSet.setSubject("alice");
		claimsSet.setIssuer("https://c2id.com");
		claimsSet.setExpirationTime(new Date(new Date().getTime() + 60 * 1000));

		SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

		// Apply the HMAC protection
		signedJWT.sign(signer);

		// Serialize to compact form, produces something like
		// eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
		String s = signedJWT.serialize();

		// On the consumer side, parse the JWS and verify its HMAC
		signedJWT = SignedJWT.parse(s);

		JWSVerifier verifier = new MACVerifier(sharedSecret);

		assertTrue(signedJWT.verify(verifier));

		// Retrieve / verify the JWT claims according to the app requirements
		assertEquals("alice", signedJWT.getJWTClaimsSet().getSubject());
		assertEquals("https://c2id.com", signedJWT.getJWTClaimsSet().getIssuer());
		assertTrue(new Date().before(signedJWT.getJWTClaimsSet().getExpirationTime());
	}
}
*/