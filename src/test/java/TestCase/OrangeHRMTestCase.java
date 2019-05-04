package TestCase;


import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import Helper.ReadExcelData;
import PageObjects.LoginPage;
import PreTest_Prep.BaseTest;



public class OrangeHRMTestCase extends BaseTest {
	
	
	@Test(dataProvider = "testData")
	public void loginPositive(String username, String password) throws Exception
	{
		
		if(driver.getTitle().equalsIgnoreCase("OrangeHRM"))
		{
			test.log(LogStatus.PASS, "Navigated to specifed URL successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
		LoginPage login = new LoginPage(driver);
		login.login(username, password);
	}
	
	@DataProvider(name = "testData")
	public Object[][] dataFeed() throws IOException
	{
		ArrayList<String> data = ReadExcelData.getExcelData("C:\\Users\\Davny1128\\eclipse-workspace\\DataDriven_OrangeSite\\src\\main\\java\\testData\\Workbook1.xlsx"
				, "Sheet1", "testcase name", "dataprovider02");
		
		Object[][] loginData = new Object[1][2]; // size is based on test parameters
		
		loginData[0][0] = data.get(1);
		loginData[0][1] = data.get(2);
		
		return loginData;
	}

}
