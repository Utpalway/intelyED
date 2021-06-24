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


public class TC004_Failed_Login_Functionalities_Invalid_Password extends TestBase {

	@Test
	public void TC004_Login_With_Invalid_Password() throws Throwable {
		
		ArrayList<String> TestcaseName;
		ExcelDataDrivenTest d = new ExcelDataDrivenTest();
		TestcaseName =d.getData("TC004_Login_With_Invalid_Password");
        LoginPage pglogin = new LoginPage(driver);
		
		//Step1 Login to the website
        HomePage pgHomePage = pglogin.intelyEDLogin(TestcaseName.get(1), TestcaseName.get(2));
		try {
			Assert.assertEquals(pglogin.getConfirmationMessage(), "Username/Password is invalid");
			//Assert.assertNotEquals(pglogin.getConfirmationMessage(), "Username/Password is invalid");
			reporting("Login Validation", "User should not able to login with username ", TestcaseName.get(1) + " ", "Pass");
			
		}catch(Throwable e) {
			reporting("Login Validation", "User should log in", "Login Failed with user" + TestcaseName.get(1), "Fail");
			throw new AssertionError("Login Validation failure error message", e);
		}
	
		
}}
