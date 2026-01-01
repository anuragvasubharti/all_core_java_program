package com.all.core.java.sms;

import java.util.logging.Logger;

//https://www.twilio.com/docs/sms/whatsapp/quickstart/java
//https://www.twilio.com/console
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioWhatsAppSender {

	private static final Logger logger = Logger.getLogger(TwilioWhatsAppSender.class.getName());

	// Find these in https://console.twilio.com/
	public static final String ACCOUNT_SID = "ACxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	public static final String AUTH_TOKEN = "your_auth_token_here";

	public static void main(String[] args) {
		// Initialize Twilio
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		// Send WhatsApp message
		Message message = Message.creator(new PhoneNumber("whatsapp:+919502119933"), // To
				new PhoneNumber("whatsapp:+14155238886"), // From (Twilio sandbox number)
				"Hello there").create();
		System.out.println("Message SID: " + message.getSid());
	}
}
