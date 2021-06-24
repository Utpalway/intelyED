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


public class TC005_Failed_Login_Functionalities_Invalid_Username extends TestBase {

	@Test
	public void TC005_Login_With_Invalid_Username() throws Throwable {
		
		ArrayList<String> TestcaseName;
		ExcelDataDrivenTest d = new ExcelDataDrivenTest();
		TestcaseName =d.getData("TC005_Login_With_Invalid_Username");
        LoginPage pglogin = new LoginPage(driver);
		
		//Step1 Login to the website
        HomePage pgHomePage = pglogin.intelyEDLogin(TestcaseName.get(1), TestcaseName.get(2));
		try {
			
			Assert.assertEquals(pglogin.getConfirmationMessage(), "Username/Password is invalid");
			reporting("Login Validation", "User should not able to login with username ", TestcaseName.get(1) + " ", "Pass");
			
		}catch(Throwable e) {
			reporting("Login Validation", "User should log in", "Login Failed with user" + TestcaseName.get(1), "Fail");
			throw new AssertionError("Login Validation failure error message", e);
		}
	
		
}}
