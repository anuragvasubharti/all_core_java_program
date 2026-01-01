package com.all.core.java.misc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScrollByPixel {

	private WebDriver driver;

	private void setupDriver() {

		System.setProperty("webdriver.chrome.driver", "E:\\JarFile\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
	}

	private void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public void byPixel() {
		setupDriver();
		try {
			driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// Scroll down by 1000 pixels
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tearDown();
		}
	}

	public void byVisibleElement() {
		setupDriver();
		try {
			driver.get("http://demo.guru99.com/test/guru99home/");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.linkText("Linux"));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tearDown();
		}
	}

	public void byPage() {
		setupDriver();
		try {
			driver.get("http://demo.guru99.com/test/guru99home/");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tearDown();
		}
	}

	public void scrollHorizontally() {
		setupDriver();
		try {
			driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.linkText("VBScript"));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tearDown();
		}
	}

	public static void main(String[] args) {
		ScrollByPixel scroll = new ScrollByPixel();
		scroll.byPage();
		scroll.byPixel();
		scroll.byVisibleElement();
		scroll.scrollHorizontally();
		System.out.println("All scrolling actions completed.");
	}
}
