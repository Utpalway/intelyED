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
import pages.PLCTeamSetupPage;
import utils.ExcelDataDrivenTest;


public class TC011_PLC_Record_Achivements extends TestBase {

	@Test
	public void TC011_PLC_Teams() throws Throwable {
		
		ArrayList<String> TestcaseName;
		ExcelDataDrivenTest d = new ExcelDataDrivenTest();
		TestcaseName =d.getData("TC011_PLC_Record_Achivements");
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
		//Step 2    Click on settings
		PLCTeamSetupPage pgPLCTeamSetupPage =  pgHomePage.clickOnbtnSettings();
		//Step 3	"Content Area from the dropbox."
		pgPLCTeamSetupPage.clickandSelectContentArea("Maths");
		//Step 4	"Checked the SET DAYS.	// Click on any of the radiobuttons."
		pgPLCTeamSetupPage.clickOnbtnradioSETDAYS();
		//Step 5	"Click on the Meeting Start Time "
		pgPLCTeamSetupPage.entertxtStartMeetingTime("17:52");
		//Step 6	"Click on the Meeting End 	Time"
		pgPLCTeamSetupPage.entertxtEndMeetingTime("18:52");
		//Step 7	Enter the TEAM NORMS fix error
		pgPLCTeamSetupPage.entertxtTEAMNORMS("Team norms");
		//Step 8	"Click on NEXT button.		"	//Next Page	
		pgPLCTeamSetupPage.clickOnbtnNEXT();
		//Step 9	Search Members
		//Step 10	"ALL MEMBERS		Select the members from checklist"
		//Step 11	Click on the Arrow keys
		//Step 12	"Click on NEXT button.		"
		//Step 13	"Update/change the 		PLC TEAM ROLES from the 		dropdown."
		//Step 14	"Click on Finish button.		"

		
		//Thread.sleep(2000);

				

	}	
		
}
