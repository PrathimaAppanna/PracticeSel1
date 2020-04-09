package com.selenium.qaClickAcademy;

import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selenium.FrameworkUtil.BaseClass;
import com.selenium.FrameworkUtil.QAClickAcademyPage;

public class QAClickAcademy extends BaseClass {

	private String radioButton1 = "radio1";
	private String radioButton2 = "radio2";
	private String radioButton3 = "radio3";
	private String radioText = "Radio Button Example";
	private String suggestionClass = "Suggession Class Example";
	private String selectCountries = "India";
	private String dropDown = "Dropdown Example";
	private String message = "Message";
	private String option1 = "Option1";
	private String option2 = "Option2";
	private String option3 = "Option3";
	private String checkboxClass = "Checkbox Example";

	private String switchClass = "Switch Window Example";
	private String openWindowLink = "openwindow";

	QAClickAcademyPage qaClickAcademyPage;

	@BeforeClass
	public void init() throws Exception {
		qaClickAcademyPage = new QAClickAcademyPage(driver);
	}

	@Test(priority=2)
	public void validateSuggestionClassExample() {

		try {

			/** Validate SuggestionClass Text **/
			waitTill(2);
			Boolean suggestionText = qaClickAcademyPage.validateText(suggestionClass);

			waitTill(2);

			Boolean countryValidation = qaClickAcademyPage.validateTextBox(selectCountries);

			waitTill(2);

		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority=0)
	public void validateRadioButtons() {

		try {

			/** Validate Radio Button Text **/
			Boolean radioButtonText = qaClickAcademyPage.validateText(radioText);

			waitTill(2);

			/** Validate Radio Buttons **/
			Boolean radio1 = qaClickAcademyPage.validateRadioButtons(radioButton1);

			waitTill(2);

			Boolean radio2 = qaClickAcademyPage.validateRadioButtons(radioButton2);

			waitTill(2);

			Boolean radio3 = qaClickAcademyPage.validateRadioButtons(radioButton3);

			waitTill(2);

		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority=3)
	public void validateDropdown() {

		SoftAssert softAssert = new SoftAssert();
		try {

			/** Validate validateDropdown Text **/
			waitTill(2);
			Boolean dropDownText = qaClickAcademyPage.validateText(dropDown);

			waitTill(2);

			Boolean OptionSelection1 = qaClickAcademyPage.validateDropdownOption(option1);

			waitTill(2);

			Boolean OptionSelection2 = qaClickAcademyPage.validateDropdownOption(option2);

			waitTill(2);

			Boolean OptionSelection3 = qaClickAcademyPage.validateDropdownOption(option3);

			waitTill(2);

		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority=4)
	public void validateCheckBoxClass() {

		try {

			/** Validate Checkbox Text **/

			waitTill(2);
			Boolean checkboxText = qaClickAcademyPage.validateText(checkboxClass);

			waitTill(2);

			Boolean checkboxValidation = qaClickAcademyPage.validateCheckBox(1);

			waitTill(8);
			Boolean checkboxValidation2 = qaClickAcademyPage.validateCheckBox(2);

			waitTill(2);
			Boolean checkboxValidation3 = qaClickAcademyPage.validateCheckBox(3);

			waitTill(2);

		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority=6)
	public void validateMouseOver() {

		try {

			waitTill(2);

			Boolean mouseOver = qaClickAcademyPage.validateMouseOver(1);

			waitTill(2);

			waitTill(2);

			mouseOver = qaClickAcademyPage.validateMouseOver(2);

			waitTill(2);

		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority=7) 
	public void validateSwitchToAlert() {

		Boolean alertMessage = qaClickAcademyPage.alert(message);

	}

	
	@Test(priority=9)
	public void validateElementDisplayExample() {

		Boolean hiddenTextbox = qaClickAcademyPage.validateElementDisplay();

	}

	@Test(priority=5) 
	public void validateOpenWindow() {  
		
		  waitTill(2);
		 
		 Boolean openWindow = qaClickAcademyPage.validateOpenWindow();

	}
		 
	
	

	@Test(priority=8)
	public void validateWebTable() { 
			 
			 
			 waitTill(2);
			 
			  Boolean webTable = qaClickAcademyPage.validateWebTab();
			  
	}	
	
	

	@Test(priority=11)
	public void validateOpenTabLink() { 
			 
			 
			 waitTill(2);
			 
			  Boolean openTab = qaClickAcademyPage.validateOpenTab();
			  
	}
	
	@Test(priority=10)
	public void validateIframe(){
		Boolean iFrameTest = qaClickAcademyPage.validateIframe();
	}

	}
	
