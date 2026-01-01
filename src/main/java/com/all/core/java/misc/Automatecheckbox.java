package com.all.core.java.misc;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Automatecheckbox {

	private static final Logger logger = Logger.getLogger(AuthHandler.class.getName());

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\JarFile\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		WebElement male_radio_button = driver.findElement(By.xpath(".//*[@id='u_0_c']"));
		boolean status = male_radio_button.isDisplayed();
		System.out.println("Male radio button is Displayed >>" + status);
		boolean enabled_status = male_radio_button.isEnabled();
		System.out.println("Male radio button is Enabled >>" + enabled_status);
		boolean selected_status = male_radio_button.isSelected();
		System.out.println("Male radio button is Selected >>" + selected_status);
		Thread.sleep(1000);
		male_radio_button.click();
		boolean selected_status_new = male_radio_button.isSelected();
		System.out.println("Male radio button is Selected >>" + selected_status_new);
	}
}
