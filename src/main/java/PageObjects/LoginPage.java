package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

	
	// page objects
	@FindBy(how = How.ID, using = "txtUsername")
	private WebElement usernameLocator;
	
	@FindBy(how = How.ID, using = "txtPassword")
	private WebElement passwordLocator;
	
	@FindBy(how = How.NAME, using = "Submit")
	private WebElement submitBtnLocator;
	
	
	
	
	// constructor - call "driver" from parent class - BasePage
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	// logIn method
	public void login(String username, String password) throws Exception
	{
		try {
				usernameLocator.clear();
				usernameLocator.sendKeys(username);
				passwordLocator.clear();
				passwordLocator.sendKeys(password);
				submitBtnLocator.click();
			
		} catch (Exception e) {
			 throw e;
		}
	}
	
}
