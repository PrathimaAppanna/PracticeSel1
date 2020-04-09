package com.selenium.FrameworkUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Cleartriptest {
	
	
	private String url = "https://www.cleartrip.com/";
	private WebDriver driver;
	
	@BeforeClass
	public void initialize() {
		try {
			
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\pappanna\\Downloads\\automation\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			WebDriverWait wait = new WebDriverWait(driver, 70);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			

		} catch (Exception e) {
		}

	}
	
	@Test
	public void launch(){
		WebDriverWait wait1;	
	//driver.findElement(By.xpath("//input[@id='OneWay']")).click();
	driver.findElement(By.xpath("//input[@id='RoundTrip']")).click();
	
	//driver.findElement(By.xpath("//input[@id='MultiCity']")).click();
	WebDriverWait wait2 = new WebDriverWait(driver, 70);
	driver.findElement(By.xpath("//input[@id='FromTag']")).click();
	 wait1 = new WebDriverWait(driver, 10);
	driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("Paris");
	
	driver.findElement(By.xpath("//input[@id='ToTag']")).click();
	driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("Zurich");
	
	driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
	SimpleDateFormat gmtDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	gmtDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
	Calendar c = Calendar.getInstance();
	c.add(Calendar.DAY_OF_MONTH, 7);
	String fromDate = gmtDateFormat.format(c.getTime());
	driver.findElement(By.xpath("//input[@id='DepartDate']")).sendKeys(fromDate);
	
	c = Calendar.getInstance();
	c.add(Calendar.DAY_OF_MONTH, 15);
	String toDate = gmtDateFormat.format(c.getTime());
	wait1 = new WebDriverWait(driver, 20);
	driver.findElement(By.xpath("//input[@id='ReturnDate']")).sendKeys(toDate);
	
	driver.findElement(By.xpath("//div[@id='MoreOptionsDiv']")).click();
	driver.findElement(By.xpath("//select[@name='adults']")).click();
	//driver.findElement(By.xpath("//input[@id='ReturnDate']")).click();
	Select select = new Select(driver.findElement(By.id("Adults")));
	select.selectByVisibleText("2");
	driver.findElement(By.xpath("//select[@name='childs']//option[@value='1']"));
	driver.findElement(By.xpath("//select[@id='Infants']//option[@value='0']"));
	
	
	
	driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
	
	driver.get("https://www.cleartrip.com/flights/international/results?from=BLR&to=ZRH&depart_date=10/03/2020&adults=1&childs=1&infants=1&class=Economy&airline=&carrier=&intl=y&sd=1582553231385&page=loaded");
	WebDriverWait wait = new WebDriverWait(driver, 70);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	List<WebElement> total_rows=driver.findElements(By.xpath("//ul[@class= 'listView flights']//li/table"));
			int totalRow = total_rows.size();
			System.out.println(totalRow);
	
	
	}

	/*public void details()
	{
		
		
	}*/
	
	/*@AfterClass
	public void quitBrowser()
	{
		
	driver.quit();
	
	}*/

}
