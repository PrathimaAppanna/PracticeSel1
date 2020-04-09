package com.selenium.FrameworkUtil;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Cleartrip {

	private String url = "https://www.cleartrip.com/";
	private WebDriver driver;

	@BeforeClass
	public void initilizeDriver() throws Exception {

		try {

			System.out.println("Launching Chrome");
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\pappanna\\Downloads\\automation\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		} catch (Exception e) {
		}

	}

	// @AfterClass
	public void quitBrowser() {
		driver.quit();
	}

	@Test
	public void bestPrice() throws ParseException {

		driver.findElement(By.xpath("//input[@id='RoundTrip']")).click();
		driver.findElement(By.xpath("//input[@id='FromTag']")).click();
		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("Bangalore");

		driver.findElement(By.xpath("//input[@id='ToTag']")).click();
		driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("Zurich");
		driver.findElement(By.xpath("//input[@id='ToTag']")).click();
		driver.findElement(By.xpath("//select[@name='childs']//option[@value='1']"));
		Select select = new Select(driver.findElement(By.id("Adults")));
		select.selectByVisibleText("1");

		// driver.findElement(By.xpath("//select[@name='childs']/option[1]"));
		// driver.findElement(By.xpath("//input[@id='Adults']/option[1]"));
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		// driver.findElement(By.xpath("//input[@id='DepartDate']")).sendKeys(java.time.LocalDate.now().plusMonths(2).toString());

		/*
		 * String pattern = "dd-MM-yyyy"; SimpleDateFormat simpleDateFormat =
		 * new SimpleDateFormat(pattern); Date date = (Date)
		 * simpleDateFormat.parse("09-11-2018"); System.out.println(date);
		 */

		SimpleDateFormat gmtDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		gmtDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 7);
		String fromDate = gmtDateFormat.format(c.getTime());
		driver.findElement(By.xpath("//input[@id='DepartDate']")).sendKeys(fromDate);

		c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 15);
		String toDate = gmtDateFormat.format(c.getTime());
		driver.findElement(By.xpath("//input[@id='ReturnDate']")).sendKeys(toDate);

		driver.findElement(By.xpath("//div[@id='MoreOptionsDiv']")).click();
		

		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		
		assertTrue(driver.findElement(By.xpath("")).isDisplayed());
		List<WebElement> flights = driver.findElements(By.xpath("//table[contains(@class,'flightDetailsLink')] //th[1]"));
		flights.size();
		//row count
		
		//assertEquals(actual, "");
		
		

	}

}
