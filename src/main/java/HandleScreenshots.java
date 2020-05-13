import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleScreenshots {

	// System.out.println("Launching Chrome");

	// driver.navigate().to("http://www.facebook.com");
	WebDriver drv;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		drv = new ChromeDriver();
		drv.get("https://google.com");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		drv.quit();
	}

	@Test
	public void test() throws IOException {
		// capture the screenshot

		TakesScreenshot scrShot = ((TakesScreenshot) drv);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		// paste the screenshot in the desired location
		FileUtils.copyFile(scrFile, new File("C:\\Screenshot\\Scr.jpg"));
	}
}
