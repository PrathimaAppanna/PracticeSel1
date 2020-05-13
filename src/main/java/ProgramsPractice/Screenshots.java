package ProgramsPractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//ExplicitWait, Take Screenshot and Navigate Back & Forward

public class Screenshots {
	
	//private String url = "http://www.facebook.com";
	protected static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		try {
		System.out.println("Launching Chrome");
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.facebook.com");
		driver.manage().window().maximize();
		//driver.get("http://www.facebook.com");
		
		takesScreenshot("Facebook_LoginPage");
			
		}catch (Exception e) {
			
		}
	}
	
	//static method no need to create object
	public static void takesScreenshot(String fileName) throws IOException{
		
		try {
		//take screenshot and store it in a file format
		//Takescreenshot is an interface
		//We want output of type file and store it in file object
		File  fil= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy the screenshot to desired location
		//.jpg will be appeneded with the file name 
		FileUtils.copyFile(fil,new File("/PraticeSel1/src/main/java/ProgramsPractice"+fileName+".jpg"));
		}
		
		
	catch (Exception e) {
		
	}
		
		                        
	}
}

	
	

