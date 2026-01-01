package com.all.core.java.misc;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LinkedInOAuth2 {

	public static void main(String[] args) throws Exception {

		String body = "grant_type=authorization_code" + "&code=AUTH_CODE" + "&redirect_uri=REDIRECT_URI"
				+ "&client_id=CLIENT_ID" + "&client_secret=CLIENT_SECRET";
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.linkedin.com/oauth/v2/accessToken"))
				.POST(HttpRequest.BodyPublishers.ofString(body))
				.header("Content-Type", "application/x-www-form-urlencoded").build();
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}
}
