package ProgramsPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//isDisplayed(),isEnabled(),

public class CheckElementPresent {

	private static final int NULL = 0;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// To check Element Present:
		//!=Null we can use

		driver.get("https://www.cleartrip.com/");

		if (driver.findElements(By.xpath("//input[@id='SearchBtn']")).size() != 0) {
			System.out.println("element is present");
		} else
			System.out.println("element is absent");
		
		
		if (driver.findElements(By.xpath("//input[@id='SearchBtn']")).size() != NULL) {
			System.out.println("element is present");
		} else
			System.out.println("element is absent");
		
		//To check element Visible
		//isDisplayed
		//These web elements can be buttons, drop boxes, checkboxes, radio buttons, labels etc.
		
		/*if(driver.findElement(By.cssSelector(selector)).isDisplayed())
		{
			System.out.println("element is visible");
		} else
			System.out.println("element is invisible");*/
		
		
		if (driver.findElement(By.xpath("//input[@id='SearchBtn']")).isDisplayed()) {
			System.out.println("element is visible");
		} else
			System.out.println("element is invisible");
		
		if (driver.findElement(By.xpath("//input[@id='SearchBtn']")).isEnabled()) {
			System.out.println("oneway is enabled");
		} else
			System.out.println("oneway is not enabled");
	
		
		
		if (driver.findElement(By.xpath("//input[@id='OneWay']")).isSelected()) {
			System.out.println("oneway is selected");
		} else
			System.out.println("oneway is not selected");
		
		
		//To check text present
		
		if(driver.getPageSource().contains("Search flights")){
			System.out.println("Text is present");
			}else{
			System.out.println("Text is absent");
			}

	}

}


