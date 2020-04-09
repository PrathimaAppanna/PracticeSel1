package com.selenium.FrameworkUtil;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	

	private String url = "http://www.qaclickacademy.com/practice.php";
	protected static WebDriver driver;

	@BeforeClass
	public void initilizeDriver() throws Exception {

		try {

			System.out.println("Launching Chrome");
			System.setProperty("webdriver.chrome.driver", "C:/Users/pappanna/Downloads/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		} catch (Exception e) {
		//	driver.quit();
		}

	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
	
	
	
	public void waitTill(int seconds) {
		seconds = seconds * 1000;
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
}
