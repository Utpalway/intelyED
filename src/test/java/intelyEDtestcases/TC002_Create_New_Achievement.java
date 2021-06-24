package intelyEDtestcases;


import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;
import pages.AchievementPage;
import pages.DashboardPage;
import pages.HomePage;
import pages.IntelyChargePage;
import pages.LoginPage;
import utils.ExcelDataDrivenTest;


public class TC002_Create_New_Achievement extends TestBase {

	@Test
	public void TC002_Create_New_Achievement() throws Throwable {
		
		ArrayList<String> TestcaseName;
		ExcelDataDrivenTest d = new ExcelDataDrivenTest();
		TestcaseName =d.getData("TC002_Create_New_Achievement");
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
		
		//Step 2 Click on Achievement link
		try {
			pgHomePage.clickOnlnkMySchool();
			AchievementPage pgAchievementPage = pgHomePage.clickOnlnkAchievement();
			//Step 3 Create Achievement
			pgAchievementPage.addAchievement(TestcaseName.get(3), TestcaseName.get(4), TestcaseName.get(5), TestcaseName.get(6));
			reporting("Create Achivement", "User should able to create achivement", "user sucessfully created achivement with team " + TestcaseName.get(3), "Fail");
		}catch(Throwable e) {
			reporting("Create Achivement", "User should able to create achivement", "user failed to create achivement with team " + TestcaseName.get(3), "Fail");
			throw new AssertionError("Login Validation failure error message", e);
		}
	
		
		
		Thread.sleep(2000);

				

	}	
		
}
