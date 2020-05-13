package ProgramsPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static  WebDriver driver =null;
	
	
	public static void initialize()
	{
		if (driver ==null)
		{
			if (Constants.browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/pappanna/Downloads/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			}
			
			
		
		
		else if (Constants.browserName.equalsIgnoreCase("FF")) {
		System.setProperty("webdriver.gecko.driver", "C:/Users/pappanna/Downloads/geckodriver-v0.26.0-win64/geckodriver.exe");
		
		driver = new FireFoxDriver();

			
			
	}
	}
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().timeouts().pageloadTimeout(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(Constants.url);
	
	public static void quit(){
		System.out.println("quitting browser");
		driver.quit();
		driver=null;
		
	}
	
	
	
	
}
