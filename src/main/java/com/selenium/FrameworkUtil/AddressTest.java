package com.selenium.FrameworkUtil;
import org.testng.annotations.*;

import com.jayway.restassured.response.Response;

public class AddressTest {
	
	FunctionHelper functionHelper;
	
	

  @BeforeClass
  public void init()
  {
	  functionHelper = new FunctionHelper("https://rahulshettyacademy.com");
  }
	
  @Test
  public void test()
  {
	  try {
		Response response = functionHelper.createAddress();
		response.prettyPrint();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
  }
  


	

}
