package com.all.core.java.selenium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.util.TreeSet;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestingSelenium {

	private static final Logger logger = Logger.getLogger(TestingSelenium.class.getName());

	public static void main(String[] args) {
		// linkedin();
		 truecaller();
	}

	public static void linkedin() {

		System.setProperty("webdriver.chrome.driver", "E:\\JarFile\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		ChromeDriver driver = new ChromeDriver(options);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.linkedin.com/login");
			// ---------------- LOGIN ----------------
			WebElement email = driver.findElement(By.name("session_key"));
			email.sendKeys("sakshivirhajobsearch@gmail.com");
			WebElement password = driver.findElement(By.name("session_password"));
			password.sendKeys("change_password", Keys.ENTER);
			Thread.sleep(5000);
			// ---------------- MY NETWORK ----------------
			driver.findElement(By.id("mynetwork-tab-icon")).click();
			Thread.sleep(4000);
			driver.findElement(By.className("mn-community-summary__sub-section")).click();
			Thread.sleep(3000);
			// ---------------- READ FILE ----------------
			TreeSet<String> links = new TreeSet<>();
			String fileName = "D:\\workspaceKepler\\EmailReader\\src\\InputEmail1.txt";
			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
				String name;
				while ((name = br.readLine()) != null) {
					try {
						WebElement link = driver.findElement(By.linkText(name));
						links.add(link.getAttribute("href"));
						System.out.println("Saved: " + name);
					} catch (NoSuchElementException ignored) {
						System.out.println("Not found: " + name);
					}
				}
			}
			System.out.println("Collected links: " + links.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	// --------------------------------------------------------------------
	public static void truecaller() {

		System.setProperty("webdriver.chrome.driver", "E:\\JarFile\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.truecaller.com/search/in/9502119933");
			WebElement search = driver.findElement(By.name("q"));
			search.sendKeys("9502119933", Keys.ENTER);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
