package pages;

import javax.xml.crypto.dsig.keyinfo.PGPData;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;
import utils.TestUtil;

public class HomePage extends PageBase  {
	
	@FindBy(xpath ="//body/div[@id='root']/div/div/div/div/div/div/div/ul/div[3]")
    private WebElement lnkMySchool;
	

	@FindBy(xpath ="//body/div[@id='root']/div/div/div/div/div/div/div/ul/div/div/div/div/div[1]")
    private WebElement lnkAchievement;
	
	@FindBy(xpath ="//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeStart']")
    private WebElement btnSettings;
	

	
	public  HomePage(WebDriver driver) {
		setWebDriver(driver);
	}
	
	public void clickOnlnkMySchool() throws Throwable {
		lnkMySchool.click();
		smallwaitDriver();
	}
	
	public PLCTeamSetupPage clickOnbtnSettings() {
		waitForElementToAppear(btnSettings);
		btnSettings.click();
		//jsExecutorClickOn(lnkSettings);
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

