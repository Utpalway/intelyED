package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;
import utils.TestUtil;

public class PLCTeamSetupPage extends PageBase {
	
	@FindBy(xpath ="//*[name()='path' and contains(@d,'M19.14 12.')]")
	private WebElement btnSetting;
	
	@FindBy(xpath ="//input[@type='text']")
	private WebElement txtPLCTeamName;
	
	@FindBy(xpath ="//body//div//div//div//main//div//div//div//div//div//div//div//div//div//div//div//div[@role='button']")
	private WebElement liContentArea;

	@FindBy(xpath ="//label[3]")
	private WebElement btnradioSETDAYS;
	
	@FindBy(xpath ="//div[@class='MuiInputBase-root MuiInput-root MuiInput-underline Mui-focused Mui-focused MuiInputBase-formControl MuiInput-formControl']//input[@id='time']")
	private WebElement btnAlarmclock;
	
	@FindBy(xpath ="//input[@value='0']")
	private WebElement txtTEAMNORMS;
	
	@FindBy(xpath ="//body/div/div/div/main/div/div/div/div/div/div/div/div/div/div/button[@type='button']/span[2]")
	private WebElement btnNEXT;
	
	@FindBy(xpath ="//form[1]//div[1]//div[1]//input[1]")
	private WebElement txtStartMeetingTime;
	
	@FindBy(xpath ="//form[2]//div[1]//div[1]//input[1]")
	private WebElement txtEndMeetingTime;
	
	public PLCTeamSetupPage(WebDriver driver) {
		setWebDriver(driver);
	}

	

	public void clickOnbtnSetting() throws Throwable {
		waitForElementToClickable(btnSetting);
		btnSetting.click();
	}

	
	public void entertxtPLCTeamName(String PLCTeamName) throws Throwable {
		waitForElementToClickable(txtPLCTeamName);
		txtPLCTeamName.sendKeys(PLCTeamName);
		txtPLCTeamName.sendKeys(Keys.TAB);
	}
	
	public void selectTeam(String strContentArea) {
		waitForElementToAppear(liContentArea);	
		TestUtil.selectItemByVisibleText(liContentArea, strContentArea);
	}
	
	public void clickandSelectContentArea(String strContentArea) throws Throwable {
		waitForElementToAppear(liContentArea);	
		liContentArea.click();
		smallwaitDriver();
		String xPathforTeam = "//li[normalize-space()='" + strContentArea + "']";
		try {
			
			pbDriver.findElement(By.xpath(xPathforTeam)).click();
		}catch(NoSuchElementException e) {
			System.out.println(e.getLocalizedMessage());	
		}
	}
	
	public void clickOnbtnradioSETDAYS() throws Throwable {
		waitForElementToClickable(btnradioSETDAYS);
		btnradioSETDAYS.click();
	}
	
	public void clickOnbtnAlarmclock() throws Throwable {
		waitForElementToClickable(btnAlarmclock);
		btnAlarmclock.click();
	}

	public void entertxtTEAMNORMS(String TEAMNORMS) throws Throwable {
		waitForElementToClickable(txtTEAMNORMS);
		txtTEAMNORMS.sendKeys(TEAMNORMS);
		txtTEAMNORMS.sendKeys(Keys.TAB);
	}
	
	public void clickOnbtnNEXT() throws Throwable {
		waitForElementToClickable(btnNEXT);
		btnNEXT.click();
	}
	// PLC Team Set Up
	
		public void createPLCTeamSetUp(String pPLCTeamName,String pstrContentArea, String pTEAMNORMS ) throws Throwable {
			waitDriver();
			
			entertxtPLCTeamName(pPLCTeamName);
			smallwaitDriver();
			clickandSelectContentArea(pstrContentArea);
			smallwaitDriver();
			clickOnbtnradioSETDAYS();
			smallwaitDriver();
			entertxtTEAMNORMS(pTEAMNORMS);
			
			clickOnbtnNEXT();
		}
		
		//23-06-2021
		public void entertxtStartMeetingTime(String strStartMeetingTime) throws Throwable {
			waitForElementToClickable(txtStartMeetingTime);
			txtStartMeetingTime.sendKeys(strStartMeetingTime);
			txtStartMeetingTime.sendKeys(Keys.TAB);
		}
		
		public void entertxtEndMeetingTime(String strEndMeetingTime) throws Throwable {
			waitForElementToClickable(txtEndMeetingTime);
			txtEndMeetingTime.sendKeys(strEndMeetingTime);
			txtEndMeetingTime.sendKeys(Keys.TAB);
		}
		

}
