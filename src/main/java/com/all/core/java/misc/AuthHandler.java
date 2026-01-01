package com.all.core.java.misc;

import java.io.Serializable;
import java.util.Scanner;
import java.util.logging.Logger;

import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

/**
 * Handles OAuth1 Access Token creation
 */
public class AuthHandler implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AuthHandler.class.getName());
	private final OAuth1AccessToken accessToken;

	public AuthHandler(OAuth10aService service) throws Exception {
		try (Scanner in = new Scanner(System.in)) {
			// Step 1: Get request token
			OAuth1RequestToken requestToken = service.getRequestToken();
			// Step 2: Ask user to authorize
			System.out.println("Authorization URL:");
			System.out.println(service.getAuthorizationUrl(requestToken));
			System.out.println("\nPaste the verifier here:");
			System.out.print(">> ");
			// Step 3: Read verifier as STRING (VERSION SAFE)
			String verifier = in.nextLine().trim();
			// Step 4: Get access token (STRING overload)
			accessToken = service.getAccessToken(requestToken, verifier);
			logger.info("OAuth1 Access Token successfully obtained.");
		}
	}

	public OAuth1AccessToken getAccessToken() {
		return accessToken;
	}
}
