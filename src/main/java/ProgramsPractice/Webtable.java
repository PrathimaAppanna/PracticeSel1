package ProgramsPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//body//div[@id='main']//div//tr[2]//td[1]---dividing this xpath into partion --using in for loop to fetch data of each column
		
		List<WebElement> row= driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowCount=row.size();
		System.out.println("row count is   "+rowCount);
		
		String beforeXpath_company="//div[@id='main']//div//tr[";
		String afterXpath_company="]//td[1]";
		
		
		String beforeXpath_contact="//div[@id='main']//div//tr[";
		String afterXpath_contact="]//td[2]";
		
		//fetching column details
		for (int i=2; i<=rowCount; i++)
		{
			//fetching first column details
			String actualXpath=beforeXpath_company+i+afterXpath_company ;
			String companyName=driver.findElement(By.xpath(actualXpath)).getText();
			System.out.println(companyName);
			
			
			//fetching second column details
			String actualXpath_contact=beforeXpath_contact+i+afterXpath_contact;
			String contactName=driver.findElement(By.xpath(actualXpath_contact)).getText();
			System.out.println(contactName);
			
			
		
		
			
			
		
			
		}

	}

}
