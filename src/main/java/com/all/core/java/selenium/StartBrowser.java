package com.all.core.java.selenium;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.all.core.java.misc.GenerateRandomNumber;

public class StartBrowser {

	private static final Logger logger = Logger.getLogger(StartBrowser.class.getName());

	public static void main(String args[]) {
		checkTureCaller();
	}

	public static void checkTureCaller() {

		int count = 0;
		List<String> strNumber = GenerateRandomNumber.generatedNumber();
		Collections.sort(strNumber);
		System.out.println("strNumber " + strNumber.size());

		for (String strNum : strNumber) {
			// for(int j = 0; j < strNumber.size(); j++){
			String number = strNum.toString().trim();
			String url = "https://www.truecaller.com/search/in/" + number;
			// String url =
			// "C:/Users/Anurag/Downloads/fwform16andsalarycertificateforthefy201718/Infosys_F16_00687656_2017.PDF";

			System.out.println("url " + url);
			String os = System.getProperty("os.name").toLowerCase();
			Runtime rt = Runtime.getRuntime();
			try {
				if (os.indexOf("win") >= 0) {
					// this doesn't support showing urls in the form of
					// "page.html#nameLink"
					rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
					// HTMLParser.HTMLParser(url);
					count++;
					if (count == 1)
						break;
				} /*
					 * else if (os.indexOf("mac") >= 0) { //For other OS rt.exec("open " + url); }
					 * else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) { // Do a best
					 * guess on unix until we get a platform // independent way // Build a list of
					 * browsers to try, in this order. String[] browsers = { "epiphany", "firefox",
					 * "mozilla", "konqueror", "netscape", "opera", "links", "lynx" }; // Build a
					 * command string which looks like "browser1 "url" || browser2 "url" ||..."
					 * StringBuffer cmd = new StringBuffer(); for (int i = 0; i < browsers.length;
					 * i++) cmd.append((i == 0 ? "" : " || ") + browsers[i] + " \"" + url + "\" ");
					 * rt.exec(new String[] { "sh", "-c", cmd.toString() }); } else { return; }
					 */
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			// return;
		}
	}
}
