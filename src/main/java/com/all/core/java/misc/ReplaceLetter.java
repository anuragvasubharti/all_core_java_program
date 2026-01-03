package com.all.core.java.misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReplaceLetter {

	public static void main(String[] args) {

		Random random = new Random();
		String base = "@";
		Set<String> patterns = new TreeSet<>();
		// ------------------ GENERATE PATTERNS ------------------
		for (int i = 0; i < 10000; i++) {
			int index = random.nextInt(base.length());
			String temp = base.replace(base.charAt(index), '_').replace("@", "E");
			patterns.add(temp);
		}
		// ------------------ WRITE TO FILE ------------------
		String outputFile = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\Replaceletter.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
			for (String s : patterns) {
				writer.write(s);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		// ------------------ READ + SELENIUM ------------------
		String inputFile = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\ReadLetter.txt";
		System.setProperty("webdriver.chrome.driver", "E:\\JarFile\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		ChromeDriver driver = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.google.com");
			String line;
			int count = 0;
			while ((line = reader.readLine()) != null) {
				count++;
				WebElement searchBox = driver.findElement(By.name("q"));
				searchBox.clear();
				searchBox.sendKeys(line.replace("_", "") + " Meaning in Hindi");
				searchBox.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
			}
			System.out.println("Processed count: " + count);
		} catch (WebDriverException wde) {
			wde.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit(); // ✅ REQUIRED
			}
		}
		System.out.println("Done.");
	}
}
