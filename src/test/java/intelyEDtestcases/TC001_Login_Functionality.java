package intelyEDtestcases;


import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;
import pages.DashboardPage;
import pages.HomePage;
import pages.IntelyChargePage;
import pages.LoginPage;
import utils.ExcelDataDrivenTest;


public class TC001_Login_Functionality extends TestBase {

	@Test
	public void TC001_Login_with_Valid_Credentials() throws Throwable {
		
		ArrayList<String> TestcaseName;
		ExcelDataDrivenTest d = new ExcelDataDrivenTest();
		TestcaseName =d.getData("TC001_Login_with_Valid_Credentials");
        LoginPage pglogin = new LoginPage(driver);
		
		//Step1 Login to the website
        HomePage pgHomePage = pglogin.intelyEDLogin(TestcaseName.get(1), TestcaseName.get(2));
		try {
			Assert.assertNotNull(pgHomePage);
			reporting("Login Validation", "User should able to login", TestcaseName.get(1) + " ", "Pass");
			
		}catch(Throwable e) {
			reporting("Login Validation", "User should log in", "Login Failed with user" + TestcaseName.get(1), "Fail");
			throw new AssertionError("Login Validation failure error message", e);
		}
	

	}	
		
}
