package ProgramsPractice;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCrmTest {
	
	
	@BeforeMethod
	public void setUp() {
	TestBase.initialize();

}

	
	@Test
	public void verifyCrmTitleTest()
	{
		
		String title=TestBase.driver.getTitle();
		System.out.println("Tiltle is "+title);
		
		Assert.assertEquals(title,Constants.loginPageTiltle);
		
		
		
		}


@AfterMethod
public  void teardown()
{
	TestBase.quit();
}
	
	



}

	
