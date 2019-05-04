package PreTest_Prep;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {

	protected WebDriver driver;
	protected ExtentReports report;
	protected ExtentTest test;
	
	@BeforeTest
	public void setupBrowser() throws Exception
	{
		initializeBrowser();
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");

		
		report = new ExtentReports("C:\\Users\\Davny1128\\eclipse-workspace\\DataDriven_OrangeSite\\report.html");
		test = report.startTest("loginPositive");
	}
	

	@AfterTest
	public void tearDown()
	{
		if(driver != null)
		{
			driver.close();
			driver.quit();
		}
	}
	
	
	
	
	
	
	// helper method - initialize browser
	public void initializeBrowser() throws Exception
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Davny1128\\eclipse-workspace\\DataDriven_OrangeSite\\src\\main\\java\\PreTest_Prep\\data.properties");
		prop.load(file);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Davny1128\\Documents\\Chrome Driver (Selenium)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("fireFox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
}
