package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageBase;
import utils.TestUtil;

public class DashboardPage extends PageBase {

	



	public DashboardPage(WebDriver driver) {
		setWebDriver(driver);
	}

	@FindBy(xpath ="//body/div[@id='root']/div/div/div/div/div/div/div/ul/div[3]")
    private WebElement lnkMySchool;
	

	@FindBy(xpath ="//body/div[@id='root']/div/div/div/div/div/div/div/ul/div/div/div/div/div[1]")
    private WebElement lnkAchievement;
	
	//@FindBy(xpath ="//*[name()='path' and contains(@d,'M19.14 12.')]")
	@FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > header:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2) > span:nth-child(1) > svg:nth-child(1) > path:nth-child(1)")
    private WebElement lnkSettings;
	


	
	public void clickOnlnkMySchool() throws Throwable {
		lnkMySchool.click();
		smallwaitDriver();
	}
	
	public PLCTeamSetupPage clickOnlnkSettings() {
		waitForElementToAppear(lnkSettings);		
		jsExecutorClickOn(lnkSettings);
		//lnkSettings.sendKeys(Keys.ENTER);
		waitForPageLoaded();
		return new PLCTeamSetupPage(pbDriver);
		
	}
	
	public AchievementPage clickOnlnkAchievement() {
		waitForElementToAppear(lnkAchievement);
		lnkAchievement.click();
		waitForPageLoaded();
		return new AchievementPage(pbDriver);
		
	}



}
