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


public class TC010_Create_New_Achievement_WithoutValues extends TestBase {

	@Test
	public void TC010_Create_New_Achievement() throws Throwable {
		
		ArrayList<String> TestcaseName;
		ExcelDataDrivenTest d = new ExcelDataDrivenTest();
		TestcaseName =d.getData("TC010_Create_New_Achievement_WithoutValues");
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
		pgHomePage.clickOnlnkMySchool();
		AchievementPage pgAchievementPage = pgHomePage.clickOnlnkAchievement();
		try {
			
			//Step 3 Create Achievement
			pgAchievementPage.addAchievementWithoutInputValues();
			System.out.println(pgAchievementPage.getTextforTeamField());
			System.out.println(pgAchievementPage.getTextforDateField());
			System.out.println(pgAchievementPage.getTextforTitleField());
			System.out.println(pgAchievementPage.getTextforDescField());
			pgAchievementPage.clickOnbtnCancel();
			reporting("Create Achivement", "User should able to create achivement", "user sucessfully created achivement with team ", "Fail");
		}catch(Throwable e) {
			reporting("Create Achivement", "User should able to create achivement", "user failed to create achivement with team ", "Fail");
			throw new AssertionError("Login Validation failure error message", e);
		}
		
		//Asserting Date 
		
		try {
			Assert.assertEquals(pgAchievementPage.getTextforDateField(), "*");
			//Assert.assertNotEquals(pglogin.getConfirmationMessage(), "Username/Password is invalid");
			reporting("Date Validation", "User should not able to see the * sign if no value entered ", "Actusl value" + pgAchievementPage.getTextforDateField(), "Pass");
			
		}catch(Throwable e) {
			reporting("Date Validation", "User should not able to see the * sign if no value entered ", "Actusl value" + pgAchievementPage.getTextforDateField(), "Fail");
			throw new AssertionError("Date Validation failure error message", e);
		}
	
		
		
		Thread.sleep(5000);

				

	}	
		
}
