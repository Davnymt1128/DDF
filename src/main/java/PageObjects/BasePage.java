package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	
	protected WebDriver driver;
	
	// constructor to initialize driver and wait
	public BasePage(WebDriver driver)
	{
		this.driver = driver;

		
		// use driver in this class to initialize all web elements in child class
		PageFactory.initElements(driver, this);
	}
	
}
