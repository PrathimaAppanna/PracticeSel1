package com.selenium.FrameworkUtil;

import java.util.List;

import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.html.HtmlTable;

public class QAClickAcademyPage extends BaseClass {

	public QAClickAcademyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//div[@Id='radio-btn-example']//legend")
	public WebElement radioButtonExaple;

	@FindBy(xpath = "//input[@class='radioButton']")
	public List<WebElement> radioButton;

	@FindBy(xpath = "//input[@class='checkBox']")
	public List<WebElement> checkBox;

	@FindBy(xpath = "//input[@value='radio1']")
	public WebElement radioButton1;

	@FindBy(xpath = "//legend[contains(text(),'Suggession Class Example')]")
	public WebElement suggessionClassExample;

	@FindBy(xpath = "//input[@value='radio2']")
	public WebElement radioButton2;

	@FindBy(xpath = "//input[@id='autocomplete']")
	public WebElement suggestionTextbox;

	@FindBy(xpath = "//legend[contains(text(),'Switch Window Example')]")
	public WebElement switchWindow;

	public boolean validateRadioButtonText() {
		Boolean flag = false;
		if (radioButtonExaple.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public boolean validateText(String text) {
		Boolean flag = false;
		WebElement textElement = driver.findElement(By.xpath("//legend[contains(text(),'" + text + "')]"));
		if (textElement.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	public boolean validateRadioButtons(String value) {
		Boolean flag = false;
		flag = selectRadioButton(radioButton, value);

		return flag;
	}

	public boolean validateTextBox(String text) {
		Boolean flag = false;
		driver.findElement(By.xpath("//input[@id='autocomplete']")).click();
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(text);
		flag = true;

		return flag;

	}

	public boolean validateDropdownOption(String text) {
		Boolean flag = false;

		Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
		select.selectByVisibleText(text);

		// driver.findElement(By.xpath("//select[@name='dropdown-class-example']//option[@value='option1']"));
		// driver.findElemen(By.xpath("//select[@name='dropdown-class-example']/option[1]"));

		flag = true;

		return flag;

	}

	public boolean validateCheckBox(int i) {
		Boolean flag = false;

		WebElement checkbox = driver.findElement(By.xpath("//input[@id='checkBoxOption" + i + "']"));
		checkbox.click();
		System.out.println(checkbox.isSelected());
		flag = true;

		return flag;

	}

	public Boolean alert(String text) {
		Boolean flag = false;
		driver.findElement(By.xpath("//input[@id='name']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
		waitTill(2);

		driver.findElement(By.xpath("//input[@value='Alert']")).click();

		// Switching to Alert
		Alert alert = driver.switchTo().alert();
		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMessage);
		waitTill(2);

		// Accepting alert
		alert.accept();

		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		String alertMessage1 = driver.switchTo().alert().getText();
		// Displaying alert message
		System.out.println(alertMessage1);
		waitTill(2);
		alert.dismiss();
		waitTill(2);

		flag = true;

		return flag;
	}

	public Boolean selectRadioButton(List<WebElement> webelement, String value) {
		value = value.trim();
		boolean flag = false;
		if (webelement.size() > 0) {
			for (WebElement element : webelement) {
				if (element.getAttribute("value").equalsIgnoreCase(value)) {
					element.click();
					flag = true;
					break;
				}
			}
		}

		if (flag == false) {
			throw new NoSuchElementException("Cannot locate radio button:" + "'" + value + "'");
		}
		return flag;
	}

	public boolean validateOpenWindow() {
		Boolean flag = false;
		String Parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@id='openwindow']")).click();
		flag = true;

		for (String currentwindow : driver.getWindowHandles()) {
			driver.switchTo().window(currentwindow);
		}

		driver.close();

		driver.switchTo().window(Parentwindow);

		return flag;

	}

	public boolean validateMouseOver(int i) {

		Boolean flag = false;

		WebElement mouseOver = driver.findElement(By.xpath("//button[contains(text(),'Mouse Hover')]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(mouseOver);

		WebElement subMenu = driver.findElement(By.xpath("//div[@class='mouse-hover'] //a[" + i + "]"));

		actions.moveToElement(subMenu);
		actions.click().build().perform();
		String url = driver.getCurrentUrl();
		if (url.contains("top")) {
			flag = true;

		}
		if (i == 2) {
			flag = true;
		}
		waitTill(2);

		return flag;

	}

	public boolean validateOpenTab() {
		Boolean flag = false;

		// Store and Print the name of the First window on the console

		String handle = driver.getWindowHandle();
		System.out.println(handle);

		driver.findElement(By.xpath("//a[@id='opentab']")).click();
		// Store and Print the name of all the windows open
		waitTill(2);

		/*
		 * Set<String> handles = driver.getWindowHandles();
		 * 
		 * System.out.println(handles);
		 */

		// Pass a window handle to the other window

		for (String handle1 : driver.getWindowHandles()) {

			System.out.println(handle1);
			if (!handle1.equals(handle)) {
				driver.switchTo().window(handle1);
				driver.close();
			}

		}

		// Closing Pop Up window

		flag = true;

		return flag;

	}

	public boolean validateElementDisplay() {

		Boolean flag = false;

		driver.findElement(By.xpath("//input[@id='show-textbox']")).click();

		WebElement textB = driver.findElement(By.xpath("//input[@id='displayed-text']"));
		textB.click();
		driver.findElement(By.xpath("//input[@id='displayed-text']"));

		waitTill(4);

		// System.out.println(textB.isSelected());
		driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();

		waitTill(2);
		flag = true;

		return flag;

	}

	public boolean validateWebTab() {
		Boolean flag = false;

		// Grab the table
		WebElement table = driver.findElement(By.id("product"));
		int numOfRow = table.findElements(By.tagName("tr")).size();
		System.out.println("Number of rows:" + numOfRow);

		int numOfC = table.findElements(By.tagName("th")).size();
		System.out.println("Number of coloums:" + numOfC);

		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));

		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));

			// Print the contents of each cell
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
		}

		flag = true;

		return flag;

	}

	public boolean validateIframe() {
		Boolean flag = false;
		
		driver.switchTo().frame("iframe-name");		
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'youtube.com')]")));
	//	driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/t2T16A0Aueg']")).click();
		driver.switchTo().defaultContent();

//		driver.switchTo().frame("sumome-jquery-iframe");

		
		
		
		        
	driver.switchTo().defaultContent();
	
	
	
	/*
	 //Assume driver is initialized properly. 
    List<WebElement> ele = driver.findElements(By.tagName("frame"));
    System.out.println("Number of frames in a page :" + ele.size());
    for(WebElement el : ele){
      //Returns the Id of a frame.
        System.out.println("Frame Id :" + el.getAttribute("id"));
      //Returns the Name of a frame.
        System.out.println("Frame name :" + el.getAttribute("name"));
    }
		
		
		
		System.out.println(driver.findElements(By.xpath("//iframe")).size());
		
		// find all your iframes
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
		        // print your number of frames
		        System.out.println(iframes.size());


		        // you can reach each frame on your site
		        for (WebElement iframe : iframes) {

		            // switch to every frame
		            driver.switchTo().frame(iframe);

		            // now within the frame you can navigate like you are used to
		            //System.out.println(driver.findElement(By.id("homepage")).getText());
		        }
		*/
		
		waitTill(4);
		flag = true;

		return flag;

	}

}
